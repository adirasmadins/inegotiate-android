package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ImportKeyPairRequest extends AmazonWebServiceRequest {
    private String keyName;
    private String publicKeyMaterial;

    public ImportKeyPairRequest(String str, String str2) {
        this.keyName = str;
        this.publicKeyMaterial = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportKeyPairRequest)) {
            return false;
        }
        ImportKeyPairRequest importKeyPairRequest = (ImportKeyPairRequest) obj;
        if (((importKeyPairRequest.getKeyName() == null ? 1 : 0) ^ (getKeyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importKeyPairRequest.getKeyName() != null && !importKeyPairRequest.getKeyName().equals(getKeyName())) {
            return false;
        }
        return ((importKeyPairRequest.getPublicKeyMaterial() == null ? 1 : 0) ^ (getPublicKeyMaterial() == null ? 1 : 0)) == 0 ? importKeyPairRequest.getPublicKeyMaterial() == null || importKeyPairRequest.getPublicKeyMaterial().equals(getPublicKeyMaterial()) : false;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public String getPublicKeyMaterial() {
        return this.publicKeyMaterial;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKeyName() == null ? 0 : getKeyName().hashCode()) + 31) * 31;
        if (getPublicKeyMaterial() != null) {
            i = getPublicKeyMaterial().hashCode();
        }
        return hashCode + i;
    }

    public void setKeyName(String str) {
        this.keyName = str;
    }

    public void setPublicKeyMaterial(String str) {
        this.publicKeyMaterial = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.keyName != null) {
            stringBuilder.append("KeyName: " + this.keyName + ", ");
        }
        if (this.publicKeyMaterial != null) {
            stringBuilder.append("PublicKeyMaterial: " + this.publicKeyMaterial + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ImportKeyPairRequest withKeyName(String str) {
        this.keyName = str;
        return this;
    }

    public ImportKeyPairRequest withPublicKeyMaterial(String str) {
        this.publicKeyMaterial = str;
        return this;
    }
}
