package com.xinfan.wxshop.business.dao;

import com.xinfan.wxshop.business.entity.IncomeRank;
import com.xinfan.wxshop.business.entity.IncomeRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomeRankMapper {
    int countByExample(IncomeRankExample example);

    int deleteByExample(IncomeRankExample example);

    int deleteByPrimaryKey(String rankDate);

    int insert(IncomeRank record);

    int insertSelective(IncomeRank record);

    List<IncomeRank> selectByExample(IncomeRankExample example);

    IncomeRank selectByPrimaryKey(String rankDate);

    int updateByExampleSelective(@Param("record") IncomeRank record, @Param("example") IncomeRankExample example);

    int updateByExample(@Param("record") IncomeRank record, @Param("example") IncomeRankExample example);

    int updateByPrimaryKeySelective(IncomeRank record);

    int updateByPrimaryKey(IncomeRank record);
}