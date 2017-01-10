package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeTerminationPolicyTypesResult {
    private List<String> terminationPolicyTypes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeTerminationPolicyTypesResult)) {
            return false;
        }
        DescribeTerminationPolicyTypesResult describeTerminationPolicyTypesResult = (DescribeTerminationPolicyTypesResult) obj;
        return ((describeTerminationPolicyTypesResult.getTerminationPolicyTypes() == null ? 1 : 0) ^ (getTerminationPolicyTypes() == null ? 1 : 0)) == 0 ? describeTerminationPolicyTypesResult.getTerminationPolicyTypes() == null || describeTerminationPolicyTypesResult.getTerminationPolicyTypes().equals(getTerminationPolicyTypes()) : false;
    }

    public List<String> getTerminationPolicyTypes() {
        if (this.terminationPolicyTypes == null) {
            this.terminationPolicyTypes = new ArrayList();
        }
        return this.terminationPolicyTypes;
    }

    public int hashCode() {
        return (getTerminationPolicyTypes() == null ? 0 : getTerminationPolicyTypes().hashCode()) + 31;
    }

    public void setTerminationPolicyTypes(Collection<String> collection) {
        if (collection == null) {
            this.terminationPolicyTypes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.terminationPolicyTypes = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.terminationPolicyTypes != null) {
            stringBuilder.append("TerminationPolicyTypes: " + this.terminationPolicyTypes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeTerminationPolicyTypesResult withTerminationPolicyTypes(Collection<String> collection) {
        if (collection == null) {
            this.terminationPolicyTypes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.terminationPolicyTypes = arrayList;
        }
        return this;
    }

    public DescribeTerminationPolicyTypesResult withTerminationPolicyTypes(String... strArr) {
        if (getTerminationPolicyTypes() == null) {
            setTerminationPolicyTypes(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getTerminationPolicyTypes().add(add);
        }
        return this;
    }
}
