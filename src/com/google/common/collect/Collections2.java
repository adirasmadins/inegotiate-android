package com.google.common.collect;

import com.amazonaws.services.s3.internal.Constants;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

@GwtCompatible
public final class Collections2 {
    static final Joiner STANDARD_JOINER;

    /* renamed from: com.google.common.collect.Collections2.1 */
    static class C04361 implements Function<Object, Object> {
        final /* synthetic */ Collection val$collection;

        C04361(Collection collection) {
            this.val$collection = collection;
        }

        public Object apply(Object input) {
            return input == this.val$collection ? "(this Collection)" : input;
        }
    }

    static class FilteredCollection<E> implements Collection<E> {
        final Predicate<? super E> predicate;
        final Collection<E> unfiltered;

        /* renamed from: com.google.common.collect.Collections2.FilteredCollection.1 */
        class C04371 implements Predicate<E> {
            final /* synthetic */ Collection val$collection;

            C04371(Collection collection) {
                this.val$collection = collection;
            }

            public boolean apply(E input) {
                return FilteredCollection.this.predicate.apply(input) && this.val$collection.contains(input);
            }
        }

        /* renamed from: com.google.common.collect.Collections2.FilteredCollection.2 */
        class C04382 implements Predicate<E> {
            final /* synthetic */ Collection val$collection;

            C04382(Collection collection) {
                this.val$collection = collection;
            }

            public boolean apply(E input) {
                return FilteredCollection.this.predicate.apply(input) && !this.val$collection.contains(input);
            }
        }

        FilteredCollection(Collection<E> unfiltered, Predicate<? super E> predicate) {
            this.unfiltered = unfiltered;
            this.predicate = predicate;
        }

        FilteredCollection<E> createCombined(Predicate<? super E> newPredicate) {
            return new FilteredCollection(this.unfiltered, Predicates.and(this.predicate, newPredicate));
        }

        public boolean add(E element) {
            Preconditions.checkArgument(this.predicate.apply(element));
            return this.unfiltered.add(element);
        }

        public boolean addAll(Collection<? extends E> collection) {
            for (E element : collection) {
                Preconditions.checkArgument(this.predicate.apply(element));
            }
            return this.unfiltered.addAll(collection);
        }

        public void clear() {
            Iterables.removeIf(this.unfiltered, this.predicate);
        }

        public boolean contains(Object element) {
            try {
                if (this.predicate.apply(element) && this.unfiltered.contains(element)) {
                    return true;
                }
                return false;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object element : collection) {
                if (!contains(element)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return !Iterators.any(this.unfiltered.iterator(), this.predicate);
        }

        public Iterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        public boolean remove(Object element) {
            try {
                if (this.predicate.apply(element) && this.unfiltered.remove(element)) {
                    return true;
                }
                return false;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }

        public boolean removeAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            return Iterables.removeIf(this.unfiltered, new C04371(collection));
        }

        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            return Iterables.removeIf(this.unfiltered, new C04382(collection));
        }

        public int size() {
            return Iterators.size(iterator());
        }

        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        public <T> T[] toArray(T[] array) {
            return Lists.newArrayList(iterator()).toArray(array);
        }

        public String toString() {
            return Iterators.toString(iterator());
        }
    }

    static class TransformedCollection<F, T> extends AbstractCollection<T> {
        final Collection<F> fromCollection;
        final Function<? super F, ? extends T> function;

        TransformedCollection(Collection<F> fromCollection, Function<? super F, ? extends T> function) {
            this.fromCollection = (Collection) Preconditions.checkNotNull(fromCollection);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        public void clear() {
            this.fromCollection.clear();
        }

        public boolean isEmpty() {
            return this.fromCollection.isEmpty();
        }

        public Iterator<T> iterator() {
            return Iterators.transform(this.fromCollection.iterator(), this.function);
        }

        public int size() {
            return this.fromCollection.size();
        }
    }

    private Collections2() {
    }

    public static <E> Collection<E> filter(Collection<E> unfiltered, Predicate<? super E> predicate) {
        if (unfiltered instanceof FilteredCollection) {
            return ((FilteredCollection) unfiltered).createCombined(predicate);
        }
        return new FilteredCollection((Collection) Preconditions.checkNotNull(unfiltered), (Predicate) Preconditions.checkNotNull(predicate));
    }

    static boolean safeContains(Collection<?> collection, Object object) {
        try {
            return collection.contains(object);
        } catch (ClassCastException e) {
            return false;
        }
    }

    public static <F, T> Collection<T> transform(Collection<F> fromCollection, Function<? super F, T> function) {
        return new TransformedCollection(fromCollection, function);
    }

    static boolean containsAllImpl(Collection<?> self, Collection<?> c) {
        Preconditions.checkNotNull(self);
        for (Object o : c) {
            if (!self.contains(o)) {
                return false;
            }
        }
        return true;
    }

    static String toStringImpl(Collection<?> collection) {
        StringBuilder sb = newStringBuilderForCollection(collection.size()).append('[');
        STANDARD_JOINER.appendTo(sb, Iterables.transform(collection, new C04361(collection)));
        return sb.append(']').toString();
    }

    static StringBuilder newStringBuilderForCollection(int size) {
        Preconditions.checkArgument(size >= 0, "size must be non-negative");
        return new StringBuilder((int) Math.min(((long) size) * 8, Constants.GB));
    }

    static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    static {
        STANDARD_JOINER = Joiner.on(", ");
    }
}
