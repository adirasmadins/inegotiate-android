package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    private final transient ImmutableMap<E, Integer> map;
    private final transient int size;

    /* renamed from: com.google.common.collect.RegularImmutableMultiset.1 */
    class C05931 extends UnmodifiableIterator<Entry<E>> {
        final /* synthetic */ Iterator val$mapIterator;

        C05931(Iterator it) {
            this.val$mapIterator = it;
        }

        public boolean hasNext() {
            return this.val$mapIterator.hasNext();
        }

        public Entry<E> next() {
            Map.Entry<E, Integer> mapEntry = (Map.Entry) this.val$mapIterator.next();
            return Multisets.immutableEntry(mapEntry.getKey(), ((Integer) mapEntry.getValue()).intValue());
        }
    }

    RegularImmutableMultiset(ImmutableMap<E, Integer> map, int size) {
        this.map = map;
        this.size = size;
    }

    boolean isPartialView() {
        return this.map.isPartialView();
    }

    public int count(@Nullable Object element) {
        Integer value = (Integer) this.map.get(element);
        return value == null ? 0 : value.intValue();
    }

    public int size() {
        return this.size;
    }

    public boolean contains(@Nullable Object element) {
        return this.map.containsKey(element);
    }

    public ImmutableSet<E> elementSet() {
        return this.map.keySet();
    }

    UnmodifiableIterator<Entry<E>> entryIterator() {
        return new C05931(this.map.entrySet().iterator());
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    int distinctElements() {
        return this.map.size();
    }
}
