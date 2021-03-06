package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import javax.annotation.Nullable;

final class ImmutableSortedAsList<E> extends ImmutableList<E> implements SortedIterable<E> {
    private final transient ImmutableList<E> backingList;
    private final transient ImmutableSortedSet<E> backingSet;

    ImmutableSortedAsList(ImmutableSortedSet<E> backingSet, ImmutableList<E> backingList) {
        this.backingSet = backingSet;
        this.backingList = backingList;
    }

    public Comparator<? super E> comparator() {
        return this.backingSet.comparator();
    }

    public boolean contains(@Nullable Object target) {
        return this.backingSet.indexOf(target) >= 0;
    }

    public int indexOf(@Nullable Object target) {
        return this.backingSet.indexOf(target);
    }

    public int lastIndexOf(@Nullable Object target) {
        return this.backingSet.indexOf(target);
    }

    public ImmutableList<E> subList(int fromIndex, int toIndex) {
        Preconditions.checkPositionIndexes(fromIndex, toIndex, size());
        return fromIndex == toIndex ? ImmutableList.of() : new RegularImmutableSortedSet(this.backingList.subList(fromIndex, toIndex), this.backingSet.comparator()).asList();
    }

    Object writeReplace() {
        return new SerializedForm(this.backingSet);
    }

    public UnmodifiableIterator<E> iterator() {
        return this.backingList.iterator();
    }

    public E get(int index) {
        return this.backingList.get(index);
    }

    public UnmodifiableListIterator<E> listIterator() {
        return this.backingList.listIterator();
    }

    public UnmodifiableListIterator<E> listIterator(int index) {
        return this.backingList.listIterator(index);
    }

    public int size() {
        return this.backingList.size();
    }

    public boolean equals(@Nullable Object obj) {
        return this.backingList.equals(obj);
    }

    public int hashCode() {
        return this.backingList.hashCode();
    }

    boolean isPartialView() {
        return this.backingList.isPartialView();
    }
}
