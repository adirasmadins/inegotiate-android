package com.google.gdata.util;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.IEntry;
import com.google.gdata.data.IFeed;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;

public class GenerateUtil {
    public static void generateAtom(XmlWriter writer, IEntry entry, ExtensionProfile extProfile) throws IOException {
        if (entry instanceof BaseEntry) {
            ((BaseEntry) entry).generateAtom(writer, extProfile);
        }
    }

    public static void generateAtom(XmlWriter writer, IFeed feed, ExtensionProfile extProfile) throws IOException {
        if (feed instanceof BaseFeed) {
            ((BaseFeed) feed).generateAtom(writer, extProfile);
        }
    }
}
