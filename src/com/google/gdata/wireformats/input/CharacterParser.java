package com.google.gdata.wireformats.input;

import com.google.gdata.data.ParseSource;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.io.base.UnicodeReader;
import com.google.gdata.wireformats.AltFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public abstract class CharacterParser<T> extends AbstractParser<T> {
    public abstract <R extends T> R parse(Reader reader, InputProperties inputProperties, Class<R> cls) throws IOException, ServiceException;

    protected CharacterParser(AltFormat altFormat, Class<T> resultClass) {
        super(altFormat, resultClass);
    }

    protected String getCharset(InputProperties inProps) {
        return inProps.getContentType().getCharset();
    }

    public <R extends T> R parse(ParseSource parseSource, InputProperties inProps, Class<R> targetClass) throws IOException, ServiceException {
        Reader reader = parseSource.getReader();
        if (reader == null) {
            InputStream inputStream = parseSource.getInputStream();
            if (inputStream != null) {
                try {
                    String charset = getCharset(inProps);
                    if (charset == null) {
                        charset = StringEncodings.UTF8;
                    }
                    if (charset.toLowerCase().startsWith("utf-")) {
                        reader = new UnicodeReader(inputStream, charset);
                    } else {
                        reader = new InputStreamReader(inputStream, charset);
                    }
                } catch (Throwable e) {
                    throw new ParseException("Unsupported encoding: " + e.getLocalizedMessage(), e);
                }
            }
            throw new IllegalStateException("XML event source not supported");
        }
        return parse(reader, inProps, (Class) targetClass);
    }
}
