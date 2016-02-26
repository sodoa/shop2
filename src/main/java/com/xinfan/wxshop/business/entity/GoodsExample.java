package com.xinfan.wxshop.business.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameIsNull() {
            addCriterion("goods_lname is null");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameIsNotNull() {
            addCriterion("goods_lname is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameEqualTo(String value) {
            addCriterion("goods_lname =", value, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameNotEqualTo(String value) {
            addCriterion("goods_lname <>", value, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameGreaterThan(String value) {
            addCriterion("goods_lname >", value, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_lname >=", value, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameLessThan(String value) {
            addCriterion("goods_lname <", value, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameLessThanOrEqualTo(String value) {
            addCriterion("goods_lname <=", value, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameLike(String value) {
            addCriterion("goods_lname like", value, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameNotLike(String value) {
            addCriterion("goods_lname not like", value, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameIn(List<String> values) {
            addCriterion("goods_lname in", values, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameNotIn(List<String> values) {
            addCriterion("goods_lname not in", values, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameBetween(String value1, String value2) {
            addCriterion("goods_lname between", value1, value2, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsLnameNotBetween(String value1, String value2) {
            addCriterion("goods_lname not between", value1, value2, "goodsLname");
            return (Criteria) this;
        }

        public Criteria andGoodsDesIsNull() {
            addCriterion("goods_des is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDesIsNotNull() {
            addCriterion("goods_des is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDesEqualTo(String value) {
            addCriterion("goods_des =", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesNotEqualTo(String value) {
            addCriterion("goods_des <>", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesGreaterThan(String value) {
            addCriterion("goods_des >", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesGreaterThanOrEqualTo(String value) {
            addCriterion("goods_des >=", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesLessThan(String value) {
            addCriterion("goods_des <", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesLessThanOrEqualTo(String value) {
            addCriterion("goods_des <=", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesLike(String value) {
            addCriterion("goods_des like", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesNotLike(String value) {
            addCriterion("goods_des not like", value, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesIn(List<String> values) {
            addCriterion("goods_des in", values, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesNotIn(List<String> values) {
            addCriterion("goods_des not in", values, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesBetween(String value1, String value2) {
            addCriterion("goods_des between", value1, value2, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsDesNotBetween(String value1, String value2) {
            addCriterion("goods_des not between", value1, value2, "goodsDes");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNull() {
            addCriterion("goods_status is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNotNull() {
            addCriterion("goods_status is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusEqualTo(Integer value) {
            addCriterion("goods_status =", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotEqualTo(Integer value) {
            addCriterion("goods_status <>", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThan(Integer value) {
            addCriterion("goods_status >", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_status >=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThan(Integer value) {
            addCriterion("goods_status <", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("goods_status <=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIn(List<Integer> values) {
            addCriterion("goods_status in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotIn(List<Integer> values) {
            addCriterion("goods_status not in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusBetween(Integer value1, Integer value2) {
            addCriterion("goods_status between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_status not between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlIsNull() {
            addCriterion("thumbnail_url is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlIsNotNull() {
            addCriterion("thumbnail_url is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlEqualTo(String value) {
            addCriterion("thumbnail_url =", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotEqualTo(String value) {
            addCriterion("thumbnail_url <>", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlGreaterThan(String value) {
            addCriterion("thumbnail_url >", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlGreaterThanOrEqualTo(String value) {
            addCriterion("thumbnail_url >=", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlLessThan(String value) {
            addCriterion("thumbnail_url <", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlLessThanOrEqualTo(String value) {
            addCriterion("thumbnail_url <=", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlLike(String value) {
            addCriterion("thumbnail_url like", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotLike(String value) {
            addCriterion("thumbnail_url not like", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlIn(List<String> values) {
            addCriterion("thumbnail_url in", values, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotIn(List<String> values) {
            addCriterion("thumbnail_url not in", values, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlBetween(String value1, String value2) {
            addCriterion("thumbnail_url between", value1, value2, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotBetween(String value1, String value2) {
            addCriterion("thumbnail_url not between", value1, value2, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andOrginPricesIsNull() {
            addCriterion("orgin_prices is null");
            return (Criteria) this;
        }

        public Criteria andOrginPricesIsNotNull() {
            addCriterion("orgin_prices is not null");
            return (Criteria) this;
        }

        public Criteria andOrginPricesEqualTo(Float value) {
            addCriterion("orgin_prices =", value, "orginPrices");
            return (Criteria) this;
        }

        public Criteria andOrginPricesNotEqualTo(Float value) {
            addCriterion("orgin_prices <>", value, "orginPrices");
            return (Criteria) this;
        }

        public Criteria andOrginPricesGreaterThan(Float value) {
            addCriterion("orgin_prices >", value, "orginPrices");
            return (Criteria) this;
        }

        public Criteria andOrginPricesGreaterThanOrEqualTo(Float value) {
            addCriterion("orgin_prices >=", value, "orginPrices");
            return (Criteria) this;
        }

        public Criteria andOrginPricesLessThan(Float value) {
            addCriterion("orgin_prices <", value, "orginPrices");
            return (Criteria) this;
        }

        public Criteria andOrginPricesLessThanOrEqualTo(Float value) {
            addCriterion("orgin_prices <=", value, "orginPrices");
            return (Criteria) this;
        }

        public Criteria andOrginPricesIn(List<Float> values) {
            addCriterion("orgin_prices in", values, "orginPrices");
            return (Criteria) this;
        }

        public Criteria andOrginPricesNotIn(List<Float> values) {
            addCriterion("orgin_prices not in", values, "orginPrices");
            return (Criteria) this;
        }

        public Criteria andOrginPricesBetween(Float value1, Float value2) {
            addCriterion("orgin_prices between", value1, value2, "orginPrices");
            return (Criteria) this;
        }

        public Criteria andOrginPricesNotBetween(Float value1, Float value2) {
            addCriterion("orgin_prices not between", value1, value2, "orginPrices");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Float value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Float value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Float value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Float value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Float value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Float> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Float> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Float value1, Float value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Float value1, Float value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andFinalPricesIsNull() {
            addCriterion("final_prices is null");
            return (Criteria) this;
        }

        public Criteria andFinalPricesIsNotNull() {
            addCriterion("final_prices is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPricesEqualTo(Float value) {
            addCriterion("final_prices =", value, "finalPrices");
            return (Criteria) this;
        }

        public Criteria andFinalPricesNotEqualTo(Float value) {
            addCriterion("final_prices <>", value, "finalPrices");
            return (Criteria) this;
        }

        public Criteria andFinalPricesGreaterThan(Float value) {
            addCriterion("final_prices >", value, "finalPrices");
            return (Criteria) this;
        }

        public Criteria andFinalPricesGreaterThanOrEqualTo(Float value) {
            addCriterion("final_prices >=", value, "finalPrices");
            return (Criteria) this;
        }

        public Criteria andFinalPricesLessThan(Float value) {
            addCriterion("final_prices <", value, "finalPrices");
            return (Criteria) this;
        }

        public Criteria andFinalPricesLessThanOrEqualTo(Float value) {
            addCriterion("final_prices <=", value, "finalPrices");
            return (Criteria) this;
        }

        public Criteria andFinalPricesIn(List<Float> values) {
            addCriterion("final_prices in", values, "finalPrices");
            return (Criteria) this;
        }

        public Criteria andFinalPricesNotIn(List<Float> values) {
            addCriterion("final_prices not in", values, "finalPrices");
            return (Criteria) this;
        }

        public Criteria andFinalPricesBetween(Float value1, Float value2) {
            addCriterion("final_prices between", value1, value2, "finalPrices");
            return (Criteria) this;
        }

        public Criteria andFinalPricesNotBetween(Float value1, Float value2) {
            addCriterion("final_prices not between", value1, value2, "finalPrices");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNull() {
            addCriterion("release_date is null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNotNull() {
            addCriterion("release_date is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateEqualTo(Date value) {
            addCriterion("release_date =", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotEqualTo(Date value) {
            addCriterion("release_date <>", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThan(Date value) {
            addCriterion("release_date >", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("release_date >=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThan(Date value) {
            addCriterion("release_date <", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThanOrEqualTo(Date value) {
            addCriterion("release_date <=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIn(List<Date> values) {
            addCriterion("release_date in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotIn(List<Date> values) {
            addCriterion("release_date not in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateBetween(Date value1, Date value2) {
            addCriterion("release_date between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotBetween(Date value1, Date value2) {
            addCriterion("release_date not between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andHotIsNull() {
            addCriterion("hot is null");
            return (Criteria) this;
        }

        public Criteria andHotIsNotNull() {
            addCriterion("hot is not null");
            return (Criteria) this;
        }

        public Criteria andHotEqualTo(Integer value) {
            addCriterion("hot =", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotEqualTo(Integer value) {
            addCriterion("hot <>", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThan(Integer value) {
            addCriterion("hot >", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("hot >=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThan(Integer value) {
            addCriterion("hot <", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThanOrEqualTo(Integer value) {
            addCriterion("hot <=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotIn(List<Integer> values) {
            addCriterion("hot in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotIn(List<Integer> values) {
            addCriterion("hot not in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotBetween(Integer value1, Integer value2) {
            addCriterion("hot between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotBetween(Integer value1, Integer value2) {
            addCriterion("hot not between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andBurstIsNull() {
            addCriterion("burst is null");
            return (Criteria) this;
        }

        public Criteria andBurstIsNotNull() {
            addCriterion("burst is not null");
            return (Criteria) this;
        }

        public Criteria andBurstEqualTo(Integer value) {
            addCriterion("burst =", value, "burst");
            return (Criteria) this;
        }

        public Criteria andBurstNotEqualTo(Integer value) {
            addCriterion("burst <>", value, "burst");
            return (Criteria) this;
        }

        public Criteria andBurstGreaterThan(Integer value) {
            addCriterion("burst >", value, "burst");
            return (Criteria) this;
        }

        public Criteria andBurstGreaterThanOrEqualTo(Integer value) {
            addCriterion("burst >=", value, "burst");
            return (Criteria) this;
        }

        public Criteria andBurstLessThan(Integer value) {
            addCriterion("burst <", value, "burst");
            return (Criteria) this;
        }

        public Criteria andBurstLessThanOrEqualTo(Integer value) {
            addCriterion("burst <=", value, "burst");
            return (Criteria) this;
        }

        public Criteria andBurstIn(List<Integer> values) {
            addCriterion("burst in", values, "burst");
            return (Criteria) this;
        }

        public Criteria andBurstNotIn(List<Integer> values) {
            addCriterion("burst not in", values, "burst");
            return (Criteria) this;
        }

        public Criteria andBurstBetween(Integer value1, Integer value2) {
            addCriterion("burst between", value1, value2, "burst");
            return (Criteria) this;
        }

        public Criteria andBurstNotBetween(Integer value1, Integer value2) {
            addCriterion("burst not between", value1, value2, "burst");
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

        public Criteria andTypeLevel1IsNull() {
            addCriterion("type_level1 is null");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1IsNotNull() {
            addCriterion("type_level1 is not null");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1EqualTo(String value) {
            addCriterion("type_level1 =", value, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1NotEqualTo(String value) {
            addCriterion("type_level1 <>", value, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1GreaterThan(String value) {
            addCriterion("type_level1 >", value, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1GreaterThanOrEqualTo(String value) {
            addCriterion("type_level1 >=", value, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1LessThan(String value) {
            addCriterion("type_level1 <", value, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1LessThanOrEqualTo(String value) {
            addCriterion("type_level1 <=", value, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1Like(String value) {
            addCriterion("type_level1 like", value, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1NotLike(String value) {
            addCriterion("type_level1 not like", value, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1In(List<String> values) {
            addCriterion("type_level1 in", values, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1NotIn(List<String> values) {
            addCriterion("type_level1 not in", values, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1Between(String value1, String value2) {
            addCriterion("type_level1 between", value1, value2, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel1NotBetween(String value1, String value2) {
            addCriterion("type_level1 not between", value1, value2, "typeLevel1");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2IsNull() {
            addCriterion("type_level2 is null");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2IsNotNull() {
            addCriterion("type_level2 is not null");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2EqualTo(String value) {
            addCriterion("type_level2 =", value, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2NotEqualTo(String value) {
            addCriterion("type_level2 <>", value, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2GreaterThan(String value) {
            addCriterion("type_level2 >", value, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2GreaterThanOrEqualTo(String value) {
            addCriterion("type_level2 >=", value, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2LessThan(String value) {
            addCriterion("type_level2 <", value, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2LessThanOrEqualTo(String value) {
            addCriterion("type_level2 <=", value, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2Like(String value) {
            addCriterion("type_level2 like", value, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2NotLike(String value) {
            addCriterion("type_level2 not like", value, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2In(List<String> values) {
            addCriterion("type_level2 in", values, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2NotIn(List<String> values) {
            addCriterion("type_level2 not in", values, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2Between(String value1, String value2) {
            addCriterion("type_level2 between", value1, value2, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andTypeLevel2NotBetween(String value1, String value2) {
            addCriterion("type_level2 not between", value1, value2, "typeLevel2");
            return (Criteria) this;
        }

        public Criteria andSellcountIsNull() {
            addCriterion("sellcount is null");
            return (Criteria) this;
        }

        public Criteria andSellcountIsNotNull() {
            addCriterion("sellcount is not null");
            return (Criteria) this;
        }

        public Criteria andSellcountEqualTo(Integer value) {
            addCriterion("sellcount =", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountNotEqualTo(Integer value) {
            addCriterion("sellcount <>", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountGreaterThan(Integer value) {
            addCriterion("sellcount >", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sellcount >=", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountLessThan(Integer value) {
            addCriterion("sellcount <", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountLessThanOrEqualTo(Integer value) {
            addCriterion("sellcount <=", value, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountIn(List<Integer> values) {
            addCriterion("sellcount in", values, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountNotIn(List<Integer> values) {
            addCriterion("sellcount not in", values, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountBetween(Integer value1, Integer value2) {
            addCriterion("sellcount between", value1, value2, "sellcount");
            return (Criteria) this;
        }

        public Criteria andSellcountNotBetween(Integer value1, Integer value2) {
            addCriterion("sellcount not between", value1, value2, "sellcount");
            return (Criteria) this;
        }

        public Criteria andFashionIsNull() {
            addCriterion("fashion is null");
            return (Criteria) this;
        }

        public Criteria andFashionIsNotNull() {
            addCriterion("fashion is not null");
            return (Criteria) this;
        }

        public Criteria andFashionEqualTo(Integer value) {
            addCriterion("fashion =", value, "fashion");
            return (Criteria) this;
        }

        public Criteria andFashionNotEqualTo(Integer value) {
            addCriterion("fashion <>", value, "fashion");
            return (Criteria) this;
        }

        public Criteria andFashionGreaterThan(Integer value) {
            addCriterion("fashion >", value, "fashion");
            return (Criteria) this;
        }

        public Criteria andFashionGreaterThanOrEqualTo(Integer value) {
            addCriterion("fashion >=", value, "fashion");
            return (Criteria) this;
        }

        public Criteria andFashionLessThan(Integer value) {
            addCriterion("fashion <", value, "fashion");
            return (Criteria) this;
        }

        public Criteria andFashionLessThanOrEqualTo(Integer value) {
            addCriterion("fashion <=", value, "fashion");
            return (Criteria) this;
        }

        public Criteria andFashionIn(List<Integer> values) {
            addCriterion("fashion in", values, "fashion");
            return (Criteria) this;
        }

        public Criteria andFashionNotIn(List<Integer> values) {
            addCriterion("fashion not in", values, "fashion");
            return (Criteria) this;
        }

        public Criteria andFashionBetween(Integer value1, Integer value2) {
            addCriterion("fashion between", value1, value2, "fashion");
            return (Criteria) this;
        }

        public Criteria andFashionNotBetween(Integer value1, Integer value2) {
            addCriterion("fashion not between", value1, value2, "fashion");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateIsNull() {
            addCriterion("fashion_template is null");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateIsNotNull() {
            addCriterion("fashion_template is not null");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateEqualTo(String value) {
            addCriterion("fashion_template =", value, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateNotEqualTo(String value) {
            addCriterion("fashion_template <>", value, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateGreaterThan(String value) {
            addCriterion("fashion_template >", value, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("fashion_template >=", value, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateLessThan(String value) {
            addCriterion("fashion_template <", value, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateLessThanOrEqualTo(String value) {
            addCriterion("fashion_template <=", value, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateLike(String value) {
            addCriterion("fashion_template like", value, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateNotLike(String value) {
            addCriterion("fashion_template not like", value, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateIn(List<String> values) {
            addCriterion("fashion_template in", values, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateNotIn(List<String> values) {
            addCriterion("fashion_template not in", values, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateBetween(String value1, String value2) {
            addCriterion("fashion_template between", value1, value2, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andFashionTemplateNotBetween(String value1, String value2) {
            addCriterion("fashion_template not between", value1, value2, "fashionTemplate");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaIsNull() {
            addCriterion("goods_area is null");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaIsNotNull() {
            addCriterion("goods_area is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaEqualTo(String value) {
            addCriterion("goods_area =", value, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaNotEqualTo(String value) {
            addCriterion("goods_area <>", value, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaGreaterThan(String value) {
            addCriterion("goods_area >", value, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaGreaterThanOrEqualTo(String value) {
            addCriterion("goods_area >=", value, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaLessThan(String value) {
            addCriterion("goods_area <", value, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaLessThanOrEqualTo(String value) {
            addCriterion("goods_area <=", value, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaLike(String value) {
            addCriterion("goods_area like", value, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaNotLike(String value) {
            addCriterion("goods_area not like", value, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaIn(List<String> values) {
            addCriterion("goods_area in", values, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaNotIn(List<String> values) {
            addCriterion("goods_area not in", values, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaBetween(String value1, String value2) {
            addCriterion("goods_area between", value1, value2, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andGoodsAreaNotBetween(String value1, String value2) {
            addCriterion("goods_area not between", value1, value2, "goodsArea");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
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