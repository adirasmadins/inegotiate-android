package com.google.gdata.wireformats.output;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.IAtom;
import com.google.gdata.data.IEntry;
import com.google.gdata.data.IFeed;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.wireformats.AltFormat;
import java.io.IOException;

public class AtomGenerator extends XmlGenerator<IAtom> {
    public AltFormat getAltFormat() {
        return AltFormat.ATOM;
    }

    public Class<IAtom> getSourceType() {
        return IAtom.class;
    }

    public void generateXml(XmlWriter xw, OutputProperties outProps, IAtom source) throws IOException {
        xw.setDefaultNamespace(Namespaces.atomNs);
        ExtensionProfile extProfile = outProps.getExtensionProfile();
        if (source instanceof IFeed) {
            IFeed feed = (IFeed) source;
            if (feed instanceof BaseFeed) {
                ((BaseFeed) feed).generateAtom(xw, extProfile);
                return;
            }
            throw new IllegalArgumentException("Feed was not an instance of data.BaseFeed");
        } else if (source instanceof IEntry) {
            IEntry entry = (IEntry) source;
            if (entry instanceof BaseEntry) {
                ((BaseEntry) entry).generateAtom(xw, extProfile);
                return;
            }
            throw new IllegalArgumentException("Entry was not an instance of data.BaseEntry");
        } else if (source != null) {
            throw new IllegalStateException("Unexpected source type: " + source.getClass());
        }
    }
}
