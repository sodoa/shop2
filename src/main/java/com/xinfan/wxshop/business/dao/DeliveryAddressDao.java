/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinfan.wxshop.business.entity.DeliveryAddress;
import com.xinfan.wxshop.business.entity.DeliveryAddressExample;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;
import com.xinfan.wxshop.common.page.Pagination;

public class DeliveryAddressDao extends SqlSessionDaoSupport {

	public List<DataMap> pageList(DataMap map, Pagination page) {
		return getSqlSession().selectList(wrapCommand("pageList"), map, page);
	}

	public int updateByPrimaryKeySelective(DeliveryAddress pojo) {
		return getSqlSession().update(
				wrapCommand("updateByPrimaryKeySelective"), pojo);
	}

	public int updateByExampleSelective(DeliveryAddress pojo,
			DeliveryAddressExample example) {

		Map map = new HashMap();
		map.put("record", pojo);
		map.put("example", example);

		return getSqlSession().update(wrapCommand("updateByExampleSelective"),
				map);
	}

	public int insertSelective(DeliveryAddress pojo) {
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}

	public int deleteByPrimaryKey(int id) {
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}

	public DeliveryAddress selectByPrimaryKey(int id) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}

	public List<DeliveryAddress> selectByExample(DeliveryAddressExample example) {
		return getSqlSession().selectList(wrapCommand("selectByExample"),
				example);
	}

	public DeliveryAddress selectTopOneByCustomerId(int customerId) {

		DeliveryAddressExample example = new DeliveryAddressExample();
		example.createCriteria().andCustomerIdEqualTo(customerId);
		example.setOrderByClause(" sort desc");

		List<DeliveryAddress> list = getSqlSession().selectList(
				wrapCommand("selectByExample"), example);

		if (list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}

	public List<DeliveryAddress> selectTopListByExample(int customerId, int top) {

		DataMap map = new DataMap();
		map.put("customerId", customerId);
		map.put("top", top);

		return getSqlSession().selectList(
				wrapCommand("selectTopListByExample"), map);
	}

}
