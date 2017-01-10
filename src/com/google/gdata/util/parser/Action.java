package com.google.gdata.util.parser;

public class Action<T, U extends T> extends Parser<U> {
    private Callback<U> callback;
    private Parser<T> subject;

    public Action(Parser<T> subject, Callback<U> callback) {
        this.subject = subject;
        this.callback = callback;
    }

    public int parse(char[] buf, int start, int end, U data) {
        int hit = this.subject.parse(buf, start, end, data);
        if (hit != -1) {
            this.callback.handle(buf, start, start + hit, data);
        }
        return hit;
    }
}
