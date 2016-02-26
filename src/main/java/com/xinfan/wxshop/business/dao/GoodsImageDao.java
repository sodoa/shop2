/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinfan.wxshop.business.entity.GoodsImage;
import com.xinfan.wxshop.business.entity.GoodsImageExample;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;
import com.xinfan.wxshop.common.page.Pagination;

public class GoodsImageDao extends SqlSessionDaoSupport {

	public int updateByPrimaryKeySelective(GoodsImage pojo) {
		return getSqlSession().update(
				wrapCommand("updateByPrimaryKeySelective"), pojo);
	}

	public int insertSelective(GoodsImage pojo) {
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}

	public int deleteByPrimaryKey(int id) {
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}

	public GoodsImage selectByPrimaryKey(int id) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}

	public List<GoodsImage> pageList(GoodsImage bean, Pagination page) {
		GoodsImageExample example = new GoodsImageExample();
		example.createCriteria().andGoodsIdEqualTo(bean.getGoodsId())
				.andImageTypeEqualTo(bean.getImageType());
		example.setOrderByClause(" sort desc");
		
		Map map = new HashMap();
		map.put("goodsId", bean.getGoodsId());
		map.put("imageType", bean.getImageType());
		
		return getSqlSession().selectList(wrapCommand("pageList"),
				bean);
	}

}
