package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpledb.model.SelectRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SelectRequestMarshaller implements Marshaller<Request<SelectRequest>, SelectRequest> {
    public Request<SelectRequest> marshall(SelectRequest selectRequest) {
        if (selectRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SelectRequest> defaultRequest = new DefaultRequest(selectRequest, "AmazonSimpleDB");
        defaultRequest.addParameter("Action", "Select");
        defaultRequest.addParameter("Version", "2009-04-15");
        if (selectRequest.getSelectExpression() != null) {
            defaultRequest.addParameter("SelectExpression", StringUtils.fromString(selectRequest.getSelectExpression()));
        }
        if (selectRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(selectRequest.getNextToken()));
        }
        if (selectRequest.isConsistentRead() != null) {
            defaultRequest.addParameter("ConsistentRead", StringUtils.fromBoolean(selectRequest.isConsistentRead()));
        }
        return defaultRequest;
    }
}
