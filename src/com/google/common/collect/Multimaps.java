package com.google.common.collect;

import com.amazonaws.services.s3.internal.Constants;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableListMultimap.Builder;
import com.google.common.collect.Maps.EntryTransformer;
import com.google.common.collect.Multiset.Entry;
import com.google.gdata.data.Category;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Multimaps {

    static abstract class Keys<K, V> extends AbstractMultiset<K> {

        class KeysEntrySet extends EntrySet<K> {
            KeysEntrySet() {
            }

            Multiset<K> multiset() {
                return Keys.this;
            }

            public Iterator<Entry<K>> iterator() {
                return Keys.this.entryIterator();
            }

            public int size() {
                return Keys.this.distinctElements();
            }

            public boolean isEmpty() {
                return Keys.this.multimap().isEmpty();
            }

            public boolean contains(@Nullable Object o) {
                if (!(o instanceof Entry)) {
                    return false;
                }
                Entry<?> entry = (Entry) o;
                Collection<V> collection = (Collection) Keys.this.multimap().asMap().get(entry.getElement());
                if (collection == null || collection.size() != entry.getCount()) {
                    return false;
                }
                return true;
            }

            public boolean remove(@Nullable Object o) {
                if (o instanceof Entry) {
                    Entry<?> entry = (Entry) o;
                    Collection<V> collection = (Collection) Keys.this.multimap().asMap().get(entry.getElement());
                    if (collection != null && collection.size() == entry.getCount()) {
                        collection.clear();
                        return true;
                    }
                }
                return false;
            }
        }

        /* renamed from: com.google.common.collect.Multimaps.Keys.1 */
        class C05651 implements Iterator<Entry<K>> {
            final /* synthetic */ Iterator val$backingIterator;

            /* renamed from: com.google.common.collect.Multimaps.Keys.1.1 */
            class C05641 extends AbstractEntry<K> {
                final /* synthetic */ Map.Entry val$backingEntry;

                C05641(Map.Entry entry) {
                    this.val$backingEntry = entry;
                }

                public K getElement() {
                    return this.val$backingEntry.getKey();
                }

                public int getCount() {
                    return ((Collection) this.val$backingEntry.getValue()).size();
                }
            }

            C05651(Iterator it) {
                this.val$backingIterator = it;
            }

            public boolean hasNext() {
                return this.val$backingIterator.hasNext();
            }

            public Entry<K> next() {
                return new C05641((Map.Entry) this.val$backingIterator.next());
            }

            public void remove() {
                this.val$backingIterator.remove();
            }
        }

        /* renamed from: com.google.common.collect.Multimaps.Keys.2 */
        class C05662 implements Function<Map.Entry<K, V>, K> {
            C05662() {
            }

            public K apply(Map.Entry<K, V> entry) {
                return entry.getKey();
            }
        }

        abstract Multimap<K, V> multimap();

        Keys() {
        }

        Iterator<Entry<K>> entryIterator() {
            return new C05651(multimap().asMap().entrySet().iterator());
        }

        int distinctElements() {
            return multimap().asMap().size();
        }

        Set<Entry<K>> createEntrySet() {
            return new KeysEntrySet();
        }

        public boolean contains(@Nullable Object element) {
            return multimap().containsKey(element);
        }

        public Iterator<K> iterator() {
            return Iterators.transform(multimap().entries().iterator(), new C05662());
        }

        public int count(@Nullable Object element) {
            int i = 0;
            try {
                if (multimap().containsKey(element)) {
                    Collection<V> values = (Collection) multimap().asMap().get(element);
                    if (values != null) {
                        i = values.size();
                    }
                }
            } catch (ClassCastException e) {
            } catch (NullPointerException e2) {
            }
            return i;
        }

        public int remove(@Nullable Object element, int occurrences) {
            Preconditions.checkArgument(occurrences >= 0);
            if (occurrences == 0) {
                return count(element);
            }
            try {
                Collection<V> values = (Collection) multimap().asMap().get(element);
                if (values == null) {
                    return 0;
                }
                int oldCount = values.size();
                if (occurrences >= oldCount) {
                    values.clear();
                } else {
                    Iterator<V> iterator = values.iterator();
                    for (int i = 0; i < occurrences; i++) {
                        iterator.next();
                        iterator.remove();
                    }
                }
                return oldCount;
            } catch (ClassCastException e) {
                return 0;
            } catch (NullPointerException e2) {
                return 0;
            }
        }

        public void clear() {
            multimap().clear();
        }

        public Set<K> elementSet() {
            return multimap().keySet();
        }
    }

    static abstract class Values<K, V> extends AbstractCollection<V> {

        /* renamed from: com.google.common.collect.Multimaps.Values.1 */
        class C05801 implements Iterator<V> {
            final /* synthetic */ Iterator val$backingIterator;

            C05801(Iterator it) {
                this.val$backingIterator = it;
            }

            public boolean hasNext() {
                return this.val$backingIterator.hasNext();
            }

            public V next() {
                return ((Map.Entry) this.val$backingIterator.next()).getValue();
            }

            public void remove() {
                this.val$backingIterator.remove();
            }
        }

        abstract Multimap<K, V> multimap();

        Values() {
        }

        public Iterator<V> iterator() {
            return new C05801(multimap().entries().iterator());
        }

        public int size() {
            return multimap().size();
        }

        public boolean contains(@Nullable Object o) {
            return multimap().containsValue(o);
        }

        public void clear() {
            multimap().clear();
        }
    }

    static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        abstract Multimap<K, V> multimap();

        Entries() {
        }

        public int size() {
            return multimap().size();
        }

        public boolean contains(@Nullable Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o;
            return multimap().containsEntry(entry.getKey(), entry.getValue());
        }

        public boolean remove(@Nullable Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o;
            return multimap().remove(entry.getKey(), entry.getValue());
        }

        public void clear() {
            multimap().clear();
        }
    }

    static abstract class EntrySet<K, V> extends Entries<K, V> implements Set<Map.Entry<K, V>> {
        EntrySet() {
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        public boolean equals(@Nullable Object obj) {
            return Sets.equalsImpl(this, obj);
        }
    }

    /* renamed from: com.google.common.collect.Multimaps.1 */
    static class C05521 extends AbstractMapEntry<K, Collection<V>> {
        final /* synthetic */ Map.Entry val$entry;

        C05521(Map.Entry entry) {
            this.val$entry = entry;
        }

        public K getKey() {
            return this.val$entry.getKey();
        }

        public Collection<V> getValue() {
            return Multimaps.unmodifiableValueCollection((Collection) this.val$entry.getValue());
        }
    }

    /* renamed from: com.google.common.collect.Multimaps.2 */
    static class C05532 implements EntryTransformer<K, V1, V2> {
        final /* synthetic */ Function val$function;

        C05532(Function function) {
            this.val$function = function;
        }

        public V2 transformEntry(K k, V1 value) {
            return this.val$function.apply(value);
        }
    }

    /* renamed from: com.google.common.collect.Multimaps.3 */
    static class C05543 implements EntryTransformer<K, V1, V2> {
        final /* synthetic */ Function val$function;

        C05543(Function function) {
            this.val$function = function;
        }

        public V2 transformEntry(K k, V1 value) {
            return this.val$function.apply(value);
        }
    }

    /* renamed from: com.google.common.collect.Multimaps.4 */
    static class C05554 implements Predicate<Map.Entry<K, V>> {
        final /* synthetic */ Predicate val$keyPredicate;

        C05554(Predicate predicate) {
            this.val$keyPredicate = predicate;
        }

        public boolean apply(Map.Entry<K, V> input) {
            return this.val$keyPredicate.apply(input.getKey());
        }
    }

    /* renamed from: com.google.common.collect.Multimaps.5 */
    static class C05565 implements Predicate<Map.Entry<K, V>> {
        final /* synthetic */ Predicate val$valuePredicate;

        C05565(Predicate predicate) {
            this.val$valuePredicate = predicate;
        }

        public boolean apply(Map.Entry<K, V> input) {
            return this.val$valuePredicate.apply(input.getValue());
        }
    }

    static abstract class AsMap<K, V> extends ImprovedAbstractMap<K, Collection<V>> {

        class EntrySet extends EntrySet<K, Collection<V>> {
            EntrySet() {
            }

            Map<K, Collection<V>> map() {
                return AsMap.this;
            }

            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return AsMap.this.entryIterator();
            }

            public boolean remove(Object o) {
                if (!contains(o)) {
                    return false;
                }
                AsMap.this.removeValuesForKey(((Map.Entry) o).getKey());
                return true;
            }
        }

        abstract Iterator<Map.Entry<K, Collection<V>>> entryIterator();

        abstract Multimap<K, V> multimap();

        public abstract int size();

        AsMap() {
        }

        protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new EntrySet();
        }

        void removeValuesForKey(Object key) {
            multimap().removeAll(key);
        }

        public Collection<V> get(Object key) {
            return containsKey(key) ? multimap().get(key) : null;
        }

        public Collection<V> remove(Object key) {
            return containsKey(key) ? multimap().removeAll(key) : null;
        }

        public Set<K> keySet() {
            return multimap().keySet();
        }

        public boolean isEmpty() {
            return multimap().isEmpty();
        }

        public boolean containsKey(Object key) {
            return multimap().containsKey(key);
        }

        public void clear() {
            multimap().clear();
        }
    }

    private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        @GwtIncompatible("java serialization not supported")
        private static final long serialVersionUID = 0;
        transient Supplier<? extends List<V>> factory;

        CustomListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> factory) {
            super(map);
            this.factory = (Supplier) Preconditions.checkNotNull(factory);
        }

        protected List<V> createCollection() {
            return (List) this.factory.get();
        }

        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(backingMap());
        }

        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.factory = (Supplier) stream.readObject();
            setMap((Map) stream.readObject());
        }
    }

    private static class CustomMultimap<K, V> extends AbstractMultimap<K, V> {
        @GwtIncompatible("java serialization not supported")
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Collection<V>> factory;

        CustomMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> factory) {
            super(map);
            this.factory = (Supplier) Preconditions.checkNotNull(factory);
        }

        protected Collection<V> createCollection() {
            return (Collection) this.factory.get();
        }

        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(backingMap());
        }

        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.factory = (Supplier) stream.readObject();
            setMap((Map) stream.readObject());
        }
    }

    private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        @GwtIncompatible("not needed in emulated source")
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Set<V>> factory;

        CustomSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> factory) {
            super(map);
            this.factory = (Supplier) Preconditions.checkNotNull(factory);
        }

        protected Set<V> createCollection() {
            return (Set) this.factory.get();
        }

        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(backingMap());
        }

        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.factory = (Supplier) stream.readObject();
            setMap((Map) stream.readObject());
        }
    }

    private static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        @GwtIncompatible("not needed in emulated source")
        private static final long serialVersionUID = 0;
        transient Supplier<? extends SortedSet<V>> factory;
        transient Comparator<? super V> valueComparator;

        CustomSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> factory) {
            super(map);
            this.factory = (Supplier) Preconditions.checkNotNull(factory);
            this.valueComparator = ((SortedSet) factory.get()).comparator();
        }

        protected SortedSet<V> createCollection() {
            return (SortedSet) this.factory.get();
        }

        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(backingMap());
        }

        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.factory = (Supplier) stream.readObject();
            this.valueComparator = ((SortedSet) this.factory.get()).comparator();
            setMap((Map) stream.readObject());
        }
    }

    private static class FilteredMultimap<K, V> implements Multimap<K, V> {
        static final Predicate<Collection<?>> NOT_EMPTY;
        Map<K, Collection<V>> asMap;
        Collection<Map.Entry<K, V>> entries;
        AbstractMultiset<K> keys;
        final Predicate<? super Map.Entry<K, V>> predicate;
        final Multimap<K, V> unfiltered;
        Collection<V> values;

        /* renamed from: com.google.common.collect.Multimaps.FilteredMultimap.1 */
        static class C05571 implements Predicate<Collection<?>> {
            C05571() {
            }

            public boolean apply(Collection<?> input) {
                return !input.isEmpty();
            }
        }

        /* renamed from: com.google.common.collect.Multimaps.FilteredMultimap.2 */
        class C05582 implements EntryTransformer<K, Collection<V>, Collection<V>> {
            C05582() {
            }

            public Collection<V> transformEntry(K key, Collection<V> collection) {
                return FilteredMultimap.this.filterCollection(collection, new ValuePredicate(key));
            }
        }

        class AsMap extends ForwardingMap<K, Collection<V>> {
            com.google.common.collect.Multimaps$FilteredMultimap$AsMap.Values asMapValues;
            final Map<K, Collection<V>> delegate;
            com.google.common.collect.Multimaps$FilteredMultimap$AsMap.EntrySet entrySet;
            Set<K> keySet;

            class EntrySet extends EntrySet<K, Collection<V>> {
                Set<Map.Entry<K, Collection<V>>> delegateEntries;

                /* renamed from: com.google.common.collect.Multimaps.FilteredMultimap.AsMap.EntrySet.1 */
                class C05591 implements Predicate<Map.Entry<K, Collection<V>>> {
                    final /* synthetic */ Collection val$c;

                    C05591(Collection collection) {
                        this.val$c = collection;
                    }

                    public boolean apply(Map.Entry<K, Collection<V>> entry) {
                        return !this.val$c.contains(entry);
                    }
                }

                public EntrySet(Set<Map.Entry<K, Collection<V>>> delegateEntries) {
                    this.delegateEntries = delegateEntries;
                }

                Map<K, Collection<V>> map() {
                    return AsMap.this;
                }

                public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                    return this.delegateEntries.iterator();
                }

                public boolean remove(Object o) {
                    if (o instanceof Map.Entry) {
                        Map.Entry<?, ?> entry = (Map.Entry) o;
                        Collection<V> collection = (Collection) AsMap.this.delegate.get(entry.getKey());
                        if (collection != null && collection.equals(entry.getValue())) {
                            collection.clear();
                            return true;
                        }
                    }
                    return false;
                }

                public boolean removeAll(Collection<?> c) {
                    return Sets.removeAllImpl(this, c);
                }

                public boolean retainAll(Collection<?> c) {
                    return FilteredMultimap.this.removeEntriesIf(new C05591(c));
                }
            }

            class KeySet extends KeySet<K, Collection<V>> {

                /* renamed from: com.google.common.collect.Multimaps.FilteredMultimap.AsMap.KeySet.1 */
                class C05601 implements Predicate<Map.Entry<K, Collection<V>>> {
                    final /* synthetic */ Collection val$c;

                    C05601(Collection collection) {
                        this.val$c = collection;
                    }

                    public boolean apply(Map.Entry<K, Collection<V>> entry) {
                        return !this.val$c.contains(entry.getKey());
                    }
                }

                KeySet() {
                }

                Map<K, Collection<V>> map() {
                    return AsMap.this;
                }

                public boolean remove(Object o) {
                    Collection<V> collection = (Collection) AsMap.this.delegate.get(o);
                    if (collection == null) {
                        return false;
                    }
                    collection.clear();
                    return true;
                }

                public boolean removeAll(Collection<?> c) {
                    return Sets.removeAllImpl(this, c);
                }

                public boolean retainAll(Collection<?> c) {
                    return FilteredMultimap.this.removeEntriesIf(new C05601(c));
                }
            }

            class Values extends Values<K, Collection<V>> {

                /* renamed from: com.google.common.collect.Multimaps.FilteredMultimap.AsMap.Values.1 */
                class C05611 implements Predicate<Map.Entry<K, Collection<V>>> {
                    final /* synthetic */ Collection val$c;

                    C05611(Collection collection) {
                        this.val$c = collection;
                    }

                    public boolean apply(Map.Entry<K, Collection<V>> entry) {
                        return this.val$c.contains(entry.getValue());
                    }
                }

                /* renamed from: com.google.common.collect.Multimaps.FilteredMultimap.AsMap.Values.2 */
                class C05622 implements Predicate<Map.Entry<K, Collection<V>>> {
                    final /* synthetic */ Collection val$c;

                    C05622(Collection collection) {
                        this.val$c = collection;
                    }

                    public boolean apply(Map.Entry<K, Collection<V>> entry) {
                        return !this.val$c.contains(entry.getValue());
                    }
                }

                Values() {
                }

                Map<K, Collection<V>> map() {
                    return AsMap.this;
                }

                public boolean remove(Object o) {
                    Iterator i$ = iterator();
                    while (i$.hasNext()) {
                        Collection<V> collection = (Collection) i$.next();
                        if (collection.equals(o)) {
                            collection.clear();
                            return true;
                        }
                    }
                    return false;
                }

                public boolean removeAll(Collection<?> c) {
                    return FilteredMultimap.this.removeEntriesIf(new C05611(c));
                }

                public boolean retainAll(Collection<?> c) {
                    return FilteredMultimap.this.removeEntriesIf(new C05622(c));
                }
            }

            AsMap(Map<K, Collection<V>> delegate) {
                this.delegate = delegate;
            }

            protected Map<K, Collection<V>> delegate() {
                return this.delegate;
            }

            public Collection<V> remove(Object o) {
                Collection<V> output = FilteredMultimap.this.removeAll(o);
                return output.isEmpty() ? null : output;
            }

            public void clear() {
                FilteredMultimap.this.clear();
            }

            public Set<K> keySet() {
                if (this.keySet != null) {
                    return this.keySet;
                }
                Set<K> keySet = new KeySet();
                this.keySet = keySet;
                return keySet;
            }

            public Collection<Collection<V>> values() {
                if (this.asMapValues != null) {
                    return this.asMapValues;
                }
                Collection values = new Values();
                this.asMapValues = values;
                return values;
            }

            public Set<Map.Entry<K, Collection<V>>> entrySet() {
                if (this.entrySet != null) {
                    return this.entrySet;
                }
                Set entrySet = new EntrySet(super.entrySet());
                this.entrySet = entrySet;
                return entrySet;
            }
        }

        class Keys extends Keys<K, V> {

            class EntrySet extends KeysEntrySet {

                /* renamed from: com.google.common.collect.Multimaps.FilteredMultimap.Keys.EntrySet.1 */
                class C05631 implements Predicate<Map.Entry<K, Collection<V>>> {
                    final /* synthetic */ Collection val$c;

                    C05631(Collection collection) {
                        this.val$c = collection;
                    }

                    public boolean apply(Map.Entry<K, Collection<V>> entry) {
                        return !this.val$c.contains(Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size()));
                    }
                }

                EntrySet() {
                    super();
                }

                public boolean removeAll(Collection<?> c) {
                    return Sets.removeAllImpl(this, c);
                }

                public boolean retainAll(Collection<?> c) {
                    return FilteredMultimap.this.removeEntriesIf(new C05631(c));
                }
            }

            Keys() {
            }

            Multimap<K, V> multimap() {
                return FilteredMultimap.this;
            }

            public int remove(Object o, int occurrences) {
                boolean z;
                if (occurrences >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                Collection<V> values = (Collection) FilteredMultimap.this.unfiltered.asMap().get(o);
                if (values == null) {
                    return 0;
                }
                int priorCount = 0;
                int removed = 0;
                Iterator<V> iterator = values.iterator();
                while (iterator.hasNext()) {
                    if (FilteredMultimap.this.satisfiesPredicate(o, iterator.next())) {
                        priorCount++;
                        if (removed < occurrences) {
                            iterator.remove();
                            removed++;
                        }
                    }
                }
                return priorCount;
            }

            Set<Entry<K>> createEntrySet() {
                return new EntrySet();
            }
        }

        class ValuePredicate implements Predicate<V> {
            final K key;

            ValuePredicate(K key) {
                this.key = key;
            }

            public boolean apply(V value) {
                return FilteredMultimap.this.satisfiesPredicate(this.key, value);
            }
        }

        class Values extends Values<K, V> {
            Values() {
            }

            Multimap<K, V> multimap() {
                return FilteredMultimap.this;
            }

            public boolean contains(@Nullable Object o) {
                return Iterators.contains(iterator(), o);
            }

            public boolean remove(Object o) {
                Iterator<Map.Entry<K, V>> iterator = FilteredMultimap.this.unfiltered.entries().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<K, V> entry = (Map.Entry) iterator.next();
                    if (Objects.equal(o, entry.getValue()) && FilteredMultimap.this.predicate.apply(entry)) {
                        iterator.remove();
                        return true;
                    }
                }
                return false;
            }

            public boolean removeAll(Collection<?> c) {
                boolean changed = false;
                Iterator<Map.Entry<K, V>> iterator = FilteredMultimap.this.unfiltered.entries().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<K, V> entry = (Map.Entry) iterator.next();
                    if (c.contains(entry.getValue()) && FilteredMultimap.this.predicate.apply(entry)) {
                        iterator.remove();
                        changed = true;
                    }
                }
                return changed;
            }

            public boolean retainAll(Collection<?> c) {
                boolean changed = false;
                Iterator<Map.Entry<K, V>> iterator = FilteredMultimap.this.unfiltered.entries().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<K, V> entry = (Map.Entry) iterator.next();
                    if (!c.contains(entry.getValue()) && FilteredMultimap.this.predicate.apply(entry)) {
                        iterator.remove();
                        changed = true;
                    }
                }
                return changed;
            }
        }

        FilteredMultimap(Multimap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> predicate) {
            this.unfiltered = unfiltered;
            this.predicate = predicate;
        }

        public int size() {
            return entries().size();
        }

        public boolean isEmpty() {
            return entries().isEmpty();
        }

        public boolean containsKey(Object key) {
            return asMap().containsKey(key);
        }

        public boolean containsValue(Object value) {
            return values().contains(value);
        }

        boolean satisfiesPredicate(Object key, Object value) {
            return this.predicate.apply(Maps.immutableEntry(key, value));
        }

        public boolean containsEntry(Object key, Object value) {
            return this.unfiltered.containsEntry(key, value) && satisfiesPredicate(key, value);
        }

        public boolean put(K key, V value) {
            Preconditions.checkArgument(satisfiesPredicate(key, value));
            return this.unfiltered.put(key, value);
        }

        public boolean remove(Object key, Object value) {
            return containsEntry(key, value) ? this.unfiltered.remove(key, value) : false;
        }

        public boolean putAll(K key, Iterable<? extends V> values) {
            for (V value : values) {
                Preconditions.checkArgument(satisfiesPredicate(key, value));
            }
            return this.unfiltered.putAll(key, values);
        }

        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry<? extends K, ? extends V> entry : multimap.entries()) {
                Preconditions.checkArgument(satisfiesPredicate(entry.getKey(), entry.getValue()));
            }
            return this.unfiltered.putAll(multimap);
        }

        public Collection<V> replaceValues(K key, Iterable<? extends V> values) {
            for (V value : values) {
                Preconditions.checkArgument(satisfiesPredicate(key, value));
            }
            Collection<V> oldValues = removeAll(key);
            this.unfiltered.putAll(key, values);
            return oldValues;
        }

        public Collection<V> removeAll(Object key) {
            List<V> removed = Lists.newArrayList();
            Collection<V> values = (Collection) this.unfiltered.asMap().get(key);
            if (values != null) {
                Iterator<V> iterator = values.iterator();
                while (iterator.hasNext()) {
                    V value = iterator.next();
                    if (satisfiesPredicate(key, value)) {
                        removed.add(value);
                        iterator.remove();
                    }
                }
            }
            if (this.unfiltered instanceof SetMultimap) {
                return Collections.unmodifiableSet(Sets.newLinkedHashSet(removed));
            }
            return Collections.unmodifiableList(removed);
        }

        public void clear() {
            entries().clear();
        }

        public boolean equals(@Nullable Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Multimap)) {
                return false;
            }
            return asMap().equals(((Multimap) object).asMap());
        }

        public int hashCode() {
            return asMap().hashCode();
        }

        public String toString() {
            return asMap().toString();
        }

        Collection<V> filterCollection(Collection<V> collection, Predicate<V> predicate) {
            if (collection instanceof Set) {
                return Sets.filter((Set) collection, (Predicate) predicate);
            }
            return Collections2.filter(collection, predicate);
        }

        public Collection<V> get(K key) {
            return filterCollection(this.unfiltered.get(key), new ValuePredicate(key));
        }

        public Set<K> keySet() {
            return asMap().keySet();
        }

        public Collection<V> values() {
            if (this.values != null) {
                return this.values;
            }
            Collection<V> values = new Values();
            this.values = values;
            return values;
        }

        public Collection<Map.Entry<K, V>> entries() {
            if (this.entries != null) {
                return this.entries;
            }
            Collection<Map.Entry<K, V>> filter = Collections2.filter(this.unfiltered.entries(), this.predicate);
            this.entries = filter;
            return filter;
        }

        boolean removeEntriesIf(Predicate<Map.Entry<K, Collection<V>>> removalPredicate) {
            Iterator<Map.Entry<K, Collection<V>>> iterator = this.unfiltered.asMap().entrySet().iterator();
            boolean changed = false;
            while (iterator.hasNext()) {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) iterator.next();
                K key = entry.getKey();
                Collection<V> collection = (Collection) entry.getValue();
                Predicate<V> valuePredicate = new ValuePredicate(key);
                Collection<V> filteredCollection = filterCollection(collection, valuePredicate);
                if (removalPredicate.apply(Maps.immutableEntry(key, filteredCollection)) && !filteredCollection.isEmpty()) {
                    changed = true;
                    if (Iterables.all(collection, valuePredicate)) {
                        iterator.remove();
                    } else {
                        filteredCollection.clear();
                    }
                }
            }
            return changed;
        }

        public Map<K, Collection<V>> asMap() {
            if (this.asMap != null) {
                return this.asMap;
            }
            Map<K, Collection<V>> createAsMap = createAsMap();
            this.asMap = createAsMap;
            return createAsMap;
        }

        static {
            NOT_EMPTY = new C05571();
        }

        Map<K, Collection<V>> createAsMap() {
            return new AsMap(Maps.filterValues(Maps.transformEntries(this.unfiltered.asMap(), new C05582()), NOT_EMPTY));
        }

        public Multiset<K> keys() {
            if (this.keys != null) {
                return this.keys;
            }
            Multiset keys = new Keys();
            this.keys = keys;
            return keys;
        }
    }

    private static class MapMultimap<K, V> implements SetMultimap<K, V>, Serializable {
        private static final MapJoiner JOINER;
        private static final long serialVersionUID = 7845222491160860175L;
        transient Map<K, Collection<V>> asMap;
        final Map<K, V> map;

        /* renamed from: com.google.common.collect.Multimaps.MapMultimap.1 */
        class C05681 extends AbstractSet<V> {
            final /* synthetic */ Object val$key;

            /* renamed from: com.google.common.collect.Multimaps.MapMultimap.1.1 */
            class C05671 implements Iterator<V> {
                int f437i;

                C05671() {
                }

                public boolean hasNext() {
                    return this.f437i == 0 && MapMultimap.this.map.containsKey(C05681.this.val$key);
                }

                public V next() {
                    if (hasNext()) {
                        this.f437i++;
                        return MapMultimap.this.map.get(C05681.this.val$key);
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    boolean z = true;
                    if (this.f437i != 1) {
                        z = false;
                    }
                    Preconditions.checkState(z);
                    this.f437i = -1;
                    MapMultimap.this.map.remove(C05681.this.val$key);
                }
            }

            C05681(Object obj) {
                this.val$key = obj;
            }

            public Iterator<V> iterator() {
                return new C05671();
            }

            public int size() {
                return MapMultimap.this.map.containsKey(this.val$key) ? 1 : 0;
            }
        }

        class AsMap extends ImprovedAbstractMap<K, Collection<V>> {
            AsMap() {
            }

            protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
                return new AsMapEntries();
            }

            public boolean containsKey(Object key) {
                return MapMultimap.this.map.containsKey(key);
            }

            public Collection<V> get(Object key) {
                Collection<V> collection = MapMultimap.this.get(key);
                return collection.isEmpty() ? null : collection;
            }

            public Collection<V> remove(Object key) {
                Collection<V> collection = MapMultimap.this.removeAll(key);
                return collection.isEmpty() ? null : collection;
            }
        }

        class AsMapEntries extends AbstractSet<Map.Entry<K, Collection<V>>> {

            /* renamed from: com.google.common.collect.Multimaps.MapMultimap.AsMapEntries.1 */
            class C05701 implements Iterator<Map.Entry<K, Collection<V>>> {
                final Iterator<K> keys;

                /* renamed from: com.google.common.collect.Multimaps.MapMultimap.AsMapEntries.1.1 */
                class C05691 extends AbstractMapEntry<K, Collection<V>> {
                    final /* synthetic */ Object val$key;

                    C05691(Object obj) {
                        this.val$key = obj;
                    }

                    public K getKey() {
                        return this.val$key;
                    }

                    public Collection<V> getValue() {
                        return MapMultimap.this.get(this.val$key);
                    }
                }

                C05701() {
                    this.keys = MapMultimap.this.map.keySet().iterator();
                }

                public boolean hasNext() {
                    return this.keys.hasNext();
                }

                public Map.Entry<K, Collection<V>> next() {
                    return new C05691(this.keys.next());
                }

                public void remove() {
                    this.keys.remove();
                }
            }

            AsMapEntries() {
            }

            public int size() {
                return MapMultimap.this.map.size();
            }

            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C05701();
            }

            public boolean contains(Object o) {
                boolean z = true;
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> entry = (Map.Entry) o;
                if (!(entry.getValue() instanceof Set)) {
                    return false;
                }
                Set<?> set = (Set) entry.getValue();
                if (!(set.size() == 1 && MapMultimap.this.containsEntry(entry.getKey(), set.iterator().next()))) {
                    z = false;
                }
                return z;
            }

            public boolean remove(Object o) {
                boolean z = true;
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> entry = (Map.Entry) o;
                if (!(entry.getValue() instanceof Set)) {
                    return false;
                }
                Set<?> set = (Set) entry.getValue();
                if (!(set.size() == 1 && MapMultimap.this.map.entrySet().remove(Maps.immutableEntry(entry.getKey(), set.iterator().next())))) {
                    z = false;
                }
                return z;
            }
        }

        MapMultimap(Map<K, V> map) {
            this.map = (Map) Preconditions.checkNotNull(map);
        }

        public int size() {
            return this.map.size();
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public boolean containsKey(Object key) {
            return this.map.containsKey(key);
        }

        public boolean containsValue(Object value) {
            return this.map.containsValue(value);
        }

        public boolean containsEntry(Object key, Object value) {
            return this.map.entrySet().contains(Maps.immutableEntry(key, value));
        }

        public Set<V> get(K key) {
            return new C05681(key);
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

        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object key, Object value) {
            return this.map.entrySet().remove(Maps.immutableEntry(key, value));
        }

        public Set<V> removeAll(Object key) {
            Set<V> values = new HashSet(2);
            if (this.map.containsKey(key)) {
                values.add(this.map.remove(key));
            }
            return values;
        }

        public void clear() {
            this.map.clear();
        }

        public Set<K> keySet() {
            return this.map.keySet();
        }

        public Multiset<K> keys() {
            return Multisets.forSet(this.map.keySet());
        }

        public Collection<V> values() {
            return this.map.values();
        }

        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> result = this.asMap;
            if (result != null) {
                return result;
            }
            result = new AsMap();
            this.asMap = result;
            return result;
        }

        public boolean equals(@Nullable Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Multimap)) {
                return false;
            }
            Multimap<?, ?> that = (Multimap) object;
            if (size() == that.size() && asMap().equals(that.asMap())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        static {
            JOINER = Joiner.on("], ").withKeyValueSeparator("=[").useForNull(Constants.NULL_VERSION_ID);
        }

        public String toString() {
            if (this.map.isEmpty()) {
                return "{}";
            }
            StringBuilder builder = Collections2.newStringBuilderForCollection(this.map.size()).append(Category.SCHEME_PREFIX);
            JOINER.appendTo(builder, this.map);
            return builder.append("]}").toString();
        }
    }

    private static class TransformedEntriesMultimap<K, V1, V2> implements Multimap<K, V2> {
        private transient Map<K, Collection<V2>> asMap;
        private transient Collection<Map.Entry<K, V2>> entries;
        final Multimap<K, V1> fromMultimap;
        final EntryTransformer<? super K, ? super V1, V2> transformer;
        private transient Collection<V2> values;

        /* renamed from: com.google.common.collect.Multimaps.TransformedEntriesMultimap.1 */
        class C05721 implements Function<V1, V2> {
            final /* synthetic */ Object val$key;

            C05721(Object obj) {
                this.val$key = obj;
            }

            public V2 apply(V1 value) {
                return TransformedEntriesMultimap.this.transformer.transformEntry(this.val$key, value);
            }
        }

        /* renamed from: com.google.common.collect.Multimaps.TransformedEntriesMultimap.2 */
        class C05732 implements EntryTransformer<K, Collection<V1>, Collection<V2>> {
            C05732() {
            }

            public Collection<V2> transformEntry(K key, Collection<V1> value) {
                return TransformedEntriesMultimap.this.transform(key, value);
            }
        }

        /* renamed from: com.google.common.collect.Multimaps.TransformedEntriesMultimap.3 */
        class C05743 implements Function<Map.Entry<K, V1>, V2> {
            C05743() {
            }

            public V2 apply(Map.Entry<K, V1> entry) {
                return TransformedEntriesMultimap.this.transformer.transformEntry(entry.getKey(), entry.getValue());
            }
        }

        private class TransformedEntries extends TransformedCollection<Map.Entry<K, V1>, Map.Entry<K, V2>> {

            /* renamed from: com.google.common.collect.Multimaps.TransformedEntriesMultimap.TransformedEntries.1 */
            class C05761 implements Function<Map.Entry<K, V1>, Map.Entry<K, V2>> {
                final /* synthetic */ TransformedEntriesMultimap val$this$0;
                final /* synthetic */ EntryTransformer val$transformer;

                /* renamed from: com.google.common.collect.Multimaps.TransformedEntriesMultimap.TransformedEntries.1.1 */
                class C05751 extends AbstractMapEntry<K, V2> {
                    final /* synthetic */ Map.Entry val$entry;

                    C05751(Map.Entry entry) {
                        this.val$entry = entry;
                    }

                    public K getKey() {
                        return this.val$entry.getKey();
                    }

                    public V2 getValue() {
                        return C05761.this.val$transformer.transformEntry(this.val$entry.getKey(), this.val$entry.getValue());
                    }
                }

                C05761(TransformedEntriesMultimap transformedEntriesMultimap, EntryTransformer entryTransformer) {
                    this.val$this$0 = transformedEntriesMultimap;
                    this.val$transformer = entryTransformer;
                }

                public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
                    return new C05751(entry);
                }
            }

            TransformedEntries(EntryTransformer<? super K, ? super V1, V2> transformer) {
                super(TransformedEntriesMultimap.this.fromMultimap.entries(), new C05761(TransformedEntriesMultimap.this, transformer));
            }

            public boolean contains(Object o) {
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> entry = (Map.Entry) o;
                return TransformedEntriesMultimap.this.containsEntry(entry.getKey(), entry.getValue());
            }

            public boolean remove(Object o) {
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> entry = (Map.Entry) o;
                return TransformedEntriesMultimap.this.get(entry.getKey()).remove(entry.getValue());
            }
        }

        TransformedEntriesMultimap(Multimap<K, V1> fromMultimap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            this.fromMultimap = (Multimap) Preconditions.checkNotNull(fromMultimap);
            this.transformer = (EntryTransformer) Preconditions.checkNotNull(transformer);
        }

        Collection<V2> transform(K key, Collection<V1> values) {
            return Collections2.transform(values, new C05721(key));
        }

        public Map<K, Collection<V2>> asMap() {
            if (this.asMap != null) {
                return this.asMap;
            }
            Map<K, Collection<V2>> aM = Maps.transformEntries(this.fromMultimap.asMap(), new C05732());
            this.asMap = aM;
            return aM;
        }

        public void clear() {
            this.fromMultimap.clear();
        }

        public boolean containsEntry(Object key, Object value) {
            return get(key).contains(value);
        }

        public boolean containsKey(Object key) {
            return this.fromMultimap.containsKey(key);
        }

        public boolean containsValue(Object value) {
            return values().contains(value);
        }

        public Collection<Map.Entry<K, V2>> entries() {
            if (this.entries != null) {
                return this.entries;
            }
            Collection<Map.Entry<K, V2>> es = new TransformedEntries(this.transformer);
            this.entries = es;
            return es;
        }

        public Collection<V2> get(K key) {
            return transform(key, this.fromMultimap.get(key));
        }

        public boolean isEmpty() {
            return this.fromMultimap.isEmpty();
        }

        public Set<K> keySet() {
            return this.fromMultimap.keySet();
        }

        public Multiset<K> keys() {
            return this.fromMultimap.keys();
        }

        public boolean put(K k, V2 v2) {
            throw new UnsupportedOperationException();
        }

        public boolean putAll(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        public boolean putAll(Multimap<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object key, Object value) {
            return get(key).remove(value);
        }

        public Collection<V2> removeAll(Object key) {
            return transform(key, this.fromMultimap.removeAll(key));
        }

        public Collection<V2> replaceValues(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.fromMultimap.size();
        }

        public Collection<V2> values() {
            if (this.values != null) {
                return this.values;
            }
            Collection<V2> vs = Collections2.transform(this.fromMultimap.entries(), new C05743());
            this.values = vs;
            return vs;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Multimap)) {
                return false;
            }
            return asMap().equals(((Multimap) obj).asMap());
        }

        public int hashCode() {
            return asMap().hashCode();
        }

        public String toString() {
            return asMap().toString();
        }
    }

    private static final class TransformedEntriesListMultimap<K, V1, V2> extends TransformedEntriesMultimap<K, V1, V2> implements ListMultimap<K, V2> {

        /* renamed from: com.google.common.collect.Multimaps.TransformedEntriesListMultimap.1 */
        class C05711 implements Function<V1, V2> {
            final /* synthetic */ Object val$key;

            C05711(Object obj) {
                this.val$key = obj;
            }

            public V2 apply(V1 value) {
                return TransformedEntriesListMultimap.this.transformer.transformEntry(this.val$key, value);
            }
        }

        TransformedEntriesListMultimap(ListMultimap<K, V1> fromMultimap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            super(fromMultimap, transformer);
        }

        List<V2> transform(K key, Collection<V1> values) {
            return Lists.transform((List) values, new C05711(key));
        }

        public List<V2> get(K key) {
            return transform((Object) key, this.fromMultimap.get(key));
        }

        public List<V2> removeAll(Object key) {
            return transform(key, this.fromMultimap.removeAll(key));
        }

        public List<V2> replaceValues(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    static class UnmodifiableAsMapEntries<K, V> extends ForwardingSet<Map.Entry<K, Collection<V>>> {
        private final Set<Map.Entry<K, Collection<V>>> delegate;

        /* renamed from: com.google.common.collect.Multimaps.UnmodifiableAsMapEntries.1 */
        class C05771 extends ForwardingIterator<Map.Entry<K, Collection<V>>> {
            final /* synthetic */ Iterator val$iterator;

            C05771(Iterator it) {
                this.val$iterator = it;
            }

            protected Iterator<Map.Entry<K, Collection<V>>> delegate() {
                return this.val$iterator;
            }

            public Map.Entry<K, Collection<V>> next() {
                return Multimaps.unmodifiableAsMapEntry((Map.Entry) this.val$iterator.next());
            }
        }

        UnmodifiableAsMapEntries(Set<Map.Entry<K, Collection<V>>> delegate) {
            this.delegate = delegate;
        }

        protected Set<Map.Entry<K, Collection<V>>> delegate() {
            return this.delegate;
        }

        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new C05771(this.delegate.iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] array) {
            return standardToArray(array);
        }

        public boolean contains(Object o) {
            return Maps.containsEntryImpl(delegate(), o);
        }

        public boolean containsAll(Collection<?> c) {
            return standardContainsAll(c);
        }

        public boolean equals(@Nullable Object object) {
            return standardEquals(object);
        }
    }

    private static class UnmodifiableAsMapValues<V> extends ForwardingCollection<Collection<V>> {
        final Collection<Collection<V>> delegate;

        /* renamed from: com.google.common.collect.Multimaps.UnmodifiableAsMapValues.1 */
        class C05781 implements Iterator<Collection<V>> {
            final /* synthetic */ Iterator val$iterator;

            C05781(Iterator it) {
                this.val$iterator = it;
            }

            public boolean hasNext() {
                return this.val$iterator.hasNext();
            }

            public Collection<V> next() {
                return Multimaps.unmodifiableValueCollection((Collection) this.val$iterator.next());
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        UnmodifiableAsMapValues(Collection<Collection<V>> delegate) {
            this.delegate = Collections.unmodifiableCollection(delegate);
        }

        protected Collection<Collection<V>> delegate() {
            return this.delegate;
        }

        public Iterator<Collection<V>> iterator() {
            return new C05781(this.delegate.iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] array) {
            return standardToArray(array);
        }

        public boolean contains(Object o) {
            return standardContains(o);
        }

        public boolean containsAll(Collection<?> c) {
            return standardContainsAll(c);
        }
    }

    private static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multimap<K, V> delegate;
        transient Collection<Map.Entry<K, V>> entries;
        transient Set<K> keySet;
        transient Multiset<K> keys;
        transient Map<K, Collection<V>> map;
        transient Collection<V> values;

        /* renamed from: com.google.common.collect.Multimaps.UnmodifiableMultimap.1 */
        class C05791 extends ForwardingMap<K, Collection<V>> {
            Collection<Collection<V>> asMapValues;
            Set<Map.Entry<K, Collection<V>>> entrySet;
            final /* synthetic */ Map val$unmodifiableMap;

            C05791(Map map) {
                this.val$unmodifiableMap = map;
            }

            protected Map<K, Collection<V>> delegate() {
                return this.val$unmodifiableMap;
            }

            public Set<Map.Entry<K, Collection<V>>> entrySet() {
                Set<Map.Entry<K, Collection<V>>> set = this.entrySet;
                if (set != null) {
                    return set;
                }
                set = Multimaps.unmodifiableAsMapEntries(this.val$unmodifiableMap.entrySet());
                this.entrySet = set;
                return set;
            }

            public Collection<V> get(Object key) {
                Collection<V> collection = (Collection) this.val$unmodifiableMap.get(key);
                return collection == null ? null : Multimaps.unmodifiableValueCollection(collection);
            }

            public Collection<Collection<V>> values() {
                Collection<Collection<V>> collection = this.asMapValues;
                if (collection != null) {
                    return collection;
                }
                collection = new UnmodifiableAsMapValues(this.val$unmodifiableMap.values());
                this.asMapValues = collection;
                return collection;
            }

            public boolean containsValue(Object o) {
                return values().contains(o);
            }
        }

        UnmodifiableMultimap(Multimap<K, V> delegate) {
            this.delegate = (Multimap) Preconditions.checkNotNull(delegate);
        }

        protected Multimap<K, V> delegate() {
            return this.delegate;
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> result = this.map;
            if (result != null) {
                return result;
            }
            result = new C05791(Collections.unmodifiableMap(this.delegate.asMap()));
            this.map = result;
            return result;
        }

        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> result = this.entries;
            if (result != null) {
                return result;
            }
            result = Multimaps.unmodifiableEntries(this.delegate.entries());
            this.entries = result;
            return result;
        }

        public Collection<V> get(K key) {
            return Multimaps.unmodifiableValueCollection(this.delegate.get(key));
        }

        public Multiset<K> keys() {
            Multiset<K> result = this.keys;
            if (result != null) {
                return result;
            }
            result = Multisets.unmodifiableMultiset(this.delegate.keys());
            this.keys = result;
            return result;
        }

        public Set<K> keySet() {
            Set<K> result = this.keySet;
            if (result != null) {
                return result;
            }
            result = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = result;
            return result;
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

        public Collection<V> removeAll(Object key) {
            throw new UnsupportedOperationException();
        }

        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public Collection<V> values() {
            Collection<V> result = this.values;
            if (result != null) {
                return result;
            }
            result = Collections.unmodifiableCollection(this.delegate.values());
            this.values = result;
            return result;
        }
    }

    private static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        UnmodifiableListMultimap(ListMultimap<K, V> delegate) {
            super(delegate);
        }

        public ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }

        public List<V> get(K key) {
            return Collections.unmodifiableList(delegate().get(key));
        }

        public List<V> removeAll(Object key) {
            throw new UnsupportedOperationException();
        }

        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        UnmodifiableSetMultimap(SetMultimap<K, V> delegate) {
            super(delegate);
        }

        public SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }

        public Set<V> get(K key) {
            return Collections.unmodifiableSet(delegate().get(key));
        }

        public Set<Map.Entry<K, V>> entries() {
            return Maps.unmodifiableEntrySet(delegate().entries());
        }

        public Set<V> removeAll(Object key) {
            throw new UnsupportedOperationException();
        }

        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> delegate) {
            super(delegate);
        }

        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }

        public SortedSet<V> get(K key) {
            return Collections.unmodifiableSortedSet(delegate().get(key));
        }

        public SortedSet<V> removeAll(Object key) {
            throw new UnsupportedOperationException();
        }

        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }
    }

    private Multimaps() {
    }

    public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> factory) {
        return new CustomMultimap(map, factory);
    }

    public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> factory) {
        return new CustomListMultimap(map, factory);
    }

    public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> factory) {
        return new CustomSetMultimap(map, factory);
    }

    public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> factory) {
        return new CustomSortedSetMultimap(map, factory);
    }

    public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> source, M dest) {
        Preconditions.checkNotNull(dest);
        for (Map.Entry<? extends V, ? extends K> entry : source.entries()) {
            dest.put(entry.getValue(), entry.getKey());
        }
        return dest;
    }

    public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> multimap) {
        return Synchronized.multimap(multimap, null);
    }

    public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> delegate) {
        return ((delegate instanceof UnmodifiableMultimap) || (delegate instanceof ImmutableMultimap)) ? delegate : new UnmodifiableMultimap(delegate);
    }

    @Deprecated
    public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> delegate) {
        return (Multimap) Preconditions.checkNotNull(delegate);
    }

    public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> multimap) {
        return Synchronized.setMultimap(multimap, null);
    }

    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> delegate) {
        return ((delegate instanceof UnmodifiableSetMultimap) || (delegate instanceof ImmutableSetMultimap)) ? delegate : new UnmodifiableSetMultimap(delegate);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> delegate) {
        return (SetMultimap) Preconditions.checkNotNull(delegate);
    }

    public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> multimap) {
        return Synchronized.sortedSetMultimap(multimap, null);
    }

    public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> delegate) {
        return delegate instanceof UnmodifiableSortedSetMultimap ? delegate : new UnmodifiableSortedSetMultimap(delegate);
    }

    public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> multimap) {
        return Synchronized.listMultimap(multimap, null);
    }

    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> delegate) {
        return ((delegate instanceof UnmodifiableListMultimap) || (delegate instanceof ImmutableListMultimap)) ? delegate : new UnmodifiableListMultimap(delegate);
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> delegate) {
        return (ListMultimap) Preconditions.checkNotNull(delegate);
    }

    private static <V> Collection<V> unmodifiableValueCollection(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    private static <K, V> Map.Entry<K, Collection<V>> unmodifiableAsMapEntry(Map.Entry<K, Collection<V>> entry) {
        Preconditions.checkNotNull(entry);
        return new C05521(entry);
    }

    private static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> entries) {
        if (entries instanceof Set) {
            return Maps.unmodifiableEntrySet((Set) entries);
        }
        return new UnmodifiableEntries(Collections.unmodifiableCollection(entries));
    }

    private static <K, V> Set<Map.Entry<K, Collection<V>>> unmodifiableAsMapEntries(Set<Map.Entry<K, Collection<V>>> asMapEntries) {
        return new UnmodifiableAsMapEntries(Collections.unmodifiableSet(asMapEntries));
    }

    public static <K, V> SetMultimap<K, V> forMap(Map<K, V> map) {
        return new MapMultimap(map);
    }

    @Beta
    public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> fromMultimap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries((Multimap) fromMultimap, new C05532(function));
    }

    @Beta
    public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesMultimap(fromMap, transformer);
    }

    @Beta
    public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> fromMultimap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries((ListMultimap) fromMultimap, new C05543(function));
    }

    @Beta
    public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesListMultimap(fromMap, transformer);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> values, Function<? super V, K> keyFunction) {
        return index(values.iterator(), (Function) keyFunction);
    }

    @Deprecated
    @Beta
    public static <K, V, I extends Iterable<V> & Iterator<V>> ImmutableListMultimap<K, V> index(I values, Function<? super V, K> keyFunction) {
        return index((Iterable) Preconditions.checkNotNull(values), (Function) keyFunction);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> values, Function<? super V, K> keyFunction) {
        Preconditions.checkNotNull(keyFunction);
        Builder<K, V> builder = ImmutableListMultimap.builder();
        while (values.hasNext()) {
            Object value = values.next();
            Preconditions.checkNotNull(value, values);
            builder.put(keyFunction.apply(value), value);
        }
        return builder.build();
    }

    @GwtIncompatible("untested")
    @Beta
    public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        Preconditions.checkNotNull(keyPredicate);
        return filterEntries(unfiltered, new C05554(keyPredicate));
    }

    @GwtIncompatible("untested")
    @Beta
    public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        Preconditions.checkNotNull(valuePredicate);
        return filterEntries(unfiltered, new C05565(valuePredicate));
    }

    @GwtIncompatible("untested")
    @Beta
    public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof FilteredMultimap ? filterFiltered((FilteredMultimap) unfiltered, entryPredicate) : new FilteredMultimap((Multimap) Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    private static <K, V> Multimap<K, V> filterFiltered(FilteredMultimap<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        return new FilteredMultimap(map.unfiltered, Predicates.and(map.predicate, entryPredicate));
    }
}
