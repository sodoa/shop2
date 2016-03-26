package com.xinfan.wxshop.business.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xinfan.wxshop.common.util.CookieUtils;

public class ShareInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(ShareInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// wx share id
		String wxsid = request.getParameter("wxsid");
		if (wxsid != null && wxsid.length() > 0) {
			CookieUtils.addCookie(request, response, "wxsid", wxsid, 24 * 60 * 60, null);
		}

		return true;

	}

}
