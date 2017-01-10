package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricRequest;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeAlarmsForMetricRequestMarshaller implements Marshaller<Request<DescribeAlarmsForMetricRequest>, DescribeAlarmsForMetricRequest> {
    public Request<DescribeAlarmsForMetricRequest> marshall(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest) {
        if (describeAlarmsForMetricRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeAlarmsForMetricRequest> defaultRequest = new DefaultRequest(describeAlarmsForMetricRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "DescribeAlarmsForMetric");
        defaultRequest.addParameter("Version", "2010-08-01");
        if (describeAlarmsForMetricRequest.getMetricName() != null) {
            defaultRequest.addParameter("MetricName", StringUtils.fromString(describeAlarmsForMetricRequest.getMetricName()));
        }
        if (describeAlarmsForMetricRequest.getNamespace() != null) {
            defaultRequest.addParameter("Namespace", StringUtils.fromString(describeAlarmsForMetricRequest.getNamespace()));
        }
        if (describeAlarmsForMetricRequest.getStatistic() != null) {
            defaultRequest.addParameter("Statistic", StringUtils.fromString(describeAlarmsForMetricRequest.getStatistic()));
        }
        int i = 1;
        for (Dimension dimension : describeAlarmsForMetricRequest.getDimensions()) {
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
        if (describeAlarmsForMetricRequest.getPeriod() != null) {
            defaultRequest.addParameter("Period", StringUtils.fromInteger(describeAlarmsForMetricRequest.getPeriod()));
        }
        if (describeAlarmsForMetricRequest.getUnit() != null) {
            defaultRequest.addParameter("Unit", StringUtils.fromString(describeAlarmsForMetricRequest.getUnit()));
        }
        return defaultRequest;
    }
}
