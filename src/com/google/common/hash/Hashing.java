package com.google.common.hash;

import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedInts;
import java.nio.ByteBuffer;
import java.util.Iterator;

@Beta
public final class Hashing {
    private static final HashFunction MD5;
    private static final Murmur3_128HashFunction MURMUR3_128;
    private static final Murmur3_32HashFunction MURMUR3_32;
    private static final HashFunction SHA_1;
    private static final HashFunction SHA_256;
    private static final HashFunction SHA_512;

    private static class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        final int bits;

        ConcatenatedHashFunction(HashFunction[] functions) {
            super(functions);
            int bitSum = 0;
            for (HashFunction f : this.functions) {
                bitSum += f.bits();
            }
            this.bits = bitSum;
        }

        HashCode makeHash(Hasher[] hashers) {
            byte[] bytes = new byte[(this.bits / 8)];
            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            for (Hasher hasher : hashers) {
                buffer.put(hasher.hash().asBytes());
            }
            return HashCodes.fromBytes(bytes);
        }

        public int bits() {
            return this.bits;
        }
    }

    private Hashing() {
    }

    public static HashFunction goodFastHash(int minimumBits) {
        int bits = checkPositiveAndMakeMultipleOf32(minimumBits);
        if (bits == 32) {
            return murmur3_32();
        }
        if (bits <= XMLChar.MASK_NCNAME) {
            return murmur3_128();
        }
        int hashFunctionsNeeded = (bits + Ascii.MAX) / XMLChar.MASK_NCNAME;
        HashFunction[] hashFunctions = new HashFunction[hashFunctionsNeeded];
        for (int i = 0; i < hashFunctionsNeeded; i++) {
            hashFunctions[i] = murmur3_128(1500450271 * i);
        }
        return new ConcatenatedHashFunction(hashFunctions);
    }

    public static HashFunction murmur3_32(int seed) {
        return new Murmur3_32HashFunction(seed);
    }

    public static HashFunction murmur3_32() {
        return MURMUR3_32;
    }

    static {
        MURMUR3_32 = new Murmur3_32HashFunction(0);
        MURMUR3_128 = new Murmur3_128HashFunction(0);
        MD5 = new MessageDigestHashFunction("MD5");
        SHA_1 = new MessageDigestHashFunction("SHA-1");
        SHA_256 = new MessageDigestHashFunction("SHA-256");
        SHA_512 = new MessageDigestHashFunction("SHA-512");
    }

    public static HashFunction murmur3_128(int seed) {
        return new Murmur3_128HashFunction(seed);
    }

    public static HashFunction murmur3_128() {
        return MURMUR3_128;
    }

    public static HashFunction md5() {
        return MD5;
    }

    public static HashFunction sha1() {
        return SHA_1;
    }

    public static HashFunction sha256() {
        return SHA_256;
    }

    public static HashFunction sha512() {
        return SHA_512;
    }

    public static long padToLong(HashCode hashCode) {
        return hashCode.bits() < 64 ? UnsignedInts.toLong(hashCode.asInt()) : hashCode.asLong();
    }

    public static int consistentHash(HashCode hashCode, int buckets) {
        return consistentHash(padToLong(hashCode), buckets);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int consistentHash(long r11, int r13) {
        /*
        r7 = 1;
        r8 = 0;
        if (r13 <= 0) goto L_0x0035;
    L_0x0004:
        r6 = r7;
    L_0x0005:
        r9 = "buckets must be positive: %s";
        r7 = new java.lang.Object[r7];
        r10 = java.lang.Integer.valueOf(r13);
        r7[r8] = r10;
        com.google.common.base.Preconditions.checkArgument(r6, r9, r7);
        r1 = r11;
        r0 = 0;
    L_0x0014:
        r6 = 2862933555777941757; // 0x27bb2ee687b0b0fd float:-2.658556E-34 double:2.694898184339827E-117;
        r6 = r6 * r1;
        r8 = 1;
        r1 = r6 + r8;
        r6 = 4746794007248502784; // 0x41e0000000000000 float:0.0 double:2.147483648E9;
        r8 = 33;
        r8 = r1 >>> r8;
        r8 = (int) r8;
        r8 = r8 + 1;
        r8 = (double) r8;
        r3 = r6 / r8;
        r6 = r0 + 1;
        r6 = (double) r6;
        r6 = r6 * r3;
        r5 = (int) r6;
        if (r5 < 0) goto L_0x0037;
    L_0x0031:
        if (r5 >= r13) goto L_0x0037;
    L_0x0033:
        r0 = r5;
        goto L_0x0014;
    L_0x0035:
        r6 = r8;
        goto L_0x0005;
    L_0x0037:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Hashing.consistentHash(long, int):int");
    }

    public static HashCode combineOrdered(Iterable<HashCode> hashCodes) {
        Iterator<HashCode> iterator = hashCodes.iterator();
        Preconditions.checkArgument(iterator.hasNext(), "Must be at least 1 hash code to combine.");
        byte[] resultBytes = new byte[(((HashCode) iterator.next()).bits() / 8)];
        for (HashCode hashCode : hashCodes) {
            byte[] nextBytes = hashCode.asBytes();
            Preconditions.checkArgument(nextBytes.length == resultBytes.length, "All hashcodes must have the same bit length.");
            for (int i = 0; i < nextBytes.length; i++) {
                resultBytes[i] = (byte) ((resultBytes[i] * 37) ^ nextBytes[i]);
            }
        }
        return HashCodes.fromBytes(resultBytes);
    }

    public static HashCode combineUnordered(Iterable<HashCode> hashCodes) {
        Iterator<HashCode> iterator = hashCodes.iterator();
        Preconditions.checkArgument(iterator.hasNext(), "Must be at least 1 hash code to combine.");
        byte[] resultBytes = new byte[(((HashCode) iterator.next()).bits() / 8)];
        for (HashCode hashCode : hashCodes) {
            byte[] nextBytes = hashCode.asBytes();
            Preconditions.checkArgument(nextBytes.length == resultBytes.length, "All hashcodes must have the same bit length.");
            for (int i = 0; i < nextBytes.length; i++) {
                resultBytes[i] = (byte) (resultBytes[i] + nextBytes[i]);
            }
        }
        return HashCodes.fromBytes(resultBytes);
    }

    static int checkPositiveAndMakeMultipleOf32(int bits) {
        Preconditions.checkArgument(bits > 0, "Number of bits must be positive");
        return (bits + 31) & -32;
    }
}
