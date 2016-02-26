package com.xinfan.wxshop.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.dao.CustomerDao;
import com.xinfan.wxshop.business.dao.GoodsDao;
import com.xinfan.wxshop.business.dao.LoveDao;
import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.entity.Love;
import com.xinfan.wxshop.common.page.Pagination;

public class LoveService {

	@Autowired
	private LoveDao loveDao;

	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private CustomerDao customerDao;

	public LoveDao getLoveDao() {
		return loveDao;
	}

	public void setLoveDao(LoveDao loveDao) {
		this.loveDao = loveDao;
	}

	public boolean delete(int id) {
		return loveDao.deleteByPrimaryKey(id) == 1;
	}

	public Pagination list(int customerId, Pagination page) {
		List list = loveDao.pageList(customerId, page);
		page.setList(list);
		return page;
	}

	public boolean add(Love pojo) {

		Goods goods = goodsDao.selectByPrimaryKey(pojo.getGoodsId());

		if (goods != null) {

			Love love = loveDao.selectByBizKey(pojo.getGoodsId(),
					pojo.getCustomerId());
			
			Customer customer = customerDao.selectByPrimaryKey(pojo.getCustomerId());
			
			if (love != null) {

				pojo.setGoodsName(goods.getGoodsLname());
				pojo.setCreatedate(new Date());

				this.loveDao.insertSelective(pojo);
			}

			return true;
		}

		return false;

	}

}
