package com.google.gdata.util.parser;

public class Strlit extends Parser<Object> {
    private String str;

    public Strlit(String str) {
        this.str = str;
    }

    public int parse(char[] buf, int start, int end, Object data) {
        int i = 0;
        while (i < this.str.length()) {
            if (start >= end || buf[start] != this.str.charAt(i)) {
                return -1;
            }
            start++;
            i++;
        }
        return this.str.length();
    }
}
