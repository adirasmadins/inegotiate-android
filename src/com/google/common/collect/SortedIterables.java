package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
final class SortedIterables {

    /* renamed from: com.google.common.collect.SortedIterables.1 */
    static class C06081 implements Function<Entry<E>, E> {
        C06081() {
        }

        public E apply(Entry<E> entry) {
            return entry.getElement();
        }
    }

    /* renamed from: com.google.common.collect.SortedIterables.2 */
    static class C06092 implements Function<E, Entry<E>> {
        C06092() {
        }

        public Entry<E> apply(E elem) {
            return Multisets.immutableEntry(elem, 1);
        }
    }

    private SortedIterables() {
    }

    public static boolean hasSameComparator(Comparator<?> comparator, Iterable<?> elements) {
        Comparator<?> comparator2;
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(elements);
        if (elements instanceof SortedSet) {
            comparator2 = ((SortedSet) elements).comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
        } else if (elements instanceof SortedIterable) {
            comparator2 = ((SortedIterable) elements).comparator();
        } else {
            comparator2 = null;
        }
        return comparator.equals(comparator2);
    }

    public static <E> Collection<E> sortedUnique(Comparator<? super E> comparator, Iterator<E> elements) {
        SortedSet<E> sortedSet = Sets.newTreeSet((Comparator) comparator);
        Iterators.addAll(sortedSet, elements);
        return sortedSet;
    }

    public static <E> Collection<E> sortedUnique(Comparator<? super E> comparator, Iterable<E> elements) {
        if (elements instanceof Multiset) {
            Iterable elements2 = ((Multiset) elements).elementSet();
        }
        if (!(elements2 instanceof Set)) {
            Object[] array = Iterables.toArray(elements2);
            if (!hasSameComparator(comparator, elements2)) {
                Arrays.sort(array, comparator);
            }
            return uniquifySortedArray(comparator, array);
        } else if (hasSameComparator(comparator, elements2)) {
            return (Set) elements2;
        } else {
            List<E> list = Lists.newArrayList(elements2);
            Collections.sort(list, comparator);
            return list;
        }
    }

    private static <E> Collection<E> uniquifySortedArray(Comparator<? super E> comparator, E[] array) {
        if (array.length == 0) {
            return Collections.emptySet();
        }
        int length = 1;
        for (int i = 1; i < array.length; i++) {
            if (comparator.compare(array[i], array[length - 1]) != 0) {
                int length2 = length + 1;
                array[length] = array[i];
                length = length2;
            }
        }
        if (length < array.length) {
            array = ObjectArrays.arraysCopyOf(array, length);
        }
        return Arrays.asList(array);
    }

    public static <E> Collection<Entry<E>> sortedCounts(Comparator<? super E> comparator, Iterator<E> elements) {
        TreeMultiset<E> multiset = TreeMultiset.create((Comparator) comparator);
        Iterators.addAll(multiset, elements);
        return multiset.entrySet();
    }

    public static <E> Collection<Entry<E>> sortedCounts(Comparator<? super E> comparator, Iterable<E> elements) {
        if (elements instanceof Multiset) {
            Multiset<E> multiset = (Multiset) elements;
            if (hasSameComparator(comparator, elements)) {
                return multiset.entrySet();
            }
            Collection<Entry<E>> entries = Lists.newArrayList(multiset.entrySet());
            Collections.sort(entries, Ordering.from((Comparator) comparator).onResultOf(new C06081()));
            return entries;
        } else if (elements instanceof Set) {
            Collection<E> sortedElements;
            if (hasSameComparator(comparator, elements)) {
                sortedElements = (Collection) elements;
            } else {
                List<E> list = Lists.newArrayList((Iterable) elements);
                Collections.sort(list, comparator);
                Object sortedElements2 = list;
            }
            return singletonEntries(sortedElements);
        } else if (hasSameComparator(comparator, elements)) {
            Object current = null;
            int currentCount = 0;
            List<Entry<E>> sortedEntries = Lists.newArrayList();
            for (E e : elements) {
                if (currentCount <= 0) {
                    current = e;
                    currentCount = 1;
                } else if (comparator.compare(current, e) == 0) {
                    currentCount++;
                } else {
                    sortedEntries.add(Multisets.immutableEntry(current, currentCount));
                    current = e;
                    currentCount = 1;
                }
            }
            if (currentCount > 0) {
                sortedEntries.add(Multisets.immutableEntry(current, currentCount));
            }
            return sortedEntries;
        } else {
            TreeMultiset<E> multiset2 = TreeMultiset.create((Comparator) comparator);
            Iterables.addAll(multiset2, elements);
            return multiset2.entrySet();
        }
    }

    static <E> Collection<Entry<E>> singletonEntries(Collection<E> set) {
        return Collections2.transform(set, new C06092());
    }
}
