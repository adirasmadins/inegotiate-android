package com.google.gdata.util.common.base;

import com.amazonaws.services.s3.model.ProgressEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public abstract class CharMatcher implements Predicate<Character> {
    public static final CharMatcher ANY;
    public static final CharMatcher ASCII;
    public static final CharMatcher DIGIT;
    public static final CharMatcher INVISIBLE;
    public static final CharMatcher JAVA_DIGIT;
    public static final CharMatcher JAVA_ISO_CONTROL;
    public static final CharMatcher JAVA_LETTER;
    public static final CharMatcher JAVA_LETTER_OR_DIGIT;
    public static final CharMatcher JAVA_LOWER_CASE;
    public static final CharMatcher JAVA_UPPER_CASE;
    public static final CharMatcher JAVA_WHITESPACE;
    public static final CharMatcher LEGACY_WHITESPACE;
    public static final CharMatcher NONE;
    public static final CharMatcher WHITESPACE;
    private static final String ZEROES = "0\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10";

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.11 */
    static class AnonymousClass11 extends CharMatcher {
        final /* synthetic */ char val$match;

        public boolean matches(char c) {
            return c == this.val$match;
        }

        public String replaceFrom(CharSequence sequence, char replacement) {
            return sequence.toString().replace(this.val$match, replacement);
        }

        public CharMatcher and(CharMatcher other) {
            return other.matches(this.val$match) ? this : NONE;
        }

        public CharMatcher or(CharMatcher other) {
            return other.matches(this.val$match) ? other : super.or(other);
        }

        public CharMatcher negate() {
            return CharMatcher.isNot(this.val$match);
        }

        AnonymousClass11(char c) {
            this.val$match = c;
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        protected void setBits(LookupTable table) {
            table.set(this.val$match);
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.12 */
    static class AnonymousClass12 extends CharMatcher {
        final /* synthetic */ char val$match;

        public boolean matches(char c) {
            return c != this.val$match;
        }

        public CharMatcher and(CharMatcher other) {
            return other.matches(this.val$match) ? super.and(other) : other;
        }

        public CharMatcher or(CharMatcher other) {
            return other.matches(this.val$match) ? ANY : this;
        }

        AnonymousClass12(char c) {
            this.val$match = c;
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        public CharMatcher negate() {
            return CharMatcher.is(this.val$match);
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.13 */
    static class AnonymousClass13 extends CharMatcher {
        final /* synthetic */ char val$match1;
        final /* synthetic */ char val$match2;

        public boolean matches(char c) {
            return c == this.val$match1 || c == this.val$match2;
        }

        AnonymousClass13(char c, char c2) {
            this.val$match1 = c;
            this.val$match2 = c2;
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        protected void setBits(LookupTable table) {
            table.set(this.val$match1);
            table.set(this.val$match2);
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.14 */
    static class AnonymousClass14 extends CharMatcher {
        final /* synthetic */ char[] val$chars;

        public boolean matches(char c) {
            return Arrays.binarySearch(this.val$chars, c) >= 0;
        }

        AnonymousClass14(char[] cArr) {
            this.val$chars = cArr;
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        protected void setBits(LookupTable table) {
            for (char c : this.val$chars) {
                table.set(c);
            }
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.15 */
    static class AnonymousClass15 extends CharMatcher {
        final /* synthetic */ char val$endInclusive;
        final /* synthetic */ char val$startInclusive;

        public boolean matches(char c) {
            return this.val$startInclusive <= c && c <= this.val$endInclusive;
        }

        AnonymousClass15(char c, char c2) {
            this.val$startInclusive = c;
            this.val$endInclusive = c2;
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        protected void setBits(LookupTable table) {
            char c = this.val$startInclusive;
            while (true) {
                table.set(c);
                char c2 = (char) (c + 1);
                if (c != this.val$endInclusive) {
                    c = c2;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.16 */
    static class AnonymousClass16 extends CharMatcher {
        final /* synthetic */ Predicate val$predicate;

        public boolean matches(char c) {
            return this.val$predicate.apply(Character.valueOf(c));
        }

        AnonymousClass16(Predicate predicate) {
            this.val$predicate = predicate;
        }

        public boolean apply(Character character) {
            return this.val$predicate.apply(Preconditions.checkNotNull(character));
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.18 */
    class AnonymousClass18 extends CharMatcher {
        final /* synthetic */ LookupTable val$table;

        public boolean matches(char c) {
            return this.val$table.get(c);
        }

        AnonymousClass18(LookupTable lookupTable) {
            this.val$table = lookupTable;
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        public CharMatcher precomputed() {
            return this;
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.1 */
    static class C07521 extends CharMatcher {
        public boolean matches(char c) {
            return true;
        }

        public int indexIn(CharSequence sequence) {
            return sequence.length() == 0 ? -1 : 0;
        }

        public int indexIn(CharSequence sequence, int start) {
            int length = sequence.length();
            Preconditions.checkPositionIndex(start, length);
            return start == length ? -1 : start;
        }

        public int lastIndexIn(CharSequence sequence) {
            return sequence.length() - 1;
        }

        public boolean matchesAllOf(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return true;
        }

        public boolean matchesNoneOf(CharSequence sequence) {
            return sequence.length() == 0;
        }

        public String removeFrom(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return StringUtil.EMPTY_STRING;
        }

        public String replaceFrom(CharSequence sequence, char replacement) {
            char[] array = new char[sequence.length()];
            Arrays.fill(array, replacement);
            return new String(array);
        }

        public String replaceFrom(CharSequence sequence, CharSequence replacement) {
            StringBuilder retval = new StringBuilder(sequence.length() * replacement.length());
            for (int i = 0; i < sequence.length(); i++) {
                retval.append(replacement);
            }
            return retval.toString();
        }

        public String collapseFrom(CharSequence sequence, char replacement) {
            return sequence.length() == 0 ? StringUtil.EMPTY_STRING : String.valueOf(replacement);
        }

        public String trimFrom(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return StringUtil.EMPTY_STRING;
        }

        public int countIn(CharSequence sequence) {
            return sequence.length();
        }

        public CharMatcher and(CharMatcher other) {
            return (CharMatcher) Preconditions.checkNotNull(other);
        }

        public CharMatcher or(CharMatcher other) {
            Preconditions.checkNotNull(other);
            return this;
        }

        C07521() {
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        public CharMatcher negate() {
            return NONE;
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.2 */
    static class C07532 extends CharMatcher {
        public boolean matches(char c) {
            return false;
        }

        public int indexIn(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return -1;
        }

        public int indexIn(CharSequence sequence, int start) {
            Preconditions.checkPositionIndex(start, sequence.length());
            return -1;
        }

        public int lastIndexIn(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return -1;
        }

        public boolean matchesAllOf(CharSequence sequence) {
            return sequence.length() == 0;
        }

        public boolean matchesNoneOf(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return true;
        }

        public String removeFrom(CharSequence sequence) {
            return sequence.toString();
        }

        public String replaceFrom(CharSequence sequence, char replacement) {
            return sequence.toString();
        }

        public String replaceFrom(CharSequence sequence, CharSequence replacement) {
            Preconditions.checkNotNull(replacement);
            return sequence.toString();
        }

        public String collapseFrom(CharSequence sequence, char replacement) {
            return sequence.toString();
        }

        public String trimFrom(CharSequence sequence) {
            return sequence.toString();
        }

        public int countIn(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return 0;
        }

        public CharMatcher and(CharMatcher other) {
            Preconditions.checkNotNull(other);
            return this;
        }

        public CharMatcher or(CharMatcher other) {
            return (CharMatcher) Preconditions.checkNotNull(other);
        }

        public CharMatcher negate() {
            return ANY;
        }

        C07532() {
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        protected void setBits(LookupTable table) {
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.3 */
    static class C07543 extends CharMatcher {
        protected void setBits(LookupTable table) {
            for (char base : CharMatcher.ZEROES.toCharArray()) {
                for (char value = '\u0000'; value < '\n'; value = (char) (value + 1)) {
                    table.set((char) (base + value));
                }
            }
        }

        C07543() {
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        public boolean matches(char c) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.4 */
    static class C07554 extends CharMatcher {
        C07554() {
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        public boolean matches(char c) {
            return Character.isWhitespace(c);
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.5 */
    static class C07565 extends CharMatcher {
        C07565() {
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        public boolean matches(char c) {
            return Character.isDigit(c);
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.6 */
    static class C07576 extends CharMatcher {
        C07576() {
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        public boolean matches(char c) {
            return Character.isLetter(c);
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.7 */
    static class C07587 extends CharMatcher {
        C07587() {
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        public boolean matches(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.8 */
    static class C07598 extends CharMatcher {
        C07598() {
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        public boolean matches(char c) {
            return Character.isUpperCase(c);
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharMatcher.9 */
    static class C07609 extends CharMatcher {
        C07609() {
        }

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        public boolean matches(char c) {
            return Character.isLowerCase(c);
        }
    }

    private static class And extends CharMatcher {
        List<CharMatcher> components;

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        And(List<CharMatcher> components) {
            this.components = components;
        }

        public boolean matches(char c) {
            for (CharMatcher matcher : this.components) {
                if (!matcher.matches(c)) {
                    return false;
                }
            }
            return true;
        }

        public CharMatcher and(CharMatcher other) {
            List<CharMatcher> newComponents = new ArrayList(this.components);
            newComponents.add(Preconditions.checkNotNull(other));
            return new And(newComponents);
        }
    }

    protected static class LookupTable {
        long[] data;

        protected LookupTable() {
            this.data = new long[ProgressEvent.PART_STARTED_EVENT_CODE];
        }

        void set(char index) {
            long[] jArr = this.data;
            int i = index >> 6;
            jArr[i] = jArr[i] | (1 << index);
        }

        boolean get(char index) {
            return (this.data[index >> 6] & (1 << index)) != 0;
        }
    }

    private static class Or extends CharMatcher {
        List<CharMatcher> components;

        public /* bridge */ /* synthetic */ boolean apply(Object x0) {
            return super.apply((Character) x0);
        }

        Or(List<CharMatcher> components) {
            this.components = components;
        }

        public boolean matches(char c) {
            for (CharMatcher matcher : this.components) {
                if (matcher.matches(c)) {
                    return true;
                }
            }
            return false;
        }

        public CharMatcher or(CharMatcher other) {
            List<CharMatcher> newComponents = new ArrayList(this.components);
            newComponents.add(Preconditions.checkNotNull(other));
            return new Or(newComponents);
        }

        protected void setBits(LookupTable table) {
            for (CharMatcher matcher : this.components) {
                matcher.setBits(table);
            }
        }
    }

    public abstract boolean matches(char c);

    static {
        ANY = new C07521();
        NONE = new C07532();
        ASCII = inRange('\u0000', '\u007f');
        WHITESPACE = anyOf("\t\n\u000b\f\r \u0085\u00a0\u1680\u180e\u2028\u2029\u202f\u205f\u3000").or(inRange('\u2000', '\u200a')).precomputed();
        DIGIT = new C07543().precomputed();
        LEGACY_WHITESPACE = anyOf(StringUtil.WHITE_SPACES);
        JAVA_WHITESPACE = new C07554();
        JAVA_DIGIT = new C07565();
        JAVA_LETTER = new C07576();
        JAVA_LETTER_OR_DIGIT = new C07587();
        JAVA_UPPER_CASE = new C07598();
        JAVA_LOWER_CASE = new C07609();
        JAVA_ISO_CONTROL = new CharMatcher() {
            public /* bridge */ /* synthetic */ boolean apply(Object x0) {
                return super.apply((Character) x0);
            }

            public boolean matches(char c) {
                return Character.isISOControl(c);
            }
        };
        INVISIBLE = inRange('\u0000', ' ').or(inRange('\u007f', '\u00a0')).or(is('\u00ad')).or(inRange('\u0600', '\u0603')).or(anyOf("\u06dd\u070f\u1680\u17b4\u17b5\u180e")).or(inRange('\u2000', '\u200f')).or(inRange('\u2028', '\u202f')).or(inRange('\u205f', '\u2064')).or(inRange('\u206a', '\u206f')).or(is('\u3000')).or(inRange('\ud800', '\uf8ff')).or(anyOf("\ufeff\ufff9\ufffa\ufffb")).precomputed();
    }

    public static CharMatcher is(char match) {
        return new AnonymousClass11(match);
    }

    public static CharMatcher isNot(char match) {
        return new AnonymousClass12(match);
    }

    public static CharMatcher anyOf(CharSequence sequence) {
        switch (sequence.length()) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return NONE;
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return is(sequence.charAt(0));
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new AnonymousClass13(sequence.charAt(0), sequence.charAt(1));
            default:
                char[] chars = sequence.toString().toCharArray();
                Arrays.sort(chars);
                return new AnonymousClass14(chars);
        }
    }

    public static CharMatcher noneOf(CharSequence sequence) {
        return anyOf(sequence).negate();
    }

    public static CharMatcher inRange(char startInclusive, char endInclusive) {
        Preconditions.checkArgument(endInclusive >= startInclusive);
        return new AnonymousClass15(startInclusive, endInclusive);
    }

    public static CharMatcher forPredicate(Predicate<? super Character> predicate) {
        Preconditions.checkNotNull(predicate);
        if (predicate instanceof CharMatcher) {
            return (CharMatcher) predicate;
        }
        return new AnonymousClass16(predicate);
    }

    public CharMatcher negate() {
        return new CharMatcher() {
            final /* synthetic */ CharMatcher val$original;

            public boolean matches(char c) {
                return !this.val$original.matches(c);
            }

            public boolean matchesAllOf(CharSequence sequence) {
                return this.val$original.matchesNoneOf(sequence);
            }

            public boolean matchesNoneOf(CharSequence sequence) {
                return this.val$original.matchesAllOf(sequence);
            }

            public int countIn(CharSequence sequence) {
                return sequence.length() - this.val$original.countIn(sequence);
            }

            {
                this.val$original = r2;
            }

            public /* bridge */ /* synthetic */ boolean apply(Object x0) {
                return super.apply((Character) x0);
            }

            public CharMatcher negate() {
                return this.val$original;
            }
        };
    }

    public CharMatcher and(CharMatcher other) {
        return new And(Arrays.asList(new CharMatcher[]{this, (CharMatcher) Preconditions.checkNotNull(other)}));
    }

    public CharMatcher or(CharMatcher other) {
        return new Or(Arrays.asList(new CharMatcher[]{this, (CharMatcher) Preconditions.checkNotNull(other)}));
    }

    public CharMatcher precomputed() {
        LookupTable table = new LookupTable();
        setBits(table);
        return new AnonymousClass18(table);
    }

    protected void setBits(LookupTable table) {
        char c = '\u0000';
        while (true) {
            if (matches(c)) {
                table.set(c);
            }
            char c2 = (char) (c + 1);
            if (c != '\uffff') {
                c = c2;
            } else {
                return;
            }
        }
    }

    public boolean matchesAllOf(CharSequence sequence) {
        for (int i = sequence.length() - 1; i >= 0; i--) {
            if (!matches(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesNoneOf(CharSequence sequence) {
        return indexIn(sequence) == -1;
    }

    public int indexIn(CharSequence sequence) {
        int length = sequence.length();
        for (int i = 0; i < length; i++) {
            if (matches(sequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public int indexIn(CharSequence sequence, int start) {
        int length = sequence.length();
        Preconditions.checkPositionIndex(start, length);
        for (int i = start; i < length; i++) {
            if (matches(sequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexIn(CharSequence sequence) {
        for (int i = sequence.length() - 1; i >= 0; i--) {
            if (matches(sequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public int countIn(CharSequence sequence) {
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (matches(sequence.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public String removeFrom(CharSequence sequence) {
        String string = sequence.toString();
        int pos = indexIn(string);
        if (pos == -1) {
            return string;
        }
        char[] chars = string.toCharArray();
        int spread = 1;
        while (true) {
            pos++;
            while (pos != chars.length) {
                if (matches(chars[pos])) {
                    spread++;
                } else {
                    chars[pos - spread] = chars[pos];
                    pos++;
                }
            }
            return new String(chars, 0, pos - spread);
        }
    }

    public String retainFrom(CharSequence sequence) {
        return negate().removeFrom(sequence);
    }

    public String replaceFrom(CharSequence sequence, char replacement) {
        String string = sequence.toString();
        int pos = indexIn(string);
        if (pos == -1) {
            return string;
        }
        char[] chars = string.toCharArray();
        chars[pos] = replacement;
        for (int i = pos + 1; i < chars.length; i++) {
            if (matches(chars[i])) {
                chars[i] = replacement;
            }
        }
        return new String(chars);
    }

    public String replaceFrom(CharSequence sequence, CharSequence replacement) {
        int replacementLen = replacement.length();
        if (replacementLen == 0) {
            return removeFrom(sequence);
        }
        if (replacementLen == 1) {
            return replaceFrom(sequence, replacement.charAt(0));
        }
        String string = sequence.toString();
        int pos = indexIn(string);
        if (pos == -1) {
            return string;
        }
        int len = string.length();
        StringBuilder buf = new StringBuilder(((int) (((double) len) * 1.5d)) + 16);
        int oldpos = 0;
        do {
            buf.append(string, oldpos, pos);
            buf.append(replacement);
            oldpos = pos + 1;
            pos = indexIn(string, oldpos);
        } while (pos != -1);
        buf.append(string, oldpos, len);
        return buf.toString();
    }

    public String trimFrom(CharSequence sequence) {
        int len = sequence.length();
        int first = 0;
        while (first < len && matches(sequence.charAt(first))) {
            first++;
        }
        int last = len - 1;
        while (last > first && matches(sequence.charAt(last))) {
            last--;
        }
        return sequence.subSequence(first, last + 1).toString();
    }

    public String trimLeadingFrom(CharSequence sequence) {
        int len = sequence.length();
        int first = 0;
        while (first < len && matches(sequence.charAt(first))) {
            first++;
        }
        return sequence.subSequence(first, len).toString();
    }

    public String trimTrailingFrom(CharSequence sequence) {
        int last = sequence.length() - 1;
        while (last >= 0 && matches(sequence.charAt(last))) {
            last--;
        }
        return sequence.subSequence(0, last + 1).toString();
    }

    public String collapseFrom(CharSequence sequence, char replacement) {
        int first = indexIn(sequence);
        if (first == -1) {
            return sequence.toString();
        }
        StringBuilder builder = new StringBuilder(sequence.length()).append(sequence.subSequence(0, first)).append(replacement);
        boolean in = true;
        for (int i = first + 1; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (!apply(Character.valueOf(c))) {
                builder.append(c);
                in = false;
            } else if (!in) {
                builder.append(replacement);
                in = true;
            }
        }
        return builder.toString();
    }

    public String trimAndCollapseFrom(CharSequence sequence, char replacement) {
        int first = negate().indexIn(sequence);
        if (first == -1) {
            return StringUtil.EMPTY_STRING;
        }
        StringBuilder builder = new StringBuilder(sequence.length());
        boolean inMatchingGroup = false;
        for (int i = first; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (apply(Character.valueOf(c))) {
                inMatchingGroup = true;
            } else {
                if (inMatchingGroup) {
                    builder.append(replacement);
                    inMatchingGroup = false;
                }
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public boolean apply(Character character) {
        return matches(character.charValue());
    }
}
