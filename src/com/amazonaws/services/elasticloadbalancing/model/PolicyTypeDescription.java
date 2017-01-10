package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PolicyTypeDescription {
    private String description;
    private List<PolicyAttributeTypeDescription> policyAttributeTypeDescriptions;
    private String policyTypeName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PolicyTypeDescription)) {
            return false;
        }
        PolicyTypeDescription policyTypeDescription = (PolicyTypeDescription) obj;
        if (((policyTypeDescription.getPolicyTypeName() == null ? 1 : 0) ^ (getPolicyTypeName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policyTypeDescription.getPolicyTypeName() != null && !policyTypeDescription.getPolicyTypeName().equals(getPolicyTypeName())) {
            return false;
        }
        if (((policyTypeDescription.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policyTypeDescription.getDescription() != null && !policyTypeDescription.getDescription().equals(getDescription())) {
            return false;
        }
        return ((policyTypeDescription.getPolicyAttributeTypeDescriptions() == null ? 1 : 0) ^ (getPolicyAttributeTypeDescriptions() == null ? 1 : 0)) == 0 ? policyTypeDescription.getPolicyAttributeTypeDescriptions() == null || policyTypeDescription.getPolicyAttributeTypeDescriptions().equals(getPolicyAttributeTypeDescriptions()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public List<PolicyAttributeTypeDescription> getPolicyAttributeTypeDescriptions() {
        if (this.policyAttributeTypeDescriptions == null) {
            this.policyAttributeTypeDescriptions = new ArrayList();
        }
        return this.policyAttributeTypeDescriptions;
    }

    public String getPolicyTypeName() {
        return this.policyTypeName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDescription() == null ? 0 : getDescription().hashCode()) + (((getPolicyTypeName() == null ? 0 : getPolicyTypeName().hashCode()) + 31) * 31)) * 31;
        if (getPolicyAttributeTypeDescriptions() != null) {
            i = getPolicyAttributeTypeDescriptions().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setPolicyAttributeTypeDescriptions(Collection<PolicyAttributeTypeDescription> collection) {
        if (collection == null) {
            this.policyAttributeTypeDescriptions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.policyAttributeTypeDescriptions = arrayList;
    }

    public void setPolicyTypeName(String str) {
        this.policyTypeName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.policyTypeName != null) {
            stringBuilder.append("PolicyTypeName: " + this.policyTypeName + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.policyAttributeTypeDescriptions != null) {
            stringBuilder.append("PolicyAttributeTypeDescriptions: " + this.policyAttributeTypeDescriptions + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PolicyTypeDescription withDescription(String str) {
        this.description = str;
        return this;
    }

    public PolicyTypeDescription withPolicyAttributeTypeDescriptions(Collection<PolicyAttributeTypeDescription> collection) {
        if (collection == null) {
            this.policyAttributeTypeDescriptions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyAttributeTypeDescriptions = arrayList;
        }
        return this;
    }

    public PolicyTypeDescription withPolicyAttributeTypeDescriptions(PolicyAttributeTypeDescription... policyAttributeTypeDescriptionArr) {
        if (getPolicyAttributeTypeDescriptions() == null) {
            setPolicyAttributeTypeDescriptions(new ArrayList(policyAttributeTypeDescriptionArr.length));
        }
        for (Object add : policyAttributeTypeDescriptionArr) {
            getPolicyAttributeTypeDescriptions().add(add);
        }
        return this;
    }

    public PolicyTypeDescription withPolicyTypeName(String str) {
        this.policyTypeName = str;
        return this;
    }
}
