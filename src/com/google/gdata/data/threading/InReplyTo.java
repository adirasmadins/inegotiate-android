package com.google.gdata.data.threading;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

@Default(localName = "in-reply-to", nsAlias = "thr", nsUri = "http://purl.org/syndication/thread/1.0")
public class InReplyTo extends ExtensionPoint {
    private static final String HREF = "href";
    private static final String REF = "ref";
    private static final String SOURCE = "source";
    private static final String TYPE = "type";
    static final String XML_NAME = "in-reply-to";
    private String href;
    private String ref;
    private String source;
    private String type;

    public InReplyTo() {
        this.href = null;
        this.ref = null;
        this.source = null;
        this.type = null;
    }

    public InReplyTo(String href, String ref, String source, String type) {
        this.href = null;
        this.ref = null;
        this.source = null;
        this.type = null;
        setHref(href);
        setRef(ref);
        setSource(source);
        setType(type);
        setImmutable(true);
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        throwExceptionIfImmutable();
        this.href = href;
    }

    public boolean hasHref() {
        return getHref() != null;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String ref) {
        throwExceptionIfImmutable();
        this.ref = ref;
    }

    public boolean hasRef() {
        return getRef() != null;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        throwExceptionIfImmutable();
        this.source = source;
    }

    public boolean hasSource() {
        return getSource() != null;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        throwExceptionIfImmutable();
        this.type = type;
    }

    public boolean hasType() {
        return getType() != null;
    }

    protected void validate() {
        if (this.ref == null) {
            AbstractExtension.throwExceptionForMissingAttribute(REF);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(InReplyTo.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(HREF, this.href);
        generator.put(REF, this.ref);
        generator.put(SOURCE, this.source);
        generator.put(TYPE, this.type);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.href = helper.consume(HREF, false);
        this.ref = helper.consume(REF, true);
        this.source = helper.consume(SOURCE, false);
        this.type = helper.consume(TYPE, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        InReplyTo other = (InReplyTo) obj;
        if (AbstractExtension.eq(this.href, other.href) && AbstractExtension.eq(this.ref, other.ref) && AbstractExtension.eq(this.source, other.source) && AbstractExtension.eq(this.type, other.type)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.href != null) {
            result = (result * 37) + this.href.hashCode();
        }
        if (this.ref != null) {
            result = (result * 37) + this.ref.hashCode();
        }
        if (this.source != null) {
            result = (result * 37) + this.source.hashCode();
        }
        if (this.type != null) {
            return (result * 37) + this.type.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{InReplyTo href=" + this.href + " ref=" + this.ref + " source=" + this.source + " type=" + this.type + "}";
    }
}
