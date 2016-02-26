package com.xinfan.wxshop.business.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.dao.RankingDao;
import com.xinfan.wxshop.business.entity.Ranking;
import com.xinfan.wxshop.business.vo.RankList;

public class RankingService {

	@Autowired
	private RankingDao rankDao;

	public List<RankList> getRankingTopList(int size){
		
		List<RankList> list = new ArrayList<RankList>();
		
		Map<Integer,String> keys = new HashMap<Integer,String>();
		
		List<Ranking> rList = rankDao.selectAllList();
		for(Ranking r : rList){
			if(keys.containsKey(r.getGoodstype())){
				RankList rl = getKeyRankList(list,r.getGoodstype());
				if(rl!=null){
					rl.getList().add(r);
				}
			}
			else{
				keys.put(r.getGoodstype(), r.getGoodstypeName());
				RankList rl = new RankList();
				rl.setId(r.getGoodstype());
				rl.setSort(r.getSort());
				rl.setName(r.getGoodstypeName());
				rl.getList().add(r);
				list.add(rl);
			}
		}
		
		Collections.sort(list,new Comparator<RankList>(){
			public int compare(RankList o1, RankList o2) {
				return o1.getSort()>o2.getSort()? 0 : 1;
			}
		});
		
		for(RankList r : list){
			Collections.sort(r.getList(), new Comparator<Ranking>(){
				public int compare(Ranking o1, Ranking o2) {
					return o1.getSellcount()>o2.getSellcount() ? 0 : 1;
				}
			});
		}
		return list;
	}
	
	private RankList getKeyRankList(List<RankList> list ,Integer key){
		
		for(RankList r  : list){
			if(r.getId().equals(key)){
				return r;
			}
		}
		
		return null;
		
	}

}
