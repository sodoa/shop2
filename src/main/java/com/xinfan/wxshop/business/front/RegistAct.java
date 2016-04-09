package com.xinfan.wxshop.business.front;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
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
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.business.util.WeixinUtils;
import com.xinfan.wxshop.business.vo.OAuthInfo;
import com.xinfan.wxshop.business.vo.UserInfo;
import com.xinfan.wxshop.common.base.BizException;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.cache.CacheHolder;
import com.xinfan.wxshop.common.config.FileConfig;
import com.xinfan.wxshop.common.security.DesUtils;
import com.xinfan.wxshop.common.sms.SmsService;
import com.xinfan.wxshop.common.util.CookieUtils;

@Controller
public class RegistAct {

	private static final Logger logger = LoggerFactory.getLogger(RegistAct.class);

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

	@RequestMapping(method = RequestMethod.GET, value = "/forget.html")
	public ModelAndView forget() {
		ModelAndView mv = new ModelAndView("/front/forget");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/protocol.html")
	public ModelAndView protocol() {
		ModelAndView mv = new ModelAndView("/front/protocol");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/regist.html")
	public ModelAndView regist1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/front/regist");

		String p = request.getParameter("p");

		if (p == null || p.length() == 0 || "null".equals(p)) {
			Object sessionp = request.getSession(true).getAttribute(BizConstants.SESSION_REDIRECT_VAR_KEY);
			if (sessionp != null) {
				p = (String) sessionp;
			}
		}

		mv.addObject("p", p);

		if (RequestUtils.ifWecatRequest()) {
			try {
				String appid = FileConfig.getInstance().getString("weixin.appid");
				String backUri = FileConfig.getInstance().getString("weixin.regist.backurl");

				// String backUri = "http://***/topayServlet";
				// 授权后要跳转的链接所需的参数一般有会员号，金额，订单号之类，
				// 最好自己带上一个加密字符串将金额加上一个自定义的key用MD5签名或者自己写的签名,
				// 比如 Sign = %3D%2F%CS%

				String body = "p=" + p;

				String desPassword = FileConfig.getInstance().getString("weixin.des.password");

				logger.debug("weixin_pay_auth despassword :" + desPassword);

				String decData;

				decData = Base64.encodeBase64String(DesUtils.encrypt(body.getBytes("UTF-8"), desPassword));

				logger.debug("weixin_pay_auth decData :" + decData);

				backUri = backUri + "?data=" + decData;
				// URLEncoder.encode 后可以在backUri 的url里面获取传递的所有参数
				backUri = URLEncoder.encode(backUri);

				// scope 参数视各自需求而定，这里用scope=snsapi_base
				// 不弹出授权页面直接授权目的只获取统一支付接口的openid
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=" + appid + "&redirect_uri=" + backUri
						+ "&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
				response.sendRedirect(url);
				return null;
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/wecat_regist.html")
	public ModelAndView wecat_regist(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/regist");
		
		String code = request.getParameter("code");
		
		String appid = FileConfig.getInstance().getString("weixin.appid");
		String appsecret = FileConfig.getInstance().getString("weixin.appsecret");
		
		if (null != code && !"".equals(code)) {
			logger.info("==============[OAuthServlet]获取网页授权code不为空，code=" + code);
			// 根据code换取openId
			OAuthInfo oa = WeixinUtils.getOAuthOpenId(appid, appsecret, code);
			mv.addObject("openid", oa.getOpenId());
		} else {
			logger.info("==============[OAuthServlet]获取网页授权code失败！");
		}
		
		return mv;
	}

	@RequestMapping(value = "/get_forget_very_code.html")
	public @ResponseBody
	JSONResult get_forget_very_code(HttpServletRequest request) {
		JSONResult result = null;

		Map attributes = new HashMap();

		try {

			String account = request.getParameter("account");
			Customer customer = CustomerService.getByAccount(account);
			if (customer == null) {
				result = JSONResult.error("帐号不存在");
			} else {

				String random = new Random().nextInt(99999) + "";

				String code = account + "," + random;

				CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).setAttribute(account + "#forget", code, 10);

				this.SmsService.sendChangePwdValidSms(account, random);

				result = JSONResult.success();
				result.putValue("code", "");
			}
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			result = JSONResult.error(e.getMessage() + new java.util.Date().getTime());
		}

		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/forget.html")
	public @ResponseBody
	JSONResult forget(HttpServletRequest request) {

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String verycode = request.getParameter("verycode");

		JSONResult result = null;

		DataMap attributes = new DataMap();
		String key = account + "#forget";

		try {
			String cacheCode = (String) CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).getAttribute(key);

			if (cacheCode == null || cacheCode.length() == 0 || "null".equals(cacheCode)) {
				result = JSONResult.error("验证码已过期");
				return result;
			}

			String sessionVeryCode = cacheCode.split(",")[1];
			String sessionMobile = cacheCode.split(",")[0];

			if (!(account.equals(sessionMobile) && verycode.equals(sessionVeryCode))) {
				result = JSONResult.error("验证码不正确");
				return result;
			}

			CustomerService.updateCustomerForgetPassword(account, password.trim());
			result = JSONResult.success();

			RequestUtils.getSession().removeAttribute(BizConstants.CUSTOMER_USER_REGIST_KEY);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			result = JSONResult.error(e.getMessage() + new java.util.Date().getTime());
		} finally {
			CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).clear(key);
		}

		return result;
	}

	@RequestMapping(value = "/get_very_code.html")
	public @ResponseBody
	JSONResult post_very_code(HttpServletRequest request) {
		JSONResult result = null;

		Map attributes = new HashMap();

		try {

			String account = request.getParameter("account");
			Customer customer = CustomerService.getByAccount(account);
			if (customer != null) {
				result = JSONResult.error("帐号已被注册");
			} else {

				String random = new Random().nextInt(99999) + "";

				String code = account + "," + random;

				CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).setAttribute(account + "#regist", code, 10);

				this.SmsService.sendRegisterValidSms(account, random);

				result = JSONResult.success();
				result.putValue("code", "");
			}
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			result = JSONResult.error(e.getMessage() + new java.util.Date().getTime());
		}

		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/regist.html")
	public @ResponseBody
	JSONResult regist(HttpServletRequest request, HttpServletResponse response) {

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String displayname = request.getParameter("displayname");
		String verycode = request.getParameter("verycode");
		String wx_id = request.getParameter("wx_id");

		JSONResult result = null;

		DataMap attributes = new DataMap();
		attributes.put("wx_id", wx_id);
		String key = account + "#regist";

		try {
			String cacheCode = (String) CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).getAttribute(key);

			if (cacheCode == null || cacheCode.length() == 0 || "null".equals(cacheCode)) {
				result = JSONResult.error("验证码已过期");
				return result;
			}

			String sessionVeryCode = cacheCode.split(",")[1];
			String sessionMobile = cacheCode.split(",")[0];

			if (!(account.equals(sessionMobile) && verycode.equals(sessionVeryCode))) {
				result = JSONResult.error("验证码不正确");
				return result;
			}

			System.out.println(1);

			Cookie cookie = CookieUtils.getCookie(request, "share_id");
			if (cookie != null) {
				String share_id = cookie.getValue();
				attributes.put("share_id", share_id);
			} else {
				Cookie wxCookie = CookieUtils.getCookie(request, "wxsid");
				if (wxCookie != null) {
					String share_id = wxCookie.getValue();
					attributes.put("share_id", share_id);
				}
			}

			CustomerService.regist(account, password, displayname, attributes);

			CookieUtils.cancleCookie(request, response, "share_id", null);

			result = JSONResult.success();

			RequestUtils.getSession().removeAttribute(BizConstants.CUSTOMER_USER_REGIST_KEY);

			// auto login//////////////////////////////////////////////////

			Customer customer = CustomerService.login(account, password, attributes);

			DataMap sessionMap = new DataMap();
			sessionMap.put("account", customer.getAccount());
			sessionMap.put("displayname", customer.getDisplayname());
			sessionMap.put("customerid", customer.getCustomerId());

			LoginSessionUtils.setCustomerUserSessionMap(sessionMap);
			// /////////////////////////////////////////////////////////////

		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			result = JSONResult.error(e.getMessage() + new java.util.Date().getTime());
		} finally {
			CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).clear(key);
		}

		return result;
	}

}
