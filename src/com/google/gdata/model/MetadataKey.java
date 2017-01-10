package com.google.gdata.model;

import com.google.gdata.util.common.base.Preconditions;

public abstract class MetadataKey<D> implements Comparable<MetadataKey<?>> {
    final Class<? extends D> datatype;
    final QName id;

    public abstract boolean matches(MetadataKey<?> metadataKey);

    MetadataKey(QName id, Class<? extends D> datatype) {
        Preconditions.checkNotNull(datatype, "datatype");
        this.id = id;
        this.datatype = datatype;
    }

    public QName getId() {
        return this.id;
    }

    public Class<? extends D> getDatatype() {
        return this.datatype;
    }

    boolean matchIdAndDatatype(MetadataKey<?> other) {
        if (this.id != null && !this.id.matches(other.id)) {
            return false;
        }
        if (this.datatype.isAssignableFrom(other.datatype) || other.datatype == String.class) {
            return true;
        }
        return false;
    }

    static int compareQName(QName a, QName b) {
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        return a.compareTo(b);
    }

    static int compareClass(Class<?> a, Class<?> b) {
        if (a == b) {
            return 0;
        }
        if (a.isAssignableFrom(b)) {
            return -1;
        }
        if (b.isAssignableFrom(a)) {
            return 1;
        }
        a = getFirstNonAssignable(a, b);
        return a.getName().compareTo(getFirstNonAssignable(b, a).getName());
    }

    static Class<?> getFirstNonAssignable(Class<?> a, Class<?> b) {
        Class<?> superA = a.getSuperclass();
        while (!superA.isAssignableFrom(b)) {
            a = superA;
            superA = a.getSuperclass();
        }
        return a;
    }

    public String toString() {
        return "{MetadataKey " + this.id + ", D:" + this.datatype + "}";
    }
}
