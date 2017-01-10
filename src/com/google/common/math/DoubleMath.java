package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.paypal.android.MEP.PayPalActivity;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;

@Beta
public final class DoubleMath {
    @VisibleForTesting
    static final double[] EVERY_SIXTEENTH_FACTORIAL;
    private static final double LN_2;
    @VisibleForTesting
    static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9d;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18d;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9d;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18d;

    /* renamed from: com.google.common.math.DoubleMath.1 */
    static /* synthetic */ class C06771 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    static double roundIntermediate(double x, RoundingMode mode) {
        if (DoubleUtils.isFinite(x)) {
            switch (C06771.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(x));
                    return x;
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                    if (x < LN_2) {
                        return Math.floor(x);
                    }
                    return x;
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                    if (x >= LN_2) {
                        return Math.ceil(x);
                    }
                    return x;
                case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                    return x;
                case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                    return x >= LN_2 ? Math.ceil(x) : Math.floor(x);
                case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                    return Math.rint(x);
                case SimpleLog.LOG_LEVEL_OFF /*7*/:
                    if (isMathematicalInteger(x)) {
                        return x;
                    }
                    return x >= LN_2 ? x + 0.5d : x - 0.5d;
                case PayPalActivity.VIEW_TEST /*8*/:
                    if (isMathematicalInteger(x)) {
                        return x;
                    }
                    double z;
                    if (x >= LN_2) {
                        z = x + 0.5d;
                        if (z != x) {
                            return DoubleUtils.next(z, false);
                        }
                        return x;
                    }
                    z = x - 0.5d;
                    if (z != x) {
                        return DoubleUtils.next(z, true);
                    }
                    return x;
                default:
                    throw new AssertionError();
            }
        }
        throw new ArithmeticException("input is infinite or NaN");
    }

    public static int roundToInt(double x, RoundingMode mode) {
        int i;
        int i2 = 1;
        double z = roundIntermediate(x, mode);
        if (z > -2.147483649E9d) {
            i = 1;
        } else {
            i = 0;
        }
        if (z >= 2.147483648E9d) {
            i2 = 0;
        }
        MathPreconditions.checkInRange(i2 & i);
        return (int) z;
    }

    public static long roundToLong(double x, RoundingMode mode) {
        int i;
        int i2 = 1;
        double z = roundIntermediate(x, mode);
        if (MIN_LONG_AS_DOUBLE - z < 1.0d) {
            i = 1;
        } else {
            i = 0;
        }
        if (z >= MAX_LONG_AS_DOUBLE_PLUS_ONE) {
            i2 = 0;
        }
        MathPreconditions.checkInRange(i2 & i);
        return (long) z;
    }

    public static BigInteger roundToBigInteger(double x, RoundingMode mode) {
        int i = 1;
        x = roundIntermediate(x, mode);
        int i2 = MIN_LONG_AS_DOUBLE - x < 1.0d ? 1 : 0;
        if (x >= MAX_LONG_AS_DOUBLE_PLUS_ONE) {
            i = 0;
        }
        if ((i & i2) != 0) {
            return BigInteger.valueOf((long) x);
        }
        int exponent = DoubleUtils.getExponent(x);
        if (exponent < 0) {
            return BigInteger.ZERO;
        }
        BigInteger result = BigInteger.valueOf(DoubleUtils.getSignificand(x)).shiftLeft(exponent - 52);
        return x < LN_2 ? result.negate() : result;
    }

    public static boolean isPowerOfTwo(double x) {
        return x > LN_2 && DoubleUtils.isFinite(x) && LongMath.isPowerOfTwo(DoubleUtils.getSignificand(x));
    }

    public static double log2(double x) {
        return Math.log(x) / LN_2;
    }

    static {
        LN_2 = Math.log(2.0d);
        EVERY_SIXTEENTH_FACTORIAL = new double[]{1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};
    }

    public static int log2(double x, RoundingMode mode) {
        int i = 1;
        boolean z = x > LN_2 && DoubleUtils.isFinite(x);
        Preconditions.checkArgument(z, "x must be positive and finite");
        int exponent = DoubleUtils.getExponent(x);
        if (!DoubleUtils.isNormal(x)) {
            return log2(4.503599627370496E15d * x, mode) - 52;
        }
        boolean increment;
        int i2;
        switch (C06771.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(x));
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                break;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                if (isPowerOfTwo(x)) {
                    increment = false;
                } else {
                    increment = true;
                }
                break;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                if (exponent < 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (isPowerOfTwo(x)) {
                    i = 0;
                }
                increment = i2 & i;
                break;
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                if (exponent >= 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (isPowerOfTwo(x)) {
                    i = 0;
                }
                increment = i2 & i;
                break;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
            case PayPalActivity.VIEW_TEST /*8*/:
                double xScaled = DoubleUtils.scaleNormalize(x);
                if (xScaled * xScaled > 2.0d) {
                    increment = true;
                } else {
                    increment = false;
                }
                break;
            default:
                throw new AssertionError();
        }
        increment = false;
        if (increment) {
            return exponent + 1;
        }
        return exponent;
    }

    public static boolean isMathematicalInteger(double x) {
        return DoubleUtils.isFinite(x) && (x == LN_2 || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(x)) <= DoubleUtils.getExponent(x));
    }

    public static double factorial(int n) {
        MathPreconditions.checkNonNegative("n", n);
        if (n > MAX_FACTORIAL) {
            return Double.POSITIVE_INFINITY;
        }
        double accum = 1.0d;
        for (int i = (n & -16) + 1; i <= n; i++) {
            accum *= (double) i;
        }
        return EVERY_SIXTEENTH_FACTORIAL[n >> 4] * accum;
    }
}
