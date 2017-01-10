package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.paypal.android.MEP.PayPalActivity;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

@Beta
public final class BigIntegerMath {
    @VisibleForTesting
    static final BigInteger SQRT2_PRECOMPUTED_BITS;
    @VisibleForTesting
    static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;

    /* renamed from: com.google.common.math.BigIntegerMath.1 */
    static /* synthetic */ class C06761 {
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

    public static boolean isPowerOfTwo(BigInteger x) {
        Preconditions.checkNotNull(x);
        return x.signum() > 0 && x.getLowestSetBit() == x.bitLength() - 1;
    }

    public static int log2(BigInteger x, RoundingMode mode) {
        MathPreconditions.checkPositive("x", (BigInteger) Preconditions.checkNotNull(x));
        int logFloor = x.bitLength() - 1;
        switch (C06761.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(x));
                return logFloor;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return logFloor;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                if (isPowerOfTwo(x)) {
                    return logFloor;
                }
                return logFloor + 1;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
            case PayPalActivity.VIEW_TEST /*8*/:
                if (logFloor < SQRT2_PRECOMPUTE_THRESHOLD) {
                    if (x.compareTo(SQRT2_PRECOMPUTED_BITS.shiftRight(256 - logFloor)) > 0) {
                        return logFloor + 1;
                    }
                    return logFloor;
                } else if (x.pow(2).bitLength() - 1 >= (logFloor * 2) + 1) {
                    return logFloor + 1;
                } else {
                    return logFloor;
                }
            default:
                throw new AssertionError();
        }
    }

    static {
        SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
    }

    public static int log10(BigInteger x, RoundingMode mode) {
        MathPreconditions.checkPositive("x", x);
        if (fitsInLong(x)) {
            return LongMath.log10(x.longValue(), mode);
        }
        List<BigInteger> powersOf10 = new ArrayList(10);
        for (BigInteger powerOf10 = BigInteger.TEN; x.compareTo(powerOf10) >= 0; powerOf10 = powerOf10.pow(2)) {
            powersOf10.add(powerOf10);
        }
        BigInteger floorPow = BigInteger.ONE;
        int floorLog = 0;
        for (int i = powersOf10.size() - 1; i >= 0; i--) {
            floorLog *= 2;
            BigInteger tenPow = ((BigInteger) powersOf10.get(i)).multiply(floorPow);
            if (x.compareTo(tenPow) >= 0) {
                floorPow = tenPow;
                floorLog++;
            }
        }
        switch (C06761.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                MathPreconditions.checkRoundingUnnecessary(floorPow.equals(x));
                return floorLog;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return floorLog;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                if (floorPow.equals(x)) {
                    return floorLog;
                }
                return floorLog + 1;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
            case PayPalActivity.VIEW_TEST /*8*/:
                if (x.pow(2).compareTo(floorPow.pow(2).multiply(BigInteger.TEN)) > 0) {
                    return floorLog + 1;
                }
                return floorLog;
            default:
                throw new AssertionError();
        }
    }

