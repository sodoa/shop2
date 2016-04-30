package com.xinfan.wxshop.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.constants.SequenceConstants;
import com.xinfan.wxshop.business.dao.CartDao;
import com.xinfan.wxshop.business.dao.CustomerDao;
import com.xinfan.wxshop.business.dao.DeliveryAddressDao;
import com.xinfan.wxshop.business.dao.GoodsDao;
import com.xinfan.wxshop.business.dao.GoodsLimitDao;
import com.xinfan.wxshop.business.dao.OrderDao;
import com.xinfan.wxshop.business.dao.OrderDetailDao;
import com.xinfan.wxshop.business.dao.SequenceDao;
import com.xinfan.wxshop.business.entity.Cart;
import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.business.entity.DeliveryAddress;
import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.entity.GoodsLimit;
import com.xinfan.wxshop.business.entity.Order;
import com.xinfan.wxshop.business.entity.OrderDetail;
import com.xinfan.wxshop.business.util.ConfigUtils;
import com.xinfan.wxshop.business.vo.CartInfoVo;
import com.xinfan.wxshop.business.vo.MakeOrderTable;
import com.xinfan.wxshop.common.base.BizException;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;
import com.xinfan.wxshop.common.util.TimeUtils;

public class CartService {

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private CartDao cartDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private GoodsLimitDao goodsLimitDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private DeliveryAddressDao deliveryAddressDao;

	@Autowired
	private SequenceDao SequenceDao;

	public List<DataMap> getShoppingCartList(int customerId) {
		Pagination page = new Pagination();

		page.setPageNo(1);
		page.setPageSize(6);

		DataMap map = new DataMap();

		List<DataMap> list = cartDao.pageList(map, page);

		return list;
	}

	public Cart getCart(int cartId) {
		Cart cart = cartDao.selectByPrimaryKey(cartId);
		return cart;
	}

	public CartInfoVo getCartInfo(int customerId) {
		List<Cart> cartList = cartDao.selectCartListByCustomerId(customerId);
		List<Goods> goodsList = new ArrayList<Goods>();
		CartInfoVo info = new CartInfoVo();

		float totalAmount = 0f;
		float saveAmount = 0f;
		float orginAmount = 0f;

		for (Cart cart : cartList) {

			Goods goods = this.goodsDao.selectByPrimaryKey(cart.getGoodsId());
			goodsList.add(goods);

			totalAmount += (cart.getQuantity() * goods.getFinalPrices());
			orginAmount += (cart.getQuantity() * goods.getOrginPrices());

		}

		saveAmount = (orginAmount - totalAmount);
		if (saveAmount <= 0) {
			saveAmount = 0;
		}

		info.setCarts(cartList);
		info.setGoods(goodsList);
		info.setTotalAmount(totalAmount);
		info.setOrginAmount(orginAmount);
		info.setSaveAmount(saveAmount);
		info.setHasGoods(!cartList.isEmpty());

		return info;
	}

	public CartInfoVo getCartInfoBySessionId(String sessionId) {
		List<Cart> cartList = cartDao.selectCartListBySessionId(sessionId);
		List<Goods> goodsList = new ArrayList<Goods>();
		CartInfoVo info = new CartInfoVo();

		float totalAmount = 0f;
		float saveAmount = 0f;
		float orginAmount = 0f;

		for (Cart cart : cartList) {

			Goods goods = this.goodsDao.selectByPrimaryKey(cart.getGoodsId());
			goodsList.add(goods);

			totalAmount += (cart.getQuantity() * goods.getFinalPrices());
			orginAmount += (cart.getQuantity() * goods.getOrginPrices());
		}

		saveAmount = (orginAmount - totalAmount);
		if (saveAmount <= 0) {
			saveAmount = 0;
		}
		
		float postage = Float.parseFloat(ConfigUtils.getValue("goods.postage", "10"));
		float postageMoney = Float.parseFloat(ConfigUtils.getValue("goods.postage.money", "49"));
		
		if (totalAmount >= postageMoney) {
			info.setHasPostage(false);
		}else{
			totalAmount = totalAmount + postage;
			info.setHasPostage(true);
		}

		info.setCarts(cartList);
		info.setGoods(goodsList);
		info.setTotalAmount(totalAmount);
		info.setOrginAmount(orginAmount);
		info.setSaveAmount(saveAmount);
		info.setHasGoods(!cartList.isEmpty());

		return info;
	}

	public int getCartNumBySessionId(String sessionId) {
		return cartDao.selectCartNumBySessionId(sessionId);
	}

	public void updateGoodsNumberInCart(int cartId, int number) {

		Cart cart = cartDao.selectByPrimaryKey(cartId);
		if (cart != null) {
			int curretnQuantity = cart.getQuantity() + number;
			if (curretnQuantity <= 1) {
				curretnQuantity = 1;
			}
			cart.setQuantity(curretnQuantity);

			this.cartDao.updateByPrimaryKeySelective(cart);
		}
	}

