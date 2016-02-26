package com.xinfan.wxshop.business.dao;

import com.xinfan.wxshop.business.entity.Distribution;
import com.xinfan.wxshop.business.entity.DistributionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistributionMapper {
    int countByExample(DistributionExample example);

    int deleteByExample(DistributionExample example);

    int deleteByPrimaryKey(Integer distributionId);

    int insert(Distribution record);

    int insertSelective(Distribution record);

    List<Distribution> selectByExample(DistributionExample example);

    Distribution selectByPrimaryKey(Integer distributionId);

    int updateByExampleSelective(@Param("record") Distribution record, @Param("example") DistributionExample example);

    int updateByExample(@Param("record") Distribution record, @Param("example") DistributionExample example);

    int updateByPrimaryKeySelective(Distribution record);

    int updateByPrimaryKey(Distribution record);
}