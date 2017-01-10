package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.DimensionFilter;
import com.amazonaws.services.cloudwatch.model.ListMetricsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ListMetricsRequestMarshaller implements Marshaller<Request<ListMetricsRequest>, ListMetricsRequest> {
    public Request<ListMetricsRequest> marshall(ListMetricsRequest listMetricsRequest) {
        if (listMetricsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ListMetricsRequest> defaultRequest = new DefaultRequest(listMetricsRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "ListMetrics");
        defaultRequest.addParameter("Version", "2010-08-01");
        if (listMetricsRequest.getNamespace() != null) {
            defaultRequest.addParameter("Namespace", StringUtils.fromString(listMetricsRequest.getNamespace()));
        }
        if (listMetricsRequest.getMetricName() != null) {
            defaultRequest.addParameter("MetricName", StringUtils.fromString(listMetricsRequest.getMetricName()));
        }
        int i = 1;
        for (DimensionFilter dimensionFilter : listMetricsRequest.getDimensions()) {
            if (dimensionFilter != null) {
                if (dimensionFilter.getName() != null) {
                    defaultRequest.addParameter("Dimensions.member." + i + ".Name", StringUtils.fromString(dimensionFilter.getName()));
                }
                if (dimensionFilter.getValue() != null) {
                    defaultRequest.addParameter("Dimensions.member." + i + ".Value", StringUtils.fromString(dimensionFilter.getValue()));
                }
            }
            i++;
        }
        if (listMetricsRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(listMetricsRequest.getNextToken()));
        }
        return defaultRequest;
    }
}
