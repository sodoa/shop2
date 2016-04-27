package com.xinfan.wxshop.business.front;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.cache.utils.ParamterUtils;
import com.xinfan.wxshop.business.entity.Article;
import com.xinfan.wxshop.business.entity.IncomeRank;
import com.xinfan.wxshop.business.helper.FilePathHelper;
import com.xinfan.wxshop.business.service.ArticleService;
import com.xinfan.wxshop.business.service.RankingService;
import com.xinfan.wxshop.business.util.LoginSessionUtils;
import com.xinfan.wxshop.business.util.WxQrcodeUtils;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.config.FileConfig;
import com.xinfan.wxshop.common.security.DesUtils;

@Controller
public class RankAct {

	private static final Logger logger = LoggerFactory.getLogger(RankAct.class);

	@Autowired
	private RankingService RankingService;

	@Autowired
	private ArticleService ArticleService;

	@RequestMapping("/rk.html")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/rank");

		String l = request.getParameter("l");
		if (l == null || l.length() == 0) {
			l = "1";
		}

		List<IncomeRank> list = null;

		if ("1".equals(l)) {
			list = RankingService.getWeekIncomeRankList();
		} else if ("2".equals(l)) {
			list = RankingService.getMonthIncomeRankList();
		} else if ("3".equals(l)) {
			list = RankingService.getYearIncomeRankList();
		}

		mv.addObject("list", list);
		mv.addObject("l", l);

		mv.addObject("menu_hit", "3");

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
		
		String customerId = "";
		String wxsid = request.getParameter("wxsid");
		
		if(LoginSessionUtils.isCustomerLogin()){
			customerId = ""+LoginSessionUtils.getCustomerIdFromUserSessionMap();
		}
		else{
			if(wxsid!=null && wxsid.length()>0){
				customerId = wxsid;
			}
		}

		mv.addObject("bean", article);
		mv.addObject("login", login);
		mv.addObject("wxsid", customerId);
		mv.addObject("random", new Date().getTime());
		return mv;
	}
	

	@RequestMapping("/distri-image2.html")
	public void distriImage2(HttpServletRequest request, HttpServletResponse response) {
		try {
			String customerId = "";
			
			String wxsid = request.getParameter("wxsid");
			
			if(LoginSessionUtils.isCustomerLogin()){
				customerId = ""+LoginSessionUtils.getCustomerIdFromUserSessionMap();
			}
			else{
				if(wxsid!=null && wxsid.length()>0){
					customerId = wxsid;
				}
			}

			byte[] images  = WxQrcodeUtils.getQrcode(request, Integer.parseInt(customerId));
			response.getOutputStream().write(images);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
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
