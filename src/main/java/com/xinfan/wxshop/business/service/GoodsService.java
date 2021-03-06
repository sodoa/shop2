package com.xinfan.wxshop.business.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.constants.SequenceConstants;
import com.xinfan.wxshop.business.dao.GoodsDao;
import com.xinfan.wxshop.business.dao.GoodsImageDao;
import com.xinfan.wxshop.business.dao.GoodsLimitDao;
import com.xinfan.wxshop.business.dao.GoodsTypeDao;
import com.xinfan.wxshop.business.dao.SequenceDao;
import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.business.entity.GoodsImage;
import com.xinfan.wxshop.business.entity.GoodsLimit;
import com.xinfan.wxshop.business.entity.GoodsType;
import com.xinfan.wxshop.business.helper.FilePathHelper;
import com.xinfan.wxshop.business.util.StringUtils;
import com.xinfan.wxshop.business.vo.GoodsVsLimitVO;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.cache.CacheHolder;
import com.xinfan.wxshop.common.cache.CacheProvider;
import com.xinfan.wxshop.common.page.Pagination;
import com.xinfan.wxshop.common.util.TimeUtils;

public class GoodsService {

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private GoodsLimitDao goodsLimitDao;

	@Autowired
	private GoodsTypeDao goodsTypeDao;

	@Autowired
	private GoodsImageDao goodsImageDao;

	@Autowired
	private SequenceDao sequenceDao;

	public void updateGoods(Goods goods) {

		if (goods.getTypeLevel2() != null) {
			GoodsType goodsType = goodsTypeDao.selectByPrimaryKey(goods.getTypeLevel2());
			goods.setTypeLevel1(goodsType.getpGoodstype());
		}

		this.goodsDao.updateByPrimaryKeySelective(goods);
	}

	public List<Goods> getMainTopBurstGoods(int size) {

		CacheProvider provider = CacheHolder.getInstance().getCacheProvider("exp_cache");

		List<Goods> list = (List<Goods>) provider.getAttribute("main_burst_goods");

		if (list == null) {
			Pagination page = new Pagination();
			page.setPageNo(1);
			page.setPageSize(size);

			DataMap map = new DataMap();
			map.put("burst", 1);
			list = goodsDao.pageBeanList(map, page);
			provider.setAttribute("main_burst_goods", (ArrayList) list, 24 * 60);
		}

		return list;
	}

	public List<Goods> getMainTopHotGoods(int size) {

		CacheProvider provider = CacheHolder.getInstance().getCacheProvider("exp_cache");

		List<Goods> list = (List<Goods>) provider.getAttribute("main_hot_goods");

		if (list == null) {
			Pagination page = new Pagination();
			page.setPageNo(1);
			page.setPageSize(size);

			DataMap map = new DataMap();
			map.put("hot", 1);
			list = goodsDao.pageBeanList(map, page);
			provider.setAttribute("main_hot_goods", (ArrayList) list, 24 * 60);
		}

		return list;
	}

	public List<GoodsImage> getGoodsImageList(int goodsId, int imageType, int size) {

		Pagination page = new Pagination();
		page.setPageNo(1);
		page.setPageSize(size);

		GoodsImage bean = new GoodsImage();
		bean.setGoodsId(goodsId);
		bean.setImageType(imageType);

		return goodsImageDao.pageList(bean, page);

	}

	public List<GoodsType> getGoodsType() {

		return goodsTypeDao.selectAll();
	}

	public List<DataMap> getTopShowGoodsList() {
		Pagination page = new Pagination();
		page.setPageNo(1);
		page.setPageSize(6);
		DataMap map = new DataMap();
		List<DataMap> list = goodsDao.pageList(map, page);
		return list;
	}

	public List<Goods> getTopHotGoodsList() {
		Pagination page = new Pagination();
		page.setPageNo(1);
		page.setPageSize(10);
		DataMap map = new DataMap();
		map.put("host", "1");
		map.put("goodsStatus", "1");
		map.put("no_theme_type", "20");
		List<Goods> list = goodsDao.pageBeanList(map, page);
		return list;
	}

