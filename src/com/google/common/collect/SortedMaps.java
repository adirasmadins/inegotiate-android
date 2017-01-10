package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps.EntryTransformer;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
@Deprecated
@Beta
public final class SortedMaps {

    /* renamed from: com.google.common.collect.SortedMaps.1 */
    static class C06191 implements Predicate<Entry<K, V>> {
        final /* synthetic */ Predicate val$keyPredicate;

        C06191(Predicate predicate) {
            this.val$keyPredicate = predicate;
        }

        public boolean apply(Entry<K, V> input) {
            return this.val$keyPredicate.apply(input.getKey());
        }
    }

    /* renamed from: com.google.common.collect.SortedMaps.2 */
    static class C06202 implements Predicate<Entry<K, V>> {
        final /* synthetic */ Predicate val$valuePredicate;

        C06202(Predicate predicate) {
            this.val$valuePredicate = predicate;
        }

        public boolean apply(Entry<K, V> input) {
            return this.val$valuePredicate.apply(input.getValue());
        }
    }

    private static class FilteredSortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {
        FilteredSortedMap(SortedMap<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
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
            return new FilteredSortedMap(sortedMap().headMap(toKey), this.predicate);
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return new FilteredSortedMap(sortedMap().subMap(fromKey, toKey), this.predicate);
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            return new FilteredSortedMap(sortedMap().tailMap(fromKey), this.predicate);
        }
    }

    private SortedMaps() {
    }

    @Deprecated
    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> fromMap, Function<? super V1, V2> function) {
        return Maps.transformValues((SortedMap) fromMap, (Function) function);
    }

    @Deprecated
    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return Maps.transformEntries((SortedMap) fromMap, (EntryTransformer) transformer);
    }

    @Deprecated
    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> left, Map<? extends K, ? extends V> right) {
        return Maps.difference((SortedMap) left, (Map) right);
    }

    static <E> Comparator<? super E> orNaturalOrder(@Nullable Comparator<? super E> comparator) {
        return comparator != null ? comparator : Ordering.natural();
    }

    @GwtIncompatible("untested")
    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        Preconditions.checkNotNull(keyPredicate);
        return filterEntries(unfiltered, new C06191(keyPredicate));
    }

    @GwtIncompatible("untested")
    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        Preconditions.checkNotNull(valuePredicate);
        return filterEntries(unfiltered, new C06202(valuePredicate));
    }

    @GwtIncompatible("untested")
    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof FilteredSortedMap ? filterFiltered((FilteredSortedMap) unfiltered, entryPredicate) : new FilteredSortedMap((SortedMap) Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    private static <K, V> SortedMap<K, V> filterFiltered(FilteredSortedMap<K, V> map, Predicate<? super Entry<K, V>> entryPredicate) {
        return new FilteredSortedMap(map.sortedMap(), Predicates.and(map.predicate, entryPredicate));
    }
}
