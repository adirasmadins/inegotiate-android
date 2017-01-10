package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BackendServerDescription {
    private Integer instancePort;
    private List<String> policyNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BackendServerDescription)) {
            return false;
        }
        BackendServerDescription backendServerDescription = (BackendServerDescription) obj;
        if (((backendServerDescription.getInstancePort() == null ? 1 : 0) ^ (getInstancePort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (backendServerDescription.getInstancePort() != null && !backendServerDescription.getInstancePort().equals(getInstancePort())) {
            return false;
        }
        return ((backendServerDescription.getPolicyNames() == null ? 1 : 0) ^ (getPolicyNames() == null ? 1 : 0)) == 0 ? backendServerDescription.getPolicyNames() == null || backendServerDescription.getPolicyNames().equals(getPolicyNames()) : false;
    }

    public Integer getInstancePort() {
        return this.instancePort;
    }

    public List<String> getPolicyNames() {
        if (this.policyNames == null) {
            this.policyNames = new ArrayList();
        }
        return this.policyNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstancePort() == null ? 0 : getInstancePort().hashCode()) + 31) * 31;
        if (getPolicyNames() != null) {
            i = getPolicyNames().hashCode();
        }
        return hashCode + i;
    }

    public void setInstancePort(Integer num) {
        this.instancePort = num;
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
        if (this.instancePort != null) {
            stringBuilder.append("InstancePort: " + this.instancePort + ", ");
        }
        if (this.policyNames != null) {
            stringBuilder.append("PolicyNames: " + this.policyNames + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BackendServerDescription withInstancePort(Integer num) {
        this.instancePort = num;
        return this;
    }

    public BackendServerDescription withPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyNames = arrayList;
        }
        return this;
    }

    public BackendServerDescription withPolicyNames(String... strArr) {
        if (getPolicyNames() == null) {
            setPolicyNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getPolicyNames().add(add);
        }
        return this;
    }
}
