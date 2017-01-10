package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

@GwtCompatible
public class Joiner {
    private final String separator;

    /* renamed from: com.google.common.base.Joiner.1 */
    class C03461 extends Joiner {
        final /* synthetic */ String val$nullText;

        C03461(Joiner x0, String str) {
            this.val$nullText = str;
            super(null);
        }

        CharSequence toString(Object part) {
            return part == null ? this.val$nullText : Joiner.this.toString(part);
        }

        public Joiner useForNull(String nullText) {
            Preconditions.checkNotNull(nullText);
            throw new UnsupportedOperationException("already specified useForNull");
        }

        public Joiner skipNulls() {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    /* renamed from: com.google.common.base.Joiner.2 */
    class C03472 extends Joiner {
        C03472(Joiner x0) {
            super(null);
        }

        public <A extends Appendable> A appendTo(A appendable, Iterator<?> parts) throws IOException {
            Preconditions.checkNotNull(appendable, "appendable");
            Preconditions.checkNotNull(parts, "parts");
            while (parts.hasNext()) {
                Object part = parts.next();
                if (part != null) {
                    appendable.append(Joiner.this.toString(part));
                    break;
                }
            }
            while (parts.hasNext()) {
                part = parts.next();
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

        public MapJoiner withKeyValueSeparator(String kvs) {
            Preconditions.checkNotNull(kvs);
            throw new UnsupportedOperationException("can't use .skipNulls() with maps");
        }
    }

    /* renamed from: com.google.common.base.Joiner.3 */
    static class C03483 extends AbstractList<Object> {
        final /* synthetic */ Object val$first;
        final /* synthetic */ Object[] val$rest;
        final /* synthetic */ Object val$second;

        C03483(Object[] objArr, Object obj, Object obj2) {
            this.val$rest = objArr;
            this.val$first = obj;
            this.val$second = obj2;
        }

        public int size() {
            return this.val$rest.length + 2;
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

    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        private MapJoiner(Joiner joiner, String keyValueSeparator) {
            this.joiner = joiner;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(keyValueSeparator);
        }

        public <A extends Appendable> A appendTo(A appendable, Map<?, ?> map) throws IOException {
            return appendTo((Appendable) appendable, map.entrySet());
        }

        public StringBuilder appendTo(StringBuilder builder, Map<?, ?> map) {
            return appendTo(builder, map.entrySet());
        }

        public String join(Map<?, ?> map) {
            return join(map.entrySet());
        }

        @Deprecated
        @Beta
        public <A extends Appendable, I extends Iterable<? extends Entry<?, ?>> & Iterator<? extends Entry<?, ?>>> A appendTo(A appendable, I entries) throws IOException {
            return appendTo((Appendable) appendable, (Iterator) entries);
        }

        @Beta
        public <A extends Appendable> A appendTo(A appendable, Iterable<? extends Entry<?, ?>> entries) throws IOException {
            return appendTo((Appendable) appendable, entries.iterator());
        }

        @Beta
        public <A extends Appendable> A appendTo(A appendable, Iterator<? extends Entry<?, ?>> parts) throws IOException {
            Preconditions.checkNotNull(appendable);
            if (parts.hasNext()) {
                Entry<?, ?> entry = (Entry) parts.next();
                appendable.append(this.joiner.toString(entry.getKey()));
                appendable.append(this.keyValueSeparator);
                appendable.append(this.joiner.toString(entry.getValue()));
                while (parts.hasNext()) {
                    appendable.append(this.joiner.separator);
                    Entry<?, ?> e = (Entry) parts.next();
                    appendable.append(this.joiner.toString(e.getKey()));
                    appendable.append(this.keyValueSeparator);
                    appendable.append(this.joiner.toString(e.getValue()));
                }
            }
            return appendable;
        }

        @Deprecated
        @Beta
        public <I extends Iterable<? extends Entry<?, ?>> & Iterator<? extends Entry<?, ?>>> StringBuilder appendTo(StringBuilder builder, I entries) throws IOException {
            return appendTo(builder, (Iterator) entries);
        }

        @Beta
        public StringBuilder appendTo(StringBuilder builder, Iterable<? extends Entry<?, ?>> entries) {
            return appendTo(builder, entries.iterator());
        }

        @Beta
        public StringBuilder appendTo(StringBuilder builder, Iterator<? extends Entry<?, ?>> entries) {
            try {
                appendTo((Appendable) builder, (Iterator) entries);
                return builder;
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        @Deprecated
        @Beta
        public <I extends Iterable<? extends Entry<?, ?>> & Iterator<? extends Entry<?, ?>>> String join(I entries) throws IOException {
            return join((Iterator) entries);
        }

        @Beta
        public String join(Iterable<? extends Entry<?, ?>> entries) {
            return join(entries.iterator());
        }

        @Beta
        public String join(Iterator<? extends Entry<?, ?>> entries) {
            return appendTo(new StringBuilder(), (Iterator) entries).toString();
        }

        @CheckReturnValue
        public MapJoiner useForNull(String nullText) {
            return new MapJoiner(this.joiner.useForNull(nullText), this.keyValueSeparator);
        }
    }

    public static Joiner on(String separator) {
        return new Joiner(separator);
    }

    public static Joiner on(char separator) {
        return new Joiner(String.valueOf(separator));
    }

    private Joiner(String separator) {
        this.separator = (String) Preconditions.checkNotNull(separator);
    }

    private Joiner(Joiner prototype) {
        this.separator = prototype.separator;
    }

    @Deprecated
    @Beta
    public final <A extends Appendable, I extends Iterable<?> & Iterator<?>> A appendTo(A appendable, I parts) throws IOException {
        return appendTo((Appendable) appendable, (Iterator) parts);
    }

    public <A extends Appendable> A appendTo(A appendable, Iterable<?> parts) throws IOException {
        return appendTo((Appendable) appendable, parts.iterator());
    }

    @Beta
    public <A extends Appendable> A appendTo(A appendable, Iterator<?> parts) throws IOException {
        Preconditions.checkNotNull(appendable);
        if (parts.hasNext()) {
            appendable.append(toString(parts.next()));
            while (parts.hasNext()) {
                appendable.append(this.separator);
                appendable.append(toString(parts.next()));
            }
        }
        return appendable;
    }

    public final <A extends Appendable> A appendTo(A appendable, Object[] parts) throws IOException {
        return appendTo((Appendable) appendable, Arrays.asList(parts));
    }

    public final <A extends Appendable> A appendTo(A appendable, @Nullable Object first, @Nullable Object second, Object... rest) throws IOException {
        return appendTo((Appendable) appendable, iterable(first, second, rest));
    }

    @Deprecated
    @Beta
    public final <I extends Iterable<?> & Iterator<?>> StringBuilder appendTo(StringBuilder builder, I parts) {
        return appendTo(builder, (Iterator) parts);
    }

    public final StringBuilder appendTo(StringBuilder builder, Iterable<?> parts) {
        return appendTo(builder, parts.iterator());
    }

    @Beta
    public final StringBuilder appendTo(StringBuilder builder, Iterator<?> parts) {
        try {
            appendTo((Appendable) builder, (Iterator) parts);
            return builder;
        } catch (IOException impossible) {
            throw new AssertionError(impossible);
        }
    }

    public final StringBuilder appendTo(StringBuilder builder, Object[] parts) {
        return appendTo(builder, Arrays.asList(parts));
    }

    public final StringBuilder appendTo(StringBuilder builder, @Nullable Object first, @Nullable Object second, Object... rest) {
        return appendTo(builder, iterable(first, second, rest));
    }

    @Deprecated
    @Beta
    public final <I extends Iterable<?> & Iterator<?>> String join(I parts) {
        return join((Iterator) parts);
    }

    public final String join(Iterable<?> parts) {
        return join(parts.iterator());
    }

    @Beta
    public final String join(Iterator<?> parts) {
        return appendTo(new StringBuilder(), (Iterator) parts).toString();
    }

    public final String join(Object[] parts) {
        return join(Arrays.asList(parts));
    }

    public final String join(@Nullable Object first, @Nullable Object second, Object... rest) {
        return join(iterable(first, second, rest));
    }

    @CheckReturnValue
    public Joiner useForNull(String nullText) {
        Preconditions.checkNotNull(nullText);
        return new C03461(this, nullText);
    }

    @CheckReturnValue
    public Joiner skipNulls() {
        return new C03472(this);
    }

    @CheckReturnValue
    public MapJoiner withKeyValueSeparator(String keyValueSeparator) {
        return new MapJoiner(keyValueSeparator, null);
    }

    CharSequence toString(Object part) {
        Preconditions.checkNotNull(part);
        return part instanceof CharSequence ? (CharSequence) part : part.toString();
    }

    private static Iterable<Object> iterable(Object first, Object second, Object[] rest) {
        Preconditions.checkNotNull(rest);
        return new C03483(rest, first, second);
    }
}
