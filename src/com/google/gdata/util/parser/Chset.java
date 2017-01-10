package com.google.gdata.util.parser;

import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class Chset extends Parser<Object> implements Cloneable {
    public static final Chset ALNUM;
    public static final Chset ALPHA;
    public static final Chset ANYCHAR;
    public static final Chset ASCII;
    public static final Chset DIGIT;
    public static final Chset LOWER;
    private static final char MAX_ASCII_CHAR = '\u007f';
    protected static final char MAX_CHAR = '\uffff';
    protected static final char MIN_CHAR = '\u0000';
    public static final Chset NOTHING;
    public static final Chset UPPER;
    public static final Chset WHITESPACE;
    public static final Chset XDIGIT;
    private BitSet asciiSet;
    private ArrayList<Range> ranges;

    static class Range {
        int first;
        int last;

        Range(int first, int last) {
            if (first > last) {
                throw new IllegalArgumentException("descending ranges not supported: " + first + "-" + last);
            }
            this.first = first;
            this.last = last;
        }

        boolean includes(int ch) {
            return this.first <= ch && ch <= this.last;
        }

        boolean includes(Range r) {
            return this.first <= r.first && r.last <= this.last;
        }

        boolean mergeable(Range r) {
            return (Math.max(this.last, r.last) + 1) - Math.min(this.first, r.first) <= ((r.last + 1) - r.first) + ((this.last + 1) - this.first);
        }

        void merge(Range r) {
            this.first = Math.min(this.first, r.first);
            this.last = Math.max(this.last, r.last);
        }
    }

    static {
        ANYCHAR = new Chset('\u0000', MAX_CHAR);
        NOTHING = new Chset();
        ALNUM = new Chset("a-zA-Z0-9");
        ALPHA = new Chset("a-zA-Z");
        DIGIT = new Chset("0-9");
        XDIGIT = new Chset("0-9a-fA-F");
        LOWER = new Chset("a-z");
        UPPER = new Chset("A-Z");
        WHITESPACE = new Chset(" \t\r\n\f");
        ASCII = new Chset('\u0000', MAX_ASCII_CHAR);
    }

    public Chset() {
        this.ranges = new ArrayList();
        this.asciiSet = new BitSet(XMLChar.MASK_NCNAME);
    }

    public Chset(char ch) {
        this(ch, ch);
    }

    public Chset(char min, char max) {
        this.ranges = new ArrayList();
        this.asciiSet = new BitSet(XMLChar.MASK_NCNAME);
        this.ranges.add(new Range(min, max));
        refreshAsciiSet();
    }

    public Chset(String spec) {
        this.ranges = new ArrayList();
        this.asciiSet = new BitSet(XMLChar.MASK_NCNAME);
        int i = 0;
        while (i < spec.length()) {
            char s = spec.charAt(i);
            if (i + 1 >= spec.length() || spec.charAt(i + 1) != '-') {
                set(new Range(s, s));
                i++;
            } else if (i + 2 < spec.length()) {
                set(new Range(s, spec.charAt(i + 2)));
                i += 3;
            } else {
                set(new Range(s, s));
                set(new Range(45, 45));
                return;
            }
        }
    }

    public Object clone() {
        Chset n = new Chset();
        Iterator i$ = this.ranges.iterator();
        while (i$.hasNext()) {
            Range r = (Range) i$.next();
            n.ranges.add(new Range(r.first, r.last));
        }
        n.refreshAsciiSet();
        return n;
    }

    public int parse(char[] buf, int start, int end, Object data) {
        if (start >= end || !test(buf[start])) {
            return -1;
        }
        return 1;
    }

    public boolean test(char ch) {
        if (ch <= MAX_ASCII_CHAR) {
            return this.asciiSet.get(ch);
        }
        return testRanges(ch);
    }

    protected boolean testRanges(char ch) {
        int range_size = this.ranges.size();
        if (range_size == 0) {
            return false;
        }
        if (range_size == 1) {
            return ((Range) this.ranges.get(0)).includes((int) ch);
        }
        int pos = find(ch);
        if (pos != range_size && ((Range) this.ranges.get(pos)).includes((int) ch)) {
            return true;
        }
        if (pos == 0 || !((Range) this.ranges.get(pos - 1)).includes((int) ch)) {
            return false;
        }
        return true;
    }

    protected void set(char min, char max) {
        set(new Range(min, max));
    }

    private void set(Range r) {
        if (this.ranges.isEmpty()) {
            this.ranges.add(r);
            refreshAsciiSet();
            return;
        }
        int pos = find(r.first);
        if (pos != this.ranges.size() && ((Range) this.ranges.get(pos)).includes(r)) {
            return;
        }
        if (pos == 0 || !((Range) this.ranges.get(pos - 1)).includes(r)) {
            if (pos != 0 && ((Range) this.ranges.get(pos - 1)).mergeable(r)) {
                merge(pos - 1, r);
            } else if (pos == this.ranges.size() || !((Range) this.ranges.get(pos)).mergeable(r)) {
                this.ranges.add(pos, r);
            } else {
                merge(pos, r);
            }
            refreshAsciiSet();
        }
    }

    protected void clear(char min, char max) {
        clear(new Range(min, max));
    }

    private void clear(Range r) {
        if (!this.ranges.isEmpty()) {
            int pos = find(r.first);
            if (pos > 0) {
                Range prev = (Range) this.ranges.get(pos - 1);
                if (prev.includes(r.first)) {
                    if (prev.last > r.last) {
                        Range n = new Range(r.last + 1, prev.last);
                        prev.last = r.first - 1;
                        this.ranges.add(pos, n);
                        refreshAsciiSet();
                        return;
                    }
                    prev.last = r.first - 1;
                }
            }
            while (pos < this.ranges.size() && r.includes((Range) this.ranges.get(pos))) {
                this.ranges.remove(pos);
            }
            if (pos < this.ranges.size() && ((Range) this.ranges.get(pos)).includes(r.last)) {
                ((Range) this.ranges.get(pos)).first = r.last + 1;
            }
            refreshAsciiSet();
        }
    }

    private void refreshAsciiSet() {
        this.asciiSet.clear();
        for (char ch = '\u0000'; ch <= MAX_ASCII_CHAR; ch = (char) (ch + 1)) {
            if (testRanges(ch)) {
                this.asciiSet.set(ch);
            }
        }
    }

    protected int size() {
        return this.ranges.size();
    }

    private int find(int first) {
        int s = 0;
        int e = this.ranges.size() - 1;
        while (s <= e) {
            int i = (s + e) / 2;
            Range r = (Range) this.ranges.get(i);
            if (r.first < first) {
                s = i + 1;
            } else if (r.first <= first) {
                return i;
            } else {
                e = i - 1;
            }
        }
        return s;
    }

    private void merge(int pos, Range r) {
        Range t = (Range) this.ranges.get(pos);
        t.merge(r);
        pos++;
        while (pos < this.ranges.size() && t.mergeable((Range) this.ranges.get(pos))) {
            t.merge((Range) this.ranges.get(pos));
            this.ranges.remove(pos);
        }
    }

    public static Chset not(Chset subject) {
        return difference(ANYCHAR, subject);
    }

    public static Chset union(Chset left, Chset right) {
        Chset n = (Chset) left.clone();
        Iterator i$ = right.ranges.iterator();
        while (i$.hasNext()) {
            n.set((Range) i$.next());
        }
        return n;
    }

    public static Chset difference(Chset left, Chset right) {
        Chset n = (Chset) left.clone();
        Iterator i$ = right.ranges.iterator();
        while (i$.hasNext()) {
            n.clear((Range) i$.next());
        }
        return n;
    }

    public static Chset intersection(Chset left, Chset right) {
        return difference(left, not(right));
    }

    public static Chset xor(Chset left, Chset right) {
        return union(difference(left, right), difference(right, left));
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < this.ranges.size(); i++) {
            Range r = (Range) this.ranges.get(i);
            if (i > 0) {
                buf.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            buf.append(r.first);
            buf.append("-");
            buf.append(r.last);
        }
        return buf.toString();
    }
}
