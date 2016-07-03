package com.xinfan.wxshop.business.front;

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
public class GoodsDetailAct {

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

	@RequestMapping("/goods-detail.html")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/index");

		String goodsId = request.getParameter("goodsId");

		Goods bean = GoodsService.getGoods(Integer.parseInt(goodsId));
		mv.addObject("goods", bean);

		return mv;
	}

}
