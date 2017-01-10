package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeKeyPairsResult {
    private List<KeyPairInfo> keyPairs;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeKeyPairsResult)) {
            return false;
        }
        DescribeKeyPairsResult describeKeyPairsResult = (DescribeKeyPairsResult) obj;
        return ((describeKeyPairsResult.getKeyPairs() == null ? 1 : 0) ^ (getKeyPairs() == null ? 1 : 0)) == 0 ? describeKeyPairsResult.getKeyPairs() == null || describeKeyPairsResult.getKeyPairs().equals(getKeyPairs()) : false;
    }

    public List<KeyPairInfo> getKeyPairs() {
        if (this.keyPairs == null) {
            this.keyPairs = new ArrayList();
        }
        return this.keyPairs;
    }

    public int hashCode() {
        return (getKeyPairs() == null ? 0 : getKeyPairs().hashCode()) + 31;
    }

    public void setKeyPairs(Collection<KeyPairInfo> collection) {
        if (collection == null) {
            this.keyPairs = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.keyPairs = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.keyPairs != null) {
            stringBuilder.append("KeyPairs: " + this.keyPairs + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeKeyPairsResult withKeyPairs(Collection<KeyPairInfo> collection) {
        if (collection == null) {
            this.keyPairs = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.keyPairs = arrayList;
        }
        return this;
    }

    public DescribeKeyPairsResult withKeyPairs(KeyPairInfo... keyPairInfoArr) {
        if (getKeyPairs() == null) {
            setKeyPairs(new ArrayList(keyPairInfoArr.length));
        }
        for (Object add : keyPairInfoArr) {
            getKeyPairs().add(add);
        }
        return this;
    }
}
