package com.google.gdata.util.parser;

public class Difference<T> extends Parser<T> {
    private Parser<? super T> left;
    private Parser<? super T> right;

    public Difference(Parser<? super T> left, Parser<? super T> right) {
        this.left = left;
        this.right = right;
    }

    public int parse(char[] buf, int start, int end, T data) {
        int left_hit = this.left.parse(buf, start, end, data);
        return (left_hit == -1 || this.right.parse(buf, start, end, data) != -1) ? -1 : left_hit;
    }
}
