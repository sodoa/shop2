package com.xinfan.wxshop.business.dao;

import com.xinfan.wxshop.business.entity.Ranking;
import com.xinfan.wxshop.business.entity.RankingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RankingMapper {
    int countByExample(RankingExample example);

    int deleteByExample(RankingExample example);

    int deleteByPrimaryKey(Integer rankingId);

    int insert(Ranking record);

    int insertSelective(Ranking record);

    List<Ranking> selectByExample(RankingExample example);

    Ranking selectByPrimaryKey(Integer rankingId);

    int updateByExampleSelective(@Param("record") Ranking record, @Param("example") RankingExample example);

    int updateByExample(@Param("record") Ranking record, @Param("example") RankingExample example);

    int updateByPrimaryKeySelective(Ranking record);

    int updateByPrimaryKey(Ranking record);
}