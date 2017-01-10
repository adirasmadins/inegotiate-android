package com.amazonaws.services.simpledb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PutAttributesRequest extends AmazonWebServiceRequest {
    private List<ReplaceableAttribute> attributes;
    private String domainName;
    private UpdateCondition expected;
    private String itemName;

    public PutAttributesRequest(String str, String str2, List<ReplaceableAttribute> list) {
        this.domainName = str;
        this.itemName = str2;
        this.attributes = list;
    }

    public PutAttributesRequest(String str, String str2, List<ReplaceableAttribute> list, UpdateCondition updateCondition) {
        this.domainName = str;
        this.itemName = str2;
        this.attributes = list;
        this.expected = updateCondition;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutAttributesRequest)) {
            return false;
        }
        PutAttributesRequest putAttributesRequest = (PutAttributesRequest) obj;
        if (((putAttributesRequest.getDomainName() == null ? 1 : 0) ^ (getDomainName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putAttributesRequest.getDomainName() != null && !putAttributesRequest.getDomainName().equals(getDomainName())) {
            return false;
        }
        if (((putAttributesRequest.getItemName() == null ? 1 : 0) ^ (getItemName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putAttributesRequest.getItemName() != null && !putAttributesRequest.getItemName().equals(getItemName())) {
            return false;
        }
        if (((putAttributesRequest.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putAttributesRequest.getAttributes() != null && !putAttributesRequest.getAttributes().equals(getAttributes())) {
            return false;
        }
        return ((putAttributesRequest.getExpected() == null ? 1 : 0) ^ (getExpected() == null ? 1 : 0)) == 0 ? putAttributesRequest.getExpected() == null || putAttributesRequest.getExpected().equals(getExpected()) : false;
    }

    public List<ReplaceableAttribute> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new ArrayList();
        }
        return this.attributes;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public UpdateCondition getExpected() {
        return this.expected;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributes() == null ? 0 : getAttributes().hashCode()) + (((getItemName() == null ? 0 : getItemName().hashCode()) + (((getDomainName() == null ? 0 : getDomainName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getExpected() != null) {
            i = getExpected().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributes(Collection<ReplaceableAttribute> collection) {
        if (collection == null) {
            this.attributes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.attributes = arrayList;
    }

    public void setDomainName(String str) {
        this.domainName = str;
    }

    public void setExpected(UpdateCondition updateCondition) {
        this.expected = updateCondition;
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
        if (this.attributes != null) {
            stringBuilder.append("Attributes: " + this.attributes + ", ");
        }
        if (this.expected != null) {
            stringBuilder.append("Expected: " + this.expected + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PutAttributesRequest withAttributes(Collection<ReplaceableAttribute> collection) {
        if (collection == null) {
            this.attributes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributes = arrayList;
        }
        return this;
    }

    public PutAttributesRequest withAttributes(ReplaceableAttribute... replaceableAttributeArr) {
        if (getAttributes() == null) {
            setAttributes(new ArrayList(replaceableAttributeArr.length));
        }
        for (Object add : replaceableAttributeArr) {
            getAttributes().add(add);
        }
        return this;
    }

    public PutAttributesRequest withDomainName(String str) {
        this.domainName = str;
        return this;
    }

    public PutAttributesRequest withExpected(UpdateCondition updateCondition) {
        this.expected = updateCondition;
        return this;
    }

    public PutAttributesRequest withItemName(String str) {
        this.itemName = str;
        return this;
    }
}
