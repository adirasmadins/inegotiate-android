package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible("not needed in emulated source.")
    private static final long serialVersionUID = -2250766705698539974L;
    private transient Map<E, Count> backingMap;
    private transient long size;

    /* renamed from: com.google.common.collect.AbstractMapBasedMultiset.1 */
    class C04061 implements Iterator<Entry<E>> {
        Map.Entry<E, Count> toRemove;
        final /* synthetic */ Iterator val$backingEntries;

        /* renamed from: com.google.common.collect.AbstractMapBasedMultiset.1.1 */
        class C04051 extends AbstractEntry<E> {
            final /* synthetic */ Map.Entry val$mapEntry;

            C04051(Map.Entry entry) {
                this.val$mapEntry = entry;
            }

            public E getElement() {
                return this.val$mapEntry.getKey();
            }

            public int getCount() {
                int count = ((Count) this.val$mapEntry.getValue()).get();
                if (count != 0) {
                    return count;
                }
                Count frequency = (Count) AbstractMapBasedMultiset.this.backingMap.get(getElement());
                if (frequency != null) {
                    return frequency.get();
                }
                return count;
            }
        }

        C04061(Iterator it) {
            this.val$backingEntries = it;
        }

        public boolean hasNext() {
            return this.val$backingEntries.hasNext();
        }

        public Entry<E> next() {
            Map.Entry<E, Count> mapEntry = (Map.Entry) this.val$backingEntries.next();
            this.toRemove = mapEntry;
            return new C04051(mapEntry);
        }

        public void remove() {
            Preconditions.checkState(this.toRemove != null, "no calls to next() since the last call to remove()");
            AbstractMapBasedMultiset.access$122(AbstractMapBasedMultiset.this, (long) ((Count) this.toRemove.getValue()).getAndSet(0));
            this.val$backingEntries.remove();
            this.toRemove = null;
        }
    }

    class MapBasedElementSet extends ForwardingSet<E> {
        private final Set<E> delegate;
        private final Map<E, Count> map;

        /* renamed from: com.google.common.collect.AbstractMapBasedMultiset.MapBasedElementSet.1 */
        class C04071 implements Iterator<E> {
            Map.Entry<E, Count> toRemove;
            final /* synthetic */ Iterator val$entries;

            C04071(Iterator it) {
                this.val$entries = it;
            }

            public boolean hasNext() {
                return this.val$entries.hasNext();
            }

            public E next() {
                this.toRemove = (Map.Entry) this.val$entries.next();
                return this.toRemove.getKey();
            }

            public void remove() {
                Preconditions.checkState(this.toRemove != null, "no calls to next() since the last call to remove()");
                AbstractMapBasedMultiset.access$122(AbstractMapBasedMultiset.this, (long) ((Count) this.toRemove.getValue()).getAndSet(0));
                this.val$entries.remove();
                this.toRemove = null;
            }
        }

        MapBasedElementSet(Map<E, Count> map) {
            this.map = map;
            this.delegate = map.keySet();
        }

        protected Set<E> delegate() {
            return this.delegate;
        }

        public Iterator<E> iterator() {
            return new C04071(this.map.entrySet().iterator());
        }

        public boolean remove(Object element) {
            return AbstractMapBasedMultiset.this.removeAllOccurrences(element, this.map) != 0;
        }

        public boolean removeAll(Collection<?> elementsToRemove) {
            return Iterators.removeAll(iterator(), elementsToRemove);
        }

        public boolean retainAll(Collection<?> elementsToRetain) {
            return Iterators.retainAll(iterator(), elementsToRetain);
        }

        public void clear() {
            if (this.map == AbstractMapBasedMultiset.this.backingMap) {
                AbstractMapBasedMultiset.this.clear();
                return;
            }
            Iterator<E> i = iterator();
            while (i.hasNext()) {
                i.next();
                i.remove();
            }
        }

        public Map<E, Count> getMap() {
            return this.map;
        }
    }

    private class MapBasedMultisetIterator implements Iterator<E> {
        boolean canRemove;
        Map.Entry<E, Count> currentEntry;
        final Iterator<Map.Entry<E, Count>> entryIterator;
        int occurrencesLeft;

        MapBasedMultisetIterator() {
            this.entryIterator = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.occurrencesLeft > 0 || this.entryIterator.hasNext();
        }

        public E next() {
            if (this.occurrencesLeft == 0) {
                this.currentEntry = (Map.Entry) this.entryIterator.next();
                this.occurrencesLeft = ((Count) this.currentEntry.getValue()).get();
            }
            this.occurrencesLeft--;
            this.canRemove = true;
            return this.currentEntry.getKey();
        }

        public void remove() {
            Preconditions.checkState(this.canRemove, "no calls to next() since the last call to remove()");
            if (((Count) this.currentEntry.getValue()).get() <= 0) {
                throw new ConcurrentModificationException();
            }
            if (((Count) this.currentEntry.getValue()).addAndGet(-1) == 0) {
                this.entryIterator.remove();
            }
            AbstractMapBasedMultiset.this.size = AbstractMapBasedMultiset.this.size - 1;
            this.canRemove = false;
        }
    }

    static /* synthetic */ long access$122(AbstractMapBasedMultiset x0, long x1) {
        long j = x0.size - x1;
        x0.size = j;
        return j;
    }

    protected AbstractMapBasedMultiset(Map<E, Count> backingMap) {
        this.backingMap = (Map) Preconditions.checkNotNull(backingMap);
        this.size = (long) super.size();
    }

    Map<E, Count> backingMap() {
        return this.backingMap;
    }

    void setBackingMap(Map<E, Count> backingMap) {
        this.backingMap = backingMap;
    }

    public Set<Entry<E>> entrySet() {
        return super.entrySet();
    }

    Iterator<Entry<E>> entryIterator() {
        return new C04061(this.backingMap.entrySet().iterator());
    }

    public void clear() {
        for (Count frequency : this.backingMap.values()) {
            frequency.set(0);
        }
        this.backingMap.clear();
        this.size = 0;
    }

    int distinctElements() {
        return this.backingMap.size();
    }

    public int size() {
        return Ints.saturatedCast(this.size);
    }

    public Iterator<E> iterator() {
        return new MapBasedMultisetIterator();
    }

    public int count(@Nullable Object element) {
        int i = 0;
        try {
            Count frequency = (Count) this.backingMap.get(element);
            if (frequency != null) {
                i = frequency.get();
            }
        } catch (NullPointerException e) {
        } catch (ClassCastException e2) {
        }
        return i;
    }

    public int add(@Nullable E element, int occurrences) {
        if (occurrences == 0) {
            return count(element);
        }
        boolean z;
        int oldCount;
        if (occurrences > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "occurrences cannot be negative: %s", Integer.valueOf(occurrences));
        Count frequency = (Count) this.backingMap.get(element);
        if (frequency == null) {
            oldCount = 0;
            this.backingMap.put(element, new Count(occurrences));
        } else {
            oldCount = frequency.get();
            if (((long) oldCount) + ((long) occurrences) <= 2147483647L) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "too many occurrences: %s", Long.valueOf(((long) oldCount) + ((long) occurrences)));
            frequency.getAndAdd(occurrences);
        }
        this.size += (long) occurrences;
        return oldCount;
    }

    public int remove(@Nullable Object element, int occurrences) {
        if (occurrences == 0) {
            return count(element);
        }
        boolean z;
        if (occurrences > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "occurrences cannot be negative: %s", Integer.valueOf(occurrences));
        Count frequency = (Count) this.backingMap.get(element);
        if (frequency == null) {
            return 0;
        }
        int numberRemoved;
        int oldCount = frequency.get();
        if (oldCount > occurrences) {
            numberRemoved = occurrences;
        } else {
            numberRemoved = oldCount;
            this.backingMap.remove(element);
        }
        frequency.addAndGet(-numberRemoved);
        this.size -= (long) numberRemoved;
        return oldCount;
    }

    public int setCount(E element, int count) {
        int oldCount;
        Multisets.checkNonnegative(count, "count");
        if (count == 0) {
            oldCount = getAndSet((Count) this.backingMap.remove(element), count);
        } else {
            Count existingCounter = (Count) this.backingMap.get(element);
            oldCount = getAndSet(existingCounter, count);
            if (existingCounter == null) {
                this.backingMap.put(element, new Count(count));
            }
        }
        this.size += (long) (count - oldCount);
        return oldCount;
    }

    private static int getAndSet(Count i, int count) {
        if (i == null) {
            return 0;
        }
        return i.getAndSet(count);
    }

    private int removeAllOccurrences(@Nullable Object element, Map<E, Count> map) {
        Count frequency = (Count) map.remove(element);
        if (frequency == null) {
            return 0;
        }
        int numberRemoved = frequency.getAndSet(0);
        this.size -= (long) numberRemoved;
        return numberRemoved;
    }

    Set<E> createElementSet() {
        return new MapBasedElementSet(this.backingMap);
    }

    @GwtIncompatible("java.io.ObjectStreamException")
    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }
}
