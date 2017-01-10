package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModifySnapshotAttributeRequest extends AmazonWebServiceRequest {
    private String attribute;
    private CreateVolumePermissionModifications createVolumePermission;
    private List<String> groupNames;
    private String operationType;
    private String snapshotId;
    private List<String> userIds;

    public ModifySnapshotAttributeRequest(String str, SnapshotAttributeName snapshotAttributeName, String str2) {
        this.snapshotId = str;
        this.attribute = snapshotAttributeName.toString();
        this.operationType = str2;
    }

    public ModifySnapshotAttributeRequest(String str, String str2, String str3) {
        this.snapshotId = str;
        this.attribute = str2;
        this.operationType = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ModifySnapshotAttributeRequest)) {
            return false;
        }
        ModifySnapshotAttributeRequest modifySnapshotAttributeRequest = (ModifySnapshotAttributeRequest) obj;
        if (((modifySnapshotAttributeRequest.getSnapshotId() == null ? 1 : 0) ^ (getSnapshotId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifySnapshotAttributeRequest.getSnapshotId() != null && !modifySnapshotAttributeRequest.getSnapshotId().equals(getSnapshotId())) {
            return false;
        }
        if (((modifySnapshotAttributeRequest.getAttribute() == null ? 1 : 0) ^ (getAttribute() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifySnapshotAttributeRequest.getAttribute() != null && !modifySnapshotAttributeRequest.getAttribute().equals(getAttribute())) {
            return false;
        }
        if (((modifySnapshotAttributeRequest.getOperationType() == null ? 1 : 0) ^ (getOperationType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifySnapshotAttributeRequest.getOperationType() != null && !modifySnapshotAttributeRequest.getOperationType().equals(getOperationType())) {
            return false;
        }
        if (((modifySnapshotAttributeRequest.getUserIds() == null ? 1 : 0) ^ (getUserIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifySnapshotAttributeRequest.getUserIds() != null && !modifySnapshotAttributeRequest.getUserIds().equals(getUserIds())) {
            return false;
        }
        if (((modifySnapshotAttributeRequest.getGroupNames() == null ? 1 : 0) ^ (getGroupNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifySnapshotAttributeRequest.getGroupNames() != null && !modifySnapshotAttributeRequest.getGroupNames().equals(getGroupNames())) {
            return false;
        }
        return ((modifySnapshotAttributeRequest.getCreateVolumePermission() == null ? 1 : 0) ^ (getCreateVolumePermission() == null ? 1 : 0)) == 0 ? modifySnapshotAttributeRequest.getCreateVolumePermission() == null || modifySnapshotAttributeRequest.getCreateVolumePermission().equals(getCreateVolumePermission()) : false;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public CreateVolumePermissionModifications getCreateVolumePermission() {
        return this.createVolumePermission;
    }

    public List<String> getGroupNames() {
        if (this.groupNames == null) {
            this.groupNames = new ArrayList();
        }
        return this.groupNames;
    }

    public String getOperationType() {
        return this.operationType;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public List<String> getUserIds() {
        if (this.userIds == null) {
            this.userIds = new ArrayList();
        }
        return this.userIds;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getGroupNames() == null ? 0 : getGroupNames().hashCode()) + (((getUserIds() == null ? 0 : getUserIds().hashCode()) + (((getOperationType() == null ? 0 : getOperationType().hashCode()) + (((getAttribute() == null ? 0 : getAttribute().hashCode()) + (((getSnapshotId() == null ? 0 : getSnapshotId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getCreateVolumePermission() != null) {
            i = getCreateVolumePermission().hashCode();
        }
        return hashCode + i;
    }

    public void setAttribute(SnapshotAttributeName snapshotAttributeName) {
        this.attribute = snapshotAttributeName.toString();
    }

    public void setAttribute(String str) {
        this.attribute = str;
    }

    public void setCreateVolumePermission(CreateVolumePermissionModifications createVolumePermissionModifications) {
        this.createVolumePermission = createVolumePermissionModifications;
    }

    public void setGroupNames(Collection<String> collection) {
        if (collection == null) {
            this.groupNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.groupNames = arrayList;
    }

    public void setOperationType(String str) {
        this.operationType = str;
    }

    public void setSnapshotId(String str) {
        this.snapshotId = str;
    }

    public void setUserIds(Collection<String> collection) {
        if (collection == null) {
            this.userIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.userIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.snapshotId != null) {
            stringBuilder.append("SnapshotId: " + this.snapshotId + ", ");
        }
        if (this.attribute != null) {
            stringBuilder.append("Attribute: " + this.attribute + ", ");
        }
        if (this.operationType != null) {
            stringBuilder.append("OperationType: " + this.operationType + ", ");
        }
        if (this.userIds != null) {
            stringBuilder.append("UserIds: " + this.userIds + ", ");
        }
        if (this.groupNames != null) {
            stringBuilder.append("GroupNames: " + this.groupNames + ", ");
        }
        if (this.createVolumePermission != null) {
            stringBuilder.append("CreateVolumePermission: " + this.createVolumePermission + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ModifySnapshotAttributeRequest withAttribute(SnapshotAttributeName snapshotAttributeName) {
        this.attribute = snapshotAttributeName.toString();
        return this;
    }

    public ModifySnapshotAttributeRequest withAttribute(String str) {
        this.attribute = str;
        return this;
    }

    public ModifySnapshotAttributeRequest withCreateVolumePermission(CreateVolumePermissionModifications createVolumePermissionModifications) {
        this.createVolumePermission = createVolumePermissionModifications;
        return this;
    }

    public ModifySnapshotAttributeRequest withGroupNames(Collection<String> collection) {
        if (collection == null) {
            this.groupNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.groupNames = arrayList;
        }
        return this;
    }

    public ModifySnapshotAttributeRequest withGroupNames(String... strArr) {
        if (getGroupNames() == null) {
            setGroupNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getGroupNames().add(add);
        }
        return this;
    }

    public ModifySnapshotAttributeRequest withOperationType(String str) {
        this.operationType = str;
        return this;
    }

    public ModifySnapshotAttributeRequest withSnapshotId(String str) {
        this.snapshotId = str;
        return this;
    }

    public ModifySnapshotAttributeRequest withUserIds(Collection<String> collection) {
        if (collection == null) {
            this.userIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.userIds = arrayList;
        }
        return this;
    }

    public ModifySnapshotAttributeRequest withUserIds(String... strArr) {
        if (getUserIds() == null) {
            setUserIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getUserIds().add(add);
        }
        return this;
    }
}
