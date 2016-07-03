/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.SearchWords;
import com.xinfan.wxshop.business.entity.SearchWordsExample;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class SearchWordsDao extends SqlSessionDaoSupport {

	public int deleteByKey(String key) {
		SearchWordsExample example = new SearchWordsExample();
		example.createCriteria().andWordsEqualTo(key);
		return getSqlSession().delete(wrapCommand("deleteByExample"), example);
	}

	public int insertSelective(SearchWords record) {
		return getSqlSession().insert(wrapCommand("insertSelective"), record);
	}

	public List<SearchWords> selectAll() {
		SearchWordsExample example = new SearchWordsExample();
		example.setOrderByClause("sort desc ");
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}

}
