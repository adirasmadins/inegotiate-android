package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SendEmailRequest extends AmazonWebServiceRequest {
    private Destination destination;
    private Message message;
    private List<String> replyToAddresses;
    private String returnPath;
    private String source;

    public SendEmailRequest(String str, Destination destination, Message message) {
        this.source = str;
        this.destination = destination;
        this.message = message;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendEmailRequest)) {
            return false;
        }
        SendEmailRequest sendEmailRequest = (SendEmailRequest) obj;
        if (((sendEmailRequest.getSource() == null ? 1 : 0) ^ (getSource() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendEmailRequest.getSource() != null && !sendEmailRequest.getSource().equals(getSource())) {
            return false;
        }
        if (((sendEmailRequest.getDestination() == null ? 1 : 0) ^ (getDestination() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendEmailRequest.getDestination() != null && !sendEmailRequest.getDestination().equals(getDestination())) {
            return false;
        }
        if (((sendEmailRequest.getMessage() == null ? 1 : 0) ^ (getMessage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendEmailRequest.getMessage() != null && !sendEmailRequest.getMessage().equals(getMessage())) {
            return false;
        }
        if (((sendEmailRequest.getReplyToAddresses() == null ? 1 : 0) ^ (getReplyToAddresses() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendEmailRequest.getReplyToAddresses() != null && !sendEmailRequest.getReplyToAddresses().equals(getReplyToAddresses())) {
            return false;
        }
        return ((sendEmailRequest.getReturnPath() == null ? 1 : 0) ^ (getReturnPath() == null ? 1 : 0)) == 0 ? sendEmailRequest.getReturnPath() == null || sendEmailRequest.getReturnPath().equals(getReturnPath()) : false;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public Message getMessage() {
        return this.message;
    }

    public List<String> getReplyToAddresses() {
        if (this.replyToAddresses == null) {
            this.replyToAddresses = new ArrayList();
        }
        return this.replyToAddresses;
    }

    public String getReturnPath() {
        return this.returnPath;
    }

    public String getSource() {
        return this.source;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getReplyToAddresses() == null ? 0 : getReplyToAddresses().hashCode()) + (((getMessage() == null ? 0 : getMessage().hashCode()) + (((getDestination() == null ? 0 : getDestination().hashCode()) + (((getSource() == null ? 0 : getSource().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getReturnPath() != null) {
            i = getReturnPath().hashCode();
        }
        return hashCode + i;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setReplyToAddresses(Collection<String> collection) {
        if (collection == null) {
            this.replyToAddresses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.replyToAddresses = arrayList;
    }

    public void setReturnPath(String str) {
        this.returnPath = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.source != null) {
            stringBuilder.append("Source: " + this.source + ", ");
        }
        if (this.destination != null) {
            stringBuilder.append("Destination: " + this.destination + ", ");
        }
        if (this.message != null) {
            stringBuilder.append("Message: " + this.message + ", ");
        }
        if (this.replyToAddresses != null) {
            stringBuilder.append("ReplyToAddresses: " + this.replyToAddresses + ", ");
        }
        if (this.returnPath != null) {
            stringBuilder.append("ReturnPath: " + this.returnPath + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SendEmailRequest withDestination(Destination destination) {
        this.destination = destination;
        return this;
    }

    public SendEmailRequest withMessage(Message message) {
        this.message = message;
        return this;
    }

    public SendEmailRequest withReplyToAddresses(Collection<String> collection) {
        if (collection == null) {
            this.replyToAddresses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.replyToAddresses = arrayList;
        }
        return this;
    }

    public SendEmailRequest withReplyToAddresses(String... strArr) {
        if (getReplyToAddresses() == null) {
            setReplyToAddresses(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getReplyToAddresses().add(add);
        }
        return this;
    }

    public SendEmailRequest withReturnPath(String str) {
        this.returnPath = str;
        return this;
    }

    public SendEmailRequest withSource(String str) {
        this.source = str;
        return this;
    }
}
