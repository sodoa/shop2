/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.DistrRank;
import com.xinfan.wxshop.business.entity.DistrRankExample;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class DistrRankDao extends SqlSessionDaoSupport {

	public List<DistrRank> getDistrRankListByType(String type) {
		DistrRankExample example = new DistrRankExample();
		example.createCriteria().andTypeEqualTo(type);
		example.setOrderByClause(" level1count desc");

		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}


}
