/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.IncomeRank;
import com.xinfan.wxshop.business.entity.IncomeRankExample;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class IncomeRankDao extends SqlSessionDaoSupport {

	public List<IncomeRank> getListByRankDate(String date) {

		IncomeRankExample example = new IncomeRankExample();
		example.createCriteria().andRankDateEqualTo(date);
		example.setOrderByClause(" total_income desc ");
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}
	

}
