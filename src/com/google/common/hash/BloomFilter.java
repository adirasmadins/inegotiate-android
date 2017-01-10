package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.Serializable;
import java.math.RoundingMode;

@Beta
public final class BloomFilter<T> implements Serializable {
    private static final double LN2;
    private static final double LN2_SQUARED;
    private final BitArray bits;
    private final Funnel<T> funnel;
    private final int hashBitsPerSlice;
    private final HashFunction hashFunction;
    private final int numHashFunctions;

    private static class BitArray {
        final long[] data;

        BitArray(int bits) {
            this(new long[(bits >> 6)]);
        }

        BitArray(long[] data) {
            Preconditions.checkArgument(data.length > 0, "data length is zero!");
            this.data = data;
        }

        void set(int index) {
            long[] jArr = this.data;
            int i = index >> 6;
            jArr[i] = jArr[i] | (1 << index);
        }

        boolean get(int index) {
            return (this.data[index >> 6] & (1 << index)) != 0;
        }

        int size() {
            return this.data.length * 64;
        }
    }

    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final long[] data;
        final Funnel<T> funnel;
        final HashFunction hashFunction;
        final int numHashFunctions;

        SerialForm(BloomFilter<T> bf) {
            this.data = bf.bits.data;
            this.numHashFunctions = bf.numHashFunctions;
            this.funnel = bf.funnel;
            this.hashFunction = bf.hashFunction;
        }

        Object readResolve() {
            return new BloomFilter(this.numHashFunctions, this.funnel, this.hashFunction, null);
        }
    }

    private BloomFilter(BitArray bits, int numHashFunctions, Funnel<T> funnel, HashFunction hashFunction) {
        Preconditions.checkArgument(numHashFunctions > 0, "numHashFunctions zero or negative");
        this.bits = (BitArray) Preconditions.checkNotNull(bits);
        this.numHashFunctions = numHashFunctions;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel);
        this.hashFunction = (HashFunction) Preconditions.checkNotNull(hashFunction);
        this.hashBitsPerSlice = IntMath.log2(Math.max(bits.size(), 64), RoundingMode.CEILING);
    }

    public boolean mightContain(T instance) {
        HashCodeSlicer slicer = HashCodes.slice(this.hashFunction.newHasher().putObject(instance, this.funnel).hash(), this.hashBitsPerSlice);
        for (int i = 0; i < this.numHashFunctions; i++) {
            if (!this.bits.get(slicer.nextSlice())) {
                return false;
            }
        }
        return true;
    }

    public void put(T instance) {
        HashCodeSlicer slicer = HashCodes.slice(this.hashFunction.newHasher().putObject(instance, this.funnel).hash(), this.hashBitsPerSlice);
        for (int i = 0; i < this.numHashFunctions; i++) {
            this.bits.set(slicer.nextSlice());
        }
    }

    @VisibleForTesting
    int getHashCount() {
        return this.numHashFunctions;
    }

    @VisibleForTesting
    double computeExpectedFalsePositiveRate(int insertions) {
        return Math.pow(1.0d - Math.exp(((double) (-this.numHashFunctions)) * (((double) insertions) / ((double) this.bits.size()))), (double) this.numHashFunctions);
    }

    public static <T> BloomFilter<T> create(Funnel<T> funnel, int expectedInsertions, double falsePositiveProbability) {
        boolean z;
        int i;
        int i2 = 0;
        Preconditions.checkNotNull(funnel);
        if (expectedInsertions > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Expected insertions must be positive");
        if (falsePositiveProbability > 0.0d) {
            i = 1;
        } else {
            i = 0;
        }
        if (falsePositiveProbability < 1.0d) {
            i2 = 1;
        }
        Preconditions.checkArgument(i & i2, "False positive probability in (0.0, 1.0)");
        int m = optimalM(expectedInsertions, falsePositiveProbability);
        int k = optimalK(expectedInsertions, m);
        BitArray bits = new BitArray(1 << IntMath.log2(Math.max(m, 64), RoundingMode.CEILING));
        return new BloomFilter(bits, k, funnel, From128ToN.withBits(bits.size() * k, Hashing.murmur3_128()));
    }

    public static <T> BloomFilter<T> create(Funnel<T> funnel, int expectedInsertions) {
        return create(funnel, expectedInsertions, 0.03d);
    }

    static {
        LN2 = Math.log(2.0d);
        LN2_SQUARED = LN2 * LN2;
    }

    @VisibleForTesting
    static int optimalK(int n, int m) {
        return Math.max(1, (int) Math.round(((double) (m / n)) * LN2));
    }

    @VisibleForTesting
    static int optimalM(int n, double p) {
        return (int) ((((double) (-n)) * Math.log(p)) / LN2_SQUARED);
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }
}
