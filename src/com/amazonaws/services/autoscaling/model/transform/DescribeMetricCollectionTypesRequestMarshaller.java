package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeMetricCollectionTypesRequest;
import com.amazonaws.transform.Marshaller;

public class DescribeMetricCollectionTypesRequestMarshaller implements Marshaller<Request<DescribeMetricCollectionTypesRequest>, DescribeMetricCollectionTypesRequest> {
    public Request<DescribeMetricCollectionTypesRequest> marshall(DescribeMetricCollectionTypesRequest describeMetricCollectionTypesRequest) {
        if (describeMetricCollectionTypesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeMetricCollectionTypesRequest> defaultRequest = new DefaultRequest(describeMetricCollectionTypesRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeMetricCollectionTypes");
        defaultRequest.addParameter("Version", "2011-01-01");
        return defaultRequest;
    }
}
