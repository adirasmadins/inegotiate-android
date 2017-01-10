package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateKeyPairRequestMarshaller implements Marshaller<Request<CreateKeyPairRequest>, CreateKeyPairRequest> {
    public Request<CreateKeyPairRequest> marshall(CreateKeyPairRequest createKeyPairRequest) {
        if (createKeyPairRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateKeyPairRequest> defaultRequest = new DefaultRequest(createKeyPairRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CreateKeyPair");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (createKeyPairRequest.getKeyName() != null) {
            defaultRequest.addParameter("KeyName", StringUtils.fromString(createKeyPairRequest.getKeyName()));
        }
        return defaultRequest;
    }
}
