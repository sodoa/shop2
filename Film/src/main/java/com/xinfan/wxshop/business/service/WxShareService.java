package com.xinfan.wxshop.business.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.dao.WxShareDao;
import com.xinfan.wxshop.business.entity.WxShare;
import com.xinfan.wxshop.common.util.TimeUtils;

public class WxShareService {

	@Autowired
	private WxShareDao wxShareDao;

	public void addWxMapping(String wxid, int fromid) {

		if (wxid != null && wxid.length() > 0) {
			WxShare exist = wxShareDao.selectByPrimaryKey(wxid);
			if (exist != null) {
				wxShareDao.deleteByPrimaryKey(wxid);
			}
			WxShare insert = new WxShare();
			insert.setCreatedate(TimeUtils.getCurrentTime());
			insert.setWxid(wxid);
			insert.setFromid(fromid);
			wxShareDao.insertSelective(insert);
		}
	}

	public void delWxMapping(String wxid) {
		wxShareDao.deleteByPrimaryKey(wxid);
	}

	public int getWxMapping(String wxid) {
		WxShare bean = wxShareDao.selectByPrimaryKey(wxid);
		if (bean == null) {
			return 0;
		}

		Integer fromid = bean.getFromid();
		if (fromid == null) {
			return 0;
		}

		return bean.getFromid();
	}

}
