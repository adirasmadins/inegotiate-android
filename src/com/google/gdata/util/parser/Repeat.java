package com.google.gdata.util.parser;

public class Repeat<T> extends Parser<T> {
    private int max;
    private int min;
    private Parser<T> subject;

    public Repeat(Parser<T> subject, int min) {
        this(subject, min, -1);
    }

    public Repeat(Parser<T> subject, int min, int max) {
        this.subject = subject;
        this.min = min;
        this.max = max;
    }

    public int parse(char[] buf, int start, int end, T data) {
        int hit = 0;
        int i = 0;
        while (i != this.max) {
            int next = this.subject.parse(buf, start + hit, end, data);
            if (next == 0) {
                return hit;
            }
            if (next != -1) {
                hit += next;
                i++;
            } else if (i < this.min) {
                return -1;
            } else {
                return hit;
            }
        }
        return hit;
    }
}
