package com.xinfan.wxshop.business.pay.hongbao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinfan.wxshop.common.config.FileConfig;


public class MoneyUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(MoneyUtils.class);
	
	private static String appid = " ";// 应用ID
	private static String appsecret = " ";// 应用密钥
	private static String partner = "";// 微信支付商户号
	private static String partnerkey = " ";// 财付通初始密�?
	private static String charset = "UTF-8";
	
	static {
		partnerkey = FileConfig.getInstance().getString("weixin.appsecret");
		appid = FileConfig.getInstance().getString("weixin.appid");
		appsecret = partnerkey;
		partner =  FileConfig.getInstance().getString("weixin.mch_id");
	}

	/**
	 * 随机16为数值
	 * 
	 * @return
	 */
	public static String buildRandom() {
		String currTime = TenpayUtil.getCurrTime();
		String strTime = currTime.substring(8, currTime.length());
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < 4; i++) {
			num = num * 10;
		}
		return (int) ((random * num)) + strTime;
	}

	/**
	 * 获取ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("PRoxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (null == ip) {
			ip = "";
		}
		if (StringUtils.isNotEmpty(ip)) {
			String[] ipArr = ip.split(",");
			if (ipArr.length > 1) {
				ip = ipArr[0];
			}
		}
		return ip;
	}

	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。 sign
	 */
	public static String createSign(Map<String, Object> map) {
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		for (Map.Entry<String, Object> m : map.entrySet()) {
			packageParams.put(m.getKey(), m.getValue().toString());
		}

		StringBuffer sb = new StringBuffer();
		Set<?> es = packageParams.entrySet();
		Iterator<?> it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (!StringUtils.isEmpty(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + partnerkey);
		
		logger.debug("createSign data : " + sb.toString());
		 
		
		String sign = MD5Util.MD5Encode(sb.toString(), charset).toUpperCase();
		return sign;
	}

	public static String getOrderNo() {
		String order = partner
				+ new SimpleDateFormat("yyyyMMdd").format(new Date());
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			order += r.nextInt(9);
		}
		return order;
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(getOrderNo()); }
	 */

	
	public static String createXML(Map<String, Object> map){
		String xml = "<xml>";
		Set<String> set = map.keySet();
		Iterator<String> i = set.iterator();
		while(i.hasNext()){
			String str = i.next();
			xml+="<"+str+">"+"<![CDATA["+map.get(str)+"]]>"+"</"+str+">";
			//xml+="<"+str+">"+map.get(str)+"</"+str+">";
		}
		xml+="</xml>";
		return xml;
	}
}
