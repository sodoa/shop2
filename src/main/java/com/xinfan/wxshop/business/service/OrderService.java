package com.xinfan.wxshop.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.cache.utils.ParamterUtils;
import com.xinfan.wxshop.business.constants.OrderStateEnum;
import com.xinfan.wxshop.business.constants.SequenceConstants;
import com.xinfan.wxshop.business.dao.AppraiseDao;
import com.xinfan.wxshop.business.dao.CustomerDao;
import com.xinfan.wxshop.business.dao.DeliveryAddressDao;
import com.xinfan.wxshop.business.dao.DistributionDao;
import com.xinfan.wxshop.business.dao.GoodsDao;
import com.xinfan.wxshop.business.dao.OrderDao;
import com.xinfan.wxshop.business.dao.OrderDetailDao;
import com.xinfan.wxshop.business.dao.SequenceDao;
import com.xinfan.wxshop.business.dao.WalletDao;
import com.xinfan.wxshop.business.entity.Appraise;
import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.business.entity.DeliveryAddress;
import com.xinfan.wxshop.business.entity.Distribution;
import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.entity.Order;
import com.xinfan.wxshop.business.entity.OrderDetail;
import com.xinfan.wxshop.business.entity.Wallet;
import com.xinfan.wxshop.business.pay.weixin.WxNotifyUtils;
import com.xinfan.wxshop.business.vo.MakeOrderTable;
import com.xinfan.wxshop.business.vo.OrderBean;
import com.xinfan.wxshop.business.vo.PurchaseGoodsVo;
import com.xinfan.wxshop.business.vo.PurchaseOrderVo;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;
import com.xinfan.wxshop.common.sms.SmsService;
import com.xinfan.wxshop.common.util.TimeUtils;

public class OrderService {

	protected final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private AppraiseDao appraiseDao;

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private DistributionDao distributionDao;

	@Autowired
	private DeliveryAddressDao deliveryAddressDao;

	@Autowired
	private WalletDao walletDao;

	@Autowired
	private SmsService smsService;

	public Pagination pageSelectOrderList(DataMap paramter, Pagination page) {
		List list = orderDao.pageOrderList(paramter, page);
		page.setList(list);

		return page;
	}

	public List<PurchaseOrderVo> getPurchaseOrderList(Date end, int status) {
		List<PurchaseOrderVo> purchaseList = new ArrayList<PurchaseOrderVo>();

		List<Order> list = orderDao.selectUnPurchaseOrderList(end, status);
		for (Order order : list) {
			List<OrderDetail> detail = orderDetailDao.selectByOrderId(order.getOrderId());
			if (!detail.isEmpty()) {
				PurchaseOrderVo item = new PurchaseOrderVo(order, detail);
				purchaseList.add(item);
			}
		}
		return purchaseList;
	}

	public Order getPayOrderInfo(int customerId, int orderId) {

		Order order = orderDao.selectByPrimaryKey(orderId);

		return order;
	}

	public Order getPayOrderWithOrderNo(String orderNo) {

		List<Order> order = orderDao.selectByBizKey(orderNo);

		if (order == null || order.size() > 1) {
			return null;
		}

		return order.get(0);
	}

