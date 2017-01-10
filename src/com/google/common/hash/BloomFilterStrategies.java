package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;

final class BloomFilterStrategies {

    static class From128ToN extends AbstractCompositeHashFunction implements Serializable {
        private final int bits;
        private final HashFunction hashFunction;

        private static class SerialForm implements Serializable {
            private static final long serialVersionUID = 0;
            final int bits;
            final HashFunction hashFunction;

            SerialForm(From128ToN object) {
                this.bits = object.bits;
                this.hashFunction = object.hashFunction;
            }

            Object readResolve() {
                return From128ToN.withBits(this.bits, this.hashFunction);
            }
        }

        private From128ToN(int longs, HashFunction hashFunction) {
            super(hashFunction);
            this.hashFunction = hashFunction;
            this.bits = longs;
        }

        static From128ToN withBits(int bits, HashFunction hashFunction) {
            return new From128ToN(BloomFilterStrategies.checkPositiveAndMakeMultipleOf64(bits), hashFunction);
        }

        HashCode makeHash(Hasher[] hashers) {
            ByteBuffer buf = ByteBuffer.wrap(hashers[0].hash().asBytes());
            return BloomFilterStrategies.compose64(buf.getLong(), buf.getLong(), this.bits);
        }

        public int bits() {
            return this.bits;
        }

        private Object writeReplace() {
            return new SerialForm(this);
        }
    }

    private BloomFilterStrategies() {
    }

    private static int checkPositiveAndMakeMultipleOf64(int bits) {
        Preconditions.checkArgument(bits > 0, "Number of bits must be positive");
        return (bits + 63) & -64;
    }

    private static HashCode compose64(long hash1, long hash2, int bits) {
        byte[] bytes = new byte[(bits / 8)];
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        long numLongs = (long) (bits / 64);
        for (long i = 1; i <= numLongs; i++) {
            buf.putLong((i * hash2) + hash1);
        }
        return HashCodes.fromBytes(bytes);
    }
}
