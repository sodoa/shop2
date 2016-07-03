package com.xinfan.wxshop.business.entity;

import java.util.ArrayList;
import java.util.List;

public class RankingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RankingExample() {
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

        public Criteria andRankingIdIsNull() {
            addCriterion("ranking_id is null");
            return (Criteria) this;
        }

        public Criteria andRankingIdIsNotNull() {
            addCriterion("ranking_id is not null");
            return (Criteria) this;
        }

        public Criteria andRankingIdEqualTo(Integer value) {
            addCriterion("ranking_id =", value, "rankingId");
            return (Criteria) this;
        }

        public Criteria andRankingIdNotEqualTo(Integer value) {
            addCriterion("ranking_id <>", value, "rankingId");
            return (Criteria) this;
        }

        public Criteria andRankingIdGreaterThan(Integer value) {
            addCriterion("ranking_id >", value, "rankingId");
            return (Criteria) this;
        }

        public Criteria andRankingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ranking_id >=", value, "rankingId");
            return (Criteria) this;
        }

        public Criteria andRankingIdLessThan(Integer value) {
            addCriterion("ranking_id <", value, "rankingId");
            return (Criteria) this;
        }

        public Criteria andRankingIdLessThanOrEqualTo(Integer value) {
            addCriterion("ranking_id <=", value, "rankingId");
            return (Criteria) this;
        }

        public Criteria andRankingIdIn(List<Integer> values) {
            addCriterion("ranking_id in", values, "rankingId");
            return (Criteria) this;
        }

        public Criteria andRankingIdNotIn(List<Integer> values) {
            addCriterion("ranking_id not in", values, "rankingId");
            return (Criteria) this;
        }

        public Criteria andRankingIdBetween(Integer value1, Integer value2) {
            addCriterion("ranking_id between", value1, value2, "rankingId");
            return (Criteria) this;
        }

        public Criteria andRankingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ranking_id not between", value1, value2, "rankingId");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIsNull() {
            addCriterion("goodstype is null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIsNotNull() {
            addCriterion("goodstype is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeEqualTo(Integer value) {
            addCriterion("goodstype =", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotEqualTo(Integer value) {
            addCriterion("goodstype <>", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeGreaterThan(Integer value) {
            addCriterion("goodstype >", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodstype >=", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeLessThan(Integer value) {
            addCriterion("goodstype <", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeLessThanOrEqualTo(Integer value) {
            addCriterion("goodstype <=", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIn(List<Integer> values) {
            addCriterion("goodstype in", values, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotIn(List<Integer> values) {
            addCriterion("goodstype not in", values, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeBetween(Integer value1, Integer value2) {
            addCriterion("goodstype between", value1, value2, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotBetween(Integer value1, Integer value2) {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andDespIsNull() {
            addCriterion("desp is null");
            return (Criteria) this;
        }

        public Criteria andDespIsNotNull() {
            addCriterion("desp is not null");
            return (Criteria) this;
        }

        public Criteria andDespEqualTo(String value) {
            addCriterion("desp =", value, "desp");
            return (Criteria) this;
        }

        public Criteria andDespNotEqualTo(String value) {
            addCriterion("desp <>", value, "desp");
            return (Criteria) this;
        }

        public Criteria andDespGreaterThan(String value) {
            addCriterion("desp >", value, "desp");
            return (Criteria) this;
        }

        public Criteria andDespGreaterThanOrEqualTo(String value) {
            addCriterion("desp >=", value, "desp");
            return (Criteria) this;
        }

        public Criteria andDespLessThan(String value) {
            addCriterion("desp <", value, "desp");
            return (Criteria) this;
        }

        public Criteria andDespLessThanOrEqualTo(String value) {
            addCriterion("desp <=", value, "desp");
            return (Criteria) this;
        }

        public Criteria andDespLike(String value) {
            addCriterion("desp like", value, "desp");
            return (Criteria) this;
        }

        public Criteria andDespNotLike(String value) {
            addCriterion("desp not like", value, "desp");
            return (Criteria) this;
        }

        public Criteria andDespIn(List<String> values) {
            addCriterion("desp in", values, "desp");
            return (Criteria) this;
        }

        public Criteria andDespNotIn(List<String> values) {
            addCriterion("desp not in", values, "desp");
            return (Criteria) this;
        }

        public Criteria andDespBetween(String value1, String value2) {
            addCriterion("desp between", value1, value2, "desp");
            return (Criteria) this;
        }

        public Criteria andDespNotBetween(String value1, String value2) {
            addCriterion("desp not between", value1, value2, "desp");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
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