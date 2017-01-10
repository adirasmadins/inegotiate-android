package com.google.api.client.android.xml;

import android.util.Xml;
import com.google.api.client.xml.XmlParserFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public final class AndroidXmlParserFactory implements XmlParserFactory {
    public XmlPullParser createParser() {
        return Xml.newPullParser();
    }

    public XmlSerializer createSerializer() {
        return Xml.newSerializer();
    }
}
