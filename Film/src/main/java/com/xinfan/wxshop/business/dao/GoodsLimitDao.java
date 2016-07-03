/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import com.xinfan.wxshop.business.entity.GoodsLimit;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class GoodsLimitDao extends SqlSessionDaoSupport {

	public int updateByPrimaryKeySelective(GoodsLimit pojo) {
		return getSqlSession().update(
				wrapCommand("updateByPrimaryKeySelective"), pojo);
	}

	public int insertSelective(GoodsLimit pojo) {
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}

	public int deleteByPrimaryKey(int id) {
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}

	public GoodsLimit selectByPrimaryKey(int id) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}


}
