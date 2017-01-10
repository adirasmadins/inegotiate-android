package com.google.common.hash;

final class HashCodes {

    private static class BytesHashCode extends HashCode {
        final byte[] bytes;

        BytesHashCode(byte[] bytes) {
            this.bytes = bytes;
        }

        public int bits() {
            return this.bytes.length * 8;
        }

        public byte[] asBytes() {
            return (byte[]) this.bytes.clone();
        }

        public int asInt() {
            return (((this.bytes[0] & 255) | ((this.bytes[1] & 255) << 8)) | ((this.bytes[2] & 255) << 16)) | ((this.bytes[3] & 255) << 24);
        }

        public long asLong() {
            if (this.bytes.length >= 8) {
                return (((((((((long) this.bytes[0]) & 255) | ((((long) this.bytes[1]) & 255) << 8)) | ((((long) this.bytes[2]) & 255) << 16)) | ((((long) this.bytes[3]) & 255) << 24)) | ((((long) this.bytes[4]) & 255) << 32)) | ((((long) this.bytes[5]) & 255) << 40)) | ((((long) this.bytes[6]) & 255) << 48)) | ((((long) this.bytes[7]) & 255) << 56);
            }
            throw new IllegalStateException("Not enough bytes");
        }
    }

    static class HashCodeSlicer {
        int bitIndex;
        final int bitsPerSlice;
        int byteIndex;
        final byte[] bytes;

        HashCodeSlicer(byte[] bytes, int bitsPerSlice) {
            this.bytes = bytes;
            this.bitsPerSlice = bitsPerSlice;
        }

        int nextSlice() {
            int slice = 0;
            for (int i = 0; i < this.bitsPerSlice; i++) {
                slice = (slice << 1) | ((this.bytes[this.byteIndex] >>> this.bitIndex) & 1);
                this.bitIndex++;
                if (this.bitIndex == 8) {
                    this.bitIndex = 0;
                    this.byteIndex++;
                }
            }
            return slice;
        }
    }

    private static class IntHashCode extends HashCode {
        final int hash;

        IntHashCode(int hash) {
            this.hash = hash;
        }

        public int bits() {
            return 32;
        }

        public byte[] asBytes() {
            return new byte[]{(byte) this.hash, (byte) (this.hash >> 8), (byte) (this.hash >> 16), (byte) (this.hash >> 24)};
        }

        public int asInt() {
            return this.hash;
        }

        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }
    }

    private static class LongHashCode extends HashCode {
        final long hash;

        LongHashCode(long hash) {
            this.hash = hash;
        }

        public int bits() {
            return 64;
        }

        public byte[] asBytes() {
            return new byte[]{(byte) ((int) this.hash), (byte) ((int) (this.hash >> 8)), (byte) ((int) (this.hash >> 16)), (byte) ((int) (this.hash >> 24)), (byte) ((int) (this.hash >> 32)), (byte) ((int) (this.hash >> 40)), (byte) ((int) (this.hash >> 48)), (byte) ((int) (this.hash >> 56))};
        }

        public int asInt() {
            return (int) this.hash;
        }

        public long asLong() {
            return this.hash;
        }
    }

    private HashCodes() {
    }

    static HashCode fromInt(int hash) {
        return new IntHashCode(hash);
    }

    static HashCode fromLong(long hash) {
        return new LongHashCode(hash);
    }

    static HashCode fromBytes(byte[] bytes) {
        return new BytesHashCode(bytes);
    }

    static HashCodeSlicer slice(HashCode hashCode, int bitsPerSlice) {
        return new HashCodeSlicer(hashCode.asBytes(), bitsPerSlice);
    }
}
