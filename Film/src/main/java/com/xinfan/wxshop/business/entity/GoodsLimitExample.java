package com.xinfan.wxshop.business.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsLimitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsLimitExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(Integer value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Integer value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Integer value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Integer value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Integer> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Integer> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountIsNull() {
            addCriterion("sell_amount is null");
            return (Criteria) this;
        }

        public Criteria andSellAmountIsNotNull() {
            addCriterion("sell_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSellAmountEqualTo(Integer value) {
            addCriterion("sell_amount =", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountNotEqualTo(Integer value) {
            addCriterion("sell_amount <>", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountGreaterThan(Integer value) {
            addCriterion("sell_amount >", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_amount >=", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountLessThan(Integer value) {
            addCriterion("sell_amount <", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountLessThanOrEqualTo(Integer value) {
            addCriterion("sell_amount <=", value, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountIn(List<Integer> values) {
            addCriterion("sell_amount in", values, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountNotIn(List<Integer> values) {
            addCriterion("sell_amount not in", values, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountBetween(Integer value1, Integer value2) {
            addCriterion("sell_amount between", value1, value2, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andSellAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_amount not between", value1, value2, "sellAmount");
            return (Criteria) this;
        }

        public Criteria andBuyLimitIsNull() {
            addCriterion("buy_limit is null");
            return (Criteria) this;
        }

        public Criteria andBuyLimitIsNotNull() {
            addCriterion("buy_limit is not null");
            return (Criteria) this;
        }

        public Criteria andBuyLimitEqualTo(Integer value) {
            addCriterion("buy_limit =", value, "buyLimit");
            return (Criteria) this;
        }

        public Criteria andBuyLimitNotEqualTo(Integer value) {
            addCriterion("buy_limit <>", value, "buyLimit");
            return (Criteria) this;
        }

        public Criteria andBuyLimitGreaterThan(Integer value) {
            addCriterion("buy_limit >", value, "buyLimit");
            return (Criteria) this;
        }

        public Criteria andBuyLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_limit >=", value, "buyLimit");
            return (Criteria) this;
        }

        public Criteria andBuyLimitLessThan(Integer value) {
            addCriterion("buy_limit <", value, "buyLimit");
            return (Criteria) this;
        }

        public Criteria andBuyLimitLessThanOrEqualTo(Integer value) {
            addCriterion("buy_limit <=", value, "buyLimit");
            return (Criteria) this;
        }

        public Criteria andBuyLimitIn(List<Integer> values) {
            addCriterion("buy_limit in", values, "buyLimit");
            return (Criteria) this;
        }

        public Criteria andBuyLimitNotIn(List<Integer> values) {
            addCriterion("buy_limit not in", values, "buyLimit");
            return (Criteria) this;
        }

        public Criteria andBuyLimitBetween(Integer value1, Integer value2) {
            addCriterion("buy_limit between", value1, value2, "buyLimit");
            return (Criteria) this;
        }

        public Criteria andBuyLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_limit not between", value1, value2, "buyLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIsNull() {
            addCriterion("time_limit is null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIsNotNull() {
            addCriterion("time_limit is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitEqualTo(Date value) {
            addCriterion("time_limit =", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotEqualTo(Date value) {
            addCriterion("time_limit <>", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitGreaterThan(Date value) {
            addCriterion("time_limit >", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitGreaterThanOrEqualTo(Date value) {
            addCriterion("time_limit >=", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLessThan(Date value) {
            addCriterion("time_limit <", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitLessThanOrEqualTo(Date value) {
            addCriterion("time_limit <=", value, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitIn(List<Date> values) {
            addCriterion("time_limit in", values, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotIn(List<Date> values) {
            addCriterion("time_limit not in", values, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitBetween(Date value1, Date value2) {
            addCriterion("time_limit between", value1, value2, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andTimeLimitNotBetween(Date value1, Date value2) {
            addCriterion("time_limit not between", value1, value2, "timeLimit");
            return (Criteria) this;
        }

        public Criteria andLimitTypeIsNull() {
            addCriterion("limit_type is null");
            return (Criteria) this;
        }

        public Criteria andLimitTypeIsNotNull() {
            addCriterion("limit_type is not null");
            return (Criteria) this;
        }

        public Criteria andLimitTypeEqualTo(Integer value) {
            addCriterion("limit_type =", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeNotEqualTo(Integer value) {
            addCriterion("limit_type <>", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeGreaterThan(Integer value) {
            addCriterion("limit_type >", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_type >=", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeLessThan(Integer value) {
            addCriterion("limit_type <", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeLessThanOrEqualTo(Integer value) {
            addCriterion("limit_type <=", value, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeIn(List<Integer> values) {
            addCriterion("limit_type in", values, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeNotIn(List<Integer> values) {
            addCriterion("limit_type not in", values, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeBetween(Integer value1, Integer value2) {
            addCriterion("limit_type between", value1, value2, "limitType");
            return (Criteria) this;
        }

        public Criteria andLimitTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_type not between", value1, value2, "limitType");
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