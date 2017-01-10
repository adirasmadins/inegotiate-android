package com.google.api.client.xml.atom;

import com.google.api.client.util.ClassInfo;
import com.google.api.client.xml.Xml;
import com.google.api.client.xml.XmlNamespaceDictionary;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public abstract class AbstractAtomFeedParser<T> {
    public Class<T> feedClass;
    private boolean feedParsed;
    public InputStream inputStream;
    public XmlNamespaceDictionary namespaceDictionary;
    public XmlPullParser parser;

    protected abstract Object parseEntryInternal() throws IOException, XmlPullParserException;

    public T parseFeed() throws IOException, XmlPullParserException {
        boolean close = true;
        try {
            this.feedParsed = true;
            T result = ClassInfo.newInstance(this.feedClass);
            Xml.parseElement(this.parser, result, this.namespaceDictionary, StopAtAtomEntry.INSTANCE);
            close = false;
            return result;
        } finally {
            if (close) {
                close();
            }
        }
    }

    public Object parseNextEntry() throws IOException, XmlPullParserException {
        Object result = null;
        XmlPullParser parser = this.parser;
        if (!this.feedParsed) {
            this.feedParsed = true;
            Xml.parseElement(parser, null, this.namespaceDictionary, StopAtAtomEntry.INSTANCE);
        }
        boolean close = true;
        try {
            if (parser.getEventType() == 2) {
                result = parseEntryInternal();
                parser.next();
                close = false;
            } else if (1 != null) {
                close();
            }
            return result;
        } finally {
            if (close) {
                close();
            }
        }
    }

    public void close() throws IOException {
        this.inputStream.close();
    }
}
