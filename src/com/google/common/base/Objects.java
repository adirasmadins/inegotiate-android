package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.gdata.data.Category;
import java.util.Arrays;
import javax.annotation.Nullable;

@GwtCompatible
public final class Objects {

    public static final class ToStringHelper {
        private final StringBuilder builder;
        private boolean needsSeparator;

        private ToStringHelper(String className) {
            this.needsSeparator = false;
            Preconditions.checkNotNull(className);
            this.builder = new StringBuilder(32).append(className).append(Category.SCHEME_PREFIX);
        }

        public ToStringHelper add(String name, @Nullable Object value) {
            checkNameAndAppend(name).append(value);
            return this;
        }

        public ToStringHelper add(String name, boolean value) {
            checkNameAndAppend(name).append(value);
            return this;
        }

        public ToStringHelper add(String name, char value) {
            checkNameAndAppend(name).append(value);
            return this;
        }

        public ToStringHelper add(String name, double value) {
            checkNameAndAppend(name).append(value);
            return this;
        }

        public ToStringHelper add(String name, float value) {
            checkNameAndAppend(name).append(value);
            return this;
        }

        public ToStringHelper add(String name, int value) {
            checkNameAndAppend(name).append(value);
            return this;
        }

        public ToStringHelper add(String name, long value) {
            checkNameAndAppend(name).append(value);
            return this;
        }

        private StringBuilder checkNameAndAppend(String name) {
            Preconditions.checkNotNull(name);
            return maybeAppendSeparator().append(name).append('=');
        }

        public ToStringHelper addValue(@Nullable Object value) {
            maybeAppendSeparator().append(value);
            return this;
        }

        public ToStringHelper addValue(boolean value) {
            maybeAppendSeparator().append(value);
            return this;
        }

        public ToStringHelper addValue(char value) {
            maybeAppendSeparator().append(value);
            return this;
        }

        public ToStringHelper addValue(double value) {
            maybeAppendSeparator().append(value);
            return this;
        }

        public ToStringHelper addValue(float value) {
            maybeAppendSeparator().append(value);
            return this;
        }

        public ToStringHelper addValue(int value) {
            maybeAppendSeparator().append(value);
            return this;
        }

        public ToStringHelper addValue(long value) {
            maybeAppendSeparator().append(value);
            return this;
        }

        public String toString() {
            try {
                String stringBuilder = this.builder.append(Category.SCHEME_SUFFIX).toString();
                return stringBuilder;
            } finally {
                this.builder.setLength(this.builder.length() - 1);
            }
        }

        private StringBuilder maybeAppendSeparator() {
            if (this.needsSeparator) {
                return this.builder.append(", ");
            }
            this.needsSeparator = true;
            return this.builder;
        }
    }

    private Objects() {
    }

    public static boolean equal(@Nullable Object a, @Nullable Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(@Nullable Object... objects) {
        return Arrays.hashCode(objects);
    }

    public static ToStringHelper toStringHelper(Object self) {
        return new ToStringHelper(null);
    }

    public static ToStringHelper toStringHelper(Class<?> clazz) {
        return new ToStringHelper(null);
    }

    public static ToStringHelper toStringHelper(String className) {
        return new ToStringHelper(null);
    }

    private static String simpleName(Class<?> clazz) {
        String name = clazz.getName().replaceAll("\\$[0-9]+", "\\$");
        int start = name.lastIndexOf(36);
        if (start == -1) {
            start = name.lastIndexOf(46);
        }
        return name.substring(start + 1);
    }

    public static <T> T firstNonNull(@Nullable T first, @Nullable T second) {
        return first != null ? first : Preconditions.checkNotNull(second);
    }
}
