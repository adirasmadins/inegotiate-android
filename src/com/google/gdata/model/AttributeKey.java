package com.google.gdata.model;

import com.google.gdata.util.common.base.Preconditions;

public final class AttributeKey<D> extends MetadataKey<D> {
    public static AttributeKey<String> of(QName id) {
        return of(id, String.class);
    }

    public static <T> AttributeKey<T> of(QName id, Class<? extends T> datatype) {
        return new AttributeKey(id, datatype);
    }

    private AttributeKey(QName id, Class<? extends D> datatype) {
        super((QName) Preconditions.checkNotNull(id, "id"), datatype);
    }

    public boolean matches(MetadataKey<?> other) {
        if (other != null && (other instanceof AttributeKey)) {
            return matchIdAndDatatype(other);
        }
        return false;
    }

    public int compareTo(MetadataKey<?> other) {
        if (other == this) {
            return 0;
        }
        if (!(other instanceof AttributeKey)) {
            return -1;
        }
        int compare = MetadataKey.compareQName(this.id, other.id);
        return compare == 0 ? MetadataKey.compareClass(this.datatype, other.datatype) : compare;
    }

    public int hashCode() {
        int hashCode = this.datatype.hashCode() * 17;
        if (this.id != null) {
            return hashCode + this.id.hashCode();
        }
        return hashCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != AttributeKey.class) {
            return false;
        }
        AttributeKey<?> o = (AttributeKey) obj;
        if (this.id.equals(o.id) && this.datatype == o.datatype) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "{AttributeKey " + this.id + ", D:" + this.datatype + "}";
    }
}
