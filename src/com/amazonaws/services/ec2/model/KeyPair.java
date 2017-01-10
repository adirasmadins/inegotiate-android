package com.amazonaws.services.ec2.model;

public class KeyPair {
    private String keyFingerprint;
    private String keyMaterial;
    private String keyName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeyPair)) {
            return false;
        }
        KeyPair keyPair = (KeyPair) obj;
        if (((keyPair.getKeyName() == null ? 1 : 0) ^ (getKeyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (keyPair.getKeyName() != null && !keyPair.getKeyName().equals(getKeyName())) {
            return false;
        }
        if (((keyPair.getKeyFingerprint() == null ? 1 : 0) ^ (getKeyFingerprint() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (keyPair.getKeyFingerprint() != null && !keyPair.getKeyFingerprint().equals(getKeyFingerprint())) {
            return false;
        }
        return ((keyPair.getKeyMaterial() == null ? 1 : 0) ^ (getKeyMaterial() == null ? 1 : 0)) == 0 ? keyPair.getKeyMaterial() == null || keyPair.getKeyMaterial().equals(getKeyMaterial()) : false;
    }

    public String getKeyFingerprint() {
        return this.keyFingerprint;
    }

    public String getKeyMaterial() {
        return this.keyMaterial;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKeyFingerprint() == null ? 0 : getKeyFingerprint().hashCode()) + (((getKeyName() == null ? 0 : getKeyName().hashCode()) + 31) * 31)) * 31;
        if (getKeyMaterial() != null) {
            i = getKeyMaterial().hashCode();
        }
        return hashCode + i;
    }

    public void setKeyFingerprint(String str) {
        this.keyFingerprint = str;
    }

    public void setKeyMaterial(String str) {
        this.keyMaterial = str;
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
        if (this.keyFingerprint != null) {
            stringBuilder.append("KeyFingerprint: " + this.keyFingerprint + ", ");
        }
        if (this.keyMaterial != null) {
            stringBuilder.append("KeyMaterial: " + this.keyMaterial + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public KeyPair withKeyFingerprint(String str) {
        this.keyFingerprint = str;
        return this;
    }

    public KeyPair withKeyMaterial(String str) {
        this.keyMaterial = str;
        return this;
    }

    public KeyPair withKeyName(String str) {
        this.keyName = str;
        return this;
    }
}
