package com.xinfan.wxshop.business.vo;

import java.util.ArrayList;
import java.util.List;

import com.xinfan.wxshop.business.entity.Ranking;

public class RankList {

	public String name;

	public Integer id;
	
	public Integer sort;

	public List<Ranking> list;
	
	
	
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public RankList(){
		this.list = new ArrayList<Ranking>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Ranking> getList() {
		return list;
	}

	public void setList(List<Ranking> list) {
		this.list = list;
	}

}
