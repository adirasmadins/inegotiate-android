package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
public abstract class ImmutableMultiset<E> extends ImmutableCollection<E> implements Multiset<E> {
    private transient ImmutableSet<Entry<E>> entrySet;

    /* renamed from: com.google.common.collect.ImmutableMultiset.1 */
    class C04521 extends UnmodifiableIterator<E> {
        E element;
        int remaining;
        final /* synthetic */ Iterator val$entryIterator;

        C04521(Iterator it) {
            this.val$entryIterator = it;
        }

        public boolean hasNext() {
            return this.remaining > 0 || this.val$entryIterator.hasNext();
        }

        public E next() {
            if (this.remaining <= 0) {
                Entry<E> entry = (Entry) this.val$entryIterator.next();
                this.element = entry.getElement();
                this.remaining = entry.getCount();
            }
            this.remaining--;
            return this.element;
        }
    }

    public static class Builder<E> extends com.google.common.collect.ImmutableCollection.Builder<E> {
        final Multiset<E> contents;

        public Builder() {
            this(LinkedHashMultiset.create());
        }

        Builder(Multiset<E> contents) {
            this.contents = contents;
        }

        public Builder<E> add(E element) {
            this.contents.add(Preconditions.checkNotNull(element));
            return this;
        }

        public Builder<E> addCopies(E element, int occurrences) {
            this.contents.add(Preconditions.checkNotNull(element), occurrences);
            return this;
        }

        public Builder<E> setCount(E element, int count) {
            this.contents.setCount(Preconditions.checkNotNull(element), count);
            return this;
        }

        public Builder<E> add(E... elements) {
            super.add((Object[]) elements);
            return this;
        }

        public Builder<E> addAll(Iterable<? extends E> elements) {
            if (elements instanceof Multiset) {
                for (Entry<? extends E> entry : Multisets.cast(elements).entrySet()) {
                    addCopies(entry.getElement(), entry.getCount());
                }
            } else {
                super.addAll((Iterable) elements);
            }
            return this;
        }

        public Builder<E> addAll(Iterator<? extends E> elements) {
            super.addAll((Iterator) elements);
            return this;
        }

        public ImmutableMultiset<E> build() {
            return ImmutableMultiset.copyOf(this.contents);
        }
    }

    static class EntrySet<E> extends ImmutableSet<Entry<E>> {
        private static final long serialVersionUID = 0;
        final transient ImmutableMultiset<E> multiset;

        static class EntrySetSerializedForm<E> implements Serializable {
            final ImmutableMultiset<E> multiset;

            EntrySetSerializedForm(ImmutableMultiset<E> multiset) {
                this.multiset = multiset;
            }

            Object readResolve() {
                return this.multiset.entrySet();
            }
        }

        public EntrySet(ImmutableMultiset<E> multiset) {
            this.multiset = multiset;
        }

        public UnmodifiableIterator<Entry<E>> iterator() {
            return this.multiset.entryIterator();
        }

        public int size() {
            return this.multiset.distinctElements();
        }

        boolean isPartialView() {
            return this.multiset.isPartialView();
        }

        public boolean contains(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry<?> entry = (Entry) o;
            if (entry.getCount() > 0 && this.multiset.count(entry.getElement()) == entry.getCount()) {
                return true;
            }
            return false;
        }

        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        public <T> T[] toArray(T[] other) {
            int size = size();
            if (other.length < size) {
                other = ObjectArrays.newArray((Object[]) other, size);
            } else if (other.length > size) {
                other[size] = null;
            }
            T[] otherAsObjectArray = other;
            int index = 0;
            Iterator i$ = iterator();
            while (i$.hasNext()) {
                int index2 = index + 1;
                otherAsObjectArray[index] = (Entry) i$.next();
                index = index2;
            }
            return other;
        }

        public int hashCode() {
            return this.multiset.hashCode();
        }

