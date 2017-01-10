package com.google.gdata.model;

import com.google.gdata.util.common.base.Preconditions;

public final class ElementKey<D, E extends Element> extends MetadataKey<D> {
    final Class<? extends E> elementType;

    public static ElementKey<String, Element> of(QName id) {
        return of(id, String.class, Element.class);
    }

    public static <V extends Element> ElementKey<Void, V> of(QName id, Class<? extends V> elementType) {
        return of(id, Void.class, elementType);
    }

    public static <T, V extends Element> ElementKey<T, V> of(QName id, Class<? extends T> datatype, Class<? extends V> elementType) {
        return new ElementKey(id, datatype, elementType);
    }

    private ElementKey(QName id, Class<? extends D> datatype, Class<? extends E> elementType) {
        super(id, datatype);
        Preconditions.checkNotNull(elementType, "elementType");
        if (Element.class == elementType) {
            Preconditions.checkNotNull(id, "id");
        }
        this.elementType = elementType;
    }

    public Class<? extends E> getElementType() {
        return this.elementType;
    }

    public boolean matches(MetadataKey<?> other) {
        if (other != null && (other instanceof ElementKey) && matchIdAndDatatype(other)) {
            return this.elementType.isAssignableFrom(((ElementKey) other).elementType);
        }
        return false;
    }

    public int compareTo(MetadataKey<?> other) {
        if (other == this) {
            return 0;
        }
        if (!(other instanceof ElementKey)) {
            return 1;
        }
        int compare = MetadataKey.compareQName(this.id, other.id);
        if (compare != 0) {
            return compare;
        }
        compare = MetadataKey.compareClass(this.elementType, ((ElementKey) other).elementType);
        return compare == 0 ? MetadataKey.compareClass(this.datatype, other.datatype) : compare;
    }

    public int hashCode() {
        int hashCode = this.datatype.hashCode() * 17;
        if (this.id != null) {
            hashCode += this.id.hashCode();
        }
        return this.elementType.hashCode() + (hashCode * 17);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ElementKey.class) {
            return false;
        }
        ElementKey<?, ?> o = (ElementKey) obj;
        if (this.id == null) {
            if (o.id != null) {
                return false;
            }
        } else if (!this.id.equals(o.id)) {
            return false;
        }
        if (!(this.elementType == o.elementType && this.datatype == o.datatype)) {
            z = false;
        }
        return z;
    }

    public String toString() {
        return "{ElementKey " + this.id + ", D:" + this.datatype + ", E:" + this.elementType + "}";
    }
}
