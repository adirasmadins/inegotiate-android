package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SendRawEmailRequest extends AmazonWebServiceRequest {
    private List<String> destinations;
    private RawMessage rawMessage;
    private String source;

    public SendRawEmailRequest(RawMessage rawMessage) {
        this.rawMessage = rawMessage;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendRawEmailRequest)) {
            return false;
        }
        SendRawEmailRequest sendRawEmailRequest = (SendRawEmailRequest) obj;
        if (((sendRawEmailRequest.getSource() == null ? 1 : 0) ^ (getSource() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendRawEmailRequest.getSource() != null && !sendRawEmailRequest.getSource().equals(getSource())) {
            return false;
        }
        if (((sendRawEmailRequest.getDestinations() == null ? 1 : 0) ^ (getDestinations() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendRawEmailRequest.getDestinations() != null && !sendRawEmailRequest.getDestinations().equals(getDestinations())) {
            return false;
        }
        return ((sendRawEmailRequest.getRawMessage() == null ? 1 : 0) ^ (getRawMessage() == null ? 1 : 0)) == 0 ? sendRawEmailRequest.getRawMessage() == null || sendRawEmailRequest.getRawMessage().equals(getRawMessage()) : false;
    }

    public List<String> getDestinations() {
        if (this.destinations == null) {
            this.destinations = new ArrayList();
        }
        return this.destinations;
    }

    public RawMessage getRawMessage() {
        return this.rawMessage;
    }

    public String getSource() {
        return this.source;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDestinations() == null ? 0 : getDestinations().hashCode()) + (((getSource() == null ? 0 : getSource().hashCode()) + 31) * 31)) * 31;
        if (getRawMessage() != null) {
            i = getRawMessage().hashCode();
        }
        return hashCode + i;
    }

    public void setDestinations(Collection<String> collection) {
        if (collection == null) {
            this.destinations = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.destinations = arrayList;
    }

    public void setRawMessage(RawMessage rawMessage) {
        this.rawMessage = rawMessage;
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
        if (this.destinations != null) {
            stringBuilder.append("Destinations: " + this.destinations + ", ");
        }
        if (this.rawMessage != null) {
            stringBuilder.append("RawMessage: " + this.rawMessage + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SendRawEmailRequest withDestinations(Collection<String> collection) {
        if (collection == null) {
            this.destinations = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.destinations = arrayList;
        }
        return this;
    }

    public SendRawEmailRequest withDestinations(String... strArr) {
        if (getDestinations() == null) {
            setDestinations(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getDestinations().add(add);
        }
        return this;
    }

    public SendRawEmailRequest withRawMessage(RawMessage rawMessage) {
        this.rawMessage = rawMessage;
        return this;
    }

    public SendRawEmailRequest withSource(String str) {
        this.source = str;
        return this;
    }
}