	public List<Goods> getTopBurstGoodsList() {
		Pagination page = new Pagination();
		page.setPageNo(1);
		page.setPageSize(10);
		DataMap map = new DataMap();
		map.put("burst", "1");
		map.put("goodsStatus", "1");
		map.put("no_theme_type", "20");
		List<Goods> list = goodsDao.pageBeanList(map, page);
		return list;
	}

	public List<Goods> getGoodsClassifySerchList(DataMap param, Pagination page) {

		param.put("goodsStatus", "1");
		List<Goods> list = goodsDao.pageBeanList(param, page);

		return list;
	}

	public List<Goods> getGoodsKeyWordsSerchList(String keywords, String theme, Pagination page) {

		keywords = StringUtils.stringFilter(keywords);
		theme = StringUtils.stringFilter(theme);

		DataMap param = new DataMap();
		param.put("goodsStatus", "1");
		param.put("goodsName", keywords);
		param.put("theme_type", theme);
		List<Goods> list = goodsDao.pageBeanList(param, page);

		return list;
	}

	public List<GoodsVsLimitVO> getGoodsLimitKeyWordsSerchList(String keywords, String theme, Pagination page) {

		keywords = StringUtils.stringFilter(keywords);
		theme = StringUtils.stringFilter(theme);

		DataMap param = new DataMap();
		param.put("goodsStatus", "1");
		param.put("goodsName", keywords);
		param.put("theme_type", theme);
		List<GoodsVsLimitVO> list = goodsDao.getGoodsLimitKeyWordsSerchList(param, page);

		return list;
	}

	public List<Goods> getGoodsBurstList(DataMap param, Pagination page) {

		param.put("goodsStatus", "1");
		param.put("burst", "1");

		List<Goods> list = goodsDao.pageBeanList(param, page);

		return list;
	}

	public Pagination getManageGoodsSearchList(DataMap param, Pagination page) {

		List<Goods> list = goodsDao.getManageGoodsSearchList(param, page);
		page.setList(list);

		return page;
	}

	public void deleteGoods(int id) {
		goodsDao.deleteByPrimaryKey(id);
	}

	public void deleteGoodsImage(int id) {
		this.goodsImageDao.deleteByPrimaryKey(id);
	}

