package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
@Beta
public class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    public static final UnsignedLong MAX_VALUE;
    public static final UnsignedLong ONE;
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    public static final UnsignedLong ZERO;
    private final long value;

    static {
        ZERO = new UnsignedLong(0);
        ONE = new UnsignedLong(1);
        MAX_VALUE = new UnsignedLong(-1);
    }

    protected UnsignedLong(long value) {
        this.value = value;
    }

    public static UnsignedLong asUnsigned(long value) {
        return new UnsignedLong(value);
    }

    public static UnsignedLong valueOf(BigInteger value) {
        boolean z;
        Preconditions.checkNotNull(value);
        if (value.signum() < 0 || value.bitLength() > 64) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "value (%s) is outside the range for an unsigned long value", value);
        return asUnsigned(value.longValue());
    }

    public static UnsignedLong valueOf(String string) {
        return valueOf(string, 10);
    }

    public static UnsignedLong valueOf(String string, int radix) {
        return asUnsigned(UnsignedLongs.parseUnsignedLong(string, radix));
    }

    public UnsignedLong add(UnsignedLong val) {
        Preconditions.checkNotNull(val);
        return asUnsigned(this.value + val.value);
    }

    public UnsignedLong subtract(UnsignedLong val) {
        Preconditions.checkNotNull(val);
        return asUnsigned(this.value - val.value);
    }

    public UnsignedLong multiply(UnsignedLong val) {
        Preconditions.checkNotNull(val);
        return asUnsigned(this.value * val.value);
    }

    public UnsignedLong divide(UnsignedLong val) {
        Preconditions.checkNotNull(val);
        return asUnsigned(UnsignedLongs.divide(this.value, val.value));
    }

    public UnsignedLong remainder(UnsignedLong val) {
        Preconditions.checkNotNull(val);
        return asUnsigned(UnsignedLongs.remainder(this.value, val.value));
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return this.value;
    }

    public float floatValue() {
        float fValue = (float) (this.value & UNSIGNED_MASK);
        if (this.value < 0) {
            return fValue + 9.223372E18f;
        }
        return fValue;
    }

    public double doubleValue() {
        double dValue = (double) (this.value & UNSIGNED_MASK);
        if (this.value < 0) {
            return dValue + 9.223372036854776E18d;
        }
        return dValue;
    }

    public BigInteger bigIntegerValue() {
        BigInteger bigInt = BigInteger.valueOf(this.value & UNSIGNED_MASK);
        if (this.value < 0) {
            return bigInt.setBit(63);
        }
        return bigInt;
    }

    public int compareTo(UnsignedLong o) {
        Preconditions.checkNotNull(o);
        return UnsignedLongs.compare(this.value, o.value);
    }

    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof UnsignedLong)) {
            return false;
        }
        if (this.value == ((UnsignedLong) obj).value) {
            return true;
        }
        return false;
    }

    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    public String toString(int radix) {
        return UnsignedLongs.toString(this.value, radix);
    }
}
