package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.gdata.data.Category;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final long serialVersionUID = 0;
    private final transient LinkedEntry<K, V>[] entries;
    private transient ImmutableSet<Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private final transient int keySetHashCode;
    private final transient int mask;
    private final transient LinkedEntry<K, V>[] table;
    private transient ImmutableCollection<V> values;

    private static class EntrySet<K, V> extends ArrayImmutableSet<Entry<K, V>> {
        final transient RegularImmutableMap<K, V> map;

        EntrySet(RegularImmutableMap<K, V> map) {
            super(map.entries);
            this.map = map;
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
    }

    private static class KeySet<K, V> extends TransformedImmutableSet<Entry<K, V>, K> {
        final RegularImmutableMap<K, V> map;

        KeySet(RegularImmutableMap<K, V> map) {
            super(map.entries, map.keySetHashCode);
            this.map = map;
        }

        K transform(Entry<K, V> element) {
            return element.getKey();
        }

        public boolean contains(Object target) {
            return this.map.containsKey(target);
        }

        boolean isPartialView() {
            return true;
        }
    }

    private interface LinkedEntry<K, V> extends Entry<K, V> {
        @Nullable
        LinkedEntry<K, V> next();
    }

    @Immutable
    private static final class NonTerminalEntry<K, V> extends ImmutableEntry<K, V> implements LinkedEntry<K, V> {
        final LinkedEntry<K, V> next;

        NonTerminalEntry(K key, V value, LinkedEntry<K, V> next) {
            super(key, value);
            this.next = next;
        }

        public LinkedEntry<K, V> next() {
            return this.next;
        }
    }

    @Immutable
    private static final class TerminalEntry<K, V> extends ImmutableEntry<K, V> implements LinkedEntry<K, V> {
        TerminalEntry(K key, V value) {
            super(key, value);
        }

        @Nullable
        public LinkedEntry<K, V> next() {
            return null;
        }
    }

    private static class Values<V> extends ImmutableCollection<V> {
        final RegularImmutableMap<?, V> map;

        /* renamed from: com.google.common.collect.RegularImmutableMap.Values.1 */
        class C05921 extends AbstractIndexedListIterator<V> {
            C05921(int x0) {
                super(x0);
            }

            protected V get(int index) {
                return Values.this.map.entries[index].getValue();
            }
        }

        Values(RegularImmutableMap<?, V> map) {
            this.map = map;
        }

        public int size() {
            return this.map.entries.length;
        }

        public UnmodifiableIterator<V> iterator() {
            return new C05921(this.map.entries.length);
        }

        public boolean contains(Object target) {
            return this.map.containsValue(target);
        }

        boolean isPartialView() {
            return true;
        }
    }

    RegularImmutableMap(Entry<?, ?>... immutableEntries) {
        int size = immutableEntries.length;
        this.entries = createEntryArray(size);
        int tableSize = chooseTableSize(size);
        this.table = createEntryArray(tableSize);
        this.mask = tableSize - 1;
        int keySetHashCodeMutable = 0;
        for (int entryIndex = 0; entryIndex < size; entryIndex++) {
            Entry<K, V> entry = immutableEntries[entryIndex];
            K key = entry.getKey();
            int keyHashCode = key.hashCode();
            keySetHashCodeMutable += keyHashCode;
            int tableIndex = Hashing.smear(keyHashCode) & this.mask;
            LinkedEntry<K, V> existing = this.table[tableIndex];
            LinkedEntry<K, V> linkedEntry = newLinkedEntry(key, entry.getValue(), existing);
            this.table[tableIndex] = linkedEntry;
            this.entries[entryIndex] = linkedEntry;
            while (existing != null) {
                Preconditions.checkArgument(!key.equals(existing.getKey()), "duplicate key: %s", key);
                existing = existing.next();
            }
        }
        this.keySetHashCode = keySetHashCodeMutable;
    }

    private static int chooseTableSize(int size) {
        boolean z;
        int tableSize = Integer.highestOneBit(size) << 1;
        if (tableSize > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "table too large: %s", Integer.valueOf(size));
        return tableSize;
    }

    private LinkedEntry<K, V>[] createEntryArray(int size) {
        return new LinkedEntry[size];
    }

    private static <K, V> LinkedEntry<K, V> newLinkedEntry(K key, V value, @Nullable LinkedEntry<K, V> next) {
        return next == null ? new TerminalEntry(key, value) : new NonTerminalEntry(key, value, next);
    }

    public V get(@Nullable Object key) {
        if (key == null) {
            return null;
        }
        for (LinkedEntry<K, V> entry = this.table[Hashing.smear(key.hashCode()) & this.mask]; entry != null; entry = entry.next()) {
            if (key.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public int size() {
        return this.entries.length;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsValue(@Nullable Object value) {
        if (value == null) {
            return false;
        }
        for (Entry<K, V> entry : this.entries) {
            if (entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    boolean isPartialView() {
        return false;
    }

    public ImmutableSet<Entry<K, V>> entrySet() {
        ImmutableSet<Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = new EntrySet(this);
        this.entrySet = immutableSet;
        return immutableSet;
    }

    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = new KeySet(this);
        this.keySet = immutableSet;
        return immutableSet;
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

    public String toString() {
        StringBuilder result = Collections2.newStringBuilderForCollection(size()).append(Category.SCHEME_PREFIX);
        Collections2.STANDARD_JOINER.appendTo(result, this.entries);
        return result.append(Category.SCHEME_SUFFIX).toString();
    }
}
