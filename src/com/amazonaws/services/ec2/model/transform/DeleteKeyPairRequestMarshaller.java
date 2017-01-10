package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DeleteKeyPairRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteKeyPairRequestMarshaller implements Marshaller<Request<DeleteKeyPairRequest>, DeleteKeyPairRequest> {
    public Request<DeleteKeyPairRequest> marshall(DeleteKeyPairRequest deleteKeyPairRequest) {
        if (deleteKeyPairRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteKeyPairRequest> defaultRequest = new DefaultRequest(deleteKeyPairRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DeleteKeyPair");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (deleteKeyPairRequest.getKeyName() != null) {
            defaultRequest.addParameter("KeyName", StringUtils.fromString(deleteKeyPairRequest.getKeyName()));
        }
        return defaultRequest;
    }
}
