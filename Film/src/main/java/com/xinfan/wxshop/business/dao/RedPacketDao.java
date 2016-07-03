/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.RedPacket;
import com.xinfan.wxshop.business.entity.RedPacketExample;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class RedPacketDao extends SqlSessionDaoSupport {

	public List<RedPacket> selectAll() {
		RedPacketExample example = new RedPacketExample();
		example.setOrderByClause("lined desc ");
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}

	public RedPacket selectByPrimaryKey(String key) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), key);
	}

	public void updateByPrimaryKeySelective(RedPacket record) {
		getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), record);
	}
	
}
