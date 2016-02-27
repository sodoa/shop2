package com.xinfan.wxshop.business.entity;

import java.util.ArrayList;
import java.util.List;

public class RedPacketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RedPacketExample() {
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

        public Criteria andLinedIsNull() {
            addCriterion("lined is null");
            return (Criteria) this;
        }

        public Criteria andLinedIsNotNull() {
            addCriterion("lined is not null");
            return (Criteria) this;
        }

        public Criteria andLinedEqualTo(String value) {
            addCriterion("lined =", value, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedNotEqualTo(String value) {
            addCriterion("lined <>", value, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedGreaterThan(String value) {
            addCriterion("lined >", value, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedGreaterThanOrEqualTo(String value) {
            addCriterion("lined >=", value, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedLessThan(String value) {
            addCriterion("lined <", value, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedLessThanOrEqualTo(String value) {
            addCriterion("lined <=", value, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedLike(String value) {
            addCriterion("lined like", value, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedNotLike(String value) {
            addCriterion("lined not like", value, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedIn(List<String> values) {
            addCriterion("lined in", values, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedNotIn(List<String> values) {
            addCriterion("lined not in", values, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedBetween(String value1, String value2) {
            addCriterion("lined between", value1, value2, "lined");
            return (Criteria) this;
        }

        public Criteria andLinedNotBetween(String value1, String value2) {
            addCriterion("lined not between", value1, value2, "lined");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Integer value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Integer value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Integer value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Integer value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Integer value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Integer> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Integer> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Integer value1, Integer value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andPickupIsNull() {
            addCriterion("pickup is null");
            return (Criteria) this;
        }

        public Criteria andPickupIsNotNull() {
            addCriterion("pickup is not null");
            return (Criteria) this;
        }

        public Criteria andPickupEqualTo(Integer value) {
            addCriterion("pickup =", value, "pickup");
            return (Criteria) this;
        }

        public Criteria andPickupNotEqualTo(Integer value) {
            addCriterion("pickup <>", value, "pickup");
            return (Criteria) this;
        }

        public Criteria andPickupGreaterThan(Integer value) {
            addCriterion("pickup >", value, "pickup");
            return (Criteria) this;
        }

        public Criteria andPickupGreaterThanOrEqualTo(Integer value) {
            addCriterion("pickup >=", value, "pickup");
            return (Criteria) this;
        }

        public Criteria andPickupLessThan(Integer value) {
            addCriterion("pickup <", value, "pickup");
            return (Criteria) this;
        }

        public Criteria andPickupLessThanOrEqualTo(Integer value) {
            addCriterion("pickup <=", value, "pickup");
            return (Criteria) this;
        }

        public Criteria andPickupIn(List<Integer> values) {
            addCriterion("pickup in", values, "pickup");
            return (Criteria) this;
        }

        public Criteria andPickupNotIn(List<Integer> values) {
            addCriterion("pickup not in", values, "pickup");
            return (Criteria) this;
        }

        public Criteria andPickupBetween(Integer value1, Integer value2) {
            addCriterion("pickup between", value1, value2, "pickup");
            return (Criteria) this;
        }

        public Criteria andPickupNotBetween(Integer value1, Integer value2) {
            addCriterion("pickup not between", value1, value2, "pickup");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
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