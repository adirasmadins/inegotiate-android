package com.amazonaws.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public class StringInputStream extends ByteArrayInputStream {
    private final String string;

    public StringInputStream(String str) throws UnsupportedEncodingException {
        super(str.getBytes(StringEncodings.UTF8));
        this.string = str;
    }

    public String getString() {
        return this.string;
    }
}
