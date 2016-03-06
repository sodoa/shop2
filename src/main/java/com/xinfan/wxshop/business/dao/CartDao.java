/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.Cart;
import com.xinfan.wxshop.business.entity.CartExample;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;
import com.xinfan.wxshop.common.page.Pagination;

public class CartDao extends SqlSessionDaoSupport {

	public List<DataMap> pageList(DataMap map, Pagination page) {
		return getSqlSession().selectList(wrapCommand("pageList"), map, page);
	}

	public int updateByPrimaryKeySelective(Cart pojo) {
		return getSqlSession().update(
				wrapCommand("updateByPrimaryKeySelective"), pojo);
	}

	public int insertSelective(Cart pojo) {
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}

	public int deleteByPrimaryKey(int id) {
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}

	public Cart selectByPrimaryKey(int id) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}

	public List<Cart> selectCartListBySessionIdIdAndGoodsId(String sessionId,int goodsId) {

		CartExample example = new CartExample();
		example.createCriteria().andSessionidEqualTo(sessionId).andGoodsIdEqualTo(goodsId);
		return getSqlSession().selectList(wrapCommand("selectByExample"),
				example);
	}
	
	public List<Cart> selectCartListByCustomerId(int id) {

		CartExample example = new CartExample();
		example.createCriteria().andCustomerIdEqualTo(id);
		return getSqlSession().selectList(wrapCommand("selectByExample"),
				example);
	}
	
	public List<Cart> selectCartListBySessionId(String id) {

		CartExample example = new CartExample();
		example.createCriteria().andSessionidEqualTo(id);
		return getSqlSession().selectList(wrapCommand("selectByExample"),
				example);
	}
	
	public int deleteCartListByCustomerId(int id) {

		CartExample example = new CartExample();
		example.createCriteria().andCustomerIdEqualTo(id);
		return getSqlSession().delete(wrapCommand("deleteByExample"),
				example);
	}
	
	public int deleteCartListBySessionId(String id) {

		CartExample example = new CartExample();
		example.createCriteria().andSessionidEqualTo(id);
		return getSqlSession().delete(wrapCommand("deleteByExample"),
				example);
	}
	

}
