package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;
import com.amazonaws.javax.xml.stream.Location;
import com.amazonaws.javax.xml.stream.XMLStreamException;
import com.amazonaws.javax.xml.stream.XMLStreamException2;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.Writer;

public abstract class DummyEvent implements XMLEvent {
    private int fEventType;
    protected Location fLocation;

    protected abstract void writeAsEncodedUnicodeEx(Writer writer) throws IOException, XMLStreamException;

    public DummyEvent() {
        this.fLocation = null;
    }

    public DummyEvent(int i) {
        this.fLocation = null;
        this.fEventType = i;
    }

    public int getEventType() {
        return this.fEventType;
    }

    protected void setEventType(int eventType) {
        this.fEventType = eventType;
    }

    public boolean isStartElement() {
        return this.fEventType == 1;
    }

    public boolean isEndElement() {
        return this.fEventType == 2;
    }

    public boolean isEntityReference() {
        return this.fEventType == 9;
    }

    public boolean isProcessingInstruction() {
        return this.fEventType == 3;
    }

    public boolean isCharacterData() {
        return this.fEventType == 4;
    }

    public boolean isStartDocument() {
        return this.fEventType == 7;
    }

    public boolean isEndDocument() {
        return this.fEventType == 8;
    }

    public Location getLocation() {
        return this.fLocation;
    }

    void setLocation(Location loc) {
        this.fLocation = loc;
    }

    public Characters asCharacters() {
        return (Characters) this;
    }

    public EndElement asEndElement() {
        return (EndElement) this;
    }

    public StartElement asStartElement() {
        return (StartElement) this;
    }

    public QName getSchemaType() {
        return null;
    }

    public boolean isAttribute() {
        return this.fEventType == 10;
    }

    public boolean isCharacters() {
        return this.fEventType == 4;
    }

    public boolean isNamespace() {
        return this.fEventType == 13;
    }

    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            writeAsEncodedUnicodeEx(writer);
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    protected void charEncode(Writer writer, String data) throws IOException {
        if (data != null && data != StringUtil.EMPTY_STRING) {
            int start = 0;
            int len = data.length();
            for (int i = 0; i < len; i++) {
                switch (data.charAt(i)) {
                    case '\"':
                        writer.write(data, start, i - start);
                        writer.write("&quot;");
                        start = i + 1;
                        break;
                    case '&':
                        writer.write(data, start, i - start);
                        writer.write("&amp;");
                        start = i + 1;
                        break;
                    case '<':
                        writer.write(data, start, i - start);
                        writer.write("&lt;");
                        start = i + 1;
                        break;
                    case '>':
                        writer.write(data, start, i - start);
                        writer.write("&gt;");
                        start = i + 1;
                        break;
                    default:
                        break;
                }
            }
            writer.write(data, start, len - start);
        }
    }
}
