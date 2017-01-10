package com.amazonaws.auth.policy.conditions;

import com.amazonaws.auth.policy.Condition;
import com.amazonaws.util.DateUtils;
import java.util.Arrays;
import java.util.Date;

public class DateCondition extends Condition {
    private final DateUtils dateUtils;

    public enum DateComparisonType {
        DateEquals,
        DateGreaterThan,
        DateGreaterThanEquals,
        DateLessThan,
        DateLessThanEquals,
        DateNotEquals
    }

    public DateCondition(DateComparisonType dateComparisonType, Date date) {
        this.dateUtils = new DateUtils();
        this.type = dateComparisonType.toString();
        this.conditionKey = ConditionFactory.CURRENT_TIME_CONDITION_KEY;
        this.values = Arrays.asList(new String[]{this.dateUtils.formatIso8601Date(date)});
    }
}
