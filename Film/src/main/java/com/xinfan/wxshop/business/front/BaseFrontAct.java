package com.xinfan.wxshop.business.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class BaseFrontAct {
	
	public ModelAndView includeError(String msg,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/front/error");
		mv.addObject("msg", msg);
		return mv;
	}
	
/*	public ModelAndView forwardError(String msg,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("forward:/error.html");
		mv.addObject("msg", msg);
		return mv;
	}*/
	
}
