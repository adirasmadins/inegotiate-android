package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.ListVerifiedEmailAddressesRequest;
import com.amazonaws.transform.Marshaller;

public class ListVerifiedEmailAddressesRequestMarshaller implements Marshaller<Request<ListVerifiedEmailAddressesRequest>, ListVerifiedEmailAddressesRequest> {
    public Request<ListVerifiedEmailAddressesRequest> marshall(ListVerifiedEmailAddressesRequest listVerifiedEmailAddressesRequest) {
        if (listVerifiedEmailAddressesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ListVerifiedEmailAddressesRequest> defaultRequest = new DefaultRequest(listVerifiedEmailAddressesRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "ListVerifiedEmailAddresses");
        defaultRequest.addParameter("Version", "2010-12-01");
        return defaultRequest;
    }
}
