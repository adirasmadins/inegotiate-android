package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.GetSendStatisticsRequest;
import com.amazonaws.transform.Marshaller;

public class GetSendStatisticsRequestMarshaller implements Marshaller<Request<GetSendStatisticsRequest>, GetSendStatisticsRequest> {
    public Request<GetSendStatisticsRequest> marshall(GetSendStatisticsRequest getSendStatisticsRequest) {
        if (getSendStatisticsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetSendStatisticsRequest> defaultRequest = new DefaultRequest(getSendStatisticsRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "GetSendStatistics");
        defaultRequest.addParameter("Version", "2010-12-01");
        return defaultRequest;
    }
}
