package com.google.gdata.util.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public class Joiner {
    private final String separator;

    /* renamed from: com.google.gdata.util.common.base.Joiner.1 */
    class C07621 extends Joiner {
        final /* synthetic */ String val$nullText;

        CharSequence toString(Object part) {
            return part == null ? this.val$nullText : part.toString();
        }

        public Joiner useForNull(String nullText) {
            Preconditions.checkNotNull(nullText);
            throw new UnsupportedOperationException("already specified useForNull");
        }

        C07621(Joiner x0, String str) {
            this.val$nullText = str;
            super(null);
        }

        public Joiner skipNulls() {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    /* renamed from: com.google.gdata.util.common.base.Joiner.2 */
    class C07632 extends Joiner {
        public <A extends Appendable> A appendTo(A appendable, Iterable<?> parts) throws IOException {
            Preconditions.checkNotNull(appendable, "appendable");
            Preconditions.checkNotNull(parts, "parts");
            Iterator<?> iterator = parts.iterator();
            while (iterator.hasNext()) {
                Object part = iterator.next();
                if (part != null) {
                    appendable.append(Joiner.this.toString(part));
                    break;
                }
            }
            while (iterator.hasNext()) {
                part = iterator.next();
                if (part != null) {
                    appendable.append(Joiner.this.separator);
                    appendable.append(Joiner.this.toString(part));
                }
            }
            return appendable;
        }

        public Joiner useForNull(String nullText) {
            Preconditions.checkNotNull(nullText);
            throw new UnsupportedOperationException("already specified skipNulls");
        }

        C07632(Joiner x0) throws IOException {
            super(null);
        }

        public MapJoiner withKeyValueSeparator(String kvs) {
            Preconditions.checkNotNull(kvs);
            throw new UnsupportedOperationException("can't use .skipNulls() with maps");
        }
    }

    /* renamed from: com.google.gdata.util.common.base.Joiner.3 */
    static class C07643 extends AbstractList<Object> {
        final /* synthetic */ Object val$first;
        final /* synthetic */ Object[] val$rest;
        final /* synthetic */ Object val$second;

        public int size() {
            return this.val$rest.length + 2;
        }

        C07643(Object[] objArr, Object obj, Object obj2) {
            this.val$rest = objArr;
            this.val$first = obj;
            this.val$second = obj2;
        }

        public Object get(int index) {
            switch (index) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                    return this.val$first;
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    return this.val$second;
                default:
                    return this.val$rest[index - 2];
            }
        }
    }

    public static class MapJoiner {
        private Joiner joiner;
        private String keyValueSeparator;

        private MapJoiner(Joiner joiner, String keyValueSeparator) {
            this.joiner = joiner;
            this.keyValueSeparator = keyValueSeparator;
        }

        public <A extends Appendable> A appendTo(A appendable, Map<?, ?> map) throws IOException {
            Preconditions.checkNotNull(appendable);
            Iterator<? extends Entry<?, ?>> iterator = map.entrySet().iterator();
            if (iterator.hasNext()) {
                Entry<?, ?> entry = (Entry) iterator.next();
                appendable.append(this.joiner.toString(entry.getKey()));
                appendable.append(this.keyValueSeparator);
                appendable.append(this.joiner.toString(entry.getValue()));
                while (iterator.hasNext()) {
                    appendable.append(this.joiner.separator);
                    Entry<?, ?> e = (Entry) iterator.next();
                    appendable.append(this.joiner.toString(e.getKey()));
                    appendable.append(this.keyValueSeparator);
                    appendable.append(this.joiner.toString(e.getValue()));
                }
            }
            return appendable;
        }

        public StringBuilder appendTo(StringBuilder builder, Map<?, ?> map) {
            try {
                appendTo((Appendable) builder, (Map) map);
                return builder;
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public String join(Map<?, ?> map) {
            return appendTo(new StringBuilder(), (Map) map).toString();
        }

        public MapJoiner useForNull(String nullText) {
            return new MapJoiner(this.joiner.useForNull(nullText), this.keyValueSeparator);
        }
    }

    public static Joiner on(String separator) {
        return new Joiner(separator);
    }

    private Joiner(String separator) {
        this.separator = (String) Preconditions.checkNotNull(separator);
    }

    private Joiner(Joiner prototype) {
        this.separator = prototype.separator;
    }

    public <A extends Appendable> A appendTo(A appendable, Iterable<?> parts) throws IOException {
        Preconditions.checkNotNull(appendable);
        Iterator<?> iterator = parts.iterator();
        if (iterator.hasNext()) {
            appendable.append(toString(iterator.next()));
            while (iterator.hasNext()) {
                appendable.append(this.separator);
                appendable.append(toString(iterator.next()));
            }
        }
        return appendable;
    }

    public final <A extends Appendable> A appendTo(A appendable, Object[] parts) throws IOException {
        return appendTo((Appendable) appendable, Arrays.asList(parts));
    }

    public final <A extends Appendable> A appendTo(A appendable, Object first, Object second, Object... rest) throws IOException {
        return appendTo((Appendable) appendable, iterable(first, second, rest));
    }

    public final StringBuilder appendTo(StringBuilder builder, Iterable<?> parts) {
        try {
            appendTo((Appendable) builder, (Iterable) parts);
            return builder;
        } catch (IOException impossible) {
            throw new AssertionError(impossible);
        }
    }

    public final StringBuilder appendTo(StringBuilder builder, Object[] parts) {
        return appendTo(builder, Arrays.asList(parts));
    }

    public final StringBuilder appendTo(StringBuilder builder, Object first, Object second, Object... rest) {
        return appendTo(builder, iterable(first, second, rest));
    }

    public final String join(Iterable<?> parts) {
        return appendTo(new StringBuilder(), (Iterable) parts).toString();
    }

    public final String join(Object[] parts) {
        return join(Arrays.asList(parts));
    }

    public final String join(Object first, Object second, Object... rest) {
        return join(iterable(first, second, rest));
    }

    public Joiner useForNull(String nullText) {
        Preconditions.checkNotNull(nullText);
        return new C07621(this, nullText);
    }

    public Joiner skipNulls() {
        return new C07632(this);
    }

    public MapJoiner withKeyValueSeparator(String keyValueSeparator) {
        return new MapJoiner((String) Preconditions.checkNotNull(keyValueSeparator), null);
    }

    CharSequence toString(Object part) {
        return part.toString();
    }

    private static Iterable<Object> iterable(Object first, Object second, Object[] rest) {
        Preconditions.checkNotNull(rest);
        return new C07643(rest, first, second);
    }
}
