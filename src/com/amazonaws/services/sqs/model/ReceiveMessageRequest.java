package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReceiveMessageRequest extends AmazonWebServiceRequest {
    private List<String> attributeNames;
    private Integer maxNumberOfMessages;
    private String queueUrl;
    private Integer visibilityTimeout;

    public ReceiveMessageRequest(String str) {
        this.queueUrl = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReceiveMessageRequest)) {
            return false;
        }
        ReceiveMessageRequest receiveMessageRequest = (ReceiveMessageRequest) obj;
        if (((receiveMessageRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (receiveMessageRequest.getQueueUrl() != null && !receiveMessageRequest.getQueueUrl().equals(getQueueUrl())) {
            return false;
        }
        if (((receiveMessageRequest.getAttributeNames() == null ? 1 : 0) ^ (getAttributeNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (receiveMessageRequest.getAttributeNames() != null && !receiveMessageRequest.getAttributeNames().equals(getAttributeNames())) {
            return false;
        }
        if (((receiveMessageRequest.getMaxNumberOfMessages() == null ? 1 : 0) ^ (getMaxNumberOfMessages() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (receiveMessageRequest.getMaxNumberOfMessages() != null && !receiveMessageRequest.getMaxNumberOfMessages().equals(getMaxNumberOfMessages())) {
            return false;
        }
        return ((receiveMessageRequest.getVisibilityTimeout() == null ? 1 : 0) ^ (getVisibilityTimeout() == null ? 1 : 0)) == 0 ? receiveMessageRequest.getVisibilityTimeout() == null || receiveMessageRequest.getVisibilityTimeout().equals(getVisibilityTimeout()) : false;
    }

    public List<String> getAttributeNames() {
        if (this.attributeNames == null) {
            this.attributeNames = new ArrayList();
        }
        return this.attributeNames;
    }

    public Integer getMaxNumberOfMessages() {
        return this.maxNumberOfMessages;
    }

    public String getQueueUrl() {
        return this.queueUrl;
    }

    public Integer getVisibilityTimeout() {
        return this.visibilityTimeout;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaxNumberOfMessages() == null ? 0 : getMaxNumberOfMessages().hashCode()) + (((getAttributeNames() == null ? 0 : getAttributeNames().hashCode()) + (((getQueueUrl() == null ? 0 : getQueueUrl().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getVisibilityTimeout() != null) {
            i = getVisibilityTimeout().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributeNames(Collection<String> collection) {
        if (collection == null) {
            this.attributeNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.attributeNames = arrayList;
    }

    public void setMaxNumberOfMessages(Integer num) {
        this.maxNumberOfMessages = num;
    }

    public void setQueueUrl(String str) {
        this.queueUrl = str;
    }

    public void setVisibilityTimeout(Integer num) {
        this.visibilityTimeout = num;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.queueUrl != null) {
            stringBuilder.append("QueueUrl: " + this.queueUrl + ", ");
        }
        if (this.attributeNames != null) {
            stringBuilder.append("AttributeNames: " + this.attributeNames + ", ");
        }
        if (this.maxNumberOfMessages != null) {
            stringBuilder.append("MaxNumberOfMessages: " + this.maxNumberOfMessages + ", ");
        }
        if (this.visibilityTimeout != null) {
            stringBuilder.append("VisibilityTimeout: " + this.visibilityTimeout + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ReceiveMessageRequest withAttributeNames(Collection<String> collection) {
        if (collection == null) {
            this.attributeNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributeNames = arrayList;
        }
        return this;
    }

    public ReceiveMessageRequest withAttributeNames(String... strArr) {
        if (getAttributeNames() == null) {
            setAttributeNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAttributeNames().add(add);
        }
        return this;
    }

    public ReceiveMessageRequest withMaxNumberOfMessages(Integer num) {
        this.maxNumberOfMessages = num;
        return this;
    }

    public ReceiveMessageRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }

    public ReceiveMessageRequest withVisibilityTimeout(Integer num) {
        this.visibilityTimeout = num;
        return this;
    }
}
