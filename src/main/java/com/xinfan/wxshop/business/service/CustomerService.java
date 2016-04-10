package com.xinfan.wxshop.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.constants.OrderStateEnum;
import com.xinfan.wxshop.business.constants.SequenceConstants;
import com.xinfan.wxshop.business.dao.CartDao;
import com.xinfan.wxshop.business.dao.CustomerDao;
import com.xinfan.wxshop.business.dao.DistributionDao;
import com.xinfan.wxshop.business.dao.GoodsDao;
import com.xinfan.wxshop.business.dao.OrderDao;
import com.xinfan.wxshop.business.dao.OrderDetailDao;
import com.xinfan.wxshop.business.dao.SequenceDao;
import com.xinfan.wxshop.business.dao.TransferDao;
import com.xinfan.wxshop.business.dao.WalletDao;
import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.entity.Order;
import com.xinfan.wxshop.business.entity.OrderDetail;
import com.xinfan.wxshop.business.entity.Transfer;
import com.xinfan.wxshop.business.entity.Wallet;
import com.xinfan.wxshop.business.pay.weixin.WxNotifyUtils;
import com.xinfan.wxshop.business.util.QueryParamterUtils;
import com.xinfan.wxshop.business.vo.OrderBean;
import com.xinfan.wxshop.common.base.BizException;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;
import com.xinfan.wxshop.common.security.Md5PwdEncoder;

