package com.google.gdata.util.common.net;

import com.google.gdata.util.common.base.CharEscapers;
import com.google.gdata.util.common.base.Charsets;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.util.httputil.FastURLEncoder;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

public final class UriEncoder {
    public static final Charset DEFAULT_ENCODING;

    private UriEncoder() {
    }

    static {
        DEFAULT_ENCODING = Charsets.UTF_8;
    }

    public static String encode(String string) {
        return CharEscapers.uriEscaper().escape(string);
    }

    public static String encode(String string, Charset encoding) {
        Preconditions.checkNotNull(string);
        Preconditions.checkNotNull(encoding);
        if (encoding.equals(DEFAULT_ENCODING)) {
            return encode(string);
        }
        try {
            return FastURLEncoder.encode(string, encoding.name());
        } catch (UnsupportedEncodingException impossible) {
            throw new AssertionError(impossible);
        }
    }

    public static String decode(String string) {
        return decode(string, DEFAULT_ENCODING);
    }

    public static String decode(String string, Charset encoding) {
        Preconditions.checkNotNull(string);
        Preconditions.checkNotNull(encoding);
        try {
            return URLDecoder.decode(string, encoding.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
