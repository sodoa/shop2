package com.xinfan.wxshop.business.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.dao.AreaDao;
import com.xinfan.wxshop.business.entity.Area;
import com.xinfan.wxshop.common.cache.CacheHolder;
import com.xinfan.wxshop.common.cache.CacheLoader;
import com.xinfan.wxshop.common.context.AppContextHolder;

/**
 * 
 * @author cyp
 * 
 */
public class AreaCacheLoader extends CacheLoader {

	@Override
	public boolean load() {

		HashMap maps = new HashMap();

		HashMap keyMap = new HashMap();
		AreaDao dao = AppContextHolder.getBean(AreaDao.class);

		List<Area> list = (ArrayList) dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			Area config = list.get(i);
			String key = config.getCode();
			keyMap.put(key.toUpperCase(), config);
		}

		maps.put(BizConstants.CACHE_BEAN_KEY, keyMap);
		maps.put(BizConstants.CACHE_BEAN_LIST, list);

		CacheHolder.getInstance()
				.getCacheProvider(BizConstants.PROVIDER_COMMON_CACHE)
				.setAttribute(this.getCacheKey(), maps, -1);

		return true;
	}

	@Override
	public boolean refresh() {
		return load();
	}

}
