package com.xinfan.wxshop.business.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.Article;
import com.xinfan.wxshop.business.entity.IncomeRank;
import com.xinfan.wxshop.business.helper.FilePathHelper;
import com.xinfan.wxshop.business.service.ArticleService;
import com.xinfan.wxshop.business.service.RankingService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.common.base.DataMap;

@Controller
public class RankAct {

	private static final Logger logger = LoggerFactory.getLogger(RankAct.class);

	@Autowired
	private RankingService RankingService;

	@Autowired
	private ArticleService ArticleService;

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

	@RequestMapping("/sh.html")
	public ModelAndView sh() {
		ModelAndView mv = new ModelAndView("/front/share");
		return mv;
	}

	@RequestMapping("/ac.html")
	public ModelAndView acitivty(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/activity");

		int pagesize = 20;
		List<Article> list = ArticleService.getShareList(pagesize);
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/ac-{id}.html")
	public ModelAndView acitivtyContent(@PathVariable int id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/activity_content");
		Article article = ArticleService.selectByPrimaryKey(id);

		if (article != null) {
			String content = FilePathHelper.getArticleContentHtml(request, article.getContent());
			article.setContent(content);
		}

		int login = 0;
		DataMap user = LoginSessionUtils.getCustomerUserSessionMap();
		if (user == null) {
			login = 0;
		} else {
			login = 1;
		}

		mv.addObject("bean", article);
		mv.addObject("login", login);
		return mv;
	}

	@RequestMapping("/accreate.html")
	public void accreate(HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			ArticleService.updateShareCount(Integer.parseInt(id));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
