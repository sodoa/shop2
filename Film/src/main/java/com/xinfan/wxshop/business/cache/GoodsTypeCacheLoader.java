package com.xinfan.wxshop.business.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.dao.GoodsTypeDao;
import com.xinfan.wxshop.business.entity.GoodsType;
import com.xinfan.wxshop.common.cache.CacheHolder;
import com.xinfan.wxshop.common.cache.CacheLoader;
import com.xinfan.wxshop.common.context.AppContextHolder;

/**
 * 
 * 閰嶇疆鍙傛暟鍔犺浇鍣�
 * 
 * @author cyp
 * 
 */
public class GoodsTypeCacheLoader extends CacheLoader {

	@Override
	public boolean load() {

		HashMap maps = new HashMap();

		HashMap keyMap = new HashMap();
		GoodsTypeDao ConfigDao = AppContextHolder.getBean(GoodsTypeDao.class);

		List<GoodsType> list = (ArrayList) ConfigDao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			GoodsType config = list.get(i);
			String key = config.getGoodstype();
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