public class CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private CartDao cartDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private WalletDao walletDao;

	@Autowired
	private DistributionDao distributionDao;

	@Autowired
	private SequenceDao sequenceDao;
	
	@Autowired
	private TransferDao transferDao;

	public Customer login(String account, String password, Map attributes) {

		if (account == null) {
			return null;
		}

		account = account.trim().toLowerCase();
		Customer customer = customerDao.selectByAccount(account);

		if (customer == null) {
			throw new BizException(100, "用户不存在");
		}
		
		if (customer.getState() != 1) {
			throw new BizException(102, "帐户状态异常");
		}

		Md5PwdEncoder encoder = new Md5PwdEncoder();

		boolean bool = encoder.isPasswordValid(customer.getPwd(), password);
		if (!bool) {
			throw new BizException(101, "密码不正确");
		}

		return customer;
	}

	public void regist(String account, String password, String displayName,
			DataMap attributes) {

		account = account.trim();

		String sex = attributes.getString("sex");
		if (sex == null || sex.trim().length() == 0) {
			sex = "1";
		}
		
		String share_id = attributes.getString("share_id");
		Customer shareCustomer = null;
		if (share_id == null || share_id.length() == 0) {
			share_id = "0";
		} else {
			shareCustomer = customerDao.selectByPrimaryKey(Integer.parseInt(share_id));
		}
		
		String wxId = attributes.getString("wx_id");

		Customer exist = customerDao.selectByAccount(account);
		if (exist != null) {
			throw new BizException("用户名已存在");
		}

		int customerId = this.sequenceDao
				.getSequence(SequenceConstants.SEQ_CUSTOMER);

		Customer bean = new Customer();
		bean.setAccount(account.trim());
		bean.setPwd(new Md5PwdEncoder().encodePassword(password));
		bean.setDisplayname(displayName);
		bean.setRegdate(new Date());
		bean.setSex(Integer.parseInt(sex));
		bean.setCustomerId(customerId);
		bean.setWxId(wxId);
		bean.setUplineId(Integer.parseInt(share_id));

		this.customerDao.insertSelective(bean);

		Wallet wallet = new Wallet();
		wallet.setBalance(0f);
		wallet.setCustomerId(bean.getCustomerId());
		wallet.setDistrBalance(0f);
		wallet.setDistrCount(0);

		this.walletDao.insertSelective(wallet);
		
		if (shareCustomer != null) {
			if(shareCustomer.getWxId()!=null && shareCustomer.getWxId().length()>1){
				WxNotifyUtils.customerDownlineJoinNotify(shareCustomer.getWxId(), shareCustomer.getDisplayname(), "2");
			}
		}

	}

	public Customer getByAccount(String account) {
		Customer bean = customerDao.selectByAccount(account.trim());
		return bean;
	}
	
	public Customer getByWeixinId(String account) {
		Customer bean = customerDao.selectByWxId(account.trim());
		return bean;
	}

	public Customer getById(int id) {
		Customer bean = customerDao.selectByPrimaryKey(id);
		return bean;
	}

	public Wallet getWalletByCustomerId(int id) {
		Wallet bean = walletDao.selectByCustomerIdKey(id);
		return bean;
	}
	
	
	public void updateWalletBalance(int id,float balance,String orderNo,String openId,String clientIp){
		Wallet wallet = this.walletDao.selectByCustomerIdKey(id);
		wallet.setBalance(wallet.getBalance()-balance);
		this.walletDao.updateByPrimaryKeySelective(wallet);
		
		try{
			Transfer transfer = new Transfer();
			int transferId = this.sequenceDao.getSequence(SequenceConstants.SEQ_TRANSFER);
			transfer.setTransferId(transferId);
			transfer.setAmount(balance);
			transfer.setCheckState(1);
			transfer.setOrderNo(orderNo);
			transfer.setCustomerId(id);
			transfer.setTransferDate(new Date());
			transfer.setWalletId(wallet.getWalletId());
			transfer.setWxOpenid(openId);
			transfer.setClientIp(clientIp);
			transferDao.insertSelective(transfer);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		
	}

	public List<Order> getCustomerTopOrderList(int id) {
		return orderDao.selectTopListByExample(id, 5);
	}

	public Pagination getCustomerCenterOrderPageList(int customerId,String type,
			Pagination page) {

		List<OrderBean> list = new ArrayList<OrderBean>();
		
		Map param = new HashMap();
		param.put("customerId", customerId);
		if("1".equals(type)){
		
		}
		else if("2".equals(type)){
			param.put("status", OrderStateEnum.UNPAY.getIndex());
		}
		else if("3".equals(type)){
			param.put("status", OrderStateEnum.PAYED.getIndex());
		}
		else if("4".equals(type)){
			param.put("status", OrderStateEnum.SHIPPED.getIndex());
		}
		else if("5".equals(type)){
			param.put("status", OrderStateEnum.COMMENT.getIndex());
		}		
		

		page = orderDao.getCustomerCenterOrderPageList(param, page);

		for (Order order : (List<Order>) page.getList()) {

			OrderBean bean = new OrderBean();
			bean.setOrder(order);
			List<Map> gList = new ArrayList<Map>();

			List<OrderDetail> detailList = orderDetailDao.selectByOrderId(order
					.getOrderId());
			for (OrderDetail detail : detailList) {
				Goods goods = this.goodsDao.selectByPrimaryKey(detail
						.getGoodsId());
				Map form = new HashMap();
				form.put("goods", goods);
				form.put("detail", detail);
				gList.add(form);
			}
			
			bean.setForm(gList);
			list.add(bean);
		}

		page.setList(list);

		return page;
	}

	public List<DataMap> getCustomerTopDistributionList(int id) {

		return distributionDao.selectTopListByExample(id, 5);
	}

	public void deleteCustomer(int id) {

		Customer customer = customerDao.selectByPrimaryKey(id);
		if (customer != null) {
			this.customerDao.deleteByPrimaryKey(id);
		}
	}

	public void updateCustomerState(int id, int state) {

		Customer customer = customerDao.selectByPrimaryKey(id);
		if (customer != null) {

			Customer update = new Customer();
			update.setCustomerId(id);
			update.setState(state);
			this.customerDao.updateByPrimaryKeySelective(update);
		}
	}

	public void updateCustomerPassword(int id, String newOrgiPassword) {

		Customer customer = customerDao.selectByPrimaryKey(id);
		if (customer != null) {
			Customer update = new Customer();
			update.setCustomerId(id);
			update.setPwd(new Md5PwdEncoder().encodePassword(newOrgiPassword));
			this.customerDao.updateByPrimaryKeySelective(update);
		}
	}

	public void updateCustomerForgetPassword(String account,
			String newOrgiPassword) {

		Customer customer = customerDao.selectByAccount(account);
		if (customer == null) {
			throw new BizException("用户不存在");
		}

		if (customer != null) {
			Customer update = new Customer();
			update.setCustomerId(customer.getCustomerId());
			update.setPwd(new Md5PwdEncoder().encodePassword(newOrgiPassword));
			this.customerDao.updateByPrimaryKeySelective(update);
		}
	}

	public void updateResetCustomerPassword(Integer customerId,
			String newOrgiPassword, String oldOrgiPassword) {

		Customer customer = customerDao.selectByPrimaryKey(customerId);
		if (customer == null) {
			throw new BizException("用户不存在");
		}

		String encPwd = customer.getPwd();
		String newEncPwd = new Md5PwdEncoder().encodePassword(newOrgiPassword);
		String oldEncPwd = new Md5PwdEncoder().encodePassword(oldOrgiPassword);

		if (!encPwd.equals(oldEncPwd)) {
			throw new BizException("原始密码错误");
		}

		Customer update = new Customer();
		update.setCustomerId(customer.getCustomerId());
		update.setPwd(newEncPwd);
		this.customerDao.updateByPrimaryKeySelective(update);

	}

	public Pagination pageSelectCustomerList(DataMap map, Pagination page) {

		QueryParamterUtils.addQueryTime(map, "startdate", "endate");

		List list = this.customerDao.pageSelectCustomerList(map, page);
		page.setList(list);

		return page;
	}
	
	public Pagination pageSelectLayerCustomerList(DataMap map, Pagination page) {

		QueryParamterUtils.addQueryTime(map, "startdate", "endate");

		List list = this.customerDao.pageSelectLayerCustomerList(map, page);
		page.setList(list);

		return page;
	}
	
	public List<Customer> listCustomerLayerUser(int customerId,int level) {
		DataMap param = new DataMap();
		param.put("customerId", customerId);
		param.put("level", level);
		
		List<Customer> list = customerDao.getListCustomerLayerUser(param);
		return list;
	}
	

}
