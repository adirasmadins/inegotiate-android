package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModifyImageAttributeRequest extends AmazonWebServiceRequest {
    private String attribute;
    private String description;
    private String imageId;
    private LaunchPermissionModifications launchPermission;
    private String operationType;
    private List<String> productCodes;
    private List<String> userGroups;
    private List<String> userIds;
    private String value;

    public ModifyImageAttributeRequest(String str, String str2) {
        this.imageId = str;
        this.attribute = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ModifyImageAttributeRequest)) {
            return false;
        }
        ModifyImageAttributeRequest modifyImageAttributeRequest = (ModifyImageAttributeRequest) obj;
        if (((modifyImageAttributeRequest.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyImageAttributeRequest.getImageId() != null && !modifyImageAttributeRequest.getImageId().equals(getImageId())) {
            return false;
        }
        if (((modifyImageAttributeRequest.getAttribute() == null ? 1 : 0) ^ (getAttribute() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyImageAttributeRequest.getAttribute() != null && !modifyImageAttributeRequest.getAttribute().equals(getAttribute())) {
            return false;
        }
        if (((modifyImageAttributeRequest.getOperationType() == null ? 1 : 0) ^ (getOperationType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyImageAttributeRequest.getOperationType() != null && !modifyImageAttributeRequest.getOperationType().equals(getOperationType())) {
            return false;
        }
        if (((modifyImageAttributeRequest.getUserIds() == null ? 1 : 0) ^ (getUserIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyImageAttributeRequest.getUserIds() != null && !modifyImageAttributeRequest.getUserIds().equals(getUserIds())) {
            return false;
        }
        if (((modifyImageAttributeRequest.getUserGroups() == null ? 1 : 0) ^ (getUserGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyImageAttributeRequest.getUserGroups() != null && !modifyImageAttributeRequest.getUserGroups().equals(getUserGroups())) {
            return false;
        }
        if (((modifyImageAttributeRequest.getProductCodes() == null ? 1 : 0) ^ (getProductCodes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyImageAttributeRequest.getProductCodes() != null && !modifyImageAttributeRequest.getProductCodes().equals(getProductCodes())) {
            return false;
        }
        if (((modifyImageAttributeRequest.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyImageAttributeRequest.getValue() != null && !modifyImageAttributeRequest.getValue().equals(getValue())) {
            return false;
        }
        if (((modifyImageAttributeRequest.getLaunchPermission() == null ? 1 : 0) ^ (getLaunchPermission() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyImageAttributeRequest.getLaunchPermission() != null && !modifyImageAttributeRequest.getLaunchPermission().equals(getLaunchPermission())) {
            return false;
        }
        return ((modifyImageAttributeRequest.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) == 0 ? modifyImageAttributeRequest.getDescription() == null || modifyImageAttributeRequest.getDescription().equals(getDescription()) : false;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageId() {
        return this.imageId;
    }

    public LaunchPermissionModifications getLaunchPermission() {
        return this.launchPermission;
    }

    public String getOperationType() {
        return this.operationType;
    }

    public List<String> getProductCodes() {
        if (this.productCodes == null) {
            this.productCodes = new ArrayList();
        }
        return this.productCodes;
    }

    public List<String> getUserGroups() {
        if (this.userGroups == null) {
            this.userGroups = new ArrayList();
        }
        return this.userGroups;
    }

    public List<String> getUserIds() {
        if (this.userIds == null) {
            this.userIds = new ArrayList();
        }
        return this.userIds;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLaunchPermission() == null ? 0 : getLaunchPermission().hashCode()) + (((getValue() == null ? 0 : getValue().hashCode()) + (((getProductCodes() == null ? 0 : getProductCodes().hashCode()) + (((getUserGroups() == null ? 0 : getUserGroups().hashCode()) + (((getUserIds() == null ? 0 : getUserIds().hashCode()) + (((getOperationType() == null ? 0 : getOperationType().hashCode()) + (((getAttribute() == null ? 0 : getAttribute().hashCode()) + (((getImageId() == null ? 0 : getImageId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getDescription() != null) {
            i = getDescription().hashCode();
        }
        return hashCode + i;
    }

    public void setAttribute(String str) {
        this.attribute = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImageId(String str) {
        this.imageId = str;
    }

    public void setLaunchPermission(LaunchPermissionModifications launchPermissionModifications) {
        this.launchPermission = launchPermissionModifications;
    }

    public void setOperationType(String str) {
        this.operationType = str;
    }

    public void setProductCodes(Collection<String> collection) {
        if (collection == null) {
            this.productCodes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.productCodes = arrayList;
    }

    public void setUserGroups(Collection<String> collection) {
        if (collection == null) {
            this.userGroups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.userGroups = arrayList;
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

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.imageId != null) {
            stringBuilder.append("ImageId: " + this.imageId + ", ");
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
        if (this.userGroups != null) {
            stringBuilder.append("UserGroups: " + this.userGroups + ", ");
        }
        if (this.productCodes != null) {
            stringBuilder.append("ProductCodes: " + this.productCodes + ", ");
        }
        if (this.value != null) {
            stringBuilder.append("Value: " + this.value + ", ");
        }
        if (this.launchPermission != null) {
            stringBuilder.append("LaunchPermission: " + this.launchPermission + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ModifyImageAttributeRequest withAttribute(String str) {
        this.attribute = str;
        return this;
    }

    public ModifyImageAttributeRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public ModifyImageAttributeRequest withImageId(String str) {
        this.imageId = str;
        return this;
    }

    public ModifyImageAttributeRequest withLaunchPermission(LaunchPermissionModifications launchPermissionModifications) {
        this.launchPermission = launchPermissionModifications;
        return this;
    }

    public ModifyImageAttributeRequest withOperationType(String str) {
        this.operationType = str;
        return this;
    }

    public ModifyImageAttributeRequest withProductCodes(Collection<String> collection) {
        if (collection == null) {
            this.productCodes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.productCodes = arrayList;
        }
        return this;
    }

    public ModifyImageAttributeRequest withProductCodes(String... strArr) {
        if (getProductCodes() == null) {
            setProductCodes(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getProductCodes().add(add);
        }
        return this;
    }

    public ModifyImageAttributeRequest withUserGroups(Collection<String> collection) {
        if (collection == null) {
            this.userGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.userGroups = arrayList;
        }
        return this;
    }

    public ModifyImageAttributeRequest withUserGroups(String... strArr) {
        if (getUserGroups() == null) {
            setUserGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getUserGroups().add(add);
        }
        return this;
    }

    public ModifyImageAttributeRequest withUserIds(Collection<String> collection) {
        if (collection == null) {
            this.userIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.userIds = arrayList;
        }
        return this;
    }

    public ModifyImageAttributeRequest withUserIds(String... strArr) {
        if (getUserIds() == null) {
            setUserIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getUserIds().add(add);
        }
        return this;
    }

    public ModifyImageAttributeRequest withValue(String str) {
        this.value = str;
        return this;
    }
}
