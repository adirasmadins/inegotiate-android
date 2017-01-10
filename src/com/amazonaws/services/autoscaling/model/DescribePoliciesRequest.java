package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribePoliciesRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private Integer maxRecords;
    private String nextToken;
    private List<String> policyNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribePoliciesRequest)) {
            return false;
        }
        DescribePoliciesRequest describePoliciesRequest = (DescribePoliciesRequest) obj;
        if (((describePoliciesRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describePoliciesRequest.getAutoScalingGroupName() != null && !describePoliciesRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((describePoliciesRequest.getPolicyNames() == null ? 1 : 0) ^ (getPolicyNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describePoliciesRequest.getPolicyNames() != null && !describePoliciesRequest.getPolicyNames().equals(getPolicyNames())) {
            return false;
        }
        if (((describePoliciesRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describePoliciesRequest.getNextToken() != null && !describePoliciesRequest.getNextToken().equals(getNextToken())) {
            return false;
        }
        return ((describePoliciesRequest.getMaxRecords() == null ? 1 : 0) ^ (getMaxRecords() == null ? 1 : 0)) == 0 ? describePoliciesRequest.getMaxRecords() == null || describePoliciesRequest.getMaxRecords().equals(getMaxRecords()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public Integer getMaxRecords() {
        return this.maxRecords;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<String> getPolicyNames() {
        if (this.policyNames == null) {
            this.policyNames = new ArrayList();
        }
        return this.policyNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNextToken() == null ? 0 : getNextToken().hashCode()) + (((getPolicyNames() == null ? 0 : getPolicyNames().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getMaxRecords() != null) {
            i = getMaxRecords().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setMaxRecords(Integer num) {
        this.maxRecords = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.policyNames = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.policyNames != null) {
            stringBuilder.append("PolicyNames: " + this.policyNames + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        if (this.maxRecords != null) {
            stringBuilder.append("MaxRecords: " + this.maxRecords + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribePoliciesRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public DescribePoliciesRequest withMaxRecords(Integer num) {
        this.maxRecords = num;
        return this;
    }

    public DescribePoliciesRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribePoliciesRequest withPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyNames = arrayList;
        }
        return this;
    }

    public DescribePoliciesRequest withPolicyNames(String... strArr) {
        if (getPolicyNames() == null) {
            setPolicyNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getPolicyNames().add(add);
        }
        return this;
    }
}
