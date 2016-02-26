package com.xinfan.wxshop.business.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.DeliveryAddress;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.business.vo.OrderBean;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
public class OrderListAct {

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

	@RequestMapping(method = RequestMethod.GET, value = "/center/order_list.html")
	public ModelAndView center(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("/front/order_list");
		
		String li = request.getParameter("li");
		
		if(li == null || li.length()==0){
			li = "1";
		}
		
		DataMap sessionMap = LoginSessionUtils.getCustomerUserSessionMap();
		int customerId = Integer.parseInt(sessionMap.getString("CUSTOMERID"));
		
		Pagination page = new Pagination();
		page.setPageNo(1);
		page.setPageSize(5);
		
		page = CustomerService.getCustomerCenterOrderPageList(customerId,li, page);

		mv.addObject("page", page);
		mv.addObject("li", li);

		return mv;
	}
	
	@RequestMapping("/center/order_list_data.html")
	public ModelAndView putGooosInCart(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/order_list_content_ajax");
		try {

			Pagination page = RequestUtils.getPagination(request);
			page.setPageSize(5);
			String li = request.getParameter("li");
			Integer id = LoginSessionUtils.getCustomerIdFromUserSessionMap();
			
			page = this.CustomerService.getCustomerCenterOrderPageList(id, li,
					page);
			
			mv.addObject("list", page.getList());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}
	
	//
	@RequestMapping("/center/order-comment.html")
	public ModelAndView orderComment(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/order-comment");
		try {

			String li = request.getParameter("li");
			String id = request.getParameter("id");
			
			mv.addObject("li", li);
			mv.addObject("id", id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}
	
	@RequestMapping("/center/save-order-comment.html")
	public ModelAndView saveOrderComment(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String li = request.getParameter("li");
		String id = request.getParameter("id");
		String comment = request.getParameter("comment");
		try {

			int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
			
			OrderService.updateOrderCommented(Integer.parseInt(id),customerId,comment);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("redirect:/center/order_list.html?li="+li);

		return mv;
	}
	
	
	@RequestMapping("/center/order-info-{id}.html")
	public ModelAndView orderview(@PathVariable Integer id,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/order_info");

		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
		OrderBean orderBean = OrderService.getOrderDetailInfo(id, customerId);

		DeliveryAddress address = DeliveryAddressService.getDeliverAddress(orderBean.getOrder().getDeliveryId());
		mv.addObject("address", address);
		mv.addObject("bean", orderBean);

		return mv;
	}
	


}
