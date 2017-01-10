package com.amazonaws.services.simpleemail.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListVerifiedEmailAddressesResult {
    private List<String> verifiedEmailAddresses;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListVerifiedEmailAddressesResult)) {
            return false;
        }
        ListVerifiedEmailAddressesResult listVerifiedEmailAddressesResult = (ListVerifiedEmailAddressesResult) obj;
        return ((listVerifiedEmailAddressesResult.getVerifiedEmailAddresses() == null ? 1 : 0) ^ (getVerifiedEmailAddresses() == null ? 1 : 0)) == 0 ? listVerifiedEmailAddressesResult.getVerifiedEmailAddresses() == null || listVerifiedEmailAddressesResult.getVerifiedEmailAddresses().equals(getVerifiedEmailAddresses()) : false;
    }

    public List<String> getVerifiedEmailAddresses() {
        if (this.verifiedEmailAddresses == null) {
            this.verifiedEmailAddresses = new ArrayList();
        }
        return this.verifiedEmailAddresses;
    }

    public int hashCode() {
        return (getVerifiedEmailAddresses() == null ? 0 : getVerifiedEmailAddresses().hashCode()) + 31;
    }

    public void setVerifiedEmailAddresses(Collection<String> collection) {
        if (collection == null) {
            this.verifiedEmailAddresses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.verifiedEmailAddresses = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.verifiedEmailAddresses != null) {
            stringBuilder.append("VerifiedEmailAddresses: " + this.verifiedEmailAddresses + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListVerifiedEmailAddressesResult withVerifiedEmailAddresses(Collection<String> collection) {
        if (collection == null) {
            this.verifiedEmailAddresses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.verifiedEmailAddresses = arrayList;
        }
        return this;
    }

    public ListVerifiedEmailAddressesResult withVerifiedEmailAddresses(String... strArr) {
        if (getVerifiedEmailAddresses() == null) {
            setVerifiedEmailAddresses(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getVerifiedEmailAddresses().add(add);
        }
        return this;
    }
}
