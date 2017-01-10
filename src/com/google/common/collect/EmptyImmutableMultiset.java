package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class EmptyImmutableMultiset extends ImmutableMultiset<Object> {
    static final EmptyImmutableMultiset INSTANCE;
    private static final long serialVersionUID = 0;

    EmptyImmutableMultiset() {
    }

    static {
        INSTANCE = new EmptyImmutableMultiset();
    }

    public int count(@Nullable Object element) {
        return 0;
    }

    public ImmutableSet<Object> elementSet() {
        return ImmutableSet.of();
    }

    public int size() {
        return 0;
    }

    UnmodifiableIterator<Entry<Object>> entryIterator() {
        return Iterators.emptyIterator();
    }

    int distinctElements() {
        return 0;
    }

    boolean isPartialView() {
        return false;
    }

    ImmutableSet<Entry<Object>> createEntrySet() {
        return ImmutableSet.of();
    }
}
