package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetMetricStatisticsRequestMarshaller implements Marshaller<Request<GetMetricStatisticsRequest>, GetMetricStatisticsRequest> {
    public Request<GetMetricStatisticsRequest> marshall(GetMetricStatisticsRequest getMetricStatisticsRequest) {
        int i = 1;
        if (getMetricStatisticsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetMetricStatisticsRequest> defaultRequest = new DefaultRequest(getMetricStatisticsRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "GetMetricStatistics");
        defaultRequest.addParameter("Version", "2010-08-01");
        if (getMetricStatisticsRequest.getNamespace() != null) {
            defaultRequest.addParameter("Namespace", StringUtils.fromString(getMetricStatisticsRequest.getNamespace()));
        }
        if (getMetricStatisticsRequest.getMetricName() != null) {
            defaultRequest.addParameter("MetricName", StringUtils.fromString(getMetricStatisticsRequest.getMetricName()));
        }
        int i2 = 1;
        for (Dimension dimension : getMetricStatisticsRequest.getDimensions()) {
            if (dimension != null) {
                if (dimension.getName() != null) {
                    defaultRequest.addParameter("Dimensions.member." + i2 + ".Name", StringUtils.fromString(dimension.getName()));
                }
                if (dimension.getValue() != null) {
                    defaultRequest.addParameter("Dimensions.member." + i2 + ".Value", StringUtils.fromString(dimension.getValue()));
                }
            }
            i2++;
        }
        if (getMetricStatisticsRequest.getStartTime() != null) {
            defaultRequest.addParameter("StartTime", StringUtils.fromDate(getMetricStatisticsRequest.getStartTime()));
        }
        if (getMetricStatisticsRequest.getEndTime() != null) {
            defaultRequest.addParameter("EndTime", StringUtils.fromDate(getMetricStatisticsRequest.getEndTime()));
        }
        if (getMetricStatisticsRequest.getPeriod() != null) {
            defaultRequest.addParameter("Period", StringUtils.fromInteger(getMetricStatisticsRequest.getPeriod()));
        }
        for (String str : getMetricStatisticsRequest.getStatistics()) {
            if (str != null) {
                defaultRequest.addParameter("Statistics.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (getMetricStatisticsRequest.getUnit() != null) {
            defaultRequest.addParameter("Unit", StringUtils.fromString(getMetricStatisticsRequest.getUnit()));
        }
        return defaultRequest;
    }
}
