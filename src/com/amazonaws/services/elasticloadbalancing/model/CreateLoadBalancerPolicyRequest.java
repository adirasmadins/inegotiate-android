package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateLoadBalancerPolicyRequest extends AmazonWebServiceRequest {
    private String loadBalancerName;
    private List<PolicyAttribute> policyAttributes;
    private String policyName;
    private String policyTypeName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateLoadBalancerPolicyRequest)) {
            return false;
        }
        CreateLoadBalancerPolicyRequest createLoadBalancerPolicyRequest = (CreateLoadBalancerPolicyRequest) obj;
        if (((createLoadBalancerPolicyRequest.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLoadBalancerPolicyRequest.getLoadBalancerName() != null && !createLoadBalancerPolicyRequest.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        if (((createLoadBalancerPolicyRequest.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLoadBalancerPolicyRequest.getPolicyName() != null && !createLoadBalancerPolicyRequest.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        if (((createLoadBalancerPolicyRequest.getPolicyTypeName() == null ? 1 : 0) ^ (getPolicyTypeName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createLoadBalancerPolicyRequest.getPolicyTypeName() != null && !createLoadBalancerPolicyRequest.getPolicyTypeName().equals(getPolicyTypeName())) {
            return false;
        }
        return ((createLoadBalancerPolicyRequest.getPolicyAttributes() == null ? 1 : 0) ^ (getPolicyAttributes() == null ? 1 : 0)) == 0 ? createLoadBalancerPolicyRequest.getPolicyAttributes() == null || createLoadBalancerPolicyRequest.getPolicyAttributes().equals(getPolicyAttributes()) : false;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public List<PolicyAttribute> getPolicyAttributes() {
        if (this.policyAttributes == null) {
            this.policyAttributes = new ArrayList();
        }
        return this.policyAttributes;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public String getPolicyTypeName() {
        return this.policyTypeName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPolicyTypeName() == null ? 0 : getPolicyTypeName().hashCode()) + (((getPolicyName() == null ? 0 : getPolicyName().hashCode()) + (((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getPolicyAttributes() != null) {
            i = getPolicyAttributes().hashCode();
        }
        return hashCode + i;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public void setPolicyAttributes(Collection<PolicyAttribute> collection) {
        if (collection == null) {
            this.policyAttributes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.policyAttributes = arrayList;
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
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.policyName != null) {
            stringBuilder.append("PolicyName: " + this.policyName + ", ");
        }
        if (this.policyTypeName != null) {
            stringBuilder.append("PolicyTypeName: " + this.policyTypeName + ", ");
        }
        if (this.policyAttributes != null) {
            stringBuilder.append("PolicyAttributes: " + this.policyAttributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateLoadBalancerPolicyRequest withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public CreateLoadBalancerPolicyRequest withPolicyAttributes(Collection<PolicyAttribute> collection) {
        if (collection == null) {
            this.policyAttributes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyAttributes = arrayList;
        }
        return this;
    }

    public CreateLoadBalancerPolicyRequest withPolicyAttributes(PolicyAttribute... policyAttributeArr) {
        if (getPolicyAttributes() == null) {
            setPolicyAttributes(new ArrayList(policyAttributeArr.length));
        }
        for (Object add : policyAttributeArr) {
            getPolicyAttributes().add(add);
        }
        return this;
    }

    public CreateLoadBalancerPolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }

    public CreateLoadBalancerPolicyRequest withPolicyTypeName(String str) {
        this.policyTypeName = str;
        return this;
    }
}
