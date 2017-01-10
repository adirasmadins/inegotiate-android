package com.google.gdata.wireformats.output;

import com.google.gdata.util.ContentType;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.WriterFlags;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public abstract class XmlGenerator<S> extends CharacterGenerator<S> {
    protected static final List<ContentType> XML_CONTENT_TYPES;

    public abstract void generateXml(XmlWriter xmlWriter, OutputProperties outputProperties, S s) throws IOException;

    static {
        XML_CONTENT_TYPES = Collections.unmodifiableList(Arrays.asList(new ContentType[]{ContentType.TEXT_XML, ContentType.TEXT_PLAIN}));
    }

    protected XmlWriter getXmlWriter(Writer w, OutputProperties outProps, String charset) throws IOException {
        EnumSet<WriterFlags> writerFlags = EnumSet.of(WriterFlags.WRITE_HEADER);
        if (usePrettyPrint(outProps)) {
            writerFlags.add(WriterFlags.PRETTY_PRINT);
        }
        return new XmlWriter(w, writerFlags, charset);
    }

    protected static List<ContentType> createMatchingXmlList(ContentType... types) {
        ArrayList<ContentType> matchingTypes = new ArrayList(types.length + XML_CONTENT_TYPES.size());
        for (ContentType contentType : types) {
            matchingTypes.add(contentType);
        }
        matchingTypes.addAll(XML_CONTENT_TYPES);
        return Collections.unmodifiableList(matchingTypes);
    }

    public void generate(Writer w, OutputProperties outProps, S source) throws IOException {
        generateXml(getXmlWriter(w, outProps, CharacterGenerator.getCharsetEncoding(outProps)), outProps, source);
        w.flush();
    }
}
