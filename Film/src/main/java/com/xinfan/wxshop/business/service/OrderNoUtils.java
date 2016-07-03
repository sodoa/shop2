package com.xinfan.wxshop.business.service;

import java.util.Date;
import java.util.Random;

import org.apache.http.impl.cookie.DateUtils;

public class OrderNoUtils {

	public static String getOrderNo(Integer orderId) {
		String orderNo = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss") + orderId;

		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			orderNo += r.nextInt(9);
		}
		return orderNo;
	}

}
