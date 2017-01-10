package com.google.gdata.util.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.gdata.data.Category;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@GwtCompatible
public final class Objects {

    public static class ToStringHelper {
        private static final Joiner JOINER;
        private final List<String> fieldString;
        private final Object instance;

        private ToStringHelper(Object instance) {
            this.fieldString = new ArrayList();
            this.instance = Preconditions.checkNotNull(instance);
        }

        public ToStringHelper add(String name, Object value) {
            return addValue(((String) Preconditions.checkNotNull(name)) + "=" + value);
        }

        public ToStringHelper addValue(Object value) {
            this.fieldString.add(String.valueOf(value));
            return this;
        }

        static {
            JOINER = Joiner.on(", ");
        }

        public String toString() {
            return JOINER.appendTo(new StringBuilder(100).append(simpleName(this.instance.getClass())).append(Category.SCHEME_PREFIX), this.fieldString).append(Category.SCHEME_SUFFIX).toString();
        }

        @VisibleForTesting
        static String simpleName(Class<?> clazz) {
            String name = clazz.getName();
            int start = name.lastIndexOf(36);
            if (start == -1) {
                start = name.lastIndexOf(46);
            }
            return name.substring(start + 1);
        }
    }

    private Objects() {
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }

    public static ToStringHelper toStringHelper(Object object) {
        return new ToStringHelper(null);
    }

    public static <T> T nonNull(T obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException();
    }

    public static <T> T nonNull(T obj, String message) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(message);
    }

    public static <T> T firstNonNull(T first, T second) {
        return first != null ? first : Preconditions.checkNotNull(second);
    }

    public static boolean deepEquals(Object a, Object b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        Class<?> type1 = a.getClass();
        Class<?> type2 = b.getClass();
        if (!type1.isArray() || !type2.isArray()) {
            return a.equals(b);
        }
        if ((a instanceof Object[]) && (b instanceof Object[])) {
            return Arrays.deepEquals((Object[]) a, (Object[]) b);
        }
        if (type1 != type2) {
            return false;
        }
        if (a instanceof boolean[]) {
            return Arrays.equals((boolean[]) a, (boolean[]) b);
        }
        if (a instanceof char[]) {
            return Arrays.equals((char[]) a, (char[]) b);
        }
        if (a instanceof byte[]) {
            return Arrays.equals((byte[]) a, (byte[]) b);
        }
        if (a instanceof short[]) {
            return Arrays.equals((short[]) a, (short[]) b);
        }
        if (a instanceof int[]) {
            return Arrays.equals((int[]) a, (int[]) b);
        }
        if (a instanceof long[]) {
            return Arrays.equals((long[]) a, (long[]) b);
        }
        if (a instanceof float[]) {
            return Arrays.equals((float[]) a, (float[]) b);
        }
        if (a instanceof double[]) {
            return Arrays.equals((double[]) a, (double[]) b);
        }
        throw new AssertionError();
    }

    public static int deepHashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (!obj.getClass().isArray()) {
            return obj.hashCode();
        }
        if (obj instanceof Object[]) {
            return Arrays.deepHashCode((Object[]) obj);
        }
        if (obj instanceof boolean[]) {
            return Arrays.hashCode((boolean[]) obj);
        }
        if (obj instanceof char[]) {
            return Arrays.hashCode((char[]) obj);
        }
        if (obj instanceof byte[]) {
            return Arrays.hashCode((byte[]) obj);
        }
        if (obj instanceof short[]) {
            return Arrays.hashCode((short[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.hashCode((int[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.hashCode((long[]) obj);
        }
        if (obj instanceof float[]) {
            return Arrays.hashCode((float[]) obj);
        }
        if (obj instanceof double[]) {
            return Arrays.hashCode((double[]) obj);
        }
        throw new AssertionError();
    }

    public static String deepToString(Object obj) {
        if (obj == null) {
            return String.valueOf(obj);
        }
        if (!obj.getClass().isArray()) {
            return obj.toString();
        }
        if (obj instanceof Object[]) {
            return Arrays.deepToString((Object[]) obj);
        }
        if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[]) obj);
        }
        if (obj instanceof char[]) {
            return Arrays.toString((char[]) obj);
        }
        if (obj instanceof byte[]) {
            return Arrays.toString((byte[]) obj);
        }
        if (obj instanceof short[]) {
            return Arrays.toString((short[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.toString((int[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.toString((long[]) obj);
        }
        if (obj instanceof float[]) {
            return Arrays.toString((float[]) obj);
        }
        if (obj instanceof double[]) {
            return Arrays.toString((double[]) obj);
        }
        throw new AssertionError();
    }
}
