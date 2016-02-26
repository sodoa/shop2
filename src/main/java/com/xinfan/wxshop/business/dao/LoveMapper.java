package com.xinfan.wxshop.business.dao;

import com.xinfan.wxshop.business.entity.Love;
import com.xinfan.wxshop.business.entity.LoveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoveMapper {
    int countByExample(LoveExample example);

    int deleteByExample(LoveExample example);

    int deleteByPrimaryKey(Integer loveId);

    int insert(Love record);

    int insertSelective(Love record);

    List<Love> selectByExample(LoveExample example);

    Love selectByPrimaryKey(Integer loveId);

    int updateByExampleSelective(@Param("record") Love record, @Param("example") LoveExample example);

    int updateByExample(@Param("record") Love record, @Param("example") LoveExample example);

    int updateByPrimaryKeySelective(Love record);

    int updateByPrimaryKey(Love record);
}