package com.xinfan.wxshop.business.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.dao.DistributionDao;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;
import com.xinfan.wxshop.common.util.TimeUtils;

public class DistributionService {

	@Autowired
	private DistributionDao distributionDao;

	public Pagination pageSelectDistributionList(DataMap map, Pagination page) {

		List list = distributionDao.pageSelectDistributionList(map, page);

		page.setList(list);

		return page;

	}

	public Pagination pageNearCustomerDistributionList(int customerId,
			Pagination page) {

		Date current = TimeUtils.getCurrentTime();
		current = DateUtils.addMonths(current, -5);

		List list = distributionDao.pageBeanSelectDistributionList(customerId,
				current, page);
		page.setList(list);
		return page;

	}

}
