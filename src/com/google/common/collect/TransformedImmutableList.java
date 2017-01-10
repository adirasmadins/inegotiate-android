package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

@GwtCompatible
abstract class TransformedImmutableList<D, E> extends ImmutableList<E> {
    private final transient ImmutableList<D> backingList;

    /* renamed from: com.google.common.collect.TransformedImmutableList.1 */
    class C06441 extends AbstractIndexedListIterator<E> {
        C06441(int x0, int x1) {
            super(x0, x1);
        }

        protected E get(int index) {
            return TransformedImmutableList.this.get(index);
        }
    }

    private class TransformedView extends TransformedImmutableList<D, E> {
        public /* bridge */ /* synthetic */ ListIterator listIterator(int x0) {
            return super.listIterator(x0);
        }

        public /* bridge */ /* synthetic */ List subList(int x0, int x1) {
            return super.subList(x0, x1);
        }

        TransformedView(ImmutableList<D> backingList) {
            super(backingList);
        }

        E transform(D d) {
            return TransformedImmutableList.this.transform(d);
        }
    }

    abstract E transform(D d);

    TransformedImmutableList(ImmutableList<D> backingList) {
        this.backingList = (ImmutableList) Preconditions.checkNotNull(backingList);
    }

    public int indexOf(@Nullable Object object) {
        if (object == null) {
            return -1;
        }
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(@Nullable Object object) {
        if (object == null) {
            return -1;
        }
        for (int i = size() - 1; i >= 0; i--) {
            if (get(i).equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        return transform(this.backingList.get(index));
    }

    public UnmodifiableListIterator<E> listIterator(int index) {
        return new C06441(size(), index);
    }

    public int size() {
        return this.backingList.size();
    }

    public ImmutableList<E> subList(int fromIndex, int toIndex) {
        return new TransformedView(this.backingList.subList(fromIndex, toIndex));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List<?> list = (List) obj;
        if (size() == list.size() && Iterators.elementsEqual(iterator(), list.iterator())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = 1;
        Iterator i$ = iterator();
        while (i$.hasNext()) {
            E e = i$.next();
            hashCode = (hashCode * 31) + (e == null ? 0 : e.hashCode());
        }
        return hashCode;
    }

    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    public <T> T[] toArray(T[] array) {
        return ObjectArrays.toArrayImpl(this, array);
    }

    boolean isPartialView() {
        return true;
    }
}
