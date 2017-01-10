package com.google.api.client.googleapis.xml.atom;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.xml.Xml;
import com.google.api.client.xml.XmlNamespaceDictionary;
import com.google.api.client.xml.atom.AbstractAtomFeedParser;
import com.google.api.client.xml.atom.Atom;
import com.google.gdata.util.Namespaces;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class MultiKindFeedParser<T> extends AbstractAtomFeedParser<T> {
    private final HashMap<String, Class<?>> kindToEntryClassMap;

    public MultiKindFeedParser() {
        this.kindToEntryClassMap = new HashMap();
    }

    public void setEntryClasses(Class<?>... entryClasses) {
        HashMap<String, Class<?>> kindToEntryClassMap = this.kindToEntryClassMap;
        for (Class<?> entryClass : entryClasses) {
            Field field = ClassInfo.of(entryClass).getField("@gd:kind");
            if (field == null) {
                throw new IllegalArgumentException("missing @gd:kind field for " + entryClass.getName());
            }
            String kind = (String) FieldInfo.getFieldValue(field, ClassInfo.newInstance(entryClass));
            if (kind == null) {
                throw new IllegalArgumentException("missing value for @gd:kind field in " + entryClass.getName());
            }
            kindToEntryClassMap.put(kind, entryClass);
        }
    }

    protected Object parseEntryInternal() throws IOException, XmlPullParserException {
        XmlPullParser parser = this.parser;
        String kind = parser.getAttributeValue(Namespaces.f443g, "kind");
        Class<?> entryClass = (Class) this.kindToEntryClassMap.get(kind);
        if (entryClass == null) {
            throw new IllegalArgumentException("unrecognized kind: " + kind);
        }
        Object result = ClassInfo.newInstance(entryClass);
        Xml.parseElement(parser, result, this.namespaceDictionary, null);
        return result;
    }

    public static <T, I> MultiKindFeedParser<T> create(HttpResponse response, XmlNamespaceDictionary namespaceDictionary, Class<T> feedClass, Class<?>... entryClasses) throws XmlPullParserException, IOException {
        InputStream content = response.getContent();
        try {
            Atom.checkContentType(response.contentType);
            XmlPullParser parser = Xml.createParser();
            parser.setInput(content, null);
            MultiKindFeedParser<T> result = new MultiKindFeedParser();
            result.parser = parser;
            result.inputStream = content;
            result.feedClass = feedClass;
            result.namespaceDictionary = namespaceDictionary;
            result.setEntryClasses(entryClasses);
            return result;
        } finally {
            content.close();
        }
    }
}
