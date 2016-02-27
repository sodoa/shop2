package com.xinfan.wxshop.business.admin;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.SearchWords;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.SearchWordsService;

@Controller
@RequestMapping("/admin")
public class SearchWordsAction {

	@Autowired
	private SearchWordsService SearchWordsService;

	@RequestMapping("/words-list.jspx")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/searchwords/list");
		
		List<SearchWords> list = SearchWordsService.selectAll();
		mv.addObject("list", list);
		
		return mv;
	}

	@RequestMapping("/words-del.jspx")
	public @ResponseBody
	JSONResult del(HttpServletRequest request) {
		String words = request.getParameter("words");
		SearchWordsService.deleteByKey(words);
		return JSONResult.success();
	}
	
	@RequestMapping("/words-add.jspx")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/searchwords/add");
		return mv;
	}
	
	@RequestMapping("/words-save.jspx")
	public @ResponseBody
	JSONResult save(HttpServletRequest request) {
		String words = request.getParameter("words");
		SearchWords record = new SearchWords();
		record.setWords(words);
		SearchWordsService.insertSelective(record);
		return JSONResult.success();
	}
	
	
}
