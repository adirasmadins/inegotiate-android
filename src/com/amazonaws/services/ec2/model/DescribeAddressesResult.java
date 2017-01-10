package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAddressesResult {
    private List<Address> addresses;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAddressesResult)) {
            return false;
        }
        DescribeAddressesResult describeAddressesResult = (DescribeAddressesResult) obj;
        return ((describeAddressesResult.getAddresses() == null ? 1 : 0) ^ (getAddresses() == null ? 1 : 0)) == 0 ? describeAddressesResult.getAddresses() == null || describeAddressesResult.getAddresses().equals(getAddresses()) : false;
    }

    public List<Address> getAddresses() {
        if (this.addresses == null) {
            this.addresses = new ArrayList();
        }
        return this.addresses;
    }

    public int hashCode() {
        return (getAddresses() == null ? 0 : getAddresses().hashCode()) + 31;
    }

    public void setAddresses(Collection<Address> collection) {
        if (collection == null) {
            this.addresses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.addresses = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.addresses != null) {
            stringBuilder.append("Addresses: " + this.addresses + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAddressesResult withAddresses(Collection<Address> collection) {
        if (collection == null) {
            this.addresses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.addresses = arrayList;
        }
        return this;
    }

    public DescribeAddressesResult withAddresses(Address... addressArr) {
        if (getAddresses() == null) {
            setAddresses(new ArrayList(addressArr.length));
        }
        for (Object add : addressArr) {
            getAddresses().add(add);
        }
        return this;
    }
}
