package com.xinfan.wxshop.business.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.model.DataTableDataGrid;
import com.xinfan.wxshop.business.service.DistributionService;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
@RequestMapping("/admin")
public class DistAction {

	@Autowired
	private DistributionService DistributionService;
	
	@RequestMapping("/dist-list.jspx")
	public ModelAndView waitOrder(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/m_dist_list");

		return mv;
	}
	
	@RequestMapping("/dist-list-page.jspx")
	public @ResponseBody
	DataTableDataGrid waitOrderPage(HttpServletRequest request) {

		Pagination page = RequestUtils.getDataTablePagination(request);
		String draw = request.getParameter("draw");
		if (draw == null || draw.trim().length() == 0) {
			draw = "1";
		}
		
		DataMap map = new DataMap();
		
		page = DistributionService.pageSelectDistributionList(map, page);

		DataTableDataGrid grid = new DataTableDataGrid(Integer.parseInt(draw),
				page, new String[] { "distribution_date", "from_displayname", "to_displayname","distribution_result"});

		return grid;
	}

}
