package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetQueueAttributesRequest extends AmazonWebServiceRequest {
    private List<String> attributeNames;
    private String queueUrl;

    public GetQueueAttributesRequest(String str) {
        this.queueUrl = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetQueueAttributesRequest)) {
            return false;
        }
        GetQueueAttributesRequest getQueueAttributesRequest = (GetQueueAttributesRequest) obj;
        if (((getQueueAttributesRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getQueueAttributesRequest.getQueueUrl() != null && !getQueueAttributesRequest.getQueueUrl().equals(getQueueUrl())) {
            return false;
        }
        return ((getQueueAttributesRequest.getAttributeNames() == null ? 1 : 0) ^ (getAttributeNames() == null ? 1 : 0)) == 0 ? getQueueAttributesRequest.getAttributeNames() == null || getQueueAttributesRequest.getAttributeNames().equals(getAttributeNames()) : false;
    }

    public List<String> getAttributeNames() {
        if (this.attributeNames == null) {
            this.attributeNames = new ArrayList();
        }
        return this.attributeNames;
    }

    public String getQueueUrl() {
        return this.queueUrl;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getQueueUrl() == null ? 0 : getQueueUrl().hashCode()) + 31) * 31;
        if (getAttributeNames() != null) {
            i = getAttributeNames().hashCode();
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

    public void setQueueUrl(String str) {
        this.queueUrl = str;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetQueueAttributesRequest withAttributeNames(Collection<String> collection) {
        if (collection == null) {
            this.attributeNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributeNames = arrayList;
        }
        return this;
    }

    public GetQueueAttributesRequest withAttributeNames(String... strArr) {
        if (getAttributeNames() == null) {
            setAttributeNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAttributeNames().add(add);
        }
        return this;
    }

    public GetQueueAttributesRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }
}
