package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateSecurityGroupRequest extends AmazonWebServiceRequest {
    private String description;
    private String groupName;
    private String vpcId;

    public CreateSecurityGroupRequest(String str, String str2) {
        this.groupName = str;
        this.description = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateSecurityGroupRequest)) {
            return false;
        }
        CreateSecurityGroupRequest createSecurityGroupRequest = (CreateSecurityGroupRequest) obj;
        if (((createSecurityGroupRequest.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createSecurityGroupRequest.getGroupName() != null && !createSecurityGroupRequest.getGroupName().equals(getGroupName())) {
            return false;
        }
        if (((createSecurityGroupRequest.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createSecurityGroupRequest.getDescription() != null && !createSecurityGroupRequest.getDescription().equals(getDescription())) {
            return false;
        }
        return ((createSecurityGroupRequest.getVpcId() == null ? 1 : 0) ^ (getVpcId() == null ? 1 : 0)) == 0 ? createSecurityGroupRequest.getVpcId() == null || createSecurityGroupRequest.getVpcId().equals(getVpcId()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getVpcId() {
        return this.vpcId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDescription() == null ? 0 : getDescription().hashCode()) + (((getGroupName() == null ? 0 : getGroupName().hashCode()) + 31) * 31)) * 31;
        if (getVpcId() != null) {
            i = getVpcId().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setVpcId(String str) {
        this.vpcId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.groupName != null) {
            stringBuilder.append("GroupName: " + this.groupName + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.vpcId != null) {
            stringBuilder.append("VpcId: " + this.vpcId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateSecurityGroupRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public CreateSecurityGroupRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public CreateSecurityGroupRequest withVpcId(String str) {
        this.vpcId = str;
        return this;
    }
}
