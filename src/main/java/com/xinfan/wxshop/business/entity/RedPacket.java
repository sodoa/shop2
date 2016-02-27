package com.xinfan.wxshop.business.entity;

import com.xinfan.wxshop.common.base.BaseEntity;

public class RedPacket extends BaseEntity  {
    private String lined;

    private Integer total;

    private Integer pickup;

    private Integer amount;

    public String getLined() {
        return lined;
    }

    public void setLined(String lined) {
        this.lined = lined == null ? null : lined.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPickup() {
        return pickup;
    }

    public void setPickup(Integer pickup) {
        this.pickup = pickup;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}