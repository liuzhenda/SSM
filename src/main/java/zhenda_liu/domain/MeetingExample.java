package zhenda_liu.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeetingExample() {
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

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Integer value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Integer value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Integer value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Integer value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Integer value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Integer> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Integer> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Integer value1, Integer value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMridIsNull() {
            addCriterion("mrid is null");
            return (Criteria) this;
        }

        public Criteria andMridIsNotNull() {
            addCriterion("mrid is not null");
            return (Criteria) this;
        }

        public Criteria andMridEqualTo(Integer value) {
            addCriterion("mrid =", value, "mrid");
            return (Criteria) this;
        }

        public Criteria andMridNotEqualTo(Integer value) {
            addCriterion("mrid <>", value, "mrid");
            return (Criteria) this;
        }

        public Criteria andMridGreaterThan(Integer value) {
            addCriterion("mrid >", value, "mrid");
            return (Criteria) this;
        }

        public Criteria andMridGreaterThanOrEqualTo(Integer value) {
            addCriterion("mrid >=", value, "mrid");
            return (Criteria) this;
        }

        public Criteria andMridLessThan(Integer value) {
            addCriterion("mrid <", value, "mrid");
            return (Criteria) this;
        }

        public Criteria andMridLessThanOrEqualTo(Integer value) {
            addCriterion("mrid <=", value, "mrid");
            return (Criteria) this;
        }

        public Criteria andMridIn(List<Integer> values) {
            addCriterion("mrid in", values, "mrid");
            return (Criteria) this;
        }

        public Criteria andMridNotIn(List<Integer> values) {
            addCriterion("mrid not in", values, "mrid");
            return (Criteria) this;
        }

        public Criteria andMridBetween(Integer value1, Integer value2) {
            addCriterion("mrid between", value1, value2, "mrid");
            return (Criteria) this;
        }

        public Criteria andMridNotBetween(Integer value1, Integer value2) {
            addCriterion("mrid not between", value1, value2, "mrid");
            return (Criteria) this;
        }

        public Criteria andOuidIsNull() {
            addCriterion("ouid is null");
            return (Criteria) this;
        }

        public Criteria andOuidIsNotNull() {
            addCriterion("ouid is not null");
            return (Criteria) this;
        }

        public Criteria andOuidEqualTo(Integer value) {
            addCriterion("ouid =", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidNotEqualTo(Integer value) {
            addCriterion("ouid <>", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidGreaterThan(Integer value) {
            addCriterion("ouid >", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ouid >=", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidLessThan(Integer value) {
            addCriterion("ouid <", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidLessThanOrEqualTo(Integer value) {
            addCriterion("ouid <=", value, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidIn(List<Integer> values) {
            addCriterion("ouid in", values, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidNotIn(List<Integer> values) {
            addCriterion("ouid not in", values, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidBetween(Integer value1, Integer value2) {
            addCriterion("ouid between", value1, value2, "ouid");
            return (Criteria) this;
        }

        public Criteria andOuidNotBetween(Integer value1, Integer value2) {
            addCriterion("ouid not between", value1, value2, "ouid");
            return (Criteria) this;
        }

        public Criteria andStarttIsNull() {
            addCriterion("startt is null");
            return (Criteria) this;
        }

        public Criteria andStarttIsNotNull() {
            addCriterion("startt is not null");
            return (Criteria) this;
        }

        public Criteria andStarttEqualTo(Date value) {
            addCriterion("startt =", value, "startt");
            return (Criteria) this;
        }

        public Criteria andStarttNotEqualTo(Date value) {
            addCriterion("startt <>", value, "startt");
            return (Criteria) this;
        }

        public Criteria andStarttGreaterThan(Date value) {
            addCriterion("startt >", value, "startt");
            return (Criteria) this;
        }

        public Criteria andStarttGreaterThanOrEqualTo(Date value) {
            addCriterion("startt >=", value, "startt");
            return (Criteria) this;
        }

        public Criteria andStarttLessThan(Date value) {
            addCriterion("startt <", value, "startt");
            return (Criteria) this;
        }

        public Criteria andStarttLessThanOrEqualTo(Date value) {
            addCriterion("startt <=", value, "startt");
            return (Criteria) this;
        }

        public Criteria andStarttIn(List<Date> values) {
            addCriterion("startt in", values, "startt");
            return (Criteria) this;
        }

        public Criteria andStarttNotIn(List<Date> values) {
            addCriterion("startt not in", values, "startt");
            return (Criteria) this;
        }

        public Criteria andStarttBetween(Date value1, Date value2) {
            addCriterion("startt between", value1, value2, "startt");
            return (Criteria) this;
        }

        public Criteria andStarttNotBetween(Date value1, Date value2) {
            addCriterion("startt not between", value1, value2, "startt");
            return (Criteria) this;
        }

        public Criteria andFtimeIsNull() {
            addCriterion("ftime is null");
            return (Criteria) this;
        }

        public Criteria andFtimeIsNotNull() {
            addCriterion("ftime is not null");
            return (Criteria) this;
        }

        public Criteria andFtimeEqualTo(Date value) {
            addCriterion("ftime =", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeNotEqualTo(Date value) {
            addCriterion("ftime <>", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeGreaterThan(Date value) {
            addCriterion("ftime >", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ftime >=", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeLessThan(Date value) {
            addCriterion("ftime <", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeLessThanOrEqualTo(Date value) {
            addCriterion("ftime <=", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeIn(List<Date> values) {
            addCriterion("ftime in", values, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeNotIn(List<Date> values) {
            addCriterion("ftime not in", values, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeBetween(Date value1, Date value2) {
            addCriterion("ftime between", value1, value2, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeNotBetween(Date value1, Date value2) {
            addCriterion("ftime not between", value1, value2, "ftime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeIsNull() {
            addCriterion("mupdatetime is null");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeIsNotNull() {
            addCriterion("mupdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeEqualTo(Date value) {
            addCriterion("mupdatetime =", value, "mupdatetime");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeNotEqualTo(Date value) {
            addCriterion("mupdatetime <>", value, "mupdatetime");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeGreaterThan(Date value) {
            addCriterion("mupdatetime >", value, "mupdatetime");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mupdatetime >=", value, "mupdatetime");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeLessThan(Date value) {
            addCriterion("mupdatetime <", value, "mupdatetime");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("mupdatetime <=", value, "mupdatetime");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeIn(List<Date> values) {
            addCriterion("mupdatetime in", values, "mupdatetime");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeNotIn(List<Date> values) {
            addCriterion("mupdatetime not in", values, "mupdatetime");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeBetween(Date value1, Date value2) {
            addCriterion("mupdatetime between", value1, value2, "mupdatetime");
            return (Criteria) this;
        }

        public Criteria andMupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("mupdatetime not between", value1, value2, "mupdatetime");
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