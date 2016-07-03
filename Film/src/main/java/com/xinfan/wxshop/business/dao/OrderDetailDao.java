/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.OrderDetail;
import com.xinfan.wxshop.business.entity.OrderDetailExample;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;
import com.xinfan.wxshop.common.page.Pagination;

public class OrderDetailDao extends SqlSessionDaoSupport {

	public List<DataMap> pageList(DataMap map ,Pagination page) {
		return getSqlSession().selectList(wrapCommand("pageList"), map,page);
	}

	public int updateByPrimaryKeySelective(OrderDetail pojo) {
		return getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), pojo);
	}
	
	public  int insertSelective(OrderDetail pojo){
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}
	
	public  int deleteByPrimaryKey(int id){
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}
	
	public  OrderDetail selectByPrimaryKey(int id){
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}
	
	public  List<OrderDetail> selectByOrderId(int id){
		OrderDetailExample example = new OrderDetailExample();
		example.createCriteria().andOrderIdEqualTo(id);
		example.setOrderByClause(" detail_id desc ");
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}
	
}
