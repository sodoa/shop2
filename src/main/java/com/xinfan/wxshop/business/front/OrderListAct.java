package com.xinfan.wxshop.business.front;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.Appraise;
import com.xinfan.wxshop.business.entity.DeliveryAddress;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.AppraiseService;
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
	
	private static final Logger logger = LoggerFactory.getLogger(OrderListAct.class);

	@Autowired
	private GoodsService GoodsService;

	@Autowired
	private CartService CartService;

	@Autowired
	private OrderService OrderService;
	
	@Autowired
	private CustomerService CustomerService;

	@Autowired
	private AppraiseService AppraiseService;	
	
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
		mv.addObject("menu_hit", 4);
		
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
			
			page = this.CustomerService.getCustomerCenterOrderPageList(id, li,page);
			
			mv.addObject("list", page.getList());

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
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
			logger.error(e.getMessage(),e);
		}

		return mv;
	}
	
	@RequestMapping("/center/order-comment-view.html")
	public ModelAndView orderCommentView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/order-comment-view");
		try {

			String li = request.getParameter("li");
			String id = request.getParameter("id");
			
			Appraise bean  =this.AppraiseService.getByOrderId(Integer.parseInt(id));
			
			mv.addObject("li", li);
			mv.addObject("id", id);
			mv.addObject("bean", bean);
			mv.addObject("menu_hit", 4);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return mv;
	}	
	
	
	
	@RequestMapping("/center/save-order-comment.html")
	public @ResponseBody JSONResult saveOrderComment(HttpServletRequest request) {
		JSONResult result = null;
		
		String li = request.getParameter("li");
		String id = request.getParameter("id");
		String comment = request.getParameter("comment");
		try {

			int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
			
			OrderService.updateOrderCommented(Integer.parseInt(id),customerId,comment);
			
			result = JSONResult.success();
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = JSONResult.error("评论异常");
		}

		return result;
	}
	
	
	@RequestMapping("/center/order-info-{id}.html")
	public ModelAndView orderview(@PathVariable Integer id,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/order_info");

		int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
		OrderBean orderBean = OrderService.getOrderDetailInfo(id, customerId);

		DeliveryAddress address = DeliveryAddressService.getDeliverAddress(orderBean.getOrder().getDeliveryId());
		mv.addObject("address", address);
		mv.addObject("bean", orderBean);
		mv.addObject("menu_hit", 4);
		mv.addObject("wecat", RequestUtils.ifWecatRequest());

		return mv;
	}
	


}
