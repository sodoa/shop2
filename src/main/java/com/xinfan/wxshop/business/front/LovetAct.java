package com.xinfan.wxshop.business.front;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.Love;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.AppraiseService;
import com.xinfan.wxshop.business.service.CartService;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.service.LoveService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
public class LovetAct {

	private static final Logger logger = LoggerFactory.getLogger(LovetAct.class);

	@Autowired
	private GoodsService GoodsService;

	@Autowired
	private CartService CartService;

	@Autowired
	private OrderService OrderService;

	@Autowired
	private AppraiseService AppraiseService;

	@Autowired
	private LoveService LoveService;

	@Autowired
	private DeliveryAddressService DeliveryAddressService;

	@RequestMapping("/center/love.html")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/love_list");

		Pagination page = RequestUtils.getPagination(request);
		page.setPageSize(100);

		DataMap sessionMap = LoginSessionUtils.getCustomerUserSessionMap();
		int customerId = Integer.parseInt(sessionMap.getString("CUSTOMERID"));

		Pagination listPage = LoveService.list(customerId, page);
		mv.addObject("list", listPage.getList());

		return mv;
	}

	// love-delete

	@RequestMapping("/center/love-delete.html")
	public @ResponseBody
	JSONResult loveDelete(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		try {

			String id = request.getParameter("id");

			if (StringUtils.isNotEmpty(id)) {
				LoveService.delete(Integer.parseInt(id));
			}

			result = result.success();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = result.error("删除失败");
		}

		return result;
	}
	

	@RequestMapping("/center/love-add.html")
	public @ResponseBody
	JSONResult addLove(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		try {

			String id = request.getParameter("gid");

			if (StringUtils.isNotEmpty(id)) {
				
				Love love = new Love();
				love.setGoodsId(Integer.parseInt(id));
				int customerId = LoginSessionUtils.getCustomerIdFromUserSessionMap();
				love.setCustomerId(customerId);
				LoveService.add(love);
			}

			result = result.success();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = result.error("删除失败");
		}

		return result;
	}

}
