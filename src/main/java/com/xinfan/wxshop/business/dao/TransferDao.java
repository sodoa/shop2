/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import com.xinfan.wxshop.business.entity.Transfer;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class TransferDao extends SqlSessionDaoSupport {

	public int updateByPrimaryKeySelective(Transfer pojo) {
		return getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), pojo);
	}
	
	public  int insertSelective(Transfer pojo){
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}
	
	public  int deleteByPrimaryKey(int id){
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}
	
	public  Transfer selectByPrimaryKey(int id){
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}

}
