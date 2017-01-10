package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.SortedLists.KeyAbsentBehavior;
import com.google.common.collect.SortedLists.KeyPresentBehavior;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import org.codehaus.jackson.impl.JsonWriteContext;

final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    static final /* synthetic */ boolean $assertionsDisabled;
    final transient ImmutableList<CumulativeCountEntry<E>> entries;

    /* renamed from: com.google.common.collect.RegularImmutableSortedMultiset.1 */
    class C05941 extends TransformedImmutableList<CumulativeCountEntry<E>, E> {
        C05941(ImmutableList x0) {
            super(x0);
        }

        E transform(CumulativeCountEntry<E> entry) {
            return entry.getElement();
        }
    }

    /* renamed from: com.google.common.collect.RegularImmutableSortedMultiset.2 */
    static /* synthetic */ class C05952 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType;

        static {
            $SwitchMap$com$google$common$collect$BoundType = new int[BoundType.values().length];
            try {
                $SwitchMap$com$google$common$collect$BoundType[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static final class CumulativeCountEntry<E> extends AbstractEntry<E> {
        final int count;
        final long cumulativeCount;
        final E element;

        CumulativeCountEntry(E element, int count, @Nullable CumulativeCountEntry<E> previous) {
            this.element = element;
            this.count = count;
            this.cumulativeCount = (previous == null ? 0 : previous.cumulativeCount) + ((long) count);
        }

        public E getElement() {
            return this.element;
        }

        public int getCount() {
            return this.count;
        }
    }

    static {
        $assertionsDisabled = !RegularImmutableSortedMultiset.class.desiredAssertionStatus();
    }

    static <E> RegularImmutableSortedMultiset<E> createFromSorted(Comparator<? super E> comparator, List<? extends Entry<E>> entries) {
        Collection newEntries = Lists.newArrayListWithCapacity(entries.size());
        CumulativeCountEntry<E> previous = null;
        for (Entry<E> entry : entries) {
            CumulativeCountEntry<E> previous2 = new CumulativeCountEntry(entry.getElement(), entry.getCount(), previous);
            newEntries.add(previous2);
            previous = previous2;
        }
        return new RegularImmutableSortedMultiset(comparator, ImmutableList.copyOf(newEntries));
    }

    RegularImmutableSortedMultiset(Comparator<? super E> comparator, ImmutableList<CumulativeCountEntry<E>> entries) {
        super(comparator);
        this.entries = entries;
        if (!$assertionsDisabled && entries.isEmpty()) {
            throw new AssertionError();
        }
    }

    ImmutableList<E> elementList() {
        return new C05941(this.entries);
    }

    ImmutableSortedSet<E> createElementSet() {
        return new RegularImmutableSortedSet(elementList(), comparator());
    }

    ImmutableSortedSet<E> createDescendingElementSet() {
        return new RegularImmutableSortedSet(elementList().reverse(), reverseComparator());
    }

    UnmodifiableIterator<Entry<E>> entryIterator() {
        return this.entries.iterator();
    }

    UnmodifiableIterator<Entry<E>> descendingEntryIterator() {
        return this.entries.reverse().iterator();
    }

    public CumulativeCountEntry<E> firstEntry() {
        return (CumulativeCountEntry) this.entries.get(0);
    }

    public CumulativeCountEntry<E> lastEntry() {
        return (CumulativeCountEntry) this.entries.get(this.entries.size() - 1);
    }

    public int size() {
        CumulativeCountEntry<E> firstEntry = firstEntry();
        return Ints.saturatedCast((lastEntry().cumulativeCount - firstEntry.cumulativeCount) + ((long) firstEntry.count));
    }

    int distinctElements() {
        return this.entries.size();
    }

    boolean isPartialView() {
        return this.entries.isPartialView();
    }

    public int count(@Nullable Object element) {
        if (element == null) {
            return 0;
        }
        try {
            int index = SortedLists.binarySearch(elementList(), element, comparator(), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
            return index >= 0 ? ((CumulativeCountEntry) this.entries.get(index)).getCount() : 0;
        } catch (ClassCastException e) {
            return 0;
        }
    }

    public ImmutableSortedMultiset<E> headMultiset(E upperBound, BoundType boundType) {
        int index;
        switch (C05952.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                index = SortedLists.binarySearch(elementList(), Preconditions.checkNotNull(upperBound), comparator(), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_HIGHER);
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                index = SortedLists.binarySearch(elementList(), Preconditions.checkNotNull(upperBound), comparator(), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_LOWER) + 1;
                break;
            default:
                throw new AssertionError();
        }
        return createSubMultiset(0, index);
    }

    public ImmutableSortedMultiset<E> tailMultiset(E lowerBound, BoundType boundType) {
        int index;
        switch (C05952.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                index = SortedLists.binarySearch(elementList(), Preconditions.checkNotNull(lowerBound), comparator(), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_LOWER) + 1;
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                index = SortedLists.binarySearch(elementList(), Preconditions.checkNotNull(lowerBound), comparator(), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_HIGHER);
                break;
            default:
                throw new AssertionError();
        }
        return createSubMultiset(index, distinctElements());
    }

    private ImmutableSortedMultiset<E> createSubMultiset(int newFromIndex, int newToIndex) {
        if (newFromIndex == 0 && newToIndex == this.entries.size()) {
            return this;
        }
        if (newFromIndex >= newToIndex) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        return new RegularImmutableSortedMultiset(comparator(), this.entries.subList(newFromIndex, newToIndex));
    }
}
