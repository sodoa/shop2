package com.xinfan.wxshop.business.entity;

import java.util.Date;

import com.xinfan.wxshop.common.base.BaseEntity;

public class Distribution extends BaseEntity {
    private Integer distributionId;

    private Integer uplineId;

    private Integer downlineId;

    private Integer result;

    private Float charge;

    private Date consumeDate;

    private String downlineName;

    private Integer orderId;

    private Float rate;

    private Float income;

    private String chargeName;

    private Integer level;

    public Integer getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Integer distributionId) {
        this.distributionId = distributionId;
    }

    public Integer getUplineId() {
        return uplineId;
    }

    public void setUplineId(Integer uplineId) {
        this.uplineId = uplineId;
    }

    public Integer getDownlineId() {
        return downlineId;
    }

    public void setDownlineId(Integer downlineId) {
        this.downlineId = downlineId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Float getCharge() {
        return charge;
    }

    public void setCharge(Float charge) {
        this.charge = charge;
    }

    public Date getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
    }

    public String getDownlineName() {
        return downlineName;
    }

    public void setDownlineName(String downlineName) {
        this.downlineName = downlineName == null ? null : downlineName.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName == null ? null : chargeName.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}