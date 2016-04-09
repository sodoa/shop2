package com.xinfan.wxshop.business.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.DeliveryAddress;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.common.base.DataMap;

@Controller
public class AddressAct {

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

	@RequestMapping("/center/address_list.html")
	public ModelAndView myaddress(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/address_list");
		
		String from = request.getParameter("from");
		String opt = request.getParameter("opt");
		
		if(from !=null && from.length()>2 && !"null".equals(from)){
			mv.addObject("from", from);//from = 1 订单
			mv.addObject("opt", opt);//from = 1 订单
			request.getSession(true).setAttribute("from", from);
			request.getSession(true).setAttribute("opt", opt);
		}
		
		DataMap sessionMap = LoginSessionUtils.getCustomerUserSessionMap();
		int customerId = Integer.parseInt(sessionMap.getString("CUSTOMERID"));

		List<DeliveryAddress> list = DeliveryAddressService.getCustomerDeliveryAddressList(customerId);
		mv.addObject("list", list);
		mv.addObject("menu_hit", 4);

		return mv;
	}

	@RequestMapping("/center/address_default.html")
	public String defaultAddress(HttpServletRequest request) {

		String id = request.getParameter("id");
		if (id != null && id.length() > 0) {
			DeliveryAddressService.updateDefaultDeliverAddress(Integer.parseInt(id));
		}
		
		String from = request.getParameter("from");
		if(from == null || from.length() ==0 || "null".equals(from)){
			from = (String)request.getSession().getAttribute("from");
		}
		
		String opt = request.getParameter("opt");
		if(opt == null || opt.length() ==0 || "null".equals(opt)){
			opt = (String)request.getSession().getAttribute("opt");
		}
		
		if(from!=null && from.trim().length()>0){
			request.getSession(true).removeAttribute("from");
			request.getSession(true).removeAttribute("opt");
			
			return "redirect:"+from;
		}
		
		return "redirect:/center/address_list.html";
	}

	@RequestMapping("/center/address_delete.html")
	public String deleteAddress(HttpServletRequest request) {

		String id = request.getParameter("id");
		if (id != null && id.length() > 0) {
			DeliveryAddressService.deleteDeliverAddress(Integer.parseInt(id));
		}
		
		String from = request.getParameter("from");
		
		return "redirect:/center/address_list.html?from="+from;
	}

	@RequestMapping("/center/address_add.html")
	public ModelAndView addAddress(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("/front/address_add");

		DataMap sessionMap = LoginSessionUtils.getCustomerUserSessionMap();
		int customerId = Integer.parseInt(sessionMap.getString("CUSTOMERID"));

		List<DeliveryAddress> list = DeliveryAddressService.getCustomerDeliveryAddressList(customerId);
		mv.addObject("list", list);
		
		String from = request.getParameter("from");
		mv.addObject("from", from);//from = 1 订单
		mv.addObject("menu_hit", 4);

		return mv;
	}

	@RequestMapping("/center/address_save.html")
	public @ResponseBody
	JSONResult saveAddress(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String county = request.getParameter("county");

		String street = request.getParameter("street");
		String receiverName = request.getParameter("receiverName");
		String receiverPhone = request.getParameter("receiverPhone");

		String address = province + city + county + street;

		DataMap sessionMap = LoginSessionUtils.getCustomerUserSessionMap();
		int customerId = Integer.parseInt(sessionMap.getString("CUSTOMERID"));

		DeliveryAddress vo = new DeliveryAddress();
		vo.setStreet(street);
		vo.setCity(city);
		vo.setProvince(province);
		vo.setCounty(county);
		vo.setReceiverName(receiverName);
		vo.setReceiverPhone(receiverPhone);
		vo.setCustomerId(customerId);
		vo.setAddress(address);

		DeliveryAddressService.addDeliverAddress(vo);

		return result.success();
	}

	@RequestMapping("/center/address_edit.html")
	public ModelAndView editAddress(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/address_edit");

		String id = request.getParameter("id");

		DeliveryAddress bean = DeliveryAddressService.getDeliverAddress(Integer.parseInt(id));
		mv.addObject("bean", bean);
		String from = request.getParameter("from");
		mv.addObject("from", from);//from = 1 订单
		mv.addObject("menu_hit", 4);
		return mv;
	}

	@RequestMapping("/center/address_esave.html")
	public @ResponseBody
	JSONResult saveEditAddress(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String county = request.getParameter("county");

		String street = request.getParameter("street");
		String receiverName = request.getParameter("receiverName");
		String receiverPhone = request.getParameter("receiverPhone");

		String deliveryId = request.getParameter("deliveryId");

		String address = province + city + county + street;

		DeliveryAddress vo = new DeliveryAddress();
		vo.setStreet(street);
		vo.setCity(city);
		vo.setProvince(province);
		vo.setCounty(county);
		vo.setReceiverName(receiverName);
		vo.setReceiverPhone(receiverPhone);
		vo.setAddress(address);
		vo.setDeliveryId(Integer.parseInt(deliveryId));

		DeliveryAddressService.updateDeliverAddress(vo);

		return result.success();
	}

}
