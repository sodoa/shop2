package com.xinfan.wxshop.business.cache.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.entity.GoodsType;
import com.xinfan.wxshop.common.cache.CacheHolder;

public class GoodsTypeUtils {

	public static List<GoodsType> getGoodsTypeList(String root) {

		Map cache = (Map) CacheHolder.getInstance()
				.getCacheProvider(BizConstants.PROVIDER_COMMON_CACHE)
				.getAttribute(BizConstants.CACHE_KEY_GOODSTYPE_CACHE);

		List<GoodsType> list = (List<GoodsType>) cache
				.get(BizConstants.CACHE_BEAN_LIST);

		return list;
	}
	
	public static List<GoodsType> getTopGoodsType(int level, int top) {

		Map cache = (Map) CacheHolder.getInstance()
				.getCacheProvider(BizConstants.PROVIDER_COMMON_CACHE)
				.getAttribute(BizConstants.CACHE_KEY_GOODSTYPE_CACHE);

		List<GoodsType> list = (List<GoodsType>) cache
				.get(BizConstants.CACHE_BEAN_LIST);

		List<GoodsType> subList = new ArrayList<GoodsType>();
		for (GoodsType item : list) {
			if ("0".equals(item.getpGoodstype())) {
				subList.add(item);
			}
		}

		Collections.sort(subList, new Comparator<GoodsType>() {

			@Override
			public int compare(GoodsType o1, GoodsType o2) {
				return o1.getSort() >= o2.getSort() ? 1 : 0;
			}
		});

		return list.subList(0, top);
	}
	
	public static List<GoodsType> getLevel2GoodsType(String topLevel , int top) {

		Map cache = (Map) CacheHolder.getInstance()
				.getCacheProvider(BizConstants.PROVIDER_COMMON_CACHE)
				.getAttribute(BizConstants.CACHE_KEY_GOODSTYPE_CACHE);

		List<GoodsType> list = (List<GoodsType>) cache
				.get(BizConstants.CACHE_BEAN_LIST);

		List<GoodsType> subList = new ArrayList<GoodsType>();
		for (GoodsType item : list) {
			if (topLevel.equals(item.getpGoodstype())) {
				subList.add(item);
			}
		}

		Collections.sort(subList, new Comparator<GoodsType>() {

			@Override
			public int compare(GoodsType o1, GoodsType o2) {
				return o1.getSort() >= o2.getSort() ? 1 : 0;
			}
		});
		
		if(subList.size()>top){
			return subList.subList(0, top);
		}

		return subList;
	}

	public static GoodsType getGoodsType(String goodsType) {

		Map cache = (Map) CacheHolder.getInstance()
				.getCacheProvider(BizConstants.PROVIDER_COMMON_CACHE)
				.getAttribute(BizConstants.CACHE_KEY_GOODSTYPE_CACHE);

		Map<String, GoodsType> beanMap = (Map) cache
				.get(BizConstants.CACHE_BEAN_KEY);

		return beanMap.get(goodsType);
	}

}