    public static BigInteger sqrt(BigInteger x, RoundingMode mode) {
        MathPreconditions.checkNonNegative("x", x);
        if (fitsInLong(x)) {
            return BigInteger.valueOf(LongMath.sqrt(x.longValue(), mode));
        }
        BigInteger sqrtFloor = sqrtFloor(x);
        switch (C06761.$SwitchMap$java$math$RoundingMode[mode.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                MathPreconditions.checkRoundingUnnecessary(sqrtFloor.pow(2).equals(x));
                return sqrtFloor;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return sqrtFloor;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                if (sqrtFloor.pow(2).equals(x)) {
                    return sqrtFloor;
                }
                return sqrtFloor.add(BigInteger.ONE);
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
            case PayPalActivity.VIEW_TEST /*8*/:
                if (sqrtFloor.pow(2).add(sqrtFloor).compareTo(x) < 0) {
                    return sqrtFloor.add(BigInteger.ONE);
                }
                return sqrtFloor;
            default:
                throw new AssertionError();
        }
    }

    private static BigInteger sqrtFloor(BigInteger x) {
        BigInteger sqrt0;
        int log2 = log2(x, RoundingMode.FLOOR);
        if (log2 < 1023) {
            sqrt0 = sqrtApproxWithDoubles(x);
        } else {
            int shift = (log2 - 52) & -2;
            sqrt0 = sqrtApproxWithDoubles(x.shiftRight(shift)).shiftLeft(shift >> 1);
        }
        BigInteger sqrt1 = sqrt0.add(x.divide(sqrt0)).shiftRight(1);
        if (sqrt0.equals(sqrt1)) {
            return sqrt0;
        }
        do {
            sqrt0 = sqrt1;
            sqrt1 = sqrt0.add(x.divide(sqrt0)).shiftRight(1);
        } while (sqrt1.compareTo(sqrt0) < 0);
        return sqrt0;
    }

    private static BigInteger sqrtApproxWithDoubles(BigInteger x) {
        return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(x)), RoundingMode.HALF_EVEN);
    }

    public static BigInteger divide(BigInteger p, BigInteger q, RoundingMode mode) {
        return new BigDecimal(p).divide(new BigDecimal(q), 0, mode).toBigIntegerExact();
    }

    public static BigInteger factorial(int n) {
        MathPreconditions.checkNonNegative("n", n);
        if (n < LongMath.FACTORIALS.length) {
            return BigInteger.valueOf(LongMath.FACTORIALS[n]);
        }
        ArrayList<BigInteger> bignums = new ArrayList(IntMath.divide(IntMath.log2(n, RoundingMode.CEILING) * n, 64, RoundingMode.CEILING));
        int startingNumber = LongMath.FACTORIALS.length;
        long product = LongMath.FACTORIALS[startingNumber - 1];
        int shift = Long.numberOfTrailingZeros(product);
        product >>= shift;
        int productBits = LongMath.log2(product, RoundingMode.FLOOR) + 1;
        int bits = LongMath.log2((long) startingNumber, RoundingMode.FLOOR) + 1;
        int nextPowerOfTwo = 1 << (bits - 1);
        long num = (long) startingNumber;
        while (true) {
            if (num > ((long) n)) {
                break;
            }
            if ((((long) nextPowerOfTwo) & num) != 0) {
                nextPowerOfTwo <<= 1;
                bits++;
            }
            int tz = Long.numberOfTrailingZeros(num);
            long normalizedNum = num >> tz;
            shift += tz;
            if ((bits - tz) + productBits >= 64) {
                bignums.add(BigInteger.valueOf(product));
                product = 1;
            }
            product *= normalizedNum;
            productBits = LongMath.log2(product, RoundingMode.FLOOR) + 1;
            num++;
        }
        if (product > 1) {
            bignums.add(BigInteger.valueOf(product));
        }
        return listProduct(bignums).shiftLeft(shift);
    }

    static BigInteger listProduct(List<BigInteger> nums) {
        return listProduct(nums, 0, nums.size());
    }

    static BigInteger listProduct(List<BigInteger> nums, int start, int end) {
        switch (end - start) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return BigInteger.ONE;
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return (BigInteger) nums.get(start);
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return ((BigInteger) nums.get(start)).multiply((BigInteger) nums.get(start + 1));
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return ((BigInteger) nums.get(start)).multiply((BigInteger) nums.get(start + 1)).multiply((BigInteger) nums.get(start + 2));
            default:
                int m = (end + start) >>> 1;
                return listProduct(nums, start, m).multiply(listProduct(nums, m, end));
        }
    }

    public static BigInteger binomial(int n, int k) {
        MathPreconditions.checkNonNegative("n", n);
        MathPreconditions.checkNonNegative("k", k);
        Preconditions.checkArgument(k <= n, "k (%s) > n (%s)", Integer.valueOf(k), Integer.valueOf(n));
        if (k > (n >> 1)) {
            k = n - k;
        }
        if (k < LongMath.BIGGEST_BINOMIALS.length && n <= LongMath.BIGGEST_BINOMIALS[k]) {
            return BigInteger.valueOf(LongMath.binomial(n, k));
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            result = result.multiply(BigInteger.valueOf((long) (n - i))).divide(BigInteger.valueOf((long) (i + 1)));
        }
        return result;
    }

    static boolean fitsInLong(BigInteger x) {
        return x.bitLength() <= 63;
    }

    private BigIntegerMath() {
    }
}
