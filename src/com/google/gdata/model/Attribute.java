package com.google.gdata.model;

import com.google.gdata.util.common.base.Objects;
import com.google.gdata.util.common.base.Preconditions;

public final class Attribute {
    private final AttributeKey<?> key;
    private volatile boolean locked;
    private Object value;

    Attribute(AttributeKey<?> key, Object value) {
        this.key = (AttributeKey) Preconditions.checkNotNull(key, "key");
        setValue(value);
    }

    public boolean isLocked() {
        return this.locked;
    }

    public Attribute lock() {
        this.locked = true;
        return this;
    }

    public AttributeKey<?> getAttributeKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public Attribute setValue(Object value) {
        Preconditions.checkState(!this.locked, this.key.getId() + " attribute is read only");
        Preconditions.checkNotNull(value, "Attribute value cannot be null.");
        Preconditions.checkArgument(this.key.getDatatype().isAssignableFrom(value.getClass()), "Cannot assign a value of type %s", value.getClass());
        this.value = value;
        return this;
    }

    public String toString() {
        return Objects.toStringHelper(this).add(this.key.getId() + "@" + Integer.toHexString(hashCode()), this.value).toString();
    }
}
