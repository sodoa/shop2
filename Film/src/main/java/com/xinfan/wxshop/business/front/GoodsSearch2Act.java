package com.xinfan.wxshop.business.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
public class GoodsSearch2Act {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsSearch2Act.class);

	@Autowired
	private GoodsService GoodsService;

	@Autowired
	private CartService CartService;

	@Autowired
	private OrderService OrderService;

	@Autowired
	private DeliveryAddressService DeliveryAddressService;

	@RequestMapping("/g-s.html")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/goods-search");
		Pagination page = RequestUtils.getPagination(request);
		String w = request.getParameter("w");
		String theme = request.getParameter("theme");
		String show = request.getParameter("show");
		
		
		if(theme == null || theme.length()==0){
			theme = "1";
		}
		
		page.setPageSize(5);

		List<Goods> list = GoodsService.getGoodsKeyWordsSerchList(w,theme,page);
		
		mv.addObject("page", page);
		mv.addObject("w", w);
		mv.addObject("theme", theme);
		mv.addObject("menu_hit", "2");
		mv.addObject("show", show);
		
		return mv;
	}

	@RequestMapping("/g-s-more.html")
	public @ResponseBody
	JSONResult putGooosInCart(HttpServletRequest request) {

		JSONResult result = null;
		
		try {

			Pagination page = RequestUtils.getPagination(request);
			String w = request.getParameter("w");
			String theme = request.getParameter("theme");
			
			if(theme == null || theme.length()==0){
				theme = "1";
			}
			
			
			page.setPageSize(5);

			List<Goods> list = GoodsService.getGoodsKeyWordsSerchList(w,theme,page);
			
			result = JSONResult.success();
			result.putValue("list", list);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result = JSONResult.error();
		}

		return result;

	}

}
