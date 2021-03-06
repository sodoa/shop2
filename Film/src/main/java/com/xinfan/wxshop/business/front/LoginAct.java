package com.xinfan.wxshop.business.front;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.common.base.BizException;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.sms.SmsService;
import com.xinfan.wxshop.common.util.CookieUtils;

@Controller
public class LoginAct {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginAct.class);

	@Autowired
	private GoodsService GoodsService;

	@Autowired
	private CartService CartService;

	@Autowired
	private OrderService OrderService;

	@Autowired
	private CustomerService CustomerService;

	@Autowired
	private SmsService SmsService;

	@RequestMapping(method = RequestMethod.GET, value = "/login.html")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/login");
		String p = request.getParameter("p");

		if (p == null || p.length() == 0 || "null".equals(p)) {
			Object sessionp = request.getSession(true).getAttribute(BizConstants.SESSION_REDIRECT_VAR_KEY);
			if (sessionp != null) {
				p = (String) sessionp;
			}
		}

		mv.addObject("p", p);
		
		
		
		Cookie cookie_account = CookieUtils.getCookie(request, "cookie_account");
		Cookie cookie_password = CookieUtils.getCookie(request, "cookie_password");
		if (cookie_account != null && cookie_password != null) {
			try {
				Map attributes = new HashMap();
				Customer customer = CustomerService.login(cookie_account.getValue(), cookie_password.getValue(), attributes);

				DataMap sessionMap = new DataMap();
				sessionMap.put("account", customer.getAccount());
				sessionMap.put("displayname", customer.getDisplayname());
				sessionMap.put("customerid", customer.getCustomerId());
				LoginSessionUtils.setCustomerUserSessionMap(sessionMap);
				
				if(p!=null && p.length()>0&&!"null".equals(p)){
					return new ModelAndView("redirect:"+p);
				}
				
				return new ModelAndView("redirect:/center/my_center.html");

			} catch (BizException e) {
				logger.error(e.getMessage(),e);
			}
		}
		
		return mv;
	}

	@RequestMapping("/my.html")
	public ModelAndView my(HttpServletRequest request) {

		DataMap sessionMap = LoginSessionUtils.getCustomerUserSessionMap();
		if (sessionMap != null) {
			ModelAndView mv = null;
			String p = request.getParameter("p");
			if (p != null && p.trim().length() > 0 && p.contains(".html")) {
				mv = new ModelAndView("redirect:" + p);
			} else {
				mv = new ModelAndView("redirect:/center/my_center.html");
			}

			return mv;
		} else {
			ModelAndView mv = new ModelAndView("/front/login");
			return mv;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login.html")
	public @ResponseBody
	JSONResult login(HttpServletRequest request,HttpServletResponse response) {

		String account = request.getParameter("account");
		String password = request.getParameter("password");

		JSONResult result = null;

		Map attributes = new HashMap();

		try {
			Customer customer = CustomerService.login(account, password, attributes);

			DataMap sessionMap = new DataMap();
			sessionMap.put("account", customer.getAccount());
			sessionMap.put("displayname", customer.getDisplayname());
			sessionMap.put("customerid", customer.getCustomerId());

			LoginSessionUtils.setCustomerUserSessionMap(sessionMap);
			CookieUtils.addCookie(request, response, "cookie_account", account, 24*60*60*30, null);
			CookieUtils.addCookie(request, response, "cookie_password", password, 24*60*60*30, null);

			result = JSONResult.success();
		} catch (BizException e) {
			logger.error(e.getMessage(),e);
			result = JSONResult.error("用户名密码错误");
		}

		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/logout.html")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("redirect:/login.html");
		LoginSessionUtils.setExpireCustomerSessionMap();
		
		CookieUtils.cancleCookie(request, response, "cookie_account", null);
		CookieUtils.cancleCookie(request, response, "cookie_password", null);
		
		return mv;
	}

	@RequestMapping("/userstate.html")
	public @ResponseBody
	JSONResult userstate(HttpServletRequest request) {
		JSONResult result = null;

		DataMap sessionMap = LoginSessionUtils.getCustomerUserSessionMap();
		if (sessionMap == null) {
			result = JSONResult.error("未登录");
		} else {
			result = JSONResult.success();
		}

		return result;
	}

}
