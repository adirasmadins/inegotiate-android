package com.google.common.math;

import com.amazonaws.services.s3.model.ProgressEvent;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigInteger;

final class DoubleUtils {
    static final int EXPONENT_BIAS = 1023;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long IMPLICIT_BIT = 4503599627370496L;
    static final int MAX_DOUBLE_EXPONENT = 1023;
    static final int MIN_DOUBLE_EXPONENT = -1022;
    private static final long ONE_BITS;
    static final int SIGNIFICAND_BITS = 52;
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    static double next(double x, boolean up) {
        if (x == 0.0d) {
            return up ? Double.MIN_VALUE : -4.9E-324d;
        } else {
            long bits = Double.doubleToRawLongBits(x);
            if ((x < 0.0d) == up) {
                bits--;
            } else {
                bits++;
            }
            return Double.longBitsToDouble(bits);
        }
    }

    @VisibleForTesting
    static int getExponent(double d) {
        return ((int) ((EXPONENT_MASK & Double.doubleToRawLongBits(d)) >> SIGNIFICAND_BITS)) - 1023;
    }

    static double scalb(double d, int scale) {
        int i = 1;
        int exponent = getExponent(d);
        switch (exponent) {
            case -1023:
                return d * StrictMath.pow(2.0d, (double) scale);
            case ProgressEvent.PART_STARTED_EVENT_CODE /*1024*/:
                return d;
            default:
                int i2;
                int newExponent = exponent + scale;
                if (MIN_DOUBLE_EXPONENT <= newExponent) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (newExponent > MAX_DOUBLE_EXPONENT) {
                    i = 0;
                }
                if ((i & i2) != 0) {
                    return Double.longBitsToDouble((Double.doubleToRawLongBits(d) & -9218868437227405313L) | (((long) (newExponent + MAX_DOUBLE_EXPONENT)) << SIGNIFICAND_BITS));
                }
                return d * StrictMath.pow(2.0d, (double) scale);
        }
    }

    static long getSignificand(double d) {
        Preconditions.checkArgument(isFinite(d), "not a normal value");
        long bits = Double.doubleToRawLongBits(d) & SIGNIFICAND_MASK;
        return getExponent(d) == -1023 ? bits << 1 : IMPLICIT_BIT | bits;
    }

    static boolean isFinite(double d) {
        return getExponent(d) <= MAX_DOUBLE_EXPONENT;
    }

    static boolean isNormal(double d) {
        return getExponent(d) >= MIN_DOUBLE_EXPONENT;
    }

    static double scaleNormalize(double x) {
        return Double.longBitsToDouble(ONE_BITS | (Double.doubleToRawLongBits(x) & SIGNIFICAND_MASK));
    }

    static double bigToDouble(BigInteger x) {
        BigInteger absX = x.abs();
        int exponent = absX.bitLength() - 1;
        if (exponent < 63) {
            return (double) x.longValue();
        }
        if (exponent > MAX_DOUBLE_EXPONENT) {
            return ((double) x.signum()) * Double.POSITIVE_INFINITY;
        }
        long signifRounded;
        int shift = (exponent - 52) - 1;
        long twiceSignifFloor = absX.shiftRight(shift).longValue();
        long signifFloor = (twiceSignifFloor >> 1) & SIGNIFICAND_MASK;
        boolean increment = (1 & twiceSignifFloor) != ONE_BITS && ((1 & signifFloor) != ONE_BITS || absX.getLowestSetBit() < shift);
        if (increment) {
            signifRounded = signifFloor + 1;
        } else {
            signifRounded = signifFloor;
        }
        return Double.longBitsToDouble(((((long) (exponent + MAX_DOUBLE_EXPONENT)) << SIGNIFICAND_BITS) + signifRounded) | (((long) x.signum()) & SIGN_MASK));
    }

    static {
        ONE_BITS = Double.doubleToRawLongBits(1.0d);
    }
}
