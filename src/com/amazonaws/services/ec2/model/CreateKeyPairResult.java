package com.amazonaws.services.ec2.model;

public class CreateKeyPairResult {
    private KeyPair keyPair;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateKeyPairResult)) {
            return false;
        }
        CreateKeyPairResult createKeyPairResult = (CreateKeyPairResult) obj;
        return ((createKeyPairResult.getKeyPair() == null ? 1 : 0) ^ (getKeyPair() == null ? 1 : 0)) == 0 ? createKeyPairResult.getKeyPair() == null || createKeyPairResult.getKeyPair().equals(getKeyPair()) : false;
    }

    public KeyPair getKeyPair() {
        return this.keyPair;
    }

    public int hashCode() {
        return (getKeyPair() == null ? 0 : getKeyPair().hashCode()) + 31;
    }

    public void setKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.keyPair != null) {
            stringBuilder.append("KeyPair: " + this.keyPair + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateKeyPairResult withKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
        return this;
    }
}
