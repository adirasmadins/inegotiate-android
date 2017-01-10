package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class Hashing {
    private Hashing() {
    }

    static int smear(int hashCode) {
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return ((hashCode >>> 7) ^ hashCode) ^ (hashCode >>> 4);
    }
}
