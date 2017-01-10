package com.amazonaws.services.simpledb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetAttributesRequest extends AmazonWebServiceRequest {
    private List<String> attributeNames;
    private Boolean consistentRead;
    private String domainName;
    private String itemName;

    public GetAttributesRequest(String str, String str2) {
        this.domainName = str;
        this.itemName = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetAttributesRequest)) {
            return false;
        }
        GetAttributesRequest getAttributesRequest = (GetAttributesRequest) obj;
        if (((getAttributesRequest.getDomainName() == null ? 1 : 0) ^ (getDomainName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getAttributesRequest.getDomainName() != null && !getAttributesRequest.getDomainName().equals(getDomainName())) {
            return false;
        }
        if (((getAttributesRequest.getItemName() == null ? 1 : 0) ^ (getItemName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getAttributesRequest.getItemName() != null && !getAttributesRequest.getItemName().equals(getItemName())) {
            return false;
        }
        if (((getAttributesRequest.getAttributeNames() == null ? 1 : 0) ^ (getAttributeNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getAttributesRequest.getAttributeNames() != null && !getAttributesRequest.getAttributeNames().equals(getAttributeNames())) {
            return false;
        }
        return ((getAttributesRequest.isConsistentRead() == null ? 1 : 0) ^ (isConsistentRead() == null ? 1 : 0)) == 0 ? getAttributesRequest.isConsistentRead() == null || getAttributesRequest.isConsistentRead().equals(isConsistentRead()) : false;
    }

    public List<String> getAttributeNames() {
        if (this.attributeNames == null) {
            this.attributeNames = new ArrayList();
        }
        return this.attributeNames;
    }

    public Boolean getConsistentRead() {
        return this.consistentRead;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributeNames() == null ? 0 : getAttributeNames().hashCode()) + (((getItemName() == null ? 0 : getItemName().hashCode()) + (((getDomainName() == null ? 0 : getDomainName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (isConsistentRead() != null) {
            i = isConsistentRead().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isConsistentRead() {
        return this.consistentRead;
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

    public void setConsistentRead(Boolean bool) {
        this.consistentRead = bool;
    }

    public void setDomainName(String str) {
        this.domainName = str;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.domainName != null) {
            stringBuilder.append("DomainName: " + this.domainName + ", ");
        }
        if (this.itemName != null) {
            stringBuilder.append("ItemName: " + this.itemName + ", ");
        }
        if (this.attributeNames != null) {
            stringBuilder.append("AttributeNames: " + this.attributeNames + ", ");
        }
        if (this.consistentRead != null) {
            stringBuilder.append("ConsistentRead: " + this.consistentRead + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetAttributesRequest withAttributeNames(Collection<String> collection) {
        if (collection == null) {
            this.attributeNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributeNames = arrayList;
        }
        return this;
    }

    public GetAttributesRequest withAttributeNames(String... strArr) {
        if (getAttributeNames() == null) {
            setAttributeNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAttributeNames().add(add);
        }
        return this;
    }

    public GetAttributesRequest withConsistentRead(Boolean bool) {
        this.consistentRead = bool;
        return this;
    }

    public GetAttributesRequest withDomainName(String str) {
        this.domainName = str;
        return this;
    }

    public GetAttributesRequest withItemName(String str) {
        this.itemName = str;
        return this;
    }
}
