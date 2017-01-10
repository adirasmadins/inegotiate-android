package com.amazonaws.services.simpledb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeleteAttributesRequest extends AmazonWebServiceRequest {
    private List<Attribute> attributes;
    private String domainName;
    private UpdateCondition expected;
    private String itemName;

    public DeleteAttributesRequest(String str, String str2) {
        this.domainName = str;
        this.itemName = str2;
    }

    public DeleteAttributesRequest(String str, String str2, List<Attribute> list) {
        this.domainName = str;
        this.itemName = str2;
        this.attributes = list;
    }

    public DeleteAttributesRequest(String str, String str2, List<Attribute> list, UpdateCondition updateCondition) {
        this.domainName = str;
        this.itemName = str2;
        this.attributes = list;
        this.expected = updateCondition;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteAttributesRequest)) {
            return false;
        }
        DeleteAttributesRequest deleteAttributesRequest = (DeleteAttributesRequest) obj;
        if (((deleteAttributesRequest.getDomainName() == null ? 1 : 0) ^ (getDomainName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteAttributesRequest.getDomainName() != null && !deleteAttributesRequest.getDomainName().equals(getDomainName())) {
            return false;
        }
        if (((deleteAttributesRequest.getItemName() == null ? 1 : 0) ^ (getItemName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteAttributesRequest.getItemName() != null && !deleteAttributesRequest.getItemName().equals(getItemName())) {
            return false;
        }
        if (((deleteAttributesRequest.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteAttributesRequest.getAttributes() != null && !deleteAttributesRequest.getAttributes().equals(getAttributes())) {
            return false;
        }
        return ((deleteAttributesRequest.getExpected() == null ? 1 : 0) ^ (getExpected() == null ? 1 : 0)) == 0 ? deleteAttributesRequest.getExpected() == null || deleteAttributesRequest.getExpected().equals(getExpected()) : false;
    }

    public List<Attribute> getAttributes() {
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

    public void setAttributes(Collection<Attribute> collection) {
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

    public DeleteAttributesRequest withAttributes(Collection<Attribute> collection) {
        if (collection == null) {
            this.attributes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributes = arrayList;
        }
        return this;
    }

    public DeleteAttributesRequest withAttributes(Attribute... attributeArr) {
        if (getAttributes() == null) {
            setAttributes(new ArrayList(attributeArr.length));
        }
        for (Object add : attributeArr) {
            getAttributes().add(add);
        }
        return this;
    }

    public DeleteAttributesRequest withDomainName(String str) {
        this.domainName = str;
        return this;
    }

    public DeleteAttributesRequest withExpected(UpdateCondition updateCondition) {
        this.expected = updateCondition;
        return this;
    }

    public DeleteAttributesRequest withItemName(String str) {
        this.itemName = str;
        return this;
    }
}
