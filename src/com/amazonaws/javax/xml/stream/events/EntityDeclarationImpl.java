package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import java.io.IOException;
import java.io.Writer;

public class EntityDeclarationImpl extends DummyEvent implements EntityDeclaration {
    private String fEntityName;
    private String fNotationName;
    private String fReplacementText;
    private XMLResourceIdentifier fXMLResourceIdentifier;

    public EntityDeclarationImpl() {
        init();
    }

    public EntityDeclarationImpl(String entityName, String replacementText) {
        this(entityName, replacementText, null);
    }

    public EntityDeclarationImpl(String entityName, String replacementText, XMLResourceIdentifier resourceIdentifier) {
        init();
        this.fEntityName = entityName;
        this.fReplacementText = replacementText;
        this.fXMLResourceIdentifier = resourceIdentifier;
    }

    public void setEntityName(String entityName) {
        this.fEntityName = entityName;
    }

    public String getEntityName() {
        return this.fEntityName;
    }

    public void setEntityReplacementText(String replacementText) {
        this.fReplacementText = replacementText;
    }

    public void setXMLResourceIdentifier(XMLResourceIdentifier resourceIdentifier) {
        this.fXMLResourceIdentifier = resourceIdentifier;
    }

    public XMLResourceIdentifier getXMLResourceIdentifier() {
        return this.fXMLResourceIdentifier;
    }

    public String getSystemId() {
        if (this.fXMLResourceIdentifier != null) {
            return this.fXMLResourceIdentifier.getLiteralSystemId();
        }
        return null;
    }

    public String getPublicId() {
        if (this.fXMLResourceIdentifier != null) {
            return this.fXMLResourceIdentifier.getPublicId();
        }
        return null;
    }

    public String getBaseURI() {
        if (this.fXMLResourceIdentifier != null) {
            return this.fXMLResourceIdentifier.getBaseSystemId();
        }
        return null;
    }

    public String getName() {
        return this.fEntityName;
    }

    public String getNotationName() {
        return this.fNotationName;
    }

    public void setNotationName(String notationName) {
        this.fNotationName = notationName;
    }

    public String getReplacementText() {
        return this.fReplacementText;
    }

    protected void init() {
        setEventType(15);
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write("<!ENTITY ");
        writer.write(this.fEntityName);
        if (this.fReplacementText != null) {
            writer.write(" \"");
            charEncode(writer, this.fReplacementText);
        } else {
            String pubId = getPublicId();
            if (pubId != null) {
                writer.write(" PUBLIC \"");
                writer.write(pubId);
            } else {
                writer.write(" SYSTEM \"");
                writer.write(getSystemId());
            }
        }
        writer.write("\"");
        if (this.fNotationName != null) {
            writer.write(" NDATA ");
            writer.write(this.fNotationName);
        }
        writer.write(">");
    }
}
