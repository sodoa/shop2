/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.Love;
import com.xinfan.wxshop.business.entity.LoveExample;
import com.xinfan.wxshop.common.base.DataMap;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;
import com.xinfan.wxshop.common.page.Pagination;

public class LoveDao extends SqlSessionDaoSupport {

	public int updateByPrimaryKeySelective(Love pojo) {
		return getSqlSession().update(
				wrapCommand("updateByPrimaryKeySelective"), pojo);
	}

	public int insertSelective(Love pojo) {
		return getSqlSession().update(wrapCommand("insertSelective"), pojo);
	}

	public int deleteByPrimaryKey(int id) {
		return getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), id);
	}

	public Love selectByPrimaryKey(int id) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}

	public List pageList(int customerId, Pagination page) {
		DataMap map = new DataMap();
		map.put("customerId", customerId);
		return getSqlSession().selectList(wrapCommand("pageList"),map, page);
	}

	public Love selectByBizKey(int goodsId, int customerId) {

		LoveExample example = new LoveExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId)
				.andCustomerIdEqualTo(customerId);

		return getSqlSession().selectOne(wrapCommand("selectByExample"),
				example);
	}

}
