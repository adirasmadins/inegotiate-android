package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateKeyPairRequest extends AmazonWebServiceRequest {
    private String keyName;

    public CreateKeyPairRequest(String str) {
        this.keyName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateKeyPairRequest)) {
            return false;
        }
        CreateKeyPairRequest createKeyPairRequest = (CreateKeyPairRequest) obj;
        return ((createKeyPairRequest.getKeyName() == null ? 1 : 0) ^ (getKeyName() == null ? 1 : 0)) == 0 ? createKeyPairRequest.getKeyName() == null || createKeyPairRequest.getKeyName().equals(getKeyName()) : false;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public int hashCode() {
        return (getKeyName() == null ? 0 : getKeyName().hashCode()) + 31;
    }

    public void setKeyName(String str) {
        this.keyName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.keyName != null) {
            stringBuilder.append("KeyName: " + this.keyName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateKeyPairRequest withKeyName(String str) {
        this.keyName = str;
        return this;
    }
}
