/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.xinfan.wxshop.business.entity.Order;
import com.xinfan.wxshop.business.entity.OrderExample;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;
import com.xinfan.wxshop.common.page.Pagination;

public class OrderDao extends SqlSessionDaoSupport {

	public List<DataMap> pageList(DataMap map ,Pagination page) {
		return getSqlSession().selectList(wrapCommand("pageList"), map,page);
	}
	
	public List<DataMap> pageOrderList(DataMap map ,Pagination page) {
		return getSqlSession().selectList(wrapCommand("pageOrderList"), map,page);
	}
	
	public List<DataMap> getOrderGoodsStaticSummary(DataMap map) {
		return getSqlSession().selectList(wrapCommand("getOrderGoodsStaticSummary"), map);
	}
	
	public int updateByPrimaryKeySelective(Order pojo) {
		return getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), pojo);
	}
	
	public  int insertSelective(Order pojo){
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}
	
	public  int deleteByPrimaryKey(int id){
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}
	
	public  Order selectByPrimaryKey(int id){
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}
	
	public  List<Order> selectUnPurchaseOrderList(Date endtime,int status){
		OrderExample example = new OrderExample();
		example.createCriteria().andOrderDateLessThanOrEqualTo(endtime).andStatusEqualTo(status);
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}
	
	public  List<Order> selectByBizKey(String orderNo){
		OrderExample example = new OrderExample();
		example.createCriteria().andOrderNoEqualTo(orderNo);
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}
	
	public Integer count(DataMap map) {
		return getSqlSession().selectOne(wrapCommand("count"), map);
	}
	
	public  List<Order> selectTopListByExample(int customerId,int top){
		
		DataMap map = new DataMap();
		map.put("customerId", customerId);
		map.put("top", top);
		
		return getSqlSession().selectList(wrapCommand("selectTopListByExample"), map);
	}
	
	
	public  Pagination  getCustomerCenterOrderPageList(Map param,Pagination page){
		
		List<Order> list = getSqlSession().selectList(
				wrapCommand("getCustomerCenterOrderPageList"), param, page);
		
		page.setList(list);
		
		return page;
	}
	
	
	
	//
	
	
	
}
