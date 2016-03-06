package com.xinfan.wxshop.business.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.IncomeRank;
import com.xinfan.wxshop.business.service.DeliveryAddressService;
import com.xinfan.wxshop.business.service.RankingService;

@Controller
public class RankAct {
	
	@Autowired
	private RankingService RankingService;

	@Autowired
	private DeliveryAddressService DeliveryAddressService;

	@RequestMapping("/rk.html")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/front/rank");
		
		List<IncomeRank> weeklist = RankingService.getWeekIncomeRankList();
		List<IncomeRank> monthlist = RankingService.getMonthIncomeRankList();
		List<IncomeRank> yearlist = RankingService.getYearIncomeRankList();
		mv.addObject("weeklist", weeklist);
		mv.addObject("monthlist", monthlist);
		mv.addObject("yearlist", yearlist);
		
		return mv;
	}

}
