package com.xinfan.wxshop.business.front;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.base.BizException;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.cache.CacheHolder;
import com.xinfan.wxshop.common.sms.SmsService;
import com.xinfan.wxshop.common.util.CookieUtils;

@Controller
public class RegistAct {

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
	
	@RequestMapping( method=RequestMethod.GET, value="/forget.html")
	public ModelAndView forget() {
		ModelAndView mv = new ModelAndView("/front/forget");
		return mv;
	}
	

	
	@RequestMapping( method=RequestMethod.GET, value="/regist.html")
	public ModelAndView regist() {
		ModelAndView mv = new ModelAndView("/front/regist");
		return mv;
	}
	

	@RequestMapping( value="/get_forget_very_code.html")
	public @ResponseBody JSONResult get_forget_very_code(HttpServletRequest request) {
		JSONResult result = null;
		
		Map attributes = new HashMap();
		
		try{
			
			String account = request.getParameter("account");
			Customer customer = CustomerService.getByAccount(account);
			if(customer ==null){
				result = JSONResult.error("帐号不存在");
			}
			else{
				
				String random = new Random().nextInt(99999) + "";
				
				String code = account+","+random;
				
				CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).setAttribute(account+"#forget", code, 10);
				
				this.SmsService.sendChangePwdValidSms(account, random);
				
				result = JSONResult.success();
				result.putValue("code", "");
			}
		}
		catch(BizException e){
			e.printStackTrace();
			result = JSONResult.error(e.getMessage()+new java.util.Date().getTime());
		}
		
		return result;
	}
	

	@RequestMapping( method=RequestMethod.POST, value="/forget.html")
	public  @ResponseBody
	JSONResult forget(HttpServletRequest request) {

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String verycode = request.getParameter("verycode");
		
		JSONResult result = null;
		
		DataMap attributes = new DataMap();
		String key = account+"#forget";
		
		try{
			
			String cacheCode  = String.valueOf(CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).getAttribute(key));
			
			if(cacheCode == null || cacheCode.length() == 0){
				result = JSONResult.error("验证码已过期");
				return result;
			}
			
			String sessionVeryCode = cacheCode.split(",")[1];
			String sessionMobile = cacheCode.split(",")[0];
			
			if(!(account.equals(sessionMobile) && verycode.equals(sessionVeryCode))){
				result = JSONResult.error("验证码不正确");
				return result;
			}
			
			CustomerService.updateCustomerForgetPassword(account,password.trim());
			result = JSONResult.success();
			
			RequestUtils.getSession().removeAttribute(BizConstants.CUSTOMER_USER_REGIST_KEY);
		}
		catch(BizException e){
			e.printStackTrace();
			result = JSONResult.error(e.getMessage()+new java.util.Date().getTime());
		}
		finally{
			CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).clear(key);
		}
		
		return result;
	}
	
	
	
	
	@RequestMapping( value="/get_very_code.html")
	public @ResponseBody JSONResult post_very_code(HttpServletRequest request) {
		JSONResult result = null;
		
		Map attributes = new HashMap();
		
		try{
			
			String account = request.getParameter("account");
			Customer customer = CustomerService.getByAccount(account);
			if(customer !=null){
				result = JSONResult.error("帐号已被注册");
			}
			else{
				
				String random = new Random().nextInt(99999) + "";
				
				String code = account+","+random;
				
				CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).setAttribute(account+"#regist", code, 10);
				
				this.SmsService.sendRegisterValidSms(account, random);
				
				result = JSONResult.success();
				result.putValue("code", "");
			}
		}
		catch(BizException e){
			e.printStackTrace();
			result = JSONResult.error(e.getMessage()+new java.util.Date().getTime());
		}
		
		return result;
	}
	
	
	@RequestMapping( method=RequestMethod.POST, value="/regist.html")
	public  @ResponseBody
	JSONResult regist(HttpServletRequest request,HttpServletResponse response) {

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String displayname = request.getParameter("displayname");
		String verycode = request.getParameter("verycode");
		
		JSONResult result = null;
		
		DataMap attributes = new DataMap();
		String key = account+"#regist";
		
		try{
			
			String cacheCode  = String.valueOf(CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).getAttribute(key));
			
			if(cacheCode == null || cacheCode.length() == 0){
				result = JSONResult.error("验证码已过期");
				return result;
			}
			
			String sessionVeryCode = cacheCode.split(",")[1];
			String sessionMobile = cacheCode.split(",")[0];
			
			if(!(account.equals(sessionMobile) && verycode.equals(sessionVeryCode))){
				result = JSONResult.error("验证码不正确");
				return result;
			}
			
			Cookie cookie = CookieUtils.getCookie(request, "share_id");
			if(cookie!=null){
				String share_id = cookie.getValue();
				attributes.put("share_id", share_id);
			}
			else{
				Cookie wxCookie = CookieUtils.getCookie(request, "wxsid");
				if(wxCookie!=null){
					String share_id = wxCookie.getValue();
					attributes.put("share_id", share_id);
				}
			}
			
			
			CustomerService.regist(account,password,displayname,attributes);
			
			CookieUtils.cancleCookie(request, response, "share_id", null);
			
			result = JSONResult.success();
			
			RequestUtils.getSession().removeAttribute(BizConstants.CUSTOMER_USER_REGIST_KEY);
		}
		catch(BizException e){
			e.printStackTrace();
			result = JSONResult.error(e.getMessage()+new java.util.Date().getTime());
		}
		finally{
			CacheHolder.getInstance().getCacheProvider(BizConstants.PROVIDER_EXP_CACHE).clear(key);
		}
		
		return result;
	}
	

}
