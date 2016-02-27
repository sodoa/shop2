package com.xinfan.wxshop.business.cache;

import java.util.ArrayList;
import java.util.HashMap;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.dao.SearchWordsDao;
import com.xinfan.wxshop.business.entity.SearchWords;
import com.xinfan.wxshop.common.cache.CacheHolder;
import com.xinfan.wxshop.common.cache.CacheLoader;
import com.xinfan.wxshop.common.context.AppContextHolder;

public class SearchWordsCacheLoader extends CacheLoader {

	@Override
	public boolean load() {

		HashMap maps = new HashMap();
		SearchWordsDao dao = AppContextHolder.getBean(SearchWordsDao.class);

		ArrayList<SearchWords> list = (ArrayList) dao.selectAll();
		CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_COMMON_CACHE).setAttribute(this.getCacheKey(), list, -1);

		return true;
	}

	@Override
	public boolean refresh() {
		return load();
	}

}
