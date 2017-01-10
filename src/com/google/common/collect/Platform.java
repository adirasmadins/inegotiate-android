package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Array;

@GwtCompatible(emulated = true)
class Platform {
    static <T> T[] clone(T[] array) {
        return (Object[]) array.clone();
    }

    static void unsafeArrayCopy(Object[] src, int srcPos, Object[] dest, int destPos, int length) {
        System.arraycopy(src, srcPos, dest, destPos, length);
    }

    @GwtIncompatible("Array.newInstance(Class, int)")
    static <T> T[] newArray(Class<T> type, int length) {
        return (Object[]) Array.newInstance(type, length);
    }

    static <T> T[] newArray(T[] reference, int length) {
        return (Object[]) ((Object[]) Array.newInstance(reference.getClass().getComponentType(), length));
    }

    static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }

    private Platform() {
    }
}
