package com.google.gdata.util.parser;

public class Sequence<T> extends Parser<T> {
    private Parser<? super T> left;
    private Parser<? super T> right;

    public Sequence(Parser<? super T> left, Parser<? super T> right) {
        this.left = left;
        this.right = right;
    }

    public int parse(char[] buf, int start, int end, T data) {
        int left_hit = this.left.parse(buf, start, end, data);
        if (left_hit == -1) {
            return -1;
        }
        int right_hit = this.right.parse(buf, start + left_hit, end, data);
        if (right_hit != -1) {
            return left_hit + right_hit;
        }
        return -1;
    }
}
