package com.xinfan.wxshop.business.entity;

import com.xinfan.wxshop.common.base.BaseEntity;

public class IncomeRank extends BaseEntity {
    private String rankDate;

    private String displayname;

    private Integer customerId;

    private Float totalIncome;

    private Integer rankType;

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate == null ? null : rankDate.trim();
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname == null ? null : displayname.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Float getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Float totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Integer getRankType() {
        return rankType;
    }

    public void setRankType(Integer rankType) {
        this.rankType = rankType;
    }
}