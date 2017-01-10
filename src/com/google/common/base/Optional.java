package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: com.google.common.base.Optional.1 */
    static class C03511 implements Iterable<T> {
        final /* synthetic */ Iterable val$optionals;

        /* renamed from: com.google.common.base.Optional.1.1 */
        class C03501 extends AbstractIterator<T> {
            private final Iterator<Optional<T>> iterator;

            C03501() {
                this.iterator = (Iterator) Preconditions.checkNotNull(C03511.this.val$optionals.iterator());
            }

            protected T computeNext() {
                while (this.iterator.hasNext()) {
                    Optional<T> optional = (Optional) this.iterator.next();
                    if (optional.isPresent()) {
                        return optional.get();
                    }
                }
                return endOfData();
            }
        }

        C03511(Iterable iterable) {
            this.val$optionals = iterable;
        }

        public Iterator<T> iterator() {
            return new C03501();
        }
    }

    private static final class Absent extends Optional<Object> {
        private static final Absent INSTANCE;
        private static final long serialVersionUID = 0;

        private Absent() {
            super();
        }

        static {
            INSTANCE = new Absent();
        }

        public boolean isPresent() {
            return false;
        }

        public Object get() {
            throw new IllegalStateException("value is absent");
        }

        public Object or(Object defaultValue) {
            return Preconditions.checkNotNull(defaultValue, "use orNull() instead of or(null)");
        }

        public Optional<Object> or(Optional<?> secondChoice) {
            return (Optional) Preconditions.checkNotNull(secondChoice);
        }

        public Object or(Supplier<?> supplier) {
            return Preconditions.checkNotNull(supplier.get(), "use orNull() instead of a Supplier that returns null");
        }

        @Nullable
        public Object orNull() {
            return null;
        }

        public Set<Object> asSet() {
            return Collections.emptySet();
        }

        public boolean equals(@Nullable Object object) {
            return object == this;
        }

        public int hashCode() {
            return 1502476572;
        }

        public String toString() {
            return "Optional.absent()";
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class Present<T> extends Optional<T> {
        private static final long serialVersionUID = 0;
        private final T reference;

        Present(T reference) {
            super();
            this.reference = reference;
        }

        public boolean isPresent() {
            return true;
        }

        public T get() {
            return this.reference;
        }

        public T or(T defaultValue) {
            Preconditions.checkNotNull(defaultValue, "use orNull() instead of or(null)");
            return this.reference;
        }

        public Optional<T> or(Optional<? extends T> secondChoice) {
            Preconditions.checkNotNull(secondChoice);
            return this;
        }

        public T or(Supplier<? extends T> supplier) {
            Preconditions.checkNotNull(supplier);
            return this.reference;
        }

        public T orNull() {
            return this.reference;
        }

        public Set<T> asSet() {
            return Collections.singleton(this.reference);
        }

        public boolean equals(@Nullable Object object) {
            if (!(object instanceof Present)) {
                return false;
            }
            return this.reference.equals(((Present) object).reference);
        }

        public int hashCode() {
            return 1502476572 + this.reference.hashCode();
        }

        public String toString() {
            return "Optional.of(" + this.reference + ")";
        }
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@Nullable Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t);

    @Nullable
    public abstract T orNull();

    public abstract String toString();

    public static <T> Optional<T> absent() {
        return Absent.INSTANCE;
    }

    public static <T> Optional<T> of(T reference) {
        return new Present(Preconditions.checkNotNull(reference));
    }

    public static <T> Optional<T> fromNullable(@Nullable T nullableReference) {
        return nullableReference == null ? absent() : new Present(nullableReference);
    }

    private Optional() {
    }

    public static <T> Iterable<T> presentInstances(Iterable<Optional<T>> optionals) {
        Preconditions.checkNotNull(optionals);
        return new C03511(optionals);
    }
}
