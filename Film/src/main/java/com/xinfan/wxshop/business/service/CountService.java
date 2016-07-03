package com.xinfan.wxshop.business.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.dao.CustomerDao;
import com.xinfan.wxshop.business.dao.DistributionDao;
import com.xinfan.wxshop.business.dao.OrderDao;
import com.xinfan.wxshop.business.vo.CountVo;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.cache.CacheHolder;
import com.xinfan.wxshop.common.cache.CacheProvider;

public class CountService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private DistributionDao distributionDao;

	public CountVo getCountBean() {
		CacheProvider provider = CacheHolder.getInstance().getCacheProvider(
				"exp_cache");

		CountVo count = (CountVo) provider.getAttribute("main_count");
		if (count == null) {
			count = new CountVo();
			DataMap cMap = new DataMap();
			int cCount = customerDao.count(cMap);
			int oCount = orderDao.count(cMap);
			int dCount = distributionDao.count(cMap);

			count.setRegistCount(cCount);
			count.setSellCount(oCount);
			count.setShareCount(dCount);

			provider.setAttribute("main_count", count, 24 * 60);
		}

		return count;

	}
}
