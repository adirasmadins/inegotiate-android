package com.amazonaws.services.simpledb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BatchDeleteAttributesRequest extends AmazonWebServiceRequest {
    private String domainName;
    private List<DeletableItem> items;

    public BatchDeleteAttributesRequest(String str, List<DeletableItem> list) {
        this.domainName = str;
        this.items = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchDeleteAttributesRequest)) {
            return false;
        }
        BatchDeleteAttributesRequest batchDeleteAttributesRequest = (BatchDeleteAttributesRequest) obj;
        if (((batchDeleteAttributesRequest.getDomainName() == null ? 1 : 0) ^ (getDomainName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (batchDeleteAttributesRequest.getDomainName() != null && !batchDeleteAttributesRequest.getDomainName().equals(getDomainName())) {
            return false;
        }
        return ((batchDeleteAttributesRequest.getItems() == null ? 1 : 0) ^ (getItems() == null ? 1 : 0)) == 0 ? batchDeleteAttributesRequest.getItems() == null || batchDeleteAttributesRequest.getItems().equals(getItems()) : false;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public List<DeletableItem> getItems() {
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

    public void setItems(Collection<DeletableItem> collection) {
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

    public BatchDeleteAttributesRequest withDomainName(String str) {
        this.domainName = str;
        return this;
    }

    public BatchDeleteAttributesRequest withItems(Collection<DeletableItem> collection) {
        if (collection == null) {
            this.items = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.items = arrayList;
        }
        return this;
    }

    public BatchDeleteAttributesRequest withItems(DeletableItem... deletableItemArr) {
        if (getItems() == null) {
            setItems(new ArrayList(deletableItemArr.length));
        }
        for (Object add : deletableItemArr) {
            getItems().add(add);
        }
        return this;
    }
}
