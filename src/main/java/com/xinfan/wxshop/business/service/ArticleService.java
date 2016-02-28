package com.xinfan.wxshop.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.constants.SequenceConstants;
import com.xinfan.wxshop.business.dao.ArticleDao;
import com.xinfan.wxshop.business.dao.SequenceDao;
import com.xinfan.wxshop.business.entity.Article;
import com.xinfan.wxshop.common.util.TimeUtils;

public class ArticleService {

	@Autowired
	private ArticleDao ArticleDao;

	@Autowired
	private SequenceDao SequenceDao;

	public List<Article> getManageList(String classify) {
		if (classify == null || classify.trim().length() == 0) {

			return ArticleDao.selectAll();
		}

		return ArticleDao.selectByClassify(classify);
	}

	public void insertSelective(Article record) {

		int id = SequenceDao.getSequence(SequenceConstants.SEQ_ARTICLE);
		record.setId(id);
		record.setReleasedate(TimeUtils.getCurrentTime());

		ArticleDao.insertSelective(record);

	}

	public Article selectByPrimaryKey(Integer id) {
		return ArticleDao.selectByPrimaryKey(id);
	}

	public void deleteByPrimaryKey(Integer id) {
		ArticleDao.deleteByPrimaryKey(id);
	}

	public void updateByPrimaryKeySelective(Article record) {
		ArticleDao.updateByPrimaryKeySelective(record);
	}

	public void updateByPrimaryKey(Article record) {
		ArticleDao.updateByPrimaryKey(record);
	}

}
