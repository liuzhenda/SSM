package zhenda_liu.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andConfigIsNull() {
            addCriterion("config is null");
            return (Criteria) this;
        }

        public Criteria andConfigIsNotNull() {
            addCriterion("config is not null");
            return (Criteria) this;
        }

        public Criteria andConfigEqualTo(String value) {
            addCriterion("config =", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigNotEqualTo(String value) {
            addCriterion("config <>", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigGreaterThan(String value) {
            addCriterion("config >", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigGreaterThanOrEqualTo(String value) {
            addCriterion("config >=", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigLessThan(String value) {
            addCriterion("config <", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigLessThanOrEqualTo(String value) {
            addCriterion("config <=", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigLike(String value) {
            addCriterion("config like", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigNotLike(String value) {
            addCriterion("config not like", value, "config");
            return (Criteria) this;
        }

        public Criteria andConfigIn(List<String> values) {
            addCriterion("config in", values, "config");
            return (Criteria) this;
        }

        public Criteria andConfigNotIn(List<String> values) {
            addCriterion("config not in", values, "config");
            return (Criteria) this;
        }

        public Criteria andConfigBetween(String value1, String value2) {
            addCriterion("config between", value1, value2, "config");
            return (Criteria) this;
        }

        public Criteria andConfigNotBetween(String value1, String value2) {
            addCriterion("config not between", value1, value2, "config");
            return (Criteria) this;
        }

        public Criteria andRdidIsNull() {
            addCriterion("rdid is null");
            return (Criteria) this;
        }

        public Criteria andRdidIsNotNull() {
            addCriterion("rdid is not null");
            return (Criteria) this;
        }

        public Criteria andRdidEqualTo(Integer value) {
            addCriterion("rdid =", value, "rdid");
            return (Criteria) this;
        }

        public Criteria andRdidNotEqualTo(Integer value) {
            addCriterion("rdid <>", value, "rdid");
            return (Criteria) this;
        }

        public Criteria andRdidGreaterThan(Integer value) {
            addCriterion("rdid >", value, "rdid");
            return (Criteria) this;
        }

        public Criteria andRdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rdid >=", value, "rdid");
            return (Criteria) this;
        }

        public Criteria andRdidLessThan(Integer value) {
            addCriterion("rdid <", value, "rdid");
            return (Criteria) this;
        }

        public Criteria andRdidLessThanOrEqualTo(Integer value) {
            addCriterion("rdid <=", value, "rdid");
            return (Criteria) this;
        }

        public Criteria andRdidIn(List<Integer> values) {
            addCriterion("rdid in", values, "rdid");
            return (Criteria) this;
        }

        public Criteria andRdidNotIn(List<Integer> values) {
            addCriterion("rdid not in", values, "rdid");
            return (Criteria) this;
        }

        public Criteria andRdidBetween(Integer value1, Integer value2) {
            addCriterion("rdid between", value1, value2, "rdid");
            return (Criteria) this;
        }

        public Criteria andRdidNotBetween(Integer value1, Integer value2) {
            addCriterion("rdid not between", value1, value2, "rdid");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeIsNull() {
            addCriterion("rupdatetime is null");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeIsNotNull() {
            addCriterion("rupdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeEqualTo(Date value) {
            addCriterion("rupdatetime =", value, "rupdatetime");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeNotEqualTo(Date value) {
            addCriterion("rupdatetime <>", value, "rupdatetime");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeGreaterThan(Date value) {
            addCriterion("rupdatetime >", value, "rupdatetime");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rupdatetime >=", value, "rupdatetime");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeLessThan(Date value) {
            addCriterion("rupdatetime <", value, "rupdatetime");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("rupdatetime <=", value, "rupdatetime");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeIn(List<Date> values) {
            addCriterion("rupdatetime in", values, "rupdatetime");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeNotIn(List<Date> values) {
            addCriterion("rupdatetime not in", values, "rupdatetime");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeBetween(Date value1, Date value2) {
            addCriterion("rupdatetime between", value1, value2, "rupdatetime");
            return (Criteria) this;
        }

        public Criteria andRupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("rupdatetime not between", value1, value2, "rupdatetime");
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