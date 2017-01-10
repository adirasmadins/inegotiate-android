package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpledb.model.BatchPutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.ReplaceableItem;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class BatchPutAttributesRequestMarshaller implements Marshaller<Request<BatchPutAttributesRequest>, BatchPutAttributesRequest> {
    public Request<BatchPutAttributesRequest> marshall(BatchPutAttributesRequest batchPutAttributesRequest) {
        if (batchPutAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<BatchPutAttributesRequest> defaultRequest = new DefaultRequest(batchPutAttributesRequest, "AmazonSimpleDB");
        defaultRequest.addParameter("Action", "BatchPutAttributes");
        defaultRequest.addParameter("Version", "2009-04-15");
        if (batchPutAttributesRequest.getDomainName() != null) {
            defaultRequest.addParameter("DomainName", StringUtils.fromString(batchPutAttributesRequest.getDomainName()));
        }
        int i = 1;
        for (ReplaceableItem replaceableItem : batchPutAttributesRequest.getItems()) {
            if (replaceableItem != null) {
                if (replaceableItem.getName() != null) {
                    defaultRequest.addParameter("Item." + i + ".ItemName", StringUtils.fromString(replaceableItem.getName()));
                }
                int i2 = 1;
                for (ReplaceableAttribute replaceableAttribute : replaceableItem.getAttributes()) {
                    if (replaceableAttribute != null) {
                        if (replaceableAttribute.getName() != null) {
                            defaultRequest.addParameter("Item." + i + ".Attribute." + i2 + ".Name", StringUtils.fromString(replaceableAttribute.getName()));
                        }
                        if (replaceableAttribute.getValue() != null) {
                            defaultRequest.addParameter("Item." + i + ".Attribute." + i2 + ".Value", StringUtils.fromString(replaceableAttribute.getValue()));
                        }
                        if (replaceableAttribute.isReplace() != null) {
                            defaultRequest.addParameter("Item." + i + ".Attribute." + i2 + ".Replace", StringUtils.fromBoolean(replaceableAttribute.isReplace()));
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
