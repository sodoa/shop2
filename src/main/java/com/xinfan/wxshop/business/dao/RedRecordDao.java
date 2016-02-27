/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.RedRecord;
import com.xinfan.wxshop.business.entity.RedRecordExample;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class RedRecordDao extends SqlSessionDaoSupport {

	public List<RedRecord> selectAll() {
		RedRecordExample example = new RedRecordExample();
		example.setOrderByClause("lined desc ");
		return getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}

	public RedRecord selectByPrimaryKey(int key) {
		return getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), key);
	}

	public void updateByPrimaryKeySelective(RedRecord record) {
		getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), record);
	}

	public int insertSelective(RedRecord record) {
		return getSqlSession().insert(wrapCommand("insertSelective"), record);
	}

	public List<RedRecord> selectByMsgId(RedRecord record) {
		RedRecordExample example = new RedRecordExample();
		example.createCriteria().andMsgidEqualTo(record.getMsgid()).andLinedEqualTo(record.getLined());
		return getSqlSession().selectList(wrapCommand("selectByExample"), record);
	}

}