	public void addCopyGoods(HttpServletRequest request, int id) {
		Goods goods = this.goodsDao.selectByPrimaryKey(id);
		String basePath = FilePathHelper.getRealPath(request);

		if (goods != null) {
			int newGoodsId = this.sequenceDao.getSequence(SequenceConstants.SEQ_GOODS);
			goods.setGoodsId(newGoodsId);

			String newImageThumdPath = FilePathHelper.getImageThumdToSavePath(String.valueOf(goods.getGoodsId())) + "0.jpg";
			try {
				FileUtils.copyFile(new File(basePath + goods.getThumbnailUrl()), new File(basePath + newImageThumdPath));
				goods.setThumbnailUrl(newImageThumdPath);
			} catch (IOException e1) {
				e1.printStackTrace();
				goods.setThumbnailUrl("");
			}

			String GoodsSummaryHtmlPath = FilePathHelper.getGoodsSummaryHtmlPath();
			try {
				FileUtils.copyFile(new File(basePath + goods.getSummary()), new File(basePath + GoodsSummaryHtmlPath));
				goods.setSummary(GoodsSummaryHtmlPath);
			} catch (IOException e1) {
				e1.printStackTrace();
				goods.setSummary("");
			}
			
			goods.setReleaseDate(new Date());
			goods.setGoodsStatus(1);

			this.goodsDao.insertSelective(goods);

			List<GoodsImage> goodsImages = this.goodsImageDao.selectByGoodsImageList(id);
			for (GoodsImage image : goodsImages) {
				image.setgImageId(this.sequenceDao.getSequence(SequenceConstants.SEQ_GOODS_IMAGE));
				image.setGoodsId(newGoodsId);

				String newImagePath = FilePathHelper.getGoodsImageListToSavePath("" + newGoodsId);

				String filename = newImagePath + "/" + new Date().getTime() + ".jpg";
				try {
					FileUtils.copyFile(new File(basePath + image.getImageUrl()), new File(basePath + "/" + filename));
					image.setImageUrl(filename);
					this.goodsImageDao.insertSelective(image);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void sortGoodsImage(int id, String type) {
		GoodsImage images = goodsImageDao.selectByPrimaryKey(id);

		int sort = "1".equals(type) ? (images.getSort() + 1) : (images.getSort() - 1);
		if (sort < 0) {
			sort = 0;
		}

		GoodsImage update = new GoodsImage();
		update.setSort(sort);
		update.setgImageId(images.getgImageId());

		this.goodsImageDao.updateByPrimaryKeySelective(update);

	}

	public void addGoods(Goods goods) {

		goods.setReleaseDate(TimeUtils.getCurrentTime());
		goods.setGoodsStatus(0);

		if (goods.getTypeLevel2() != null) {
			GoodsType goodsType = goodsTypeDao.selectByPrimaryKey(goods.getTypeLevel2());
			goods.setTypeLevel1(goodsType.getpGoodstype());
		}

		float finalPrices = goods.getFinalPrices();
		float orginPrices = goods.getOrginPrices();

		float discount = Float.parseFloat(new java.text.DecimalFormat("#.0").format(new Float((finalPrices / orginPrices)) * 10));

		goods.setDiscount(discount);

		goods.setGoodsId(sequenceDao.getSequence(SequenceConstants.SEQ_GOODS));

		this.goodsDao.insertSelective(goods);
	}

	public void updateGoodsLimit(GoodsLimit goods) {
		goodsLimitDao.updateByPrimaryKeySelective(goods);
	}

	public void addGoodsLimit(GoodsLimit goods) {

		goods.setSellAmount(0);

		this.goodsLimitDao.insertSelective(goods);
	}

	public void updateGoodsThumdUrl(int id, String url) {
		Goods goods = new Goods();
		goods.setGoodsId(id);
		goods.setThumbnailUrl(url);
		this.goodsDao.updateByPrimaryKeySelective(goods);
	}

	public void insertGoodsImageList(GoodsImage bean) {
		bean.setgImageId(this.sequenceDao.getSequence(SequenceConstants.SEQ_GOODS_IMAGE));
		bean.setSort(1);
		this.goodsImageDao.insertSelective(bean);
	}

	public void updateGoodsState(int id, int state) {
		Goods update = new Goods();
		update.setGoodsId(id);
		update.setGoodsStatus(state);
		goodsDao.updateByPrimaryKeySelective(update);
	}

	public void updateGoodsHot(int id, int state) {
		Goods update = new Goods();
		update.setGoodsId(id);
		update.setHot(state);
		goodsDao.updateByPrimaryKeySelective(update);
	}

	public void updateGoodsBurst(int id, int state) {
		Goods update = new Goods();
		update.setGoodsId(id);
		update.setBurst(state);
		goodsDao.updateByPrimaryKeySelective(update);
	}

	public void updateGoodsFashion(int id, int state) {
		Goods update = new Goods();
		update.setGoodsId(id);
		update.setFashion(state);
		goodsDao.updateByPrimaryKeySelective(update);
	}

	public Goods getGoods(int goodsId) {
		Goods goods = goodsDao.selectByPrimaryKey(goodsId);
		return goods;
	}

	public GoodsLimit getGoodsLimit(int goodsId) {
		GoodsLimit goods = goodsLimitDao.selectByPrimaryKey(goodsId);
		return goods;
	}

	public GoodsImage getGoodsImage(int id) {
		GoodsImage goods = this.goodsImageDao.selectByPrimaryKey(id);
		return goods;
	}

}
