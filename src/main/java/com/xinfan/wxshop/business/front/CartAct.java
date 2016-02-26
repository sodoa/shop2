package com.xinfan.wxshop.business.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.DeliveryAddress;
import com.xinfan.wxshop.business.entity.Order;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.business.vo.CartInfoVo;
import com.xinfan.wxshop.business.vo.MakeOrderTable;
import com.xinfan.wxshop.common.base.DataMap;

@Controller
public class CartAct {

	@Autowired
	private GoodsService GoodsService;

	@Autowired
	private CartService CartService;

	@Autowired
	private OrderService OrderService;

	@Autowired
	private DeliveryAddressService DeliveryAddressService;


	@RequestMapping("/center/cart.html")
	public ModelAndView cart() {
		ModelAndView mv = new ModelAndView("/front/cart");

		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
		CartInfoVo CartInfoVo = CartService.getCartInfo(customerId);
		mv.addObject("CartInfoVo", CartInfoVo);

		return mv;
	}

	@RequestMapping("/center/cart-number.html")
	public String numberOperator(HttpServletRequest request) {

		String cartId = request.getParameter("cartId");
		String number_operator = request.getParameter("number_operator");

		int number = 0;
		if ("1".equals(number_operator)) {
			number = 1;
		} else {
			number = -1;
		}

		CartService.updateGoodsNumberInCart(Integer.parseInt(cartId), number);

		return "redirect:/center/cart.html";

	}

	@RequestMapping("/center/order.html")
	public ModelAndView orderview(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/order");

		String did = request.getParameter("did");
		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();

		if (did == null || did.length() == 0) {
			DeliveryAddress address = DeliveryAddressService.getSugestDeliverAddress(customerId);
			mv.addObject("address", address);
		} else {
			DeliveryAddress address = DeliveryAddressService.getDeliverAddress(Integer.parseInt(did));
			mv.addObject("address", address);
		}

		CartInfoVo CartInfoVo = CartService.getCartInfo(customerId);

		mv.addObject("CartInfoVo", CartInfoVo);

		return mv;
	}
	
	@RequestMapping("/center/cart-del.html")
	public String cartDel(HttpServletRequest request) {

		String cid = request.getParameter("cid");
		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
		CartService.deleteGoodInCard(Integer.parseInt(cid));

		return "redirect:/center/cart.html";
	}
	
	@RequestMapping("/center/order-del.html")
	public String orderDel(HttpServletRequest request) {

		String id = request.getParameter("id");
		String li = request.getParameter("li");
		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
		OrderService.deleteOrder(Integer.parseInt(id),customerId);

		return "redirect://center/order_list.html?li="+li;
	}
	
	
	//order-del.html
	
	@RequestMapping("/center/empty_cart.html")
	public ModelAndView emptyCart(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/center/cart.html");

		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();

		this.CartService.deleteAllGoodInCard(customerId);

		return mv;
	}

	@RequestMapping("/my-order.html")
	public ModelAndView myOrder() {
		ModelAndView mv = new ModelAndView("/front/my_order");

		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();

		List<DataMap> orderList = OrderService.getTopMyOrderList(customerId);

		mv.addObject("orderList", orderList);

		return mv;
	}

	@RequestMapping("/center/take-order.html")
	public ModelAndView takeOrder(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		String payType = request.getParameter("paytype");
		String msg = "";

		try {

			int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();

			String order_remark = request.getParameter("order_remark");
			String deliveryId = request.getParameter("deliveryId");
			String order_payment_type = payType;

			MakeOrderTable orderTable = CartService.makeOrder(customerId, Integer.parseInt(deliveryId), order_remark, Integer.parseInt(order_payment_type));

			if (orderTable != null) {
				mv.addObject("orderNo", orderTable.getOrderNo());
				mv.addObject("money", orderTable.getFee());
				mv.addObject("customerId", String.valueOf(customerId));
				mv.addObject("describe", orderTable.getGoodsName());
			} else {
				throw new RuntimeException("make order error");
			}
			
			
			if("1".equals(payType)){
				mv.setViewName("forward:/center/weixin_pay_auth.html");
			}
			else if("2".equals(payType)){
				mv.setViewName("forward:/center/alipay_pay.html");
			}
			else{
				msg = "支付类型异常";
				mv.setViewName("/front/order_error");
			}

		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("/front/order_error");
			mv.addObject("msg", e.getMessage());
		}

		return mv;
	}
	
	
	@RequestMapping("/center/take-order-update.html")
	public ModelAndView takeOrderUpdate(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		String payType = request.getParameter("paytype");
		String orderId = request.getParameter("orderId");
		String msg = "";

		try {

			int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();

			String order_remark = request.getParameter("order_remark");
			String deliveryId = request.getParameter("deliveryId");
			String order_payment_type = payType;

			MakeOrderTable orderTable = OrderService.payOrder(Integer.parseInt(orderId), customerId, order_remark, Integer.parseInt(order_payment_type),Integer.parseInt(deliveryId));

			if (orderTable != null) {
				mv.addObject("orderNo", orderTable.getOrderNo());
				mv.addObject("money", orderTable.getFee());
				mv.addObject("customerId", String.valueOf(customerId));
				mv.addObject("describe", orderTable.getGoodsName());
			} else {
				throw new RuntimeException("make order error");
			}
			
			
			if("1".equals(payType)){
				mv.setViewName("forward:/center/weixin_pay_auth.html");
			}
			else if("2".equals(payType)){
				mv.setViewName("forward:/center/alipay_pay.html");
			}
			else{
				msg = "支付类型异常";
				mv.setViewName("/front/order_error");
			}

		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("/front/order_error");
			mv.addObject("msg", e.getMessage());
		}

		return mv;
	}
	
	@RequestMapping("/center/address-list.html")
	public @ResponseBody
	JSONResult address_list(HttpServletRequest request) {
		JSONResult result = null;

		try {

			int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();

			List list = DeliveryAddressService.getLastDeliverAddress(customerId);

			result = JSONResult.success();
			result.putValue("list", list);

		} catch (Exception e) {
			e.printStackTrace();
			result = JSONResult.error();
		}

		return result;
	}

	@RequestMapping("/center/pay-{orderId}.html")
	public ModelAndView pay(@PathVariable Integer orderId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/pay");

		// 获取定单信息

		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
		Order order = OrderService.getPayOrderInfo(customerId, orderId);
		mv.addObject("order", order);

		return mv;
	}

	@RequestMapping("/center/put-goods-cart.html")
	public @ResponseBody
	JSONResult putGooosInCart(HttpServletRequest request) {

		JSONResult result = null;

		try {
			String goodsId = request.getParameter("goodsId");

			int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
			CartService.addGoodInCart(customerId, Integer.parseInt(goodsId));

			result = JSONResult.success();

		} catch (Exception e) {
			e.printStackTrace();
			result = JSONResult.error();
		}

		return result;
	}

}
