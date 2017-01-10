package com.google.gdata.util;

import com.google.gdata.data.XmlEventSource;
import com.google.gdata.util.XmlParser.ElementHandler;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventSourceParser extends XmlParser {
    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger(EventSourceParser.class.getName());
    }

    public EventSourceParser(ElementHandler rootHandler, String rootNamespace, String rootElementName) {
        this.rootHandler = rootHandler;
        this.rootNamespace = rootNamespace;
        this.rootElementName = rootElementName;
    }

    public void parse(XmlEventSource source) throws ParseException, IOException {
        try {
            source.parse(this);
        } catch (Throwable e) {
            Exception rootException = e.getException();
            if (rootException instanceof ParseException) {
                throwParseException((ParseException) rootException);
            } else if (rootException instanceof IOException) {
                LogUtils.logException(LOGGER, Level.WARNING, null, e);
                throw ((IOException) rootException);
            } else {
                LogUtils.logException(LOGGER, Level.FINE, null, e);
                throw new ParseException(e);
            }
        }
    }
}
