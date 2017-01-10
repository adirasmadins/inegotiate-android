package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.dtd.nonvalidating.XMLNotationDecl;
import java.io.IOException;
import java.io.Writer;

public class NotationDeclarationImpl extends DummyEvent implements NotationDeclaration {
    String fName;
    String fPublicId;
    String fSystemId;

    public NotationDeclarationImpl() {
        this.fName = null;
        this.fPublicId = null;
        this.fSystemId = null;
        setEventType(14);
    }

    public NotationDeclarationImpl(String name, String publicId, String systemId) {
        this.fName = null;
        this.fPublicId = null;
        this.fSystemId = null;
        this.fName = name;
        this.fPublicId = publicId;
        this.fSystemId = systemId;
        setEventType(14);
    }

    public NotationDeclarationImpl(XMLNotationDecl notation) {
        this.fName = null;
        this.fPublicId = null;
        this.fSystemId = null;
        this.fName = notation.name;
        this.fPublicId = notation.publicId;
        this.fSystemId = notation.systemId;
        setEventType(14);
    }

    public String getName() {
        return this.fName;
    }

    public String getPublicId() {
        return this.fPublicId;
    }

    public String getSystemId() {
        return this.fSystemId;
    }

    void setPublicId(String publicId) {
        this.fPublicId = publicId;
    }

    void setSystemId(String systemId) {
        this.fSystemId = systemId;
    }

    void setName(String name) {
        this.fName = name;
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write("<!NOTATION ");
        writer.write(getName());
        if (this.fPublicId != null) {
            writer.write(" PUBLIC \"");
            writer.write(this.fPublicId);
            writer.write("\"");
        } else if (this.fSystemId != null) {
            writer.write(" SYSTEM");
            writer.write(" \"");
            writer.write(this.fSystemId);
            writer.write("\"");
        }
        writer.write(62);
    }
}
