package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CancelConversionTaskRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CancelConversionTaskRequestMarshaller implements Marshaller<Request<CancelConversionTaskRequest>, CancelConversionTaskRequest> {
    public Request<CancelConversionTaskRequest> marshall(CancelConversionTaskRequest cancelConversionTaskRequest) {
        if (cancelConversionTaskRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CancelConversionTaskRequest> defaultRequest = new DefaultRequest(cancelConversionTaskRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CancelConversionTask");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (cancelConversionTaskRequest.getConversionTaskId() != null) {
            defaultRequest.addParameter("ConversionTaskId", StringUtils.fromString(cancelConversionTaskRequest.getConversionTaskId()));
        }
        if (cancelConversionTaskRequest.getReasonMessage() != null) {
            defaultRequest.addParameter("ReasonMessage", StringUtils.fromString(cancelConversionTaskRequest.getReasonMessage()));
        }
        return defaultRequest;
    }
}
