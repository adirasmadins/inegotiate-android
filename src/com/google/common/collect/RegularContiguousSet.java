package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final Range<C> range;

    /* renamed from: com.google.common.collect.RegularContiguousSet.1 */
    class C05901 extends AbstractLinkedIterator<C> {
        final C last;

        C05901(Comparable x0) {
            super(x0);
            this.last = RegularContiguousSet.this.last();
        }

        protected C computeNext(C previous) {
            return RegularContiguousSet.equalsOrThrow(previous, this.last) ? null : RegularContiguousSet.this.domain.next(previous);
        }
    }

    @GwtIncompatible("serialization")
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        final DiscreteDomain<C> domain;
        final Range<C> range;

        private SerializedForm(Range<C> range, DiscreteDomain<C> domain) {
            this.range = range;
            this.domain = domain;
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }
    }

    RegularContiguousSet(Range<C> range, DiscreteDomain<C> domain) {
        super(domain);
        this.range = range;
    }

    ContiguousSet<C> headSetImpl(C toElement, boolean inclusive) {
        return this.range.intersection(Ranges.upTo(toElement, BoundType.forBoolean(inclusive))).asSet(this.domain);
    }

    int indexOf(Object target) {
        return contains(target) ? (int) this.domain.distance(first(), (Comparable) target) : -1;
    }

    ContiguousSet<C> subSetImpl(C fromElement, boolean fromInclusive, C toElement, boolean toInclusive) {
        return this.range.intersection(Ranges.range(fromElement, BoundType.forBoolean(fromInclusive), toElement, BoundType.forBoolean(toInclusive))).asSet(this.domain);
    }

    ContiguousSet<C> tailSetImpl(C fromElement, boolean inclusive) {
        return this.range.intersection(Ranges.downTo(fromElement, BoundType.forBoolean(inclusive))).asSet(this.domain);
    }

    public UnmodifiableIterator<C> iterator() {
        return new C05901(first());
    }

    private static boolean equalsOrThrow(Comparable<?> left, @Nullable Comparable<?> right) {
        return right != null && Range.compareOrThrow(left, right) == 0;
    }

    boolean isPartialView() {
        return false;
    }

    public C first() {
        return this.range.lowerBound.leastValueAbove(this.domain);
    }

    public C last() {
        return this.range.upperBound.greatestValueBelow(this.domain);
    }

    public int size() {
        long distance = this.domain.distance(first(), last());
        return distance >= 2147483647L ? Integer.MAX_VALUE : ((int) distance) + 1;
    }

    public boolean contains(Object object) {
        try {
            return this.range.contains((Comparable) object);
        } catch (ClassCastException e) {
            return false;
        }
    }

    public boolean containsAll(Collection<?> targets) {
        try {
            return this.range.containsAll(targets);
        } catch (ClassCastException e) {
            return false;
        }
    }

    public boolean isEmpty() {
        return false;
    }

    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    public <T> T[] toArray(T[] other) {
        return ObjectArrays.toArrayImpl(this, other);
    }

    public ContiguousSet<C> intersection(ContiguousSet<C> other) {
        Preconditions.checkNotNull(other);
        Preconditions.checkArgument(this.domain.equals(other.domain));
        if (other.isEmpty()) {
            return other;
        }
        Comparable lowerEndpoint = (Comparable) Ordering.natural().max(first(), other.first());
        Comparable upperEndpoint = (Comparable) Ordering.natural().min(last(), other.last());
        return lowerEndpoint.compareTo(upperEndpoint) < 0 ? Ranges.closed(lowerEndpoint, upperEndpoint).asSet(this.domain) : new EmptyContiguousSet(this.domain);
    }

    public Range<C> range() {
        return range(BoundType.CLOSED, BoundType.CLOSED);
    }

    public Range<C> range(BoundType lowerBoundType, BoundType upperBoundType) {
        return Ranges.create(this.range.lowerBound.withLowerBoundType(lowerBoundType, this.domain), this.range.upperBound.withUpperBoundType(upperBoundType, this.domain));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof RegularContiguousSet) {
            RegularContiguousSet<?> that = (RegularContiguousSet) object;
            if (this.domain.equals(that.domain)) {
                if (first().equals(that.first()) && last().equals(that.last())) {
                    return true;
                }
                return false;
            }
        }
        return super.equals(object);
    }

    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @GwtIncompatible("serialization")
    Object writeReplace() {
        return new SerializedForm(this.domain, null);
    }
}
