package com.xinfan.wxshop.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.constants.BizConstants;
import com.xinfan.wxshop.business.dao.GoodsTypeDao;
import com.xinfan.wxshop.business.entity.GoodsType;
import com.xinfan.wxshop.common.cache.CacheHelper;

public class GoodsTypeService {

	@Autowired
	private GoodsTypeDao goodsTypeDao;

	public List<GoodsType> getAll() {
		return goodsTypeDao.selectAll();
	}

	public GoodsType getGoodsType(String id) {
		return goodsTypeDao.selectByPrimaryKey(id);
	}

	public int updateGoodsType(GoodsType bean) {
		
		GoodsType goodsType = goodsTypeDao.selectByPrimaryKey(bean.getGoodstype());
		if(bean.getGoodstype()!=null && !bean.getGoodstype().equals(goodsType.getGoodstype())){
			List<GoodsType> list = goodsTypeDao.selectSubGoodsType(goodsType.getGoodstype());
			for(GoodsType subType : list){
				subType.setpGoodstype(bean.getGoodstype());
				this.updateGoodsType(bean);
			}
		}
		
		int size = goodsTypeDao.updateByPrimaryKeySelective(bean);

		CacheHelper.getInstance().refresh(BizConstants.CACHE_KEY_GOODSTYPE_CACHE);

		return size;
	}

	public int deleteGoodsType(String id) {
		
		List<GoodsType> list = goodsTypeDao.selectSubGoodsType(id);
		for(GoodsType subType : list){
			goodsTypeDao.deleteByPrimaryKey(subType.getGoodstype());
		}

		int size = goodsTypeDao.deleteByPrimaryKey(id);
		CacheHelper.getInstance().refresh(BizConstants.CACHE_KEY_GOODSTYPE_CACHE);

		return size;
	}

	public int insertGoodsType(GoodsType bean) {

		int size = goodsTypeDao.insertSelective(bean);
		CacheHelper.getInstance().refresh(BizConstants.CACHE_KEY_GOODSTYPE_CACHE);
		return size;
	}

}
