package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeSecurityGroupsResult {
    private List<SecurityGroup> securityGroups;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSecurityGroupsResult)) {
            return false;
        }
        DescribeSecurityGroupsResult describeSecurityGroupsResult = (DescribeSecurityGroupsResult) obj;
        return ((describeSecurityGroupsResult.getSecurityGroups() == null ? 1 : 0) ^ (getSecurityGroups() == null ? 1 : 0)) == 0 ? describeSecurityGroupsResult.getSecurityGroups() == null || describeSecurityGroupsResult.getSecurityGroups().equals(getSecurityGroups()) : false;
    }

    public List<SecurityGroup> getSecurityGroups() {
        if (this.securityGroups == null) {
            this.securityGroups = new ArrayList();
        }
        return this.securityGroups;
    }

    public int hashCode() {
        return (getSecurityGroups() == null ? 0 : getSecurityGroups().hashCode()) + 31;
    }

    public void setSecurityGroups(Collection<SecurityGroup> collection) {
        if (collection == null) {
            this.securityGroups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.securityGroups = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.securityGroups != null) {
            stringBuilder.append("SecurityGroups: " + this.securityGroups + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeSecurityGroupsResult withSecurityGroups(Collection<SecurityGroup> collection) {
        if (collection == null) {
            this.securityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroups = arrayList;
        }
        return this;
    }

    public DescribeSecurityGroupsResult withSecurityGroups(SecurityGroup... securityGroupArr) {
        if (getSecurityGroups() == null) {
            setSecurityGroups(new ArrayList(securityGroupArr.length));
        }
        for (Object add : securityGroupArr) {
            getSecurityGroups().add(add);
        }
        return this;
    }
}
