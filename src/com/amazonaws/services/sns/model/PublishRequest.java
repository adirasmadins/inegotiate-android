package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class PublishRequest extends AmazonWebServiceRequest {
    private String message;
    private String messageStructure;
    private String subject;
    private String topicArn;

    public PublishRequest(String str, String str2) {
        this.topicArn = str;
        this.message = str2;
    }

    public PublishRequest(String str, String str2, String str3) {
        this.topicArn = str;
        this.message = str2;
        this.subject = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PublishRequest)) {
            return false;
        }
        PublishRequest publishRequest = (PublishRequest) obj;
        if (((publishRequest.getTopicArn() == null ? 1 : 0) ^ (getTopicArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (publishRequest.getTopicArn() != null && !publishRequest.getTopicArn().equals(getTopicArn())) {
            return false;
        }
        if (((publishRequest.getMessage() == null ? 1 : 0) ^ (getMessage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (publishRequest.getMessage() != null && !publishRequest.getMessage().equals(getMessage())) {
            return false;
        }
        if (((publishRequest.getSubject() == null ? 1 : 0) ^ (getSubject() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (publishRequest.getSubject() != null && !publishRequest.getSubject().equals(getSubject())) {
            return false;
        }
        return ((publishRequest.getMessageStructure() == null ? 1 : 0) ^ (getMessageStructure() == null ? 1 : 0)) == 0 ? publishRequest.getMessageStructure() == null || publishRequest.getMessageStructure().equals(getMessageStructure()) : false;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessageStructure() {
        return this.messageStructure;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getTopicArn() {
        return this.topicArn;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSubject() == null ? 0 : getSubject().hashCode()) + (((getMessage() == null ? 0 : getMessage().hashCode()) + (((getTopicArn() == null ? 0 : getTopicArn().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getMessageStructure() != null) {
            i = getMessageStructure().hashCode();
        }
        return hashCode + i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMessageStructure(String str) {
        this.messageStructure = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setTopicArn(String str) {
        this.topicArn = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.topicArn != null) {
            stringBuilder.append("TopicArn: " + this.topicArn + ", ");
        }
        if (this.message != null) {
            stringBuilder.append("Message: " + this.message + ", ");
        }
        if (this.subject != null) {
            stringBuilder.append("Subject: " + this.subject + ", ");
        }
        if (this.messageStructure != null) {
            stringBuilder.append("MessageStructure: " + this.messageStructure + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PublishRequest withMessage(String str) {
        this.message = str;
        return this;
    }

    public PublishRequest withMessageStructure(String str) {
        this.messageStructure = str;
        return this;
    }

    public PublishRequest withSubject(String str) {
        this.subject = str;
        return this;
    }

    public PublishRequest withTopicArn(String str) {
        this.topicArn = str;
        return this;
    }
}
