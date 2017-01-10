package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.UpdateCondition;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class PutAttributesRequestMarshaller implements Marshaller<Request<PutAttributesRequest>, PutAttributesRequest> {
    public Request<PutAttributesRequest> marshall(PutAttributesRequest putAttributesRequest) {
        if (putAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<PutAttributesRequest> defaultRequest = new DefaultRequest(putAttributesRequest, "AmazonSimpleDB");
        defaultRequest.addParameter("Action", "PutAttributes");
        defaultRequest.addParameter("Version", "2009-04-15");
        if (putAttributesRequest.getDomainName() != null) {
            defaultRequest.addParameter("DomainName", StringUtils.fromString(putAttributesRequest.getDomainName()));
        }
        if (putAttributesRequest.getItemName() != null) {
            defaultRequest.addParameter("ItemName", StringUtils.fromString(putAttributesRequest.getItemName()));
        }
        int i = 1;
        for (ReplaceableAttribute replaceableAttribute : putAttributesRequest.getAttributes()) {
            if (replaceableAttribute != null) {
                if (replaceableAttribute.getName() != null) {
                    defaultRequest.addParameter("Attribute." + i + ".Name", StringUtils.fromString(replaceableAttribute.getName()));
                }
                if (replaceableAttribute.getValue() != null) {
                    defaultRequest.addParameter("Attribute." + i + ".Value", StringUtils.fromString(replaceableAttribute.getValue()));
                }
                if (replaceableAttribute.isReplace() != null) {
                    defaultRequest.addParameter("Attribute." + i + ".Replace", StringUtils.fromBoolean(replaceableAttribute.isReplace()));
                }
            }
            i++;
        }
        UpdateCondition expected = putAttributesRequest.getExpected();
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
