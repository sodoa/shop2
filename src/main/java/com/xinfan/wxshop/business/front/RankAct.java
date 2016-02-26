package com.xinfan.wxshop.business.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.service.RankingService;
import com.xinfan.wxshop.business.vo.RankList;

@Controller
public class RankAct {

	@Autowired
	private GoodsService GoodsService;

	@Autowired
	private CartService CartService;

	@Autowired
	private OrderService OrderService;
	
	@Autowired
	private RankingService RankingService;

	@Autowired
	private DeliveryAddressService DeliveryAddressService;

	@RequestMapping("/rk.html")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/front/rank");
		
		List<RankList> list = RankingService.getRankingTopList(100);
		mv.addObject("list", list);
		
		return mv;
	}

}
