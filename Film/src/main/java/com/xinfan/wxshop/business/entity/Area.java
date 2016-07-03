package com.xinfan.wxshop.business.entity;

import com.xinfan.wxshop.common.base.BaseEntity;

public class Area extends BaseEntity {
    private String code;

    private String name;

    private Integer level;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}