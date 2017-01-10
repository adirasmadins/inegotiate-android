package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Iterables {

    static abstract class IterableWithToString<E> implements Iterable<E> {
        IterableWithToString() {
        }

        public String toString() {
            return Iterables.toString(this);
        }
    }

    /* renamed from: com.google.common.collect.Iterables.10 */
    static class AnonymousClass10 extends IterableWithToString<T> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ int val$numberToSkip;

        /* renamed from: com.google.common.collect.Iterables.10.1 */
        class C04591 implements Iterator<T> {
            boolean atStart;
            final /* synthetic */ Iterator val$iterator;

            C04591(Iterator it) {
                this.val$iterator = it;
                this.atStart = true;
            }

            public boolean hasNext() {
                return this.val$iterator.hasNext();
            }

            public T next() {
                if (hasNext()) {
                    try {
                        T next = this.val$iterator.next();
                        return next;
                    } finally {
                        this.atStart = false;
                    }
                } else {
                    throw new NoSuchElementException();
                }
            }

            public void remove() {
                if (this.atStart) {
                    throw new IllegalStateException();
                }
                this.val$iterator.remove();
            }
        }

        AnonymousClass10(Iterable iterable, int i) {
            this.val$iterable = iterable;
            this.val$numberToSkip = i;
        }

        public Iterator<T> iterator() {
            Iterator<T> iterator = this.val$iterable.iterator();
            Iterators.skip(iterator, this.val$numberToSkip);
            return new C04591(iterator);
        }
    }

    /* renamed from: com.google.common.collect.Iterables.11 */
    static class AnonymousClass11 extends IterableWithToString<T> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ int val$limitSize;

        AnonymousClass11(Iterable iterable, int i) {
            this.val$iterable = iterable;
            this.val$limitSize = i;
        }

        public Iterator<T> iterator() {
            return Iterators.limit(this.val$iterable.iterator(), this.val$limitSize);
        }
    }

    /* renamed from: com.google.common.collect.Iterables.12 */
    static class AnonymousClass12 implements Iterable<T> {
        final /* synthetic */ Iterable val$iterable;

        AnonymousClass12(Iterable iterable) {
            this.val$iterable = iterable;
        }

        public Iterator<T> iterator() {
            return new ConsumingQueueIterator(null);
        }
    }

    /* renamed from: com.google.common.collect.Iterables.13 */
    static class AnonymousClass13 implements Iterable<T> {
        final /* synthetic */ Iterable val$iterable;

        AnonymousClass13(Iterable iterable) {
            this.val$iterable = iterable;
        }

        public Iterator<T> iterator() {
            return Iterators.consumingIterator(this.val$iterable.iterator());
        }
    }

    /* renamed from: com.google.common.collect.Iterables.14 */
    static class AnonymousClass14 implements Iterable<T> {
        final /* synthetic */ Comparator val$comparator;
        final /* synthetic */ Iterable val$iterables;

        AnonymousClass14(Iterable iterable, Comparator comparator) {
            this.val$iterables = iterable;
            this.val$comparator = comparator;
        }

        public Iterator<T> iterator() {
            return Iterators.mergeSorted(Iterables.transform(this.val$iterables, Iterables.toIterator()), this.val$comparator);
        }
    }

    /* renamed from: com.google.common.collect.Iterables.1 */
    static class C04601 implements Iterable<T> {
        final /* synthetic */ Iterable val$iterable;

        C04601(Iterable iterable) {
            this.val$iterable = iterable;
        }

        public Iterator<T> iterator() {
            return Iterators.cycle(this.val$iterable);
        }

        public String toString() {
            return this.val$iterable.toString() + " (cycled)";
        }
    }

    /* renamed from: com.google.common.collect.Iterables.2 */
    static class C04612 extends IterableWithToString<T> {
        final /* synthetic */ Iterable val$inputs;

        C04612(Iterable iterable) {
            this.val$inputs = iterable;
        }

        public Iterator<T> iterator() {
            return Iterators.concat(Iterables.iterators(this.val$inputs));
        }
    }

    /* renamed from: com.google.common.collect.Iterables.3 */
    static class C04623 extends UnmodifiableIterator<Iterator<? extends T>> {
        final /* synthetic */ Iterator val$iterableIterator;

        C04623(Iterator it) {
            this.val$iterableIterator = it;
        }

        public boolean hasNext() {
            return this.val$iterableIterator.hasNext();
        }

        public Iterator<? extends T> next() {
            return ((Iterable) this.val$iterableIterator.next()).iterator();
        }
    }

    /* renamed from: com.google.common.collect.Iterables.4 */
    static class C04634 extends IterableWithToString<List<T>> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ int val$size;

        C04634(Iterable iterable, int i) {
            this.val$iterable = iterable;
            this.val$size = i;
        }

        public Iterator<List<T>> iterator() {
            return Iterators.partition(this.val$iterable.iterator(), this.val$size);
        }
    }

    /* renamed from: com.google.common.collect.Iterables.5 */
    static class C04645 extends IterableWithToString<List<T>> {
        final /* synthetic */ Iterable val$iterable;
        final /* synthetic */ int val$size;

        C04645(Iterable iterable, int i) {
            this.val$iterable = iterable;
            this.val$size = i;
        }

        public Iterator<List<T>> iterator() {
            return Iterators.paddedPartition(this.val$iterable.iterator(), this.val$size);
        }
    }

    /* renamed from: com.google.common.collect.Iterables.6 */
    static class C04656 extends IterableWithToString<T> {
        final /* synthetic */ Predicate val$predicate;
        final /* synthetic */ Iterable val$unfiltered;

        C04656(Iterable iterable, Predicate predicate) {
            this.val$unfiltered = iterable;
            this.val$predicate = predicate;
        }

        public Iterator<T> iterator() {
            return Iterators.filter(this.val$unfiltered.iterator(), this.val$predicate);
        }
    }

    /* renamed from: com.google.common.collect.Iterables.7 */
    static class C04667 extends IterableWithToString<T> {
        final /* synthetic */ Class val$type;
        final /* synthetic */ Iterable val$unfiltered;

        C04667(Iterable iterable, Class cls) {
            this.val$unfiltered = iterable;
            this.val$type = cls;
        }

        public Iterator<T> iterator() {
            return Iterators.filter(this.val$unfiltered.iterator(), this.val$type);
        }
    }

    /* renamed from: com.google.common.collect.Iterables.8 */
    static class C04678 extends IterableWithToString<T> {
        final /* synthetic */ Iterable val$fromIterable;
        final /* synthetic */ Function val$function;

        C04678(Iterable iterable, Function function) {
            this.val$fromIterable = iterable;
            this.val$function = function;
        }

        public Iterator<T> iterator() {
            return Iterators.transform(this.val$fromIterable.iterator(), this.val$function);
        }
    }

    /* renamed from: com.google.common.collect.Iterables.9 */
    static class C04689 extends IterableWithToString<T> {
        final /* synthetic */ List val$list;
        final /* synthetic */ int val$numberToSkip;

        C04689(int i, List list) {
            this.val$numberToSkip = i;
            this.val$list = list;
        }

        public Iterator<T> iterator() {
            return this.val$numberToSkip >= this.val$list.size() ? Iterators.emptyIterator() : this.val$list.subList(this.val$numberToSkip, this.val$list.size()).iterator();
        }
    }

    private static class ConsumingQueueIterator<T> extends AbstractIterator<T> {
        private final Queue<T> queue;

        private ConsumingQueueIterator(Queue<T> queue) {
            this.queue = queue;
        }

        public T computeNext() {
            try {
                return this.queue.remove();
            } catch (NoSuchElementException e) {
                return endOfData();
            }
        }
    }

    private static final class UnmodifiableIterable<T> implements Iterable<T> {
        private final Iterable<T> iterable;

        private UnmodifiableIterable(Iterable<T> iterable) {
            this.iterable = iterable;
        }

        public Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.iterable.iterator());
        }

        public String toString() {
            return this.iterable.toString();
        }
    }

    private Iterables() {
    }

    public static <T> Iterable<T> unmodifiableIterable(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return ((iterable instanceof UnmodifiableIterable) || (iterable instanceof ImmutableCollection)) ? iterable : new UnmodifiableIterable(null);
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> iterable) {
        return (Iterable) Preconditions.checkNotNull(iterable);
    }

    public static int size(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : Iterators.size(iterable.iterator());
    }

    public static boolean contains(Iterable<?> iterable, @Nullable Object element) {
        boolean z = false;
        if (!(iterable instanceof Collection)) {
            return Iterators.contains(iterable.iterator(), element);
        }
        try {
            return ((Collection) iterable).contains(element);
        } catch (NullPointerException e) {
            return z;
        } catch (ClassCastException e2) {
            return z;
        }
    }

    public static boolean removeAll(Iterable<?> removeFrom, Collection<?> elementsToRemove) {
        return removeFrom instanceof Collection ? ((Collection) removeFrom).removeAll((Collection) Preconditions.checkNotNull(elementsToRemove)) : Iterators.removeAll(removeFrom.iterator(), elementsToRemove);
    }

    public static boolean retainAll(Iterable<?> removeFrom, Collection<?> elementsToRetain) {
        return removeFrom instanceof Collection ? ((Collection) removeFrom).retainAll((Collection) Preconditions.checkNotNull(elementsToRetain)) : Iterators.retainAll(removeFrom.iterator(), elementsToRetain);
    }

    public static <T> boolean removeIf(Iterable<T> removeFrom, Predicate<? super T> predicate) {
        if ((removeFrom instanceof RandomAccess) && (removeFrom instanceof List)) {
            return removeIfFromRandomAccessList((List) removeFrom, (Predicate) Preconditions.checkNotNull(predicate));
        }
        return Iterators.removeIf(removeFrom.iterator(), predicate);
    }

    private static <T> boolean removeIfFromRandomAccessList(List<T> list, Predicate<? super T> predicate) {
        int from = 0;
        int to = 0;
        while (from < list.size()) {
            T element = list.get(from);
            if (!predicate.apply(element)) {
                if (from > to) {
                    try {
                        list.set(to, element);
                    } catch (UnsupportedOperationException e) {
                        slowRemoveIfForRemainingElements(list, predicate, to, from);
                        return true;
                    }
                }
                to++;
            }
            from++;
        }
        list.subList(to, list.size()).clear();
        if (from == to) {
            return false;
        }
        return true;
    }

    private static <T> void slowRemoveIfForRemainingElements(List<T> list, Predicate<? super T> predicate, int to, int from) {
        int n;
        for (n = list.size() - 1; n > from; n--) {
            if (predicate.apply(list.get(n))) {
                list.remove(n);
            }
        }
        for (n = from - 1; n >= to; n--) {
            list.remove(n);
        }
    }

    public static boolean elementsEqual(Iterable<?> iterable1, Iterable<?> iterable2) {
        return Iterators.elementsEqual(iterable1.iterator(), iterable2.iterator());
    }

    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    public static <T> T getOnlyElement(Iterable<T> iterable) {
        return Iterators.getOnlyElement(iterable.iterator());
    }

    public static <T> T getOnlyElement(Iterable<T> iterable, @Nullable T defaultValue) {
        return Iterators.getOnlyElement(iterable.iterator(), defaultValue);
    }

    @GwtIncompatible("Array.newInstance(Class, int)")
    public static <T> T[] toArray(Iterable<? extends T> iterable, Class<T> type) {
        Collection<? extends T> collection = toCollection(iterable);
        return collection.toArray(ObjectArrays.newArray((Class) type, collection.size()));
    }

    static Object[] toArray(Iterable<?> iterable) {
        return toCollection(iterable).toArray();
    }

    private static <E> Collection<E> toCollection(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.newArrayList(iterable.iterator());
    }

    public static <T> boolean addAll(Collection<T> addTo, Iterable<? extends T> elementsToAdd) {
        if (elementsToAdd instanceof Collection) {
            return addTo.addAll(Collections2.cast(elementsToAdd));
        }
        return Iterators.addAll(addTo, elementsToAdd.iterator());
    }

    public static int frequency(Iterable<?> iterable, @Nullable Object element) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).count(element);
        }
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(element) ? 1 : 0;
        } else {
            return Iterators.frequency(iterable.iterator(), element);
        }
    }

    public static <T> Iterable<T> cycle(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new C04601(iterable);
    }

    public static <T> Iterable<T> cycle(T... elements) {
        return cycle(Lists.newArrayList((Object[]) elements));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> a, Iterable<? extends T> b) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        return concat(Arrays.asList(new Iterable[]{a, b}));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> a, Iterable<? extends T> b, Iterable<? extends T> c) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        Preconditions.checkNotNull(c);
        return concat(Arrays.asList(new Iterable[]{a, b, c}));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> a, Iterable<? extends T> b, Iterable<? extends T> c, Iterable<? extends T> d) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(d);
        return concat(Arrays.asList(new Iterable[]{a, b, c, d}));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T>... inputs) {
        return concat(ImmutableList.copyOf((Object[]) inputs));
    }

    public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> inputs) {
        Preconditions.checkNotNull(inputs);
        return new C04612(inputs);
    }

    private static <T> UnmodifiableIterator<Iterator<? extends T>> iterators(Iterable<? extends Iterable<? extends T>> iterables) {
        return new C04623(iterables.iterator());
    }

    public static <T> Iterable<List<T>> partition(Iterable<T> iterable, int size) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(size > 0);
        return new C04634(iterable, size);
    }

    public static <T> Iterable<List<T>> paddedPartition(Iterable<T> iterable, int size) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(size > 0);
        return new C04645(iterable, size);
    }

    public static <T> Iterable<T> filter(Iterable<T> unfiltered, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(unfiltered);
        Preconditions.checkNotNull(predicate);
        return new C04656(unfiltered, predicate);
    }

    @GwtIncompatible("Class.isInstance")
    public static <T> Iterable<T> filter(Iterable<?> unfiltered, Class<T> type) {
        Preconditions.checkNotNull(unfiltered);
        Preconditions.checkNotNull(type);
        return new C04667(unfiltered, type);
    }

    public static <T> boolean any(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.any(iterable.iterator(), predicate);
    }

    public static <T> boolean all(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.all(iterable.iterator(), predicate);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.find(iterable.iterator(), predicate);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate, @Nullable T defaultValue) {
        return Iterators.find(iterable.iterator(), predicate, defaultValue);
    }

    public static <T> Optional<T> tryFind(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.tryFind(iterable.iterator(), predicate);
    }

    public static <T> int indexOf(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.indexOf(iterable.iterator(), predicate);
    }

    public static <F, T> Iterable<T> transform(Iterable<F> fromIterable, Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(fromIterable);
        Preconditions.checkNotNull(function);
        return new C04678(fromIterable, function);
    }

    public static <T> T get(Iterable<T> iterable, int position) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof List) {
            return ((List) iterable).get(position);
        }
        if (iterable instanceof Collection) {
            Preconditions.checkElementIndex(position, ((Collection) iterable).size());
        } else {
            checkNonnegativeIndex(position);
        }
        return Iterators.get(iterable.iterator(), position);
    }

    private static void checkNonnegativeIndex(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("position cannot be negative: " + position);
        }
    }

    public static <T> T get(Iterable<T> iterable, int position, @Nullable T defaultValue) {
        Preconditions.checkNotNull(iterable);
        checkNonnegativeIndex(position);
        try {
            defaultValue = get(iterable, position);
        } catch (IndexOutOfBoundsException e) {
        }
        return defaultValue;
    }

    public static <T> T getFirst(Iterable<T> iterable, @Nullable T defaultValue) {
        return Iterators.getNext(iterable.iterator(), defaultValue);
    }

    public static <T> T getLast(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List<T> list = (List) iterable;
            if (!list.isEmpty()) {
                return getLastInNonemptyList(list);
            }
            throw new NoSuchElementException();
        } else if (iterable instanceof SortedSet) {
            return ((SortedSet) iterable).last();
        } else {
            return Iterators.getLast(iterable.iterator());
        }
    }

    public static <T> T getLast(Iterable<T> iterable, @Nullable T defaultValue) {
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return defaultValue;
        }
        if (iterable instanceof List) {
            return getLastInNonemptyList((List) iterable);
        }
        if (iterable instanceof SortedSet) {
            return ((SortedSet) iterable).last();
        }
        return Iterators.getLast(iterable.iterator(), defaultValue);
    }

    private static <T> T getLastInNonemptyList(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> Iterable<T> skip(Iterable<T> iterable, int numberToSkip) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(numberToSkip >= 0, "number to skip cannot be negative");
        return iterable instanceof List ? new C04689(numberToSkip, (List) iterable) : new AnonymousClass10(iterable, numberToSkip);
    }

    public static <T> Iterable<T> limit(Iterable<T> iterable, int limitSize) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(limitSize >= 0, "limit is negative");
        return new AnonymousClass11(iterable, limitSize);
    }

    public static <T> Iterable<T> consumingIterable(Iterable<T> iterable) {
        if (iterable instanceof Queue) {
            return new AnonymousClass12(iterable);
        }
        Preconditions.checkNotNull(iterable);
        return new AnonymousClass13(iterable);
    }

    @Deprecated
    public static <T> Iterable<T> reverse(List<T> list) {
        return Lists.reverse(list);
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    static boolean remove(Iterable<?> iterable, @Nullable Object o) {
        Iterator<?> i = iterable.iterator();
        while (i.hasNext()) {
            if (Objects.equal(i.next(), o)) {
                i.remove();
                return true;
            }
        }
        return false;
    }

    @Beta
    public static <T> Iterable<T> mergeSorted(Iterable<? extends Iterable<? extends T>> iterables, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterables, "iterables");
        Preconditions.checkNotNull(comparator, "comparator");
        return new UnmodifiableIterable(null);
    }

    private static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator() {
        return new Function<Iterable<? extends T>, Iterator<? extends T>>() {
            public Iterator<? extends T> apply(Iterable<? extends T> iterable) {
                return iterable.iterator();
            }
        };
    }
}
