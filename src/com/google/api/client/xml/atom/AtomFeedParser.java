package com.google.api.client.xml.atom;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.xml.Xml;
import com.google.api.client.xml.XmlNamespaceDictionary;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class AtomFeedParser<T, I> extends AbstractAtomFeedParser<T> {
    public Class<I> entryClass;

    public I parseNextEntry() throws IOException, XmlPullParserException {
        return super.parseNextEntry();
    }

    protected Object parseEntryInternal() throws IOException, XmlPullParserException {
        I result = ClassInfo.newInstance(this.entryClass);
        Xml.parseElement(this.parser, result, this.namespaceDictionary, null);
        return result;
    }

    public static <T, I> AtomFeedParser<T, I> create(HttpResponse response, XmlNamespaceDictionary namespaceDictionary, Class<T> feedClass, Class<I> entryClass) throws XmlPullParserException, IOException {
        InputStream content = response.getContent();
        try {
            Atom.checkContentType(response.contentType);
            XmlPullParser parser = Xml.createParser();
            parser.setInput(content, null);
            AtomFeedParser<T, I> result = new AtomFeedParser();
            result.parser = parser;
            result.inputStream = content;
            result.feedClass = feedClass;
            result.entryClass = entryClass;
            result.namespaceDictionary = namespaceDictionary;
            content = null;
            return result;
        } finally {
            if (content != null) {
                content.close();
            }
        }
    }
}
