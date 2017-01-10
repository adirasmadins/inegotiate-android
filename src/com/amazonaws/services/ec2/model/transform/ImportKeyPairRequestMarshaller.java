package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.ImportKeyPairRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ImportKeyPairRequestMarshaller implements Marshaller<Request<ImportKeyPairRequest>, ImportKeyPairRequest> {
    public Request<ImportKeyPairRequest> marshall(ImportKeyPairRequest importKeyPairRequest) {
        if (importKeyPairRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ImportKeyPairRequest> defaultRequest = new DefaultRequest(importKeyPairRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ImportKeyPair");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (importKeyPairRequest.getKeyName() != null) {
            defaultRequest.addParameter("KeyName", StringUtils.fromString(importKeyPairRequest.getKeyName()));
        }
        if (importKeyPairRequest.getPublicKeyMaterial() != null) {
            defaultRequest.addParameter("PublicKeyMaterial", StringUtils.fromString(importKeyPairRequest.getPublicKeyMaterial()));
        }
        return defaultRequest;
    }
}
