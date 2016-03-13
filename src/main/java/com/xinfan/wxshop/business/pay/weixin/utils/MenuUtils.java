package com.xinfan.wxshop.business.pay.weixin.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.fastjson.JSONObject;
import com.xinfan.wxshop.business.util.WeiXinSessionManager;

public class MenuUtils {

	private static final Logger logger = LoggerFactory.getLogger(MenuUtils.class);

	private static String create_url = "https://api.weixin.qq.com/cgi-bin/menu/create";// ?access_token=ACCESS_TOKEN

	private static String delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete";// ?access_token=ACCESS_TOKEN

	public static String createMenu() {

		ClassPathResource loader = new ClassPathResource("/config/weixin_menu.json");
		String msg = null;

		try {
			String menuJson = FileUtils.readFileToString(loader.getFile());
			logger.info("weixin menu json : " + menuJson);

			String accessToken = WeiXinSessionManager.getAccessToken();

			StringBuffer bufferUrl = new StringBuffer(create_url);
			bufferUrl.append("?").append("access_token=").append(accessToken);
			JSONObject result = CommonUtil.httpsRequest(create_url, "post", menuJson);

			if (result != null) {
				logger.debug(result.toString());
				String errcode = result.getString("errcode");
				String errmsg = result.getString("errmsg");

				msg = errmsg;
			}

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			msg = e.getMessage();
		}

		return msg;
	}

	public static String deleteMenu() {
		String msg = null;

		String accessToken = WeiXinSessionManager.getAccessToken();

		StringBuffer bufferUrl = new StringBuffer(delete_url);
		bufferUrl.append("?").append("access_token=").append(accessToken);

		JSONObject result = CommonUtil.httpsRequest(delete_url, "post", "");

		if (result != null) {
			logger.debug(result.toString());
			String errmsg = result.getString("errmsg");
			msg = errmsg;
		}

		return msg;

	}

	public static String getSubscribeContent() {

		ClassPathResource loader = new ClassPathResource("/config/weixin_subscribe.json");
		String msg = null;

		try {
			String menuJson = FileUtils.readFileToString(loader.getFile());
			logger.info("weixin menu json : " + menuJson);
			msg = menuJson;

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			msg = e.getMessage();
		}

		return msg;
	}
}
