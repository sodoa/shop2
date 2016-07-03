package com.xinfan.wxshop.business.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.cache.utils.ParamterUtils;
import com.xinfan.wxshop.business.constants.SequenceConstants;
import com.xinfan.wxshop.business.dao.CustomerDao;
import com.xinfan.wxshop.business.dao.DistributionDao;
import com.xinfan.wxshop.business.dao.SequenceDao;
import com.xinfan.wxshop.business.dao.WalletDao;
import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.business.entity.Distribution;
import com.xinfan.wxshop.business.entity.Wallet;
import com.xinfan.wxshop.business.pay.weixin.WxNotifyUtils;
import com.xinfan.wxshop.common.base.BizException;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;
import com.xinfan.wxshop.common.sms.SmsService;
import com.xinfan.wxshop.common.util.TimeUtils;

public class DistributionService {

	protected final Logger logger = LoggerFactory.getLogger(DistributionService.class);

	@Autowired
	private DistributionDao distributionDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private WalletDao walletDao;

	@Autowired
	private SmsService smsService;

	public Pagination pageSelectDistributionList(DataMap map, Pagination page) {

		List list = distributionDao.pageSelectDistributionList(map, page);

		page.setList(list);

		return page;

	}

	public Pagination pageNearCustomerDistributionList(int customerId, Pagination page) {

		Date current = TimeUtils.getCurrentTime();
		current = DateUtils.addMonths(current, -5);

		List list = distributionDao.pageBeanSelectDistributionList(customerId, current, page);
		page.setList(list);
		return page;
	}

	public Pagination pageNearCustomerVirtualDistributionList(int customerId, Pagination page) {

		List list = distributionDao.pageBeanSelectVirtualDistributionList(customerId, "1", page);
		page.setList(list);
		return page;
	}

	public void addCustomerVirtualDistribution(int customerId, float amount, String chargeName) {
		
		if(amount > 200){
			throw new BizException("金额不能超过200");
		}

		int orderId = 0;
		String orderNo = OrderNoUtils.getOrderNo(orderId);

		try {
			Customer currentCustomer = customerDao.selectByPrimaryKey(customerId);
			if (currentCustomer != null) {
				Integer uplineId = currentCustomer.getUplineId();
				if (uplineId != null && uplineId != 0) {
					Customer level1Customer = customerDao.selectByPrimaryKey(uplineId);
					if (level1Customer != null) {

						float distribution_rate = Float.parseFloat(ParamterUtils.getString("distribution.level1.rate", "0.01"));
						float income = (float) Math.floor(amount * distribution_rate * 100) / 100;

						int distributionId = this.sequenceDao.getSequence(SequenceConstants.SEQ_DISTRIBUTION);

						if (income >= 0.1) {

							Distribution distribution = new Distribution();
							distribution.setCharge(amount);
							distribution.setRate(distribution_rate);
							distribution.setChargeName(orderNo);
							distribution.setConsumeDate(TimeUtils.getCurrentTime());
							distribution.setDistributionId(distributionId);
							distribution.setDownlineId(currentCustomer.getCustomerId());
							distribution.setUplineId(level1Customer.getCustomerId());
							distribution.setDownlineName(currentCustomer.getAccount());
							distribution.setIncome(income);
							distribution.setOrderId(orderId);
							distribution.setResult(1);
							distribution.setLevel(2);
							distribution.setVirtual("1");
							distributionDao.insertSelective(distribution);

							if (level1Customer.getWxId() != null && level1Customer.getWxId().length() > 1) {

								Wallet wallet = this.walletDao.selectByCustomerIdKey(level1Customer.getCustomerId());

								if (wallet != null) {
									float totalMoney = wallet.getBalance() + income;
									Wallet update = new Wallet();
									update.setWalletId(wallet.getWalletId());
									update.setBalance(totalMoney);
									walletDao.updateByPrimaryKeySelective(update);
									WxNotifyUtils.customerPointsJoinNotify(level1Customer.getWxId(), level1Customer.getDisplayname(), String.valueOf(income),
											String.valueOf(totalMoney), "2");
								}
							}

							try {

								if (level1Customer.getUplineId() != null) {
									Customer level2Customer = customerDao.selectByPrimaryKey(level1Customer.getUplineId());
									if (level2Customer.getUplineId() != null && level2Customer.getUplineId() != 0) {
										float distribution_rate2 = Float.parseFloat(ParamterUtils.getString("distribution.level2.rate", "0.01"));
										float income2 = (float) Math.floor(amount * distribution_rate2 * 10) / 10;

										if (income2 >= 0.1) {
											int distributionId2 = this.sequenceDao.getSequence(SequenceConstants.SEQ_DISTRIBUTION);

											Distribution distribution2 = new Distribution();
											distribution2.setCharge(amount);
											distribution2.setRate(distribution_rate2);
											distribution2.setChargeName(orderNo);
											distribution2.setConsumeDate(TimeUtils.getCurrentTime());
											distribution2.setDistributionId(distributionId2);
											distribution2.setDownlineId(currentCustomer.getCustomerId());
											distribution2.setUplineId(level2Customer.getCustomerId());
											distribution2.setDownlineName(currentCustomer.getAccount());
											distribution2.setIncome(income2);
											distribution2.setOrderId(orderId);
											distribution2.setResult(1);
											distribution2.setLevel(3);
											distribution2.setVirtual("1");
											distributionDao.insertSelective(distribution2);

											if (level2Customer.getWxId() != null && level2Customer.getWxId().length() > 1) {

												Wallet wallet = this.walletDao.selectByCustomerIdKey(level2Customer.getCustomerId());
												if (wallet != null) {
													float totalMoney = wallet.getBalance() + income2;
													Wallet update = new Wallet();
													update.setWalletId(wallet.getWalletId());
													update.setBalance(totalMoney);
													walletDao.updateByPrimaryKeySelective(update);
													WxNotifyUtils.customerPointsJoinNotify(level2Customer.getWxId(), level2Customer.getDisplayname(),
															String.valueOf(income2), String.valueOf(totalMoney), "3");
												}
											}
										}
									}
								}
							} catch (Exception e) {
								logger.error(e.getMessage(), e);
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
			message.append("价格：").append(amount).append(",");
			message.append("定单号：").append(orderNo).append(",");
			message.append("客户号：").append(customerId + "");

			smsService.sendOderPaySms(mobile, message.toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
