package com.xinfan.wxshop.business.entity;

import java.util.ArrayList;
import java.util.List;

public class WalletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WalletExample() {
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

        public Criteria andWalletIdIsNull() {
            addCriterion("wallet_id is null");
            return (Criteria) this;
        }

        public Criteria andWalletIdIsNotNull() {
            addCriterion("wallet_id is not null");
            return (Criteria) this;
        }

        public Criteria andWalletIdEqualTo(Integer value) {
            addCriterion("wallet_id =", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdNotEqualTo(Integer value) {
            addCriterion("wallet_id <>", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdGreaterThan(Integer value) {
            addCriterion("wallet_id >", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_id >=", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdLessThan(Integer value) {
            addCriterion("wallet_id <", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_id <=", value, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdIn(List<Integer> values) {
            addCriterion("wallet_id in", values, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdNotIn(List<Integer> values) {
            addCriterion("wallet_id not in", values, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdBetween(Integer value1, Integer value2) {
            addCriterion("wallet_id between", value1, value2, "walletId");
            return (Criteria) this;
        }

        public Criteria andWalletIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_id not between", value1, value2, "walletId");
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

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Float value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Float value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Float value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Float value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Float value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Float value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Float> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Float> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Float value1, Float value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Float value1, Float value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceIsNull() {
            addCriterion("distr_balance is null");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceIsNotNull() {
            addCriterion("distr_balance is not null");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceEqualTo(Float value) {
            addCriterion("distr_balance =", value, "distrBalance");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceNotEqualTo(Float value) {
            addCriterion("distr_balance <>", value, "distrBalance");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceGreaterThan(Float value) {
            addCriterion("distr_balance >", value, "distrBalance");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceGreaterThanOrEqualTo(Float value) {
            addCriterion("distr_balance >=", value, "distrBalance");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceLessThan(Float value) {
            addCriterion("distr_balance <", value, "distrBalance");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceLessThanOrEqualTo(Float value) {
            addCriterion("distr_balance <=", value, "distrBalance");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceIn(List<Float> values) {
            addCriterion("distr_balance in", values, "distrBalance");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceNotIn(List<Float> values) {
            addCriterion("distr_balance not in", values, "distrBalance");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceBetween(Float value1, Float value2) {
            addCriterion("distr_balance between", value1, value2, "distrBalance");
            return (Criteria) this;
        }

        public Criteria andDistrBalanceNotBetween(Float value1, Float value2) {
            addCriterion("distr_balance not between", value1, value2, "distrBalance");
            return (Criteria) this;
        }

        public Criteria andDistrCountIsNull() {
            addCriterion("distr_count is null");
            return (Criteria) this;
        }

        public Criteria andDistrCountIsNotNull() {
            addCriterion("distr_count is not null");
            return (Criteria) this;
        }

        public Criteria andDistrCountEqualTo(Integer value) {
            addCriterion("distr_count =", value, "distrCount");
            return (Criteria) this;
        }

        public Criteria andDistrCountNotEqualTo(Integer value) {
            addCriterion("distr_count <>", value, "distrCount");
            return (Criteria) this;
        }

        public Criteria andDistrCountGreaterThan(Integer value) {
            addCriterion("distr_count >", value, "distrCount");
            return (Criteria) this;
        }

        public Criteria andDistrCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("distr_count >=", value, "distrCount");
            return (Criteria) this;
        }

        public Criteria andDistrCountLessThan(Integer value) {
            addCriterion("distr_count <", value, "distrCount");
            return (Criteria) this;
        }

        public Criteria andDistrCountLessThanOrEqualTo(Integer value) {
            addCriterion("distr_count <=", value, "distrCount");
            return (Criteria) this;
        }

        public Criteria andDistrCountIn(List<Integer> values) {
            addCriterion("distr_count in", values, "distrCount");
            return (Criteria) this;
        }

        public Criteria andDistrCountNotIn(List<Integer> values) {
            addCriterion("distr_count not in", values, "distrCount");
            return (Criteria) this;
        }

        public Criteria andDistrCountBetween(Integer value1, Integer value2) {
            addCriterion("distr_count between", value1, value2, "distrCount");
            return (Criteria) this;
        }

        public Criteria andDistrCountNotBetween(Integer value1, Integer value2) {
            addCriterion("distr_count not between", value1, value2, "distrCount");
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