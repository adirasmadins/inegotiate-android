package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityGroup {
    private String description;
    private String groupId;
    private String groupName;
    private List<IpPermission> ipPermissions;
    private List<IpPermission> ipPermissionsEgress;
    private String ownerId;
    private List<Tag> tags;
    private String vpcId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SecurityGroup)) {
            return false;
        }
        SecurityGroup securityGroup = (SecurityGroup) obj;
        if (((securityGroup.getOwnerId() == null ? 1 : 0) ^ (getOwnerId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (securityGroup.getOwnerId() != null && !securityGroup.getOwnerId().equals(getOwnerId())) {
            return false;
        }
        if (((securityGroup.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (securityGroup.getGroupName() != null && !securityGroup.getGroupName().equals(getGroupName())) {
            return false;
        }
        if (((securityGroup.getGroupId() == null ? 1 : 0) ^ (getGroupId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (securityGroup.getGroupId() != null && !securityGroup.getGroupId().equals(getGroupId())) {
            return false;
        }
        if (((securityGroup.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (securityGroup.getDescription() != null && !securityGroup.getDescription().equals(getDescription())) {
            return false;
        }
        if (((securityGroup.getIpPermissions() == null ? 1 : 0) ^ (getIpPermissions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (securityGroup.getIpPermissions() != null && !securityGroup.getIpPermissions().equals(getIpPermissions())) {
            return false;
        }
        if (((securityGroup.getIpPermissionsEgress() == null ? 1 : 0) ^ (getIpPermissionsEgress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (securityGroup.getIpPermissionsEgress() != null && !securityGroup.getIpPermissionsEgress().equals(getIpPermissionsEgress())) {
            return false;
        }
        if (((securityGroup.getVpcId() == null ? 1 : 0) ^ (getVpcId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (securityGroup.getVpcId() != null && !securityGroup.getVpcId().equals(getVpcId())) {
            return false;
        }
        return ((securityGroup.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) == 0 ? securityGroup.getTags() == null || securityGroup.getTags().equals(getTags()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<IpPermission> getIpPermissions() {
        if (this.ipPermissions == null) {
            this.ipPermissions = new ArrayList();
        }
        return this.ipPermissions;
    }

    public List<IpPermission> getIpPermissionsEgress() {
        if (this.ipPermissionsEgress == null) {
            this.ipPermissionsEgress = new ArrayList();
        }
        return this.ipPermissionsEgress;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public String getVpcId() {
        return this.vpcId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVpcId() == null ? 0 : getVpcId().hashCode()) + (((getIpPermissionsEgress() == null ? 0 : getIpPermissionsEgress().hashCode()) + (((getIpPermissions() == null ? 0 : getIpPermissions().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getGroupId() == null ? 0 : getGroupId().hashCode()) + (((getGroupName() == null ? 0 : getGroupName().hashCode()) + (((getOwnerId() == null ? 0 : getOwnerId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getTags() != null) {
            i = getTags().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setIpPermissions(Collection<IpPermission> collection) {
        if (collection == null) {
            this.ipPermissions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.ipPermissions = arrayList;
    }

    public void setIpPermissionsEgress(Collection<IpPermission> collection) {
        if (collection == null) {
            this.ipPermissionsEgress = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.ipPermissionsEgress = arrayList;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.tags = arrayList;
    }

    public void setVpcId(String str) {
        this.vpcId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.ownerId != null) {
            stringBuilder.append("OwnerId: " + this.ownerId + ", ");
        }
        if (this.groupName != null) {
            stringBuilder.append("GroupName: " + this.groupName + ", ");
        }
        if (this.groupId != null) {
            stringBuilder.append("GroupId: " + this.groupId + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.ipPermissions != null) {
            stringBuilder.append("IpPermissions: " + this.ipPermissions + ", ");
        }
        if (this.ipPermissionsEgress != null) {
            stringBuilder.append("IpPermissionsEgress: " + this.ipPermissionsEgress + ", ");
        }
        if (this.vpcId != null) {
            stringBuilder.append("VpcId: " + this.vpcId + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SecurityGroup withDescription(String str) {
        this.description = str;
        return this;
    }

    public SecurityGroup withGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public SecurityGroup withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public SecurityGroup withIpPermissions(Collection<IpPermission> collection) {
        if (collection == null) {
            this.ipPermissions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.ipPermissions = arrayList;
        }
        return this;
    }

    public SecurityGroup withIpPermissions(IpPermission... ipPermissionArr) {
        if (getIpPermissions() == null) {
            setIpPermissions(new ArrayList(ipPermissionArr.length));
        }
        for (Object add : ipPermissionArr) {
            getIpPermissions().add(add);
        }
        return this;
    }

    public SecurityGroup withIpPermissionsEgress(Collection<IpPermission> collection) {
        if (collection == null) {
            this.ipPermissionsEgress = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.ipPermissionsEgress = arrayList;
        }
        return this;
    }

    public SecurityGroup withIpPermissionsEgress(IpPermission... ipPermissionArr) {
        if (getIpPermissionsEgress() == null) {
            setIpPermissionsEgress(new ArrayList(ipPermissionArr.length));
        }
        for (Object add : ipPermissionArr) {
            getIpPermissionsEgress().add(add);
        }
        return this;
    }

    public SecurityGroup withOwnerId(String str) {
        this.ownerId = str;
        return this;
    }

    public SecurityGroup withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public SecurityGroup withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }

    public SecurityGroup withVpcId(String str) {
        this.vpcId = str;
        return this;
    }
}
