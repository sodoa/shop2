package com.xinfan.wxshop.business.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.service.AppraiseService;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;

@Controller
public class FrontAct {

	@Autowired
	private GoodsService GoodsService;

	@Autowired
	private CartService CartService;

	@Autowired
	private OrderService OrderService;
	
	@Autowired
	private AppraiseService AppraiseService;

	@Autowired
	private DeliveryAddressService DeliveryAddressService;

	@RequestMapping("/index.html")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/front/index");

		List<Goods> burstList = this.GoodsService.getTopBurstGoodsList();
		List<Goods> hotList = this.GoodsService.getTopHotGoodsList();

		mv.addObject("burstList", burstList);
		mv.addObject("hotList", hotList);

		return mv;
	}
	
	@RequestMapping("/center.html")
	public ModelAndView center() {
		ModelAndView mv = new ModelAndView("redirect:/center/my_center2.html");

		return mv;
	}
	

	@RequestMapping("/error.html")
	public ModelAndView error(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/error");
		
		String msg = request.getParameter("msg");
		if(msg == null || msg.trim().length()==0){
			msg = String.valueOf(request.getAttribute("msg"));
			
			if(msg == null || msg.trim().length() ==0	){
				msg ="未知错误";
			}
		}

		mv.addObject("msg", msg);
		return mv;
	}

}
