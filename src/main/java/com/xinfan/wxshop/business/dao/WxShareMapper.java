package com.xinfan.wxshop.business.dao;

import com.xinfan.wxshop.business.entity.WxShare;
import com.xinfan.wxshop.business.entity.WxShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxShareMapper {
    int countByExample(WxShareExample example);

    int deleteByExample(WxShareExample example);

    int deleteByPrimaryKey(String wxid);

    int insert(WxShare record);

    int insertSelective(WxShare record);

    List<WxShare> selectByExample(WxShareExample example);

    WxShare selectByPrimaryKey(String wxid);

    int updateByExampleSelective(@Param("record") WxShare record, @Param("example") WxShareExample example);

    int updateByExample(@Param("record") WxShare record, @Param("example") WxShareExample example);

    int updateByPrimaryKeySelective(WxShare record);

    int updateByPrimaryKey(WxShare record);
}