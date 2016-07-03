package com.xinfan.wxshop.business.entity;

import java.util.ArrayList;
import java.util.List;

public class DistrRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DistrRankExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDisplaynameIsNull() {
            addCriterion("displayname is null");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIsNotNull() {
            addCriterion("displayname is not null");
            return (Criteria) this;
        }

        public Criteria andDisplaynameEqualTo(String value) {
            addCriterion("displayname =", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotEqualTo(String value) {
            addCriterion("displayname <>", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameGreaterThan(String value) {
            addCriterion("displayname >", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameGreaterThanOrEqualTo(String value) {
            addCriterion("displayname >=", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLessThan(String value) {
            addCriterion("displayname <", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLessThanOrEqualTo(String value) {
            addCriterion("displayname <=", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLike(String value) {
            addCriterion("displayname like", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotLike(String value) {
            addCriterion("displayname not like", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIn(List<String> values) {
            addCriterion("displayname in", values, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotIn(List<String> values) {
            addCriterion("displayname not in", values, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameBetween(String value1, String value2) {
            addCriterion("displayname between", value1, value2, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotBetween(String value1, String value2) {
            addCriterion("displayname not between", value1, value2, "displayname");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andLevel1countIsNull() {
            addCriterion("level1count is null");
            return (Criteria) this;
        }

        public Criteria andLevel1countIsNotNull() {
            addCriterion("level1count is not null");
            return (Criteria) this;
        }

        public Criteria andLevel1countEqualTo(String value) {
            addCriterion("level1count =", value, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countNotEqualTo(String value) {
            addCriterion("level1count <>", value, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countGreaterThan(String value) {
            addCriterion("level1count >", value, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countGreaterThanOrEqualTo(String value) {
            addCriterion("level1count >=", value, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countLessThan(String value) {
            addCriterion("level1count <", value, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countLessThanOrEqualTo(String value) {
            addCriterion("level1count <=", value, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countLike(String value) {
            addCriterion("level1count like", value, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countNotLike(String value) {
            addCriterion("level1count not like", value, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countIn(List<String> values) {
            addCriterion("level1count in", values, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countNotIn(List<String> values) {
            addCriterion("level1count not in", values, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countBetween(String value1, String value2) {
            addCriterion("level1count between", value1, value2, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel1countNotBetween(String value1, String value2) {
            addCriterion("level1count not between", value1, value2, "level1count");
            return (Criteria) this;
        }

        public Criteria andLevel2countIsNull() {
            addCriterion("level2count is null");
            return (Criteria) this;
        }

        public Criteria andLevel2countIsNotNull() {
            addCriterion("level2count is not null");
            return (Criteria) this;
        }

        public Criteria andLevel2countEqualTo(String value) {
            addCriterion("level2count =", value, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countNotEqualTo(String value) {
            addCriterion("level2count <>", value, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countGreaterThan(String value) {
            addCriterion("level2count >", value, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countGreaterThanOrEqualTo(String value) {
            addCriterion("level2count >=", value, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countLessThan(String value) {
            addCriterion("level2count <", value, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countLessThanOrEqualTo(String value) {
            addCriterion("level2count <=", value, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countLike(String value) {
            addCriterion("level2count like", value, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countNotLike(String value) {
            addCriterion("level2count not like", value, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countIn(List<String> values) {
            addCriterion("level2count in", values, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countNotIn(List<String> values) {
            addCriterion("level2count not in", values, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countBetween(String value1, String value2) {
            addCriterion("level2count between", value1, value2, "level2count");
            return (Criteria) this;
        }

        public Criteria andLevel2countNotBetween(String value1, String value2) {
            addCriterion("level2count not between", value1, value2, "level2count");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}