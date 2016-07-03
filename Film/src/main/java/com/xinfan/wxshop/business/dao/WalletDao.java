/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.Customer;
import com.xinfan.wxshop.business.entity.Wallet;
import com.xinfan.wxshop.business.entity.WalletExample;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;
import com.xinfan.wxshop.common.page.Pagination;

public class WalletDao extends SqlSessionDaoSupport {

	public List<DataMap> pageList(DataMap map ,Pagination page) {
		return getSqlSession().selectList(wrapCommand("pageList"), map,page);
	}

	public int updateByPrimaryKeySelective(Wallet pojo) {
		return getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), pojo);
	}
	
	public  int insertSelective(Wallet pojo){
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}
	
	public  int deleteByPrimaryKey(int id){
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}
	
	public  Wallet selectByPrimaryKey(int id){
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}
	
	
	public  Wallet selectByCustomerIdKey(int id){
		
		WalletExample example = new WalletExample();
		example.createCriteria().andCustomerIdEqualTo(id);
		List<Wallet> list = getSqlSession().selectList(
				wrapCommand("selectByExample"), example);

		return list.isEmpty() ? null : list.get(0);
	}
}
