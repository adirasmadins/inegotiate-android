package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.paypal.android.MEP.PayPalActivity;
import java.math.RoundingMode;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

@Beta
public final class LongMath {
    static final int[] BIGGEST_BINOMIALS;
    @VisibleForTesting
    static final int[] BIGGEST_SIMPLE_BINOMIALS;
    static final long[] FACTORIALS;
    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    @VisibleForTesting
    static final long[] HALF_POWERS_OF_10;
    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    @VisibleForTesting
    static final long[] POWERS_OF_10;

    /* renamed from: com.google.common.math.LongMath.1 */
    static /* synthetic */ class C06791 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public static boolean isPowerOfTwo(long x) {
        int i = 1;
        int i2 = x > 0 ? 1 : 0;
        if (((x - 1) & x) != 0) {
            i = 0;
        }
        return i & i2;
    }

    public static int log2(long x, RoundingMode mode) {
        MathPreconditions.checkPositive("x", x);
        switch (C06791.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(x));
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                break;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                return 64 - Long.numberOfLeadingZeros(x - 1);
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
            case PayPalActivity.VIEW_TEST /*8*/:
                int leadingZeros = Long.numberOfLeadingZeros(x);
                int logFloor = 63 - leadingZeros;
                if (x > (MAX_POWER_OF_SQRT2_UNSIGNED >>> leadingZeros)) {
                    return logFloor + 1;
                }
                return logFloor;
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(x);
    }

    public static int log10(long x, RoundingMode mode) {
        MathPreconditions.checkPositive("x", x);
        if (fitsInInt(x)) {
            return IntMath.log10((int) x, mode);
        }
        int logFloor = log10Floor(x);
        long floorPow = POWERS_OF_10[logFloor];
        switch (C06791.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                MathPreconditions.checkRoundingUnnecessary(x == floorPow);
                return logFloor;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return logFloor;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                if (x != floorPow) {
                    return logFloor + 1;
                }
                return logFloor;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
            case PayPalActivity.VIEW_TEST /*8*/:
                if (x > HALF_POWERS_OF_10[logFloor]) {
                    return logFloor + 1;
                }
                return logFloor;
            default:
                throw new AssertionError();
        }
    }

    static int log10Floor(long x) {
        for (int i = 1; i < POWERS_OF_10.length; i++) {
            if (x < POWERS_OF_10[i]) {
                return i - 1;
            }
        }
        return POWERS_OF_10.length - 1;
    }

