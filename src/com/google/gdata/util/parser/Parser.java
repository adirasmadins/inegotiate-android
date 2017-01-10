package com.google.gdata.util.parser;

import com.amazonaws.services.s3.model.ProgressEvent;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Reader;

public abstract class Parser<T> {
    public static final int NO_MATCH = -1;

    public abstract int parse(char[] cArr, int i, int i2, T t);

    public final int parse(char[] buf, T udata) {
        return parse(buf, 0, buf.length, udata);
    }

    public final int parse(String str, T udata) {
        return parse(str.toCharArray(), (Object) udata);
    }

    public final int parse(Reader reader, T udata) {
        CharArrayWriter writer = new CharArrayWriter();
        try {
            char[] buf = new char[ProgressEvent.PART_STARTED_EVENT_CODE];
            while (true) {
                int count = reader.read(buf);
                if (count < 0) {
                    break;
                }
                writer.write(buf, 0, count);
            }
        } catch (IOException e) {
        }
        return parse(writer.toCharArray(), (Object) udata);
    }

    public final Parser<T> repeat(int count) {
        return new Repeat(this, count, count);
    }

    public final Parser<T> repeat(int min, int max) {
        return new Repeat(this, min, max);
    }

    public final Parser<T> star() {
        return new Repeat(this, 0);
    }

    public final Parser<T> plus() {
        return new Repeat(this, 1);
    }

    public final Parser<T> optional() {
        return repeat(0, 1);
    }

    public final Parser<T> list(Parser<? super T> sep) {
        return sequence(this, sequence(sep, this).star());
    }

    public final <U extends T> Parser<U> action(Callback<U> callback) {
        return new Action(this, callback);
    }

    public static <T> Parser<T> alternative(Parser<? super T> left, Parser<? super T> right) {
        return new Alternative(left, right);
    }

    public static <T> Parser<T> intersection(Parser<? super T> left, Parser<? super T> right) {
        return new Intersection(left, right);
    }

    public static <T> Parser<T> difference(Parser<? super T> left, Parser<? super T> right) {
        return new Difference(left, right);
    }

    public static <T> Parser<T> sequence(Parser<? super T> left, Parser<? super T> right) {
        return new Sequence(left, right);
    }

    public static <T> Parser<T> sequence(Parser<? super T> one, Parser<? super T> two, Parser<? super T> three) {
        return sequence(one, sequence(two, three));
    }

    public static <T> Parser<T> sequence(Parser<? super T> one, Parser<? super T> two, Parser<? super T> three, Parser<? super T> four) {
        return sequence(one, sequence(two, sequence(three, four)));
    }

    public static <T> Parser<T> sequence(Parser<? super T> one, Parser<? super T> two, Parser<? super T> three, Parser<? super T> four, Parser<? super T> five) {
        return sequence(one, sequence(two, sequence(three, sequence(four, five))));
    }
}
