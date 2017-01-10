package com.amazonaws.services.sqs.model;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private Map<String, String> attributes;
    private String body;
    private String mD5OfBody;
    private String messageId;
    private String receiptHandle;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        if (((message.getMessageId() == null ? 1 : 0) ^ (getMessageId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (message.getMessageId() != null && !message.getMessageId().equals(getMessageId())) {
            return false;
        }
        if (((message.getReceiptHandle() == null ? 1 : 0) ^ (getReceiptHandle() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (message.getReceiptHandle() != null && !message.getReceiptHandle().equals(getReceiptHandle())) {
            return false;
        }
        if (((message.getMD5OfBody() == null ? 1 : 0) ^ (getMD5OfBody() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (message.getMD5OfBody() != null && !message.getMD5OfBody().equals(getMD5OfBody())) {
            return false;
        }
        if (((message.getBody() == null ? 1 : 0) ^ (getBody() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (message.getBody() != null && !message.getBody().equals(getBody())) {
            return false;
        }
        return ((message.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) == 0 ? message.getAttributes() == null || message.getAttributes().equals(getAttributes()) : false;
    }

    public Map<String, String> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new HashMap();
        }
        return this.attributes;
    }

    public String getBody() {
        return this.body;
    }

    public String getMD5OfBody() {
        return this.mD5OfBody;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getReceiptHandle() {
        return this.receiptHandle;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getBody() == null ? 0 : getBody().hashCode()) + (((getMD5OfBody() == null ? 0 : getMD5OfBody().hashCode()) + (((getReceiptHandle() == null ? 0 : getReceiptHandle().hashCode()) + (((getMessageId() == null ? 0 : getMessageId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getAttributes() != null) {
            i = getAttributes().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributes(Map<String, String> map) {
        this.attributes = map;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setMD5OfBody(String str) {
        this.mD5OfBody = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setReceiptHandle(String str) {
        this.receiptHandle = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.messageId != null) {
            stringBuilder.append("MessageId: " + this.messageId + ", ");
        }
        if (this.receiptHandle != null) {
            stringBuilder.append("ReceiptHandle: " + this.receiptHandle + ", ");
        }
        if (this.mD5OfBody != null) {
            stringBuilder.append("MD5OfBody: " + this.mD5OfBody + ", ");
        }
        if (this.body != null) {
            stringBuilder.append("Body: " + this.body + ", ");
        }
        if (this.attributes != null) {
            stringBuilder.append("Attributes: " + this.attributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Message withAttributes(Map<String, String> map) {
        setAttributes(map);
        return this;
    }

    public Message withBody(String str) {
        this.body = str;
        return this;
    }

    public Message withMD5OfBody(String str) {
        this.mD5OfBody = str;
        return this;
    }

    public Message withMessageId(String str) {
        this.messageId = str;
        return this;
    }

    public Message withReceiptHandle(String str) {
        this.receiptHandle = str;
        return this;
    }
}
