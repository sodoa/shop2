/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinfan.wxshop.business.entity.Appraise;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;
import com.xinfan.wxshop.common.page.Pagination;

public class AppraiseDao extends SqlSessionDaoSupport {

	public int updateByPrimaryKeySelective(Appraise pojo) {
		return getSqlSession().update(
				wrapCommand("updateByPrimaryKeySelective"), pojo);
	}

	public int insertSelective(Appraise pojo) {
		return getSqlSession().insert(wrapCommand("insertSelective"), pojo);
	}

	public int deleteByPrimaryKey(int id) {
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}

	public Appraise selectByPrimaryKey(int id) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}
	
	public List pageList(int goodsId, Pagination page) {
		
		Map param = new HashMap();
		param.put("goodsId", goodsId);
		
		return getSqlSession().selectList(wrapCommand("pageList"),
				param, page);
	}
	
}
