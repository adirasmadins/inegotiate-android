package com.google.common.collect;

import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Iterators {
    static final UnmodifiableIterator<Object> EMPTY_ITERATOR;
    private static final Iterator<Object> EMPTY_MODIFIABLE_ITERATOR;

    /* renamed from: com.google.common.collect.Iterators.10 */
    static class AnonymousClass10 extends UnmodifiableIterator<T> {
        final /* synthetic */ Iterator val$iterator;

        AnonymousClass10(Iterator it) {
            this.val$iterator = it;
        }

        public boolean hasNext() {
            return this.val$iterator.hasNext();
        }

        public T next() {
            T next = this.val$iterator.next();
            this.val$iterator.remove();
            return next;
        }
    }

    /* renamed from: com.google.common.collect.Iterators.11 */
    static class AnonymousClass11 extends AbstractIndexedListIterator<T> {
        final /* synthetic */ Object[] val$array;

        AnonymousClass11(int x0, Object[] objArr) {
            this.val$array = objArr;
            super(x0);
        }

        protected T get(int index) {
            return this.val$array[index];
        }
    }

    /* renamed from: com.google.common.collect.Iterators.12 */
    static class AnonymousClass12 extends AbstractIndexedListIterator<T> {
        final /* synthetic */ Object[] val$array;
        final /* synthetic */ int val$offset;

        AnonymousClass12(int x0, Object[] objArr, int i) {
            this.val$array = objArr;
            this.val$offset = i;
            super(x0);
        }

        protected T get(int index) {
            return this.val$array[this.val$offset + index];
        }
    }

    /* renamed from: com.google.common.collect.Iterators.13 */
    static class AnonymousClass13 extends UnmodifiableIterator<T> {
        boolean done;
        final /* synthetic */ Object val$value;

        AnonymousClass13(Object obj) {
            this.val$value = obj;
        }

        public boolean hasNext() {
            return !this.done;
        }

        public T next() {
            if (this.done) {
                throw new NoSuchElementException();
            }
            this.done = true;
            return this.val$value;
        }
    }

    /* renamed from: com.google.common.collect.Iterators.14 */
    static class AnonymousClass14 extends UnmodifiableIterator<T> {
        final /* synthetic */ Enumeration val$enumeration;

        AnonymousClass14(Enumeration enumeration) {
            this.val$enumeration = enumeration;
        }

        public boolean hasNext() {
            return this.val$enumeration.hasMoreElements();
        }

        public T next() {
            return this.val$enumeration.nextElement();
        }
    }

    /* renamed from: com.google.common.collect.Iterators.15 */
    static class AnonymousClass15 implements Enumeration<T> {
        final /* synthetic */ Iterator val$iterator;

        AnonymousClass15(Iterator it) {
            this.val$iterator = it;
        }

        public boolean hasMoreElements() {
            return this.val$iterator.hasNext();
        }

        public T nextElement() {
            return this.val$iterator.next();
        }
    }

    /* renamed from: com.google.common.collect.Iterators.1 */
    static class C04691 extends UnmodifiableIterator<Object> {
        C04691() {
        }

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }
    }

    /* renamed from: com.google.common.collect.Iterators.2 */
    static class C04702 implements Iterator<Object> {
        C04702() {
        }

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* renamed from: com.google.common.collect.Iterators.3 */
    static class C04713 extends UnmodifiableIterator<T> {
        final /* synthetic */ Iterator val$iterator;

        C04713(Iterator it) {
            this.val$iterator = it;
        }

        public boolean hasNext() {
            return this.val$iterator.hasNext();
        }

        public T next() {
            return this.val$iterator.next();
        }
    }

    /* renamed from: com.google.common.collect.Iterators.4 */
    static class C04724 implements Iterator<T> {
        Iterator<T> iterator;
        Iterator<T> removeFrom;
        final /* synthetic */ Iterable val$iterable;

        C04724(Iterable iterable) {
            this.val$iterable = iterable;
            this.iterator = Iterators.emptyIterator();
        }

        public boolean hasNext() {
            if (!this.iterator.hasNext()) {
                this.iterator = this.val$iterable.iterator();
            }
            return this.iterator.hasNext();
        }

        public T next() {
            if (hasNext()) {
                this.removeFrom = this.iterator;
                return this.iterator.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Preconditions.checkState(this.removeFrom != null, "no calls to next() since last call to remove()");
            this.removeFrom.remove();
            this.removeFrom = null;
        }
    }

    /* renamed from: com.google.common.collect.Iterators.5 */
    static class C04735 implements Iterator<T> {
        Iterator<? extends T> current;
        Iterator<? extends T> removeFrom;
        final /* synthetic */ Iterator val$inputs;

        C04735(Iterator it) {
            this.val$inputs = it;
            this.current = Iterators.emptyIterator();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean hasNext() {
            /*
            r2 = this;
        L_0x0000:
            r1 = r2.current;
            r1 = com.google.common.base.Preconditions.checkNotNull(r1);
            r1 = (java.util.Iterator) r1;
            r0 = r1.hasNext();
            if (r0 != 0) goto L_0x0021;
        L_0x000e:
            r1 = r2.val$inputs;
            r1 = r1.hasNext();
            if (r1 == 0) goto L_0x0021;
        L_0x0016:
            r1 = r2.val$inputs;
            r1 = r1.next();
            r1 = (java.util.Iterator) r1;
            r2.current = r1;
            goto L_0x0000;
        L_0x0021:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.5.hasNext():boolean");
        }

        public T next() {
            if (hasNext()) {
                this.removeFrom = this.current;
                return this.current.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Preconditions.checkState(this.removeFrom != null, "no calls to next() since last call to remove()");
            this.removeFrom.remove();
            this.removeFrom = null;
        }
    }

    /* renamed from: com.google.common.collect.Iterators.6 */
    static class C04746 extends UnmodifiableIterator<List<T>> {
        final /* synthetic */ Iterator val$iterator;
        final /* synthetic */ boolean val$pad;
        final /* synthetic */ int val$size;

        C04746(Iterator it, int i, boolean z) {
            this.val$iterator = it;
            this.val$size = i;
            this.val$pad = z;
        }

        public boolean hasNext() {
            return this.val$iterator.hasNext();
        }

        public List<T> next() {
            if (hasNext()) {
                Object[] array = new Object[this.val$size];
                int count = 0;
                while (count < this.val$size && this.val$iterator.hasNext()) {
                    array[count] = this.val$iterator.next();
                    count++;
                }
                for (int i = count; i < this.val$size; i++) {
                    array[i] = null;
                }
                List<T> list = Collections.unmodifiableList(Arrays.asList(array));
                return (this.val$pad || count == this.val$size) ? list : list.subList(0, count);
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    /* renamed from: com.google.common.collect.Iterators.7 */
    static class C04757 extends AbstractIterator<T> {
        final /* synthetic */ Predicate val$predicate;
        final /* synthetic */ Iterator val$unfiltered;

        C04757(Iterator it, Predicate predicate) {
            this.val$unfiltered = it;
            this.val$predicate = predicate;
        }

        protected T computeNext() {
            while (this.val$unfiltered.hasNext()) {
                T element = this.val$unfiltered.next();
                if (this.val$predicate.apply(element)) {
                    return element;
                }
            }
            return endOfData();
        }
    }

    /* renamed from: com.google.common.collect.Iterators.8 */
    static class C04768 implements Iterator<T> {
        final /* synthetic */ Iterator val$fromIterator;
        final /* synthetic */ Function val$function;

        C04768(Iterator it, Function function) {
            this.val$fromIterator = it;
            this.val$function = function;
        }

        public boolean hasNext() {
            return this.val$fromIterator.hasNext();
        }

        public T next() {
            return this.val$function.apply(this.val$fromIterator.next());
        }

        public void remove() {
            this.val$fromIterator.remove();
        }
    }

    /* renamed from: com.google.common.collect.Iterators.9 */
    static class C04779 implements Iterator<T> {
        private int count;
        final /* synthetic */ Iterator val$iterator;
        final /* synthetic */ int val$limitSize;

        C04779(int i, Iterator it) {
            this.val$limitSize = i;
            this.val$iterator = it;
        }

        public boolean hasNext() {
            return this.count < this.val$limitSize && this.val$iterator.hasNext();
        }

        public T next() {
            if (hasNext()) {
                this.count++;
                return this.val$iterator.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            this.val$iterator.remove();
        }
    }

    private static class MergingIterator<T> extends AbstractIterator<T> {
        final Comparator<? super T> comparator;
        final Queue<PeekingIterator<T>> queue;

        /* renamed from: com.google.common.collect.Iterators.MergingIterator.1 */
        class C04781 implements Comparator<PeekingIterator<T>> {
            C04781() {
            }

            public int compare(PeekingIterator<T> o1, PeekingIterator<T> o2) {
                return MergingIterator.this.comparator.compare(o1.peek(), o2.peek());
            }
        }

        public MergingIterator(Iterable<? extends Iterator<? extends T>> iterators, Comparator<? super T> itemComparator) {
            this.comparator = itemComparator;
            this.queue = new PriorityQueue(2, new C04781());
            for (Iterator iterator : iterators) {
                if (iterator.hasNext()) {
                    this.queue.add(Iterators.peekingIterator(iterator));
                }
            }
        }

        protected T computeNext() {
            if (this.queue.isEmpty()) {
                return endOfData();
            }
            PeekingIterator<T> nextIter = (PeekingIterator) this.queue.poll();
            T next = nextIter.next();
            if (!nextIter.hasNext()) {
                return next;
            }
            this.queue.add(nextIter);
            return next;
        }
    }

    private static class PeekingImpl<E> implements PeekingIterator<E> {
        private boolean hasPeeked;
        private final Iterator<? extends E> iterator;
        private E peekedElement;

        public PeekingImpl(Iterator<? extends E> iterator) {
            this.iterator = (Iterator) Preconditions.checkNotNull(iterator);
        }

        public boolean hasNext() {
            return this.hasPeeked || this.iterator.hasNext();
        }

        public E next() {
            if (!this.hasPeeked) {
                return this.iterator.next();
            }
            E result = this.peekedElement;
            this.hasPeeked = false;
            this.peekedElement = null;
            return result;
        }

        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }

        public E peek() {
            if (!this.hasPeeked) {
                this.peekedElement = this.iterator.next();
                this.hasPeeked = true;
            }
            return this.peekedElement;
        }
    }

    private Iterators() {
    }

    static {
        EMPTY_ITERATOR = new C04691();
        EMPTY_MODIFIABLE_ITERATOR = new C04702();
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return EMPTY_ITERATOR;
    }

    static <T> Iterator<T> emptyModifiableIterator() {
        return EMPTY_MODIFIABLE_ITERATOR;
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(Iterator<T> iterator) {
        Preconditions.checkNotNull(iterator);
        if (iterator instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) iterator;
        }
        return new C04713(iterator);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> iterator) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(iterator);
    }

    public static int size(Iterator<?> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    public static boolean contains(Iterator<?> iterator, @Nullable Object element) {
        if (element == null) {
            while (iterator.hasNext()) {
                if (iterator.next() == null) {
                    return true;
                }
            }
        }
        while (iterator.hasNext()) {
            if (element.equals(iterator.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean removeAll(Iterator<?> removeFrom, Collection<?> elementsToRemove) {
        Preconditions.checkNotNull(elementsToRemove);
        boolean modified = false;
        while (removeFrom.hasNext()) {
            if (elementsToRemove.contains(removeFrom.next())) {
                removeFrom.remove();
                modified = true;
            }
        }
        return modified;
    }

    public static <T> boolean removeIf(Iterator<T> removeFrom, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean modified = false;
        while (removeFrom.hasNext()) {
            if (predicate.apply(removeFrom.next())) {
                removeFrom.remove();
                modified = true;
            }
        }
        return modified;
    }

    public static boolean retainAll(Iterator<?> removeFrom, Collection<?> elementsToRetain) {
        Preconditions.checkNotNull(elementsToRetain);
        boolean modified = false;
        while (removeFrom.hasNext()) {
            if (!elementsToRetain.contains(removeFrom.next())) {
                removeFrom.remove();
                modified = true;
            }
        }
        return modified;
    }

    public static boolean elementsEqual(Iterator<?> iterator1, Iterator<?> iterator2) {
        while (iterator1.hasNext()) {
            if (!iterator2.hasNext()) {
                return false;
            }
            if (!Objects.equal(iterator1.next(), iterator2.next())) {
                return false;
            }
        }
        if (iterator2.hasNext()) {
            return false;
        }
        return true;
    }

    public static String toString(Iterator<?> iterator) {
        if (!iterator.hasNext()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append('[').append(iterator.next());
        while (iterator.hasNext()) {
            builder.append(", ").append(iterator.next());
        }
        return builder.append(']').toString();
    }

    public static <T> T getOnlyElement(Iterator<T> iterator) {
        T first = iterator.next();
        if (!iterator.hasNext()) {
            return first;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <" + first);
        for (int i = 0; i < 4 && iterator.hasNext(); i++) {
            sb.append(", " + iterator.next());
        }
        if (iterator.hasNext()) {
            sb.append(", ...");
        }
        sb.append(XMLStreamWriterImpl.CLOSE_START_TAG);
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> T getOnlyElement(Iterator<T> iterator, @Nullable T defaultValue) {
        return iterator.hasNext() ? getOnlyElement(iterator) : defaultValue;
    }

    @GwtIncompatible("Array.newInstance(Class, int)")
    public static <T> T[] toArray(Iterator<? extends T> iterator, Class<T> type) {
        return Iterables.toArray(Lists.newArrayList((Iterator) iterator), type);
    }

    public static <T> boolean addAll(Collection<T> addTo, Iterator<? extends T> iterator) {
        Preconditions.checkNotNull(addTo);
        boolean wasModified = false;
        while (iterator.hasNext()) {
            wasModified |= addTo.add(iterator.next());
        }
        return wasModified;
    }

    public static int frequency(Iterator<?> iterator, @Nullable Object element) {
        int result = 0;
        if (element == null) {
            while (iterator.hasNext()) {
                if (iterator.next() == null) {
                    result++;
                }
            }
        } else {
            while (iterator.hasNext()) {
                if (element.equals(iterator.next())) {
                    result++;
                }
            }
        }
        return result;
    }

    public static <T> Iterator<T> cycle(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new C04724(iterable);
    }

    public static <T> Iterator<T> cycle(T... elements) {
        return cycle(Lists.newArrayList((Object[]) elements));
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        return concat(Arrays.asList(new Iterator[]{a, b}).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b, Iterator<? extends T> c) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        Preconditions.checkNotNull(c);
        return concat(Arrays.asList(new Iterator[]{a, b, c}).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b, Iterator<? extends T> c, Iterator<? extends T> d) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(d);
        return concat(Arrays.asList(new Iterator[]{a, b, c, d}).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T>... inputs) {
        return concat(ImmutableList.copyOf((Object[]) inputs).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> inputs) {
        Preconditions.checkNotNull(inputs);
        return new C04735(inputs);
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> iterator, int size) {
        return partitionImpl(iterator, size, false);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> iterator, int size) {
        return partitionImpl(iterator, size, true);
    }

    private static <T> UnmodifiableIterator<List<T>> partitionImpl(Iterator<T> iterator, int size, boolean pad) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(size > 0);
        return new C04746(iterator, size, pad);
    }

    public static <T> UnmodifiableIterator<T> filter(Iterator<T> unfiltered, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(unfiltered);
        Preconditions.checkNotNull(predicate);
        return new C04757(unfiltered, predicate);
    }

    @GwtIncompatible("Class.isInstance")
    public static <T> UnmodifiableIterator<T> filter(Iterator<?> unfiltered, Class<T> type) {
        return filter((Iterator) unfiltered, Predicates.instanceOf(type));
    }

    public static <T> boolean any(Iterator<T> iterator, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (iterator.hasNext()) {
            if (predicate.apply(iterator.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean all(Iterator<T> iterator, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.apply(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> T find(Iterator<T> iterator, Predicate<? super T> predicate) {
        return filter((Iterator) iterator, (Predicate) predicate).next();
    }

    public static <T> T find(Iterator<T> iterator, Predicate<? super T> predicate, @Nullable T defaultValue) {
        UnmodifiableIterator<T> filteredIterator = filter((Iterator) iterator, (Predicate) predicate);
        return filteredIterator.hasNext() ? filteredIterator.next() : defaultValue;
    }

    public static <T> Optional<T> tryFind(Iterator<T> iterator, Predicate<? super T> predicate) {
        UnmodifiableIterator<T> filteredIterator = filter((Iterator) iterator, (Predicate) predicate);
        return filteredIterator.hasNext() ? Optional.of(filteredIterator.next()) : Optional.absent();
    }

    public static <T> int indexOf(Iterator<T> iterator, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.apply(iterator.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <F, T> Iterator<T> transform(Iterator<F> fromIterator, Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(fromIterator);
        Preconditions.checkNotNull(function);
        return new C04768(fromIterator, function);
    }

    public static <T> T get(Iterator<T> iterator, int position) {
        checkNonnegative(position);
        int skipped = 0;
        while (iterator.hasNext()) {
            T t = iterator.next();
            int skipped2 = skipped + 1;
            if (skipped == position) {
                return t;
            }
            skipped = skipped2;
        }
        throw new IndexOutOfBoundsException("position (" + position + ") must be less than the number of elements that remained (" + skipped + ")");
    }

    private static void checkNonnegative(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("position (" + position + ") must not be negative");
        }
    }

    public static <T> T get(Iterator<T> iterator, int position, @Nullable T defaultValue) {
        checkNonnegative(position);
        try {
            defaultValue = get(iterator, position);
        } catch (IndexOutOfBoundsException e) {
        }
        return defaultValue;
    }

    public static <T> T getNext(Iterator<T> iterator, @Nullable T defaultValue) {
        return iterator.hasNext() ? iterator.next() : defaultValue;
    }

    public static <T> T getLast(Iterator<T> iterator) {
        T current;
        do {
            current = iterator.next();
        } while (iterator.hasNext());
        return current;
    }

    public static <T> T getLast(Iterator<T> iterator, @Nullable T defaultValue) {
        return iterator.hasNext() ? getLast(iterator) : defaultValue;
    }

    @Beta
    public static <T> int skip(Iterator<T> iterator, int numberToSkip) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(numberToSkip >= 0, "number to skip cannot be negative");
        int i = 0;
        while (i < numberToSkip && iterator.hasNext()) {
            iterator.next();
            i++;
        }
        return i;
    }

    public static <T> Iterator<T> limit(Iterator<T> iterator, int limitSize) {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkArgument(limitSize >= 0, "limit is negative");
        return new C04779(limitSize, iterator);
    }

    public static <T> Iterator<T> consumingIterator(Iterator<T> iterator) {
        Preconditions.checkNotNull(iterator);
        return new AnonymousClass10(iterator);
    }

    static void clear(Iterator<?> iterator) {
        Preconditions.checkNotNull(iterator);
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    public static <T> UnmodifiableIterator<T> forArray(T... array) {
        Preconditions.checkNotNull(array);
        return new AnonymousClass11(array.length, array);
    }

    static <T> UnmodifiableIterator<T> forArray(T[] array, int offset, int length) {
        Preconditions.checkArgument(length >= 0);
        Preconditions.checkPositionIndexes(offset, offset + length, array.length);
        return new AnonymousClass12(length, array, offset);
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@Nullable T value) {
        return new AnonymousClass13(value);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new AnonymousClass14(enumeration);
    }

    public static <T> Enumeration<T> asEnumeration(Iterator<T> iterator) {
        Preconditions.checkNotNull(iterator);
        return new AnonymousClass15(iterator);
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> iterator) {
        if (iterator instanceof PeekingImpl) {
            return (PeekingImpl) iterator;
        }
        return new PeekingImpl(iterator);
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> iterator) {
        return (PeekingIterator) Preconditions.checkNotNull(iterator);
    }

    @Beta
    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterators, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterators, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new MergingIterator(iterators, comparator);
    }
}
