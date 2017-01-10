package com.google.gdata.data;

import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import org.xml.sax.Attributes;

public interface Extension {
    void generate(XmlWriter xmlWriter, ExtensionProfile extensionProfile) throws IOException;

    ElementHandler getHandler(ExtensionProfile extensionProfile, String str, String str2, Attributes attributes) throws ParseException, IOException;
}
