package com.xinfan.wxshop.business.service;

import java.util.Date;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.entity.GoodsLimit;
import com.xinfan.wxshop.common.util.TimeUtils;

public class GoodsHelper {

	public static String canBuyGoods(GoodsLimit goodslimit){
		
		Date current = TimeUtils.getCurrentTime();
		boolean timeout = !current.before(goodslimit.getTimeLimit());
		
		boolean canBuy = false;
		
		if(goodslimit.getLimitType()==BizConstants.GOODS_TIME_LIMIT_TYPE_BY_COUNT){
			canBuy = !(goodslimit.getSellAmount()>=goodslimit.getTotalAmount() || timeout);
			
			if(!canBuy){
				return "已经超过购买时间或是没有存货了";
			}
		}
		else if(goodslimit.getLimitType()==BizConstants.GOODS_TIME_LIMIT_TYPE_BY_TIME){
			canBuy = !(timeout);
			if(!canBuy){
				return "已经超过购买时间";
			}
		}
		return null;
	}
	
}
