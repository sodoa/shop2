/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.Goods;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;
import com.xinfan.wxshop.common.page.Pagination;

public class GoodsDao extends SqlSessionDaoSupport {

	public List<DataMap> pageList(DataMap map ,Pagination page) {
		return getSqlSession().selectList(wrapCommand("pageList"), map,page);
	}
	
	public List<Goods> pageBeanList(DataMap map ,Pagination page) {
		return getSqlSession().selectList(wrapCommand("pageBeanList"), map,page);
	}
	
	public List<Goods> getManageGoodsSearchList(DataMap map ,Pagination page) {
		return getSqlSession().selectList(wrapCommand("getManageGoodsSearchList"), map,page);
	}

	public int updateByPrimaryKeySelective(Goods pojo) {
		return getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), pojo);
	}
	
	public  int insertSelective(Goods pojo){
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}
	
	public  int deleteByPrimaryKey(int id){
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}
	
	public  Goods selectByPrimaryKey(int id){
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}
	
	public int updateGoodsSellCountByPrimaryKey(Goods pojo) {
		return getSqlSession().update(wrapCommand("updateGoodsSellCountByPrimaryKey"), pojo);
	}
	
}