	public void addGoodInCart(String sessionId, int goodsId,int num) {

		List<Cart> list = cartDao.selectCartListBySessionIdIdAndGoodsId(sessionId, goodsId);

		Goods goods = this.goodsDao.selectByPrimaryKey(goodsId);

		if (goods.getThemeType() != null && goods.getThemeType().equals(BizConstants.GOODS_THEME_TYPE_LIMIT)) {
			GoodsLimit goodsLimit = goodsLimitDao.selectByPrimaryKey(goodsId);
			String msg = GoodsHelper.canBuyGoods(goodsLimit);
			if (msg != null) {
				throw new BizException(msg);
			}
		}

		if (list.isEmpty()) {
			Cart cart = new Cart();
			cart.setCustomerId(0);
			cart.setSessionid(sessionId);
			cart.setQuantity(num);
			cart.setGoodsId(goodsId);
			cart.setCreatetime(TimeUtils.getCurrentTime());
			cartDao.insertSelective(cart);
		}

	}

	public void deleteGoodInCard(int cartId) {
		cartDao.deleteByPrimaryKey(cartId);
	}

	public void deleteAllGoodInCard(int customerId, String sessionId) {
		if (customerId > 0) {
			cartDao.deleteCartListByCustomerId(customerId);
		}
		cartDao.deleteCartListBySessionId(sessionId);
	}

	public MakeOrderTable makeOrder(int customerId, String sessionId, int deliveryId, String mark, int paymentMode) {
		List<Cart> cartList = cartDao.selectCartListBySessionId(sessionId);
		MakeOrderTable table = new MakeOrderTable();

		Customer customer = this.customerDao.selectByPrimaryKey(customerId);
		if (customer == null) {
			throw new BizException("用户帐号不存在");
		}

		if (!cartList.isEmpty()) {

			DeliveryAddress address = deliveryAddressDao.selectByPrimaryKey(deliveryId);

			Order order = new Order();
			List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

			float totalAmount = 0f;
			int totalQuantity = 0;

			for (Cart cart : cartList) {
				Goods goods = goodsDao.selectByPrimaryKey(cart.getGoodsId());

				OrderDetail detail = new OrderDetail();
				detail.setGoodsId(goods.getGoodsId());
				detail.setQuantity(cart.getQuantity());
				detail.setOrginPrice(goods.getOrginPrices());
				detail.setFinalPrice(goods.getFinalPrices());
				detail.setGoodsName(goods.getGoodsName());
				detail.setWeight(goods.getWeight());
				detail.setUnit(goods.getUnit());
				orderDetailList.add(detail);

				totalQuantity += detail.getQuantity();

				totalAmount += (goods.getFinalPrices() * detail.getQuantity());

				table.setGoodsId(goods.getGoodsId());
				table.setGoodsName(goods.getGoodsName());
			}

			int orderId = SequenceDao.getSequence(SequenceConstants.SEQ_ORDER);

			String orderNo = OrderNoUtils.getOrderNo(orderId);
			boolean hasPostage = false;
			
			float postage = Float.parseFloat(ConfigUtils.getValue("goods.postage", "10"));
			float postageMoney = Float.parseFloat(ConfigUtils.getValue("goods.postage.money", "49"));
			
			if (totalAmount <= postageMoney) {
				totalAmount = totalAmount + postage;
				hasPostage = true;
			}
			
			order.setPostage(hasPostage ? new Float(postage).intValue() : 0);
			order.setOrderId(orderId);
			order.setOrderNo(orderNo);
			order.setCustomerId(customerId);
			order.setDeliveryId(deliveryId);
			order.setMark(mark);
			order.setShared(0);
			order.setTotalQuantity(totalQuantity);
			order.setTotalAmount(totalAmount);
			order.setStatus(BizConstants.ORDER_STATUS_UNPAY);
			order.setPaymentMode(paymentMode);
			order.setDisStatus(BizConstants.ORDER_DISTRIBUTION_READY);
			order.setReceiverName(address.getReceiverName());
			order.setReceiverAddress(address.getAddress());
			order.setReceiverPhone(address.getReceiverPhone());
			order.setOrderDate(new Date());

			table.setFee(totalAmount);
			table.setOrderNo(orderNo);
			table.setOrderId(orderId);

			this.orderDao.insertSelective(order);
			for (OrderDetail orderDetail : orderDetailList) {
				int detailId = this.SequenceDao.getSequence(SequenceConstants.SEQ_ORDER_DETAIL);
				orderDetail.setOrderId(order.getOrderId());
				orderDetail.setDetailId(detailId);
				this.orderDetailDao.insertSelective(orderDetail);
			}

			// this.cartDao.deleteCartListByCustomerId(customerId);
			this.cartDao.deleteCartListBySessionId(sessionId);

			return table;
		}

		return null;
	}


}
