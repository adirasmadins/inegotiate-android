package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E element;

    /* renamed from: com.google.common.collect.SingletonImmutableList.1 */
    class C06071 extends UnmodifiableListIterator<E> {
        boolean hasNext;
        final /* synthetic */ int val$start;

        C06071(int i) {
            this.val$start = i;
            this.hasNext = this.val$start == 0;
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public boolean hasPrevious() {
            return !this.hasNext;
        }

        public E next() {
            if (this.hasNext) {
                this.hasNext = false;
                return SingletonImmutableList.this.element;
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.hasNext ? 0 : 1;
        }

        public E previous() {
            if (this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = true;
            return SingletonImmutableList.this.element;
        }

        public int previousIndex() {
            return this.hasNext ? -1 : 0;
        }
    }

    SingletonImmutableList(E element) {
        this.element = Preconditions.checkNotNull(element);
    }

    public E get(int index) {
        Preconditions.checkElementIndex(index, 1);
        return this.element;
    }

    public int indexOf(@Nullable Object object) {
        return this.element.equals(object) ? 0 : -1;
    }

    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    public int lastIndexOf(@Nullable Object object) {
        return this.element.equals(object) ? 0 : -1;
    }

    public UnmodifiableListIterator<E> listIterator(int start) {
        Preconditions.checkPositionIndex(start, 1);
        return new C06071(start);
    }

    public int size() {
        return 1;
    }

    public ImmutableList<E> subList(int fromIndex, int toIndex) {
        Preconditions.checkPositionIndexes(fromIndex, toIndex, 1);
        return fromIndex == toIndex ? ImmutableList.of() : this;
    }

    public ImmutableList<E> reverse() {
        return this;
    }

    public boolean contains(@Nullable Object object) {
        return this.element.equals(object);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof List)) {
            return false;
        }
        List<?> that = (List) object;
        if (that.size() == 1 && this.element.equals(that.get(0))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.element.hashCode() + 31;
    }

    public String toString() {
        String elementToString = this.element.toString();
        return new StringBuilder(elementToString.length() + 2).append('[').append(elementToString).append(']').toString();
    }

    public boolean isEmpty() {
        return false;
    }

    boolean isPartialView() {
        return false;
    }

    public Object[] toArray() {
        return new Object[]{this.element};
    }

    public <T> T[] toArray(T[] array) {
        if (array.length == 0) {
            array = ObjectArrays.newArray((Object[]) array, 1);
        } else if (array.length > 1) {
            array[1] = null;
        }
        array[0] = this.element;
        return array;
    }
}
