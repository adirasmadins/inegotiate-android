package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.SortedLists.KeyAbsentBehavior;
import com.google.common.collect.SortedLists.KeyPresentBehavior;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements SortedMap<K, V> {
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP;
    private static final Comparator<Comparable> NATURAL_ORDER;
    private static final long serialVersionUID = 0;
    private final transient Comparator<? super K> comparator;
    final transient ImmutableList<Entry<K, V>> entries;
    private transient ImmutableSet<Entry<K, V>> entrySet;
    private transient ImmutableSortedSet<K> keySet;
    private transient ImmutableCollection<V> values;

    /* renamed from: com.google.common.collect.ImmutableSortedMap.1 */
    static class C04541 implements Comparator<Entry<K, V>> {
        final /* synthetic */ Comparator val$comparator;

        C04541(Comparator comparator) {
            this.val$comparator = comparator;
        }

        public int compare(Entry<K, V> entry1, Entry<K, V> entry2) {
            return this.val$comparator.compare(entry1.getKey(), entry2.getKey());
        }
    }

    /* renamed from: com.google.common.collect.ImmutableSortedMap.2 */
    class C04552 extends TransformedImmutableList<Entry<K, V>, K> {
        C04552(ImmutableList x0) {
            super(x0);
        }

        K transform(Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* renamed from: com.google.common.collect.ImmutableSortedMap.3 */
    class C04563 extends UnmodifiableIterator<V> {
        final /* synthetic */ UnmodifiableIterator val$entryIterator;

        C04563(UnmodifiableIterator unmodifiableIterator) {
            this.val$entryIterator = unmodifiableIterator;
        }

        public boolean hasNext() {
            return this.val$entryIterator.hasNext();
        }

        public V next() {
            return ((Entry) this.val$entryIterator.next()).getValue();
        }
    }

    /* renamed from: com.google.common.collect.ImmutableSortedMap.4 */
    class C04574 extends TransformedImmutableList<Entry<K, V>, K> {
        C04574(ImmutableList x0) {
            super(x0);
        }

        K transform(Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    public static class Builder<K, V> extends com.google.common.collect.ImmutableMap.Builder<K, V> {
        private final Comparator<? super K> comparator;

        public Builder(Comparator<? super K> comparator) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        public Builder<K, V> put(K key, V value) {
            this.entries.add(ImmutableMap.entryOf(key, value));
            return this;
        }

        public Builder<K, V> put(Entry<? extends K, ? extends V> entry) {
            super.put(entry);
            return this;
        }

        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public ImmutableSortedMap<K, V> build() {
            ImmutableSortedMap.sortEntries(this.entries, this.comparator);
            ImmutableSortedMap.validateEntries(this.entries, this.comparator);
            return new ImmutableSortedMap(ImmutableList.copyOf(this.entries), this.comparator);
        }
    }

    private static class EntrySet<K, V> extends ImmutableSet<Entry<K, V>> {
        final transient ImmutableSortedMap<K, V> map;

        EntrySet(ImmutableSortedMap<K, V> map) {
            this.map = map;
        }

        boolean isPartialView() {
            return this.map.isPartialView();
        }

        public int size() {
            return this.map.size();
        }

        public UnmodifiableIterator<Entry<K, V>> iterator() {
            return this.map.entries.iterator();
        }

        public boolean contains(Object target) {
            if (!(target instanceof Entry)) {
                return false;
            }
            Entry<?, ?> entry = (Entry) target;
            V mappedValue = this.map.get(entry.getKey());
            if (mappedValue == null || !mappedValue.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        Object writeReplace() {
            return new EntrySetSerializedForm(this.map);
        }
    }

    private static class EntrySetSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableSortedMap<K, V> map;

        EntrySetSerializedForm(ImmutableSortedMap<K, V> map) {
            this.map = map;
        }

        Object readResolve() {
            return this.map.entrySet();
        }
    }

    private static class SerializedForm extends SerializedForm {
        private static final long serialVersionUID = 0;
        private final Comparator<Object> comparator;

        SerializedForm(ImmutableSortedMap<?, ?> sortedMap) {
            super(sortedMap);
            this.comparator = sortedMap.comparator();
        }

        Object readResolve() {
            return createMap(new Builder(this.comparator));
        }
    }

    private static class Values<V> extends ImmutableCollection<V> {
        private final ImmutableSortedMap<?, V> map;

        Values(ImmutableSortedMap<?, V> map) {
            this.map = map;
        }

        public int size() {
            return this.map.size();
        }

        public UnmodifiableIterator<V> iterator() {
            return this.map.valueIterator();
        }

        public boolean contains(Object target) {
            return this.map.containsValue(target);
        }

        boolean isPartialView() {
            return true;
        }

        Object writeReplace() {
            return new ValuesSerializedForm(this.map);
        }
    }

    private static class ValuesSerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableSortedMap<?, V> map;

        ValuesSerializedForm(ImmutableSortedMap<?, V> map) {
            this.map = map;
        }

        Object readResolve() {
            return this.map.values();
        }
    }

    static {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableList.of(), NATURAL_ORDER);
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return NATURAL_EMPTY_MAP;
    }

    private static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        if (NATURAL_ORDER.equals(comparator)) {
            return NATURAL_EMPTY_MAP;
        }
        return new ImmutableSortedMap(ImmutableList.of(), comparator);
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k1, V v1) {
        return new ImmutableSortedMap(ImmutableList.of(ImmutableMap.entryOf(k1, v1)), Ordering.natural());
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2) {
        return new Builder(Ordering.natural()).put((Object) k1, (Object) v1).put((Object) k2, (Object) v2).build();
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return new Builder(Ordering.natural()).put((Object) k1, (Object) v1).put((Object) k2, (Object) v2).put((Object) k3, (Object) v3).build();
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new Builder(Ordering.natural()).put((Object) k1, (Object) v1).put((Object) k2, (Object) v2).put((Object) k3, (Object) v3).put((Object) k4, (Object) v4).build();
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new Builder(Ordering.natural()).put((Object) k1, (Object) v1).put((Object) k2, (Object) v2).put((Object) k3, (Object) v3).put((Object) k4, (Object) v4).put((Object) k5, (Object) v5).build();
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return copyOfInternal(map, Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return copyOfInternal(map, (Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> map) {
        Comparator<? super K> comparator = map.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        return copyOfInternal(map, comparator);
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean sameComparator = false;
        if (map instanceof SortedMap) {
            Comparator<?> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                sameComparator = comparator.equals(comparator2);
            } else if (comparator == NATURAL_ORDER) {
                sameComparator = true;
            } else {
                sameComparator = false;
            }
        }
        if (sameComparator && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> kvMap = (ImmutableSortedMap) map;
            if (!kvMap.isPartialView()) {
                return kvMap;
            }
        }
        Entry[] entries = (Entry[]) map.entrySet().toArray(new Entry[0]);
        for (int i = 0; i < entries.length; i++) {
            Entry<K, V> entry = entries[i];
            entries[i] = ImmutableMap.entryOf(entry.getKey(), entry.getValue());
        }
        Collection list = Arrays.asList(entries);
        if (!sameComparator) {
            sortEntries(list, comparator);
            validateEntries(list, comparator);
        }
        return new ImmutableSortedMap(ImmutableList.copyOf(list), comparator);
    }

    private static <K, V> void sortEntries(List<Entry<K, V>> entries, Comparator<? super K> comparator) {
        Collections.sort(entries, new C04541(comparator));
    }

    private static <K, V> void validateEntries(List<Entry<K, V>> entries, Comparator<? super K> comparator) {
        for (int i = 1; i < entries.size(); i++) {
            if (comparator.compare(((Entry) entries.get(i - 1)).getKey(), ((Entry) entries.get(i)).getKey()) == 0) {
                throw new IllegalArgumentException("Duplicate keys in mappings " + entries.get(i - 1) + " and " + entries.get(i));
            }
        }
    }

    public static <K extends Comparable<K>, V> Builder<K, V> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> comparator) {
        return new Builder(comparator);
    }

    public static <K extends Comparable<K>, V> Builder<K, V> reverseOrder() {
        return new Builder(Ordering.natural().reverse());
    }

    ImmutableSortedMap(ImmutableList<Entry<K, V>> entries, Comparator<? super K> comparator) {
        this.entries = entries;
        this.comparator = comparator;
    }

    public int size() {
        return this.entries.size();
    }

    Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    public V get(@Nullable Object key) {
        if (key == null) {
            return null;
        }
        try {
            int i = index(key, KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
            if (i >= 0) {
                return ((Entry) this.entries.get(i)).getValue();
            }
            return null;
        } catch (ClassCastException e) {
            return null;
        }
    }

    public boolean containsValue(@Nullable Object value) {
        if (value == null) {
            return false;
        }
        return Iterators.contains(valueIterator(), value);
    }

    boolean isPartialView() {
        return this.entries.isPartialView();
    }

    public ImmutableSet<Entry<K, V>> entrySet() {
        ImmutableSet<Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = createEntrySet();
        this.entrySet = immutableSet;
        return immutableSet;
    }

    private ImmutableSet<Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this);
    }

    public ImmutableSortedSet<K> keySet() {
        ImmutableSortedSet<K> immutableSortedSet = this.keySet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        immutableSortedSet = createKeySet();
        this.keySet = immutableSortedSet;
        return immutableSortedSet;
    }

    private ImmutableSortedSet<K> createKeySet() {
        if (isEmpty()) {
            return ImmutableSortedSet.emptySet(this.comparator);
        }
        return new RegularImmutableSortedSet(new C04552(this.entries), this.comparator);
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

    UnmodifiableIterator<V> valueIterator() {
        return new C04563(this.entries.iterator());
    }

    public Comparator<? super K> comparator() {
        return this.comparator;
    }

    public K firstKey() {
        if (!isEmpty()) {
            return ((Entry) this.entries.get(0)).getKey();
        }
        throw new NoSuchElementException();
    }

    public K lastKey() {
        if (!isEmpty()) {
            return ((Entry) this.entries.get(size() - 1)).getKey();
        }
        throw new NoSuchElementException();
    }

    public ImmutableSortedMap<K, V> headMap(K toKey) {
        return headMap(toKey, false);
    }

    ImmutableSortedMap<K, V> headMap(K toKey, boolean inclusive) {
        int index;
        if (inclusive) {
            index = index(toKey, KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_LOWER) + 1;
        } else {
            index = index(toKey, KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_HIGHER);
        }
        return createSubmap(0, index);
    }

    public ImmutableSortedMap<K, V> subMap(K fromKey, K toKey) {
        return subMap(fromKey, true, toKey, false);
    }

    ImmutableSortedMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        Preconditions.checkNotNull(fromKey);
        Preconditions.checkNotNull(toKey);
        Preconditions.checkArgument(this.comparator.compare(fromKey, toKey) <= 0);
        return tailMap(fromKey, fromInclusive).headMap(toKey, toInclusive);
    }

    public ImmutableSortedMap<K, V> tailMap(K fromKey) {
        return tailMap(fromKey, true);
    }

    ImmutableSortedMap<K, V> tailMap(K fromKey, boolean inclusive) {
        int index;
        if (inclusive) {
            index = index(fromKey, KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_HIGHER);
        } else {
            index = index(fromKey, KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_LOWER) + 1;
        }
        return createSubmap(index, size());
    }

    private ImmutableList<K> keyList() {
        return new C04574(this.entries);
    }

    private int index(Object key, KeyPresentBehavior presentBehavior, KeyAbsentBehavior absentBehavior) {
        return SortedLists.binarySearch(keyList(), Preconditions.checkNotNull(key), unsafeComparator(), presentBehavior, absentBehavior);
    }

    private ImmutableSortedMap<K, V> createSubmap(int newFromIndex, int newToIndex) {
        if (newFromIndex < newToIndex) {
            return new ImmutableSortedMap(this.entries.subList(newFromIndex, newToIndex), this.comparator);
        }
        return emptyMap(this.comparator);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
