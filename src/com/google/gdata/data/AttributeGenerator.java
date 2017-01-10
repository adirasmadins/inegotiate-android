package com.google.gdata.data;

import com.google.gdata.data.AttributeHelper.EnumToAttributeValue;
import java.util.LinkedHashMap;

public class AttributeGenerator extends LinkedHashMap<String, String> {
    private String content;

    public AttributeGenerator() {
        this.content = null;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void put(String key, long value) {
        put(key, Long.toString(value));
    }

    public void put(String key, boolean value) {
        put(key, Boolean.toString(value));
    }

    public void put(String key, float value) {
        if (value == Float.POSITIVE_INFINITY) {
            put(key, "INF");
        } else if (value == Float.NEGATIVE_INFINITY) {
            put(key, "-INF");
        } else {
            put(key, Float.toString(value));
        }
    }

    public void put(String key, double value) {
        if (value == Double.POSITIVE_INFINITY) {
            put(key, "INF");
        } else if (value == Double.NEGATIVE_INFINITY) {
            put(key, "-INF");
        } else {
            put(key, Double.toString(value));
        }
    }

    public void put(String key, Object value) {
        if (value == null) {
            super.put(key, null);
        } else if (value instanceof Float) {
            put(key, ((Float) value).floatValue());
        } else if (value instanceof Double) {
            put(key, ((Double) value).doubleValue());
        } else {
            put(key, value.toString());
        }
    }

    public <T extends Enum<T>> void put(String key, T value, EnumToAttributeValue<T> enumToAttributeValue) {
        put(key, value == null ? null : enumToAttributeValue.getAttributeValue(value));
    }
}
