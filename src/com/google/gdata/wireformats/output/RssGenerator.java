package com.google.gdata.wireformats.output;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.IAtom;
import com.google.gdata.data.IEntry;
import com.google.gdata.data.IFeed;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.wireformats.AltFormat;
import java.io.IOException;

public class RssGenerator extends XmlGenerator<IAtom> {
    public AltFormat getAltFormat() {
        return AltFormat.RSS;
    }

    public Class<IAtom> getSourceType() {
        return IAtom.class;
    }

    public void generateXml(XmlWriter xw, OutputProperties outProps, IAtom source) throws IOException {
        if (source instanceof IFeed) {
            IFeed feed = (IFeed) source;
            if (feed instanceof BaseFeed) {
                ((BaseFeed) feed).generateRss(xw, outProps.getExtensionProfile());
                return;
            }
            throw new IllegalArgumentException("Feed was not an instance of BaseFeed");
        } else if (source instanceof IEntry) {
            IEntry entry = (IEntry) source;
            if (entry instanceof BaseEntry) {
                ((BaseEntry) entry).generateRss(xw, outProps.getExtensionProfile());
                return;
            }
            throw new IllegalArgumentException("Entry was not an instance of BaseEntry");
        } else {
            throw new IllegalStateException("Unexpected source type: " + source);
        }
    }
}
