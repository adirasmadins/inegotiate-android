package com.google.api.client.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class DefaultXmlParserFactory implements XmlParserFactory {
    private static DefaultXmlParserFactory INSTANCE;
    private final XmlPullParserFactory factory;

    public static DefaultXmlParserFactory getInstance() throws XmlPullParserException {
        if (INSTANCE == null) {
            INSTANCE = new DefaultXmlParserFactory();
        }
        return INSTANCE;
    }

    private DefaultXmlParserFactory() throws XmlPullParserException {
        this.factory = XmlPullParserFactory.newInstance(System.getProperty("org.xmlpull.v1.XmlPullParserFactory"), null);
        this.factory.setNamespaceAware(true);
    }

    public XmlPullParser createParser() throws XmlPullParserException {
        return this.factory.newPullParser();
    }

    public XmlSerializer createSerializer() throws XmlPullParserException {
        return this.factory.newSerializer();
    }
}
