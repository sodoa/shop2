package com.xinfan.wxshop.business.entity;

import com.xinfan.wxshop.common.base.BaseEntity;

public class GoodsType extends BaseEntity {
    private String goodstype;

    private String goodstypeName;

    private String pGoodstype;

    private Integer sort;

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype == null ? null : goodstype.trim();
    }

    public String getGoodstypeName() {
        return goodstypeName;
    }

    public void setGoodstypeName(String goodstypeName) {
        this.goodstypeName = goodstypeName == null ? null : goodstypeName.trim();
    }

    public String getpGoodstype() {
        return pGoodstype;
    }

    public void setpGoodstype(String pGoodstype) {
        this.pGoodstype = pGoodstype == null ? null : pGoodstype.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}