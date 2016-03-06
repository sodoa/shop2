package com.xinfan.wxshop.business.entity;

import java.util.ArrayList;
import java.util.List;

public class IncomeRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IncomeRankExample() {
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

        public Criteria andRankDateIsNull() {
            addCriterion("rank_date is null");
            return (Criteria) this;
        }

        public Criteria andRankDateIsNotNull() {
            addCriterion("rank_date is not null");
            return (Criteria) this;
        }

        public Criteria andRankDateEqualTo(String value) {
            addCriterion("rank_date =", value, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateNotEqualTo(String value) {
            addCriterion("rank_date <>", value, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateGreaterThan(String value) {
            addCriterion("rank_date >", value, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateGreaterThanOrEqualTo(String value) {
            addCriterion("rank_date >=", value, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateLessThan(String value) {
            addCriterion("rank_date <", value, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateLessThanOrEqualTo(String value) {
            addCriterion("rank_date <=", value, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateLike(String value) {
            addCriterion("rank_date like", value, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateNotLike(String value) {
            addCriterion("rank_date not like", value, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateIn(List<String> values) {
            addCriterion("rank_date in", values, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateNotIn(List<String> values) {
            addCriterion("rank_date not in", values, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateBetween(String value1, String value2) {
            addCriterion("rank_date between", value1, value2, "rankDate");
            return (Criteria) this;
        }

        public Criteria andRankDateNotBetween(String value1, String value2) {
            addCriterion("rank_date not between", value1, value2, "rankDate");
            return (Criteria) this;
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

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeIsNull() {
            addCriterion("total_income is null");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeIsNotNull() {
            addCriterion("total_income is not null");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeEqualTo(Float value) {
            addCriterion("total_income =", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeNotEqualTo(Float value) {
            addCriterion("total_income <>", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeGreaterThan(Float value) {
            addCriterion("total_income >", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeGreaterThanOrEqualTo(Float value) {
            addCriterion("total_income >=", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeLessThan(Float value) {
            addCriterion("total_income <", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeLessThanOrEqualTo(Float value) {
            addCriterion("total_income <=", value, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeIn(List<Float> values) {
            addCriterion("total_income in", values, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeNotIn(List<Float> values) {
            addCriterion("total_income not in", values, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeBetween(Float value1, Float value2) {
            addCriterion("total_income between", value1, value2, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andTotalIncomeNotBetween(Float value1, Float value2) {
            addCriterion("total_income not between", value1, value2, "totalIncome");
            return (Criteria) this;
        }

        public Criteria andRankTypeIsNull() {
            addCriterion("rank_type is null");
            return (Criteria) this;
        }

        public Criteria andRankTypeIsNotNull() {
            addCriterion("rank_type is not null");
            return (Criteria) this;
        }

        public Criteria andRankTypeEqualTo(Integer value) {
            addCriterion("rank_type =", value, "rankType");
            return (Criteria) this;
        }

        public Criteria andRankTypeNotEqualTo(Integer value) {
            addCriterion("rank_type <>", value, "rankType");
            return (Criteria) this;
        }

        public Criteria andRankTypeGreaterThan(Integer value) {
            addCriterion("rank_type >", value, "rankType");
            return (Criteria) this;
        }

        public Criteria andRankTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank_type >=", value, "rankType");
            return (Criteria) this;
        }

        public Criteria andRankTypeLessThan(Integer value) {
            addCriterion("rank_type <", value, "rankType");
            return (Criteria) this;
        }

        public Criteria andRankTypeLessThanOrEqualTo(Integer value) {
            addCriterion("rank_type <=", value, "rankType");
            return (Criteria) this;
        }

        public Criteria andRankTypeIn(List<Integer> values) {
            addCriterion("rank_type in", values, "rankType");
            return (Criteria) this;
        }

        public Criteria andRankTypeNotIn(List<Integer> values) {
            addCriterion("rank_type not in", values, "rankType");
            return (Criteria) this;
        }

        public Criteria andRankTypeBetween(Integer value1, Integer value2) {
            addCriterion("rank_type between", value1, value2, "rankType");
            return (Criteria) this;
        }

        public Criteria andRankTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("rank_type not between", value1, value2, "rankType");
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