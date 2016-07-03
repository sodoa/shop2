package com.xinfan.wxshop.business.front;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.business.entity.Order;
import com.xinfan.wxshop.business.entity.OrderDetail;
import com.xinfan.wxshop.business.entity.Wallet;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.common.base.DataMap;

@Controller
public class CenterAct {

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

	@RequestMapping(method = RequestMethod.GET, value = "/center/my_center.html")
	public ModelAndView center2(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/my_center");

		String from = request.getParameter("from");
		if (from == null || from.length() == 0 || "null".equals(from)) {
			from = (String) request.getSession().getAttribute("from");
		}

		if (from != null && from.trim().length() > 0) {
			request.getSession().removeAttribute("from");
			return new ModelAndView("redirect:" + from);
		}

		DataMap sessionMap = LoginSessionUtils.getCustomerUserSessionMap();
		int customerId = Integer.parseInt(sessionMap.getString("CUSTOMERID"));

		String li = request.getParameter("li");
		if (li == null || li.length() == 0) {
			li = "2";
		}
		Customer customer = CustomerService.getById(customerId);

		if (customer == null) {
			LoginSessionUtils.setExpireCustomerSessionMap();
			return new ModelAndView("redirect:/login.html");
		}

		Wallet wallet = CustomerService.getWalletByCustomerId(customerId);
		// List<DataMap> distList =
		// CustomerService.getCustomerTopDistributionList(customerId);
		// List<Order> orderList =
		// CustomerService.getCustomerTopOrderList(customerId);

		int unPayCount = OrderService.getUnPayOrderCount(customerId);

		request.setAttribute("wallet", wallet);
		// request.setAttribute("distList", distList);
		// request.setAttribute("orderList", orderList);
		request.setAttribute("customer", customer);
		request.setAttribute("li", null);
		request.setAttribute("unPayCount", unPayCount);
		request.setAttribute("menu_hit", 4);
		request.setAttribute("customerId", customer.getCustomerId());
		mv.addObject("random", new Date().getTime());

		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/center/order_history/{id}.html")
	public ModelAndView order_history(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("/front/order_history");

		Order order = OrderService.getPayOrderInfo(0, id);
		List<OrderDetail> list = OrderService.getOrderDetail(0, id);

		mv.addObject("order", order);
		mv.addObject("list", list);
		mv.addObject("menu_hit", 4);
		return mv;
	}

}
