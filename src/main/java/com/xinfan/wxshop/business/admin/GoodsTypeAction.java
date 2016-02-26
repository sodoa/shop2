package com.xinfan.wxshop.business.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.entity.GoodsType;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.GoodsTypeService;

@Controller
@RequestMapping("/admin")
public class GoodsTypeAction {

	private static final Logger logger = LoggerFactory.getLogger(GoodsTypeAction.class);

	@Autowired
	private GoodsTypeService GoodsTypeService;

	@RequestMapping("/producttype-list.jspx")
	public ModelAndView productTypeList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/productype/list");

		List<GoodsType> list = GoodsTypeService.getAll();
		
		List<GoodsType> topList = new ArrayList<GoodsType>();
		for(GoodsType topType : list){
			if(topType.getpGoodstype().equals("0")){
				topList.add(topType);
			}
		}
		
		Collections.sort(topList,new Comparator<GoodsType>(){

			@Override
			public int compare(GoodsType o1, GoodsType o2) {
				return o1.getSort() >= o2.getSort() ? 0 : 1;
			}
			
		});
		
		//String tree = GoodsTypeUtils.toTree(list);
		mv.addObject("list", list);
		mv.addObject("topList", topList);

		return mv;
	}

	@RequestMapping("/producttype-add.jspx")
	public ModelAndView productTypeAdd(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/productype/add");

		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		GoodsType bean = GoodsTypeService.getGoodsType(id);
		mv.addObject("bean", bean);
		mv.addObject("opt", opt);

		return mv;
	}

	@RequestMapping("/producttype-save.jspx")
	public ModelAndView productTypeSaveAdd(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/productype/tip");
		String msg = "操作成功";
		try {

			String opt = request.getParameter("opt");
			String pGoodstype = request.getParameter("pGoodstype");
			String goodstype = request.getParameter("goodstype");
			String productType = request.getParameter("product-type");
			String productTypeName = request.getParameter("product-type-name");
			String sort = request.getParameter("product-type-sort");

			if ("1".equals(opt)) {
				GoodsType bean = new GoodsType();
				bean.setGoodstype(productType);
				bean.setpGoodstype(pGoodstype);
				bean.setSort(Integer.parseInt(sort));
				bean.setGoodstypeName(productTypeName);
				GoodsTypeService.insertGoodsType(bean);
			} else if ("2".equals(opt)) {
				GoodsType bean = new GoodsType();
				bean.setGoodstype(goodstype);
				bean.setSort(Integer.parseInt(sort));
				bean.setGoodstypeName(productTypeName);
				bean.setGoodstype(pGoodstype);
				this.GoodsTypeService.updateGoodsType(bean);
			} else if ("3".equals(opt)) {
				GoodsTypeService.deleteGoodsType(goodstype);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			msg = e.getMessage();
		}

		mv.addObject("msg", msg);

		return mv;
	}
	

	@RequestMapping("/producttype-del.jspx")
	public @ResponseBody
	JSONResult del(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		this.GoodsTypeService.deleteGoodsType(id);

		return JSONResult.success();
	}

}
