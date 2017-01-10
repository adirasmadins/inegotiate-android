package com.google.api.client.xml;

import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.ClassInfo;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XmlHttpParser implements HttpParser {
    public static final String CONTENT_TYPE = "application/xml";
    public String contentType;
    public XmlNamespaceDictionary namespaceDictionary;

    public XmlHttpParser() {
        this.contentType = CONTENT_TYPE;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public <T> T parse(HttpResponse response, Class<T> dataClass) throws IOException {
        InputStream content = response.getContent();
        try {
            T result = ClassInfo.newInstance(dataClass);
            XmlPullParser parser = Xml.createParser();
            parser.setInput(content, null);
            Xml.parseElement(parser, result, this.namespaceDictionary, null);
            content.close();
            return result;
        } catch (XmlPullParserException e) {
            IOException exception = new IOException();
            exception.initCause(e);
            throw exception;
        } catch (Throwable th) {
            content.close();
        }
    }
}
