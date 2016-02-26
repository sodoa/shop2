/**
 * 
 */
package com.xinfan.wxshop.business.dao;

import java.util.List;

import com.xinfan.wxshop.business.entity.Area;
import com.xinfan.wxshop.business.entity.AreaExample;
import com.xinfan.wxshop.common.dal.SqlSessionDaoSupport;

public class AreaDao extends SqlSessionDaoSupport {
	
	public List<Area> selectAll() {

		AreaExample example = new AreaExample();
		return getSqlSession().selectList(wrapCommand("selectByExample"),
				example);
	}

}
