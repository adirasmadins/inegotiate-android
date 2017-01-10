package com.google.gdata.util.parser;

public class Alternative<T> extends Parser<T> {
    private Parser<? super T> left;
    private Parser<? super T> right;

    public Alternative(Parser<? super T> left, Parser<? super T> right) {
        this.left = left;
        this.right = right;
    }

    public int parse(char[] buf, int start, int end, T data) {
        int hit = this.left.parse(buf, start, end, data);
        return hit != -1 ? hit : this.right.parse(buf, start, end, data);
    }
}
