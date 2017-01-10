package com.amazonaws.services.sns.model;

import java.util.HashMap;
import java.util.Map;

public class GetTopicAttributesResult {
    private Map<String, String> attributes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetTopicAttributesResult)) {
            return false;
        }
        GetTopicAttributesResult getTopicAttributesResult = (GetTopicAttributesResult) obj;
        return ((getTopicAttributesResult.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) == 0 ? getTopicAttributesResult.getAttributes() == null || getTopicAttributesResult.getAttributes().equals(getAttributes()) : false;
    }

    public Map<String, String> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new HashMap();
        }
        return this.attributes;
    }

    public int hashCode() {
        return (getAttributes() == null ? 0 : getAttributes().hashCode()) + 31;
    }

    public void setAttributes(Map<String, String> map) {
        this.attributes = map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.attributes != null) {
            stringBuilder.append("Attributes: " + this.attributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetTopicAttributesResult withAttributes(Map<String, String> map) {
        setAttributes(map);
        return this;
    }
}
