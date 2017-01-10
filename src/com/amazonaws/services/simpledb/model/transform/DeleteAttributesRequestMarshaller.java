package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.DeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.UpdateCondition;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteAttributesRequestMarshaller implements Marshaller<Request<DeleteAttributesRequest>, DeleteAttributesRequest> {
    public Request<DeleteAttributesRequest> marshall(DeleteAttributesRequest deleteAttributesRequest) {
        if (deleteAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteAttributesRequest> defaultRequest = new DefaultRequest(deleteAttributesRequest, "AmazonSimpleDB");
        defaultRequest.addParameter("Action", "DeleteAttributes");
        defaultRequest.addParameter("Version", "2009-04-15");
        if (deleteAttributesRequest.getDomainName() != null) {
            defaultRequest.addParameter("DomainName", StringUtils.fromString(deleteAttributesRequest.getDomainName()));
        }
        if (deleteAttributesRequest.getItemName() != null) {
            defaultRequest.addParameter("ItemName", StringUtils.fromString(deleteAttributesRequest.getItemName()));
        }
        int i = 1;
        for (Attribute attribute : deleteAttributesRequest.getAttributes()) {
            if (attribute != null) {
                if (attribute.getName() != null) {
                    defaultRequest.addParameter("Attribute." + i + ".Name", StringUtils.fromString(attribute.getName()));
                }
                if (attribute.getAlternateNameEncoding() != null) {
                    defaultRequest.addParameter("Attribute." + i + ".AlternateNameEncoding", StringUtils.fromString(attribute.getAlternateNameEncoding()));
                }
                if (attribute.getValue() != null) {
                    defaultRequest.addParameter("Attribute." + i + ".Value", StringUtils.fromString(attribute.getValue()));
                }
                if (attribute.getAlternateValueEncoding() != null) {
                    defaultRequest.addParameter("Attribute." + i + ".AlternateValueEncoding", StringUtils.fromString(attribute.getAlternateValueEncoding()));
                }
            }
            i++;
        }
        UpdateCondition expected = deleteAttributesRequest.getExpected();
        if (expected != null) {
            if (expected.getName() != null) {
                defaultRequest.addParameter("Expected.Name", StringUtils.fromString(expected.getName()));
            }
            if (expected.getValue() != null) {
                defaultRequest.addParameter("Expected.Value", StringUtils.fromString(expected.getValue()));
            }
            if (expected.isExists() != null) {
                defaultRequest.addParameter("Expected.Exists", StringUtils.fromBoolean(expected.isExists()));
            }
        }
        return defaultRequest;
    }
}
