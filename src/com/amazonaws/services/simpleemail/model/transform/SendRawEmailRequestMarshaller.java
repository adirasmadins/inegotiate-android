package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.RawMessage;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SendRawEmailRequestMarshaller implements Marshaller<Request<SendRawEmailRequest>, SendRawEmailRequest> {
    public Request<SendRawEmailRequest> marshall(SendRawEmailRequest sendRawEmailRequest) {
        if (sendRawEmailRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SendRawEmailRequest> defaultRequest = new DefaultRequest(sendRawEmailRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "SendRawEmail");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (sendRawEmailRequest.getSource() != null) {
            defaultRequest.addParameter("Source", StringUtils.fromString(sendRawEmailRequest.getSource()));
        }
        int i = 1;
        for (String str : sendRawEmailRequest.getDestinations()) {
            if (str != null) {
                defaultRequest.addParameter("Destinations.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        RawMessage rawMessage = sendRawEmailRequest.getRawMessage();
        if (!(rawMessage == null || rawMessage.getData() == null)) {
            defaultRequest.addParameter("RawMessage.Data", StringUtils.fromByteBuffer(rawMessage.getData()));
        }
        return defaultRequest;
    }
}
