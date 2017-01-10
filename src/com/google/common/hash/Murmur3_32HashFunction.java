package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;

final class Murmur3_32HashFunction extends AbstractStreamingHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;

    private static final class Murmur3_32Hasher extends AbstractStreamingHasher {
        int c1;
        int c2;
        int h1;
        int len;

        Murmur3_32Hasher(int seed) {
            super(4);
            this.c1 = -862048943;
            this.c2 = 461845907;
            this.h1 = seed;
        }

        protected void process(ByteBuffer bb) {
            int k1 = bb.getInt();
            this.len += 4;
            this.h1 ^= Integer.rotateLeft(k1 * this.c1, 15) * this.c2;
            this.h1 = Integer.rotateLeft(this.h1, 13);
            this.h1 = (this.h1 * 5) - 430675100;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void processRemaining(java.nio.ByteBuffer r4) {
            /*
            r3 = this;
            r1 = r3.len;
            r2 = r4.remaining();
            r1 = r1 + r2;
            r3.len = r1;
            r0 = 0;
            r1 = r4.remaining();
            switch(r1) {
                case 1: goto L_0x003b;
                case 2: goto L_0x002f;
                case 3: goto L_0x0023;
                default: goto L_0x0011;
            };
        L_0x0011:
            r1 = r3.c1;
            r0 = r0 * r1;
            r1 = 15;
            r0 = java.lang.Integer.rotateLeft(r0, r1);
            r1 = r3.c2;
            r0 = r0 * r1;
            r1 = r3.h1;
            r1 = r1 ^ r0;
            r3.h1 = r1;
            return;
        L_0x0023:
            r1 = 2;
            r1 = r4.get(r1);
            r1 = com.google.common.primitives.UnsignedBytes.toInt(r1);
            r1 = r1 << 16;
            r0 = r0 ^ r1;
        L_0x002f:
            r1 = 1;
            r1 = r4.get(r1);
            r1 = com.google.common.primitives.UnsignedBytes.toInt(r1);
            r1 = r1 << 8;
            r0 = r0 ^ r1;
        L_0x003b:
            r1 = 0;
            r1 = r4.get(r1);
            r1 = com.google.common.primitives.UnsignedBytes.toInt(r1);
            r0 = r0 ^ r1;
            goto L_0x0011;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Murmur3_32HashFunction.Murmur3_32Hasher.processRemaining(java.nio.ByteBuffer):void");
        }

        public HashCode makeHash() {
            this.h1 ^= this.len;
            this.h1 ^= this.h1 >>> 16;
            this.h1 *= -2048144789;
            this.h1 ^= this.h1 >>> 13;
            this.h1 *= -1028477387;
            this.h1 ^= this.h1 >>> 16;
            return HashCodes.fromInt(this.h1);
        }
    }

    Murmur3_32HashFunction(int seed) {
        this.seed = seed;
    }

    public int bits() {
        return 32;
    }

    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }
}
