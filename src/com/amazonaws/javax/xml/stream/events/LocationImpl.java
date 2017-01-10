package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.Location;

public class LocationImpl implements Location {
    int charOffset;
    int colNo;
    int lineNo;
    String publicId;
    String systemId;

    LocationImpl(Location loc) {
        this.systemId = loc.getSystemId();
        this.publicId = loc.getPublicId();
        this.lineNo = loc.getLineNumber();
        this.colNo = loc.getColumnNumber();
        this.charOffset = loc.getCharacterOffset();
    }

    public int getCharacterOffset() {
        return this.charOffset;
    }

    public int getColumnNumber() {
        return this.colNo;
    }

    public int getLineNumber() {
        return this.lineNo;
    }

    public String getPublicId() {
        return this.publicId;
    }

    public String getSystemId() {
        return this.systemId;
    }

    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(new StringBuffer().append("Line number = ").append(getLineNumber()).toString());
        sbuffer.append("\n");
        sbuffer.append(new StringBuffer().append("Column number = ").append(getColumnNumber()).toString());
        sbuffer.append("\n");
        sbuffer.append(new StringBuffer().append("System Id = ").append(getSystemId()).toString());
        sbuffer.append("\n");
        sbuffer.append(new StringBuffer().append("Public Id = ").append(getPublicId()).toString());
        sbuffer.append("\n");
        sbuffer.append(new StringBuffer().append("CharacterOffset = ").append(getCharacterOffset()).toString());
        sbuffer.append("\n");
        return sbuffer.toString();
    }
}
