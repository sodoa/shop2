package com.xinfan.wxshop.business.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.constants.OrderStateEnum;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.vo.PurchaseGoodsVo;

@Controller
@RequestMapping("/admin")
public class PurchaseAction {

	@Autowired
	private OrderService OrderService;

	@Autowired
	private CustomerService CustomerService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@RequestMapping("/purchase-summary.jspx")
	public ModelAndView summary(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/purchase/summary");


		String enddate = request.getParameter("enddate");
		
		Date end = new Date();

		if (StringUtils.isNotEmpty(enddate)) {
			try {
				end = DateUtils.parseDate(enddate, new String[]{"yyyy-MM-dd HH:mm"});
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		List<PurchaseGoodsVo> list = this.OrderService.getOrderGoodsStaticSummary(DateUtils.addHours(end, 1));
		mv.addObject("list", list);
		mv.addObject("end", sdf.format(end));
		
		return mv;
	}
	
	
	@RequestMapping("/purchase-list.jspx")
	public ModelAndView listPurchase(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/purchase/list");

		String enddate = request.getParameter("enddate");
		
		Date end = new Date();

		if (StringUtils.isNotEmpty(enddate)) {
			try {
				end = DateUtils.parseDate(enddate, new String[]{"yyyy-MM-dd HH:mm"});
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		List list = OrderService.getPurchaseOrderList(DateUtils.addHours(end, 1),OrderStateEnum.PAYED.getIndex());
		
		mv.addObject("list", list);
		mv.addObject("size", list.size());
		mv.addObject("end", sdf.format(end));
		return mv;
	}
	
}
