package com.google.gdata.util.parser;

public interface Callback<T> {
    void handle(char[] cArr, int i, int i2, T t);
}
