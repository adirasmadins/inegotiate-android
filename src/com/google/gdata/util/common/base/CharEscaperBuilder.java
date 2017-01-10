package com.google.gdata.util.common.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CharEscaperBuilder {
    private final Map<Character, String> map;
    private int max;

    private static class CharArrayDecorator extends CharEscaper {
        private final int replaceLength;
        private final char[][] replacements;

        public CharArrayDecorator(char[][] replacements) {
            this.replacements = replacements;
            this.replaceLength = replacements.length;
        }

        public String escape(String s) {
            int slen = s.length();
            for (int index = 0; index < slen; index++) {
                char c = s.charAt(index);
                if (c < this.replacements.length && this.replacements[c] != null) {
                    return escapeSlow(s, index);
                }
            }
            return s;
        }

        protected char[] escape(char c) {
            return c < this.replaceLength ? this.replacements[c] : null;
        }
    }

    public CharEscaperBuilder() {
        this.max = -1;
        this.map = new HashMap();
    }

    public CharEscaperBuilder addEscape(char c, String r) {
        this.map.put(Character.valueOf(c), r);
        if (c > this.max) {
            this.max = c;
        }
        return this;
    }

    public CharEscaperBuilder addEscapes(char[] cs, String r) {
        for (char c : cs) {
            addEscape(c, r);
        }
        return this;
    }

    public char[][] toArray() {
        char[][] result = new char[(this.max + 1)][];
        for (Entry<Character, String> entry : this.map.entrySet()) {
            result[((Character) entry.getKey()).charValue()] = ((String) entry.getValue()).toCharArray();
        }
        return result;
    }

    public CharEscaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }
}
