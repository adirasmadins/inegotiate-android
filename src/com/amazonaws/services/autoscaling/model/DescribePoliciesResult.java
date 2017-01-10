package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribePoliciesResult {
    private String nextToken;
    private List<ScalingPolicy> scalingPolicies;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribePoliciesResult)) {
            return false;
        }
        DescribePoliciesResult describePoliciesResult = (DescribePoliciesResult) obj;
        if (((describePoliciesResult.getScalingPolicies() == null ? 1 : 0) ^ (getScalingPolicies() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describePoliciesResult.getScalingPolicies() != null && !describePoliciesResult.getScalingPolicies().equals(getScalingPolicies())) {
            return false;
        }
        return ((describePoliciesResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describePoliciesResult.getNextToken() == null || describePoliciesResult.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<ScalingPolicy> getScalingPolicies() {
        if (this.scalingPolicies == null) {
            this.scalingPolicies = new ArrayList();
        }
        return this.scalingPolicies;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getScalingPolicies() == null ? 0 : getScalingPolicies().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setScalingPolicies(Collection<ScalingPolicy> collection) {
        if (collection == null) {
            this.scalingPolicies = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.scalingPolicies = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.scalingPolicies != null) {
            stringBuilder.append("ScalingPolicies: " + this.scalingPolicies + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribePoliciesResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribePoliciesResult withScalingPolicies(Collection<ScalingPolicy> collection) {
        if (collection == null) {
            this.scalingPolicies = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.scalingPolicies = arrayList;
        }
        return this;
    }

    public DescribePoliciesResult withScalingPolicies(ScalingPolicy... scalingPolicyArr) {
        if (getScalingPolicies() == null) {
            setScalingPolicies(new ArrayList(scalingPolicyArr.length));
        }
        for (Object add : scalingPolicyArr) {
            getScalingPolicies().add(add);
        }
        return this;
    }
}
