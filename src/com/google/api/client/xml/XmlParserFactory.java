package com.google.api.client.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public interface XmlParserFactory {
    XmlPullParser createParser() throws XmlPullParserException;

    XmlSerializer createSerializer() throws XmlPullParserException;
}
