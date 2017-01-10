package com.google.gdata.util.common.base;

import com.amazonaws.services.s3.internal.Constants;
import com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@GwtCompatible
public final class Join {

    /* renamed from: com.google.gdata.util.common.base.Join.1 */
    static class C07611 extends AbstractList<Object> {
        final /* synthetic */ Object val$first;
        final /* synthetic */ Object[] val$rest;

        public int size() {
            return this.val$rest.length + 1;
        }

        C07611(Object[] objArr, Object obj) {
            this.val$rest = objArr;
            this.val$first = obj;
        }

        public Object get(int index) {
            return index == 0 ? this.val$first : this.val$rest[index - 1];
        }
    }

    public static class JoinException extends RuntimeException {
        private static final long serialVersionUID = 1;

        private JoinException(IOException cause) {
            super(cause);
        }
    }

    private Join() {
    }

    public static String join(String delimiter, Iterable<?> tokens) {
        return Joiner.on(delimiter).useForNull(Constants.NULL_VERSION_ID).join((Iterable) tokens);
    }

    public static String join(String delimiter, Object[] tokens) {
        return Joiner.on(delimiter).useForNull(Constants.NULL_VERSION_ID).join(tokens);
    }

    public static String join(String delimiter, Object firstToken, Object... otherTokens) {
        return Joiner.on(delimiter).useForNull(Constants.NULL_VERSION_ID).join(iterable(firstToken, otherTokens));
    }

    public static String join(String delimiter, Iterator<?> tokens) {
        Appendable sb = new StringBuilder();
        join(sb, delimiter, (Iterator) tokens);
        return sb.toString();
    }

    public static String join(String keyValueSeparator, String entryDelimiter, Map<?, ?> map) {
        return Joiner.on(entryDelimiter).useForNull(Constants.NULL_VERSION_ID).withKeyValueSeparator(keyValueSeparator).join(map);
    }

    public static <T extends Appendable> T join(T appendable, String delimiter, Iterable<?> tokens) {
        try {
            return Joiner.on(delimiter).useForNull(Constants.NULL_VERSION_ID).appendTo((Appendable) appendable, (Iterable) tokens);
        } catch (IOException e) {
            throw new JoinException(null);
        }
    }

    public static <T extends Appendable> T join(T appendable, String delimiter, Object[] tokens) {
        return join((Appendable) appendable, delimiter, Arrays.asList(tokens));
    }

    public static <T extends Appendable> T join(T appendable, String delimiter, Object firstToken, Object... otherTokens) {
        return join((Appendable) appendable, delimiter, iterable(firstToken, otherTokens));
    }

    public static <T extends Appendable> T join(T appendable, String delimiter, Iterator<?> tokens) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(delimiter);
        if (tokens.hasNext()) {
            try {
                appendOneToken(appendable, tokens.next());
                while (tokens.hasNext()) {
                    appendable.append(delimiter);
                    appendOneToken(appendable, tokens.next());
                }
            } catch (IOException e) {
                throw new JoinException(null);
            }
        }
        return appendable;
    }

    public static <T extends Appendable> T join(T appendable, String keyValueSeparator, String entryDelimiter, Map<?, ?> map) {
        try {
            return Joiner.on(entryDelimiter).useForNull(Constants.NULL_VERSION_ID).withKeyValueSeparator(keyValueSeparator).appendTo((Appendable) appendable, (Map) map);
        } catch (IOException e) {
            throw new JoinException(null);
        }
    }

    private static void appendOneToken(Appendable appendable, Object token) throws IOException {
        appendable.append(toCharSequence(token));
    }

    private static CharSequence toCharSequence(Object token) {
        return token instanceof CharSequence ? (CharSequence) token : String.valueOf(token);
    }

    private static Iterable<Object> iterable(Object first, Object[] rest) {
        Preconditions.checkNotNull(rest);
        return new C07611(rest, first);
    }
}
