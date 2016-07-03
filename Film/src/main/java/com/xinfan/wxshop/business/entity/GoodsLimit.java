package com.xinfan.wxshop.business.entity;

import java.util.Date;

import com.xinfan.wxshop.common.base.BaseEntity;

public class GoodsLimit extends BaseEntity{
    private Integer goodsId;

    private Integer totalAmount;

    private Integer sellAmount;

    private Integer buyLimit;

    private Date timeLimit;

    private Integer limitType;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(Integer sellAmount) {
        this.sellAmount = sellAmount;
    }

    public Integer getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(Integer buyLimit) {
        this.buyLimit = buyLimit;
    }

    public Date getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Date timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getLimitType() {
        return limitType;
    }

    public void setLimitType(Integer limitType) {
        this.limitType = limitType;
    }
}