package com.google.api.client.util;

import java.io.UnsupportedEncodingException;

public class Strings {
    public static final String LINE_SEPARATOR;

    static {
        LINE_SEPARATOR = System.getProperty("line.separator");
    }

    public static byte[] toBytesUtf8(String string) {
        try {
            return string.getBytes(StringEncodings.UTF8);
        } catch (UnsupportedEncodingException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String fromBytesUtf8(byte[] bytes) {
        try {
            return new String(bytes, StringEncodings.UTF8);
        } catch (UnsupportedEncodingException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Strings() {
    }
}
