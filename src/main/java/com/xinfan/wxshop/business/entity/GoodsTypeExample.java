package com.xinfan.wxshop.business.entity;

import java.util.ArrayList;
import java.util.List;

public class GoodsTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsTypeExample() {
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

        public Criteria andGoodstypeIsNull() {
            addCriterion("goodstype is null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIsNotNull() {
            addCriterion("goodstype is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeEqualTo(String value) {
            addCriterion("goodstype =", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotEqualTo(String value) {
            addCriterion("goodstype <>", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeGreaterThan(String value) {
            addCriterion("goodstype >", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeGreaterThanOrEqualTo(String value) {
            addCriterion("goodstype >=", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeLessThan(String value) {
            addCriterion("goodstype <", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeLessThanOrEqualTo(String value) {
            addCriterion("goodstype <=", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeLike(String value) {
            addCriterion("goodstype like", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotLike(String value) {
            addCriterion("goodstype not like", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIn(List<String> values) {
            addCriterion("goodstype in", values, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotIn(List<String> values) {
            addCriterion("goodstype not in", values, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeBetween(String value1, String value2) {
            addCriterion("goodstype between", value1, value2, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotBetween(String value1, String value2) {
            addCriterion("goodstype not between", value1, value2, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameIsNull() {
            addCriterion("goodstype_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameIsNotNull() {
            addCriterion("goodstype_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameEqualTo(String value) {
            addCriterion("goodstype_name =", value, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameNotEqualTo(String value) {
            addCriterion("goodstype_name <>", value, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameGreaterThan(String value) {
            addCriterion("goodstype_name >", value, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("goodstype_name >=", value, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameLessThan(String value) {
            addCriterion("goodstype_name <", value, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameLessThanOrEqualTo(String value) {
            addCriterion("goodstype_name <=", value, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameLike(String value) {
            addCriterion("goodstype_name like", value, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameNotLike(String value) {
            addCriterion("goodstype_name not like", value, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameIn(List<String> values) {
            addCriterion("goodstype_name in", values, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameNotIn(List<String> values) {
            addCriterion("goodstype_name not in", values, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameBetween(String value1, String value2) {
            addCriterion("goodstype_name between", value1, value2, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNameNotBetween(String value1, String value2) {
            addCriterion("goodstype_name not between", value1, value2, "goodstypeName");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeIsNull() {
            addCriterion("p_goodstype is null");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeIsNotNull() {
            addCriterion("p_goodstype is not null");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeEqualTo(String value) {
            addCriterion("p_goodstype =", value, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeNotEqualTo(String value) {
            addCriterion("p_goodstype <>", value, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeGreaterThan(String value) {
            addCriterion("p_goodstype >", value, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeGreaterThanOrEqualTo(String value) {
            addCriterion("p_goodstype >=", value, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeLessThan(String value) {
            addCriterion("p_goodstype <", value, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeLessThanOrEqualTo(String value) {
            addCriterion("p_goodstype <=", value, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeLike(String value) {
            addCriterion("p_goodstype like", value, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeNotLike(String value) {
            addCriterion("p_goodstype not like", value, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeIn(List<String> values) {
            addCriterion("p_goodstype in", values, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeNotIn(List<String> values) {
            addCriterion("p_goodstype not in", values, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeBetween(String value1, String value2) {
            addCriterion("p_goodstype between", value1, value2, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andPGoodstypeNotBetween(String value1, String value2) {
            addCriterion("p_goodstype not between", value1, value2, "pGoodstype");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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