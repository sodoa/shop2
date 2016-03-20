package com.xinfan.wxshop.business.front;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.entity.GoodsImage;
import com.xinfan.wxshop.business.entity.GoodsLimit;
import com.xinfan.wxshop.business.helper.FilePathHelper;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.business.vo.GoodsVsLimitVO;
import com.xinfan.wxshop.common.page.Pagination;
import com.xinfan.wxshop.common.util.TimeUtils;

@Controller
public class GoodsLimitAct  extends BaseFrontAct{
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsLimitAct.class);

	@Autowired
	private GoodsService GoodsService;

	@Autowired
	private CartService CartService;

	@Autowired
	private OrderService OrderService;

	@Autowired
	private DeliveryAddressService DeliveryAddressService;

	@RequestMapping("/g-l.html")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/goods_limit");
		Pagination page = RequestUtils.getPagination(request);
		String w = request.getParameter("w");
		String theme = request.getParameter("theme");
		
		if(theme == null || theme.length()==0){
			theme = "1";
		}
		
		page.setPageSize(5);

		List<Goods> list = GoodsService.getGoodsKeyWordsSerchList(w,theme,page);
		
		mv.addObject("page", page);
		mv.addObject("w", w);
		mv.addObject("theme", theme);
		
		return mv;
	}

	@RequestMapping("/g-l-more.html")
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

			List<GoodsVsLimitVO> list = GoodsService.getGoodsLimitKeyWordsSerchList(w,theme,page);
			
			result = JSONResult.success();
			result.putValue("list", list);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result = JSONResult.error();
		}

		return result;
	}
	
	@RequestMapping("/gl-{goodsId}.html")
	public ModelAndView goods(@PathVariable Integer goodsId,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/goods_limit_info");

		Goods goods = GoodsService.getGoods(goodsId);
		
		if(goods.getGoodsStatus() == 0){
			return this.includeError("该商品已下架", request);
		}
		
		if(!BizConstants.GOODS_THEME_TYPE_LIMIT.equals(goods.getThemeType())){
			return this.includeError("该商品不是特价", request);
		}
		
		if(goods!=null){
			String html = FilePathHelper.getGoodsSummaryHtml(request, goods.getSummary());
			mv.addObject("html", html);
		}
		
		GoodsLimit goodslimit = GoodsService.getGoodsLimit(goodsId);
		
		List<GoodsImage> gImages = GoodsService.getGoodsImageList(goodsId, 1, 5);

		mv.addObject("goods", goods);
		mv.addObject("goodslimit", goodslimit);
		mv.addObject("gImages", gImages);
		mv.addObject("timelimit", goodslimit.getTimeLimit().getTime());
		
		Date current = TimeUtils.getCurrentTime();
		boolean timeout = !current.before(goodslimit.getTimeLimit());
		
		boolean canBuy = false;
		
		if(goodslimit.getLimitType()==BizConstants.GOODS_TIME_LIMIT_TYPE_BY_COUNT){
			canBuy = !(goodslimit.getSellAmount()>=goodslimit.getTotalAmount() || timeout);
		}
		else if(goodslimit.getLimitType()==BizConstants.GOODS_TIME_LIMIT_TYPE_BY_TIME){
			canBuy = !(timeout);
		}
		
		mv.addObject("canBuy", canBuy);
		return mv;
	}

}