	public void updateOrderIsPayed(String orderNo) {

		Order order = getPayOrderWithOrderNo(orderNo);
		if (order == null) {
			throw new RuntimeException("order is null");
		}

		if (order.getStatus() != OrderStateEnum.UNPAY.getIndex()) {
			throw new RuntimeException("order state is leggel");
		}

		// 更新订单状态
		Order updateOrder = new Order();
		updateOrder.setOrderId(order.getOrderId());
		updateOrder.setStatus(OrderStateEnum.PAYED.getIndex());

		orderDao.updateByPrimaryKeySelective(updateOrder);

		// 更新商品数量

		try {
			List<OrderDetail> details = orderDetailDao.selectByOrderId(order.getOrderId());
			for (OrderDetail detail : details) {

				Goods updateGoodsSellerCount = new Goods();
				updateGoodsSellerCount.setGoodsId(detail.getGoodsId());
				updateGoodsSellerCount.setSellcount(detail.getQuantity());
				goodsDao.updateGoodsSellCountByPrimaryKey(updateGoodsSellerCount);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		try {
			Customer level1Customer = customerDao.selectByPrimaryKey(order.getCustomerId());
			if (level1Customer != null) {
				Integer uplineId = level1Customer.getUplineId();
				if (uplineId != null && uplineId != 0) {

					float distribution_rate = Float.parseFloat(ParamterUtils.getString("distribution.level1.rate", "0.01"));
					float income = (float) Math.floor(order.getTotalAmount() * distribution_rate * 100) / 100;

					// income = 1;

					int distributionId = this.sequenceDao.getSequence(SequenceConstants.SEQ_DISTRIBUTION);

					if (income >= 0.1) {

						Distribution distribution = new Distribution();
						distribution.setCharge(order.getTotalAmount());
						distribution.setRate(distribution_rate);
						distribution.setChargeName(order.getOrderNo());
						distribution.setConsumeDate(TimeUtils.getCurrentTime());
						distribution.setDistributionId(distributionId);
						distribution.setDownlineId(order.getCustomerId());
						distribution.setUplineId(uplineId);
						distribution.setDownlineName(level1Customer.getAccount());
						distribution.setIncome(income);
						distribution.setOrderId(order.getOrderId());
						distribution.setResult(1);
						distribution.setLevel(2);
						distributionDao.insertSelective(distribution);

						if (level1Customer.getWxId() != null && level1Customer.getWxId().length() > 1) {

							Wallet wallet = this.walletDao.selectByCustomerIdKey(level1Customer.getCustomerId());
							String totalMoney = "";
							if (wallet != null) {
								totalMoney = String.valueOf(wallet.getBalance());
							}
							WxNotifyUtils.customerPointsJoinNotify(level1Customer.getWxId(), level1Customer.getDisplayname(), String.valueOf(income),
									totalMoney, "2");
						}

						if (level1Customer.getUplineId() != null) {
							Customer level2Customer = customerDao.selectByPrimaryKey(level1Customer.getUplineId());
							if (level2Customer.getUplineId() != null && level2Customer.getUplineId() != 0) {
								float distribution_rate2 = Float.parseFloat(ParamterUtils.getString("distribution.level2.rate", "0.01"));
								float income2 = (float) Math.floor(order.getTotalAmount() * distribution_rate * 10) / 10;

								if (income2 >= 0.1) {
									int distributionId2 = this.sequenceDao.getSequence(SequenceConstants.SEQ_DISTRIBUTION);

									Distribution distribution2 = new Distribution();
									distribution2.setCharge(order.getTotalAmount());
									distribution2.setRate(distribution_rate2);
									distribution2.setChargeName(order.getOrderNo());
									distribution2.setConsumeDate(TimeUtils.getCurrentTime());
									distribution2.setDistributionId(distributionId2);
									distribution2.setDownlineId(level2Customer.getCustomerId());
									distribution2.setUplineId(level2Customer.getCustomerId());
									distribution2.setDownlineName(level2Customer.getAccount());
									distribution2.setIncome(income2);
									distribution2.setOrderId(order.getOrderId());
									distribution2.setResult(1);
									distribution2.setLevel(3);
									distributionDao.insertSelective(distribution2);

									if (level2Customer.getWxId() != null && level2Customer.getWxId().length() > 1) {

										Wallet wallet = this.walletDao.selectByCustomerIdKey(level2Customer.getCustomerId());
										String totalMoney = "";
										if (wallet != null) {
											totalMoney = String.valueOf(wallet.getBalance());
										}
										WxNotifyUtils.customerPointsJoinNotify(level2Customer.getWxId(), level2Customer.getDisplayname(),
												String.valueOf(income2), totalMoney, "3");
									}

								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		try {
			String mobile = ParamterUtils.getString("order_tip_mobile", "18673119686");

			StringBuilder message = new StringBuilder();
			message.append("价格：").append(order.getTotalAmount()).append(",");
			message.append("定单号：").append(order.getOrderNo()).append(",");
			message.append("客户号：").append(order.getCustomerId()).append("");

			smsService.sendOderPaySms(mobile, message.toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public void updateOrderIsConfirmed(int orderId) {

		Order order = new Order();
		order.setOrderId(orderId);
		order.setShared(1);

		orderDao.updateByPrimaryKeySelective(order);
	}

	public void updateOrderCommented(int orderId, int customerId, String comment) {

		Order order = this.orderDao.selectByPrimaryKey(orderId);
		if (order == null) {
			throw new RuntimeException("order is null");
		}

		if (order.getCustomerId() != customerId) {
			throw new RuntimeException("error access");
		}

		if (order.getStatus() != OrderStateEnum.SHIPPED.getIndex()) {
			throw new RuntimeException("error order state");
		}

		Order updateOrder = new Order();
		updateOrder.setOrderId(order.getOrderId());
		updateOrder.setStatus(OrderStateEnum.COMMENT.getIndex());

		orderDao.updateByPrimaryKeySelective(updateOrder);

		Customer customer = this.customerDao.selectByPrimaryKey(customerId);
		if (customer != null) {

			int aid = this.sequenceDao.getSequence(SequenceConstants.SEQ_APPRAISE);
			Appraise pojo = new Appraise();
			pojo.setContext(comment);
			pojo.setAppraiseId(aid);
			pojo.setCreatedate(new Date());
			pojo.setCustomerId(customerId);
			pojo.setCustomerName(customer.getDisplayname());
			pojo.setOrderId(orderId);
			appraiseDao.insertSelective(pojo);
		}

	}

	public List<OrderDetail> getOrderDetail(int customerId, int orderId) {
		return orderDetailDao.selectByOrderId(orderId);
	}

	public MakeOrderTable payOrder(int orderId, int customerId, String mark, int paymentMode, int addressId) {

		Order order = orderDao.selectByPrimaryKey(orderId);
		if (order.getCustomerId() != customerId) {
			throw new RuntimeException("error access");
		}

		DeliveryAddress address = this.deliveryAddressDao.selectByPrimaryKey(addressId);

		String orderNo = OrderNoUtils.getOrderNo(orderId);

		order.setReceiverAddress(address.getAddress());
		order.setReceiverName(address.getReceiverName());
		order.setReceiverPhone(address.getReceiverPhone());
		order.setPaymentMode(paymentMode);
		order.setMark(mark);
		order.setOrderNo(orderNo);

		this.orderDao.updateByPrimaryKeySelective(order);

		MakeOrderTable table = new MakeOrderTable();
		table.setFee(order.getTotalAmount());
		table.setOrderId(orderId);
		table.setOrderNo(order.getOrderNo());

		return table;
	}

	// 出货
	public void processOrder(int orderId) {

		Order order = orderDao.selectByPrimaryKey(orderId);
		order.setStatus(2);

		orderDao.updateByPrimaryKeySelective(order);
	}

	public void deleteOrder(int orderId, int customerId) {

		Order order = orderDao.selectByPrimaryKey(orderId);
		if (order != null) {
			if (customerId != order.getCustomerId()) {
				throw new RuntimeException("非法访问");
			}

			List<OrderDetail> list = this.orderDetailDao.selectByOrderId(orderId);

			for (OrderDetail detail : list) {
				this.orderDetailDao.deleteByPrimaryKey(detail.getDetailId());
			}

			this.orderDao.deleteByPrimaryKey(orderId);
		}

	}

	public List<DataMap> getTopMyOrderList(int customerId) {

		Pagination page = new Pagination();
		page.setPageNo(1);
		page.setPageSize(10);

		DataMap map = new DataMap();
		map.put("customerId", customerId);

		List<DataMap> list = orderDao.pageList(map, page);

		return list;
	}

	public int getUnPayOrderCount(int customerId) {
		return orderDao.getUnPayOrderCount(customerId, OrderStateEnum.UNPAY.getIndex());
	}

	public OrderBean getOrderDetailInfo(int orderId, int customerId) {

		OrderBean bean = new OrderBean();

		Order order = this.orderDao.selectByPrimaryKey(orderId);

		bean.setOrder(order);
		List<Map> gList = new ArrayList<Map>();

		List<OrderDetail> detailList = orderDetailDao.selectByOrderId(order.getOrderId());
		for (OrderDetail detail : detailList) {
			Goods goods = goodsDao.selectByPrimaryKey(detail.getGoodsId());
			Map form = new HashMap();
			form.put("goods", goods);
			form.put("detail", detail);
			gList.add(form);
		}

		bean.setForm(gList);

		return bean;
	}

	public List<PurchaseGoodsVo> getOrderGoodsStaticSummary(Date end) {
		DataMap param = new DataMap();
		param.put("order_date", end);
		List<DataMap> list = orderDao.getOrderGoodsStaticSummary(param);

		List<PurchaseGoodsVo> purchaseList = new ArrayList<PurchaseGoodsVo>();
		for (DataMap item : list) {
			int gid = item.getInt("gid");
			int cnt = item.getInt("cnt");
			String weight = item.getString("weight");

			PurchaseGoodsVo pGood = new PurchaseGoodsVo();
			pGood.setCount(cnt);
			pGood.setGoodsId(gid);
			pGood.setWeight(weight);

			Goods goods = this.goodsDao.selectByPrimaryKey(gid);
			if (goods != null) {
				pGood.setGoodsName(goods.getGoodsName());
				pGood.setUnit(goods.getUnit());
			}

			purchaseList.add(pGood);
		}
		return purchaseList;
	}

}
