package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.PutMetricAlarmRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class PutMetricAlarmRequestMarshaller implements Marshaller<Request<PutMetricAlarmRequest>, PutMetricAlarmRequest> {
    public Request<PutMetricAlarmRequest> marshall(PutMetricAlarmRequest putMetricAlarmRequest) {
        int i = 1;
        if (putMetricAlarmRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<PutMetricAlarmRequest> defaultRequest = new DefaultRequest(putMetricAlarmRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "PutMetricAlarm");
        defaultRequest.addParameter("Version", "2010-08-01");
        if (putMetricAlarmRequest.getAlarmName() != null) {
            defaultRequest.addParameter("AlarmName", StringUtils.fromString(putMetricAlarmRequest.getAlarmName()));
        }
        if (putMetricAlarmRequest.getAlarmDescription() != null) {
            defaultRequest.addParameter("AlarmDescription", StringUtils.fromString(putMetricAlarmRequest.getAlarmDescription()));
        }
        if (putMetricAlarmRequest.isActionsEnabled() != null) {
            defaultRequest.addParameter("ActionsEnabled", StringUtils.fromBoolean(putMetricAlarmRequest.isActionsEnabled()));
        }
        int i2 = 1;
        for (String str : putMetricAlarmRequest.getOKActions()) {
            if (str != null) {
                defaultRequest.addParameter("OKActions.member." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        i2 = 1;
        for (String str2 : putMetricAlarmRequest.getAlarmActions()) {
            if (str2 != null) {
                defaultRequest.addParameter("AlarmActions.member." + i2, StringUtils.fromString(str2));
            }
            i2++;
        }
        i2 = 1;
        for (String str22 : putMetricAlarmRequest.getInsufficientDataActions()) {
            if (str22 != null) {
                defaultRequest.addParameter("InsufficientDataActions.member." + i2, StringUtils.fromString(str22));
            }
            i2++;
        }
        if (putMetricAlarmRequest.getMetricName() != null) {
            defaultRequest.addParameter("MetricName", StringUtils.fromString(putMetricAlarmRequest.getMetricName()));
        }
        if (putMetricAlarmRequest.getNamespace() != null) {
            defaultRequest.addParameter("Namespace", StringUtils.fromString(putMetricAlarmRequest.getNamespace()));
        }
        if (putMetricAlarmRequest.getStatistic() != null) {
            defaultRequest.addParameter("Statistic", StringUtils.fromString(putMetricAlarmRequest.getStatistic()));
        }
        for (Dimension dimension : putMetricAlarmRequest.getDimensions()) {
            if (dimension != null) {
                if (dimension.getName() != null) {
                    defaultRequest.addParameter("Dimensions.member." + i + ".Name", StringUtils.fromString(dimension.getName()));
                }
                if (dimension.getValue() != null) {
                    defaultRequest.addParameter("Dimensions.member." + i + ".Value", StringUtils.fromString(dimension.getValue()));
                }
            }
            i++;
        }
        if (putMetricAlarmRequest.getPeriod() != null) {
            defaultRequest.addParameter("Period", StringUtils.fromInteger(putMetricAlarmRequest.getPeriod()));
        }
        if (putMetricAlarmRequest.getUnit() != null) {
            defaultRequest.addParameter("Unit", StringUtils.fromString(putMetricAlarmRequest.getUnit()));
        }
        if (putMetricAlarmRequest.getEvaluationPeriods() != null) {
            defaultRequest.addParameter("EvaluationPeriods", StringUtils.fromInteger(putMetricAlarmRequest.getEvaluationPeriods()));
        }
        if (putMetricAlarmRequest.getThreshold() != null) {
            defaultRequest.addParameter("Threshold", StringUtils.fromDouble(putMetricAlarmRequest.getThreshold()));
        }
        if (putMetricAlarmRequest.getComparisonOperator() != null) {
            defaultRequest.addParameter("ComparisonOperator", StringUtils.fromString(putMetricAlarmRequest.getComparisonOperator()));
        }
        return defaultRequest;
    }
}
