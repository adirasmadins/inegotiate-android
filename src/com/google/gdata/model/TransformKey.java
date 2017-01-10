package com.google.gdata.model;

import com.amazonaws.services.s3.internal.Constants;
import com.google.gdata.util.common.base.Preconditions;

final class TransformKey implements Comparable<TransformKey> {
    private final MetadataContext context;
    private final MetadataKey<?> key;
    private final ElementKey<?, ?> parent;

    static TransformKey forParent(ElementKey<?, ?> parent, MetadataKey<?> key) {
        return forTransform(parent, key, null);
    }

    static TransformKey forKey(MetadataKey<?> key) {
        return forTransform(null, key, null);
    }

    static TransformKey forContext(MetadataKey<?> key, MetadataContext context) {
        return forTransform(null, key, context);
    }

    static TransformKey forTransform(ElementKey<?, ?> parent, MetadataKey<?> key, MetadataContext context) {
        Preconditions.checkNotNull(key, "key");
        return new TransformKey(parent, key, context);
    }

    private TransformKey(ElementKey<?, ?> parent, MetadataKey<?> key, MetadataContext context) {
        this.parent = parent;
        this.key = key;
        this.context = context;
    }

    boolean matches(TransformKey other) {
        return (this.parent == null || this.parent.matches(other.parent)) && this.key.matches(other.key) && (this.context == null || this.context.matches(other.context));
    }

    TransformKey bind(TransformKey other) {
        if (other == null) {
            return this;
        }
        ElementKey otherParent = other.getParent();
        MetadataKey otherKey = other.getKey();
        MetadataContext otherContext = other.getContext();
        if (otherParent == this.parent && otherKey == this.key) {
            if (otherContext != null && otherContext.equals(this.context)) {
                return this;
            }
            if (otherContext == null && this.context == null) {
                return this;
            }
        }
        if (otherParent == null) {
            otherParent = this.parent;
        }
        if (otherKey == null) {
            otherKey = this.key;
        }
        if (otherContext == null) {
            otherContext = this.context;
        }
        return new TransformKey(otherParent, otherKey, otherContext);
    }

    ElementKey<?, ?> getParent() {
        return this.parent;
    }

    MetadataKey<?> getKey() {
        return this.key;
    }

    MetadataContext getContext() {
        return this.context;
    }

    public int compareTo(TransformKey other) {
        if (this == other) {
            return 0;
        }
        if (other == null) {
            return 1;
        }
        int compare = compare(this.parent, other.parent);
        if (compare != 0) {
            return compare;
        }
        compare = compare(this.key, other.key);
        if (compare != 0) {
            return compare;
        }
        if (this.context == null) {
            if (other.context != null) {
                return -1;
            }
            return compare;
        } else if (other.context == null) {
            return 1;
        } else {
            return this.context.compareTo(other.context);
        }
    }

    static int compare(MetadataKey<?> a, MetadataKey<?> b) {
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

    public int hashCode() {
        int hash = this.key.hashCode() * 17;
        if (this.parent != null) {
            hash += this.parent.hashCode();
        }
        hash *= 17;
        if (this.context != null) {
            return hash + this.context.hashCode();
        }
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransformKey)) {
            return false;
        }
        TransformKey other = (TransformKey) obj;
        if (this.parent == null) {
            if (other.parent != null) {
                return false;
            }
        } else if (!this.parent.equals(other.parent)) {
            return false;
        }
        if (!this.key.equals(other.key)) {
            return false;
        }
        if (this.context == null) {
            if (other.context != null) {
                return false;
            }
            return true;
        } else if (this.context.equals(other.context)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{TransformKey(");
        sb.append(this.parent == null ? Constants.NULL_VERSION_ID : this.parent);
        sb.append(',');
        sb.append(this.key == null ? Constants.NULL_VERSION_ID : this.key);
        sb.append(',');
        sb.append(this.context);
        sb.append(")}");
        return sb.toString();
    }
}
