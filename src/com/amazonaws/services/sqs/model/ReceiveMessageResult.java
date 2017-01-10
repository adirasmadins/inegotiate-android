package com.amazonaws.services.sqs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReceiveMessageResult {
    private List<Message> messages;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReceiveMessageResult)) {
            return false;
        }
        ReceiveMessageResult receiveMessageResult = (ReceiveMessageResult) obj;
        return ((receiveMessageResult.getMessages() == null ? 1 : 0) ^ (getMessages() == null ? 1 : 0)) == 0 ? receiveMessageResult.getMessages() == null || receiveMessageResult.getMessages().equals(getMessages()) : false;
    }

    public List<Message> getMessages() {
        if (this.messages == null) {
            this.messages = new ArrayList();
        }
        return this.messages;
    }

    public int hashCode() {
        return (getMessages() == null ? 0 : getMessages().hashCode()) + 31;
    }

    public void setMessages(Collection<Message> collection) {
        if (collection == null) {
            this.messages = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.messages = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.messages != null) {
            stringBuilder.append("Messages: " + this.messages + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ReceiveMessageResult withMessages(Collection<Message> collection) {
        if (collection == null) {
            this.messages = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.messages = arrayList;
        }
        return this;
    }

    public ReceiveMessageResult withMessages(Message... messageArr) {
        if (getMessages() == null) {
            setMessages(new ArrayList(messageArr.length));
        }
        for (Object add : messageArr) {
            getMessages().add(add);
        }
        return this;
    }
}
