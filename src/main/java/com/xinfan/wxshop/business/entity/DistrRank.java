package com.xinfan.wxshop.business.entity;

import com.xinfan.wxshop.common.base.BaseEntity;

public class DistrRank extends BaseEntity{
    private String displayname;

    private String account;

    private String level1count;

    private String level2count;

    private String type;

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname == null ? null : displayname.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getLevel1count() {
        return level1count;
    }

    public void setLevel1count(String level1count) {
        this.level1count = level1count == null ? null : level1count.trim();
    }

    public String getLevel2count() {
        return level2count;
    }

    public void setLevel2count(String level2count) {
        this.level2count = level2count == null ? null : level2count.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}