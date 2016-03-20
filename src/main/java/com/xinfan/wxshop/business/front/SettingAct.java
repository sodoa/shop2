package com.xinfan.wxshop.business.front;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.common.base.BizException;
import com.xinfan.wxshop.common.sms.SmsService;

@Controller
public class SettingAct {
	
	private static final Logger logger = LoggerFactory.getLogger(SettingAct.class);

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

	@RequestMapping(method = RequestMethod.GET, value = "/center/setting.html")
	public ModelAndView setting(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/setting");

		return mv;
	}

	@RequestMapping("/center/about.html")
	public ModelAndView about(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/about");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/center/setpassword.html")
	public ModelAndView setpassword(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/setpassword");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/center/setpassword.html")
	public @ResponseBody
	JSONResult saveSetpassword(HttpServletRequest request) {
		String orgiPassword = request.getParameter("orgi_password");
		String password = request.getParameter("password");

		JSONResult result = null;

		try {
			Integer customerId = LoginSessionUtils
					.getCustomerIdFromUserSessionMap();
			CustomerService.updateResetCustomerPassword(customerId, password,
					orgiPassword);
			result = JSONResult.success();
			
			LoginSessionUtils.setExpireCustomerSessionMap();

		} catch (BizException e) {
			logger.error(e.getMessage(),e);
			result = JSONResult.error(e.getMessage());
		} finally {
		}

		return result;
	}

}
