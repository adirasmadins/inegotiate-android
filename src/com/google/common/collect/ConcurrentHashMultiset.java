package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;
    private transient EntrySet entrySet;

    /* renamed from: com.google.common.collect.ConcurrentHashMultiset.1 */
    class C04401 extends ForwardingSet<E> {
        final /* synthetic */ Set val$delegate;

        C04401(Set set) {
            this.val$delegate = set;
        }

        protected Set<E> delegate() {
            return this.val$delegate;
        }

        public boolean remove(Object object) {
            boolean z = false;
            try {
                z = this.val$delegate.remove(object);
            } catch (NullPointerException e) {
            } catch (ClassCastException e2) {
            }
            return z;
        }
    }

    /* renamed from: com.google.common.collect.ConcurrentHashMultiset.2 */
    class C04412 extends AbstractIterator<Entry<E>> {
        private Iterator<Map.Entry<E, AtomicInteger>> mapEntries;

        C04412() {
            this.mapEntries = ConcurrentHashMultiset.this.countMap.entrySet().iterator();
        }

        protected Entry<E> computeNext() {
            while (this.mapEntries.hasNext()) {
                Map.Entry<E, AtomicInteger> mapEntry = (Map.Entry) this.mapEntries.next();
                int count = ((AtomicInteger) mapEntry.getValue()).get();
                if (count != 0) {
                    return Multisets.immutableEntry(mapEntry.getKey(), count);
                }
            }
            return (Entry) endOfData();
        }
    }

    /* renamed from: com.google.common.collect.ConcurrentHashMultiset.3 */
    class C04423 extends ForwardingIterator<Entry<E>> {
        private Entry<E> last;
        final /* synthetic */ Iterator val$readOnlyIterator;

        C04423(Iterator it) {
            this.val$readOnlyIterator = it;
        }

        protected Iterator<Entry<E>> delegate() {
            return this.val$readOnlyIterator;
        }

        public Entry<E> next() {
            this.last = (Entry) super.next();
            return this.last;
        }

        public void remove() {
            boolean z;
            if (this.last != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            ConcurrentHashMultiset.this.setCount(this.last.getElement(), 0);
            this.last = null;
        }
    }

    private class EntrySet extends EntrySet {
        private EntrySet() {
            super();
        }

        ConcurrentHashMultiset<E> multiset() {
            return ConcurrentHashMultiset.this;
        }

        public Object[] toArray() {
            return snapshot().toArray();
        }

        public <T> T[] toArray(T[] array) {
            return snapshot().toArray(array);
        }

        private List<Entry<E>> snapshot() {
            List<Entry<E>> list = Lists.newArrayListWithExpectedSize(size());
            Iterators.addAll(list, iterator());
            return list;
        }

        public boolean remove(Object object) {
            if (!(object instanceof Entry)) {
                return false;
            }
            Entry<?> entry = (Entry) object;
            Object element = entry.getElement();
            int entryCount = entry.getCount();
            if (entryCount != 0) {
                return multiset().setCount(element, entryCount, 0);
            }
            return false;
        }
    }

    private static class FieldSettersHolder {
        static final FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER;

        private FieldSettersHolder() {
        }

        static {
            COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");
        }
    }

    public /* bridge */ /* synthetic */ boolean add(Object x0) {
        return super.add(x0);
    }

    public /* bridge */ /* synthetic */ boolean addAll(Collection x0) {
        return super.addAll(x0);
    }

    public /* bridge */ /* synthetic */ boolean contains(Object x0) {
        return super.contains(x0);
    }

    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object x0) {
        return super.equals(x0);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public /* bridge */ /* synthetic */ boolean remove(Object x0) {
        return super.remove(x0);
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection x0) {
        return super.removeAll(x0);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection x0) {
        return super.retainAll(x0);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> elements) {
        ConcurrentHashMultiset<E> multiset = create();
        Iterables.addAll(multiset, elements);
        return multiset;
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(GenericMapMaker<? super E, ? super Number> mapMaker) {
        return new ConcurrentHashMultiset(mapMaker.makeMap());
    }

    @VisibleForTesting
    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> countMap) {
        Preconditions.checkArgument(countMap.isEmpty());
        this.countMap = countMap;
    }

    public int count(@Nullable Object element) {
        AtomicInteger existingCounter = safeGet(element);
        return existingCounter == null ? 0 : existingCounter.get();
    }

    private AtomicInteger safeGet(Object element) {
        try {
            return (AtomicInteger) this.countMap.get(element);
        } catch (NullPointerException e) {
            return null;
        } catch (ClassCastException e2) {
            return null;
        }
    }

    public int size() {
        long sum = 0;
        for (AtomicInteger value : this.countMap.values()) {
            sum += (long) value.get();
        }
        return Ints.saturatedCast(sum);
    }

    public Object[] toArray() {
        return snapshot().toArray();
    }

    public <T> T[] toArray(T[] array) {
        return snapshot().toArray(array);
    }

    private List<E> snapshot() {
        List<E> list = Lists.newArrayListWithExpectedSize(size());
        for (Entry<E> entry : entrySet()) {
            E element = entry.getElement();
            for (int i = entry.getCount(); i > 0; i--) {
                list.add(element);
            }
        }
        return list;
    }

    public int add(E element, int occurrences) {
        if (occurrences == 0) {
            return count(element);
        }
        boolean z;
        if (occurrences > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid occurrences: %s", Integer.valueOf(occurrences));
        AtomicInteger existingCounter;
        AtomicInteger newCounter;
        do {
            existingCounter = safeGet(element);
            if (existingCounter == null) {
                existingCounter = (AtomicInteger) this.countMap.putIfAbsent(element, new AtomicInteger(occurrences));
                if (existingCounter == null) {
                    return 0;
                }
            }
            while (true) {
                int oldValue = existingCounter.get();
                if (oldValue == 0) {
                    break;
                }
                try {
                    if (existingCounter.compareAndSet(oldValue, IntMath.checkedAdd(oldValue, occurrences))) {
                        return oldValue;
                    }
                } catch (ArithmeticException e) {
                    throw new IllegalArgumentException("Overflow adding " + occurrences + " occurrences to a count of " + oldValue);
                }
            }
            newCounter = new AtomicInteger(occurrences);
            if (this.countMap.putIfAbsent(element, newCounter) == null) {
                return 0;
            }
        } while (!this.countMap.replace(element, existingCounter, newCounter));
        return 0;
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
        Preconditions.checkArgument(z, "Invalid occurrences: %s", Integer.valueOf(occurrences));
        AtomicInteger existingCounter = safeGet(element);
        if (existingCounter == null) {
            return 0;
        }
        int oldValue;
        int newValue;
        do {
            oldValue = existingCounter.get();
            if (oldValue == 0) {
                return 0;
            }
            newValue = Math.max(0, oldValue - occurrences);
        } while (!existingCounter.compareAndSet(oldValue, newValue));
        if (newValue == 0) {
            this.countMap.remove(element, existingCounter);
        }
        return oldValue;
    }

    public boolean removeExactly(@Nullable Object element, int occurrences) {
        if (occurrences == 0) {
            return true;
        }
        boolean z;
        if (occurrences > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid occurrences: %s", Integer.valueOf(occurrences));
        AtomicInteger existingCounter = safeGet(element);
        if (existingCounter == null) {
            return false;
        }
        int oldValue;
        int newValue;
        do {
            oldValue = existingCounter.get();
            if (oldValue < occurrences) {
                return false;
            }
            newValue = oldValue - occurrences;
        } while (!existingCounter.compareAndSet(oldValue, newValue));
        if (newValue != 0) {
            return true;
        }
        this.countMap.remove(element, existingCounter);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setCount(E r7, int r8) {
        /*
        r6 = this;
        r3 = 0;
        r4 = "count";
        com.google.common.collect.Multisets.checkNonnegative(r8, r4);
    L_0x0006:
        r0 = r6.safeGet(r7);
        if (r0 != 0) goto L_0x0021;
    L_0x000c:
        if (r8 != 0) goto L_0x0010;
    L_0x000e:
        r2 = r3;
    L_0x000f:
        return r2;
    L_0x0010:
        r4 = r6.countMap;
        r5 = new java.util.concurrent.atomic.AtomicInteger;
        r5.<init>(r8);
        r0 = r4.putIfAbsent(r7, r5);
        r0 = (java.util.concurrent.atomic.AtomicInteger) r0;
        if (r0 != 0) goto L_0x0021;
    L_0x001f:
        r2 = r3;
        goto L_0x000f;
    L_0x0021:
        r2 = r0.get();
        if (r2 != 0) goto L_0x0042;
    L_0x0027:
        if (r8 != 0) goto L_0x002b;
    L_0x0029:
        r2 = r3;
        goto L_0x000f;
    L_0x002b:
        r1 = new java.util.concurrent.atomic.AtomicInteger;
        r1.<init>(r8);
        r4 = r6.countMap;
        r4 = r4.putIfAbsent(r7, r1);
        if (r4 == 0) goto L_0x0040;
    L_0x0038:
        r4 = r6.countMap;
        r4 = r4.replace(r7, r0, r1);
        if (r4 == 0) goto L_0x0006;
    L_0x0040:
        r2 = r3;
        goto L_0x000f;
    L_0x0042:
        r4 = r0.compareAndSet(r2, r8);
        if (r4 == 0) goto L_0x0021;
    L_0x0048:
        if (r8 != 0) goto L_0x000f;
    L_0x004a:
        r3 = r6.countMap;
        r3.remove(r7, r0);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.setCount(java.lang.Object, int):int");
    }

    public boolean setCount(E element, int expectedOldCount, int newCount) {
        boolean z = false;
        Multisets.checkNonnegative(expectedOldCount, "oldCount");
        Multisets.checkNonnegative(newCount, "newCount");
        AtomicInteger existingCounter = safeGet(element);
        if (existingCounter != null) {
            int oldValue = existingCounter.get();
            if (oldValue == expectedOldCount) {
                if (oldValue == 0) {
                    if (newCount == 0) {
                        this.countMap.remove(element, existingCounter);
                        return true;
                    }
                    AtomicInteger newCounter = new AtomicInteger(newCount);
                    if (this.countMap.putIfAbsent(element, newCounter) == null || this.countMap.replace(element, existingCounter, newCounter)) {
                        z = true;
                    }
                    return z;
                } else if (existingCounter.compareAndSet(oldValue, newCount)) {
                    if (newCount != 0) {
                        return true;
                    }
                    this.countMap.remove(element, existingCounter);
                    return true;
                }
            }
            return false;
        } else if (expectedOldCount != 0) {
            return false;
        } else {
            if (newCount == 0 || this.countMap.putIfAbsent(element, new AtomicInteger(newCount)) == null) {
                return true;
            }
            return false;
        }
    }

    Set<E> createElementSet() {
        return new C04401(this.countMap.keySet());
    }

    public Set<Entry<E>> entrySet() {
        EntrySet result = this.entrySet;
        if (result != null) {
            return result;
        }
        result = new EntrySet();
        this.entrySet = result;
        return result;
    }

    int distinctElements() {
        return this.countMap.size();
    }

    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    Iterator<Entry<E>> entryIterator() {
        return new C04423(new C04412());
    }

    public void clear() {
        this.countMap.clear();
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(this.countMap);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set((Object) this, (ConcurrentMap) stream.readObject());
    }
}
