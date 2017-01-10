package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.BatchDeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.DeletableItem;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class BatchDeleteAttributesRequestMarshaller implements Marshaller<Request<BatchDeleteAttributesRequest>, BatchDeleteAttributesRequest> {
    public Request<BatchDeleteAttributesRequest> marshall(BatchDeleteAttributesRequest batchDeleteAttributesRequest) {
        if (batchDeleteAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<BatchDeleteAttributesRequest> defaultRequest = new DefaultRequest(batchDeleteAttributesRequest, "AmazonSimpleDB");
        defaultRequest.addParameter("Action", "BatchDeleteAttributes");
        defaultRequest.addParameter("Version", "2009-04-15");
        if (batchDeleteAttributesRequest.getDomainName() != null) {
            defaultRequest.addParameter("DomainName", StringUtils.fromString(batchDeleteAttributesRequest.getDomainName()));
        }
        int i = 1;
        for (DeletableItem deletableItem : batchDeleteAttributesRequest.getItems()) {
            if (deletableItem != null) {
                if (deletableItem.getName() != null) {
                    defaultRequest.addParameter("Item." + i + ".ItemName", StringUtils.fromString(deletableItem.getName()));
                }
                int i2 = 1;
                for (Attribute attribute : deletableItem.getAttributes()) {
                    if (attribute != null) {
                        if (attribute.getName() != null) {
                            defaultRequest.addParameter("Item." + i + ".Attribute." + i2 + ".Name", StringUtils.fromString(attribute.getName()));
                        }
                        if (attribute.getAlternateNameEncoding() != null) {
                            defaultRequest.addParameter("Item." + i + ".Attribute." + i2 + ".AlternateNameEncoding", StringUtils.fromString(attribute.getAlternateNameEncoding()));
                        }
                        if (attribute.getValue() != null) {
                            defaultRequest.addParameter("Item." + i + ".Attribute." + i2 + ".Value", StringUtils.fromString(attribute.getValue()));
                        }
                        if (attribute.getAlternateValueEncoding() != null) {
                            defaultRequest.addParameter("Item." + i + ".Attribute." + i2 + ".AlternateValueEncoding", StringUtils.fromString(attribute.getAlternateValueEncoding()));
                        }
                    }
                    i2++;
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
