package com.google.gdata.wireformats.output;

import com.google.gdata.data.OpenSearchDescriptionDocument;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.wireformats.AltFormat;
import java.io.IOException;

public class OpenSearchGenerator extends XmlGenerator<OpenSearchDescriptionDocument> {
    public AltFormat getAltFormat() {
        return AltFormat.OPENSEARCH;
    }

    public Class<OpenSearchDescriptionDocument> getSourceType() {
        return OpenSearchDescriptionDocument.class;
    }

    public void generateXml(XmlWriter xw, OutputProperties outProps, OpenSearchDescriptionDocument source) throws IOException {
        source.generate(xw);
    }
}
