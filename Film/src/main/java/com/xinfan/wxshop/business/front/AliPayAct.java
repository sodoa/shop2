package com.xinfan.wxshop.business.front;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.pay.alipay.AlipayNotify;
import com.xinfan.wxshop.business.pay.alipay.OrderPay;
import com.xinfan.wxshop.business.pay.alipay.PayRequestUtil;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.common.config.FileConfig;

@Controller
public class AliPayAct {

	private static final Logger logger = LoggerFactory
			.getLogger(AliPayAct.class);

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

	@RequestMapping(value = "/center/alipay_pay.html")
	public ModelAndView generateOrder(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/ali_pay");

		String orderNo = (String) request.getAttribute("orderNo");
		Float money = (Float) request.getAttribute("money");
		String customerId = (String) request.getAttribute("customerId");
		String describe = (String) request.getAttribute("describe");
		
		
		String returnUrl = FileConfig.getInstance().getString("alipay.backurl");
		String notifyUrl  = FileConfig.getInstance().getString("alipay.notifyurl");

		OrderPay pay = new OrderPay();
		pay.setFee(money);
		pay.setOrderName(describe);
		pay.setUserIp(request.getRemoteAddr());
		pay.setOrderNo(orderNo);
		pay.setNotify_url(notifyUrl);
		pay.setReturn_url(returnUrl);
		pay.setBody("customerId="+customerId);

		String html = PayRequestUtil.alipayPc(pay);

		mv.addObject("html", html);

		return mv;
	}

	/**
	 * 支付宝返回页面
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/alipay_return_url.html")
	public ModelAndView generateOrder(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = null;
		logger.debug("支付宝，return");
		try {
			Map<String, String> params = new HashMap<String, String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter
					.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
			// 计算得出通知验证结果
			boolean verify_result = AlipayNotify.verify(params);

			if (verify_result) {
				// 验证成功
				String out_trade_no = new String(request.getParameter(
						"out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
				String total_fee = request.getParameter("total_fee");
				mv = new ModelAndView("/front/alipay_msg");
				mv.addObject("orderNo", out_trade_no);
				mv.addObject("money", total_fee);
				mv.addObject("msg","支付成功");
				// ——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

				// ////////////////////////////////////////////////////////////////////////////////////////
			} else {
				// 该页面可做页面美工编辑
				mv = new ModelAndView("/front/alipay_msg");
				mv.addObject("msg", "非支付宝链接!");
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(),e);
			mv = new ModelAndView("/front/alipay_msg");
			mv.addObject("msg", e.getMessage());
		}
		return mv;

	}

	/**
	 * 支付宝异步通知页面
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/alipay_notify_url.html")
	public String notifyUrl(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = null;
		logger.debug("支付宝，notify");
		try {
			Map<String, String> params = new HashMap<String, String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter
					.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				params.put(name, valueStr);
			}
			// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			// 商户订单号
			String out_trade_no = new String(request.getParameter(
					"out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no")
					.getBytes("ISO-8859-1"), "UTF-8");
			// 交易状态
			String trade_status = new String(request.getParameter(
					"trade_status").getBytes("ISO-8859-1"), "UTF-8");
			// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
			// 计算得出通知验证结果
			boolean verify_result = AlipayNotify.verify(params);
			if (verify_result) {
				// 验证成功
				if (trade_status.equals("TRADE_FINISHED")
						|| trade_status.equals("TRADE_SUCCESS")) {
					// 判断该笔订单是否在商户网站中已经做过处理
					// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					// 请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
					// 如果有做过处理，不执行商户的业务程序

					// 注意：
					// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
					
					OrderService.updateOrderIsPayed(out_trade_no);

					logger.debug("交易成功！");
					response.getWriter().print("success");
					return "success";
				}
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
		return "fail";
	}

}
