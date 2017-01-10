package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpledb.model.GetAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetAttributesRequestMarshaller implements Marshaller<Request<GetAttributesRequest>, GetAttributesRequest> {
    public Request<GetAttributesRequest> marshall(GetAttributesRequest getAttributesRequest) {
        if (getAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetAttributesRequest> defaultRequest = new DefaultRequest(getAttributesRequest, "AmazonSimpleDB");
        defaultRequest.addParameter("Action", "GetAttributes");
        defaultRequest.addParameter("Version", "2009-04-15");
        if (getAttributesRequest.getDomainName() != null) {
            defaultRequest.addParameter("DomainName", StringUtils.fromString(getAttributesRequest.getDomainName()));
        }
        if (getAttributesRequest.getItemName() != null) {
            defaultRequest.addParameter("ItemName", StringUtils.fromString(getAttributesRequest.getItemName()));
        }
        int i = 1;
        for (String str : getAttributesRequest.getAttributeNames()) {
            if (str != null) {
                defaultRequest.addParameter("AttributeName." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (getAttributesRequest.isConsistentRead() != null) {
            defaultRequest.addParameter("ConsistentRead", StringUtils.fromBoolean(getAttributesRequest.isConsistentRead()));
        }
        return defaultRequest;
    }
}
