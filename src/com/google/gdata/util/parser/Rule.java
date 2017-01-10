package com.google.gdata.util.parser;

public class Rule<T> extends Parser<T> {
    private Parser<T> subject;

    public Rule() {
        this(null);
    }

    public Rule(Parser<T> subject) {
        this.subject = subject;
    }

    public int parse(char[] buf, int start, int end, T data) {
        if (this.subject != null) {
            return this.subject.parse(buf, start, end, data);
        }
        return -1;
    }

    public void set(Parser<T> subject) {
        this.subject = subject;
    }
}
