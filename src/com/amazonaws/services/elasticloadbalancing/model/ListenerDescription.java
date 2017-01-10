package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListenerDescription {
    private Listener listener;
    private List<String> policyNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListenerDescription)) {
            return false;
        }
        ListenerDescription listenerDescription = (ListenerDescription) obj;
        if (((listenerDescription.getListener() == null ? 1 : 0) ^ (getListener() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listenerDescription.getListener() != null && !listenerDescription.getListener().equals(getListener())) {
            return false;
        }
        return ((listenerDescription.getPolicyNames() == null ? 1 : 0) ^ (getPolicyNames() == null ? 1 : 0)) == 0 ? listenerDescription.getPolicyNames() == null || listenerDescription.getPolicyNames().equals(getPolicyNames()) : false;
    }

    public Listener getListener() {
        return this.listener;
    }

    public List<String> getPolicyNames() {
        if (this.policyNames == null) {
            this.policyNames = new ArrayList();
        }
        return this.policyNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getListener() == null ? 0 : getListener().hashCode()) + 31) * 31;
        if (getPolicyNames() != null) {
            i = getPolicyNames().hashCode();
        }
        return hashCode + i;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
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
        if (this.listener != null) {
            stringBuilder.append("Listener: " + this.listener + ", ");
        }
        if (this.policyNames != null) {
            stringBuilder.append("PolicyNames: " + this.policyNames + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListenerDescription withListener(Listener listener) {
        this.listener = listener;
        return this;
    }

    public ListenerDescription withPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.policyNames = arrayList;
        }
        return this;
    }

    public ListenerDescription withPolicyNames(String... strArr) {
        if (getPolicyNames() == null) {
            setPolicyNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getPolicyNames().add(add);
        }
        return this;
    }
}
