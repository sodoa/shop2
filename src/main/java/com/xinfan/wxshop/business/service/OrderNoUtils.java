package com.xinfan.wxshop.business.service;

import java.util.Date;

import org.apache.http.impl.cookie.DateUtils;

public class OrderNoUtils {

	public static String getOrderNo(Integer orderId) {
		String orderNo = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss") + orderId;
		return orderNo;
	}

}
