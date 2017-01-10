package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Sets {

    public static abstract class SetView<E> extends AbstractSet<E> {
        private SetView() {
        }

        public ImmutableSet<E> immutableCopy() {
            return ImmutableSet.copyOf((Collection) this);
        }

        public <S extends Set<E>> S copyInto(S set) {
            set.addAll(this);
            return set;
        }
    }

    /* renamed from: com.google.common.collect.Sets.1 */
    static class C06001 extends SetView<E> {
        final /* synthetic */ Set val$set1;
        final /* synthetic */ Set val$set2;
        final /* synthetic */ Set val$set2minus1;

        C06001(Set set, Set set2, Set set3) {
            this.val$set1 = set;
            this.val$set2minus1 = set2;
            this.val$set2 = set3;
            super();
        }

        public int size() {
            return this.val$set1.size() + this.val$set2minus1.size();
        }

        public boolean isEmpty() {
            return this.val$set1.isEmpty() && this.val$set2.isEmpty();
        }

        public Iterator<E> iterator() {
            return Iterators.unmodifiableIterator(Iterators.concat(this.val$set1.iterator(), this.val$set2minus1.iterator()));
        }

        public boolean contains(Object object) {
            return this.val$set1.contains(object) || this.val$set2.contains(object);
        }

        public <S extends Set<E>> S copyInto(S set) {
            set.addAll(this.val$set1);
            set.addAll(this.val$set2);
            return set;
        }

        public ImmutableSet<E> immutableCopy() {
            return new Builder().addAll(this.val$set1).addAll(this.val$set2).build();
        }
    }

    /* renamed from: com.google.common.collect.Sets.2 */
    static class C06012 extends SetView<E> {
        final /* synthetic */ Predicate val$inSet2;
        final /* synthetic */ Set val$set1;
        final /* synthetic */ Set val$set2;

        C06012(Set set, Predicate predicate, Set set2) {
            this.val$set1 = set;
            this.val$inSet2 = predicate;
            this.val$set2 = set2;
            super();
        }

        public Iterator<E> iterator() {
            return Iterators.filter(this.val$set1.iterator(), this.val$inSet2);
        }

        public int size() {
            return Iterators.size(iterator());
        }

        public boolean isEmpty() {
            return !iterator().hasNext();
        }

        public boolean contains(Object object) {
            return this.val$set1.contains(object) && this.val$set2.contains(object);
        }

        public boolean containsAll(Collection<?> collection) {
            return this.val$set1.containsAll(collection) && this.val$set2.containsAll(collection);
        }
    }

    /* renamed from: com.google.common.collect.Sets.3 */
    static class C06023 extends SetView<E> {
        final /* synthetic */ Predicate val$notInSet2;
        final /* synthetic */ Set val$set1;
        final /* synthetic */ Set val$set2;

        C06023(Set set, Predicate predicate, Set set2) {
            this.val$set1 = set;
            this.val$notInSet2 = predicate;
            this.val$set2 = set2;
            super();
        }

        public Iterator<E> iterator() {
            return Iterators.filter(this.val$set1.iterator(), this.val$notInSet2);
        }

        public int size() {
            return Iterators.size(iterator());
        }

        public boolean isEmpty() {
            return this.val$set2.containsAll(this.val$set1);
        }

        public boolean contains(Object element) {
            return this.val$set1.contains(element) && !this.val$set2.contains(element);
        }
    }

    private static class CartesianSet<B> extends AbstractSet<List<B>> {
        final ImmutableList<Axis> axes;
        final int size;

        /* renamed from: com.google.common.collect.Sets.CartesianSet.1 */
        class C06031 extends UnmodifiableIterator<List<B>> {
            int index;

            C06031() {
            }

            public boolean hasNext() {
                return this.index < CartesianSet.this.size;
            }

            public List<B> next() {
                if (hasNext()) {
                    Object[] tuple = new Object[CartesianSet.this.axes.size()];
                    for (int i = 0; i < tuple.length; i++) {
                        tuple[i] = ((Axis) CartesianSet.this.axes.get(i)).getForIndex(this.index);
                    }
                    this.index++;
                    return ImmutableList.copyOf(tuple);
                }
                throw new NoSuchElementException();
            }
        }

        private class Axis {
            final ImmutableSet<? extends B> choices;
            final ImmutableList<? extends B> choicesList;
            final int dividend;

            Axis(Set<? extends B> set, int dividend) {
                this.choices = ImmutableSet.copyOf((Collection) set);
                this.choicesList = this.choices.asList();
                this.dividend = dividend;
            }

            int size() {
                return this.choices.size();
            }

            B getForIndex(int index) {
                return this.choicesList.get((index / this.dividend) % size());
            }

            boolean contains(Object target) {
                return this.choices.contains(target);
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof Axis)) {
                    return false;
                }
                return this.choices.equals(((Axis) obj).choices);
            }

            public int hashCode() {
                return (CartesianSet.this.size / this.choices.size()) * this.choices.hashCode();
            }
        }

        CartesianSet(List<? extends Set<? extends B>> sets) {
            int dividend = 1;
            ImmutableList.Builder<Axis> builder = ImmutableList.builder();
            try {
                for (Set<? extends B> set : sets) {
                    Object axis = new Axis(set, dividend);
                    builder.add(axis);
                    dividend = IntMath.checkedMultiply(dividend, axis.size());
                }
                this.axes = builder.build();
                this.size = dividend;
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException("cartesian product too big");
            }
        }

        public int size() {
            return this.size;
        }

        public UnmodifiableIterator<List<B>> iterator() {
            return new C06031();
        }

        public boolean contains(Object element) {
            if (!(element instanceof List)) {
                return false;
            }
            List<?> tuple = (List) element;
            int dimensions = this.axes.size();
            if (tuple.size() != dimensions) {
                return false;
            }
            for (int i = 0; i < dimensions; i++) {
                if (!((Axis) this.axes.get(i)).contains(tuple.get(i))) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(@Nullable Object object) {
            if (!(object instanceof CartesianSet)) {
                return super.equals(object);
            }
            return this.axes.equals(((CartesianSet) object).axes);
        }

        public int hashCode() {
            int adjust = this.size - 1;
            for (int i = 0; i < this.axes.size(); i++) {
                adjust *= 31;
            }
            return this.axes.hashCode() + adjust;
        }
    }

    private static class FilteredSet<E> extends FilteredCollection<E> implements Set<E> {
        FilteredSet(Set<E> unfiltered, Predicate<? super E> predicate) {
            super(unfiltered, predicate);
        }

        public boolean equals(@Nullable Object object) {
            return Sets.equalsImpl(this, object);
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    private static class FilteredSortedSet<E> extends FilteredCollection<E> implements SortedSet<E> {
        FilteredSortedSet(SortedSet<E> unfiltered, Predicate<? super E> predicate) {
            super(unfiltered, predicate);
        }

        public boolean equals(@Nullable Object object) {
            return Sets.equalsImpl(this, object);
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        public Comparator<? super E> comparator() {
            return ((SortedSet) this.unfiltered).comparator();
        }

        public SortedSet<E> subSet(E fromElement, E toElement) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).subSet(fromElement, toElement), this.predicate);
        }

        public SortedSet<E> headSet(E toElement) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).headSet(toElement), this.predicate);
        }

        public SortedSet<E> tailSet(E fromElement) {
            return new FilteredSortedSet(((SortedSet) this.unfiltered).tailSet(fromElement), this.predicate);
        }

        public E first() {
            return iterator().next();
        }

        public E last() {
            SortedSet<E> sortedUnfiltered = (SortedSet) this.unfiltered;
            while (true) {
                E element = sortedUnfiltered.last();
                if (this.predicate.apply(element)) {
                    return element;
                }
                sortedUnfiltered = sortedUnfiltered.headSet(element);
            }
        }
    }

    static abstract class InvertibleFunction<A, B> implements Function<A, B> {

        /* renamed from: com.google.common.collect.Sets.InvertibleFunction.1 */
        class C06041 extends InvertibleFunction<B, A> {
            C06041() {
            }

            public A apply(B b) {
                return InvertibleFunction.this.invert(b);
            }

            B invert(A a) {
                return InvertibleFunction.this.apply(a);
            }

            public InvertibleFunction<A, B> inverse() {
                return InvertibleFunction.this;
            }
        }

        abstract A invert(B b);

        InvertibleFunction() {
        }

        public InvertibleFunction<B, A> inverse() {
            return new C06041();
        }
    }

    private static final class PowerSet<E> extends AbstractSet<Set<E>> {
        final ImmutableList<E> inputList;
        final ImmutableSet<E> inputSet;
        final int powerSetSize;

        /* renamed from: com.google.common.collect.Sets.PowerSet.1 */
        class C06061 extends AbstractIndexedListIterator<Set<E>> {

            /* renamed from: com.google.common.collect.Sets.PowerSet.1.1 */
            class C06051 extends AbstractSet<E> {
                final /* synthetic */ int val$setBits;

                C06051(int i) {
                    this.val$setBits = i;
                }

                public int size() {
                    return Integer.bitCount(this.val$setBits);
                }

                public Iterator<E> iterator() {
                    return new BitFilteredSetIterator(PowerSet.this.inputList, this.val$setBits);
                }
            }

            C06061(int x0) {
                super(x0);
            }

            protected Set<E> get(int setBits) {
                return new C06051(setBits);
            }
        }

        private static final class BitFilteredSetIterator<E> extends UnmodifiableIterator<E> {
            final ImmutableList<E> input;
            int remainingSetBits;

            BitFilteredSetIterator(ImmutableList<E> input, int allSetBits) {
                this.input = input;
                this.remainingSetBits = allSetBits;
            }

            public boolean hasNext() {
                return this.remainingSetBits != 0;
            }

            public E next() {
                int index = Integer.numberOfTrailingZeros(this.remainingSetBits);
                if (index == 32) {
                    throw new NoSuchElementException();
                }
                this.remainingSetBits &= (1 << index) ^ -1;
                return this.input.get(index);
            }
        }

        PowerSet(ImmutableSet<E> input) {
            this.inputSet = input;
            this.inputList = input.asList();
            this.powerSetSize = 1 << input.size();
        }

        public int size() {
            return this.powerSetSize;
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator<Set<E>> iterator() {
            return new C06061(this.powerSetSize);
        }

        public boolean contains(@Nullable Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.inputSet.containsAll((Set) obj);
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof PowerSet)) {
                return super.equals(obj);
            }
            return this.inputSet.equals(((PowerSet) obj).inputSet);
        }

        public int hashCode() {
            return this.inputSet.hashCode() << (this.inputSet.size() - 1);
        }

        public String toString() {
            return "powerSet(" + this.inputSet + ")";
        }
    }

    private static class SetFromMap<E> extends AbstractSet<E> implements Set<E>, Serializable {
        @GwtIncompatible("not needed in emulated source")
        private static final long serialVersionUID = 0;
        private final Map<E, Boolean> f438m;
        private transient Set<E> f439s;

        SetFromMap(Map<E, Boolean> map) {
            Preconditions.checkArgument(map.isEmpty(), "Map is non-empty");
            this.f438m = map;
            this.f439s = map.keySet();
        }

        public void clear() {
            this.f438m.clear();
        }

        public int size() {
            return this.f438m.size();
        }

        public boolean isEmpty() {
            return this.f438m.isEmpty();
        }

        public boolean contains(Object o) {
            return this.f438m.containsKey(o);
        }

        public boolean remove(Object o) {
            return this.f438m.remove(o) != null;
        }

        public boolean add(E e) {
            return this.f438m.put(e, Boolean.TRUE) == null;
        }

        public Iterator<E> iterator() {
            return this.f439s.iterator();
        }

        public Object[] toArray() {
            return this.f439s.toArray();
        }

        public <T> T[] toArray(T[] a) {
            return this.f439s.toArray(a);
        }

        public String toString() {
            return this.f439s.toString();
        }

        public int hashCode() {
            return this.f439s.hashCode();
        }

        public boolean equals(@Nullable Object object) {
            return this == object || this.f439s.equals(object);
        }

        public boolean containsAll(Collection<?> c) {
            return this.f439s.containsAll(c);
        }

        public boolean removeAll(Collection<?> c) {
            return this.f439s.removeAll(c);
        }

        public boolean retainAll(Collection<?> c) {
            return this.f439s.retainAll(c);
        }

        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.f439s = this.f438m.keySet();
        }
    }

    private static class TransformedSet<A, B> extends AbstractSet<B> {
        final InvertibleFunction<A, B> bijection;
        final Set<A> delegate;

        TransformedSet(Set<A> delegate, InvertibleFunction<A, B> bijection) {
            this.delegate = delegate;
            this.bijection = bijection;
        }

        public Iterator<B> iterator() {
            return Iterators.transform(this.delegate.iterator(), this.bijection);
        }

        public int size() {
            return this.delegate.size();
        }

        public boolean contains(Object o) {
            A a = this.bijection.invert(o);
            return this.delegate.contains(a) && Objects.equal(this.bijection.apply(a), o);
        }

        public boolean add(B b) {
            return this.delegate.add(this.bijection.invert(b));
        }

        public boolean remove(Object o) {
            return contains(o) && this.delegate.remove(this.bijection.invert(o));
        }

        public void clear() {
            this.delegate.clear();
        }
    }

    private Sets() {
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E anElement, E... otherElements) {
        return new ImmutableEnumSet(EnumSet.of(anElement, otherElements));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> elements) {
        Iterator<E> iterator = elements.iterator();
        if (!iterator.hasNext()) {
            return ImmutableSet.of();
        }
        if (elements instanceof EnumSet) {
            return new ImmutableEnumSet(EnumSet.copyOf((EnumSet) elements));
        }
        EnumSet<E> set = EnumSet.of((Enum) iterator.next());
        while (iterator.hasNext()) {
            set.add(iterator.next());
        }
        return new ImmutableEnumSet(set);
    }

    public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> iterable, Class<E> elementType) {
        Preconditions.checkNotNull(iterable);
        EnumSet<E> set = EnumSet.noneOf(elementType);
        Iterables.addAll(set, iterable);
        return set;
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet();
    }

    public static <E> HashSet<E> newHashSet(E... elements) {
        HashSet<E> set = newHashSetWithExpectedSize(elements.length);
        Collections.addAll(set, elements);
        return set;
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int expectedSize) {
        return new HashSet(Maps.capacity(expectedSize));
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> elements) {
        return elements instanceof Collection ? new HashSet(Collections2.cast(elements)) : newHashSet(elements.iterator());
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> elements) {
        HashSet<E> set = newHashSet();
        while (elements.hasNext()) {
            set.add(elements.next());
        }
        return set;
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int expectedSize) {
        return new LinkedHashSet(Maps.capacity(expectedSize));
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return new LinkedHashSet(Collections2.cast(elements));
        }
        LinkedHashSet<E> set = newLinkedHashSet();
        for (E element : elements) {
            set.add(element);
        }
        return set;
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet() {
        return new TreeSet();
    }

    public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> elements) {
        TreeSet<E> set = newTreeSet();
        Iterator i$ = elements.iterator();
        while (i$.hasNext()) {
            set.add((Comparable) i$.next());
        }
        return set;
    }

    public static <E> TreeSet<E> newTreeSet(Comparator<? super E> comparator) {
        return new TreeSet((Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <E> Set<E> newIdentityHashSet() {
        return newSetFromMap(Maps.newIdentityHashMap());
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        Preconditions.checkArgument(!collection.isEmpty(), "collection is empty; use the other version of this method");
        return makeComplementByHand(collection, ((Enum) collection.iterator().next()).getDeclaringClass());
    }

    public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> collection, Class<E> type) {
        Preconditions.checkNotNull(collection);
        return collection instanceof EnumSet ? EnumSet.complementOf((EnumSet) collection) : makeComplementByHand(collection, type);
    }

    private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> collection, Class<E> type) {
        EnumSet<E> result = EnumSet.allOf(type);
        result.removeAll(collection);
        return result;
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return new SetFromMap(map);
    }

    public static <E> SetView<E> union(Set<? extends E> set1, Set<? extends E> set2) {
        Preconditions.checkNotNull(set1, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new C06001(set1, difference(set2, set1), set2);
    }

    public static <E> SetView<E> intersection(Set<E> set1, Set<?> set2) {
        Preconditions.checkNotNull(set1, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new C06012(set1, Predicates.in(set2), set2);
    }

    public static <E> SetView<E> difference(Set<E> set1, Set<?> set2) {
        Preconditions.checkNotNull(set1, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new C06023(set1, Predicates.not(Predicates.in(set2)), set2);
    }

    public static <E> SetView<E> symmetricDifference(Set<? extends E> set1, Set<? extends E> set2) {
        Preconditions.checkNotNull(set1, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return difference(union(set1, set2), intersection(set1, set2));
    }

    public static <E> Set<E> filter(Set<E> unfiltered, Predicate<? super E> predicate) {
        if (unfiltered instanceof SortedSet) {
            return filter((SortedSet) unfiltered, (Predicate) predicate);
        }
        if (!(unfiltered instanceof FilteredSet)) {
            return new FilteredSet((Set) Preconditions.checkNotNull(unfiltered), (Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet<E> filtered = (FilteredSet) unfiltered;
        return new FilteredSet((Set) filtered.unfiltered, Predicates.and(filtered.predicate, predicate));
    }

    @Beta
    public static <E> SortedSet<E> filter(SortedSet<E> unfiltered, Predicate<? super E> predicate) {
        if (!(unfiltered instanceof FilteredSet)) {
            return new FilteredSortedSet((SortedSet) Preconditions.checkNotNull(unfiltered), (Predicate) Preconditions.checkNotNull(predicate));
        }
        FilteredSet<E> filtered = (FilteredSet) unfiltered;
        return new FilteredSortedSet((SortedSet) filtered.unfiltered, Predicates.and(filtered.predicate, predicate));
    }

    public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> sets) {
        for (Set<? extends B> set : sets) {
            if (set.isEmpty()) {
                return ImmutableSet.of();
            }
        }
        return new CartesianSet(sets);
    }

    public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... sets) {
        return cartesianProduct(Arrays.asList(sets));
    }

    @GwtCompatible(serializable = false)
    public static <E> Set<Set<E>> powerSet(Set<E> set) {
        boolean z;
        ImmutableSet<E> input = ImmutableSet.copyOf((Collection) set);
        if (input.size() <= 30) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Too many elements to create power set: %s > 30", Integer.valueOf(input.size()));
        return new PowerSet(input);
    }

    static int hashCodeImpl(Set<?> s) {
        int hashCode = 0;
        for (Object o : s) {
            hashCode += o != null ? o.hashCode() : 0;
        }
        return hashCode;
    }

    static boolean equalsImpl(Set<?> s, @Nullable Object object) {
        boolean z = true;
        if (s == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set<?> o = (Set) object;
        try {
            if (!(s.size() == o.size() && s.containsAll(o))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    static <A, B> Set<B> transform(Set<A> set, InvertibleFunction<A, B> bijection) {
        return new TransformedSet((Set) Preconditions.checkNotNull(set, "set"), (InvertibleFunction) Preconditions.checkNotNull(bijection, "bijection"));
    }

    static boolean removeAllImpl(Set<?> set, Iterable<?> iterable) {
        boolean changed = false;
        for (Object o : iterable) {
            changed |= set.remove(o);
        }
        return changed;
    }
}
