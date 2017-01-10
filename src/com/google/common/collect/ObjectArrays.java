package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class ObjectArrays {
    private ObjectArrays() {
    }

    @GwtIncompatible("Array.newInstance(Class, int)")
    public static <T> T[] newArray(Class<T> type, int length) {
        return Platform.newArray((Class) type, length);
    }

    public static <T> T[] newArray(T[] reference, int length) {
        return Platform.newArray((Object[]) reference, length);
    }

    @GwtIncompatible("Array.newInstance(Class, int)")
    public static <T> T[] concat(T[] first, T[] second, Class<T> type) {
        T[] result = newArray((Class) type, first.length + second.length);
        Platform.unsafeArrayCopy(first, 0, result, 0, first.length);
        Platform.unsafeArrayCopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static <T> T[] concat(@Nullable T element, T[] array) {
        T[] result = newArray((Object[]) array, array.length + 1);
        result[0] = element;
        Platform.unsafeArrayCopy(array, 0, result, 1, array.length);
        return result;
    }

    public static <T> T[] concat(T[] array, @Nullable T element) {
        T[] result = arraysCopyOf(array, array.length + 1);
        result[array.length] = element;
        return result;
    }

    static <T> T[] arraysCopyOf(T[] original, int newLength) {
        T[] copy = newArray((Object[]) original, newLength);
        Platform.unsafeArrayCopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    static <T> T[] toArrayImpl(Collection<?> c, T[] array) {
        int size = c.size();
        if (array.length < size) {
            array = newArray((Object[]) array, size);
        }
        fillArray(c, array);
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    static Object[] toArrayImpl(Collection<?> c) {
        return fillArray(c, new Object[c.size()]);
    }

    private static Object[] fillArray(Iterable<?> elements, Object[] array) {
        int i = 0;
        for (Object element : elements) {
            int i2 = i + 1;
            array[i] = element;
            i = i2;
        }
        return array;
    }

    static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
