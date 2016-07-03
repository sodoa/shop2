package com.xinfan.wxshop.business.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderExample() {
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

		public Criteria andTotalAmountIsNull() {
			addCriterion("total_amount is null");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIsNotNull() {
			addCriterion("total_amount is not null");
			return (Criteria) this;
		}

		public Criteria andTotalAmountEqualTo(Float value) {
			addCriterion("total_amount =", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotEqualTo(Float value) {
			addCriterion("total_amount <>", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountGreaterThan(Float value) {
			addCriterion("total_amount >", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountGreaterThanOrEqualTo(Float value) {
			addCriterion("total_amount >=", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountLessThan(Float value) {
			addCriterion("total_amount <", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountLessThanOrEqualTo(Float value) {
			addCriterion("total_amount <=", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIn(List<Float> values) {
			addCriterion("total_amount in", values, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotIn(List<Float> values) {
			addCriterion("total_amount not in", values, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountBetween(Float value1, Float value2) {
			addCriterion("total_amount between", value1, value2, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotBetween(Float value1, Float value2) {
			addCriterion("total_amount not between", value1, value2, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andOrderDateIsNull() {
			addCriterion("order_date is null");
			return (Criteria) this;
		}

		public Criteria andOrderDateIsNotNull() {
			addCriterion("order_date is not null");
			return (Criteria) this;
		}

		public Criteria andOrderDateEqualTo(Date value) {
			addCriterion("order_date =", value, "orderDate");
			return (Criteria) this;
		}

		public Criteria andOrderDateNotEqualTo(Date value) {
			addCriterion("order_date <>", value, "orderDate");
			return (Criteria) this;
		}

		public Criteria andOrderDateGreaterThan(Date value) {
			addCriterion("order_date >", value, "orderDate");
			return (Criteria) this;
		}

		public Criteria andOrderDateGreaterThanOrEqualTo(Date value) {
			addCriterion("order_date >=", value, "orderDate");
			return (Criteria) this;
		}

		public Criteria andOrderDateLessThan(Date value) {
			addCriterion("order_date <", value, "orderDate");
			return (Criteria) this;
		}

		public Criteria andOrderDateLessThanOrEqualTo(Date value) {
			addCriterion("order_date <=", value, "orderDate");
			return (Criteria) this;
		}

		public Criteria andOrderDateIn(List<Date> values) {
			addCriterion("order_date in", values, "orderDate");
			return (Criteria) this;
		}

		public Criteria andOrderDateNotIn(List<Date> values) {
			addCriterion("order_date not in", values, "orderDate");
			return (Criteria) this;
		}

		public Criteria andOrderDateBetween(Date value1, Date value2) {
			addCriterion("order_date between", value1, value2, "orderDate");
			return (Criteria) this;
		}

		public Criteria andOrderDateNotBetween(Date value1, Date value2) {
			addCriterion("order_date not between", value1, value2, "orderDate");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdIsNull() {
			addCriterion("delivery_id is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdIsNotNull() {
			addCriterion("delivery_id is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdEqualTo(Integer value) {
			addCriterion("delivery_id =", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdNotEqualTo(Integer value) {
			addCriterion("delivery_id <>", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdGreaterThan(Integer value) {
			addCriterion("delivery_id >", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("delivery_id >=", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdLessThan(Integer value) {
			addCriterion("delivery_id <", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdLessThanOrEqualTo(Integer value) {
			addCriterion("delivery_id <=", value, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdIn(List<Integer> values) {
			addCriterion("delivery_id in", values, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdNotIn(List<Integer> values) {
			addCriterion("delivery_id not in", values, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdBetween(Integer value1, Integer value2) {
			addCriterion("delivery_id between", value1, value2, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andDeliveryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("delivery_id not between", value1, value2, "deliveryId");
			return (Criteria) this;
		}

		public Criteria andPaymentModeIsNull() {
			addCriterion("payment_mode is null");
			return (Criteria) this;
		}

		public Criteria andPaymentModeIsNotNull() {
			addCriterion("payment_mode is not null");
			return (Criteria) this;
		}

		public Criteria andPaymentModeEqualTo(Integer value) {
			addCriterion("payment_mode =", value, "paymentMode");
			return (Criteria) this;
		}

		public Criteria andPaymentModeNotEqualTo(Integer value) {
			addCriterion("payment_mode <>", value, "paymentMode");
			return (Criteria) this;
		}

		public Criteria andPaymentModeGreaterThan(Integer value) {
			addCriterion("payment_mode >", value, "paymentMode");
			return (Criteria) this;
		}

		public Criteria andPaymentModeGreaterThanOrEqualTo(Integer value) {
			addCriterion("payment_mode >=", value, "paymentMode");
			return (Criteria) this;
		}

		public Criteria andPaymentModeLessThan(Integer value) {
			addCriterion("payment_mode <", value, "paymentMode");
			return (Criteria) this;
		}

		public Criteria andPaymentModeLessThanOrEqualTo(Integer value) {
			addCriterion("payment_mode <=", value, "paymentMode");
			return (Criteria) this;
		}

		public Criteria andPaymentModeIn(List<Integer> values) {
			addCriterion("payment_mode in", values, "paymentMode");
			return (Criteria) this;
		}

		public Criteria andPaymentModeNotIn(List<Integer> values) {
			addCriterion("payment_mode not in", values, "paymentMode");
			return (Criteria) this;
		}

		public Criteria andPaymentModeBetween(Integer value1, Integer value2) {
			addCriterion("payment_mode between", value1, value2, "paymentMode");
			return (Criteria) this;
		}

		public Criteria andPaymentModeNotBetween(Integer value1, Integer value2) {
			addCriterion("payment_mode not between", value1, value2, "paymentMode");
			return (Criteria) this;
		}

		public Criteria andMarkIsNull() {
			addCriterion("mark is null");
			return (Criteria) this;
		}

		public Criteria andMarkIsNotNull() {
			addCriterion("mark is not null");
			return (Criteria) this;
		}

		public Criteria andMarkEqualTo(String value) {
			addCriterion("mark =", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotEqualTo(String value) {
			addCriterion("mark <>", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkGreaterThan(String value) {
			addCriterion("mark >", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkGreaterThanOrEqualTo(String value) {
			addCriterion("mark >=", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkLessThan(String value) {
			addCriterion("mark <", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkLessThanOrEqualTo(String value) {
			addCriterion("mark <=", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkLike(String value) {
			addCriterion("mark like", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotLike(String value) {
			addCriterion("mark not like", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkIn(List<String> values) {
			addCriterion("mark in", values, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotIn(List<String> values) {
			addCriterion("mark not in", values, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkBetween(String value1, String value2) {
			addCriterion("mark between", value1, value2, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotBetween(String value1, String value2) {
			addCriterion("mark not between", value1, value2, "mark");
			return (Criteria) this;
		}

		public Criteria andSharedIsNull() {
			addCriterion("shared is null");
			return (Criteria) this;
		}

		public Criteria andSharedIsNotNull() {
			addCriterion("shared is not null");
			return (Criteria) this;
		}

		public Criteria andSharedEqualTo(Integer value) {
			addCriterion("shared =", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedNotEqualTo(Integer value) {
			addCriterion("shared <>", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedGreaterThan(Integer value) {
			addCriterion("shared >", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedGreaterThanOrEqualTo(Integer value) {
			addCriterion("shared >=", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedLessThan(Integer value) {
			addCriterion("shared <", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedLessThanOrEqualTo(Integer value) {
			addCriterion("shared <=", value, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedIn(List<Integer> values) {
			addCriterion("shared in", values, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedNotIn(List<Integer> values) {
			addCriterion("shared not in", values, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedBetween(Integer value1, Integer value2) {
			addCriterion("shared between", value1, value2, "shared");
			return (Criteria) this;
		}

		public Criteria andSharedNotBetween(Integer value1, Integer value2) {
			addCriterion("shared not between", value1, value2, "shared");
			return (Criteria) this;
		}

		public Criteria andDisStatusIsNull() {
			addCriterion("dis_status is null");
			return (Criteria) this;
		}

		public Criteria andDisStatusIsNotNull() {
			addCriterion("dis_status is not null");
			return (Criteria) this;
		}

		public Criteria andDisStatusEqualTo(Integer value) {
			addCriterion("dis_status =", value, "disStatus");
			return (Criteria) this;
		}

		public Criteria andDisStatusNotEqualTo(Integer value) {
			addCriterion("dis_status <>", value, "disStatus");
			return (Criteria) this;
		}

		public Criteria andDisStatusGreaterThan(Integer value) {
			addCriterion("dis_status >", value, "disStatus");
			return (Criteria) this;
		}

		public Criteria andDisStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("dis_status >=", value, "disStatus");
			return (Criteria) this;
		}

		public Criteria andDisStatusLessThan(Integer value) {
			addCriterion("dis_status <", value, "disStatus");
			return (Criteria) this;
		}

		public Criteria andDisStatusLessThanOrEqualTo(Integer value) {
			addCriterion("dis_status <=", value, "disStatus");
			return (Criteria) this;
		}

		public Criteria andDisStatusIn(List<Integer> values) {
			addCriterion("dis_status in", values, "disStatus");
			return (Criteria) this;
		}

		public Criteria andDisStatusNotIn(List<Integer> values) {
			addCriterion("dis_status not in", values, "disStatus");
			return (Criteria) this;
		}

		public Criteria andDisStatusBetween(Integer value1, Integer value2) {
			addCriterion("dis_status between", value1, value2, "disStatus");
			return (Criteria) this;
		}

		public Criteria andDisStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("dis_status not between", value1, value2, "disStatus");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressIsNull() {
			addCriterion("receiver_address is null");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressIsNotNull() {
			addCriterion("receiver_address is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressEqualTo(String value) {
			addCriterion("receiver_address =", value, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressNotEqualTo(String value) {
			addCriterion("receiver_address <>", value, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressGreaterThan(String value) {
			addCriterion("receiver_address >", value, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_address >=", value, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressLessThan(String value) {
			addCriterion("receiver_address <", value, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
			addCriterion("receiver_address <=", value, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressLike(String value) {
			addCriterion("receiver_address like", value, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressNotLike(String value) {
			addCriterion("receiver_address not like", value, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressIn(List<String> values) {
			addCriterion("receiver_address in", values, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressNotIn(List<String> values) {
			addCriterion("receiver_address not in", values, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressBetween(String value1, String value2) {
			addCriterion("receiver_address between", value1, value2, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverAddressNotBetween(String value1, String value2) {
			addCriterion("receiver_address not between", value1, value2, "receiverAddress");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIsNull() {
			addCriterion("receiver_name is null");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIsNotNull() {
			addCriterion("receiver_name is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverNameEqualTo(String value) {
			addCriterion("receiver_name =", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotEqualTo(String value) {
			addCriterion("receiver_name <>", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameGreaterThan(String value) {
			addCriterion("receiver_name >", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_name >=", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLessThan(String value) {
			addCriterion("receiver_name <", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLessThanOrEqualTo(String value) {
			addCriterion("receiver_name <=", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameLike(String value) {
			addCriterion("receiver_name like", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotLike(String value) {
			addCriterion("receiver_name not like", value, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameIn(List<String> values) {
			addCriterion("receiver_name in", values, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotIn(List<String> values) {
			addCriterion("receiver_name not in", values, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameBetween(String value1, String value2) {
			addCriterion("receiver_name between", value1, value2, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverNameNotBetween(String value1, String value2) {
			addCriterion("receiver_name not between", value1, value2, "receiverName");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneIsNull() {
			addCriterion("receiver_phone is null");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneIsNotNull() {
			addCriterion("receiver_phone is not null");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneEqualTo(String value) {
			addCriterion("receiver_phone =", value, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneNotEqualTo(String value) {
			addCriterion("receiver_phone <>", value, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneGreaterThan(String value) {
			addCriterion("receiver_phone >", value, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("receiver_phone >=", value, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneLessThan(String value) {
			addCriterion("receiver_phone <", value, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
			addCriterion("receiver_phone <=", value, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneLike(String value) {
			addCriterion("receiver_phone like", value, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneNotLike(String value) {
			addCriterion("receiver_phone not like", value, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneIn(List<String> values) {
			addCriterion("receiver_phone in", values, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneNotIn(List<String> values) {
			addCriterion("receiver_phone not in", values, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneBetween(String value1, String value2) {
			addCriterion("receiver_phone between", value1, value2, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andReceiverPhoneNotBetween(String value1, String value2) {
			addCriterion("receiver_phone not between", value1, value2, "receiverPhone");
			return (Criteria) this;
		}

		public Criteria andAppraiseIsNull() {
			addCriterion("appraise is null");
			return (Criteria) this;
		}

		public Criteria andAppraiseIsNotNull() {
			addCriterion("appraise is not null");
			return (Criteria) this;
		}

		public Criteria andAppraiseEqualTo(Integer value) {
			addCriterion("appraise =", value, "appraise");
			return (Criteria) this;
		}

		public Criteria andAppraiseNotEqualTo(Integer value) {
			addCriterion("appraise <>", value, "appraise");
			return (Criteria) this;
		}

		public Criteria andAppraiseGreaterThan(Integer value) {
			addCriterion("appraise >", value, "appraise");
			return (Criteria) this;
		}

		public Criteria andAppraiseGreaterThanOrEqualTo(Integer value) {
			addCriterion("appraise >=", value, "appraise");
			return (Criteria) this;
		}

		public Criteria andAppraiseLessThan(Integer value) {
			addCriterion("appraise <", value, "appraise");
			return (Criteria) this;
		}

		public Criteria andAppraiseLessThanOrEqualTo(Integer value) {
			addCriterion("appraise <=", value, "appraise");
			return (Criteria) this;
		}

		public Criteria andAppraiseIn(List<Integer> values) {
			addCriterion("appraise in", values, "appraise");
			return (Criteria) this;
		}

		public Criteria andAppraiseNotIn(List<Integer> values) {
			addCriterion("appraise not in", values, "appraise");
			return (Criteria) this;
		}

		public Criteria andAppraiseBetween(Integer value1, Integer value2) {
			addCriterion("appraise between", value1, value2, "appraise");
			return (Criteria) this;
		}

		public Criteria andAppraiseNotBetween(Integer value1, Integer value2) {
			addCriterion("appraise not between", value1, value2, "appraise");
			return (Criteria) this;
		}

		public Criteria andOrderNoIsNull() {
			addCriterion("order_no is null");
			return (Criteria) this;
		}

		public Criteria andOrderNoIsNotNull() {
			addCriterion("order_no is not null");
			return (Criteria) this;
		}

		public Criteria andOrderNoEqualTo(String value) {
			addCriterion("order_no =", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoNotEqualTo(String value) {
			addCriterion("order_no <>", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoGreaterThan(String value) {
			addCriterion("order_no >", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
			addCriterion("order_no >=", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoLessThan(String value) {
			addCriterion("order_no <", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoLessThanOrEqualTo(String value) {
			addCriterion("order_no <=", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoLike(String value) {
			addCriterion("order_no like", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoNotLike(String value) {
			addCriterion("order_no not like", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoIn(List<String> values) {
			addCriterion("order_no in", values, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoNotIn(List<String> values) {
			addCriterion("order_no not in", values, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoBetween(String value1, String value2) {
			addCriterion("order_no between", value1, value2, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoNotBetween(String value1, String value2) {
			addCriterion("order_no not between", value1, value2, "orderNo");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityIsNull() {
			addCriterion("total_quantity is null");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityIsNotNull() {
			addCriterion("total_quantity is not null");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityEqualTo(Integer value) {
			addCriterion("total_quantity =", value, "totalQuantity");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityNotEqualTo(Integer value) {
			addCriterion("total_quantity <>", value, "totalQuantity");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityGreaterThan(Integer value) {
			addCriterion("total_quantity >", value, "totalQuantity");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityGreaterThanOrEqualTo(Integer value) {
			addCriterion("total_quantity >=", value, "totalQuantity");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityLessThan(Integer value) {
			addCriterion("total_quantity <", value, "totalQuantity");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityLessThanOrEqualTo(Integer value) {
			addCriterion("total_quantity <=", value, "totalQuantity");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityIn(List<Integer> values) {
			addCriterion("total_quantity in", values, "totalQuantity");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityNotIn(List<Integer> values) {
			addCriterion("total_quantity not in", values, "totalQuantity");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityBetween(Integer value1, Integer value2) {
			addCriterion("total_quantity between", value1, value2, "totalQuantity");
			return (Criteria) this;
		}

		public Criteria andTotalQuantityNotBetween(Integer value1, Integer value2) {
			addCriterion("total_quantity not between", value1, value2, "totalQuantity");
			return (Criteria) this;
		}

		public Criteria andPostageIsNull() {
			addCriterion("postage is null");
			return (Criteria) this;
		}

		public Criteria andPostageIsNotNull() {
			addCriterion("postage is not null");
			return (Criteria) this;
		}

		public Criteria andPostageEqualTo(Integer value) {
			addCriterion("postage =", value, "postage");
			return (Criteria) this;
		}

		public Criteria andPostageNotEqualTo(Integer value) {
			addCriterion("postage <>", value, "postage");
			return (Criteria) this;
		}

		public Criteria andPostageGreaterThan(Integer value) {
			addCriterion("postage >", value, "postage");
			return (Criteria) this;
		}

		public Criteria andPostageGreaterThanOrEqualTo(Integer value) {
			addCriterion("postage >=", value, "postage");
			return (Criteria) this;
		}

		public Criteria andPostageLessThan(Integer value) {
			addCriterion("postage <", value, "postage");
			return (Criteria) this;
		}

		public Criteria andPostageLessThanOrEqualTo(Integer value) {
			addCriterion("postage <=", value, "postage");
			return (Criteria) this;
		}

		public Criteria andPostageIn(List<Integer> values) {
			addCriterion("postage in", values, "postage");
			return (Criteria) this;
		}

		public Criteria andPostageNotIn(List<Integer> values) {
			addCriterion("postage not in", values, "postage");
			return (Criteria) this;
		}

		public Criteria andPostageBetween(Integer value1, Integer value2) {
			addCriterion("postage between", value1, value2, "postage");
			return (Criteria) this;
		}

		public Criteria andPostageNotBetween(Integer value1, Integer value2) {
			addCriterion("postage not between", value1, value2, "postage");
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