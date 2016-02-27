package com.xinfan.wxshop.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.dao.SearchWordsDao;
import com.xinfan.wxshop.business.entity.SearchWords;

public class SearchWordsService {

	@Autowired
	private SearchWordsDao SearchWordsDao;

	public int deleteByKey(String key) {
		return SearchWordsDao.deleteByKey(key);
	}

	public int insertSelective(SearchWords record) {
		record.setSort(1);
		return SearchWordsDao.insertSelective(record);
	}

	public List<SearchWords> selectAll() {
		return SearchWordsDao.selectAll();
	}

}
