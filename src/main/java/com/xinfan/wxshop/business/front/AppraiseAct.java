package com.xinfan.wxshop.business.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.AppraiseService;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
public class AppraiseAct {

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

	@RequestMapping("/goods-appraise.html")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/index");
		return mv;
	}

	@RequestMapping("/goods_appraise_more.html")
	public @ResponseBody
	JSONResult putGooosInCart(HttpServletRequest request) {

		JSONResult result = null;

		try {

			Pagination page = RequestUtils.getPagination(request);
			String goodsId = request.getParameter("goodsId");

			page = AppraiseService.listGoodsAppraise(Integer.parseInt(goodsId),
					page);

			result = JSONResult.success();
			result.putValue("list", page.getList());

		} catch (Exception e) {
			e.printStackTrace();
			result = JSONResult.error();
		}

		return result;
	}

}
