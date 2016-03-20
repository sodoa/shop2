package com.xinfan.wxshop.business.admin;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.Article;
import com.xinfan.wxshop.business.helper.FilePathHelper;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.ArticleService;

@Controller
@RequestMapping("/admin/article")
public class ArticleAction {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleAction.class);

	@Autowired
	private ArticleService ArticleService;

	@RequestMapping("/list.jspx")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/article/list");

		String classify = request.getParameter("classify");
		List<Article> list = ArticleService.getManageList(classify);
		mv.addObject("list", list);

		return mv;
	}
	

	@RequestMapping("/del.jspx")
	public @ResponseBody
	JSONResult del(HttpServletRequest request) {
		String id = request.getParameter("id");
		ArticleService.deleteByPrimaryKey(Integer.parseInt(id));
		return JSONResult.success();
	}
	
	@RequestMapping("/add.jspx")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/article/add");
		return mv;
	}
	
	@RequestMapping("/save-add.jspx")
	public ModelAndView save( @RequestParam("img") MultipartFile file,HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("/admin/article/tip");
		
		try {
			String title = request.getParameter("title");
			String summary = request.getParameter("summary");
			String classify = request.getParameter("classify");
			String keywords = request.getParameter("keywords");
			String content = request.getParameter("content");
			
			Article record = new Article();
			
			String path = FilePathHelper.getArticleContentHtmlToSavePath();
			FileUtils.writeStringToFile(new File(FilePathHelper.getRealPath(request) + path), content);
			record.setContent(path);
			
			if(!file.isEmpty() && file.getSize()>0){
				String imagePath = FilePathHelper.getArticleImgToSavePath();
				FileUtils.writeByteArrayToFile(new File(FilePathHelper.getRealPath(request) + imagePath), file.getBytes());
				record.setImg(imagePath);
			}
			
			record.setClassify(classify);
			record.setTitle(title);
			record.setClassify(classify);
			record.setKeywords(keywords);
			record.setSummary(summary);
			
			ArticleService.insertSelective(record);
			mv.addObject("msg", "操作成功");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			mv.addObject("msg", e.getMessage());
		}
		
		return mv;
	}
	
	@RequestMapping("/update.jspx")
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/article/update");
		
		String id = request.getParameter("id");
		Article article = this.ArticleService.selectByPrimaryKey(Integer.parseInt(id));
		String html = FilePathHelper.getArticleContentHtml(request, article.getContent());
		
		mv.addObject("bean", article);
		mv.addObject("html", html);
		
		return mv;
	}
	
	@RequestMapping("/save-update.jspx")
	public ModelAndView saveupdate( @RequestParam("img") MultipartFile file,HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("/admin/article/tip");
		
		try {
			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String summary = request.getParameter("summary");
			String classify = request.getParameter("classify");
			String keywords = request.getParameter("keywords");
			String content = request.getParameter("content");
			
			Article article = this.ArticleService.selectByPrimaryKey(Integer.parseInt(id));
			
			Article record = new Article();
			record.setId(Integer.parseInt(id));
			
			String path = FilePathHelper.getArticleContentHtmlToSavePath();
			FileUtils.writeStringToFile(new File(FilePathHelper.getRealPath(request) + path), content);
			record.setContent(path);
			
			if(!file.isEmpty() && file.getSize()>0){
				
				String imagePath = FilePathHelper.getArticleImgToSavePath();
				FileUtils.writeByteArrayToFile(new File(FilePathHelper.getRealPath(request) + imagePath), file.getBytes());
				record.setImg(imagePath);
				
				FileUtils.deleteQuietly(new File(FilePathHelper.getRealPath(request) + article.getContent()));
			}
			
			record.setClassify(classify);
			record.setTitle(title);
			record.setClassify(classify);
			record.setKeywords(keywords);
			record.setSummary(summary);
			
			ArticleService.insertSelective(record);
			mv.addObject("msg", "操作成功");
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			mv.addObject("msg", e.getMessage());
		}
		
		return mv;
	}

}
