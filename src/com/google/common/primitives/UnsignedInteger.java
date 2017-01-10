package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.math.BigInteger;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
@Beta
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static final UnsignedInteger MAX_VALUE;
    public static final UnsignedInteger ONE;
    public static final UnsignedInteger ZERO;
    private final int value;

    static {
        ZERO = asUnsigned(0);
        ONE = asUnsigned(1);
        MAX_VALUE = asUnsigned(-1);
    }

    private UnsignedInteger(int value) {
        this.value = value & -1;
    }

    public static UnsignedInteger asUnsigned(int value) {
        return new UnsignedInteger(value);
    }

    public static UnsignedInteger valueOf(long value) {
        boolean z;
        if ((4294967295L & value) == value) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "value (%s) is outside the range for an unsigned integer value", Long.valueOf(value));
        return asUnsigned((int) value);
    }

    public static UnsignedInteger valueOf(BigInteger value) {
        boolean z;
        Preconditions.checkNotNull(value);
        if (value.signum() < 0 || value.bitLength() > 32) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "value (%s) is outside the range for an unsigned integer value", value);
        return asUnsigned(value.intValue());
    }

    public static UnsignedInteger valueOf(String string) {
        return valueOf(string, 10);
    }

    public static UnsignedInteger valueOf(String string, int radix) {
        return asUnsigned(UnsignedInts.parseUnsignedInt(string, radix));
    }

    public UnsignedInteger add(UnsignedInteger val) {
        Preconditions.checkNotNull(val);
        return asUnsigned(this.value + val.value);
    }

    public UnsignedInteger subtract(UnsignedInteger val) {
        Preconditions.checkNotNull(val);
        return asUnsigned(this.value - val.value);
    }

    @GwtIncompatible("Does not truncate correctly")
    public UnsignedInteger multiply(UnsignedInteger val) {
        Preconditions.checkNotNull(val);
        return asUnsigned(this.value * val.value);
    }

    public UnsignedInteger divide(UnsignedInteger val) {
        Preconditions.checkNotNull(val);
        return asUnsigned(UnsignedInts.divide(this.value, val.value));
    }

    public UnsignedInteger remainder(UnsignedInteger val) {
        Preconditions.checkNotNull(val);
        return asUnsigned(UnsignedInts.remainder(this.value, val.value));
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return UnsignedInts.toLong(this.value);
    }

    public float floatValue() {
        return (float) longValue();
    }

    public double doubleValue() {
        return (double) longValue();
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    public int compareTo(UnsignedInteger other) {
        Preconditions.checkNotNull(other);
        return UnsignedInts.compare(this.value, other.value);
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof UnsignedInteger)) {
            return false;
        }
        if (this.value == ((UnsignedInteger) obj).value) {
            return true;
        }
        return false;
    }

    public String toString() {
        return toString(10);
    }

    public String toString(int radix) {
        return UnsignedInts.toString(this.value, radix);
    }
}
