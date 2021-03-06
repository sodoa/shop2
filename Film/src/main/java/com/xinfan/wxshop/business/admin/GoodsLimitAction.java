package com.xinfan.wxshop.business.admin;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.entity.GoodsImage;
import com.xinfan.wxshop.business.entity.GoodsLimit;
import com.xinfan.wxshop.business.helper.FilePathHelper;
import com.xinfan.wxshop.business.model.DataTableDataGrid;
import com.xinfan.wxshop.business.model.JSONResult;
import com.xinfan.wxshop.business.service.GoodsService;
import com.xinfan.wxshop.business.util.RequestUtils;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.page.Pagination;

@Controller
@RequestMapping("/admin/goodslimit")
public class GoodsLimitAction {

	private static final Logger logger = LoggerFactory.getLogger(GoodsLimitAction.class);

	@Autowired
	private GoodsService GoodsService;

	@RequestMapping("/goods-list.jspx")
	public ModelAndView productTypeList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/list");

		return mv;
	}
	
	@RequestMapping("/goods-image-add.jspx")
	public ModelAndView goodsImageAdd(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/image-add");
		
		String id = request.getParameter("id");
		mv.addObject("id", id);
		
		return mv;
	}
	
	@RequestMapping("/goods-image-save.jspx")
	public ModelAndView goodsImageAdd(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/tip");
		
		String goodsId = request.getParameter("id");
		
		String realPath = FilePathHelper.getGoodsImageListToSavePath(goodsId);
		String basePath = FilePathHelper.getRealPath(request);
		String filename = new Date().getTime()+".jpg";
		
		try {
			FileUtils.writeByteArrayToFile(new File(basePath+realPath+"/"+filename), file.getBytes());
			
			GoodsImage image = new GoodsImage();
			image.setGoodsId(Integer.parseInt(goodsId));
			image.setImageType(1);
			image.setImageUrl(realPath+"/"+filename);
			this.GoodsService.insertGoodsImageList(image);
			
		} catch (IOException e) {
			mv.addObject("msg", "添加失败");
		}
		
		mv.addObject("msg", "添加成功");
		
		return mv;
	}

	@RequestMapping("/goods-image-del.jspx")
	public @ResponseBody
	JSONResult goodsImageDel(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		try {

			String id = request.getParameter("id");

			if (StringUtils.isNotEmpty(id)) {
				
				GoodsImage image = this.GoodsService.getGoodsImage(Integer.parseInt(id));
				String basePath = FilePathHelper.getRealPath(request);
				FileUtils.deleteQuietly(new File(basePath+image.getImageUrl()));
				this.GoodsService.deleteGoodsImage(Integer.parseInt(id));
			}

			result = result.success();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = result.error("删除失败");
		}
		return result;
	}

	@RequestMapping("/goods-image-list.jspx")
	public ModelAndView goodsImageList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/image-list");
		String id = request.getParameter("id");

		List<GoodsImage> list = GoodsService.getGoodsImageList(Integer.parseInt(id), 1, 20);

		mv.addObject("list", list);
		mv.addObject("id", id);

		return mv;
	}

	@RequestMapping("/goods-add.jspx")
	public ModelAndView productTypeAdd(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/add");

		String time = String.valueOf(new Date().getTime());
		mv.addObject("time", time);

		return mv;
	}

	// goods-update

	@RequestMapping("/goods-update.jspx")
	public ModelAndView productGoodsUpdate(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/update");

		String id = request.getParameter("id");
		String time = String.valueOf(new Date().getTime());

		Goods goods = GoodsService.getGoods(Integer.parseInt(id));
		GoodsLimit goodsLimit = GoodsService.getGoodsLimit(Integer.parseInt(id));

		mv.addObject("bean", goods);
		mv.addObject("time", time);
		mv.addObject("goodsLimit", goodsLimit);

		String html = FilePathHelper.getGoodsSummaryHtml(request, goods.getSummary());
		mv.addObject("html", html);

		return mv;
	}

	@RequestMapping("/goods-save-update.jspx")
	public ModelAndView productSaveUpdate(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/tip");

		DataMap paramter = RequestUtils.getRequestDataMap();

		String goodsId = request.getParameter("goodsId");
		String goods_name = request.getParameter("goods_name");
		String goods_lname = request.getParameter("goods_lname");
		String type_level1 = request.getParameter("type_level1");
		String sort = request.getParameter("sort");
		String hot = request.getParameter("hot");
		String burst = request.getParameter("burst");
		String fashion = request.getParameter("fashion");
		String fashion_template = request.getParameter("fashion_template");
		String goods_area = request.getParameter("goods_area");
		String supplier = request.getParameter("supplier");
		String unit = request.getParameter("unit");
		String final_prices = request.getParameter("final_prices");
		String orgin_prices = request.getParameter("orgin_prices");
		String keywords = request.getParameter("keywords");
		String weight = request.getParameter("weight");

		String goods_des = request.getParameter("goods_des");
		String summary = request.getParameter("summary");
		
		String theme_type = request.getParameter("theme_type");

		String time = request.getParameter("time");
		
		//////////////////////////////////////////////////////////////
		String time_limit = request.getParameter("time_limit");
		String buy_limit = request.getParameter("buy_limit");
		String total_amount = request.getParameter("total_amount");
		String goods_limit_type = request.getParameter("goods_limit_type");
		/////////////////////////////////////////////////////////////////////////

		Goods goods = new Goods();
		goods.setBurst(paramter.getInt("burst", 0));
		goods.setGoodsName(goods_name);
		goods.setGoodsLname(goods_lname);
		goods.setTypeLevel1(type_level1);
		goods.setTypeLevel2(type_level1);
		goods.setSort(paramter.getInt("sort", 0));
		goods.setHot(paramter.getInt("hot", 0));
		goods.setFashion(paramter.getInt("fashion", 0));
		goods.setFashionTemplate(fashion_template);
		goods.setSummary(summary);
		goods.setUnit(unit);
		goods.setGoodsArea(goods_area);
		goods.setFinalPrices(paramter.getFloat("final_prices"));
		goods.setOrginPrices(paramter.getFloat("orgin_prices"));
		goods.setKeywords(keywords);
		goods.setGoodsStatus(1);
		goods.setGoodsDes(goods_des);
		goods.setSupplier(supplier);
		goods.setThemeType(theme_type);
		goods.setWeight(weight);

		Goods existGoods = this.GoodsService.getGoods(Integer.parseInt(goodsId));

		try {
			File file = new File(FilePathHelper.getRealPath(request) + existGoods.getSummary());
			if (file.exists()) {
				FileUtils.deleteQuietly(file);
			}

			String path = FilePathHelper.getGoodsSummaryHtmlPath();
			FileUtils.writeStringToFile(new File(FilePathHelper.getRealPath(request) + path), summary);
			goods.setSummary(path);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		goods.setGoodsId(Integer.parseInt(goodsId));
		GoodsService.updateGoods(goods);

		String thumdPath = FilePathHelper.getImageThumdUploadPath(request);
		File tFile = new File(thumdPath);

		if (tFile.exists()) {
			Collection<File> thumdFile = FileUtils.listFiles(tFile, new String[] { "jpg" }, true);
			int index = 0;
			if (!thumdFile.isEmpty()) {
				File thumdImage = thumdFile.iterator().next();
				String newPath = FilePathHelper.getImageThumdToSavePath(String.valueOf(goods.getGoodsId()));
				try {
					newPath += (index + ".jpg");
					FileUtils.copyFile(thumdImage, new File(FilePathHelper.getRealPath(request) + newPath));
					GoodsService.updateGoodsThumdUrl(goods.getGoodsId(), newPath);
				} catch (IOException e) {
					logger.error(e.getMessage(),e);
				}
			}
			try {
				FileUtils.deleteDirectory(new File(FilePathHelper.getRealPath(request) + existGoods.getSummary()));
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
		}
		

		try {
			GoodsLimit goodsLimit = new GoodsLimit();
			goodsLimit.setGoodsId(goods.getGoodsId());
			goodsLimit.setLimitType(Integer.parseInt(goods_limit_type));
			goodsLimit.setTotalAmount(Integer.parseInt(total_amount));
			goodsLimit.setBuyLimit(Integer.parseInt(buy_limit));
			goodsLimit.setTimeLimit(DateUtils.parseDate(time_limit, new String[]{"yyyy-MM-dd HH:mm"}));
			GoodsService.updateGoodsLimit(goodsLimit);
			
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}

		mv.addObject("msg", "修改成功");
		return mv;
	}

	@RequestMapping("/goods-detail.jspx")
	public ModelAndView productGoodsDetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/detail");

		String id = request.getParameter("id");

		Goods goods = GoodsService.getGoods(Integer.parseInt(id));

		mv.addObject("bean", goods);

		String html = FilePathHelper.getGoodsSummaryHtml(request, goods.getSummary());
		mv.addObject("html", html);

		return mv;
	}

	@RequestMapping("/goods-save.jspx")
	public ModelAndView productSave(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/tip");

		DataMap paramter = RequestUtils.getRequestDataMap();

		String goods_name = request.getParameter("goods_name");
		String goods_lname = request.getParameter("goods_lname");
		String type_level1 = request.getParameter("type_level1");
		String sort = request.getParameter("sort");
		String hot = request.getParameter("hot");
		String burst = request.getParameter("burst");
		String fashion = request.getParameter("fashion");
		String fashion_template = request.getParameter("fashion_template");
		String goods_area = request.getParameter("goods_area");
		String supplier = request.getParameter("supplier");
		String unit = request.getParameter("unit");
		String final_prices = request.getParameter("final_prices");
		String orgin_prices = request.getParameter("orgin_prices");
		String keywords = request.getParameter("keywords");
		String weight = request.getParameter("weight");

		String goods_des = request.getParameter("goods_des");
		String summary = request.getParameter("summary");
		String time = request.getParameter("time");
		
		//////////////////////////////////////////////////////////////
		String time_limit = request.getParameter("time_limit");
		String buy_limit = request.getParameter("buy_limit");
		String total_amount = request.getParameter("total_amount");
		String goods_limit_type = request.getParameter("goods_limit_type");
		String theme_type = request.getParameter("theme_type");
		/////////////////////////////////////////////////////////////////////////

		Goods goods = new Goods();
		goods.setBurst(paramter.getInt("burst", 0));
		goods.setGoodsName(goods_name);
		goods.setGoodsLname(goods_lname);
		goods.setTypeLevel1(type_level1);
		goods.setTypeLevel2(type_level1);
		goods.setSort(paramter.getInt("sort", 0));
		goods.setHot(paramter.getInt("hot", 0));
		goods.setFashion(paramter.getInt("fashion", 0));
		goods.setFashionTemplate(fashion_template);
		goods.setSummary(summary);
		goods.setUnit(unit);
		goods.setFinalPrices(paramter.getFloat("final_prices"));
		goods.setOrginPrices(paramter.getFloat("orgin_prices"));
		goods.setKeywords(keywords);
		goods.setGoodsStatus(1);
		goods.setGoodsDes(goods_des);
		goods.setSupplier(supplier);
		goods.setThemeType(theme_type);
		goods.setGoodsArea(goods_area);
		goods.setWeight(weight);

		try {
			String path = FilePathHelper.getGoodsSummaryHtmlPath();
			FileUtils.writeStringToFile(new File(FilePathHelper.getRealPath(request) + path), summary);
			goods.setSummary(path);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		GoodsService.addGoods(goods);

		String thumdPath = FilePathHelper.getImageThumdUploadPath(request);
		Collection<File> thumdFile = FileUtils.listFiles(new File(thumdPath), new String[] { "jpg" }, true);

		int index = 0;
		if (!thumdFile.isEmpty()) {
			File thumdImage = thumdFile.iterator().next();
			String newPath = FilePathHelper.getImageThumdToSavePath(String.valueOf(goods.getGoodsId()));
			try {
				newPath += (index + ".jpg");
				FileUtils.copyFile(thumdImage, new File(FilePathHelper.getRealPath(request) + newPath));
				GoodsService.updateGoodsThumdUrl(goods.getGoodsId(), newPath);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		

		try {
			GoodsLimit goodsLimit = new GoodsLimit();
			goodsLimit.setGoodsId(goods.getGoodsId());
			goodsLimit.setLimitType(Integer.parseInt(goods_limit_type));
			goodsLimit.setTotalAmount(Integer.parseInt(total_amount));
			goodsLimit.setBuyLimit(Integer.parseInt(buy_limit));
			goodsLimit.setTimeLimit(DateUtils.parseDate(time_limit, new String[]{"yyyy-MM-dd HH:mm"}));
			GoodsService.addGoodsLimit(goodsLimit);
			
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
	
		mv.addObject("msg", "添加成功");
		return mv;
	}

	@RequestMapping("/goods-delete.jspx")
	public @ResponseBody
	JSONResult deleteCustomer(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		try {

			String id = request.getParameter("id");

			if (StringUtils.isNotEmpty(id)) {
				this.GoodsService.deleteGoods(Integer.parseInt(id));
			}

			result = result.success();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = result.error("删除失败");
		}
		return result;
	}

	@RequestMapping("/goods-state.jspx")
	public @ResponseBody
	JSONResult stateGoods(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		try {

			String id = request.getParameter("id");
			String state = request.getParameter("state");

			if (StringUtils.isNotEmpty(id)) {
				this.GoodsService.updateGoodsState(Integer.parseInt(id), Integer.parseInt(state));
			}

			result = result.success();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = result.error("操作失败");
		}
		return result;
	}

	@RequestMapping("/goods-hot.jspx")
	public @ResponseBody
	JSONResult hotGoods(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		try {

			String id = request.getParameter("id");
			String state = request.getParameter("state");

			if (StringUtils.isNotEmpty(id)) {
				this.GoodsService.updateGoodsHot(Integer.parseInt(id), Integer.parseInt(state));
			}

			result = result.success();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = result.error("操作失败");
		}
		return result;
	}

	@RequestMapping("/goods-burst.jspx")
	public @ResponseBody
	JSONResult burstGoods(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		try {

			String id = request.getParameter("id");
			String state = request.getParameter("state");

			if (StringUtils.isNotEmpty(id)) {
				this.GoodsService.updateGoodsBurst(Integer.parseInt(id), Integer.parseInt(state));
			}

			result = result.success();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = result.error("操作失败");
		}
		return result;
	}

	@RequestMapping("/goods-fashion.jspx")
	public @ResponseBody
	JSONResult fashionGoods(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		try {

			String id = request.getParameter("id");
			String state = request.getParameter("state");

			if (StringUtils.isNotEmpty(id)) {
				this.GoodsService.updateGoodsFashion(Integer.parseInt(id), Integer.parseInt(state));
			}

			result = result.success();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = result.error("操作失败");
		}
		return result;
	}

	@RequestMapping("/goods-list-page.jspx")
	public @ResponseBody
	DataTableDataGrid listGoodsPage(HttpServletRequest request) {

		Pagination page = RequestUtils.getDataTablePagination(request);
		String draw = request.getParameter("draw");
		if (draw == null || draw.trim().length() == 0) {
			draw = "1";
		}

		DataMap paramter = new DataMap();

		RequestUtils.getRequestQueryParamter(request, paramter, "burst");
		RequestUtils.getRequestQueryParamter(request, paramter, "hot");
		RequestUtils.getRequestQueryParamter(request, paramter, "type_level2");
		RequestUtils.getRequestQueryParamter(request, paramter, "goods_status");
		RequestUtils.getRequestQueryParamter(request, paramter, "goods_name");
		RequestUtils.getRequestQueryParamter(request, paramter, "theme_type");

		page = GoodsService.getManageGoodsSearchList(paramter, page);

		DataTableDataGrid grid = new DataTableDataGrid(Integer.parseInt(draw), page, new Object[] { "goods_id", "goods_name", "goods_lname", "final_prices",
				"release_date", "goods_status", "hot", "burst", "fashion","theme_type" });

		return grid;
	}
	
	
	/**
	 * 
	 * fashion manage
	 * 
	 */
	
	@RequestMapping("/goods-fashion-list.jspx")
	public ModelAndView fashionlist(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/fashion-list");
		String id = request.getParameter("id");

		List<GoodsImage> list = GoodsService.getGoodsImageList(Integer.parseInt(id), BizConstants.IMAGE_TYPE_FASHION, 20);

		mv.addObject("list", list);
		mv.addObject("id", id);

		return mv;
	}

	@RequestMapping("/goods-fashion-add.jspx")
	public ModelAndView fashionadd(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/fashion-add");

		String time = String.valueOf(new Date().getTime());
		mv.addObject("time", time);
		
		String id = request.getParameter("id");
		mv.addObject("id", id);

		return mv;
	}
	
	@RequestMapping("/goods-fashion-del.jspx")
	public @ResponseBody
	JSONResult fashiondel(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		try {

			String id = request.getParameter("id");

			if (StringUtils.isNotEmpty(id)) {
				
				GoodsImage image = this.GoodsService.getGoodsImage(Integer.parseInt(id));
				String basePath = FilePathHelper.getRealPath(request);
				FileUtils.deleteQuietly(new File(basePath+image.getImageUrl()));
				this.GoodsService.deleteGoodsImage(Integer.parseInt(id));
			}

			result = result.success();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = result.error("删除失败");
		}
		return result;
	}
	

	@RequestMapping("/goods-fashion-sort.jspx")
	public @ResponseBody
	JSONResult fashionsort(HttpServletRequest request) {

		JSONResult result = new JSONResult();

		try {

			String id = request.getParameter("id");
			String type = request.getParameter("type");
			
			if (StringUtils.isNotEmpty(id)) {
				
				this.GoodsService.sortGoodsImage(Integer.parseInt(id),type);
	
			}

			result = result.success();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = result.error("删除失败");
		}
		return result;
	}
	
	

	@RequestMapping("/goods-fashion-save.jspx")
	public ModelAndView fashionSave(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/admin/goodslimit/tip");
		
		String goodsId = request.getParameter("id");
		
		String realPath = FilePathHelper.getGoodsFashionImageListToSavePath(goodsId);
		String basePath = FilePathHelper.getRealPath(request);
		String filename = new Date().getTime()+".jpg";
		
		try {
			FileUtils.writeByteArrayToFile(new File(basePath+realPath+"/"+filename), file.getBytes());
			
			GoodsImage image = new GoodsImage();
			image.setGoodsId(Integer.parseInt(goodsId));
			image.setImageType(BizConstants.IMAGE_TYPE_FASHION);
			image.setImageUrl(realPath+"/"+filename);
			this.GoodsService.insertGoodsImageList(image);
			
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
			logger.error(e.getMessage(),e);
			mv.addObject("msg", "添加失败");
		}
		
		mv.addObject("msg", "添加成功");
		
		return mv;
	}

}
