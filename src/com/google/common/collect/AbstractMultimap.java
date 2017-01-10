package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap$WrappedCollection.WrappedIterator;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractMultimap<K, V> implements Multimap<K, V>, Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> asMap;
    private transient Collection<Entry<K, V>> entries;
    private transient Set<K> keySet;
    private transient Map<K, Collection<V>> map;
    private transient Multiset<K> multiset;
    private transient int totalSize;
    private transient Collection<V> valuesCollection;

    /* renamed from: com.google.common.collect.AbstractMultimap.1 */
    class C04081 extends Keys<K, V> {
        C04081() {
        }

        Multimap<K, V> multimap() {
            return AbstractMultimap.this;
        }
    }

    /* renamed from: com.google.common.collect.AbstractMultimap.2 */
    class C04092 extends Values<K, V> {
        C04092() {
        }

        Multimap<K, V> multimap() {
            return AbstractMultimap.this;
        }
    }

    /* renamed from: com.google.common.collect.AbstractMultimap.3 */
    class C04103 extends EntrySet<K, V> {
        C04103() {
        }

        Multimap<K, V> multimap() {
            return AbstractMultimap.this;
        }

        public Iterator<Entry<K, V>> iterator() {
            return AbstractMultimap.this.createEntryIterator();
        }
    }

    /* renamed from: com.google.common.collect.AbstractMultimap.4 */
    class C04114 extends Entries<K, V> {
        C04114() {
        }

        Multimap<K, V> multimap() {
            return AbstractMultimap.this;
        }

        public Iterator<Entry<K, V>> iterator() {
            return AbstractMultimap.this.createEntryIterator();
        }
    }

    private class AsMap extends AbstractMap<K, Collection<V>> {
        transient Set<Entry<K, Collection<V>>> entrySet;
        final transient Map<K, Collection<V>> submap;

        class AsMapEntries extends EntrySet<K, Collection<V>> {
            AsMapEntries() {
            }

            Map<K, Collection<V>> map() {
                return AsMap.this;
            }

            public Iterator<Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator();
            }

            public boolean contains(Object o) {
                return Collections2.safeContains(AsMap.this.submap.entrySet(), o);
            }

            public boolean remove(Object o) {
                if (!contains(o)) {
                    return false;
                }
                AbstractMultimap.this.removeValuesForKey(((Entry) o).getKey());
                return true;
            }
        }

        class AsMapIterator implements Iterator<Entry<K, Collection<V>>> {
            Collection<V> collection;
            final Iterator<Entry<K, Collection<V>>> delegateIterator;

            AsMapIterator() {
                this.delegateIterator = AsMap.this.submap.entrySet().iterator();
            }

            public boolean hasNext() {
                return this.delegateIterator.hasNext();
            }

            public Entry<K, Collection<V>> next() {
                Entry<K, Collection<V>> entry = (Entry) this.delegateIterator.next();
                K key = entry.getKey();
                this.collection = (Collection) entry.getValue();
                return Maps.immutableEntry(key, AbstractMultimap.this.wrapCollection(key, this.collection));
            }

            public void remove() {
                this.delegateIterator.remove();
                AbstractMultimap.access$220(AbstractMultimap.this, this.collection.size());
                this.collection.clear();
            }
        }

        AsMap(Map<K, Collection<V>> submap) {
            this.submap = submap;
        }

        public Set<Entry<K, Collection<V>>> entrySet() {
            Set<Entry<K, Collection<V>>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            set = new AsMapEntries();
            this.entrySet = set;
            return set;
        }

        public boolean containsKey(Object key) {
            return Maps.safeContainsKey(this.submap, key);
        }

        public Collection<V> get(Object key) {
            Collection<V> collection = (Collection) Maps.safeGet(this.submap, key);
            if (collection == null) {
                return null;
            }
            return AbstractMultimap.this.wrapCollection(key, collection);
        }

        public Set<K> keySet() {
            return AbstractMultimap.this.keySet();
        }

        public int size() {
            return this.submap.size();
        }

        public Collection<V> remove(Object key) {
            Collection<V> collection = (Collection) this.submap.remove(key);
            if (collection == null) {
                return null;
            }
            Collection<V> output = AbstractMultimap.this.createCollection();
            output.addAll(collection);
            AbstractMultimap.access$220(AbstractMultimap.this, collection.size());
            collection.clear();
            return output;
        }

        public boolean equals(@Nullable Object object) {
            return this == object || this.submap.equals(object);
        }

        public int hashCode() {
            return this.submap.hashCode();
        }

        public String toString() {
            return this.submap.toString();
        }

        public void clear() {
            if (this.submap == AbstractMultimap.this.map) {
                AbstractMultimap.this.clear();
            } else {
                Iterators.clear(new AsMapIterator());
            }
        }
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {
        Collection<V> collection;
        K key;
        final Iterator<Entry<K, Collection<V>>> keyIterator;
        Iterator<V> valueIterator;

        EntryIterator() {
            this.keyIterator = AbstractMultimap.this.map.entrySet().iterator();
            if (this.keyIterator.hasNext()) {
                findValueIteratorAndKey();
            } else {
                this.valueIterator = Iterators.emptyModifiableIterator();
            }
        }

        void findValueIteratorAndKey() {
            Entry<K, Collection<V>> entry = (Entry) this.keyIterator.next();
            this.key = entry.getKey();
            this.collection = (Collection) entry.getValue();
            this.valueIterator = this.collection.iterator();
        }

        public boolean hasNext() {
            return this.keyIterator.hasNext() || this.valueIterator.hasNext();
        }

        public Entry<K, V> next() {
            if (!this.valueIterator.hasNext()) {
                findValueIteratorAndKey();
            }
            return Maps.immutableEntry(this.key, this.valueIterator.next());
        }

        public void remove() {
            this.valueIterator.remove();
            if (this.collection.isEmpty()) {
                this.keyIterator.remove();
            }
            AbstractMultimap.this.totalSize = AbstractMultimap.this.totalSize - 1;
        }
    }

    private class KeySet extends KeySet<K, Collection<V>> {
        final Map<K, Collection<V>> subMap;

        /* renamed from: com.google.common.collect.AbstractMultimap.KeySet.1 */
        class C04121 implements Iterator<K> {
            Entry<K, Collection<V>> entry;
            final Iterator<Entry<K, Collection<V>>> entryIterator;

            C04121() {
                this.entryIterator = KeySet.this.subMap.entrySet().iterator();
            }

            public boolean hasNext() {
                return this.entryIterator.hasNext();
            }

            public K next() {
                this.entry = (Entry) this.entryIterator.next();
                return this.entry.getKey();
            }

            public void remove() {
                Preconditions.checkState(this.entry != null);
                Collection<V> collection = (Collection) this.entry.getValue();
                this.entryIterator.remove();
                AbstractMultimap.access$220(AbstractMultimap.this, collection.size());
                collection.clear();
            }
        }

        KeySet(Map<K, Collection<V>> subMap) {
            this.subMap = subMap;
        }

        Map<K, Collection<V>> map() {
            return this.subMap;
        }

        public Iterator<K> iterator() {
            return new C04121();
        }

        public boolean remove(Object key) {
            int count = 0;
            Collection<V> collection = (Collection) this.subMap.remove(key);
            if (collection != null) {
                count = collection.size();
                collection.clear();
                AbstractMultimap.access$220(AbstractMultimap.this, count);
            }
            return count > 0;
        }

        public void clear() {
            Iterators.clear(iterator());
        }

        public boolean containsAll(Collection<?> c) {
            return this.subMap.keySet().containsAll(c);
        }

        public boolean equals(@Nullable Object object) {
            return this == object || this.subMap.keySet().equals(object);
        }

        public int hashCode() {
            return this.subMap.keySet().hashCode();
        }
    }

    private class WrappedCollection extends AbstractCollection<V> {
        final WrappedCollection ancestor;
        final Collection<V> ancestorDelegate;
        Collection<V> delegate;
        final K key;

        class WrappedIterator implements Iterator<V> {
            final Iterator<V> delegateIterator;
            final Collection<V> originalDelegate;

            WrappedIterator() {
                this.originalDelegate = WrappedCollection.this.delegate;
                this.delegateIterator = AbstractMultimap.this.iteratorOrListIterator(WrappedCollection.this.delegate);
            }

            WrappedIterator(Iterator<V> delegateIterator) {
                this.originalDelegate = WrappedCollection.this.delegate;
                this.delegateIterator = delegateIterator;
            }

            void validateIterator() {
                WrappedCollection.this.refreshIfEmpty();
                if (WrappedCollection.this.delegate != this.originalDelegate) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                validateIterator();
                return this.delegateIterator.hasNext();
            }

            public V next() {
                validateIterator();
                return this.delegateIterator.next();
            }

            public void remove() {
                this.delegateIterator.remove();
                this.this$0.totalSize = AbstractMultimap.this.totalSize - 1;
                WrappedCollection.this.removeIfEmpty();
            }

            Iterator<V> getDelegateIterator() {
                validateIterator();
                return this.delegateIterator;
            }
        }

        WrappedCollection(@Nullable K key, Collection<V> delegate, @Nullable WrappedCollection ancestor) {
            this.key = key;
            this.delegate = delegate;
            this.ancestor = ancestor;
            this.ancestorDelegate = ancestor == null ? null : ancestor.getDelegate();
        }

        void refreshIfEmpty() {
            if (this.ancestor != null) {
                this.ancestor.refreshIfEmpty();
                if (this.ancestor.getDelegate() != this.ancestorDelegate) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.delegate.isEmpty()) {
                Collection<V> newDelegate = (Collection) AbstractMultimap.this.map.get(this.key);
                if (newDelegate != null) {
                    this.delegate = newDelegate;
                }
            }
        }

        void removeIfEmpty() {
            if (this.ancestor != null) {
                this.ancestor.removeIfEmpty();
            } else if (this.delegate.isEmpty()) {
                AbstractMultimap.this.map.remove(this.key);
            }
        }

        K getKey() {
            return this.key;
        }

        void addToMap() {
            if (this.ancestor != null) {
                this.ancestor.addToMap();
            } else {
                AbstractMultimap.this.map.put(this.key, this.delegate);
            }
        }

        public int size() {
            refreshIfEmpty();
            return this.delegate.size();
        }

        public boolean equals(@Nullable Object object) {
            if (object == this) {
                return true;
            }
            refreshIfEmpty();
            return this.delegate.equals(object);
        }

        public int hashCode() {
            refreshIfEmpty();
            return this.delegate.hashCode();
        }

        public String toString() {
            refreshIfEmpty();
            return this.delegate.toString();
        }

        Collection<V> getDelegate() {
            return this.delegate;
        }

        public Iterator<V> iterator() {
            refreshIfEmpty();
            return new WrappedIterator();
        }

        public boolean add(V value) {
            refreshIfEmpty();
            boolean wasEmpty = this.delegate.isEmpty();
            boolean changed = this.delegate.add(value);
            if (changed) {
                AbstractMultimap.this.totalSize = AbstractMultimap.this.totalSize + 1;
                if (wasEmpty) {
                    addToMap();
                }
            }
            return changed;
        }

        WrappedCollection getAncestor() {
            return this.ancestor;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int oldSize = size();
            boolean changed = this.delegate.addAll(collection);
            if (!changed) {
                return changed;
            }
            AbstractMultimap.access$212(AbstractMultimap.this, this.delegate.size() - oldSize);
            if (oldSize != 0) {
                return changed;
            }
            addToMap();
            return changed;
        }

        public boolean contains(Object o) {
            refreshIfEmpty();
            return this.delegate.contains(o);
        }

        public boolean containsAll(Collection<?> c) {
            refreshIfEmpty();
            return this.delegate.containsAll(c);
        }

        public void clear() {
            int oldSize = size();
            if (oldSize != 0) {
                this.delegate.clear();
                AbstractMultimap.access$220(AbstractMultimap.this, oldSize);
                removeIfEmpty();
            }
        }

        public boolean remove(Object o) {
            refreshIfEmpty();
            boolean changed = this.delegate.remove(o);
            if (changed) {
                this.this$0.totalSize = AbstractMultimap.this.totalSize - 1;
                removeIfEmpty();
            }
            return changed;
        }

        public boolean removeAll(Collection<?> c) {
            if (c.isEmpty()) {
                return false;
            }
            int oldSize = size();
            boolean changed = this.delegate.removeAll(c);
            if (!changed) {
                return changed;
            }
            AbstractMultimap.access$212(AbstractMultimap.this, this.delegate.size() - oldSize);
            removeIfEmpty();
            return changed;
        }

        public boolean retainAll(Collection<?> c) {
            Preconditions.checkNotNull(c);
            int oldSize = size();
            boolean changed = this.delegate.retainAll(c);
            if (changed) {
                AbstractMultimap.access$212(AbstractMultimap.this, this.delegate.size() - oldSize);
                removeIfEmpty();
            }
            return changed;
        }
    }

    private class WrappedList extends WrappedCollection implements List<V> {

        private class WrappedListIterator extends WrappedIterator implements ListIterator<V> {
            WrappedListIterator() {
                super();
            }

            public WrappedListIterator(int index) {
                super(WrappedList.this.getListDelegate().listIterator(index));
            }

            private ListIterator<V> getDelegateListIterator() {
                return (ListIterator) getDelegateIterator();
            }

            public boolean hasPrevious() {
                return getDelegateListIterator().hasPrevious();
            }

            public V previous() {
                return getDelegateListIterator().previous();
            }

            public int nextIndex() {
                return getDelegateListIterator().nextIndex();
            }

            public int previousIndex() {
                return getDelegateListIterator().previousIndex();
            }

            public void set(V value) {
                getDelegateListIterator().set(value);
            }

            public void add(V value) {
                boolean wasEmpty = WrappedList.this.isEmpty();
                getDelegateListIterator().add(value);
                this.this$0.totalSize = AbstractMultimap.this.totalSize + 1;
                if (wasEmpty) {
                    WrappedList.this.addToMap();
                }
            }
        }

        WrappedList(@Nullable K key, List<V> delegate, @Nullable WrappedCollection ancestor) {
            super(key, delegate, ancestor);
        }

        List<V> getListDelegate() {
            return (List) getDelegate();
        }

        public boolean addAll(int index, Collection<? extends V> c) {
            if (c.isEmpty()) {
                return false;
            }
            int oldSize = size();
            boolean changed = getListDelegate().addAll(index, c);
            if (!changed) {
                return changed;
            }
            AbstractMultimap.access$212(AbstractMultimap.this, getDelegate().size() - oldSize);
            if (oldSize != 0) {
                return changed;
            }
            addToMap();
            return changed;
        }

        public V get(int index) {
            refreshIfEmpty();
            return getListDelegate().get(index);
        }

        public V set(int index, V element) {
            refreshIfEmpty();
            return getListDelegate().set(index, element);
        }

        public void add(int index, V element) {
            refreshIfEmpty();
            boolean wasEmpty = getDelegate().isEmpty();
            getListDelegate().add(index, element);
            this.this$0.totalSize = AbstractMultimap.this.totalSize + 1;
            if (wasEmpty) {
                addToMap();
            }
        }

        public V remove(int index) {
            refreshIfEmpty();
            V value = getListDelegate().remove(index);
            this.this$0.totalSize = AbstractMultimap.this.totalSize - 1;
            removeIfEmpty();
            return value;
        }

        public int indexOf(Object o) {
            refreshIfEmpty();
            return getListDelegate().indexOf(o);
        }

        public int lastIndexOf(Object o) {
            refreshIfEmpty();
            return getListDelegate().lastIndexOf(o);
        }

        public ListIterator<V> listIterator() {
            refreshIfEmpty();
            return new WrappedListIterator();
        }

        public ListIterator<V> listIterator(int index) {
            refreshIfEmpty();
            return new WrappedListIterator(index);
        }

        public List<V> subList(int fromIndex, int toIndex) {
            WrappedList this;
            refreshIfEmpty();
            AbstractMultimap abstractMultimap = AbstractMultimap.this;
            Object key = getKey();
            List subList = getListDelegate().subList(fromIndex, toIndex);
            if (getAncestor() != null) {
                this = getAncestor();
            }
            return abstractMultimap.wrapList(key, subList, this);
        }
    }

    private class RandomAccessWrappedList extends WrappedList implements RandomAccess {
        RandomAccessWrappedList(@Nullable K key, List<V> delegate, @Nullable WrappedCollection ancestor) {
            super(key, delegate, ancestor);
        }
    }

    private class SortedAsMap extends AsMap implements SortedMap<K, Collection<V>> {
        SortedSet<K> sortedKeySet;

        SortedAsMap(SortedMap<K, Collection<V>> submap) {
            super(submap);
        }

        SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap) this.submap;
        }

        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        public K firstKey() {
            return sortedMap().firstKey();
        }

        public K lastKey() {
            return sortedMap().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(K toKey) {
            return new SortedAsMap(sortedMap().headMap(toKey));
        }

        public SortedMap<K, Collection<V>> subMap(K fromKey, K toKey) {
            return new SortedAsMap(sortedMap().subMap(fromKey, toKey));
        }

        public SortedMap<K, Collection<V>> tailMap(K fromKey) {
            return new SortedAsMap(sortedMap().tailMap(fromKey));
        }

        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.sortedKeySet;
            if (sortedSet != null) {
                return sortedSet;
            }
            sortedSet = new SortedKeySet(sortedMap());
            this.sortedKeySet = sortedSet;
            return sortedSet;
        }
    }

    private class SortedKeySet extends KeySet implements SortedSet<K> {
        SortedKeySet(SortedMap<K, Collection<V>> subMap) {
            super(subMap);
        }

        SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap) this.subMap;
        }

        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        public K first() {
            return sortedMap().firstKey();
        }

        public SortedSet<K> headSet(K toElement) {
            return new SortedKeySet(sortedMap().headMap(toElement));
        }

        public K last() {
            return sortedMap().lastKey();
        }

        public SortedSet<K> subSet(K fromElement, K toElement) {
            return new SortedKeySet(sortedMap().subMap(fromElement, toElement));
        }

        public SortedSet<K> tailSet(K fromElement) {
            return new SortedKeySet(sortedMap().tailMap(fromElement));
        }
    }

    private class WrappedSet extends WrappedCollection implements Set<V> {
        WrappedSet(@Nullable K key, Set<V> delegate) {
            super(key, delegate, null);
        }
    }

    private class WrappedSortedSet extends WrappedCollection implements SortedSet<V> {
        WrappedSortedSet(@Nullable K key, SortedSet<V> delegate, @Nullable WrappedCollection ancestor) {
            super(key, delegate, ancestor);
        }

        SortedSet<V> getSortedSetDelegate() {
            return (SortedSet) getDelegate();
        }

        public Comparator<? super V> comparator() {
            return getSortedSetDelegate().comparator();
        }

        public V first() {
            refreshIfEmpty();
            return getSortedSetDelegate().first();
        }

        public V last() {
            refreshIfEmpty();
            return getSortedSetDelegate().last();
        }

        public SortedSet<V> headSet(V toElement) {
            WrappedSortedSet this;
            refreshIfEmpty();
            AbstractMultimap abstractMultimap = AbstractMultimap.this;
            Object key = getKey();
            SortedSet headSet = getSortedSetDelegate().headSet(toElement);
            if (getAncestor() != null) {
                this = getAncestor();
            }
            return new WrappedSortedSet(key, headSet, this);
        }

        public SortedSet<V> subSet(V fromElement, V toElement) {
            WrappedSortedSet this;
            refreshIfEmpty();
            AbstractMultimap abstractMultimap = AbstractMultimap.this;
            Object key = getKey();
            SortedSet subSet = getSortedSetDelegate().subSet(fromElement, toElement);
            if (getAncestor() != null) {
                this = getAncestor();
            }
            return new WrappedSortedSet(key, subSet, this);
        }

        public SortedSet<V> tailSet(V fromElement) {
            WrappedSortedSet this;
            refreshIfEmpty();
            AbstractMultimap abstractMultimap = AbstractMultimap.this;
            Object key = getKey();
            SortedSet tailSet = getSortedSetDelegate().tailSet(fromElement);
            if (getAncestor() != null) {
                this = getAncestor();
            }
            return new WrappedSortedSet(key, tailSet, this);
        }
    }

    abstract Collection<V> createCollection();

    static /* synthetic */ int access$212(AbstractMultimap x0, int x1) {
        int i = x0.totalSize + x1;
        x0.totalSize = i;
        return i;
    }

    static /* synthetic */ int access$220(AbstractMultimap x0, int x1) {
        int i = x0.totalSize - x1;
        x0.totalSize = i;
        return i;
    }

    protected AbstractMultimap(Map<K, Collection<V>> map) {
        Preconditions.checkArgument(map.isEmpty());
        this.map = map;
    }

    final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> values : map.values()) {
            boolean z;
            if (values.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z);
            this.totalSize += values.size();
        }
    }

    Collection<V> createCollection(@Nullable K k) {
        return createCollection();
    }

    Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    public int size() {
        return this.totalSize;
    }

    public boolean isEmpty() {
        return this.totalSize == 0;
    }

    public boolean containsKey(@Nullable Object key) {
        return this.map.containsKey(key);
    }

    public boolean containsValue(@Nullable Object value) {
        for (Collection<V> collection : this.map.values()) {
            if (collection.contains(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsEntry(@Nullable Object key, @Nullable Object value) {
        Collection<V> collection = (Collection) this.map.get(key);
        return collection != null && collection.contains(value);
    }

    public boolean put(@Nullable K key, @Nullable V value) {
        if (!getOrCreateCollection(key).add(value)) {
            return false;
        }
        this.totalSize++;
        return true;
    }

    private Collection<V> getOrCreateCollection(@Nullable K key) {
        Collection<V> collection = (Collection) this.map.get(key);
        if (collection != null) {
            return collection;
        }
        collection = createCollection(key);
        this.map.put(key, collection);
        return collection;
    }

    public boolean remove(@Nullable Object key, @Nullable Object value) {
        Collection<V> collection = (Collection) this.map.get(key);
        if (collection == null) {
            return false;
        }
        boolean changed = collection.remove(value);
        if (!changed) {
            return changed;
        }
        this.totalSize--;
        if (!collection.isEmpty()) {
            return changed;
        }
        this.map.remove(key);
        return changed;
    }

    public boolean putAll(@Nullable K key, Iterable<? extends V> values) {
        if (!values.iterator().hasNext()) {
            return false;
        }
        Collection<V> collection = getOrCreateCollection(key);
        int oldSize = collection.size();
        boolean changed = false;
        if (values instanceof Collection) {
            changed = collection.addAll(Collections2.cast(values));
        } else {
            for (V value : values) {
                changed |= collection.add(value);
            }
        }
        this.totalSize += collection.size() - oldSize;
        return changed;
    }

    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        boolean changed = false;
        for (Entry<? extends K, ? extends V> entry : multimap.entries()) {
            changed |= put(entry.getKey(), entry.getValue());
        }
        return changed;
    }

    public Collection<V> replaceValues(@Nullable K key, Iterable<? extends V> values) {
        Iterator<? extends V> iterator = values.iterator();
        if (!iterator.hasNext()) {
            return removeAll(key);
        }
        Collection<V> collection = getOrCreateCollection(key);
        Collection<V> oldValues = createCollection();
        oldValues.addAll(collection);
        this.totalSize -= collection.size();
        collection.clear();
        while (iterator.hasNext()) {
            if (collection.add(iterator.next())) {
                this.totalSize++;
            }
        }
        return unmodifiableCollectionSubclass(oldValues);
    }

    public Collection<V> removeAll(@Nullable Object key) {
        Collection<V> collection = (Collection) this.map.remove(key);
        Collection<V> output = createCollection();
        if (collection != null) {
            output.addAll(collection);
            this.totalSize -= collection.size();
            collection.clear();
        }
        return unmodifiableCollectionSubclass(output);
    }

    private Collection<V> unmodifiableCollectionSubclass(Collection<V> collection) {
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

    public void clear() {
        for (Collection<V> collection : this.map.values()) {
            collection.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    public Collection<V> get(@Nullable K key) {
        Collection<V> collection = (Collection) this.map.get(key);
        if (collection == null) {
            collection = createCollection(key);
        }
        return wrapCollection(key, collection);
    }

    private Collection<V> wrapCollection(@Nullable K key, Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return new WrappedSortedSet(key, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new WrappedSet(key, (Set) collection);
        }
        if (collection instanceof List) {
            return wrapList(key, (List) collection, null);
        }
        return new WrappedCollection(key, collection, null);
    }

    private List<V> wrapList(@Nullable K key, List<V> list, @Nullable WrappedCollection ancestor) {
        return list instanceof RandomAccess ? new RandomAccessWrappedList(key, list, ancestor) : new WrappedList(key, list, ancestor);
    }

    private Iterator<V> iteratorOrListIterator(Collection<V> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        set = createKeySet();
        this.keySet = set;
        return set;
    }

    private Set<K> createKeySet() {
        return this.map instanceof SortedMap ? new SortedKeySet((SortedMap) this.map) : new KeySet(this.map);
    }

    public Multiset<K> keys() {
        Multiset<K> multiset = this.multiset;
        if (multiset != null) {
            return multiset;
        }
        multiset = new C04081();
        this.multiset = multiset;
        return multiset;
    }

    private int removeValuesForKey(Object key) {
        try {
            Collection<V> collection = (Collection) this.map.remove(key);
            if (collection == null) {
                return 0;
            }
            int count = collection.size();
            collection.clear();
            this.totalSize -= count;
            return count;
        } catch (NullPointerException e) {
            return 0;
        } catch (ClassCastException e2) {
            return 0;
        }
    }

    public Collection<V> values() {
        Collection<V> collection = this.valuesCollection;
        if (collection != null) {
            return collection;
        }
        collection = new C04092();
        this.valuesCollection = collection;
        return collection;
    }

    public Collection<Entry<K, V>> entries() {
        Collection<Entry<K, V>> collection = this.entries;
        if (collection != null) {
            return collection;
        }
        collection = createEntries();
        this.entries = collection;
        return collection;
    }

    Collection<Entry<K, V>> createEntries() {
        if (this instanceof SetMultimap) {
            return new C04103();
        }
        return new C04114();
    }

    Iterator<Entry<K, V>> createEntryIterator() {
        return new EntryIterator();
    }

    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.asMap;
        if (map != null) {
            return map;
        }
        map = createAsMap();
        this.asMap = map;
        return map;
    }

    private Map<K, Collection<V>> createAsMap() {
        return this.map instanceof SortedMap ? new SortedAsMap((SortedMap) this.map) : new AsMap(this.map);
    }

    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
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
}
