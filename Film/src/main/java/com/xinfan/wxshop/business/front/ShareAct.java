package com.xinfan.wxshop.business.front;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.business.util.WeiXinSessionManager;
import com.xinfan.wxshop.business.util.WeiXinShareSign;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.config.FileConfig;
import com.xinfan.wxshop.common.util.JSONUtils;

@Controller
public class ShareAct {

	private final Logger logger = LoggerFactory.getLogger(ShareAct.class);

	@RequestMapping("/share_sign.html")
	public @ResponseBody
	JSONResult shareSign(HttpServletRequest request,
			HttpServletResponse response) {

		String appid = FileConfig.getInstance().getString("weixin.appid");

		String ticket_token = WeiXinSessionManager.getTicketToken();

		if (ticket_token != null) {

			String url = request.getParameter("url");
			
			logger.debug("share_sign sign url : " + url);
			
			//url = URLEncoder.encode(url);

			Map<String, String> ret = WeiXinShareSign.sign(ticket_token, url);
			logger.debug("share_sign sign data : " + JSONUtils.toJSONString(ret));
			
			
			DataMap sessionMap = LoginSessionUtils.getCustomerUserSessionMap();
			if (sessionMap != null) {
				Integer customerId = sessionMap.getInt("customerId");
				if (customerId != null) {
					ret.put("wxsid", String.valueOf(customerId));
				}
			}

			ret.put("appId", appid);

			return JSONResult.success().putValues(ret);

		} else {
			logger.error("ticket_token is null");
			return JSONResult.error("ticket_token is null");
		}

	}

}
