package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    static final int CUTOFF = 536870912;
    static final int MAX_TABLE_SIZE = 1073741824;

    static abstract class ArrayImmutableSet<E> extends ImmutableSet<E> {
        final transient Object[] elements;

        ArrayImmutableSet(Object[] elements) {
            this.elements = elements;
        }

        public int size() {
            return this.elements.length;
        }

        public boolean isEmpty() {
            return false;
        }

        public UnmodifiableIterator<E> iterator() {
            return Iterators.forArray(this.elements);
        }

        public Object[] toArray() {
            Object[] array = new Object[size()];
            System.arraycopy(this.elements, 0, array, 0, size());
            return array;
        }

        public <T> T[] toArray(T[] array) {
            int size = size();
            if (array.length < size) {
                array = ObjectArrays.newArray((Object[]) array, size);
            } else if (array.length > size) {
                array[size] = null;
            }
            System.arraycopy(this.elements, 0, array, 0, size);
            return array;
        }

        public boolean containsAll(Collection<?> targets) {
            if (targets == this) {
                return true;
            }
            if (!(targets instanceof ArrayImmutableSet)) {
                return super.containsAll(targets);
            }
            if (targets.size() > size()) {
                return false;
            }
            for (Object target : ((ArrayImmutableSet) targets).elements) {
                if (!contains(target)) {
                    return false;
                }
            }
            return true;
        }

        boolean isPartialView() {
            return false;
        }

        ImmutableList<E> createAsList() {
            return new ImmutableAsList(this.elements, this);
        }
    }

    public static class Builder<E> extends com.google.common.collect.ImmutableCollection.Builder<E> {
        final ArrayList<E> contents;

        public Builder() {
            this.contents = Lists.newArrayList();
        }

        public Builder<E> add(E element) {
            this.contents.add(Preconditions.checkNotNull(element));
            return this;
        }

        public Builder<E> add(E... elements) {
            this.contents.ensureCapacity(this.contents.size() + elements.length);
            super.add((Object[]) elements);
            return this;
        }

        public Builder<E> addAll(Iterable<? extends E> elements) {
            if (elements instanceof Collection) {
                this.contents.ensureCapacity(this.contents.size() + ((Collection) elements).size());
            }
            super.addAll((Iterable) elements);
            return this;
        }

        public Builder<E> addAll(Iterator<? extends E> elements) {
            super.addAll((Iterator) elements);
            return this;
        }

        public ImmutableSet<E> build() {
            return ImmutableSet.copyOf(this.contents);
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] elements) {
            this.elements = elements;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    static abstract class TransformedImmutableSet<D, E> extends ImmutableSet<E> {
        final int hashCode;
        final D[] source;

        /* renamed from: com.google.common.collect.ImmutableSet.TransformedImmutableSet.1 */
        class C04531 extends AbstractIndexedListIterator<E> {
            C04531(int x0) {
                super(x0);
            }

            protected E get(int index) {
                return TransformedImmutableSet.this.transform(TransformedImmutableSet.this.source[index]);
            }
        }

        abstract E transform(D d);

        TransformedImmutableSet(D[] source, int hashCode) {
            this.source = source;
            this.hashCode = hashCode;
        }

        public int size() {
            return this.source.length;
        }

        public boolean isEmpty() {
            return false;
        }

        public UnmodifiableIterator<E> iterator() {
            return new C04531(this.source.length);
        }

        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        public <T> T[] toArray(T[] array) {
            int size = size();
            if (array.length < size) {
                array = ObjectArrays.newArray((Object[]) array, size);
            } else if (array.length > size) {
                array[size] = null;
            }
            T[] objectArray = array;
            for (int i = 0; i < this.source.length; i++) {
                objectArray[i] = transform(this.source[i]);
            }
            return array;
        }

        public final int hashCode() {
            return this.hashCode;
        }

        boolean isHashCodeFast() {
            return true;
        }
    }

    public abstract UnmodifiableIterator<E> iterator();

    public static <E> ImmutableSet<E> of() {
        return EmptyImmutableSet.INSTANCE;
    }

    public static <E> ImmutableSet<E> of(E element) {
        return new SingletonImmutableSet(element);
    }

    public static <E> ImmutableSet<E> of(E e1, E e2) {
        return construct(e1, e2);
    }

    public static <E> ImmutableSet<E> of(E e1, E e2, E e3) {
        return construct(e1, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e1, E e2, E e3, E e4) {
        return construct(e1, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> of(E e1, E e2, E e3, E e4, E e5) {
        return construct(e1, e2, e3, e4, e5);
    }

    public static <E> ImmutableSet<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E... others) {
        Object[] elements = new Object[(others.length + 6)];
        elements[0] = e1;
        elements[1] = e2;
        elements[2] = e3;
        elements[3] = e4;
        elements[4] = e5;
        elements[5] = e6;
        for (int i = 6; i < elements.length; i++) {
            elements[i] = others[i - 6];
        }
        return construct(elements);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <E> com.google.common.collect.ImmutableSet<E> construct(java.lang.Object... r19) {
        /*
        r0 = r19;
        r0 = r0.length;
        r17 = r0;
        r13 = chooseTableSize(r17);
        r12 = new java.lang.Object[r13];
        r10 = r13 + -1;
        r15 = 0;
        r5 = 0;
        r6 = 0;
    L_0x0010:
        r0 = r19;
        r0 = r0.length;
        r17 = r0;
        r0 = r17;
        if (r6 >= r0) goto L_0x0058;
    L_0x0019:
        r2 = r19[r6];
        r4 = r2.hashCode();
        r8 = com.google.common.collect.Hashing.smear(r4);
    L_0x0023:
        r7 = r8 & r10;
        r16 = r12[r7];
        if (r16 != 0) goto L_0x0034;
    L_0x0029:
        if (r15 == 0) goto L_0x002e;
    L_0x002b:
        r15.add(r2);
    L_0x002e:
        r12[r7] = r2;
        r5 = r5 + r4;
    L_0x0031:
        r6 = r6 + 1;
        goto L_0x0010;
    L_0x0034:
        r0 = r16;
        r17 = r0.equals(r2);
        if (r17 == 0) goto L_0x0055;
    L_0x003c:
        if (r15 != 0) goto L_0x0031;
    L_0x003e:
        r15 = new java.util.ArrayList;
        r0 = r19;
        r0 = r0.length;
        r17 = r0;
        r0 = r17;
        r15.<init>(r0);
        r9 = 0;
    L_0x004b:
        if (r9 >= r6) goto L_0x0031;
    L_0x004d:
        r11 = r19[r9];
        r15.add(r11);
        r9 = r9 + 1;
        goto L_0x004b;
    L_0x0055:
        r8 = r8 + 1;
        goto L_0x0023;
    L_0x0058:
        if (r15 != 0) goto L_0x0073;
    L_0x005a:
        r14 = r19;
    L_0x005c:
        r0 = r14.length;
        r17 = r0;
        r18 = 1;
        r0 = r17;
        r1 = r18;
        if (r0 != r1) goto L_0x0078;
    L_0x0067:
        r17 = 0;
        r3 = r14[r17];
        r17 = new com.google.common.collect.SingletonImmutableSet;
        r0 = r17;
        r0.<init>(r3, r5);
    L_0x0072:
        return r17;
    L_0x0073:
        r14 = r15.toArray();
        goto L_0x005c;
    L_0x0078:
        r0 = r14.length;
        r17 = r0;
        r17 = chooseTableSize(r17);
        r17 = r17 * 2;
        r0 = r17;
        if (r13 <= r0) goto L_0x008a;
    L_0x0085:
        r17 = construct(r14);
        goto L_0x0072;
    L_0x008a:
        r17 = new com.google.common.collect.RegularImmutableSet;
        r0 = r17;
        r0.<init>(r14, r5, r12, r10);
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSet.construct(java.lang.Object[]):com.google.common.collect.ImmutableSet<E>");
    }

    static int chooseTableSize(int setSize) {
        if (setSize < CUTOFF) {
            return Integer.highestOneBit(setSize) << 2;
        }
        Preconditions.checkArgument(setSize < MAX_TABLE_SIZE, "collection too large");
        return MAX_TABLE_SIZE;
    }

    public static <E> ImmutableSet<E> copyOf(E[] elements) {
        switch (elements.length) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return of();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return of(elements[0]);
            default:
                return construct((Object[]) elements.clone());
        }
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> elements) {
        return elements instanceof Collection ? copyOf(Collections2.cast(elements)) : copyOf(elements.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> elements) {
        return copyFromCollection(Lists.newArrayList((Iterator) elements));
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> elements) {
        if ((elements instanceof ImmutableSet) && !(elements instanceof ImmutableSortedSet)) {
            ImmutableSet<E> set = (ImmutableSet) elements;
            if (!set.isPartialView()) {
                return set;
            }
        }
        return copyFromCollection(elements);
    }

    private static <E> ImmutableSet<E> copyFromCollection(Collection<? extends E> collection) {
        Object[] elements = collection.toArray();
        switch (elements.length) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return of();
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return of(elements[0]);
            default:
                return construct(elements);
        }
    }

    ImmutableSet() {
    }

    boolean isHashCodeFast() {
        return false;
    }

    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if ((object instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) object).isHashCodeFast() && hashCode() != object.hashCode()) {
            return false;
        }
        return Sets.equalsImpl(this, object);
    }

    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }
}
