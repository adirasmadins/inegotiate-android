package com.google.gdata.wireformats;

import com.google.gdata.util.io.base.UnicodeReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public abstract class ParserUtils {
    private ParserUtils() {
    }

    public static Reader getInputReader(InputStream input, Charset cs) throws IOException {
        if (cs.name().toLowerCase().startsWith("utf-")) {
            return new UnicodeReader(input, cs.name());
        }
        return new InputStreamReader(input, cs);
    }
}
