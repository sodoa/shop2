package com.xinfan.wxshop.business.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.common.base.DataMap;

@Controller
public class LayerAct {

	@Autowired
	private CustomerService CustomerService;

	@RequestMapping("/center/layer_list.html")
	public ModelAndView myaddress(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/layer_list");
		
		DataMap sessionMap = LoginSessionUtils.getCustomerUserSessionMap();
		int customerId = Integer.parseInt(sessionMap.getString("CUSTOMERID"));

		List<Customer> list1 = CustomerService.listCustomerLayerUser(customerId,1);
		List<Customer> list2 = CustomerService.listCustomerLayerUser(customerId,2);

		mv.addObject("list1", list1);
		mv.addObject("list2", list2);
		
		mv.addObject("menu_hit", 4);

		return mv;
	}


}
