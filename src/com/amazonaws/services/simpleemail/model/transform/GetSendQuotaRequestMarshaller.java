package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.GetSendQuotaRequest;
import com.amazonaws.transform.Marshaller;

public class GetSendQuotaRequestMarshaller implements Marshaller<Request<GetSendQuotaRequest>, GetSendQuotaRequest> {
    public Request<GetSendQuotaRequest> marshall(GetSendQuotaRequest getSendQuotaRequest) {
        if (getSendQuotaRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetSendQuotaRequest> defaultRequest = new DefaultRequest(getSendQuotaRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "GetSendQuota");
        defaultRequest.addParameter("Version", "2010-12-01");
        return defaultRequest;
    }
}
