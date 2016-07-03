package com.xinfan.wxshop.business.entity;

import com.xinfan.wxshop.common.base.BaseEntity;

public class Wallet extends BaseEntity {
    private Integer walletId;

    private Integer customerId;

    private Float balance;

    private Float distrBalance;

    private Integer distrCount;

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getDistrBalance() {
        return distrBalance;
    }

    public void setDistrBalance(Float distrBalance) {
        this.distrBalance = distrBalance;
    }

    public Integer getDistrCount() {
        return distrCount;
    }

    public void setDistrCount(Integer distrCount) {
        this.distrCount = distrCount;
    }
}