package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
final class SortedMultisets {

    static abstract class ElementSet<E> extends ElementSet<E> implements SortedSet<E> {
        abstract SortedMultiset<E> multiset();

        ElementSet() {
        }

        public Comparator<? super E> comparator() {
            return multiset().comparator();
        }

        public SortedSet<E> subSet(E fromElement, E toElement) {
            return multiset().subMultiset(fromElement, BoundType.CLOSED, toElement, BoundType.OPEN).elementSet();
        }

        public SortedSet<E> headSet(E toElement) {
            return multiset().headMultiset(toElement, BoundType.OPEN).elementSet();
        }

        public SortedSet<E> tailSet(E fromElement) {
            return multiset().tailMultiset(fromElement, BoundType.CLOSED).elementSet();
        }

        public E first() {
            return SortedMultisets.getElementOrThrow(multiset().firstEntry());
        }

        public E last() {
            return SortedMultisets.getElementOrThrow(multiset().lastEntry());
        }
    }

    static abstract class DescendingMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {
        private transient Comparator<? super E> comparator;
        private transient SortedSet<E> elementSet;
        private transient Set<Entry<E>> entrySet;

        /* renamed from: com.google.common.collect.SortedMultisets.DescendingMultiset.1 */
        class C06211 extends ElementSet<E> {
            C06211() {
            }

            SortedMultiset<E> multiset() {
                return DescendingMultiset.this;
            }
        }

        /* renamed from: com.google.common.collect.SortedMultisets.DescendingMultiset.2 */
        class C06222 extends EntrySet<E> {
            C06222() {
            }

            Multiset<E> multiset() {
                return DescendingMultiset.this;
            }

            public Iterator<Entry<E>> iterator() {
                return DescendingMultiset.this.entryIterator();
            }

            public int size() {
                return DescendingMultiset.this.forwardMultiset().entrySet().size();
            }
        }

        abstract Iterator<Entry<E>> entryIterator();

        abstract SortedMultiset<E> forwardMultiset();

        DescendingMultiset() {
        }

        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator = this.comparator;
            if (comparator != null) {
                return comparator;
            }
            comparator = Ordering.from(forwardMultiset().comparator()).reverse();
            this.comparator = comparator;
            return comparator;
        }

        public SortedSet<E> elementSet() {
            SortedSet<E> sortedSet = this.elementSet;
            if (sortedSet != null) {
                return sortedSet;
            }
            sortedSet = new C06211();
            this.elementSet = sortedSet;
            return sortedSet;
        }

        public Entry<E> pollFirstEntry() {
            return forwardMultiset().pollLastEntry();
        }

        public Entry<E> pollLastEntry() {
            return forwardMultiset().pollFirstEntry();
        }

        public SortedMultiset<E> headMultiset(E toElement, BoundType boundType) {
            return forwardMultiset().tailMultiset(toElement, boundType).descendingMultiset();
        }

        public SortedMultiset<E> subMultiset(E fromElement, BoundType fromBoundType, E toElement, BoundType toBoundType) {
            return forwardMultiset().subMultiset(toElement, toBoundType, fromElement, fromBoundType).descendingMultiset();
        }

        public SortedMultiset<E> tailMultiset(E fromElement, BoundType boundType) {
            return forwardMultiset().headMultiset(fromElement, boundType).descendingMultiset();
        }

        protected Multiset<E> delegate() {
            return forwardMultiset();
        }

        public SortedMultiset<E> descendingMultiset() {
            return forwardMultiset();
        }

        public Entry<E> firstEntry() {
            return forwardMultiset().lastEntry();
        }

        public Entry<E> lastEntry() {
            return forwardMultiset().firstEntry();
        }

        public Set<Entry<E>> entrySet() {
            Set<Entry<E>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            set = createEntrySet();
            this.entrySet = set;
            return set;
        }

        Set<Entry<E>> createEntrySet() {
            return new C06222();
        }

        public Iterator<E> iterator() {
            return Multisets.iteratorImpl(this);
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] array) {
            return standardToArray(array);
        }

        public String toString() {
            return entrySet().toString();
        }
    }

    private SortedMultisets() {
    }

    private static <E> E getElementOrThrow(Entry<E> entry) {
        if (entry != null) {
            return entry.getElement();
        }
        throw new NoSuchElementException();
    }
}
