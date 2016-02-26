/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.Ranking;
import com.xinfan.wxshop.business.entity.RankingExample;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class RankingDao extends SqlSessionDaoSupport {

	public int updateByPrimaryKeySelective(Ranking pojo) {
		return getSqlSession().update(
				wrapCommand("updateByPrimaryKeySelective"), pojo);
	}
	
	public List<Ranking> selectAllList() {
		
		RankingExample example = new RankingExample();
		
		return getSqlSession().selectList(
				wrapCommand("selectByExample"), example);
	}
	

	public int insertSelective(Ranking pojo) {
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}

	public int deleteByPrimaryKey(int id) {
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}

	public Ranking selectByPrimaryKey(int id) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}

}
