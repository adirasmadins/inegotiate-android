package com.amazonaws.services.simpleemail.model;

import java.util.HashMap;
import java.util.Map;

public class GetIdentityVerificationAttributesResult {
    private Map<String, IdentityVerificationAttributes> verificationAttributes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdentityVerificationAttributesResult)) {
            return false;
        }
        GetIdentityVerificationAttributesResult getIdentityVerificationAttributesResult = (GetIdentityVerificationAttributesResult) obj;
        return ((getIdentityVerificationAttributesResult.getVerificationAttributes() == null ? 1 : 0) ^ (getVerificationAttributes() == null ? 1 : 0)) == 0 ? getIdentityVerificationAttributesResult.getVerificationAttributes() == null || getIdentityVerificationAttributesResult.getVerificationAttributes().equals(getVerificationAttributes()) : false;
    }

    public Map<String, IdentityVerificationAttributes> getVerificationAttributes() {
        if (this.verificationAttributes == null) {
            this.verificationAttributes = new HashMap();
        }
        return this.verificationAttributes;
    }

    public int hashCode() {
        return (getVerificationAttributes() == null ? 0 : getVerificationAttributes().hashCode()) + 31;
    }

    public void setVerificationAttributes(Map<String, IdentityVerificationAttributes> map) {
        this.verificationAttributes = map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.verificationAttributes != null) {
            stringBuilder.append("VerificationAttributes: " + this.verificationAttributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetIdentityVerificationAttributesResult withVerificationAttributes(Map<String, IdentityVerificationAttributes> map) {
        setVerificationAttributes(map);
        return this;
    }
}
