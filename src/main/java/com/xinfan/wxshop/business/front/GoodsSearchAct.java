package com.xinfan.wxshop.business.front;

import java.util.ArrayList;
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
import com.xinfan.wxshop.business.util.ParamterUtils;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
public class GoodsSearchAct {

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

	@RequestMapping("/goods-s-detail.html")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/index");

		String goodsId = request.getParameter("goodsId");

		Goods bean = GoodsService.getGoods(Integer.parseInt(goodsId));
		mv.addObject("goods", bean);

		return mv;
	}
	
	
	@RequestMapping("/s.html")
	public ModelAndView s(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("/front/search");
		
		String w = request.getParameter("w");
		
		Pagination page = RequestUtils.getPagination(request);

		DataMap param = new DataMap();
		List<Goods> list =  new ArrayList<Goods>();
		page.setPageSize(2);
		
		if(w!=null &&w.trim().length()>0){
			w = ParamterUtils.stringFilter(w);
			param.put("goodsName", w);
			param.put("goodsLname", w);
			list = GoodsService.getGoodsClassifySerchList(param,page);
		}
		
		page.setList(list);

		mv.addObject("page", page);
		mv.addObject("w", w);

		return mv;
	}
	
	@RequestMapping("/s-more.html")
	public @ResponseBody
	JSONResult putGooosInCart(HttpServletRequest request) {

		JSONResult result = null;

		try {

			Pagination page = RequestUtils.getPagination(request);
			String w = request.getParameter("w");

			DataMap param = new DataMap();
			List<Goods> list =  new ArrayList<Goods>();
			page.setPageSize(2);
			
			if(w!=null &&w.trim().length()>0){
				w = ParamterUtils.stringFilter(w);
				param.put("goodsName", w);
				param.put("goodsLname", w);
				list = GoodsService.getGoodsClassifySerchList(param,page);
			}

			result = JSONResult.success();
			result.putValue("list", list);

		} catch (Exception e) {
			e.printStackTrace();
			result = JSONResult.error();
		}

		return result;
	}

}
