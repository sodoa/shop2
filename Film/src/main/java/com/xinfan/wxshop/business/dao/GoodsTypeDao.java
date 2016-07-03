/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.GoodsType;
import com.xinfan.wxshop.business.entity.GoodsTypeExample;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class GoodsTypeDao extends SqlSessionDaoSupport {

	public List<GoodsType> selectAll() {

		GoodsTypeExample example = new GoodsTypeExample();
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}
	
	public List<GoodsType> selectSubGoodsType(String id) {
		GoodsTypeExample example = new GoodsTypeExample();
		example.createCriteria().andPGoodstypeEqualTo(id);
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}

	public int updateByPrimaryKeySelective(GoodsType pojo) {
		return getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), pojo);
	}

	public int insertSelective(GoodsType pojo) {
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}

	public int deleteByPrimaryKey(String id) {
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}

	public GoodsType selectByPrimaryKey(String id) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}

}