    static {
        POWERS_OF_10 = new long[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
        HALF_POWERS_OF_10 = new long[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
        FACTORIALS = new long[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
        BIGGEST_BINOMIALS = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
        BIGGEST_SIMPLE_BINOMIALS = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    }

    public static long pow(long b, int k) {
        long j = 0;
        MathPreconditions.checkNonNegative("exponent", k);
        if (-2 <= b && b <= 2) {
            switch ((int) b) {
                case CharacterEscapes.ESCAPE_CUSTOM /*-2*/:
                    if (k < 64) {
                        return (k & 1) == 0 ? 1 << k : -(1 << k);
                    } else {
                        return 0;
                    }
                case CharacterEscapes.ESCAPE_STANDARD /*-1*/:
                    if ((k & 1) != 0) {
                        return -1;
                    }
                    return 1;
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                    if (k == 0) {
                        return 1;
                    }
                    return 0;
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    return 1;
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                    if (k < 64) {
                        j = 1 << k;
                    }
                    return j;
            }
        }
        long accum = 1;
        while (true) {
            switch (k) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                    return accum;
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    return accum * b;
                default:
                    if ((k & 1) == 0) {
                        j = 1;
                    } else {
                        j = b;
                    }
                    accum *= j;
                    b *= b;
                    k >>= 1;
            }
        }
    }

    public static long sqrt(long x, RoundingMode mode) {
        int i = 1;
        MathPreconditions.checkNonNegative("x", x);
        if (fitsInInt(x)) {
            return (long) IntMath.sqrt((int) x, mode);
        }
        long sqrtFloor = sqrtFloor(x);
        switch (C06791.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                boolean z;
                if (sqrtFloor * sqrtFloor != x) {
                    z = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z);
                return sqrtFloor;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return sqrtFloor;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                if (sqrtFloor * sqrtFloor != x) {
                    return sqrtFloor + 1;
                }
                return sqrtFloor;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
            case PayPalActivity.VIEW_TEST /*8*/:
                long halfSquare = (sqrtFloor * sqrtFloor) + sqrtFloor;
                int i2 = halfSquare >= x ? 1 : 0;
                if (halfSquare >= 0) {
                    i = 0;
                }
                if ((i | i2) == 0) {
                    return sqrtFloor + 1;
                }
                return sqrtFloor;
            default:
                throw new AssertionError();
        }
    }

    private static long sqrtFloor(long x) {
        long sqrt0 = (long) Math.sqrt((double) x);
        long sqrt1 = ((x / sqrt0) + sqrt0) >> 1;
        if (sqrt1 == sqrt0) {
            return sqrt0;
        }
        do {
            sqrt0 = sqrt1;
            sqrt1 = ((x / sqrt0) + sqrt0) >> 1;
        } while (sqrt1 < sqrt0);
        return sqrt0;
    }

    public static long divide(long p, long q, RoundingMode mode) {
        Preconditions.checkNotNull(mode);
        long div = p / q;
        long rem = p - (q * div);
        if (rem == 0) {
            return div;
        }
        boolean increment;
        int signum = ((int) ((p ^ q) >> 63)) | 1;
        switch (C06791.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                MathPreconditions.checkRoundingUnnecessary(rem == 0);
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                break;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                increment = signum < 0;
                break;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                increment = true;
                break;
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                increment = signum > 0;
                break;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
            case PayPalActivity.VIEW_TEST /*8*/:
                long absRem = Math.abs(rem);
                long cmpRemToHalfDivisor = absRem - (Math.abs(q) - absRem);
                if (cmpRemToHalfDivisor != 0) {
                    increment = cmpRemToHalfDivisor > 0;
                    break;
                }
                increment = (mode == RoundingMode.HALF_UP ? 1 : 0) | (((1 & div) != 0 ? 1 : 0) & (mode == RoundingMode.HALF_EVEN ? 1 : 0));
                break;
            default:
                throw new AssertionError();
        }
        increment = false;
        if (increment) {
            return div + ((long) signum);
        }
        return div;
    }

    public static int mod(long x, int m) {
        return (int) mod(x, (long) m);
    }

    public static long mod(long x, long m) {
        if (m <= 0) {
            throw new ArithmeticException("Modulus " + m + " must be > 0");
        }
        long result = x % m;
        return result >= 0 ? result : result + m;
    }

    public static long gcd(long a, long b) {
        int i = 1;
        MathPreconditions.checkNonNegative("a", a);
        MathPreconditions.checkNonNegative("b", b);
        int i2 = a == 0 ? 1 : 0;
        if (b != 0) {
            i = 0;
        }
        if ((i | i2) != 0) {
            return a | b;
        }
        int aTwos = Long.numberOfTrailingZeros(a);
        a >>= aTwos;
        int bTwos = Long.numberOfTrailingZeros(b);
        b >>= bTwos;
        while (a != b) {
            if (a < b) {
                long t = b;
                b = a;
                a = t;
            }
            a -= b;
            a >>= Long.numberOfTrailingZeros(a);
        }
        return a << Math.min(aTwos, bTwos);
    }

    public static long checkedAdd(long a, long b) {
        int i;
        int i2 = 1;
        long result = a + b;
        if ((a ^ b) < 0) {
            i = 1;
        } else {
            i = 0;
        }
        if ((a ^ result) < 0) {
            i2 = 0;
        }
        MathPreconditions.checkNoOverflow(i2 | i);
        return result;
    }

    public static long checkedSubtract(long a, long b) {
        int i;
        int i2 = 1;
        long result = a - b;
        if ((a ^ b) >= 0) {
            i = 1;
        } else {
            i = 0;
        }
        if ((a ^ result) < 0) {
            i2 = 0;
        }
        MathPreconditions.checkNoOverflow(i2 | i);
        return result;
    }

    public static long checkedMultiply(long a, long b) {
        boolean z = false;
        int leadingZeros = ((Long.numberOfLeadingZeros(a) + Long.numberOfLeadingZeros(a ^ -1)) + Long.numberOfLeadingZeros(b)) + Long.numberOfLeadingZeros(b ^ -1);
        if (leadingZeros > 65) {
            return a * b;
        }
        boolean z2;
        int i;
        if (leadingZeros >= 64) {
            z2 = true;
        } else {
            z2 = false;
        }
        MathPreconditions.checkNoOverflow(z2);
        if (a >= 0) {
            i = 1;
        } else {
            i = 0;
        }
        MathPreconditions.checkNoOverflow((b != Long.MIN_VALUE ? 1 : 0) | i);
        long result = a * b;
        if (a == 0 || result / a == b) {
            z = true;
        }
        MathPreconditions.checkNoOverflow(z);
        return result;
    }

    public static long checkedPow(long b, int k) {
        int i;
        boolean z = true;
        MathPreconditions.checkNonNegative("exponent", k);
        if (b >= -2) {
            i = 1;
        } else {
            i = 0;
        }
        if (((b <= 2 ? 1 : 0) & i) != 0) {
            switch ((int) b) {
                case CharacterEscapes.ESCAPE_CUSTOM /*-2*/:
                    if (k >= 64) {
                        z = false;
                    }
                    MathPreconditions.checkNoOverflow(z);
                    return (k & 1) == 0 ? 1 << k : -1 << k;
                case CharacterEscapes.ESCAPE_STANDARD /*-1*/:
                    if ((k & 1) != 0) {
                        return -1;
                    }
                    return 1;
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                    if (k == 0) {
                        return 1;
                    }
                    return 0;
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    return 1;
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                    boolean z2;
                    if (k < 63) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    MathPreconditions.checkNoOverflow(z2);
                    return 1 << k;
            }
        }
        long accum = 1;
        while (true) {
            switch (k) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                    return accum;
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    return checkedMultiply(accum, b);
                default:
                    if ((k & 1) != 0) {
                        accum = checkedMultiply(accum, b);
                    }
                    k >>= 1;
                    if (k > 0) {
                        boolean z3;
                        if (b <= FLOOR_SQRT_MAX_LONG) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        MathPreconditions.checkNoOverflow(z3);
                        b *= b;
                    }
            }
        }
    }

    public static long factorial(int n) {
        MathPreconditions.checkNonNegative("n", n);
        return n < FACTORIALS.length ? FACTORIALS[n] : Long.MAX_VALUE;
    }

    public static long binomial(int n, int k) {
        MathPreconditions.checkNonNegative("n", n);
        MathPreconditions.checkNonNegative("k", k);
        Preconditions.checkArgument(k <= n, "k (%s) > n (%s)", Integer.valueOf(k), Integer.valueOf(n));
        if (k > (n >> 1)) {
            k = n - k;
        }
        if (k >= BIGGEST_BINOMIALS.length || n > BIGGEST_BINOMIALS[k]) {
            return Long.MAX_VALUE;
        }
        long result = 1;
        int i;
        if (k >= BIGGEST_SIMPLE_BINOMIALS.length || n > BIGGEST_SIMPLE_BINOMIALS[k]) {
            i = 1;
            while (i <= k) {
                int d = IntMath.gcd(n, i);
                result = (result / ((long) (i / d))) * ((long) (n / d));
                i++;
                n--;
            }
            return result;
        }
        for (i = 0; i < k; i++) {
            result = (result * ((long) (n - i))) / ((long) (i + 1));
        }
        return result;
    }

    static boolean fitsInInt(long x) {
        return ((long) ((int) x)) == x;
    }

    private LongMath() {
    }
}
