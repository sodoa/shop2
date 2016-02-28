package com.xinfan.wxshop.business.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.entity.GoodsImage;
import com.xinfan.wxshop.business.helper.FilePathHelper;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.AppraiseService;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.base.BizException;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
public class GoodsAct extends BaseFrontAct{

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
	
	@RequestMapping("/goods-{goodsId}.html")
	public ModelAndView goods(@PathVariable Integer goodsId,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/goods");

		Goods goods = GoodsService.getGoods(goodsId);
		
		if(goods.getGoodsStatus() == 0){
			return this.includeError("该商品已下架", request);
		}
		
		Pagination page = new Pagination();
		page.setPageNo(1);
		page.setPageSize(10);
		page = AppraiseService.listGoodsAppraise(goodsId, page);
		
		if(goods!=null){
			String html = FilePathHelper.getGoodsSummaryHtml(request, goods.getSummary());
			mv.addObject("html", html);
		}
		
		List<GoodsImage> gImages = GoodsService.getGoodsImageList(goodsId, 1, 5);

		mv.addObject("goods", goods);
		mv.addObject("list", page.getList());
		mv.addObject("gImages", gImages);

		return mv;
	}
	
	@RequestMapping("/apprise-{id}.html")
	public ModelAndView apprise(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("/front/apprise");
		
		Pagination page = new Pagination();
		page.setPageNo(1);
		page.setPageSize(5);
		page = AppraiseService.listGoodsAppraise(id, page);
		

		mv.addObject("page", page);
		mv.addObject("goodsId", id);

		return mv;
	}
	
	
	

	@RequestMapping("/fashion-{goodsId}.html")
	public ModelAndView fashion(@PathVariable Integer goodsId,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/goods-fashion");

		Goods goods = GoodsService.getGoods(goodsId);
		
		if(goods.getGoodsStatus() == 0){
			return this.includeError("该商品已下架", request);
		}
		
		List<GoodsImage> gImages = GoodsService.getGoodsImageList(goodsId, BizConstants.IMAGE_TYPE_FASHION, 30);

		mv.addObject("goods", goods);
		mv.addObject("gImages", gImages);

		return mv;
	}
	
	
	@RequestMapping("/goods-html.html")
	public ModelAndView html(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/goods-html");
		
		String summary = request.getParameter("s");
		
		String html = FilePathHelper.getGoodsSummaryHtml(request, summary);
		mv.addObject("html", html);

		return mv;
	}
	

	@RequestMapping("/apprise-list-{id}.html")
	public  @ResponseBody
	JSONResult applist(@PathVariable Integer id,HttpServletRequest request) {
		
		JSONResult result = null;
		
		try{
			Pagination page = RequestUtils.getPagination(request);
			page.setPageSize(5);
			page = AppraiseService.listGoodsAppraise(id, page);
			result = JSONResult.success();
			result.putValue("list", page.getList());
		}
		catch(BizException e){
			e.printStackTrace();
			result = JSONResult.error("");
		}
		
		return result;
	}
	

}
