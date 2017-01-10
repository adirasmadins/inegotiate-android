package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SendEmailRequestMarshaller implements Marshaller<Request<SendEmailRequest>, SendEmailRequest> {
    public Request<SendEmailRequest> marshall(SendEmailRequest sendEmailRequest) {
        int i = 1;
        if (sendEmailRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SendEmailRequest> defaultRequest = new DefaultRequest(sendEmailRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "SendEmail");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (sendEmailRequest.getSource() != null) {
            defaultRequest.addParameter("Source", StringUtils.fromString(sendEmailRequest.getSource()));
        }
        Destination destination = sendEmailRequest.getDestination();
        if (destination != null) {
            int i2 = 1;
            for (String str : destination.getToAddresses()) {
                if (str != null) {
                    defaultRequest.addParameter("Destination.ToAddresses.member." + i2, StringUtils.fromString(str));
                }
                i2++;
            }
            i2 = 1;
            for (String str2 : destination.getCcAddresses()) {
                if (str2 != null) {
                    defaultRequest.addParameter("Destination.CcAddresses.member." + i2, StringUtils.fromString(str2));
                }
                i2++;
            }
            i2 = 1;
            for (String str22 : destination.getBccAddresses()) {
                if (str22 != null) {
                    defaultRequest.addParameter("Destination.BccAddresses.member." + i2, StringUtils.fromString(str22));
                }
                i2++;
            }
        }
        Message message = sendEmailRequest.getMessage();
        if (message != null) {
            Content subject = message.getSubject();
            if (subject != null) {
                if (subject.getData() != null) {
                    defaultRequest.addParameter("Message.Subject.Data", StringUtils.fromString(subject.getData()));
                }
                if (subject.getCharset() != null) {
                    defaultRequest.addParameter("Message.Subject.Charset", StringUtils.fromString(subject.getCharset()));
                }
            }
            Body body = message.getBody();
            if (body != null) {
                subject = body.getText();
                if (subject != null) {
                    if (subject.getData() != null) {
                        defaultRequest.addParameter("Message.Body.Text.Data", StringUtils.fromString(subject.getData()));
                    }
                    if (subject.getCharset() != null) {
                        defaultRequest.addParameter("Message.Body.Text.Charset", StringUtils.fromString(subject.getCharset()));
                    }
                }
                Content html = body.getHtml();
                if (html != null) {
                    if (html.getData() != null) {
                        defaultRequest.addParameter("Message.Body.Html.Data", StringUtils.fromString(html.getData()));
                    }
                    if (html.getCharset() != null) {
                        defaultRequest.addParameter("Message.Body.Html.Charset", StringUtils.fromString(html.getCharset()));
                    }
                }
            }
        }
        for (String str222 : sendEmailRequest.getReplyToAddresses()) {
            if (str222 != null) {
                defaultRequest.addParameter("ReplyToAddresses.member." + i, StringUtils.fromString(str222));
            }
            i++;
        }
        if (sendEmailRequest.getReturnPath() != null) {
            defaultRequest.addParameter("ReturnPath", StringUtils.fromString(sendEmailRequest.getReturnPath()));
        }
        return defaultRequest;
    }
}
