package com.google.gdata.util.parser;

public class Strcaselit extends Parser<Object> {
    private String str;

    public Strcaselit(String str) {
        this.str = str;
    }

    public int parse(char[] buf, int start, int end, Object data) {
        int i = 0;
        while (i < this.str.length()) {
            if (start >= end || Character.toLowerCase(buf[start]) != Character.toLowerCase(this.str.charAt(i))) {
                return -1;
            }
            start++;
            i++;
        }
        return this.str.length();
    }
}
