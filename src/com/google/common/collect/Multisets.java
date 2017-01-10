package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public final class Multisets {
    private static final Ordering<Entry<?>> DECREASING_COUNT_ORDERING;

    static abstract class AbstractEntry<E> implements Entry<E> {
        AbstractEntry() {
        }

        public boolean equals(@Nullable Object object) {
            if (!(object instanceof Entry)) {
                return false;
            }
            Entry<?> that = (Entry) object;
            if (getCount() == that.getCount() && Objects.equal(getElement(), that.getElement())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            E e = getElement();
            return (e == null ? 0 : e.hashCode()) ^ getCount();
        }

        public String toString() {
            String text = String.valueOf(getElement());
            int n = getCount();
            return n == 1 ? text : text + " x " + n;
        }
    }

    static abstract class ElementSet<E> extends AbstractSet<E> {

        /* renamed from: com.google.common.collect.Multisets.ElementSet.1 */
        class C05841 implements Function<Entry<E>, E> {
            C05841() {
            }

            public E apply(Entry<E> entry) {
                return entry.getElement();
            }
        }

        abstract Multiset<E> multiset();

        ElementSet() {
        }

        public void clear() {
            multiset().clear();
        }

        public boolean contains(Object o) {
            return multiset().contains(o);
        }

        public boolean containsAll(Collection<?> c) {
            return multiset().containsAll(c);
        }

        public boolean isEmpty() {
            return multiset().isEmpty();
        }

        public Iterator<E> iterator() {
            return Iterators.transform(multiset().entrySet().iterator(), new C05841());
        }

        public boolean remove(Object o) {
            int count = multiset().count(o);
            if (count <= 0) {
                return false;
            }
            multiset().remove(o, count);
            return true;
        }

        public int size() {
            return multiset().entrySet().size();
        }
    }

    static abstract class EntrySet<E> extends AbstractSet<Entry<E>> {
        abstract Multiset<E> multiset();

        EntrySet() {
        }

        public boolean contains(@Nullable Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry<?> entry = (Entry) o;
            if (entry.getCount() > 0 && multiset().count(entry.getElement()) == entry.getCount()) {
                return true;
            }
            return false;
        }

        public boolean remove(Object o) {
            return contains(o) && multiset().elementSet().remove(((Entry) o).getElement());
        }

        public void clear() {
            multiset().clear();
        }
    }

    /* renamed from: com.google.common.collect.Multisets.1 */
    static class C05821 extends AbstractMultiset<E> {
        final /* synthetic */ Multiset val$multiset1;
        final /* synthetic */ Multiset val$multiset2;

        /* renamed from: com.google.common.collect.Multisets.1.1 */
        class C05811 extends AbstractIterator<Entry<E>> {
            final /* synthetic */ Iterator val$iterator1;

            C05811(Iterator it) {
                this.val$iterator1 = it;
            }

            protected Entry<E> computeNext() {
                while (this.val$iterator1.hasNext()) {
                    Entry<E> entry1 = (Entry) this.val$iterator1.next();
                    E element = entry1.getElement();
                    int count = Math.min(entry1.getCount(), C05821.this.val$multiset2.count(element));
                    if (count > 0) {
                        return Multisets.immutableEntry(element, count);
                    }
                }
                return (Entry) endOfData();
            }
        }

        C05821(Multiset multiset, Multiset multiset2) {
            this.val$multiset1 = multiset;
            this.val$multiset2 = multiset2;
        }

        public int count(Object element) {
            int count1 = this.val$multiset1.count(element);
            return count1 == 0 ? 0 : Math.min(count1, this.val$multiset2.count(element));
        }

        Set<E> createElementSet() {
            return Sets.intersection(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
        }

        Iterator<Entry<E>> entryIterator() {
            return new C05811(this.val$multiset1.entrySet().iterator());
        }

        int distinctElements() {
            return elementSet().size();
        }
    }

    /* renamed from: com.google.common.collect.Multisets.2 */
    static class C05832 extends Ordering<Entry<?>> {
        C05832() {
        }

        public int compare(Entry<?> entry1, Entry<?> entry2) {
            return Ints.compare(entry2.getCount(), entry1.getCount());
        }
    }

    static final class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final int count;
        @Nullable
        final E element;

        ImmutableEntry(@Nullable E element, int count) {
            this.element = element;
            this.count = count;
            Preconditions.checkArgument(count >= 0);
        }

        @Nullable
        public E getElement() {
            return this.element;
        }

        public int getCount() {
            return this.count;
        }
    }

    static final class MultisetIteratorImpl<E> implements Iterator<E> {
        private boolean canRemove;
        private Entry<E> currentEntry;
        private final Iterator<Entry<E>> entryIterator;
        private int laterCount;
        private final Multiset<E> multiset;
        private int totalCount;

        MultisetIteratorImpl(Multiset<E> multiset, Iterator<Entry<E>> entryIterator) {
            this.multiset = multiset;
            this.entryIterator = entryIterator;
        }

        public boolean hasNext() {
            return this.laterCount > 0 || this.entryIterator.hasNext();
        }

        public E next() {
            if (hasNext()) {
                if (this.laterCount == 0) {
                    this.currentEntry = (Entry) this.entryIterator.next();
                    int count = this.currentEntry.getCount();
                    this.laterCount = count;
                    this.totalCount = count;
                }
                this.laterCount--;
                this.canRemove = true;
                return this.currentEntry.getElement();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Preconditions.checkState(this.canRemove, "no calls to next() since the last call to remove()");
            if (this.totalCount == 1) {
                this.entryIterator.remove();
            } else {
                this.multiset.remove(this.currentEntry.getElement());
            }
            this.totalCount--;
            this.canRemove = false;
        }
    }

    private static class SetMultiset<E> extends ForwardingCollection<E> implements Multiset<E>, Serializable {
        private static final long serialVersionUID = 0;
        final Set<E> delegate;
        transient Set<E> elementSet;
        transient Set<Entry<E>> entrySet;

        /* renamed from: com.google.common.collect.Multisets.SetMultiset.1 */
        class C05861 extends EntrySet<E> {

            /* renamed from: com.google.common.collect.Multisets.SetMultiset.1.1 */
            class C05851 implements Function<E, Entry<E>> {
                C05851() {
                }

                public Entry<E> apply(E elem) {
                    return Multisets.immutableEntry(elem, 1);
                }
            }

            C05861() {
            }

            Multiset<E> multiset() {
                return SetMultiset.this;
            }

            public Iterator<Entry<E>> iterator() {
                return Iterators.transform(SetMultiset.this.delegate.iterator(), new C05851());
            }

            public int size() {
                return SetMultiset.this.delegate.size();
            }
        }

        class ElementSet extends ForwardingSet<E> {
            ElementSet() {
            }

            protected Set<E> delegate() {
                return SetMultiset.this.delegate;
            }

            public boolean add(E e) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }
        }

        SetMultiset(Set<E> set) {
            this.delegate = (Set) Preconditions.checkNotNull(set);
        }

        protected Set<E> delegate() {
            return this.delegate;
        }

        public int count(Object element) {
            return this.delegate.contains(element) ? 1 : 0;
        }

        public int add(E e, int occurrences) {
            throw new UnsupportedOperationException();
        }

        public int remove(Object element, int occurrences) {
            if (occurrences == 0) {
                return count(element);
            }
            boolean z;
            if (occurrences > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            if (this.delegate.remove(element)) {
                return 1;
            }
            return 0;
        }

        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set != null) {
                return set;
            }
            set = new ElementSet();
            this.elementSet = set;
            return set;
        }

        public Set<Entry<E>> entrySet() {
            Set<Entry<E>> es = this.entrySet;
            if (es != null) {
                return es;
            }
            es = new C05861();
            this.entrySet = es;
            return es;
        }

        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public int setCount(E element, int count) {
            Multisets.checkNonnegative(count, "count");
            if (count == count(element)) {
                return count;
            }
            if (count == 0) {
                remove(element);
                return 1;
            }
            throw new UnsupportedOperationException();
        }

        public boolean setCount(E element, int oldCount, int newCount) {
            return Multisets.setCountImpl(this, element, oldCount, newCount);
        }

        public boolean equals(@Nullable Object object) {
            if (!(object instanceof Multiset)) {
                return false;
            }
            Multiset<?> that = (Multiset) object;
            if (size() == that.size() && this.delegate.equals(that.elementSet())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int sum = 0;
            Iterator i$ = iterator();
            while (i$.hasNext()) {
                E e = i$.next();
                sum += (e == null ? 0 : e.hashCode()) ^ 1;
            }
            return sum;
        }
    }

    static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multiset<? extends E> delegate;
        transient Set<E> elementSet;
        transient Set<Entry<E>> entrySet;

        UnmodifiableMultiset(Multiset<? extends E> delegate) {
            this.delegate = delegate;
        }

        protected Multiset<E> delegate() {
            return this.delegate;
        }

        Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set != null) {
                return set;
            }
            set = createElementSet();
            this.elementSet = set;
            return set;
        }

        public Set<Entry<E>> entrySet() {
            Set<Entry<E>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            set = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = set;
            return set;
        }

        public Iterator<E> iterator() {
            return Iterators.unmodifiableIterator(this.delegate.iterator());
        }

        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        public int add(E e, int occurences) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object element) {
            throw new UnsupportedOperationException();
        }

        public int remove(Object element, int occurrences) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public int setCount(E e, int count) {
            throw new UnsupportedOperationException();
        }

        public boolean setCount(E e, int oldCount, int newCount) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class UnmodifiableSortedMultiset<E> extends UnmodifiableMultiset<E> implements SortedMultiset<E> {
        private static final long serialVersionUID = 0;
        private transient UnmodifiableSortedMultiset<E> descendingMultiset;

        private UnmodifiableSortedMultiset(SortedMultiset<E> delegate) {
            super(delegate);
        }

        protected SortedMultiset<E> delegate() {
            return (SortedMultiset) super.delegate();
        }

        public Comparator<? super E> comparator() {
            return delegate().comparator();
        }

        SortedSet<E> createElementSet() {
            return Collections.unmodifiableSortedSet(delegate().elementSet());
        }

        public SortedSet<E> elementSet() {
            return (SortedSet) super.elementSet();
        }

        public SortedMultiset<E> descendingMultiset() {
            UnmodifiableSortedMultiset<E> result = this.descendingMultiset;
            if (result != null) {
                return result;
            }
            result = new UnmodifiableSortedMultiset(delegate().descendingMultiset());
            result.descendingMultiset = this;
            this.descendingMultiset = result;
            return result;
        }

        public Entry<E> firstEntry() {
            return delegate().firstEntry();
        }

        public Entry<E> lastEntry() {
            return delegate().lastEntry();
        }

        public Entry<E> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        public Entry<E> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        public SortedMultiset<E> headMultiset(E upperBound, BoundType boundType) {
            return Multisets.unmodifiableSortedMultiset(delegate().headMultiset(upperBound, boundType));
        }

        public SortedMultiset<E> subMultiset(E lowerBound, BoundType lowerBoundType, E upperBound, BoundType upperBoundType) {
            return Multisets.unmodifiableSortedMultiset(delegate().subMultiset(lowerBound, lowerBoundType, upperBound, upperBoundType));
        }

        public SortedMultiset<E> tailMultiset(E lowerBound, BoundType boundType) {
            return Multisets.unmodifiableSortedMultiset(delegate().tailMultiset(lowerBound, boundType));
        }
    }

    private Multisets() {
    }

    public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> multiset) {
        if ((multiset instanceof UnmodifiableMultiset) || (multiset instanceof ImmutableMultiset)) {
            return multiset;
        }
        return new UnmodifiableMultiset((Multiset) Preconditions.checkNotNull(multiset));
    }

    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> multiset) {
        return (Multiset) Preconditions.checkNotNull(multiset);
    }

    @Beta
    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        return new UnmodifiableSortedMultiset(null);
    }

    public static <E> Entry<E> immutableEntry(@Nullable E e, int n) {
        return new ImmutableEntry(e, n);
    }

    static <E> Multiset<E> forSet(Set<E> set) {
        return new SetMultiset(set);
    }

    static int inferDistinctElements(Iterable<?> elements) {
        if (elements instanceof Multiset) {
            return ((Multiset) elements).elementSet().size();
        }
        return 11;
    }

    public static <E> Multiset<E> intersection(Multiset<E> multiset1, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset1);
        Preconditions.checkNotNull(multiset2);
        return new C05821(multiset1, multiset2);
    }

    @Beta
    public static boolean containsOccurrences(Multiset<?> superMultiset, Multiset<?> subMultiset) {
        Preconditions.checkNotNull(superMultiset);
        Preconditions.checkNotNull(subMultiset);
        for (Entry<?> entry : subMultiset.entrySet()) {
            if (superMultiset.count(entry.getElement()) < entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    @Beta
    public static boolean retainOccurrences(Multiset<?> multisetToModify, Multiset<?> multisetToRetain) {
        return retainOccurrencesImpl(multisetToModify, multisetToRetain);
    }

    private static <E> boolean retainOccurrencesImpl(Multiset<E> multisetToModify, Multiset<?> occurrencesToRetain) {
        Preconditions.checkNotNull(multisetToModify);
        Preconditions.checkNotNull(occurrencesToRetain);
        Iterator<Entry<E>> entryIterator = multisetToModify.entrySet().iterator();
        boolean changed = false;
        while (entryIterator.hasNext()) {
            Entry<E> entry = (Entry) entryIterator.next();
            int retainCount = occurrencesToRetain.count(entry.getElement());
            if (retainCount == 0) {
                entryIterator.remove();
                changed = true;
            } else if (retainCount < entry.getCount()) {
                multisetToModify.setCount(entry.getElement(), retainCount);
                changed = true;
            }
        }
        return changed;
    }

    @Beta
    public static boolean removeOccurrences(Multiset<?> multisetToModify, Multiset<?> occurrencesToRemove) {
        return removeOccurrencesImpl(multisetToModify, occurrencesToRemove);
    }

    private static <E> boolean removeOccurrencesImpl(Multiset<E> multisetToModify, Multiset<?> occurrencesToRemove) {
        Preconditions.checkNotNull(multisetToModify);
        Preconditions.checkNotNull(occurrencesToRemove);
        boolean changed = false;
        Iterator<Entry<E>> entryIterator = multisetToModify.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Entry<E> entry = (Entry) entryIterator.next();
            int removeCount = occurrencesToRemove.count(entry.getElement());
            if (removeCount >= entry.getCount()) {
                entryIterator.remove();
                changed = true;
            } else if (removeCount > 0) {
                multisetToModify.remove(entry.getElement(), removeCount);
                changed = true;
            }
        }
        return changed;
    }

    static boolean equalsImpl(Multiset<?> multiset, @Nullable Object object) {
        if (object == multiset) {
            return true;
        }
        if (!(object instanceof Multiset)) {
            return false;
        }
        Multiset<?> that = (Multiset) object;
        if (multiset.size() != that.size() || multiset.entrySet().size() != that.entrySet().size()) {
            return false;
        }
        for (Entry<?> entry : that.entrySet()) {
            if (multiset.count(entry.getElement()) != entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    static <E> boolean addAllImpl(Multiset<E> self, Collection<? extends E> elements) {
        if (elements.isEmpty()) {
            return false;
        }
        if (elements instanceof Multiset) {
            for (Entry<? extends E> entry : cast(elements).entrySet()) {
                self.add(entry.getElement(), entry.getCount());
            }
        } else {
            Iterators.addAll(self, elements.iterator());
        }
        return true;
    }

    static boolean removeAllImpl(Multiset<?> self, Collection<?> elementsToRemove) {
        Collection<?> collection;
        if (elementsToRemove instanceof Multiset) {
            collection = ((Multiset) elementsToRemove).elementSet();
        } else {
            collection = elementsToRemove;
        }
        return self.elementSet().removeAll(collection);
    }

    static boolean retainAllImpl(Multiset<?> self, Collection<?> elementsToRetain) {
        Collection<?> collection;
        if (elementsToRetain instanceof Multiset) {
            collection = ((Multiset) elementsToRetain).elementSet();
        } else {
            collection = elementsToRetain;
        }
        return self.elementSet().retainAll(collection);
    }

    static <E> int setCountImpl(Multiset<E> self, E element, int count) {
        checkNonnegative(count, "count");
        int oldCount = self.count(element);
        int delta = count - oldCount;
        if (delta > 0) {
            self.add(element, delta);
        } else if (delta < 0) {
            self.remove(element, -delta);
        }
        return oldCount;
    }

    static <E> boolean setCountImpl(Multiset<E> self, E element, int oldCount, int newCount) {
        checkNonnegative(oldCount, "oldCount");
        checkNonnegative(newCount, "newCount");
        if (self.count(element) != oldCount) {
            return false;
        }
        self.setCount(element, newCount);
        return true;
    }

    static <E> Iterator<E> iteratorImpl(Multiset<E> multiset) {
        return new MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
    }

    static int sizeImpl(Multiset<?> multiset) {
        long size = 0;
        for (Entry<?> entry : multiset.entrySet()) {
            size += (long) entry.getCount();
        }
        return Ints.saturatedCast(size);
    }

    static void checkNonnegative(int count, String name) {
        boolean z;
        if (count >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "%s cannot be negative: %s", name, Integer.valueOf(count));
    }

    static <T> Multiset<T> cast(Iterable<T> iterable) {
        return (Multiset) iterable;
    }

    static {
        DECREASING_COUNT_ORDERING = new C05832();
    }

    @Beta
    public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> multiset) {
        return ImmutableMultiset.copyFromEntries(DECREASING_COUNT_ORDERING.sortedCopy(multiset.entrySet()));
    }
}
