package com.xinfan.wxshop.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.dao.SearchWordsDao;
import com.xinfan.wxshop.business.entity.SearchWords;
import com.xinfan.wxshop.common.cache.CacheHelper;

public class SearchWordsService {

	@Autowired
	private SearchWordsDao SearchWordsDao;

	public void deleteByKey(String key) {
		SearchWordsDao.deleteByKey(key);
		CacheHelper.getInstance().refresh(BizConstants.CACHE_KEY_SEARCHWORDS_CACHE);
	}

	public void insertSelective(SearchWords record) {
		record.setSort(1);

		SearchWordsDao.insertSelective(record);

		CacheHelper.getInstance().refresh(BizConstants.CACHE_KEY_SEARCHWORDS_CACHE);
	}

	public List<SearchWords> selectAll() {
		return SearchWordsDao.selectAll();
	}

}
