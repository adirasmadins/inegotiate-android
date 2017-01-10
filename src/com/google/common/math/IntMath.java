package com.google.common.math;

import com.amazonaws.services.s3.internal.Constants;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.paypal.android.MEP.PayPalActivity;
import java.math.RoundingMode;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

@GwtCompatible(emulated = true)
@Beta
public final class IntMath {
    @VisibleForTesting
    static int[] BIGGEST_BINOMIALS = null;
    static final int[] FACTORIALS;
    @VisibleForTesting
    static final int FLOOR_SQRT_MAX_INT = 46340;
    @VisibleForTesting
    static final int[] HALF_POWERS_OF_10;
    @VisibleForTesting
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
    @VisibleForTesting
    static final int[] POWERS_OF_10;

    /* renamed from: com.google.common.math.IntMath.1 */
    static /* synthetic */ class C06781 {
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

    public static boolean isPowerOfTwo(int x) {
        int i = 1;
        int i2 = x > 0 ? 1 : 0;
        if (((x - 1) & x) != 0) {
            i = 0;
        }
        return i & i2;
    }

    @GwtIncompatible("need BigIntegerMath to adequately test")
    public static int log2(int x, RoundingMode mode) {
        MathPreconditions.checkPositive("x", x);
        switch (C06781.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(x));
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                break;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                return 32 - Integer.numberOfLeadingZeros(x - 1);
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
            case PayPalActivity.VIEW_TEST /*8*/:
                int leadingZeros = Integer.numberOfLeadingZeros(x);
                int logFloor = 31 - leadingZeros;
                if (x > (MAX_POWER_OF_SQRT2_UNSIGNED >>> leadingZeros)) {
                    return logFloor + 1;
                }
                return logFloor;
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    @GwtIncompatible("need BigIntegerMath to adequately test")
    public static int log10(int x, RoundingMode mode) {
        MathPreconditions.checkPositive("x", x);
        int logFloor = log10Floor(x);
        int floorPow = POWERS_OF_10[logFloor];
        switch (C06781.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                boolean z;
                if (x == floorPow) {
                    z = true;
                } else {
                    z = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z);
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

    private static int log10Floor(int x) {
        for (int i = 1; i < POWERS_OF_10.length; i++) {
            if (x < POWERS_OF_10[i]) {
                return i - 1;
            }
        }
        return POWERS_OF_10.length - 1;
    }

    static {
        POWERS_OF_10 = new int[]{1, 10, 100, 1000, Constants.MAXIMUM_UPLOAD_PARTS, 100000, 1000000, 10000000, 100000000, 1000000000};
        HALF_POWERS_OF_10 = new int[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
        FACTORIALS = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
        BIGGEST_BINOMIALS = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    }

    @GwtIncompatible("failing tests")
    public static int pow(int b, int k) {
        int i = 0;
        MathPreconditions.checkNonNegative("exponent", k);
        switch (b) {
            case CharacterEscapes.ESCAPE_CUSTOM /*-2*/:
                if (k < 32) {
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
                if (k < 32) {
                    i = 1 << k;
                }
                return i;
            default:
                int accum = 1;
                while (true) {
                    switch (k) {
                        case CharacterEscapes.ESCAPE_NONE /*0*/:
                            return accum;
                        case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                            return b * accum;
                        default:
                            if ((k & 1) == 0) {
                                i = 1;
                            } else {
                                i = b;
                            }
                            accum *= i;
                            b *= b;
                            k >>= 1;
                    }
                }
        }
    }

    @GwtIncompatible("need BigIntegerMath to adequately test")
    public static int sqrt(int x, RoundingMode mode) {
        int i = 1;
        MathPreconditions.checkNonNegative("x", x);
        int sqrtFloor = sqrtFloor(x);
        switch (C06781.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
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
                int halfSquare = (sqrtFloor * sqrtFloor) + sqrtFloor;
                int i2 = x <= halfSquare ? 1 : 0;
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

    private static int sqrtFloor(int x) {
        return (int) Math.sqrt((double) x);
    }

    @GwtIncompatible("failing tests")
    public static int divide(int p, int q, RoundingMode mode) {
        boolean z = true;
        Preconditions.checkNotNull(mode);
        if (q == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int div = p / q;
        int rem = p - (q * div);
        if (rem == 0) {
            return div;
        }
        boolean increment;
        int signum = ((p ^ q) >> 31) | 1;
        switch (C06781.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                if (rem != 0) {
                    z = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z);
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                break;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                if (signum < 0) {
                    increment = true;
                } else {
                    increment = false;
                }
                break;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                increment = true;
                break;
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                if (signum > 0) {
                    increment = true;
                } else {
                    increment = false;
                }
                break;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
            case PayPalActivity.VIEW_TEST /*8*/:
                int absRem = Math.abs(rem);
                int cmpRemToHalfDivisor = absRem - (Math.abs(q) - absRem);
                if (cmpRemToHalfDivisor != 0) {
                    if (cmpRemToHalfDivisor > 0) {
                        increment = true;
                    } else {
                        increment = false;
                    }
                    break;
                }
                if (mode != RoundingMode.HALF_UP) {
                    if ((((div & 1) != 0 ? 1 : 0) & (mode == RoundingMode.HALF_EVEN ? 1 : 0)) == 0) {
                        increment = false;
                        break;
                    }
                }
                increment = true;
            default:
                throw new AssertionError();
        }
        increment = false;
        return increment ? div + signum : div;
    }

    public static int mod(int x, int m) {
        if (m <= 0) {
            throw new ArithmeticException("Modulus " + m + " must be > 0");
        }
        int result = x % m;
        return result >= 0 ? result : result + m;
    }

    public static int gcd(int a, int b) {
        MathPreconditions.checkNonNegative("a", a);
        MathPreconditions.checkNonNegative("b", b);
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static int checkedAdd(int a, int b) {
        long result = ((long) a) + ((long) b);
        MathPreconditions.checkNoOverflow(result == ((long) ((int) result)));
        return (int) result;
    }

    public static int checkedSubtract(int a, int b) {
        long result = ((long) a) - ((long) b);
        MathPreconditions.checkNoOverflow(result == ((long) ((int) result)));
        return (int) result;
    }

    public static int checkedMultiply(int a, int b) {
        long result = ((long) a) * ((long) b);
        MathPreconditions.checkNoOverflow(result == ((long) ((int) result)));
        return (int) result;
    }

    @GwtIncompatible("failing tests")
    public static int checkedPow(int b, int k) {
        boolean z = false;
        MathPreconditions.checkNonNegative("exponent", k);
        switch (b) {
            case CharacterEscapes.ESCAPE_CUSTOM /*-2*/:
                if (k < 32) {
                    z = true;
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
                if (k < 31) {
                    z = true;
                }
                MathPreconditions.checkNoOverflow(z);
                return 1 << k;
            default:
                int accum = 1;
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
                                int i;
                                int i2;
                                if (-46340 <= b) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                if (b <= FLOOR_SQRT_MAX_INT) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                MathPreconditions.checkNoOverflow(i2 & i);
                                b *= b;
                            }
                    }
                }
        }
    }

    @GwtIncompatible("need BigIntegerMath to adequately test")
    public static int factorial(int n) {
        MathPreconditions.checkNonNegative("n", n);
        return n < FACTORIALS.length ? FACTORIALS[n] : Integer.MAX_VALUE;
    }

    @GwtIncompatible("need BigIntegerMath to adequately test")
    public static int binomial(int n, int k) {
        MathPreconditions.checkNonNegative("n", n);
        MathPreconditions.checkNonNegative("k", k);
        Preconditions.checkArgument(k <= n, "k (%s) > n (%s)", Integer.valueOf(k), Integer.valueOf(n));
        if (k > (n >> 1)) {
            k = n - k;
        }
        if (k >= BIGGEST_BINOMIALS.length || n > BIGGEST_BINOMIALS[k]) {
            return Integer.MAX_VALUE;
        }
        switch (k) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return 1;
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return n;
            default:
                long result = 1;
                for (int i = 0; i < k; i++) {
                    result = (result * ((long) (n - i))) / ((long) (i + 1));
                }
                return (int) result;
        }
    }

    private IntMath() {
    }
}
