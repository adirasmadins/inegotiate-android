package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.Location;
import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.Writer;

public class StartDocumentEvent extends DummyEvent implements StartDocument {
    protected String fEncodingScheam;
    private boolean fEncodingSchemeSet;
    protected boolean fStandalone;
    private boolean fStandaloneSet;
    protected String fSystemId;
    protected String fVersion;
    private boolean nestedCall;

    public StartDocumentEvent() {
        this.fEncodingSchemeSet = false;
        this.fStandaloneSet = false;
        this.nestedCall = false;
        init(StringEncodings.UTF8, XMLStreamWriterImpl.DEFAULT_XML_VERSION, true, null);
    }

    public StartDocumentEvent(String encoding) {
        this.fEncodingSchemeSet = false;
        this.fStandaloneSet = false;
        this.nestedCall = false;
        init(encoding, XMLStreamWriterImpl.DEFAULT_XML_VERSION, true, null);
    }

    public StartDocumentEvent(String encoding, String version) {
        this.fEncodingSchemeSet = false;
        this.fStandaloneSet = false;
        this.nestedCall = false;
        init(encoding, version, true, null);
    }

    public StartDocumentEvent(String encoding, String version, boolean standalone) {
        this.fEncodingSchemeSet = false;
        this.fStandaloneSet = false;
        this.nestedCall = false;
        this.fStandaloneSet = true;
        init(encoding, version, standalone, null);
    }

    public StartDocumentEvent(String encoding, String version, boolean standalone, Location loc) {
        this.fEncodingSchemeSet = false;
        this.fStandaloneSet = false;
        this.nestedCall = false;
        this.fStandaloneSet = true;
        init(encoding, version, standalone, loc);
    }

    protected void init(String encoding, String version, boolean standalone, Location loc) {
        setEventType(7);
        this.fEncodingScheam = encoding;
        this.fVersion = version;
        this.fStandalone = standalone;
        if (encoding == null || encoding.equals(StringUtil.EMPTY_STRING)) {
            this.fEncodingSchemeSet = false;
            this.fEncodingScheam = StringEncodings.UTF8;
        } else {
            this.fEncodingSchemeSet = true;
        }
        this.fLocation = loc;
    }

    public String getSystemId() {
        if (this.fLocation == null) {
            return StringUtil.EMPTY_STRING;
        }
        return this.fLocation.getSystemId();
    }

    public String getCharacterEncodingScheme() {
        return this.fEncodingScheam;
    }

    public boolean isStandalone() {
        return this.fStandalone;
    }

    public String getVersion() {
        return this.fVersion;
    }

    public void setStandalone(boolean flag) {
        this.fStandaloneSet = true;
        this.fStandalone = flag;
    }

    public void setStandalone(String s) {
        this.fStandaloneSet = true;
        if (s == null) {
            this.fStandalone = true;
        } else if (s.equals("yes")) {
            this.fStandalone = true;
        } else {
            this.fStandalone = false;
        }
    }

    public boolean encodingSet() {
        return this.fEncodingSchemeSet;
    }

    public boolean standaloneSet() {
        return this.fStandaloneSet;
    }

    public void setEncoding(String encoding) {
        this.fEncodingScheam = encoding;
    }

    void setDeclaredEncoding(boolean value) {
        this.fEncodingSchemeSet = value;
    }

    public void setVersion(String s) {
        this.fVersion = s;
    }

    void clear() {
        this.fEncodingScheam = StringEncodings.UTF8;
        this.fStandalone = true;
        this.fVersion = XMLStreamWriterImpl.DEFAULT_XML_VERSION;
        this.fEncodingSchemeSet = false;
        this.fStandaloneSet = false;
    }

    public String toString() {
        String s = new StringBuffer().append(new StringBuffer().append("<?xml version=\"").append(this.fVersion).append("\"").toString()).append(" encoding='").append(this.fEncodingScheam).append("'").toString();
        if (!this.fStandaloneSet) {
            return new StringBuffer().append(s).append("?>").toString();
        }
        if (this.fStandalone) {
            return new StringBuffer().append(s).append(" standalone='yes'?>").toString();
        }
        return new StringBuffer().append(s).append(" standalone='no'?>").toString();
    }

    public boolean isStartDocument() {
        return true;
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write(toString());
    }
}
