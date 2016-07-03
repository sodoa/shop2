/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.Article;
import com.xinfan.wxshop.business.entity.ArticleExample;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class ArticleDao extends SqlSessionDaoSupport {

	public List<Article> selectByClassify(String type) {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andClassifyEqualTo(type);
		example.setOrderByClause("releasedate desc");
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}

	public List<Article> selectAll() {
		ArticleExample example = new ArticleExample();
		example.setOrderByClause("releasedate desc");
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}

	public int insertSelective(Article record) {

		return getSqlSession().insert(wrapCommand("insertSelective"), record);
	}

	public List<Article> selectByExample(ArticleExample example) {
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}

	public Article selectByPrimaryKey(Integer id) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}

	public int deleteByPrimaryKey(Integer id) {
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}

	public int updateByPrimaryKeySelective(Article record) {
		return getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), record);
	}

	public int updateByPrimaryKey(Article record) {
		return getSqlSession().update(wrapCommand("updateByPrimaryKey"), record);
	}
}
