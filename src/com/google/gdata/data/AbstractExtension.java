package com.google.gdata.data;

import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.xml.sax.Attributes;

public abstract class AbstractExtension implements Extension {
    private static ThreadLocal<Boolean> strictValidation;
    private boolean immutable;
    protected final String localName;
    protected final XmlNamespace namespace;

    /* renamed from: com.google.gdata.data.AbstractExtension.1 */
    static class C07171 extends ThreadLocal<Boolean> {
        C07171() {
        }

        protected Boolean initialValue() {
            return Boolean.TRUE;
        }
    }

    protected class AttributesHandler extends ElementHandler {
        private final AttributeHelper helper;

        public AttributesHandler(Attributes attrs) {
            this.helper = attrs == null ? null : new AttributeHelper(attrs);
            if (AbstractExtension.this.immutable) {
                throw new IllegalStateException("Cannot parse into immutable instance");
            }
        }

        public void processEndElement() throws ParseException {
            if (this.helper != null) {
                this.helper.setContent(this.value);
                AbstractExtension.this.consumeAttributes(this.helper);
            }
            if (AbstractExtension.isStrictValidation()) {
                try {
                    AbstractExtension.this.validate();
                } catch (Throwable e) {
                    throw new ParseException(e.getMessage(), e);
                }
            }
        }
    }

    static {
        strictValidation = new C07171();
    }

    public static final boolean isStrictValidation() {
        return ((Boolean) strictValidation.get()).booleanValue();
    }

    public static final void enableStrictValidation() {
        strictValidation.set(Boolean.TRUE);
    }

    public static final void disableStrictValidation() {
        strictValidation.set(Boolean.FALSE);
    }

    public final boolean isImmutable() {
        return this.immutable;
    }

    public final void setImmutable(boolean isImmutable) {
        this.immutable = isImmutable;
    }

    protected AbstractExtension() {
        Default defAnnot = (Default) getClass().getAnnotation(Default.class);
        if (defAnnot != null) {
            this.namespace = new XmlNamespace(defAnnot.nsAlias(), defAnnot.nsUri());
            this.localName = defAnnot.localName();
            return;
        }
        this.namespace = null;
        this.localName = null;
    }

    protected AbstractExtension(XmlNamespace namespace, String localName) {
        this.namespace = namespace;
        this.localName = localName;
    }

    public final XmlNamespace getExtensionNamespace() {
        return this.namespace;
    }

    public final String getExtensionLocalName() {
        return this.localName;
    }

    protected void validate() throws IllegalStateException {
    }

    protected void putAttributes(AttributeGenerator generator) {
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
    }

    protected void generate(XmlWriter w, ExtensionProfile p, XmlNamespace namespace, String localName, List<Attribute> attrs, AttributeGenerator generator) throws IOException {
        w.simpleElement(namespace, localName, attrs, generator.getContent());
    }

    public void generate(XmlWriter w, ExtensionProfile p) throws IOException {
        if (this.namespace == null) {
            String name = getClass().getName();
            throw new IllegalStateException("No @ExtensionDescription.Default annotation found on subclass " + name.substring(name.lastIndexOf(46) + 1));
        }
        if (isStrictValidation()) {
            validate();
        }
        AttributeGenerator generator = new AttributeGenerator();
        putAttributes(generator);
        List<Attribute> attrs = new ArrayList();
        generateAttributes(attrs, generator);
        generate(w, p, this.namespace, this.localName, attrs, generator);
    }

    protected void generateAttributes(List<Attribute> attrs, AttributeGenerator generator) {
        for (Entry<String, String> entry : generator.entrySet()) {
            String value = (String) entry.getValue();
            if (value != null) {
                attrs.add(new Attribute((String) entry.getKey(), value));
            }
        }
    }

    public ElementHandler getHandler(ExtensionProfile p, String namespace, String localName, Attributes attrs) throws ParseException {
        return new AttributesHandler(attrs);
    }

    protected final void throwExceptionIfImmutable() {
        if (this.immutable) {
            throw new IllegalStateException(this.localName + " instance is read only");
        }
    }

    protected static final void throwExceptionForMissingAttribute(String attrName) {
        throw new IllegalStateException("Missing attribute: " + attrName);
    }

    protected boolean sameClassAs(Object o) {
        return o != null && getClass().equals(o.getClass());
    }

    protected static boolean eq(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        } else {
            return o1.equals(o2);
        }
    }
}
