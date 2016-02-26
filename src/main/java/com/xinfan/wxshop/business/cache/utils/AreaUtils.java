package com.xinfan.wxshop.business.cache.utils;

import java.util.Map;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.entity.Area;
import com.xinfan.wxshop.common.cache.CacheHolder;

public class AreaUtils {

	public static Area getArea(String code) {

		Map cache = (Map) CacheHolder.getInstance()
				.getCacheProvider(BizConstants.PROVIDER_COMMON_CACHE)
				.getAttribute(BizConstants.CACHE_KEY_AREACACHE_CACHE);

		Map<String, Area> beanMap = (Map) cache
				.get(BizConstants.CACHE_BEAN_KEY);

		return beanMap.get(code);
	}

	public static String getFullAreaName(String code) {

		Map cache = (Map) CacheHolder.getInstance()
				.getCacheProvider(BizConstants.PROVIDER_COMMON_CACHE)
				.getAttribute(BizConstants.CACHE_KEY_AREACACHE_CACHE);

		Map<String, Area> beanMap = (Map) cache
				.get(BizConstants.CACHE_BEAN_KEY);
		
		Area area = beanMap.get(code);
		StringBuffer buffer= new StringBuffer();
		if(area.getLevel() == 0){
			buffer.append(area.getName());
		}
		else if(area.getLevel()==1){
			String topAreaCode = area.getCode().substring(0, 3);
			Area topArea = beanMap.get(topAreaCode);
			buffer.append(topArea.getName()).append(area.getName());
		}
		else if(area.getLevel() == 2){
			String topAreaCode = area.getCode().substring(0, 3);
			Area topArea = beanMap.get(topAreaCode);
			
			String subAreaCode = area.getCode().substring(3, 6);
			Area subArea = beanMap.get(subAreaCode);
			
			buffer.append(topArea.getName()).append(subArea.getName()).append(area.getName());
		}
		
		return buffer.toString();

	}

}
