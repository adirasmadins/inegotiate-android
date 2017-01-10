package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import java.io.IOException;
import java.io.Writer;

public class CharacterEvent extends DummyEvent implements Characters {
    private boolean fCheckIfSpaceNeeded;
    private String fData;
    private boolean fIsCData;
    private boolean fIsIgnorableWhitespace;
    private boolean fIsSpace;

    public CharacterEvent() {
        this.fIsSpace = false;
        this.fCheckIfSpaceNeeded = true;
        this.fIsCData = false;
        init();
    }

    public CharacterEvent(String data) {
        this.fIsSpace = false;
        this.fCheckIfSpaceNeeded = true;
        this.fIsCData = false;
        init();
        this.fData = data;
    }

    public CharacterEvent(String data, boolean flag) {
        this.fIsSpace = false;
        this.fCheckIfSpaceNeeded = true;
        init();
        this.fData = data;
        this.fIsCData = flag;
    }

    public CharacterEvent(String data, boolean flag, boolean isIgnorableWhiteSpace) {
        this.fIsSpace = false;
        this.fCheckIfSpaceNeeded = true;
        init();
        this.fData = data;
        this.fIsCData = flag;
        this.fIsIgnorableWhitespace = isIgnorableWhiteSpace;
    }

    protected void init() {
        setEventType(4);
    }

    public String getData() {
        return this.fData;
    }

    public void setData(String data) {
        this.fData = data;
        this.fCheckIfSpaceNeeded = true;
    }

    public boolean isCData() {
        return this.fIsCData;
    }

    public String toString() {
        if (this.fIsCData) {
            return new StringBuffer().append(XMLStreamWriterImpl.START_CDATA).append(getData()).append(XMLStreamWriterImpl.END_CDATA).toString();
        }
        return this.fData;
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        if (this.fIsCData) {
            writer.write(new StringBuffer().append(XMLStreamWriterImpl.START_CDATA).append(getData()).append(XMLStreamWriterImpl.END_CDATA).toString());
        } else {
            charEncode(writer, this.fData);
        }
    }

    public boolean isIgnorableWhiteSpace() {
        return this.fIsIgnorableWhitespace;
    }

    public boolean isWhiteSpace() {
        if (this.fCheckIfSpaceNeeded) {
            checkWhiteSpace();
            this.fCheckIfSpaceNeeded = false;
        }
        return this.fIsSpace;
    }

    private void checkWhiteSpace() {
        if (this.fData != null && this.fData.length() > 0) {
            this.fIsSpace = true;
            int i = 0;
            while (i < this.fData.length()) {
                if (XMLChar.isSpace(this.fData.charAt(i))) {
                    i++;
                } else {
                    this.fIsSpace = false;
                    return;
                }
            }
        }
    }
}
