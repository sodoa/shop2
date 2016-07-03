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
import com.xinfan.wxshop.business.service.AppraiseService;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
public class GoodsFashionAct {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsFashionAct.class);

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

	@RequestMapping("/goods-fashion.html")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/index");
		return mv;
	}
	

	@RequestMapping("/goods_fashion_more.html")
	public @ResponseBody
	JSONResult putGooosInCart(HttpServletRequest request) {

		JSONResult result = null;

		try {

			Pagination page = RequestUtils.getPagination(request);

			DataMap param = new DataMap();
			param.put("fashion", 1);

			List<Goods> list = GoodsService.getGoodsClassifySerchList(param,
					page);

			result = JSONResult.success();
			result.putValue("list", list);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result = JSONResult.error();
		}

		return result;
	}

}
