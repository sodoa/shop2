/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.Date;
import java.util.List;

import com.xinfan.wxshop.business.entity.Distribution;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;
import com.xinfan.wxshop.common.page.Pagination;

public class DistributionDao extends SqlSessionDaoSupport {

	public List<DataMap> pageList(DataMap map ,Pagination page) {
		return getSqlSession().selectList(wrapCommand("pageList"), map,page);
	}
	
	public List<DataMap> pageSelectDistributionList(DataMap map ,Pagination page) {
		return getSqlSession().selectList(wrapCommand("pageSelectDistributionList"), map,page);
	}

	public int updateByPrimaryKeySelective(Distribution pojo) {
		return getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), pojo);
	}
	
	public  int insertSelective(Distribution pojo){
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}
	
	public  int deleteByPrimaryKey(int id){
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}
	
	public  Distribution selectByPrimaryKey(int id){
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}
	
	public Integer count(DataMap map) {
		return getSqlSession().selectOne(wrapCommand("count"), map);
	}
	
	public  List<DataMap> selectTopListByExample(int customerId,int top){
		
		DataMap map = new DataMap();
		map.put("customerId", customerId);
		map.put("top", top);
		
		return getSqlSession().selectList(wrapCommand("selectTopListByExample"), map);
	}
	
	public  List<Distribution> pageBeanSelectDistributionList(int uplineId,Date consumeDate,Pagination page){
		
		DataMap map = new DataMap();
		map.put("consumeDate", consumeDate);
		map.put("uplineId", uplineId);
		
		return getSqlSession().selectList(wrapCommand("pageBeanSelectDistributionList"), map,page);
	}
	
	public  List<Distribution> pageBeanSelectVirtualDistributionList(int uplineId,String virtual,Pagination page){
		
		DataMap map = new DataMap();
		map.put("uplineId", uplineId);
		map.put("virtual", virtual);
		
		return getSqlSession().selectList(wrapCommand("pageBeanSelectDistributionList"), map,page);
	}
	
	
	//pageBeanSelectDistributionList
	
}
