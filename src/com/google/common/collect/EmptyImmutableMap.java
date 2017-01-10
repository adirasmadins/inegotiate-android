package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class EmptyImmutableMap extends ImmutableMap<Object, Object> {
    static final EmptyImmutableMap INSTANCE;
    private static final long serialVersionUID = 0;

    static {
        INSTANCE = new EmptyImmutableMap();
    }

    private EmptyImmutableMap() {
    }

    public Object get(@Nullable Object key) {
        return null;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean containsKey(@Nullable Object key) {
        return false;
    }

    public boolean containsValue(@Nullable Object value) {
        return false;
    }

    public ImmutableSet<Entry<Object, Object>> entrySet() {
        return ImmutableSet.of();
    }

    public ImmutableSet<Object> keySet() {
        return ImmutableSet.of();
    }

    public ImmutableCollection<Object> values() {
        return ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION;
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof Map) {
            return ((Map) object).isEmpty();
        }
        return false;
    }

    boolean isPartialView() {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "{}";
    }

    Object readResolve() {
        return INSTANCE;
    }
}
