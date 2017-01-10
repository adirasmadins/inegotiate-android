package com.amazonaws.services.simpledb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BatchPutAttributesRequest extends AmazonWebServiceRequest {
    private String domainName;
    private List<ReplaceableItem> items;

    public BatchPutAttributesRequest(String str, List<ReplaceableItem> list) {
        this.domainName = str;
        this.items = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchPutAttributesRequest)) {
            return false;
        }
        BatchPutAttributesRequest batchPutAttributesRequest = (BatchPutAttributesRequest) obj;
        if (((batchPutAttributesRequest.getDomainName() == null ? 1 : 0) ^ (getDomainName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (batchPutAttributesRequest.getDomainName() != null && !batchPutAttributesRequest.getDomainName().equals(getDomainName())) {
            return false;
        }
        return ((batchPutAttributesRequest.getItems() == null ? 1 : 0) ^ (getItems() == null ? 1 : 0)) == 0 ? batchPutAttributesRequest.getItems() == null || batchPutAttributesRequest.getItems().equals(getItems()) : false;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public List<ReplaceableItem> getItems() {
        if (this.items == null) {
            this.items = new ArrayList();
        }
        return this.items;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDomainName() == null ? 0 : getDomainName().hashCode()) + 31) * 31;
        if (getItems() != null) {
            i = getItems().hashCode();
        }
        return hashCode + i;
    }

    public void setDomainName(String str) {
        this.domainName = str;
    }

    public void setItems(Collection<ReplaceableItem> collection) {
        if (collection == null) {
            this.items = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.items = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.domainName != null) {
            stringBuilder.append("DomainName: " + this.domainName + ", ");
        }
        if (this.items != null) {
            stringBuilder.append("Items: " + this.items + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BatchPutAttributesRequest withDomainName(String str) {
        this.domainName = str;
        return this;
    }

    public BatchPutAttributesRequest withItems(Collection<ReplaceableItem> collection) {
        if (collection == null) {
            this.items = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.items = arrayList;
        }
        return this;
    }

    public BatchPutAttributesRequest withItems(ReplaceableItem... replaceableItemArr) {
        if (getItems() == null) {
            setItems(new ArrayList(replaceableItemArr.length));
        }
        for (Object add : replaceableItemArr) {
            getItems().add(add);
        }
        return this;
    }
}
