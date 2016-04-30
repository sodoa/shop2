package com.xinfan.wxshop.business.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DistributionExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public DistributionExample() {
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

		public Criteria andDistributionIdIsNull() {
			addCriterion("distribution_id is null");
			return (Criteria) this;
		}

		public Criteria andDistributionIdIsNotNull() {
			addCriterion("distribution_id is not null");
			return (Criteria) this;
		}

		public Criteria andDistributionIdEqualTo(Integer value) {
			addCriterion("distribution_id =", value, "distributionId");
			return (Criteria) this;
		}

		public Criteria andDistributionIdNotEqualTo(Integer value) {
			addCriterion("distribution_id <>", value, "distributionId");
			return (Criteria) this;
		}

		public Criteria andDistributionIdGreaterThan(Integer value) {
			addCriterion("distribution_id >", value, "distributionId");
			return (Criteria) this;
		}

		public Criteria andDistributionIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("distribution_id >=", value, "distributionId");
			return (Criteria) this;
		}

		public Criteria andDistributionIdLessThan(Integer value) {
			addCriterion("distribution_id <", value, "distributionId");
			return (Criteria) this;
		}

		public Criteria andDistributionIdLessThanOrEqualTo(Integer value) {
			addCriterion("distribution_id <=", value, "distributionId");
			return (Criteria) this;
		}

		public Criteria andDistributionIdIn(List<Integer> values) {
			addCriterion("distribution_id in", values, "distributionId");
			return (Criteria) this;
		}

		public Criteria andDistributionIdNotIn(List<Integer> values) {
			addCriterion("distribution_id not in", values, "distributionId");
			return (Criteria) this;
		}

		public Criteria andDistributionIdBetween(Integer value1, Integer value2) {
			addCriterion("distribution_id between", value1, value2, "distributionId");
			return (Criteria) this;
		}

		public Criteria andDistributionIdNotBetween(Integer value1, Integer value2) {
			addCriterion("distribution_id not between", value1, value2, "distributionId");
			return (Criteria) this;
		}

		public Criteria andUplineIdIsNull() {
			addCriterion("upline_id is null");
			return (Criteria) this;
		}

		public Criteria andUplineIdIsNotNull() {
			addCriterion("upline_id is not null");
			return (Criteria) this;
		}

		public Criteria andUplineIdEqualTo(Integer value) {
			addCriterion("upline_id =", value, "uplineId");
			return (Criteria) this;
		}

		public Criteria andUplineIdNotEqualTo(Integer value) {
			addCriterion("upline_id <>", value, "uplineId");
			return (Criteria) this;
		}

		public Criteria andUplineIdGreaterThan(Integer value) {
			addCriterion("upline_id >", value, "uplineId");
			return (Criteria) this;
		}

		public Criteria andUplineIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("upline_id >=", value, "uplineId");
			return (Criteria) this;
		}

		public Criteria andUplineIdLessThan(Integer value) {
			addCriterion("upline_id <", value, "uplineId");
			return (Criteria) this;
		}

		public Criteria andUplineIdLessThanOrEqualTo(Integer value) {
			addCriterion("upline_id <=", value, "uplineId");
			return (Criteria) this;
		}

		public Criteria andUplineIdIn(List<Integer> values) {
			addCriterion("upline_id in", values, "uplineId");
			return (Criteria) this;
		}

		public Criteria andUplineIdNotIn(List<Integer> values) {
			addCriterion("upline_id not in", values, "uplineId");
			return (Criteria) this;
		}

		public Criteria andUplineIdBetween(Integer value1, Integer value2) {
			addCriterion("upline_id between", value1, value2, "uplineId");
			return (Criteria) this;
		}

		public Criteria andUplineIdNotBetween(Integer value1, Integer value2) {
			addCriterion("upline_id not between", value1, value2, "uplineId");
			return (Criteria) this;
		}

		public Criteria andDownlineIdIsNull() {
			addCriterion("downline_id is null");
			return (Criteria) this;
		}

		public Criteria andDownlineIdIsNotNull() {
			addCriterion("downline_id is not null");
			return (Criteria) this;
		}

		public Criteria andDownlineIdEqualTo(Integer value) {
			addCriterion("downline_id =", value, "downlineId");
			return (Criteria) this;
		}

		public Criteria andDownlineIdNotEqualTo(Integer value) {
			addCriterion("downline_id <>", value, "downlineId");
			return (Criteria) this;
		}

		public Criteria andDownlineIdGreaterThan(Integer value) {
			addCriterion("downline_id >", value, "downlineId");
			return (Criteria) this;
		}

		public Criteria andDownlineIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("downline_id >=", value, "downlineId");
			return (Criteria) this;
		}

		public Criteria andDownlineIdLessThan(Integer value) {
			addCriterion("downline_id <", value, "downlineId");
			return (Criteria) this;
		}

		public Criteria andDownlineIdLessThanOrEqualTo(Integer value) {
			addCriterion("downline_id <=", value, "downlineId");
			return (Criteria) this;
		}

		public Criteria andDownlineIdIn(List<Integer> values) {
			addCriterion("downline_id in", values, "downlineId");
			return (Criteria) this;
		}

		public Criteria andDownlineIdNotIn(List<Integer> values) {
			addCriterion("downline_id not in", values, "downlineId");
			return (Criteria) this;
		}

		public Criteria andDownlineIdBetween(Integer value1, Integer value2) {
			addCriterion("downline_id between", value1, value2, "downlineId");
			return (Criteria) this;
		}

		public Criteria andDownlineIdNotBetween(Integer value1, Integer value2) {
			addCriterion("downline_id not between", value1, value2, "downlineId");
			return (Criteria) this;
		}

		public Criteria andResultIsNull() {
			addCriterion("result is null");
			return (Criteria) this;
		}

		public Criteria andResultIsNotNull() {
			addCriterion("result is not null");
			return (Criteria) this;
		}

		public Criteria andResultEqualTo(Integer value) {
			addCriterion("result =", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultNotEqualTo(Integer value) {
			addCriterion("result <>", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultGreaterThan(Integer value) {
			addCriterion("result >", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultGreaterThanOrEqualTo(Integer value) {
			addCriterion("result >=", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultLessThan(Integer value) {
			addCriterion("result <", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultLessThanOrEqualTo(Integer value) {
			addCriterion("result <=", value, "result");
			return (Criteria) this;
		}

		public Criteria andResultIn(List<Integer> values) {
			addCriterion("result in", values, "result");
			return (Criteria) this;
		}

		public Criteria andResultNotIn(List<Integer> values) {
			addCriterion("result not in", values, "result");
			return (Criteria) this;
		}

		public Criteria andResultBetween(Integer value1, Integer value2) {
			addCriterion("result between", value1, value2, "result");
			return (Criteria) this;
		}

		public Criteria andResultNotBetween(Integer value1, Integer value2) {
			addCriterion("result not between", value1, value2, "result");
			return (Criteria) this;
		}

		public Criteria andChargeIsNull() {
			addCriterion("charge is null");
			return (Criteria) this;
		}

		public Criteria andChargeIsNotNull() {
			addCriterion("charge is not null");
			return (Criteria) this;
		}

		public Criteria andChargeEqualTo(Float value) {
			addCriterion("charge =", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotEqualTo(Float value) {
			addCriterion("charge <>", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeGreaterThan(Float value) {
			addCriterion("charge >", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeGreaterThanOrEqualTo(Float value) {
			addCriterion("charge >=", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeLessThan(Float value) {
			addCriterion("charge <", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeLessThanOrEqualTo(Float value) {
			addCriterion("charge <=", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeIn(List<Float> values) {
			addCriterion("charge in", values, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotIn(List<Float> values) {
			addCriterion("charge not in", values, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeBetween(Float value1, Float value2) {
			addCriterion("charge between", value1, value2, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotBetween(Float value1, Float value2) {
			addCriterion("charge not between", value1, value2, "charge");
			return (Criteria) this;
		}

		public Criteria andConsumeDateIsNull() {
			addCriterion("consume_date is null");
			return (Criteria) this;
		}

		public Criteria andConsumeDateIsNotNull() {
			addCriterion("consume_date is not null");
			return (Criteria) this;
		}

		public Criteria andConsumeDateEqualTo(Date value) {
			addCriterion("consume_date =", value, "consumeDate");
			return (Criteria) this;
		}

		public Criteria andConsumeDateNotEqualTo(Date value) {
			addCriterion("consume_date <>", value, "consumeDate");
			return (Criteria) this;
		}

		public Criteria andConsumeDateGreaterThan(Date value) {
			addCriterion("consume_date >", value, "consumeDate");
			return (Criteria) this;
		}

		public Criteria andConsumeDateGreaterThanOrEqualTo(Date value) {
			addCriterion("consume_date >=", value, "consumeDate");
			return (Criteria) this;
		}

		public Criteria andConsumeDateLessThan(Date value) {
			addCriterion("consume_date <", value, "consumeDate");
			return (Criteria) this;
		}

		public Criteria andConsumeDateLessThanOrEqualTo(Date value) {
			addCriterion("consume_date <=", value, "consumeDate");
			return (Criteria) this;
		}

		public Criteria andConsumeDateIn(List<Date> values) {
			addCriterion("consume_date in", values, "consumeDate");
			return (Criteria) this;
		}

		public Criteria andConsumeDateNotIn(List<Date> values) {
			addCriterion("consume_date not in", values, "consumeDate");
			return (Criteria) this;
		}

		public Criteria andConsumeDateBetween(Date value1, Date value2) {
			addCriterion("consume_date between", value1, value2, "consumeDate");
			return (Criteria) this;
		}

		public Criteria andConsumeDateNotBetween(Date value1, Date value2) {
			addCriterion("consume_date not between", value1, value2, "consumeDate");
			return (Criteria) this;
		}

		public Criteria andDownlineNameIsNull() {
			addCriterion("downline_name is null");
			return (Criteria) this;
		}

		public Criteria andDownlineNameIsNotNull() {
			addCriterion("downline_name is not null");
			return (Criteria) this;
		}

		public Criteria andDownlineNameEqualTo(String value) {
			addCriterion("downline_name =", value, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameNotEqualTo(String value) {
			addCriterion("downline_name <>", value, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameGreaterThan(String value) {
			addCriterion("downline_name >", value, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameGreaterThanOrEqualTo(String value) {
			addCriterion("downline_name >=", value, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameLessThan(String value) {
			addCriterion("downline_name <", value, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameLessThanOrEqualTo(String value) {
			addCriterion("downline_name <=", value, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameLike(String value) {
			addCriterion("downline_name like", value, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameNotLike(String value) {
			addCriterion("downline_name not like", value, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameIn(List<String> values) {
			addCriterion("downline_name in", values, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameNotIn(List<String> values) {
			addCriterion("downline_name not in", values, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameBetween(String value1, String value2) {
			addCriterion("downline_name between", value1, value2, "downlineName");
			return (Criteria) this;
		}

		public Criteria andDownlineNameNotBetween(String value1, String value2) {
			addCriterion("downline_name not between", value1, value2, "downlineName");
			return (Criteria) this;
		}

		public Criteria andOrderIdIsNull() {
			addCriterion("order_id is null");
			return (Criteria) this;
		}

		public Criteria andOrderIdIsNotNull() {
			addCriterion("order_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrderIdEqualTo(Integer value) {
			addCriterion("order_id =", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotEqualTo(Integer value) {
			addCriterion("order_id <>", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThan(Integer value) {
			addCriterion("order_id >", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_id >=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThan(Integer value) {
			addCriterion("order_id <", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
			addCriterion("order_id <=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdIn(List<Integer> values) {
			addCriterion("order_id in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotIn(List<Integer> values) {
			addCriterion("order_id not in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdBetween(Integer value1, Integer value2) {
			addCriterion("order_id between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
			addCriterion("order_id not between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andRateIsNull() {
			addCriterion("rate is null");
			return (Criteria) this;
		}

		public Criteria andRateIsNotNull() {
			addCriterion("rate is not null");
			return (Criteria) this;
		}

		public Criteria andRateEqualTo(Float value) {
			addCriterion("rate =", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotEqualTo(Float value) {
			addCriterion("rate <>", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateGreaterThan(Float value) {
			addCriterion("rate >", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateGreaterThanOrEqualTo(Float value) {
			addCriterion("rate >=", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateLessThan(Float value) {
			addCriterion("rate <", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateLessThanOrEqualTo(Float value) {
			addCriterion("rate <=", value, "rate");
			return (Criteria) this;
		}

		public Criteria andRateIn(List<Float> values) {
			addCriterion("rate in", values, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotIn(List<Float> values) {
			addCriterion("rate not in", values, "rate");
			return (Criteria) this;
		}

		public Criteria andRateBetween(Float value1, Float value2) {
			addCriterion("rate between", value1, value2, "rate");
			return (Criteria) this;
		}

		public Criteria andRateNotBetween(Float value1, Float value2) {
			addCriterion("rate not between", value1, value2, "rate");
			return (Criteria) this;
		}

		public Criteria andIncomeIsNull() {
			addCriterion("income is null");
			return (Criteria) this;
		}

		public Criteria andIncomeIsNotNull() {
			addCriterion("income is not null");
			return (Criteria) this;
		}

		public Criteria andIncomeEqualTo(Float value) {
			addCriterion("income =", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeNotEqualTo(Float value) {
			addCriterion("income <>", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeGreaterThan(Float value) {
			addCriterion("income >", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeGreaterThanOrEqualTo(Float value) {
			addCriterion("income >=", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeLessThan(Float value) {
			addCriterion("income <", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeLessThanOrEqualTo(Float value) {
			addCriterion("income <=", value, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeIn(List<Float> values) {
			addCriterion("income in", values, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeNotIn(List<Float> values) {
			addCriterion("income not in", values, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeBetween(Float value1, Float value2) {
			addCriterion("income between", value1, value2, "income");
			return (Criteria) this;
		}

		public Criteria andIncomeNotBetween(Float value1, Float value2) {
			addCriterion("income not between", value1, value2, "income");
			return (Criteria) this;
		}

		public Criteria andChargeNameIsNull() {
			addCriterion("charge_name is null");
			return (Criteria) this;
		}

		public Criteria andChargeNameIsNotNull() {
			addCriterion("charge_name is not null");
			return (Criteria) this;
		}

		public Criteria andChargeNameEqualTo(String value) {
			addCriterion("charge_name =", value, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameNotEqualTo(String value) {
			addCriterion("charge_name <>", value, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameGreaterThan(String value) {
			addCriterion("charge_name >", value, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameGreaterThanOrEqualTo(String value) {
			addCriterion("charge_name >=", value, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameLessThan(String value) {
			addCriterion("charge_name <", value, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameLessThanOrEqualTo(String value) {
			addCriterion("charge_name <=", value, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameLike(String value) {
			addCriterion("charge_name like", value, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameNotLike(String value) {
			addCriterion("charge_name not like", value, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameIn(List<String> values) {
			addCriterion("charge_name in", values, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameNotIn(List<String> values) {
			addCriterion("charge_name not in", values, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameBetween(String value1, String value2) {
			addCriterion("charge_name between", value1, value2, "chargeName");
			return (Criteria) this;
		}

		public Criteria andChargeNameNotBetween(String value1, String value2) {
			addCriterion("charge_name not between", value1, value2, "chargeName");
			return (Criteria) this;
		}

		public Criteria andLevelIsNull() {
			addCriterion("level is null");
			return (Criteria) this;
		}

		public Criteria andLevelIsNotNull() {
			addCriterion("level is not null");
			return (Criteria) this;
		}

		public Criteria andLevelEqualTo(Integer value) {
			addCriterion("level =", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotEqualTo(Integer value) {
			addCriterion("level <>", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelGreaterThan(Integer value) {
			addCriterion("level >", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
			addCriterion("level >=", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelLessThan(Integer value) {
			addCriterion("level <", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelLessThanOrEqualTo(Integer value) {
			addCriterion("level <=", value, "level");
			return (Criteria) this;
		}

		public Criteria andLevelIn(List<Integer> values) {
			addCriterion("level in", values, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotIn(List<Integer> values) {
			addCriterion("level not in", values, "level");
			return (Criteria) this;
		}

		public Criteria andLevelBetween(Integer value1, Integer value2) {
			addCriterion("level between", value1, value2, "level");
			return (Criteria) this;
		}

		public Criteria andLevelNotBetween(Integer value1, Integer value2) {
			addCriterion("level not between", value1, value2, "level");
			return (Criteria) this;
		}

		public Criteria andVirtualIsNull() {
			addCriterion("virtual is null");
			return (Criteria) this;
		}

		public Criteria andVirtualIsNotNull() {
			addCriterion("virtual is not null");
			return (Criteria) this;
		}

		public Criteria andVirtualEqualTo(String value) {
			addCriterion("virtual =", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualNotEqualTo(String value) {
			addCriterion("virtual <>", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualGreaterThan(String value) {
			addCriterion("virtual >", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualGreaterThanOrEqualTo(String value) {
			addCriterion("virtual >=", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualLessThan(String value) {
			addCriterion("virtual <", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualLessThanOrEqualTo(String value) {
			addCriterion("virtual <=", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualLike(String value) {
			addCriterion("virtual like", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualNotLike(String value) {
			addCriterion("virtual not like", value, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualIn(List<String> values) {
			addCriterion("virtual in", values, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualNotIn(List<String> values) {
			addCriterion("virtual not in", values, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualBetween(String value1, String value2) {
			addCriterion("virtual between", value1, value2, "virtual");
			return (Criteria) this;
		}

		public Criteria andVirtualNotBetween(String value1, String value2) {
			addCriterion("virtual not between", value1, value2, "virtual");
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