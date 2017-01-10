package com.amazonaws.javax.xml.stream.events;

import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.Writer;

public class EntityReferenceEvent extends DummyEvent implements EntityReference {
    private EntityDeclaration fEntityDeclaration;
    private String fEntityName;

    public EntityReferenceEvent() {
        init();
    }

    public EntityReferenceEvent(String entityName, EntityDeclaration entityDeclaration) {
        init();
        this.fEntityName = entityName;
        this.fEntityDeclaration = entityDeclaration;
    }

    public String getName() {
        return this.fEntityName;
    }

    public String toString() {
        String text = this.fEntityDeclaration.getReplacementText();
        if (text == null) {
            text = StringUtil.EMPTY_STRING;
        }
        return new StringBuffer().append("&").append(getName()).append(";='").append(text).append("'").toString();
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write(38);
        writer.write(getName());
        writer.write(59);
    }

    public EntityDeclaration getDeclaration() {
        return this.fEntityDeclaration;
    }

    protected void init() {
        setEventType(9);
    }
}
