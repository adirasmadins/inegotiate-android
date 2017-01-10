package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IpPermission {
    private Integer fromPort;
    private String ipProtocol;
    private List<String> ipRanges;
    private Integer toPort;
    private List<UserIdGroupPair> userIdGroupPairs;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IpPermission)) {
            return false;
        }
        IpPermission ipPermission = (IpPermission) obj;
        if (((ipPermission.getIpProtocol() == null ? 1 : 0) ^ (getIpProtocol() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ipPermission.getIpProtocol() != null && !ipPermission.getIpProtocol().equals(getIpProtocol())) {
            return false;
        }
        if (((ipPermission.getFromPort() == null ? 1 : 0) ^ (getFromPort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ipPermission.getFromPort() != null && !ipPermission.getFromPort().equals(getFromPort())) {
            return false;
        }
        if (((ipPermission.getToPort() == null ? 1 : 0) ^ (getToPort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ipPermission.getToPort() != null && !ipPermission.getToPort().equals(getToPort())) {
            return false;
        }
        if (((ipPermission.getUserIdGroupPairs() == null ? 1 : 0) ^ (getUserIdGroupPairs() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ipPermission.getUserIdGroupPairs() != null && !ipPermission.getUserIdGroupPairs().equals(getUserIdGroupPairs())) {
            return false;
        }
        return ((ipPermission.getIpRanges() == null ? 1 : 0) ^ (getIpRanges() == null ? 1 : 0)) == 0 ? ipPermission.getIpRanges() == null || ipPermission.getIpRanges().equals(getIpRanges()) : false;
    }

    public Integer getFromPort() {
        return this.fromPort;
    }

    public String getIpProtocol() {
        return this.ipProtocol;
    }

    public List<String> getIpRanges() {
        if (this.ipRanges == null) {
            this.ipRanges = new ArrayList();
        }
        return this.ipRanges;
    }

    public Integer getToPort() {
        return this.toPort;
    }

    public List<UserIdGroupPair> getUserIdGroupPairs() {
        if (this.userIdGroupPairs == null) {
            this.userIdGroupPairs = new ArrayList();
        }
        return this.userIdGroupPairs;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getUserIdGroupPairs() == null ? 0 : getUserIdGroupPairs().hashCode()) + (((getToPort() == null ? 0 : getToPort().hashCode()) + (((getFromPort() == null ? 0 : getFromPort().hashCode()) + (((getIpProtocol() == null ? 0 : getIpProtocol().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getIpRanges() != null) {
            i = getIpRanges().hashCode();
        }
        return hashCode + i;
    }

    public void setFromPort(Integer num) {
        this.fromPort = num;
    }

    public void setIpProtocol(String str) {
        this.ipProtocol = str;
    }

    public void setIpRanges(Collection<String> collection) {
        if (collection == null) {
            this.ipRanges = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.ipRanges = arrayList;
    }

    public void setToPort(Integer num) {
        this.toPort = num;
    }

    public void setUserIdGroupPairs(Collection<UserIdGroupPair> collection) {
        if (collection == null) {
            this.userIdGroupPairs = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.userIdGroupPairs = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.ipProtocol != null) {
            stringBuilder.append("IpProtocol: " + this.ipProtocol + ", ");
        }
        if (this.fromPort != null) {
            stringBuilder.append("FromPort: " + this.fromPort + ", ");
        }
        if (this.toPort != null) {
            stringBuilder.append("ToPort: " + this.toPort + ", ");
        }
        if (this.userIdGroupPairs != null) {
            stringBuilder.append("UserIdGroupPairs: " + this.userIdGroupPairs + ", ");
        }
        if (this.ipRanges != null) {
            stringBuilder.append("IpRanges: " + this.ipRanges + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public IpPermission withFromPort(Integer num) {
        this.fromPort = num;
        return this;
    }

    public IpPermission withIpProtocol(String str) {
        this.ipProtocol = str;
        return this;
    }

    public IpPermission withIpRanges(Collection<String> collection) {
        if (collection == null) {
            this.ipRanges = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.ipRanges = arrayList;
        }
        return this;
    }

    public IpPermission withIpRanges(String... strArr) {
        if (getIpRanges() == null) {
            setIpRanges(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getIpRanges().add(add);
        }
        return this;
    }

    public IpPermission withToPort(Integer num) {
        this.toPort = num;
        return this;
    }

    public IpPermission withUserIdGroupPairs(Collection<UserIdGroupPair> collection) {
        if (collection == null) {
            this.userIdGroupPairs = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.userIdGroupPairs = arrayList;
        }
        return this;
    }

    public IpPermission withUserIdGroupPairs(UserIdGroupPair... userIdGroupPairArr) {
        if (getUserIdGroupPairs() == null) {
            setUserIdGroupPairs(new ArrayList(userIdGroupPairArr.length));
        }
        for (Object add : userIdGroupPairArr) {
            getUserIdGroupPairs().add(add);
        }
        return this;
    }
}
