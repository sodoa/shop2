package com.xinfan.wxshop.business.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinfan.wxshop.business.entity.GoodsType;
import com.xinfan.wxshop.common.util.JSONUtils;

public class GoodsTypeUtils {
	
	public static String toTree(List<GoodsType> list){
		
		List<Map> listMap = new ArrayList<Map>();
		
		for(GoodsType item : list){
			Map node = new HashMap();
			node.put("id", item.getGoodstype());
			node.put("pId", item.getpGoodstype());
			node.put("name", item.getGoodstypeName());
			listMap.add(node);
		}
		
		return JSONUtils.toJSONString(listMap);
	}
}
