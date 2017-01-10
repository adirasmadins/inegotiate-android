package com.google.common.primitives;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.gdata.util.common.base.StringUtil;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Comparator;
import sun.misc.Unsafe;

public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;

    @VisibleForTesting
    static class LexicographicalComparatorHolder {
        static final Comparator<byte[]> BEST_COMPARATOR;
        static final String UNSAFE_COMPARATOR_NAME;

        enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            public int compare(byte[] left, byte[] right) {
                int minLength = Math.min(left.length, right.length);
                for (int i = 0; i < minLength; i++) {
                    int result = UnsignedBytes.compare(left[i], right[i]);
                    if (result != 0) {
                        return result;
                    }
                }
                return left.length - right.length;
            }
        }

        @VisibleForTesting
        enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;
            
            static final int BYTE_ARRAY_BASE_OFFSET;
            static final boolean littleEndian;
            static final Unsafe theUnsafe;

            /* renamed from: com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.1 */
            static class C06801 implements PrivilegedAction<Object> {
                C06801() {
                }

                public Object run() {
                    try {
                        Field f = Unsafe.class.getDeclaredField("theUnsafe");
                        f.setAccessible(true);
                        return f.get(null);
                    } catch (NoSuchFieldException e) {
                        throw new Error();
                    } catch (IllegalAccessException e2) {
                        throw new Error();
                    }
                }
            }

            static {
                littleEndian = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);
                theUnsafe = (Unsafe) AccessController.doPrivileged(new C06801());
                BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
                if (theUnsafe.arrayIndexScale(byte[].class) != 1) {
                    throw new AssertionError();
                }
            }

            public int compare(byte[] left, byte[] right) {
                int minLength = Math.min(left.length, right.length);
                int minWords = minLength / 8;
                int i = 0;
                while (i < minWords * 8) {
                    long lw = theUnsafe.getLong(left, ((long) BYTE_ARRAY_BASE_OFFSET) + ((long) i));
                    long rw = theUnsafe.getLong(right, ((long) BYTE_ARRAY_BASE_OFFSET) + ((long) i));
                    long diff = lw ^ rw;
                    if (diff == 0) {
                        i += 8;
                    } else if (!littleEndian) {
                        return UnsignedLongs.compare(lw, rw);
                    } else {
                        int n = 0;
                        int x = (int) diff;
                        if (x == 0) {
                            x = (int) (diff >>> 32);
                            n = 32;
                        }
                        int y = x << 16;
                        if (y == 0) {
                            n += 16;
                        } else {
                            x = y;
                        }
                        if ((x << 8) == 0) {
                            n += 8;
                        }
                        return (int) (((lw >>> n) & 255) - ((rw >>> n) & 255));
                    }
                }
                for (i = minWords * 8; i < minLength; i++) {
                    int result = UnsignedBytes.compare(left[i], right[i]);
                    if (result != 0) {
                        return result;
                    }
                }
                return left.length - right.length;
            }
        }

        LexicographicalComparatorHolder() {
        }

        static {
            UNSAFE_COMPARATOR_NAME = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";
            BEST_COMPARATOR = getBestComparator();
        }

        static Comparator<byte[]> getBestComparator() {
            try {
                return (Comparator) Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants()[0];
            } catch (Throwable th) {
                return UnsignedBytes.lexicographicalComparatorJavaImpl();
            }
        }
    }

    private UnsignedBytes() {
    }

    public static int toInt(byte value) {
        return value & 255;
    }

    public static byte checkedCast(long value) {
        boolean z;
        if ((value >> 8) == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "out of range: %s", Long.valueOf(value));
        return (byte) ((int) value);
    }

    public static byte saturatedCast(long value) {
        if (value > 255) {
            return (byte) -1;
        }
        if (value < 0) {
            return (byte) 0;
        }
        return (byte) ((int) value);
    }

    public static int compare(byte a, byte b) {
        return toInt(a) - toInt(b);
    }

    public static byte min(byte... array) {
        boolean z;
        if (array.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int min = toInt(array[0]);
        for (int i = 1; i < array.length; i++) {
            int next = toInt(array[i]);
            if (next < min) {
                min = next;
            }
        }
        return (byte) min;
    }

    public static byte max(byte... array) {
        boolean z;
        if (array.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int max = toInt(array[0]);
        for (int i = 1; i < array.length; i++) {
            int next = toInt(array[i]);
            if (next > max) {
                max = next;
            }
        }
        return (byte) max;
    }

    public static String join(String separator, byte... array) {
        Preconditions.checkNotNull(separator);
        if (array.length == 0) {
            return StringUtil.EMPTY_STRING;
        }
        StringBuilder builder = new StringBuilder(array.length * 5);
        builder.append(toInt(array[0]));
        for (int i = 1; i < array.length; i++) {
            builder.append(separator).append(toInt(array[i]));
        }
        return builder.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    @VisibleForTesting
    static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return PureJavaComparator.INSTANCE;
    }
}
