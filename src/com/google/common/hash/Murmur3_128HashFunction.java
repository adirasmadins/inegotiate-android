package com.google.common.hash;

import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class Murmur3_128HashFunction extends AbstractStreamingHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;

    private static final class Murmur3_128Hasher extends AbstractStreamingHasher {
        long c1;
        long c2;
        long h1;
        long h2;
        int len;

        Murmur3_128Hasher(int seed) {
            super(16);
            this.c1 = -8663945395140668459L;
            this.c2 = 5545529020109919103L;
            this.h1 = (long) seed;
            this.h2 = (long) seed;
        }

        protected void process(ByteBuffer bb) {
            long k1 = bb.getLong();
            long k2 = bb.getLong();
            this.len += 16;
            bmix64(k1, k2);
        }

        private void bmix64(long k1, long k2) {
            this.h1 ^= Long.rotateLeft(k1 * this.c1, 31) * this.c2;
            this.h1 = Long.rotateLeft(this.h1, 27);
            this.h1 += this.h2;
            this.h1 = (this.h1 * 5) + 1390208809;
            this.h2 ^= Long.rotateLeft(k2 * this.c2, 33) * this.c1;
            this.h2 = Long.rotateLeft(this.h2, 31);
            this.h2 += this.h1;
            this.h2 = (this.h2 * 5) + 944331445;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void processRemaining(java.nio.ByteBuffer r13) {
            /*
            r12 = this;
            r11 = 32;
            r10 = 24;
            r9 = 16;
            r8 = 8;
            r7 = 0;
            r0 = 0;
            r2 = 0;
            r4 = r12.len;
            r5 = r13.remaining();
            r4 = r4 + r5;
            r12.len = r4;
            r4 = r13.remaining();
            switch(r4) {
                case 1: goto L_0x00e6;
                case 2: goto L_0x00da;
                case 3: goto L_0x00ce;
                case 4: goto L_0x00c2;
                case 5: goto L_0x00b6;
                case 6: goto L_0x00a8;
                case 7: goto L_0x009a;
                case 8: goto L_0x008c;
                case 9: goto L_0x0070;
                case 10: goto L_0x0063;
                case 11: goto L_0x0056;
                case 12: goto L_0x0049;
                case 13: goto L_0x003c;
                case 14: goto L_0x002d;
                case 15: goto L_0x001e;
                default: goto L_0x001d;
            };
        L_0x001d:
            return;
        L_0x001e:
            r4 = 14;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r6 = 48;
            r4 = r4 << r6;
            r2 = r2 ^ r4;
        L_0x002d:
            r4 = 13;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r6 = 40;
            r4 = r4 << r6;
            r2 = r2 ^ r4;
        L_0x003c:
            r4 = 12;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r4 = r4 << r11;
            r2 = r2 ^ r4;
        L_0x0049:
            r4 = 11;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r4 = r4 << r10;
            r2 = r2 ^ r4;
        L_0x0056:
            r4 = 10;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r4 = r4 << r9;
            r2 = r2 ^ r4;
        L_0x0063:
            r4 = 9;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r4 = r4 << r8;
            r2 = r2 ^ r4;
        L_0x0070:
            r4 = r13.get(r8);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r4 = r4 << r7;
            r2 = r2 ^ r4;
            r4 = r12.c2;
            r2 = r2 * r4;
            r4 = 33;
            r2 = java.lang.Long.rotateLeft(r2, r4);
            r4 = r12.c1;
            r2 = r2 * r4;
            r4 = r12.h2;
            r4 = r4 ^ r2;
            r12.h2 = r4;
        L_0x008c:
            r4 = 7;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r6 = 56;
            r4 = r4 << r6;
            r0 = r0 ^ r4;
        L_0x009a:
            r4 = 6;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r6 = 48;
            r4 = r4 << r6;
            r0 = r0 ^ r4;
        L_0x00a8:
            r4 = 5;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r6 = 40;
            r4 = r4 << r6;
            r0 = r0 ^ r4;
        L_0x00b6:
            r4 = 4;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r4 = r4 << r11;
            r0 = r0 ^ r4;
        L_0x00c2:
            r4 = 3;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r4 = r4 << r10;
            r0 = r0 ^ r4;
        L_0x00ce:
            r4 = 2;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r4 = r4 << r9;
            r0 = r0 ^ r4;
        L_0x00da:
            r4 = 1;
            r4 = r13.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r4 = r4 << r8;
            r0 = r0 ^ r4;
        L_0x00e6:
            r4 = r13.get(r7);
            r4 = com.google.common.primitives.UnsignedBytes.toInt(r4);
            r4 = (long) r4;
            r4 = r4 << r7;
            r0 = r0 ^ r4;
            r4 = r12.c1;
            r0 = r0 * r4;
            r4 = 31;
            r0 = java.lang.Long.rotateLeft(r0, r4);
            r4 = r12.c2;
            r0 = r0 * r4;
            r4 = r12.h1;
            r4 = r4 ^ r0;
            r12.h1 = r4;
            goto L_0x001d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Murmur3_128HashFunction.Murmur3_128Hasher.processRemaining(java.nio.ByteBuffer):void");
        }

        public HashCode makeHash() {
            this.h1 ^= (long) this.len;
            this.h2 ^= (long) this.len;
            this.h1 += this.h2;
            this.h2 += this.h1;
            this.h1 = fmix64(this.h1);
            this.h2 = fmix64(this.h2);
            this.h1 += this.h2;
            this.h2 += this.h1;
            ByteBuffer bb = ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN);
            bb.putLong(this.h1);
            bb.putLong(this.h2);
            return HashCodes.fromBytes(bb.array());
        }

        private long fmix64(long k) {
            k = (k ^ (k >>> 33)) * -49064778989728563L;
            k = (k ^ (k >>> 33)) * -4265267296055464877L;
            return k ^ (k >>> 33);
        }
    }

    Murmur3_128HashFunction(int seed) {
        this.seed = seed;
    }

    public int bits() {
        return XMLChar.MASK_NCNAME;
    }

    public Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }
}
