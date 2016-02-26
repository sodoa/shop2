package com.xinfan.wxshop.business.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.AppraiseService;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
public class GoodsBurstAct {

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

	@RequestMapping("/goods-burst.html")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/burst_list");
		
		String cur = request.getParameter("cur");
		
		Pagination page = RequestUtils.getPagination(request);
		page.setPageSize(2);
		
		DataMap param = new DataMap();
		
		if(cur!=null && cur.length()>0){
			param.put("typeLevel2", cur);
		}

		List<Goods> list = GoodsService.getGoodsBurstList(param, page);
		mv.addObject("page", page);
		mv.addObject("cur", cur);

		return mv;
	}
	
	

	@RequestMapping("/g-b-more.html")
	public @ResponseBody
	JSONResult putGooosInCart(HttpServletRequest request) {

		JSONResult result = null;

		try {

			Pagination page = RequestUtils.getPagination(request);
			String cur = request.getParameter("cur");
			
			page.setPageSize(2);
			
			DataMap param = new DataMap();
			if(cur!=null && cur.length()>0){
				param.put("typeLevel1", cur);
			}

			List<Goods> list = GoodsService.getGoodsBurstList(param, page);
			
			result = JSONResult.success();
			result.putValue("list", list);

		} catch (Exception e) {
			e.printStackTrace();
			result = JSONResult.error();
		}

		return result;
	}
	
}
