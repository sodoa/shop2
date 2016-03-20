package com.xinfan.wxshop.business.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.business.entity.Order;
import com.xinfan.wxshop.business.entity.OrderDetail;
import com.xinfan.wxshop.business.formater.DataGridFormater;
import com.xinfan.wxshop.business.formater.OrderStateDataGridFormater;
import com.xinfan.wxshop.business.model.DataTableDataGrid;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.CustomerService;
import com.xinfan.wxshop.business.service.OrderService;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
@RequestMapping("/admin")
public class OrderAction {

	@Autowired
	private OrderService OrderService;

	@Autowired
	private CustomerService CustomerService;

	@RequestMapping("/order-list.jspx")
	public ModelAndView listOrder(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/order/list");
		return mv;
	}

	@RequestMapping("/order-list-page.jspx")
	public @ResponseBody
	DataTableDataGrid listOrderPage(HttpServletRequest request) {

		Pagination page = RequestUtils.getDataTablePagination(request);
		String draw = request.getParameter("draw");
		if (draw == null || draw.trim().length() == 0) {
			draw = "1";
		}

		DataMap paramter = new DataMap();
		String state = request.getParameter("state");
		if (StringUtils.isNotEmpty(state)) {
			paramter.put("status", state);
		}

		String account = request.getParameter("account");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String orderId = request.getParameter("orderId");

		if (StringUtils.isNotEmpty(account)) {
			paramter.put("account", account);
		}
		if (StringUtils.isNotEmpty(startdate)) {
			paramter.put("startdate", startdate);
		}
		if (StringUtils.isNotEmpty(enddate)) {
			paramter.put("enddate", enddate);
		}
		if (StringUtils.isNotEmpty(orderId)) {
			paramter.put("orderId", orderId);
		}

		page = OrderService.pageSelectOrderList(paramter, page);

		DataGridFormater stateFormater = new OrderStateDataGridFormater("status");

		DataTableDataGrid grid = new DataTableDataGrid(Integer.parseInt(draw), page, new Object[] { "order_id", "receiver_name", "account", "order_date",
				"total_amount", "status" });

		return grid;
	}

	@RequestMapping("/order-info.jspx")
	public ModelAndView orderDetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/order/info");

		String orderId = request.getParameter("oid");

		int oid = Integer.parseInt(orderId);

		List<OrderDetail> orderDetailList = OrderService.getOrderDetail(0, oid);
		Order order = OrderService.getPayOrderInfo(0, oid);
		Customer customer = CustomerService.getById(order.getCustomerId());

		mv.addObject("orderDetailList", orderDetailList);
		mv.addObject("order", order);
		mv.addObject("customer", customer);

		return mv;
	}

	@RequestMapping("/order-process.jspx")
	public ModelAndView order_process(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/m_order_process");

		String orderId = request.getParameter("oid");

		int oid = Integer.parseInt(orderId);

		List<OrderDetail> orderDetailList = OrderService.getOrderDetail(0, oid);
		Order order = OrderService.getPayOrderInfo(0, oid);
		Customer customer = CustomerService.getById(order.getCustomerId());

		mv.addObject("orderDetailList", orderDetailList);
		mv.addObject("order", order);
		mv.addObject("customer", customer);

		return mv;
	}

	@RequestMapping("/process-order-{id}.jspx")
	public @ResponseBody
	JSONResult processOrder(@PathVariable int id, HttpServletRequest request) {

		JSONResult result = null;
		try {

			OrderService.processOrder(id);

			result = JSONResult.success();

		} catch (Exception e) {
			e.printStackTrace();
			result = JSONResult.error();
		}
		return result;
	}

	@RequestMapping("/wait-order-page.jspx")
	public @ResponseBody
	DataTableDataGrid waitOrderPage(HttpServletRequest request) {

		Pagination page = RequestUtils.getDataTablePagination(request);
		String draw = request.getParameter("draw");
		if (draw == null || draw.trim().length() == 0) {
			draw = "1";
		}

		// page = OrderService.pageSelectOrderList(1, page);

		DataTableDataGrid grid = new DataTableDataGrid(Integer.parseInt(draw), page, new String[] { "order_id", "displayname", "order_date", "total_amount",
				"status" });

		return grid;
	}

}