        Object writeReplace() {
            return new EntrySetSerializedForm(this.multiset);
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(Multiset<?> multiset) {
            int distinct = multiset.entrySet().size();
            this.elements = new Object[distinct];
            this.counts = new int[distinct];
            int i = 0;
            for (Entry<?> entry : multiset.entrySet()) {
                this.elements[i] = entry.getElement();
                this.counts[i] = entry.getCount();
                i++;
            }
        }

        Object readResolve() {
            Iterable multiset = LinkedHashMultiset.create(this.elements.length);
            for (int i = 0; i < this.elements.length; i++) {
                multiset.add(this.elements[i], this.counts[i]);
            }
            return ImmutableMultiset.copyOf(multiset);
        }
    }

    abstract int distinctElements();

    abstract UnmodifiableIterator<Entry<E>> entryIterator();

    public static <E> ImmutableMultiset<E> of() {
        return EmptyImmutableMultiset.INSTANCE;
    }

    public static <E> ImmutableMultiset<E> of(E element) {
        return copyOfInternal(element);
    }

    public static <E> ImmutableMultiset<E> of(E e1, E e2) {
        return copyOfInternal(e1, e2);
    }

    public static <E> ImmutableMultiset<E> of(E e1, E e2, E e3) {
        return copyOfInternal(e1, e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e1, E e2, E e3, E e4) {
        return copyOfInternal(e1, e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e1, E e2, E e3, E e4, E e5) {
        return copyOfInternal(e1, e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E... others) {
        Iterable all = new ArrayList(others.length + 6);
        Collections.addAll(all, new Object[]{e1, e2, e3, e4, e5, e6});
        Collections.addAll(all, others);
        return copyOf(all);
    }

    @Deprecated
    public static <E> ImmutableMultiset<E> of(E[] elements) {
        return copyOf(Arrays.asList(elements));
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] elements) {
        return copyOf(Arrays.asList(elements));
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> elements) {
        if (elements instanceof ImmutableMultiset) {
            ImmutableMultiset<E> result = (ImmutableMultiset) elements;
            if (!result.isPartialView()) {
                return result;
            }
        }
        return copyOfInternal(elements instanceof Multiset ? Multisets.cast(elements) : LinkedHashMultiset.create((Iterable) elements));
    }

    private static <E> ImmutableMultiset<E> copyOfInternal(E... elements) {
        return copyOf(Arrays.asList(elements));
    }

    private static <E> ImmutableMultiset<E> copyOfInternal(Multiset<? extends E> multiset) {
        return copyFromEntries(multiset.entrySet());
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Entry<? extends E>> entries) {
        long size = 0;
        com.google.common.collect.ImmutableMap.Builder<E, Integer> builder = ImmutableMap.builder();
        for (Entry<? extends E> entry : entries) {
            int count = entry.getCount();
            if (count > 0) {
                builder.put(entry.getElement(), Integer.valueOf(count));
                size += (long) count;
            }
        }
        if (size == 0) {
            return of();
        }
        return new RegularImmutableMultiset(builder.build(), Ints.saturatedCast(size));
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> elements) {
        Multiset multiset = LinkedHashMultiset.create();
        Iterators.addAll(multiset, elements);
        return copyOfInternal(multiset);
    }

    ImmutableMultiset() {
    }

    public UnmodifiableIterator<E> iterator() {
        return new C04521(entryIterator());
    }

    public boolean contains(@Nullable Object object) {
        return count(object) > 0;
    }

    public boolean containsAll(Collection<?> targets) {
        return elementSet().containsAll(targets);
    }

    public final int add(E e, int occurrences) {
        throw new UnsupportedOperationException();
    }

    public final int remove(Object element, int occurrences) {
        throw new UnsupportedOperationException();
    }

    public final int setCount(E e, int count) {
        throw new UnsupportedOperationException();
    }

    public final boolean setCount(E e, int oldCount, int newCount) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Multiset)) {
            return false;
        }
        Multiset<?> that = (Multiset) object;
        if (size() != that.size()) {
            return false;
        }
        for (Entry<?> entry : that.entrySet()) {
            if (count(entry.getElement()) != entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    public String toString() {
        return entrySet().toString();
    }

    public Set<Entry<E>> entrySet() {
        Set<Entry<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    ImmutableSet<Entry<E>> createEntrySet() {
        return new EntrySet(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }
}
