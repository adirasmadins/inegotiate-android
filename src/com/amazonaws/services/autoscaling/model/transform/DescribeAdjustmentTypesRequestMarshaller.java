package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeAdjustmentTypesRequest;
import com.amazonaws.transform.Marshaller;

public class DescribeAdjustmentTypesRequestMarshaller implements Marshaller<Request<DescribeAdjustmentTypesRequest>, DescribeAdjustmentTypesRequest> {
    public Request<DescribeAdjustmentTypesRequest> marshall(DescribeAdjustmentTypesRequest describeAdjustmentTypesRequest) {
        if (describeAdjustmentTypesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeAdjustmentTypesRequest> defaultRequest = new DefaultRequest(describeAdjustmentTypesRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeAdjustmentTypes");
        defaultRequest.addParameter("Version", "2011-01-01");
        return defaultRequest;
    }
}
