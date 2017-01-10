package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

@GwtIncompatible("hasn't been tested yet")
abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
    private static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET;
    private static final Comparator<Comparable> NATURAL_ORDER;
    private final transient Comparator<? super E> comparator;
    transient ImmutableSortedMultiset<E> descendingMultiset;
    private transient ImmutableSortedSet<E> elementSet;
    private transient Comparator<? super E> reverseComparator;

    public static class Builder<E> extends com.google.common.collect.ImmutableMultiset.Builder<E> {
        private final Comparator<? super E> comparator;

        public Builder(Comparator<? super E> comparator) {
            super(TreeMultiset.create((Comparator) comparator));
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        public Builder<E> add(E element) {
            super.add((Object) element);
            return this;
        }

        public Builder<E> addCopies(E element, int occurrences) {
            super.addCopies(element, occurrences);
            return this;
        }

        public Builder<E> setCount(E element, int count) {
            super.setCount(element, count);
            return this;
        }

        public Builder<E> add(E... elements) {
            super.add((Object[]) elements);
            return this;
        }

        public Builder<E> addAll(Iterable<? extends E> elements) {
            super.addAll((Iterable) elements);
            return this;
        }

        public Builder<E> addAll(Iterator<? extends E> elements) {
            super.addAll((Iterator) elements);
            return this;
        }

        public ImmutableSortedMultiset<E> build() {
            return ImmutableSortedMultiset.copyOf(this.comparator, this.contents);
        }
    }

    private static final class SerializedForm implements Serializable {
        Comparator comparator;
        int[] counts;
        Object[] elements;

        SerializedForm(SortedMultiset<?> multiset) {
            this.comparator = multiset.comparator();
            int n = multiset.entrySet().size();
            this.elements = new Object[n];
            this.counts = new int[n];
            int i = 0;
            for (Entry<?> entry : multiset.entrySet()) {
                this.elements[i] = entry.getElement();
                this.counts[i] = entry.getCount();
                i++;
            }
        }

        Object readResolve() {
            int n = this.elements.length;
            Builder<Object> builder = ImmutableSortedMultiset.orderedBy(this.comparator);
            for (int i = 0; i < n; i++) {
                builder.addCopies(this.elements[i], this.counts[i]);
            }
            return builder.build();
        }
    }

    abstract ImmutableSortedSet<E> createDescendingElementSet();

    abstract ImmutableSortedSet<E> createElementSet();

    abstract UnmodifiableIterator<Entry<E>> descendingEntryIterator();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType);

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType);

    static {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_MULTISET = new EmptyImmutableSortedMultiset(NATURAL_ORDER);
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return NATURAL_EMPTY_MULTISET;
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E element) {
        return RegularImmutableSortedMultiset.createFromSorted(NATURAL_ORDER, ImmutableList.of(Multisets.immutableEntry(Preconditions.checkNotNull(element), 1)));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e1, E e2) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e1, e2}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e1, E e2, E e3) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e1, e2, e3}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e1, E e2, E e3, E e4) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e1, e2, e3, e4}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e1, E e2, E e3, E e4, E e5) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e1, e2, e3, e4, e5}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E... remaining) {
        Iterable all = new ArrayList(remaining.length + 6);
        Collections.addAll(all, new Comparable[]{e1, e2, e3, e4, e5, e6});
        Collections.addAll(all, remaining);
        return copyOf(Ordering.natural(), all);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] elements) {
        return copyOf(Ordering.natural(), Arrays.asList(elements));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> elements) {
        return copyOf(Ordering.natural(), (Iterable) elements);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> elements) {
        return copyOfInternal(Ordering.natural(), (Iterator) elements);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> elements) {
        Preconditions.checkNotNull(comparator);
        return copyOfInternal((Comparator) comparator, (Iterator) elements);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> elements) {
        Preconditions.checkNotNull(comparator);
        return copyOfInternal((Comparator) comparator, (Iterable) elements);
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        Comparator comparator = sortedMultiset.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        return copyOfInternal(comparator, (Iterable) sortedMultiset);
    }

    private static <E> ImmutableSortedMultiset<E> copyOfInternal(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (SortedIterables.hasSameComparator(comparator, iterable) && (iterable instanceof ImmutableSortedMultiset) && !((ImmutableSortedMultiset) iterable).isPartialView()) {
            return (ImmutableSortedMultiset) iterable;
        }
        ImmutableList<Entry<E>> entries = ImmutableList.copyOf(SortedIterables.sortedCounts((Comparator) comparator, (Iterable) iterable));
        if (entries.isEmpty()) {
            return emptyMultiset(comparator);
        }
        verifyEntries(entries);
        return RegularImmutableSortedMultiset.createFromSorted(comparator, entries);
    }

    private static <E> ImmutableSortedMultiset<E> copyOfInternal(Comparator<? super E> comparator, Iterator<? extends E> iterator) {
        ImmutableList<Entry<E>> entries = ImmutableList.copyOf(SortedIterables.sortedCounts((Comparator) comparator, (Iterator) iterator));
        if (entries.isEmpty()) {
            return emptyMultiset(comparator);
        }
        verifyEntries(entries);
        return RegularImmutableSortedMultiset.createFromSorted(comparator, entries);
    }

    private static <E> void verifyEntries(Collection<Entry<E>> entries) {
        for (Entry<E> entry : entries) {
            Preconditions.checkNotNull(entry.getElement());
        }
    }

    static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        if (NATURAL_ORDER.equals(comparator)) {
            return NATURAL_EMPTY_MULTISET;
        }
        return new EmptyImmutableSortedMultiset(comparator);
    }

    ImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    Comparator<? super E> reverseComparator() {
        Comparator<? super E> comparator = this.reverseComparator;
        if (comparator != null) {
            return comparator;
        }
        comparator = Ordering.from(this.comparator).reverse();
        this.reverseComparator = comparator;
        return comparator;
    }

    public ImmutableSortedSet<E> elementSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.elementSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        immutableSortedSet = createElementSet();
        this.elementSet = immutableSortedSet;
        return immutableSortedSet;
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset != null) {
            return immutableSortedMultiset;
        }
        immutableSortedMultiset = new DescendingImmutableSortedMultiset(this);
        this.descendingMultiset = immutableSortedMultiset;
        return immutableSortedMultiset;
    }

    public final Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    public Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedMultiset<E> subMultiset(E lowerBound, BoundType lowerBoundType, E upperBound, BoundType upperBoundType) {
        return tailMultiset((Object) lowerBound, lowerBoundType).headMultiset((Object) upperBound, upperBoundType);
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder(comparator);
    }

    public static <E extends Comparable<E>> Builder<E> reverseOrder() {
        return new Builder(Ordering.natural().reverse());
    }

    public static <E extends Comparable<E>> Builder<E> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
