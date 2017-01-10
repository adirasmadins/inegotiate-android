package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public abstract class ImmutableMultimap<K, V> implements Multimap<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient ImmutableCollection<Entry<K, V>> entries;
    private transient ImmutableMultiset<K> keys;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;
    private transient ImmutableCollection<V> values;

    public static class Builder<K, V> {
        Multimap<K, V> builderMultimap;
        Comparator<? super V> valueComparator;

        public Builder() {
            this.builderMultimap = new BuilderMultimap();
        }

        public Builder<K, V> put(K key, V value) {
            this.builderMultimap.put(Preconditions.checkNotNull(key), Preconditions.checkNotNull(value));
            return this;
        }

        public Builder<K, V> put(Entry<? extends K, ? extends V> entry) {
            this.builderMultimap.put(Preconditions.checkNotNull(entry.getKey()), Preconditions.checkNotNull(entry.getValue()));
            return this;
        }

        public Builder<K, V> putAll(K key, Iterable<? extends V> values) {
            Collection<V> valueList = this.builderMultimap.get(Preconditions.checkNotNull(key));
            for (V value : values) {
                valueList.add(Preconditions.checkNotNull(value));
            }
            return this;
        }

        public Builder<K, V> putAll(K key, V... values) {
            return putAll((Object) key, Arrays.asList(values));
        }

        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Entry<? extends K, ? extends Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll(entry.getKey(), (Iterable) entry.getValue());
            }
            return this;
        }

        @Beta
        public Builder<K, V> orderKeysBy(Comparator<? super K> keyComparator) {
            this.builderMultimap = new SortedKeyBuilderMultimap((Comparator) Preconditions.checkNotNull(keyComparator), this.builderMultimap);
            return this;
        }

        @Beta
        public Builder<K, V> orderValuesBy(Comparator<? super V> valueComparator) {
            this.valueComparator = (Comparator) Preconditions.checkNotNull(valueComparator);
            return this;
        }

        public ImmutableMultimap<K, V> build() {
            if (this.valueComparator != null) {
                for (Collection<V> list : this.builderMultimap.asMap().values()) {
                    Collections.sort((List) list, this.valueComparator);
                }
            }
            return ImmutableMultimap.copyOf(this.builderMultimap);
        }
    }

    private static class BuilderMultimap<K, V> extends AbstractMultimap<K, V> {
        private static final long serialVersionUID = 0;

        BuilderMultimap() {
            super(new LinkedHashMap());
        }

        Collection<V> createCollection() {
            return Lists.newArrayList();
        }
    }

    private static class EntryCollection<K, V> extends ImmutableCollection<Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        /* renamed from: com.google.common.collect.ImmutableMultimap.EntryCollection.1 */
        class C04501 extends UnmodifiableIterator<Entry<K, V>> {
            K key;
            final /* synthetic */ Iterator val$mapIterator;
            Iterator<V> valueIterator;

            C04501(Iterator it) {
                this.val$mapIterator = it;
            }

            public boolean hasNext() {
                return (this.key != null && this.valueIterator.hasNext()) || this.val$mapIterator.hasNext();
            }

            public Entry<K, V> next() {
                if (this.key == null || !this.valueIterator.hasNext()) {
                    Entry<K, ? extends ImmutableCollection<V>> entry = (Entry) this.val$mapIterator.next();
                    this.key = entry.getKey();
                    this.valueIterator = ((ImmutableCollection) entry.getValue()).iterator();
                }
                return Maps.immutableEntry(this.key, this.valueIterator.next());
            }
        }

        EntryCollection(ImmutableMultimap<K, V> multimap) {
            this.multimap = multimap;
        }

        public UnmodifiableIterator<Entry<K, V>> iterator() {
            return new C04501(this.multimap.map.entrySet().iterator());
        }

        boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        public int size() {
            return this.multimap.size();
        }

        public boolean contains(Object object) {
            if (!(object instanceof Entry)) {
                return false;
            }
            Entry<?, ?> entry = (Entry) object;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }
    }

    @GwtIncompatible("java serialization is not supported")
    static class FieldSettersHolder {
        static final FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER;
        static final FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER;

        FieldSettersHolder() {
        }

        static {
            MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
            SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");
        }
    }

    private static class SortedKeyBuilderMultimap<K, V> extends AbstractMultimap<K, V> {
        private static final long serialVersionUID = 0;

        SortedKeyBuilderMultimap(Comparator<? super K> keyComparator, Multimap<K, V> multimap) {
            super(new TreeMap(keyComparator));
            putAll(multimap);
        }

        Collection<V> createCollection() {
            return Lists.newArrayList();
        }
    }

    private static class Values<V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<?, V> multimap;

        /* renamed from: com.google.common.collect.ImmutableMultimap.Values.1 */
        class C04511 extends UnmodifiableIterator<V> {
            final /* synthetic */ Iterator val$entryIterator;

            C04511(Iterator it) {
                this.val$entryIterator = it;
            }

            public boolean hasNext() {
                return this.val$entryIterator.hasNext();
            }

            public V next() {
                return ((Entry) this.val$entryIterator.next()).getValue();
            }
        }

        Values(ImmutableMultimap<?, V> multimap) {
            this.multimap = multimap;
        }

        public UnmodifiableIterator<V> iterator() {
            return new C04511(this.multimap.entries().iterator());
        }

        public int size() {
            return this.multimap.size();
        }

        boolean isPartialView() {
            return true;
        }
    }

    public abstract ImmutableCollection<V> get(K k);

    @Beta
    public abstract ImmutableMultimap<V, K> inverse();

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k1, V v1) {
        return ImmutableListMultimap.of(k1, v1);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k1, V v1, K k2, V v2) {
        return ImmutableListMultimap.of(k1, v1, k2, v2);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.of(k1, v1, k2, v2, k3, v3);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.of(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> kvMultimap = (ImmutableMultimap) multimap;
            if (!kvMultimap.isPartialView()) {
                return kvMultimap;
            }
        }
        return ImmutableListMultimap.copyOf(multimap);
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> map, int size) {
        this.map = map;
        this.size = size;
    }

    public ImmutableCollection<V> removeAll(Object key) {
        throw new UnsupportedOperationException();
    }

    public ImmutableCollection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    boolean isPartialView() {
        return this.map.isPartialView();
    }

    public boolean containsEntry(@Nullable Object key, @Nullable Object value) {
        Collection<V> values = (Collection) this.map.get(key);
        return values != null && values.contains(value);
    }

    public boolean containsKey(@Nullable Object key) {
        return this.map.containsKey(key);
    }

    public boolean containsValue(@Nullable Object value) {
        Iterator i$ = this.map.values().iterator();
        while (i$.hasNext()) {
            if (((ImmutableCollection) i$.next()).contains(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Multimap)) {
            return false;
        }
        return this.map.equals(((Multimap) object).asMap());
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return this.map.toString();
    }

    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    public ImmutableCollection<Entry<K, V>> entries() {
        ImmutableCollection<Entry<K, V>> immutableCollection = this.entries;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        immutableCollection = new EntryCollection(this);
        this.entries = immutableCollection;
        return immutableCollection;
    }

    public ImmutableMultiset<K> keys() {
        ImmutableMultiset<K> immutableMultiset = this.keys;
        if (immutableMultiset != null) {
            return immutableMultiset;
        }
        immutableMultiset = createKeys();
        this.keys = immutableMultiset;
        return immutableMultiset;
    }

    private ImmutableMultiset<K> createKeys() {
        com.google.common.collect.ImmutableMultiset.Builder<K> builder = ImmutableMultiset.builder();
        Iterator i$ = this.map.entrySet().iterator();
        while (i$.hasNext()) {
            Entry<K, ? extends ImmutableCollection<V>> entry = (Entry) i$.next();
            builder.addCopies(entry.getKey(), ((ImmutableCollection) entry.getValue()).size());
        }
        return builder.build();
    }

    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        immutableCollection = new Values(this);
        this.values = immutableCollection;
        return immutableCollection;
    }
}
