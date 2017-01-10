package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.gdata.util.common.base.StringUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated = true)
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final CharMatcher trimmer;

    private static abstract class SplittingIterator extends AbstractIterator<String> {
        int limit;
        int offset;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;

        abstract int separatorEnd(int i);

        abstract int separatorStart(int i);

        protected SplittingIterator(Splitter splitter, CharSequence toSplit) {
            this.offset = 0;
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = toSplit;
        }

        protected String computeNext() {
            while (this.offset != -1) {
                int end;
                int start = this.offset;
                int separatorPosition = separatorStart(this.offset);
                if (separatorPosition == -1) {
                    end = this.toSplit.length();
                    this.offset = -1;
                } else {
                    end = separatorPosition;
                    this.offset = separatorEnd(separatorPosition);
                }
                while (start < end && this.trimmer.matches(this.toSplit.charAt(start))) {
                    start++;
                }
                while (end > start && this.trimmer.matches(this.toSplit.charAt(end - 1))) {
                    end--;
                }
                if (this.omitEmptyStrings) {
                    if (start != end) {
                    }
                }
                if (this.limit == 1) {
                    end = this.toSplit.length();
                    this.offset = -1;
                    while (end > start && this.trimmer.matches(this.toSplit.charAt(end - 1))) {
                        end--;
                    }
                } else {
                    this.limit--;
                }
                return this.toSplit.subSequence(start, end).toString();
            }
            return (String) endOfData();
        }
    }

    private interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }

    /* renamed from: com.google.common.base.Splitter.1 */
    static class C03591 implements Strategy {
        final /* synthetic */ CharMatcher val$separatorMatcher;

        /* renamed from: com.google.common.base.Splitter.1.1 */
        class C03581 extends SplittingIterator {
            C03581(Splitter x0, CharSequence x1) {
                super(x0, x1);
            }

            int separatorStart(int start) {
                return C03591.this.val$separatorMatcher.indexIn(this.toSplit, start);
            }

            int separatorEnd(int separatorPosition) {
                return separatorPosition + 1;
            }
        }

        C03591(CharMatcher charMatcher) {
            this.val$separatorMatcher = charMatcher;
        }

        public SplittingIterator iterator(Splitter splitter, CharSequence toSplit) {
            return new C03581(splitter, toSplit);
        }
    }

    /* renamed from: com.google.common.base.Splitter.2 */
    static class C03612 implements Strategy {
        final /* synthetic */ String val$separator;

        /* renamed from: com.google.common.base.Splitter.2.1 */
        class C03601 extends SplittingIterator {
            C03601(Splitter x0, CharSequence x1) {
                super(x0, x1);
            }

            public int separatorStart(int start) {
                int delimeterLength = C03612.this.val$separator.length();
                int p = start;
                int last = this.toSplit.length() - delimeterLength;
                while (p <= last) {
                    int i = 0;
                    while (i < delimeterLength) {
                        if (this.toSplit.charAt(i + p) != C03612.this.val$separator.charAt(i)) {
                            p++;
                        } else {
                            i++;
                        }
                    }
                    return p;
                }
                return -1;
            }

            public int separatorEnd(int separatorPosition) {
                return C03612.this.val$separator.length() + separatorPosition;
            }
        }

        C03612(String str) {
            this.val$separator = str;
        }

        public SplittingIterator iterator(Splitter splitter, CharSequence toSplit) {
            return new C03601(splitter, toSplit);
        }
    }

    /* renamed from: com.google.common.base.Splitter.3 */
    static class C03633 implements Strategy {
        final /* synthetic */ Pattern val$separatorPattern;

        /* renamed from: com.google.common.base.Splitter.3.1 */
        class C03621 extends SplittingIterator {
            final /* synthetic */ Matcher val$matcher;

            C03621(Splitter x0, CharSequence x1, Matcher matcher) {
                this.val$matcher = matcher;
                super(x0, x1);
            }

            public int separatorStart(int start) {
                return this.val$matcher.find(start) ? this.val$matcher.start() : -1;
            }

            public int separatorEnd(int separatorPosition) {
                return this.val$matcher.end();
            }
        }

        C03633(Pattern pattern) {
            this.val$separatorPattern = pattern;
        }

        public SplittingIterator iterator(Splitter splitter, CharSequence toSplit) {
            return new C03621(splitter, toSplit, this.val$separatorPattern.matcher(toSplit));
        }
    }

    /* renamed from: com.google.common.base.Splitter.4 */
    static class C03654 implements Strategy {
        final /* synthetic */ int val$length;

        /* renamed from: com.google.common.base.Splitter.4.1 */
        class C03641 extends SplittingIterator {
            C03641(Splitter x0, CharSequence x1) {
                super(x0, x1);
            }

            public int separatorStart(int start) {
                int nextChunkStart = start + C03654.this.val$length;
                return nextChunkStart < this.toSplit.length() ? nextChunkStart : -1;
            }

            public int separatorEnd(int separatorPosition) {
                return separatorPosition;
            }
        }

        C03654(int i) {
            this.val$length = i;
        }

        public SplittingIterator iterator(Splitter splitter, CharSequence toSplit) {
            return new C03641(splitter, toSplit);
        }
    }

    /* renamed from: com.google.common.base.Splitter.5 */
    class C03665 implements Iterable<String> {
        final /* synthetic */ CharSequence val$sequence;

        C03665(CharSequence charSequence) {
            this.val$sequence = charSequence;
        }

        public Iterator<String> iterator() {
            return Splitter.this.spliterator(this.val$sequence);
        }
    }

    @Beta
    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        private MapSplitter(Splitter outerSplitter, Splitter entrySplitter) {
            this.outerSplitter = outerSplitter;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(entrySplitter);
        }

        public Map<String, String> split(CharSequence sequence) {
            Map<String, String> map = new LinkedHashMap();
            for (String entry : this.outerSplitter.split(sequence)) {
                boolean z;
                Iterator<String> entryFields = this.entrySplitter.spliterator(entry);
                Preconditions.checkArgument(entryFields.hasNext(), INVALID_ENTRY_MESSAGE, entry);
                String key = (String) entryFields.next();
                if (map.containsKey(key)) {
                    z = false;
                } else {
                    z = true;
                }
                Preconditions.checkArgument(z, "Duplicate key [%s] found.", key);
                Preconditions.checkArgument(entryFields.hasNext(), INVALID_ENTRY_MESSAGE, entry);
                map.put(key, (String) entryFields.next());
                if (entryFields.hasNext()) {
                    z = false;
                } else {
                    z = true;
                }
                Preconditions.checkArgument(z, INVALID_ENTRY_MESSAGE, entry);
            }
            return Collections.unmodifiableMap(map);
        }
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.NONE, Integer.MAX_VALUE);
    }

    private Splitter(Strategy strategy, boolean omitEmptyStrings, CharMatcher trimmer, int limit) {
        this.strategy = strategy;
        this.omitEmptyStrings = omitEmptyStrings;
        this.trimmer = trimmer;
        this.limit = limit;
    }

    public static Splitter on(char separator) {
        return on(CharMatcher.is(separator));
    }

    public static Splitter on(CharMatcher separatorMatcher) {
        Preconditions.checkNotNull(separatorMatcher);
        return new Splitter(new C03591(separatorMatcher));
    }

    public static Splitter on(String separator) {
        Preconditions.checkArgument(separator.length() != 0, "The separator may not be the empty string.");
        return new Splitter(new C03612(separator));
    }

    @GwtIncompatible("java.util.regex")
    public static Splitter on(Pattern separatorPattern) {
        boolean z;
        Preconditions.checkNotNull(separatorPattern);
        if (separatorPattern.matcher(StringUtil.EMPTY_STRING).matches()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "The pattern may not match the empty string: %s", separatorPattern);
        return new Splitter(new C03633(separatorPattern));
    }

    @GwtIncompatible("java.util.regex")
    public static Splitter onPattern(String separatorPattern) {
        return on(Pattern.compile(separatorPattern));
    }

    public static Splitter fixedLength(int length) {
        Preconditions.checkArgument(length > 0, "The length may not be less than 1");
        return new Splitter(new C03654(length));
    }

    @CheckReturnValue
    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    @CheckReturnValue
    public Splitter limit(int limit) {
        boolean z;
        if (limit > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "must be greater than zero: %s", Integer.valueOf(limit));
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, limit);
    }

    @CheckReturnValue
    public Splitter trimResults() {
        return trimResults(CharMatcher.WHITESPACE);
    }

    @CheckReturnValue
    public Splitter trimResults(CharMatcher trimmer) {
        Preconditions.checkNotNull(trimmer);
        return new Splitter(this.strategy, this.omitEmptyStrings, trimmer, this.limit);
    }

    public Iterable<String> split(CharSequence sequence) {
        Preconditions.checkNotNull(sequence);
        return new C03665(sequence);
    }

    private Iterator<String> spliterator(CharSequence sequence) {
        return this.strategy.iterator(this, sequence);
    }

    @CheckReturnValue
    @Beta
    public MapSplitter withKeyValueSeparator(String separator) {
        return withKeyValueSeparator(on(separator));
    }

    @CheckReturnValue
    @Beta
    public MapSplitter withKeyValueSeparator(Splitter keyValueSplitter) {
        return new MapSplitter(keyValueSplitter, null);
    }
}
