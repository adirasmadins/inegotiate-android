package com.amazonaws.services.ec2.model;

public class ImportKeyPairResult {
    private String keyFingerprint;
    private String keyName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportKeyPairResult)) {
            return false;
        }
        ImportKeyPairResult importKeyPairResult = (ImportKeyPairResult) obj;
        if (((importKeyPairResult.getKeyName() == null ? 1 : 0) ^ (getKeyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importKeyPairResult.getKeyName() != null && !importKeyPairResult.getKeyName().equals(getKeyName())) {
            return false;
        }
        return ((importKeyPairResult.getKeyFingerprint() == null ? 1 : 0) ^ (getKeyFingerprint() == null ? 1 : 0)) == 0 ? importKeyPairResult.getKeyFingerprint() == null || importKeyPairResult.getKeyFingerprint().equals(getKeyFingerprint()) : false;
    }

    public String getKeyFingerprint() {
        return this.keyFingerprint;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKeyName() == null ? 0 : getKeyName().hashCode()) + 31) * 31;
        if (getKeyFingerprint() != null) {
            i = getKeyFingerprint().hashCode();
        }
        return hashCode + i;
    }

    public void setKeyFingerprint(String str) {
        this.keyFingerprint = str;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ImportKeyPairResult withKeyFingerprint(String str) {
        this.keyFingerprint = str;
        return this;
    }

    public ImportKeyPairResult withKeyName(String str) {
        this.keyName = str;
        return this;
    }
}
