package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Equivalences;
import com.google.common.base.Function;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.primitives.Ints;
import com.google.gdata.data.Category;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Maps {
    static final MapJoiner STANDARD_JOINER;

    static abstract class EntrySet<K, V> extends AbstractSet<Entry<K, V>> {
        abstract Map<K, V> map();

        EntrySet() {
        }

        public int size() {
            return map().size();
        }

        public void clear() {
            map().clear();
        }

        public boolean contains(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry<?, ?> entry = (Entry) o;
            Object key = entry.getKey();
            V value = map().get(key);
            if (!Objects.equal(value, entry.getValue())) {
                return false;
            }
            if (value != null || map().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean remove(Object o) {
            if (!contains(o)) {
                return false;
            }
            return map().keySet().remove(((Entry) o).getKey());
        }

        public boolean removeAll(Collection<?> c) {
            boolean removeAll;
            try {
                removeAll = super.removeAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                removeAll = true;
                for (Object o : c) {
                    removeAll |= remove(o);
                }
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> c) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                Set<Object> keys = Sets.newHashSetWithExpectedSize(c.size());
                for (Entry<?, ?> o : c) {
                    if (contains(o)) {
                        keys.add(o.getKey());
                    }
                }
                return map().keySet().retainAll(keys);
            }
        }
    }

    static abstract class KeySet<K, V> extends AbstractSet<K> {

        /* renamed from: com.google.common.collect.Maps.KeySet.1 */
        class C05451 implements Function<Entry<K, V>, K> {
            C05451() {
            }

            public K apply(Entry<K, V> entry) {
                return entry.getKey();
            }
        }

        abstract Map<K, V> map();

        KeySet() {
        }

        public Iterator<K> iterator() {
            return Iterators.transform(map().entrySet().iterator(), new C05451());
        }

        public int size() {
            return map().size();
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean contains(Object o) {
            return map().containsKey(o);
        }

        public boolean remove(Object o) {
            if (!contains(o)) {
                return false;
            }
            map().remove(o);
            return true;
        }

        public boolean removeAll(Collection<?> c) {
            return super.removeAll((Collection) Preconditions.checkNotNull(c));
        }

        public void clear() {
            map().clear();
        }
    }

    static abstract class Values<K, V> extends AbstractCollection<V> {

        /* renamed from: com.google.common.collect.Maps.Values.1 */
        class C05501 implements Function<Entry<K, V>, V> {
            C05501() {
            }

            public V apply(Entry<K, V> entry) {
                return entry.getValue();
            }
        }

        abstract Map<K, V> map();

        Values() {
        }

        public Iterator<V> iterator() {
            return Iterators.transform(map().entrySet().iterator(), new C05501());
        }

        public boolean remove(Object o) {
            try {
                return super.remove(o);
            } catch (UnsupportedOperationException e) {
                for (Entry<K, V> entry : map().entrySet()) {
                    if (Objects.equal(o, entry.getValue())) {
                        map().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> c) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                Set<K> toRemove = Sets.newHashSet();
                for (Entry<K, V> entry : map().entrySet()) {
                    if (c.contains(entry.getValue())) {
                        toRemove.add(entry.getKey());
                    }
                }
                return map().keySet().removeAll(toRemove);
            }
        }

        public boolean retainAll(Collection<?> c) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                Set<K> toRetain = Sets.newHashSet();
                for (Entry<K, V> entry : map().entrySet()) {
                    if (c.contains(entry.getValue())) {
                        toRetain.add(entry.getKey());
                    }
                }
                return map().keySet().retainAll(toRetain);
            }
        }

        public int size() {
            return map().size();
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean contains(@Nullable Object o) {
            return map().containsValue(o);
        }

        public void clear() {
            map().clear();
        }
    }

    /* renamed from: com.google.common.collect.Maps.1 */
    static class C05321 extends AbstractMapEntry<K, V> {
        final /* synthetic */ Entry val$entry;

        C05321(Entry entry) {
            this.val$entry = entry;
        }

        public K getKey() {
            return this.val$entry.getKey();
        }

        public V getValue() {
            return this.val$entry.getValue();
        }
    }

    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(@Nullable K k, @Nullable V1 v1);
    }

    /* renamed from: com.google.common.collect.Maps.2 */
    static class C05332 implements EntryTransformer<K, V1, V2> {
        final /* synthetic */ Function val$function;

        C05332(Function function) {
            this.val$function = function;
        }

        public V2 transformEntry(K k, V1 value) {
            return this.val$function.apply(value);
        }
    }

    /* renamed from: com.google.common.collect.Maps.3 */
    static class C05343 implements EntryTransformer<K, V1, V2> {
        final /* synthetic */ Function val$function;

        C05343(Function function) {
            this.val$function = function;
        }

        public V2 transformEntry(K k, V1 value) {
            return this.val$function.apply(value);
        }
    }

    /* renamed from: com.google.common.collect.Maps.4 */
    static class C05354 implements Predicate<Entry<K, V>> {
        final /* synthetic */ Predicate val$keyPredicate;

        C05354(Predicate predicate) {
            this.val$keyPredicate = predicate;
        }

        public boolean apply(Entry<K, V> input) {
            return this.val$keyPredicate.apply(input.getKey());
        }
    }

    /* renamed from: com.google.common.collect.Maps.5 */
    static class C05365 implements Predicate<Entry<K, V>> {
        final /* synthetic */ Predicate val$keyPredicate;

        C05365(Predicate predicate) {
            this.val$keyPredicate = predicate;
        }

        public boolean apply(Entry<K, V> input) {
            return this.val$keyPredicate.apply(input.getKey());
        }
    }

    /* renamed from: com.google.common.collect.Maps.6 */
    static class C05376 implements Predicate<Entry<K, V>> {
        final /* synthetic */ Predicate val$valuePredicate;

        C05376(Predicate predicate) {
            this.val$valuePredicate = predicate;
        }

        public boolean apply(Entry<K, V> input) {
            return this.val$valuePredicate.apply(input.getValue());
        }
    }

    /* renamed from: com.google.common.collect.Maps.7 */
    static class C05387 implements Predicate<Entry<K, V>> {
        final /* synthetic */ Predicate val$valuePredicate;

        C05387(Predicate predicate) {
            this.val$valuePredicate = predicate;
        }

        public boolean apply(Entry<K, V> input) {
            return this.val$valuePredicate.apply(input.getValue());
        }
    }

    private static abstract class AbstractFilteredMap<K, V> extends AbstractMap<K, V> {
        final Predicate<? super Entry<K, V>> predicate;
        final Map<K, V> unfiltered;
        Collection<V> values;

        class Values extends AbstractCollection<V> {

            /* renamed from: com.google.common.collect.Maps.AbstractFilteredMap.Values.1 */
            class C05391 extends UnmodifiableIterator<V> {
                final /* synthetic */ Iterator val$entryIterator;

                C05391(Iterator it) {
                    this.val$entryIterator = it;
                }

                public boolean hasNext() {
                    return this.val$entryIterator.hasNext();
                }

                public V next() {
                    return ((Entry) this.val$entryIterator.next()).getValue();
                }
            }

            Values() {
            }

            public Iterator<V> iterator() {
                return new C05391(AbstractFilteredMap.this.entrySet().iterator());
            }

            public int size() {
                return AbstractFilteredMap.this.entrySet().size();
            }

            public void clear() {
                AbstractFilteredMap.this.entrySet().clear();
            }

            public boolean isEmpty() {
                return AbstractFilteredMap.this.entrySet().isEmpty();
            }

            public boolean remove(Object o) {
                Iterator<Entry<K, V>> iterator = AbstractFilteredMap.this.unfiltered.entrySet().iterator();
                while (iterator.hasNext()) {
                    Entry<K, V> entry = (Entry) iterator.next();
                    if (Objects.equal(o, entry.getValue()) && AbstractFilteredMap.this.predicate.apply(entry)) {
                        iterator.remove();
                        return true;
                    }
                }
                return false;
            }

            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                boolean changed = false;
                Iterator<Entry<K, V>> iterator = AbstractFilteredMap.this.unfiltered.entrySet().iterator();
                while (iterator.hasNext()) {
                    Entry<K, V> entry = (Entry) iterator.next();
                    if (collection.contains(entry.getValue()) && AbstractFilteredMap.this.predicate.apply(entry)) {
                        iterator.remove();
                        changed = true;
                    }
                }
                return changed;
            }

            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                boolean changed = false;
                Iterator<Entry<K, V>> iterator = AbstractFilteredMap.this.unfiltered.entrySet().iterator();
                while (iterator.hasNext()) {
                    Entry<K, V> entry = (Entry) iterator.next();
                    if (!collection.contains(entry.getValue()) && AbstractFilteredMap.this.predicate.apply(entry)) {
                        iterator.remove();
                        changed = true;
                    }
                }
                return changed;
            }

            public Object[] toArray() {
                return Lists.newArrayList(iterator()).toArray();
            }

            public <T> T[] toArray(T[] array) {
                return Lists.newArrayList(iterator()).toArray(array);
            }
        }

        AbstractFilteredMap(Map<K, V> unfiltered, Predicate<? super Entry<K, V>> predicate) {
            this.unfiltered = unfiltered;
            this.predicate = predicate;
        }

        boolean apply(Object key, V value) {
            return this.predicate.apply(Maps.immutableEntry(key, value));
        }

        public V put(K key, V value) {
            Preconditions.checkArgument(apply(key, value));
            return this.unfiltered.put(key, value);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
                Preconditions.checkArgument(apply(entry.getKey(), entry.getValue()));
            }
            this.unfiltered.putAll(map);
        }

        public boolean containsKey(Object key) {
            return this.unfiltered.containsKey(key) && apply(key, this.unfiltered.get(key));
        }

        public V get(Object key) {
            V value = this.unfiltered.get(key);
            return (value == null || !apply(key, value)) ? null : value;
        }

        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        public V remove(Object key) {
            return containsKey(key) ? this.unfiltered.remove(key) : null;
        }

        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            collection = new Values();
            this.values = collection;
            return collection;
        }
    }

    static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {
        Set<Entry<K, V>> entrySet;
        final Set<Entry<K, V>> filteredEntrySet;
        Set<K> keySet;

        private class EntrySet extends ForwardingSet<Entry<K, V>> {

            /* renamed from: com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1 */
            class C05411 extends UnmodifiableIterator<Entry<K, V>> {
                final /* synthetic */ Iterator val$iterator;

                /* renamed from: com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1.1 */
                class C05401 extends ForwardingMapEntry<K, V> {
                    final /* synthetic */ Entry val$entry;

                    C05401(Entry entry) {
                        this.val$entry = entry;
                    }

                    protected Entry<K, V> delegate() {
                        return this.val$entry;
                    }

                    public V setValue(V value) {
                        Preconditions.checkArgument(FilteredEntryMap.this.apply(this.val$entry.getKey(), value));
                        return super.setValue(value);
                    }
                }

                C05411(Iterator it) {
                    this.val$iterator = it;
                }

                public boolean hasNext() {
                    return this.val$iterator.hasNext();
                }

                public Entry<K, V> next() {
                    return new C05401((Entry) this.val$iterator.next());
                }
            }

            private EntrySet() {
            }

            protected Set<Entry<K, V>> delegate() {
                return FilteredEntryMap.this.filteredEntrySet;
            }

            public Iterator<Entry<K, V>> iterator() {
                return new C05411(FilteredEntryMap.this.filteredEntrySet.iterator());
            }
        }

        private class KeySet extends AbstractSet<K> {

            /* renamed from: com.google.common.collect.Maps.FilteredEntryMap.KeySet.1 */
            class C05421 extends UnmodifiableIterator<K> {
                final /* synthetic */ Iterator val$iterator;

                C05421(Iterator it) {
                    this.val$iterator = it;
                }

                public boolean hasNext() {
                    return this.val$iterator.hasNext();
                }

                public K next() {
                    return ((Entry) this.val$iterator.next()).getKey();
                }
            }

            private KeySet() {
            }

            public Iterator<K> iterator() {
                return new C05421(FilteredEntryMap.this.filteredEntrySet.iterator());
            }

            public int size() {
                return FilteredEntryMap.this.filteredEntrySet.size();
            }

            public void clear() {
                FilteredEntryMap.this.filteredEntrySet.clear();
            }

            public boolean contains(Object o) {
                return FilteredEntryMap.this.containsKey(o);
            }

            public boolean remove(Object o) {
                if (!FilteredEntryMap.this.containsKey(o)) {
                    return false;
                }
                FilteredEntryMap.this.unfiltered.remove(o);
                return true;
            }

            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                boolean changed = false;
                for (Object obj : collection) {
                    changed |= remove(obj);
                }
                return changed;
            }

            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                boolean changed = false;
                Iterator<Entry<K, V>> iterator = FilteredEntryMap.this.unfiltered.entrySet().iterator();
                while (iterator.hasNext()) {
                    Entry<K, V> entry = (Entry) iterator.next();
                    if (!collection.contains(entry.getKey()) && FilteredEntryMap.this.predicate.apply(entry)) {
                        iterator.remove();
                        changed = true;
                    }
                }
                return changed;
            }

            public Object[] toArray() {
                return Lists.newArrayList(iterator()).toArray();
            }

            public <T> T[] toArray(T[] array) {
                return Lists.newArrayList(iterator()).toArray(array);
            }
        }

        FilteredEntryMap(Map<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
            this.filteredEntrySet = Sets.filter(unfiltered.entrySet(), this.predicate);
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            set = new EntrySet();
            this.entrySet = set;
            return set;
        }

        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            set = new KeySet();
            this.keySet = set;
            return set;
        }
    }

    private static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {
        FilteredEntrySortedMap(SortedMap<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
        }

        SortedMap<K, V> sortedMap() {
            return (SortedMap) this.unfiltered;
        }

        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        public K firstKey() {
            return keySet().iterator().next();
        }

        public K lastKey() {
            SortedMap<K, V> headMap = sortedMap();
            while (true) {
                K key = headMap.lastKey();
                if (apply(key, this.unfiltered.get(key))) {
                    return key;
                }
                headMap = sortedMap().headMap(key);
            }
        }

        public SortedMap<K, V> headMap(K toKey) {
            return new FilteredEntrySortedMap(sortedMap().headMap(toKey), this.predicate);
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return new FilteredEntrySortedMap(sortedMap().subMap(fromKey, toKey), this.predicate);
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            return new FilteredEntrySortedMap(sortedMap().tailMap(fromKey), this.predicate);
        }
    }

    private static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
        Set<Entry<K, V>> entrySet;
        Predicate<? super K> keyPredicate;
        Set<K> keySet;

        FilteredKeyMap(Map<K, V> unfiltered, Predicate<? super K> keyPredicate, Predicate<Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
            this.keyPredicate = keyPredicate;
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            set = Sets.filter(this.unfiltered.entrySet(), this.predicate);
            this.entrySet = set;
            return set;
        }

        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            set = Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
            this.keySet = set;
            return set;
        }

        public boolean containsKey(Object key) {
            return this.unfiltered.containsKey(key) && this.keyPredicate.apply(key);
        }
    }

    @GwtCompatible
    static abstract class ImprovedAbstractMap<K, V> extends AbstractMap<K, V> {
        private Set<Entry<K, V>> entrySet;
        private Set<K> keySet;
        private Collection<V> values;

        /* renamed from: com.google.common.collect.Maps.ImprovedAbstractMap.1 */
        class C05431 extends KeySet<K, V> {
            C05431() {
            }

            Map<K, V> map() {
                return ImprovedAbstractMap.this;
            }
        }

        /* renamed from: com.google.common.collect.Maps.ImprovedAbstractMap.2 */
        class C05442 extends Values<K, V> {
            C05442() {
            }

            Map<K, V> map() {
                return ImprovedAbstractMap.this;
            }
        }

        protected abstract Set<Entry<K, V>> createEntrySet();

        ImprovedAbstractMap() {
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> result = this.entrySet;
            if (result != null) {
                return result;
            }
            result = createEntrySet();
            this.entrySet = result;
            return result;
        }

        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            set = new C05431();
            this.keySet = set;
            return set;
        }

        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            collection = new C05442();
            this.values = collection;
            return collection;
        }

        public boolean isEmpty() {
            return entrySet().isEmpty();
        }
    }

    static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {
        final boolean areEqual;
        final Map<K, ValueDifference<V>> differences;
        final Map<K, V> onBoth;
        final Map<K, V> onlyOnLeft;
        final Map<K, V> onlyOnRight;

        MapDifferenceImpl(boolean areEqual, Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, ValueDifference<V>> differences) {
            this.areEqual = areEqual;
            this.onlyOnLeft = onlyOnLeft;
            this.onlyOnRight = onlyOnRight;
            this.onBoth = onBoth;
            this.differences = differences;
        }

        public boolean areEqual() {
            return this.areEqual;
        }

        public Map<K, V> entriesOnlyOnLeft() {
            return this.onlyOnLeft;
        }

        public Map<K, V> entriesOnlyOnRight() {
            return this.onlyOnRight;
        }

        public Map<K, V> entriesInCommon() {
            return this.onBoth;
        }

        public Map<K, ValueDifference<V>> entriesDiffering() {
            return this.differences;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof MapDifference)) {
                return false;
            }
            MapDifference<?, ?> other = (MapDifference) object;
            if (entriesOnlyOnLeft().equals(other.entriesOnlyOnLeft()) && entriesOnlyOnRight().equals(other.entriesOnlyOnRight()) && entriesInCommon().equals(other.entriesInCommon()) && entriesDiffering().equals(other.entriesDiffering())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering());
        }

        public String toString() {
            if (this.areEqual) {
                return "equal";
            }
            StringBuilder result = new StringBuilder("not equal");
            if (!this.onlyOnLeft.isEmpty()) {
                result.append(": only on left=").append(this.onlyOnLeft);
            }
            if (!this.onlyOnRight.isEmpty()) {
                result.append(": only on right=").append(this.onlyOnRight);
            }
            if (!this.differences.isEmpty()) {
                result.append(": value differences=").append(this.differences);
            }
            return result.toString();
        }
    }

    static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
        SortedMapDifferenceImpl(boolean areEqual, SortedMap<K, V> onlyOnLeft, SortedMap<K, V> onlyOnRight, SortedMap<K, V> onBoth, SortedMap<K, ValueDifference<V>> differences) {
            super(areEqual, onlyOnLeft, onlyOnRight, onBoth, differences);
        }

        public SortedMap<K, ValueDifference<V>> entriesDiffering() {
            return (SortedMap) super.entriesDiffering();
        }

        public SortedMap<K, V> entriesInCommon() {
            return (SortedMap) super.entriesInCommon();
        }

        public SortedMap<K, V> entriesOnlyOnLeft() {
            return (SortedMap) super.entriesOnlyOnLeft();
        }

        public SortedMap<K, V> entriesOnlyOnRight() {
            return (SortedMap) super.entriesOnlyOnRight();
        }
    }

    static class TransformedEntriesMap<K, V1, V2> extends AbstractMap<K, V2> {
        Set<Entry<K, V2>> entrySet;
        final Map<K, V1> fromMap;
        final EntryTransformer<? super K, ? super V1, V2> transformer;
        Collection<V2> values;

        /* renamed from: com.google.common.collect.Maps.TransformedEntriesMap.1 */
        class C05471 extends EntrySet<K, V2> {

            /* renamed from: com.google.common.collect.Maps.TransformedEntriesMap.1.1 */
            class C05461 implements Function<Entry<K, V1>, Entry<K, V2>> {
                C05461() {
                }

                public Entry<K, V2> apply(Entry<K, V1> entry) {
                    return Maps.immutableEntry(entry.getKey(), TransformedEntriesMap.this.transformer.transformEntry(entry.getKey(), entry.getValue()));
                }
            }

            C05471() {
            }

            Map<K, V2> map() {
                return TransformedEntriesMap.this;
            }

            public Iterator<Entry<K, V2>> iterator() {
                return Iterators.transform(TransformedEntriesMap.this.fromMap.entrySet().iterator(), new C05461());
            }
        }

        /* renamed from: com.google.common.collect.Maps.TransformedEntriesMap.2 */
        class C05482 extends Values<K, V2> {
            C05482() {
            }

            Map<K, V2> map() {
                return TransformedEntriesMap.this;
            }
        }

        TransformedEntriesMap(Map<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            this.fromMap = (Map) Preconditions.checkNotNull(fromMap);
            this.transformer = (EntryTransformer) Preconditions.checkNotNull(transformer);
        }

        public int size() {
            return this.fromMap.size();
        }

        public boolean containsKey(Object key) {
            return this.fromMap.containsKey(key);
        }

        public V2 get(Object key) {
            V1 value = this.fromMap.get(key);
            return (value != null || this.fromMap.containsKey(key)) ? this.transformer.transformEntry(key, value) : null;
        }

        public V2 remove(Object key) {
            return this.fromMap.containsKey(key) ? this.transformer.transformEntry(key, this.fromMap.remove(key)) : null;
        }

        public void clear() {
            this.fromMap.clear();
        }

        public Set<K> keySet() {
            return this.fromMap.keySet();
        }

        public Set<Entry<K, V2>> entrySet() {
            Set<Entry<K, V2>> result = this.entrySet;
            if (result != null) {
                return result;
            }
            result = new C05471();
            this.entrySet = result;
            return result;
        }

        public Collection<V2> values() {
            Collection<V2> collection = this.values;
            if (collection != null) {
                return collection;
            }
            collection = new C05482();
            this.values = collection;
            return collection;
        }
    }

    static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
        protected SortedMap<K, V1> fromMap() {
            return (SortedMap) this.fromMap;
        }

        TransformedEntriesSortedMap(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            super(fromMap, transformer);
        }

        public Comparator<? super K> comparator() {
            return fromMap().comparator();
        }

        public K firstKey() {
            return fromMap().firstKey();
        }

        public SortedMap<K, V2> headMap(K toKey) {
            return Maps.transformEntries(fromMap().headMap(toKey), this.transformer);
        }

        public K lastKey() {
            return fromMap().lastKey();
        }

        public SortedMap<K, V2> subMap(K fromKey, K toKey) {
            return Maps.transformEntries(fromMap().subMap(fromKey, toKey), this.transformer);
        }

        public SortedMap<K, V2> tailMap(K fromKey) {
            return Maps.transformEntries(fromMap().tailMap(fromKey), this.transformer);
        }
    }

    private static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final BiMap<? extends K, ? extends V> delegate;
        transient BiMap<V, K> inverse;
        final Map<K, V> unmodifiableMap;
        transient Set<V> values;

        UnmodifiableBiMap(BiMap<? extends K, ? extends V> delegate, @Nullable BiMap<V, K> inverse) {
            this.unmodifiableMap = Collections.unmodifiableMap(delegate);
            this.delegate = delegate;
            this.inverse = inverse;
        }

        protected Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        public V forcePut(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap = this.inverse;
            if (biMap != null) {
                return biMap;
            }
            biMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = biMap;
            return biMap;
        }

        public Set<V> values() {
            Set<V> set = this.values;
            if (set != null) {
                return set;
            }
            set = Collections.unmodifiableSet(this.delegate.values());
            this.values = set;
            return set;
        }
    }

    static class UnmodifiableEntries<K, V> extends ForwardingCollection<Entry<K, V>> {
        private final Collection<Entry<K, V>> entries;

        /* renamed from: com.google.common.collect.Maps.UnmodifiableEntries.1 */
        class C05491 extends ForwardingIterator<Entry<K, V>> {
            final /* synthetic */ Iterator val$delegate;

            C05491(Iterator it) {
                this.val$delegate = it;
            }

            public Entry<K, V> next() {
                return Maps.unmodifiableEntry((Entry) super.next());
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            protected Iterator<Entry<K, V>> delegate() {
                return this.val$delegate;
            }
        }

        UnmodifiableEntries(Collection<Entry<K, V>> entries) {
            this.entries = entries;
        }

        protected Collection<Entry<K, V>> delegate() {
            return this.entries;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C05491(super.iterator());
        }

        public boolean add(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] array) {
            return standardToArray(array);
        }
    }

    static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Entry<K, V>> {
        UnmodifiableEntrySet(Set<Entry<K, V>> entries) {
            super(entries);
        }

        public boolean equals(@Nullable Object object) {
            return Sets.equalsImpl(this, object);
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    static class ValueDifferenceImpl<V> implements ValueDifference<V> {
        private final V left;
        private final V right;

        static <V> ValueDifference<V> create(@Nullable V left, @Nullable V right) {
            return new ValueDifferenceImpl(left, right);
        }

        private ValueDifferenceImpl(@Nullable V left, @Nullable V right) {
            this.left = left;
            this.right = right;
        }

        public V leftValue() {
            return this.left;
        }

        public V rightValue() {
            return this.right;
        }

        public boolean equals(@Nullable Object object) {
            if (!(object instanceof ValueDifference)) {
                return false;
            }
            ValueDifference<?> that = (ValueDifference) object;
            if (Objects.equal(this.left, that.leftValue()) && Objects.equal(this.right, that.rightValue())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.left, this.right);
        }

        public String toString() {
            return "(" + this.left + ", " + this.right + ")";
        }
    }

    private Maps() {
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int expectedSize) {
        return new HashMap(capacity(expectedSize));
    }

    static int capacity(int expectedSize) {
        if (expectedSize < 3) {
            Preconditions.checkArgument(expectedSize >= 0);
            return expectedSize + 1;
        } else if (expectedSize < Ints.MAX_POWER_OF_TWO) {
            return (expectedSize / 3) + expectedSize;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        return new HashMap(map);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap(map);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new MapMaker().makeMap();
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap();
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> map) {
        return new TreeMap(map);
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@Nullable Comparator<C> comparator) {
        return new TreeMap(comparator);
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> type) {
        return new EnumMap((Class) Preconditions.checkNotNull(type));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> map) {
        return new EnumMap(map);
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap();
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> bimap) {
        return Synchronized.biMap(bimap, null);
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
        if (left instanceof SortedMap) {
            return difference((SortedMap) left, (Map) right);
        }
        return difference(left, right, Equivalences.equals());
    }

    @Beta
    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right, Equivalence<? super V> valueEquivalence) {
        Preconditions.checkNotNull(valueEquivalence);
        Map<K, V> onlyOnLeft = newHashMap();
        Map<K, V> onlyOnRight = new HashMap(right);
        Map<K, V> onBoth = newHashMap();
        Map<K, ValueDifference<V>> differences = newHashMap();
        boolean eq = true;
        for (Entry<? extends K, ? extends V> entry : left.entrySet()) {
            K leftKey = entry.getKey();
            V leftValue = entry.getValue();
            if (right.containsKey(leftKey)) {
                V rightValue = onlyOnRight.remove(leftKey);
                if (valueEquivalence.equivalent(leftValue, rightValue)) {
                    onBoth.put(leftKey, leftValue);
                } else {
                    eq = false;
                    differences.put(leftKey, ValueDifferenceImpl.create(leftValue, rightValue));
                }
            } else {
                eq = false;
                onlyOnLeft.put(leftKey, leftValue);
            }
        }
        boolean areEqual = eq && onlyOnRight.isEmpty();
        return mapDifference(areEqual, onlyOnLeft, onlyOnRight, onBoth, differences);
    }

    private static <K, V> MapDifference<K, V> mapDifference(boolean areEqual, Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, ValueDifference<V>> differences) {
        return new MapDifferenceImpl(areEqual, Collections.unmodifiableMap(onlyOnLeft), Collections.unmodifiableMap(onlyOnRight), Collections.unmodifiableMap(onBoth), Collections.unmodifiableMap(differences));
    }

    @Beta
    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> left, Map<? extends K, ? extends V> right) {
        Preconditions.checkNotNull(left);
        Preconditions.checkNotNull(right);
        Comparator comparator = orNaturalOrder(left.comparator());
        SortedMap<K, V> onlyOnLeft = newTreeMap(comparator);
        SortedMap<K, V> onlyOnRight = newTreeMap(comparator);
        onlyOnRight.putAll(right);
        SortedMap<K, V> onBoth = newTreeMap(comparator);
        SortedMap<K, ValueDifference<V>> differences = newTreeMap(comparator);
        boolean eq = true;
        for (Entry<? extends K, ? extends V> entry : left.entrySet()) {
            K leftKey = entry.getKey();
            V leftValue = entry.getValue();
            if (right.containsKey(leftKey)) {
                V rightValue = onlyOnRight.remove(leftKey);
                if (Objects.equal(leftValue, rightValue)) {
                    onBoth.put(leftKey, leftValue);
                } else {
                    eq = false;
                    differences.put(leftKey, ValueDifferenceImpl.create(leftValue, rightValue));
                }
            } else {
                eq = false;
                onlyOnLeft.put(leftKey, leftValue);
            }
        }
        boolean areEqual = eq && onlyOnRight.isEmpty();
        return sortedMapDifference(areEqual, onlyOnLeft, onlyOnRight, onBoth, differences);
    }

    private static <K, V> SortedMapDifference<K, V> sortedMapDifference(boolean areEqual, SortedMap<K, V> onlyOnLeft, SortedMap<K, V> onlyOnRight, SortedMap<K, V> onBoth, SortedMap<K, ValueDifference<V>> differences) {
        return new SortedMapDifferenceImpl(areEqual, Collections.unmodifiableSortedMap(onlyOnLeft), Collections.unmodifiableSortedMap(onlyOnRight), Collections.unmodifiableSortedMap(onBoth), Collections.unmodifiableSortedMap(differences));
    }

    static <E> Comparator<? super E> orNaturalOrder(@Nullable Comparator<? super E> comparator) {
        return comparator != null ? comparator : Ordering.natural();
    }

    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> values, Function<? super V, K> keyFunction) {
        return uniqueIndex(values.iterator(), (Function) keyFunction);
    }

    @Deprecated
    @Beta
    public static <K, V, I extends Iterable<V> & Iterator<V>> ImmutableMap<K, V> uniqueIndex(I values, Function<? super V, K> keyFunction) {
        return uniqueIndex((Iterable) Preconditions.checkNotNull(values), (Function) keyFunction);
    }

    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> values, Function<? super V, K> keyFunction) {
        Preconditions.checkNotNull(keyFunction);
        Builder<K, V> builder = ImmutableMap.builder();
        while (values.hasNext()) {
            V value = values.next();
            builder.put(keyFunction.apply(value), value);
        }
        return builder.build();
    }

    @GwtIncompatible("java.util.Properties")
    public static ImmutableMap<String, String> fromProperties(Properties properties) {
        Builder<String, String> builder = ImmutableMap.builder();
        Enumeration<?> e = properties.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            builder.put(key, properties.getProperty(key));
        }
        return builder.build();
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Entry<K, V> immutableEntry(@Nullable K key, @Nullable V value) {
        return new ImmutableEntry(key, value);
    }

    static <K, V> Set<Entry<K, V>> unmodifiableEntrySet(Set<Entry<K, V>> entrySet) {
        return new UnmodifiableEntrySet(Collections.unmodifiableSet(entrySet));
    }

    static <K, V> Entry<K, V> unmodifiableEntry(Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        return new C05321(entry);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> bimap) {
        return new UnmodifiableBiMap(bimap, null);
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> fromMap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries((Map) fromMap, new C05332(function));
    }

    @Beta
    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> fromMap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries((SortedMap) fromMap, new C05343(function));
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        if (fromMap instanceof SortedMap) {
            return transformEntries((SortedMap) fromMap, (EntryTransformer) transformer);
        }
        return new TransformedEntriesMap(fromMap, transformer);
    }

    @Beta
    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesSortedMap(fromMap, transformer);
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        if (unfiltered instanceof SortedMap) {
            return filterKeys((SortedMap) unfiltered, (Predicate) keyPredicate);
        }
        Preconditions.checkNotNull(keyPredicate);
        Predicate entryPredicate = new C05354(keyPredicate);
        return unfiltered instanceof AbstractFilteredMap ? filterFiltered((AbstractFilteredMap) unfiltered, entryPredicate) : new FilteredKeyMap((Map) Preconditions.checkNotNull(unfiltered), keyPredicate, entryPredicate);
    }

    @Beta
    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        Preconditions.checkNotNull(keyPredicate);
        return filterEntries((SortedMap) unfiltered, new C05365(keyPredicate));
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        if (unfiltered instanceof SortedMap) {
            return filterValues((SortedMap) unfiltered, (Predicate) valuePredicate);
        }
        Preconditions.checkNotNull(valuePredicate);
        return filterEntries((Map) unfiltered, new C05376(valuePredicate));
    }

    @Beta
    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        Preconditions.checkNotNull(valuePredicate);
        return filterEntries((SortedMap) unfiltered, new C05387(valuePredicate));
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
        if (unfiltered instanceof SortedMap) {
            return filterEntries((SortedMap) unfiltered, (Predicate) entryPredicate);
        }
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof AbstractFilteredMap ? filterFiltered((AbstractFilteredMap) unfiltered, (Predicate) entryPredicate) : new FilteredEntryMap((Map) Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    @Beta
    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof FilteredEntrySortedMap ? filterFiltered((FilteredEntrySortedMap) unfiltered, (Predicate) entryPredicate) : new FilteredEntrySortedMap((SortedMap) Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> map, Predicate<? super Entry<K, V>> entryPredicate) {
        return new FilteredEntryMap(map.unfiltered, Predicates.and(map.predicate, entryPredicate));
    }

    private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> map, Predicate<? super Entry<K, V>> entryPredicate) {
        return new FilteredEntrySortedMap(map.sortedMap(), Predicates.and(map.predicate, entryPredicate));
    }

    static {
        STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
    }

    static <V> V safeGet(Map<?, V> map, Object key) {
        try {
            return map.get(key);
        } catch (ClassCastException e) {
            return null;
        }
    }

    static boolean safeContainsKey(Map<?, ?> map, Object key) {
        try {
            return map.containsKey(key);
        } catch (ClassCastException e) {
            return false;
        }
    }

    static <K, V> boolean containsEntryImpl(Collection<Entry<K, V>> c, Object o) {
        if (o instanceof Entry) {
            return c.contains(unmodifiableEntry((Entry) o));
        }
        return false;
    }

    static <K, V> boolean removeEntryImpl(Collection<Entry<K, V>> c, Object o) {
        if (o instanceof Entry) {
            return c.remove(unmodifiableEntry((Entry) o));
        }
        return false;
    }

    static boolean equalsImpl(Map<?, ?> map, Object object) {
        if (map == object) {
            return true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        return map.entrySet().equals(((Map) object).entrySet());
    }

    static int hashCodeImpl(Map<?, ?> map) {
        return Sets.hashCodeImpl(map.entrySet());
    }

    static String toStringImpl(Map<?, ?> map) {
        StringBuilder sb = Collections2.newStringBuilderForCollection(map.size()).append(Category.SCHEME_PREFIX);
        STANDARD_JOINER.appendTo(sb, (Map) map);
        return sb.append(Category.SCHEME_SUFFIX).toString();
    }

    static <K, V> void putAllImpl(Map<K, V> self, Map<? extends K, ? extends V> map) {
        for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
            self.put(entry.getKey(), entry.getValue());
        }
    }

    static boolean containsKeyImpl(Map<?, ?> map, @Nullable Object key) {
        for (Entry<?, ?> entry : map.entrySet()) {
            if (Objects.equal(entry.getKey(), key)) {
                return true;
            }
        }
        return false;
    }

    static boolean containsValueImpl(Map<?, ?> map, @Nullable Object value) {
        for (Entry<?, ?> entry : map.entrySet()) {
            if (Objects.equal(entry.getValue(), value)) {
                return true;
            }
        }
        return false;
    }
}
