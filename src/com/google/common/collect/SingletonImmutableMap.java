package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.gdata.data.Category;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableMap<K, V> extends ImmutableMap<K, V> {
    private transient Entry<K, V> entry;
    private transient ImmutableSet<Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    final transient K singleKey;
    final transient V singleValue;
    private transient ImmutableCollection<V> values;

    private static class Values<V> extends ImmutableCollection<V> {
        final V singleValue;

        Values(V singleValue) {
            this.singleValue = singleValue;
        }

        public boolean contains(Object object) {
            return this.singleValue.equals(object);
        }

        public boolean isEmpty() {
            return false;
        }

        public int size() {
            return 1;
        }

        public UnmodifiableIterator<V> iterator() {
            return Iterators.singletonIterator(this.singleValue);
        }

        boolean isPartialView() {
            return true;
        }
    }

    SingletonImmutableMap(K singleKey, V singleValue) {
        this.singleKey = singleKey;
        this.singleValue = singleValue;
    }

    SingletonImmutableMap(Entry<K, V> entry) {
        this.entry = entry;
        this.singleKey = entry.getKey();
        this.singleValue = entry.getValue();
    }

    private Entry<K, V> entry() {
        Entry<K, V> entry = this.entry;
        if (entry != null) {
            return entry;
        }
        entry = Maps.immutableEntry(this.singleKey, this.singleValue);
        this.entry = entry;
        return entry;
    }

    public V get(@Nullable Object key) {
        return this.singleKey.equals(key) ? this.singleValue : null;
    }

    public int size() {
        return 1;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(@Nullable Object key) {
        return this.singleKey.equals(key);
    }

    public boolean containsValue(@Nullable Object value) {
        return this.singleValue.equals(value);
    }

    boolean isPartialView() {
        return false;
    }

    public ImmutableSet<Entry<K, V>> entrySet() {
        ImmutableSet<Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = ImmutableSet.of(entry());
        this.entrySet = immutableSet;
        return immutableSet;
    }

    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = ImmutableSet.of(this.singleKey);
        this.keySet = immutableSet;
        return immutableSet;
    }

    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        immutableCollection = new Values(this.singleValue);
        this.values = immutableCollection;
        return immutableCollection;
    }

    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        Map<?, ?> that = (Map) object;
        if (that.size() != 1) {
            return false;
        }
        Entry<?, ?> entry = (Entry) that.entrySet().iterator().next();
        if (this.singleKey.equals(entry.getKey()) && this.singleValue.equals(entry.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.singleKey.hashCode() ^ this.singleValue.hashCode();
    }

    public String toString() {
        return Category.SCHEME_PREFIX + this.singleKey.toString() + '=' + this.singleValue.toString() + Category.SCHEME_SUFFIX;
    }
}
