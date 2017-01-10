package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PolicyDescription {
    private List<PolicyAttributeDescription> policyAttributeDescriptions;
    private String policyName;
    private String policyTypeName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PolicyDescription)) {
            return false;
        }
        PolicyDescription policyDescription = (PolicyDescription) obj;
        if (((policyDescription.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policyDescription.getPolicyName() != null && !policyDescription.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        if (((policyDescription.getPolicyTypeName() == null ? 1 : 0) ^ (getPolicyTypeName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policyDescription.getPolicyTypeName() != null && !policyDescription.getPolicyTypeName().equals(getPolicyTypeName())) {
            return false;
        }
        return ((policyDescription.getPolicyAttributeDescriptions() == null ? 1 : 0) ^ (getPolicyAttributeDescriptions() == null ? 1 : 0)) == 0 ? policyDescription.getPolicyAttributeDescriptions() == null || policyDescription.getPolicyAttributeDescriptions().equals(getPolicyAttributeDescriptions()) : false;
    }

    public List<PolicyAttributeDescription> getPolicyAttributeDescriptions() {
        if (this.policyAttributeDescriptions == null) {
            this.policyAttributeDescriptions = new ArrayList();
        }
        return this.policyAttributeDescriptions;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public String getPolicyTypeName() {
        return this.policyTypeName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPolicyTypeName() == null ? 0 : getPolicyTypeName().hashCode()) + (((getPolicyName() == null ? 0 : getPolicyName().hashCode()) + 31) * 31)) * 31;
        if (getPolicyAttributeDescriptions() != null) {
            i = getPolicyAttributeDescriptions().hashCode();
        }
        return hashCode + i;
    }

    public void setPolicyAttributeDescriptions(Collection<PolicyAttributeDescription> collection) {
        if (collection == null) {
            this.policyAttributeDescriptions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.policyAttributeDescriptions = arrayList;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public void setPolicyTypeName(String str) {
        this.policyTypeName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.policyName != null) {
            stringBuilder.append("PolicyName: " + this.policyName + ", ");
        }
        if (this.policyTypeName != null) {
            stringBuilder.append("PolicyTypeName: " + this.policyTypeName + ", ");
        }
        if (this.policyAttributeDescriptions != null) {
            stringBuilder.append("PolicyAttributeDescriptions: " + this.policyAttributeDescriptions + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PolicyDescription withPolicyAttributeDescriptions(Collection<PolicyAttributeDescription> collection) {
        if (collection == null) {
            this.policyAttributeDescriptions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyAttributeDescriptions = arrayList;
        }
        return this;
    }

    public PolicyDescription withPolicyAttributeDescriptions(PolicyAttributeDescription... policyAttributeDescriptionArr) {
        if (getPolicyAttributeDescriptions() == null) {
            setPolicyAttributeDescriptions(new ArrayList(policyAttributeDescriptionArr.length));
        }
        for (Object add : policyAttributeDescriptionArr) {
            getPolicyAttributeDescriptions().add(add);
        }
        return this;
    }

    public PolicyDescription withPolicyName(String str) {
        this.policyName = str;
        return this;
    }

    public PolicyDescription withPolicyTypeName(String str) {
        this.policyTypeName = str;
        return this;
    }
}
