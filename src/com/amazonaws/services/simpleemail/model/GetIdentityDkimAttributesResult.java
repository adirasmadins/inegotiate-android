package com.amazonaws.services.simpleemail.model;

import java.util.HashMap;
import java.util.Map;

public class GetIdentityDkimAttributesResult {
    private Map<String, IdentityDkimAttributes> dkimAttributes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdentityDkimAttributesResult)) {
            return false;
        }
        GetIdentityDkimAttributesResult getIdentityDkimAttributesResult = (GetIdentityDkimAttributesResult) obj;
        return ((getIdentityDkimAttributesResult.getDkimAttributes() == null ? 1 : 0) ^ (getDkimAttributes() == null ? 1 : 0)) == 0 ? getIdentityDkimAttributesResult.getDkimAttributes() == null || getIdentityDkimAttributesResult.getDkimAttributes().equals(getDkimAttributes()) : false;
    }

    public Map<String, IdentityDkimAttributes> getDkimAttributes() {
        if (this.dkimAttributes == null) {
            this.dkimAttributes = new HashMap();
        }
        return this.dkimAttributes;
    }

    public int hashCode() {
        return (getDkimAttributes() == null ? 0 : getDkimAttributes().hashCode()) + 31;
    }

    public void setDkimAttributes(Map<String, IdentityDkimAttributes> map) {
        this.dkimAttributes = map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.dkimAttributes != null) {
            stringBuilder.append("DkimAttributes: " + this.dkimAttributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetIdentityDkimAttributesResult withDkimAttributes(Map<String, IdentityDkimAttributes> map) {
        setDkimAttributes(map);
        return this;
    }
}
