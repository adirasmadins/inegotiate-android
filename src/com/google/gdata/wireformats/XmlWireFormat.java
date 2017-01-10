package com.google.gdata.wireformats;

import com.amazonaws.javax.xml.XMLConstants;
import com.google.gdata.data.XmlEventSource;
import com.google.gdata.wireformats.input.InputProperties;
import com.google.gdata.wireformats.output.OutputProperties;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class XmlWireFormat extends WireFormat {
    public XmlWireFormat() {
        super(XMLConstants.XML_NS_PREFIX);
    }

    public WireFormatGenerator createGenerator(OutputProperties outProps, Writer w, Charset cs, boolean prettyPrint) {
        return new XmlGenerator(outProps, w, cs, prettyPrint);
    }

    public WireFormatParser createParser(InputProperties inProps, Reader r, Charset cs) {
        return new XmlParser(inProps, r, cs);
    }

    public WireFormatParser createParser(InputProperties inProps, XmlEventSource source) {
        return new XmlParser(inProps, source);
    }
}
