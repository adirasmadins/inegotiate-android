package com.google.gdata.wireformats.input;

import com.google.gdata.data.ParseSource;
import com.google.gdata.data.XmlEventSource;
import com.google.gdata.util.ServiceException;
import com.google.gdata.wireformats.AltFormat;
import java.io.IOException;

public abstract class XmlInputParser<T> extends CharacterParser<T> {
    protected abstract <R extends T> R parse(XmlEventSource xmlEventSource, InputProperties inputProperties, Class<R> cls) throws IOException, ServiceException;

    public XmlInputParser(AltFormat altFormat, Class<T> resultClass) {
        super(altFormat, resultClass);
    }

    public <R extends T> R parse(ParseSource parseSource, InputProperties inProps, Class<R> targetClass) throws IOException, ServiceException {
        XmlEventSource eventSource = parseSource.getEventSource();
        if (eventSource == null) {
            return super.parse(parseSource, inProps, (Class) targetClass);
        }
        return parse(eventSource, inProps, (Class) targetClass);
    }
}
