package com.xinfan.wxshop.business.pay.weixin;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.xinfan.wxshop.business.util.ThreadUtils;
import com.xinfan.wxshop.business.util.WeiXinSessionManager;
import com.xinfan.wxshop.common.util.JSONUtils;

public class WxNotifyUtils {

	public static final String url = "https://api.weixin.qq.com/cgi-bin/message/template/send";

	public static void notify(String openid) {

		ThreadUtils.run(new Thread() {

			@Override
			public void run() {
				Map json = new HashMap();
				json.put("", "");

				String tokenUrl = url + "?access_token=" + WeiXinSessionManager.getAccessToken();
				JSONObject jsonResult = CommonUtil.httpsRequest(url, "POST", JSONUtils.toJSONString(json));
			}
		});

	}

}
