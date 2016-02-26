package com.xinfan.wxshop.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.dao.AppraiseDao;
import com.xinfan.wxshop.business.dao.CustomerDao;
import com.xinfan.wxshop.business.entity.Appraise;
import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.common.page.Pagination;

public class AppraiseService {

	@Autowired
	private AppraiseDao appraiseDao;

	@Autowired
	private CustomerDao customerDao;

	public boolean add(Appraise pojo) {

		Customer customer = customerDao
				.selectByPrimaryKey(pojo.getCustomerId());
		if (customer != null) {
			pojo.setCustomerName(customer.getDisplayname());
		}

		pojo.setCreatedate(new Date());

		return appraiseDao.insertSelective(pojo) == 1;
	}

	public Appraise get(int id) {

		return appraiseDao.selectByPrimaryKey(id);
	}

	public boolean delete(int appraiseId) {
		return appraiseDao.deleteByPrimaryKey(appraiseId) == 1;
	}

	public Pagination listGoodsAppraise(int goodsId, Pagination page) {

		List list = appraiseDao.pageList(goodsId, page);
		page.setList(list);

		return page;

	}

}
