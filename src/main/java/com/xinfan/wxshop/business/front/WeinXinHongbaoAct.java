package com.xinfan.wxshop.business.front;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xinfan.wxshop.business.entity.Wallet;
import com.xinfan.wxshop.business.pay.hongbao.MoneyUtils;
import com.xinfan.wxshop.business.pay.weixin.CommonUtil;
import com.xinfan.wxshop.business.pay.weixin.GetWxOrderno;
import com.xinfan.wxshop.business.pay.weixin.RequestHandler;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.config.FileConfig;
import com.xinfan.wxshop.common.security.DesUtils;
import com.xinfan.wxshop.common.util.JSONUtils;

@Controller
public class WeinXinHongbaoAct {
	
	private final Logger logger = LoggerFactory.getLogger(WeinXinHongbaoAct.class);

	@Autowired
	private GoodsService GoodsService;

	@Autowired
	private CartService CartService;

	@Autowired
	private OrderService OrderService;
	
	@Autowired
	private CustomerService CustomerService;

	@Autowired
	private DeliveryAddressService DeliveryAddressService;
	
	@RequestMapping("/center/transfer.html")
	public ModelAndView transfer(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView("/front/tranfer");
		
		String msg = "";
		String money = request.getParameter("money");
		if(money == null || money.length() == 0){
			msg = "请输入金额";
			return toErrorTranfer(msg);
		}
		
		float moneyFloat = Float.parseFloat(money);
		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
		Wallet wallet = this.CustomerService.getWalletByCustomerId(customerId);
		if(wallet.getBalance()<moneyFloat){
			msg = "余额不足";
			return toErrorTranfer(msg);
		}
		
		if(moneyFloat>200){
			msg = "金额一次不能超过200元";
			return toErrorTranfer(msg);
		}
		
		request.setAttribute("money", money);
		return new ModelAndView("forward:/center/weixin_hongbao_auth.html");
	}
	
	public ModelAndView toErrorTranfer(String msg) {
		ModelAndView mv = new ModelAndView("/front/tranfer");
		
		Integer customerId = LoginSessionUtils
				.getCustomerIdFromUserSessionMap();
		
		Wallet wallet = this.CustomerService.getWalletByCustomerId(customerId);
		mv.addObject("wallet", wallet);
		mv.addObject("msg", msg);
		
		return mv;
	}

	@RequestMapping("/center/weixin_hongbao_auth.html")
	public void weixin1(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		//共账号及商户相关参数
		String appid = FileConfig.getInstance().getString("weixin.appid");
		String backUri = FileConfig.getInstance().getString("weixin.hongbao.backurl");
		
		Float money =Float.parseFloat(String.valueOf(request.getAttribute("money")));
		
		String body = "money="+money;
		
		String desPassword = FileConfig.getInstance().getString("weixin.des.password");
		String decData = Base64.encodeBase64String(DesUtils.encrypt(body.getBytes("UTF-8"), desPassword));
		
		backUri = backUri+"?data="+decData;
		//URLEncoder.encode 后可以在backUri 的url里面获取传递的所有参数
		backUri =URLEncoder.encode(backUri);
		
		//scope 参数视各自需求而定，这里用scope=snsapi_base 不弹出授权页面直接授权目的只获取统一支付接口的openid
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
				"appid=" + appid+
				"&redirect_uri=" +
				 backUri+
				"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
		response.sendRedirect(url);
	}
	

	@RequestMapping("/center/weixin_hongbao_pay.html")
	public ModelAndView weixin2(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		ModelAndView mv = new ModelAndView("/front/hongbao_pay_tip");
		
		String msg = "";
		
		String authData = request.getParameter("data").replaceAll(" ", "+");
		
		String desPassword = FileConfig.getInstance().getString("weixin.des.password");
		String decData = new String(DesUtils.decrypt(Base64.decodeBase64(authData), desPassword));
		
		Map<String,String[]> paramterMap = RequestUtils.getQueryParamMap(decData);
		
		int money = Float.valueOf(paramterMap.get("money")[0]).intValue();
		String code = request.getParameter("code");
		

		// 商户相关资料
		String appid = FileConfig.getInstance().getString("weixin.appid");
		String appsecret = FileConfig.getInstance().getString("weixin.appsecret");
		String partner = FileConfig.getInstance().getString("weixin.mch_id");

		String openId = "";
		String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ appid + "&secret=" + appsecret + "&code=" + code
				+ "&grant_type=authorization_code";
		
		JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
		
		logger.debug("weixin_hongbao_pay jsonobject :" + jsonObject.toJSONString());
		
		if (null != jsonObject) {
			openId = jsonObject.getString("openid");
		}
		
		String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
		
		String orderNNo =  MoneyUtils.getOrderNo() ; 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nonce_str", MoneyUtils.buildRandom());//随机字符串
		map.put("mch_billno", orderNNo);//商户订单
		map.put("mch_id", partner);//商户号
		map.put("wxappid", appid);//商户appid
		map.put("nick_name", "新帆科技");//提供方名称
		map.put("send_name", "果然逗红包");//用户名
		map.put("re_openid", openId);//用户openid
		map.put("total_amount", money*100);//付款金额
		//map.put("min_value", money *100);//最小红包
		//map.put("max_value", money *100);//最大红包
		map.put("total_num", 1);//红包发送总人数
		map.put("wishing", "果然逗红包提层红包");//红包祝福语
		map.put("client_ip", request.getRemoteHost());//ip地址
		map.put("act_name", "红包");//活动名称
		map.put("remark", "继续加油哦");//备注
		
		logger.debug("weixin_hongbao_pay sign map :" + JSONUtils.toJSONString(map));
		
		map.put("sign", MoneyUtils.createSign(map));//签名
		
		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
		Wallet wallet = CustomerService.getWalletByCustomerId(customerId);
		
		if(wallet.getBalance()<=money){
			msg = "金额不足";
			mv.addObject("msg", msg);
			return mv;
		}
		
		try {
			
			Map<String,String> resultMap = GetWxOrderno.getSSLResult(url, MoneyUtils.createXML(map));
			if(resultMap!=null){
				String return_code = resultMap.get("return_code");
				String return_msg = resultMap.get("return_msg");
				
				if("SUCCESS".equalsIgnoreCase(return_code)){
					CustomerService.updateWalletBalance(customerId, money,orderNNo,openId,request.getRemoteHost());
					mv.addObject("msg", "发送红外成功");
					return mv;
				}
				
				msg = return_msg;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "红包失败";
		}
		
		mv.addObject("msg", msg);
		return mv;
	}
	

	public void checkSign(SortedMap<String, String> resultMap) {
		String sign = resultMap.get("sign");

		String secret = FileConfig.getInstance().getString("weixin.appsecret");

		String calSign = RequestHandler.createSign(resultMap, secret);

		if (!calSign.equals(sign)) {
			throw new RuntimeException("sign check error");
		}
	}

}
