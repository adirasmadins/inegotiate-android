package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.Nullable;
import org.codehaus.jackson.impl.JsonWriteContext;

@GwtCompatible(serializable = true)
final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    @Nullable
    private final T lowerEndpoint;
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;
    @Nullable
    private final T upperEndpoint;

    /* renamed from: com.google.common.collect.GeneralRange.1 */
    static /* synthetic */ class C04461 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType;

        static {
            $SwitchMap$com$google$common$collect$BoundType = new int[BoundType.values().length];
            try {
                $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$common$collect$BoundType[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        T lowerEndpoint;
        T upperEndpoint;
        if (range.hasLowerBound()) {
            lowerEndpoint = range.lowerEndpoint();
        } else {
            lowerEndpoint = null;
        }
        BoundType lowerBoundType = range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN;
        if (range.hasUpperBound()) {
            upperEndpoint = range.upperEndpoint();
        } else {
            upperEndpoint = null;
        }
        return new GeneralRange(Ordering.natural(), range.hasLowerBound(), lowerEndpoint, lowerBoundType, range.hasUpperBound(), upperEndpoint, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
    }

    static <T> GeneralRange<T> all(Comparator<? super T> comparator) {
        return new GeneralRange(comparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    static <T> GeneralRange<T> downTo(Comparator<? super T> comparator, @Nullable T endpoint, BoundType boundType) {
        return new GeneralRange(comparator, true, endpoint, boundType, false, null, BoundType.OPEN);
    }

    static <T> GeneralRange<T> upTo(Comparator<? super T> comparator, @Nullable T endpoint, BoundType boundType) {
        return new GeneralRange(comparator, false, null, BoundType.OPEN, true, endpoint, boundType);
    }

    static <T> GeneralRange<T> range(Comparator<? super T> comparator, @Nullable T lower, BoundType lowerType, @Nullable T upper, BoundType upperType) {
        return new GeneralRange(comparator, true, lower, lowerType, true, upper, upperType);
    }

    private GeneralRange(Comparator<? super T> comparator, boolean hasLowerBound, @Nullable T lowerEndpoint, BoundType lowerBoundType, boolean hasUpperBound, @Nullable T upperEndpoint, BoundType upperBoundType) {
        int i = 1;
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        this.hasLowerBound = hasLowerBound;
        this.hasUpperBound = hasUpperBound;
        this.lowerEndpoint = lowerEndpoint;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(lowerBoundType);
        this.upperEndpoint = upperEndpoint;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(upperBoundType);
        if (hasLowerBound) {
            comparator.compare(lowerEndpoint, lowerEndpoint);
        }
        if (hasUpperBound) {
            comparator.compare(upperEndpoint, upperEndpoint);
        }
        if (hasLowerBound && hasUpperBound) {
            boolean z;
            int cmp = comparator.compare(lowerEndpoint, upperEndpoint);
            if (cmp <= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "lowerEndpoint (%s) > upperEndpoint (%s)", lowerEndpoint, upperEndpoint);
            if (cmp == 0) {
                int i2;
                if (lowerBoundType != BoundType.OPEN) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (upperBoundType == BoundType.OPEN) {
                    i = 0;
                }
                Preconditions.checkArgument(i2 | i);
            }
        }
    }

    Comparator<? super T> comparator() {
        return this.comparator;
    }

    boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    boolean isEmpty() {
        return (hasUpperBound() && tooLow(this.upperEndpoint)) || (hasLowerBound() && tooHigh(this.lowerEndpoint));
    }

    boolean tooLow(@Nullable T t) {
        int i = 1;
        if (!hasLowerBound()) {
            return false;
        }
        int cmp = this.comparator.compare(t, this.lowerEndpoint);
        int i2 = cmp < 0 ? 1 : 0;
        int i3 = cmp == 0 ? 1 : 0;
        if (this.lowerBoundType != BoundType.OPEN) {
            i = 0;
        }
        return i2 | (i3 & i);
    }

    boolean tooHigh(@Nullable T t) {
        int i = 1;
        if (!hasUpperBound()) {
            return false;
        }
        int cmp = this.comparator.compare(t, this.upperEndpoint);
        int i2 = cmp > 0 ? 1 : 0;
        int i3 = cmp == 0 ? 1 : 0;
        if (this.upperBoundType != BoundType.OPEN) {
            i = 0;
        }
        return i2 | (i3 & i);
    }

    boolean contains(@Nullable T t) {
        return (tooLow(t) || tooHigh(t)) ? false : true;
    }

    GeneralRange<T> intersect(GeneralRange<T> other) {
        int cmp;
        Preconditions.checkNotNull(other);
        Preconditions.checkArgument(this.comparator.equals(other.comparator));
        boolean hasLowBound = this.hasLowerBound;
        T lowEnd = this.lowerEndpoint;
        BoundType lowType = this.lowerBoundType;
        if (!hasLowerBound()) {
            hasLowBound = other.hasLowerBound;
            lowEnd = other.lowerEndpoint;
            lowType = other.lowerBoundType;
        } else if (other.hasLowerBound()) {
            cmp = this.comparator.compare(this.lowerEndpoint, other.lowerEndpoint);
            if (cmp < 0 || (cmp == 0 && other.lowerBoundType == BoundType.OPEN)) {
                lowEnd = other.lowerEndpoint;
                lowType = other.lowerBoundType;
            }
        }
        boolean hasUpBound = this.hasUpperBound;
        T upEnd = this.upperEndpoint;
        BoundType upType = this.upperBoundType;
        if (!hasUpperBound()) {
            hasUpBound = other.hasUpperBound;
            upEnd = other.upperEndpoint;
            upType = other.upperBoundType;
        } else if (other.hasUpperBound()) {
            cmp = this.comparator.compare(this.upperEndpoint, other.upperEndpoint);
            if (cmp > 0 || (cmp == 0 && other.upperBoundType == BoundType.OPEN)) {
                upEnd = other.upperEndpoint;
                upType = other.upperBoundType;
            }
        }
        if (hasLowBound && hasUpBound) {
            cmp = this.comparator.compare(lowEnd, upEnd);
            if (cmp > 0 || (cmp == 0 && lowType == BoundType.OPEN && upType == BoundType.OPEN)) {
                lowEnd = upEnd;
                lowType = BoundType.OPEN;
                upType = BoundType.CLOSED;
            }
        }
        return new GeneralRange(this.comparator, hasLowBound, lowEnd, lowType, hasUpBound, upEnd, upType);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange<?> r = (GeneralRange) obj;
        if (this.comparator.equals(r.comparator) && this.hasLowerBound == r.hasLowerBound && this.hasUpperBound == r.hasUpperBound && this.lowerBoundType.equals(r.lowerBoundType) && this.upperBoundType.equals(r.upperBoundType) && Objects.equal(this.lowerEndpoint, r.lowerEndpoint) && Objects.equal(this.upperEndpoint, r.upperEndpoint)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.comparator, this.lowerEndpoint, this.lowerBoundType, this.upperEndpoint, this.upperBoundType);
    }

    public GeneralRange<T> reverse() {
        GeneralRange<T> result = this.reverse;
        if (result != null) {
            return result;
        }
        result = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, this.upperEndpoint, this.upperBoundType, this.hasLowerBound, this.lowerEndpoint, this.lowerBoundType);
        result.reverse = this;
        this.reverse = result;
        return result;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.comparator).append(":");
        switch (C04461.$SwitchMap$com$google$common$collect$BoundType[this.lowerBoundType.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                builder.append('[');
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                builder.append('(');
                break;
        }
        if (hasLowerBound()) {
            builder.append(this.lowerEndpoint);
        } else {
            builder.append("-\u221e");
        }
        builder.append(',');
        if (hasUpperBound()) {
            builder.append(this.upperEndpoint);
        } else {
            builder.append("\u221e");
        }
        switch (C04461.$SwitchMap$com$google$common$collect$BoundType[this.upperBoundType.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                builder.append(']');
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                builder.append(')');
                break;
        }
        return builder.toString();
    }
}
