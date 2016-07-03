/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import com.xinfan.wxshop.business.entity.WxShare;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class WxShareDao extends SqlSessionDaoSupport {

	public int insertSelective(WxShare pojo) {
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}

	public int deleteByPrimaryKey(String wxid) {
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), wxid);
	}

	public WxShare selectByPrimaryKey(String wxid) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), wxid);
	}

}
