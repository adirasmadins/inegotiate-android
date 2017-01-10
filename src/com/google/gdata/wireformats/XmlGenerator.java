package com.google.gdata.wireformats;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.AttributeMetadata;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.ElementVisitor;
import com.google.gdata.model.ElementVisitor.StoppedException;
import com.google.gdata.model.QName;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import com.google.gdata.util.common.xml.XmlWriter.WriterFlags;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class XmlGenerator implements WireFormatGenerator, ElementVisitor {
    private static final ElementGenerator DEFAULT_GENERATOR;
    private static final XmlNamespace USE_ROOT_ELEMENT_NAMESPACE;
    private final XmlNamespace defaultNamespace;
    protected final ElementMetadata<?, ?> rootMetadata;
    protected final XmlWriter xw;

    public interface ElementGenerator {
        void endElement(XmlWriter xmlWriter, Element element, ElementMetadata<?, ?> elementMetadata) throws IOException;

        boolean startElement(XmlWriter xmlWriter, Element element, Element element2, ElementMetadata<?, ?> elementMetadata) throws IOException;

        void textContent(XmlWriter xmlWriter, Element element, ElementMetadata<?, ?> elementMetadata) throws IOException;
    }

    public static class XmlElementGenerator implements ElementGenerator {
        public boolean startElement(XmlWriter xw, Element parent, Element e, ElementMetadata<?, ?> metadata) throws IOException {
            Collection<XmlNamespace> namespaces = getNamespaces(parent, e, metadata);
            List<Attribute> attrs = getAttributes(e, metadata);
            QName name = getName(e, metadata);
            xw.startElement(name.getNs(), name.getLocalName(), attrs, namespaces);
            return true;
        }

        protected QName getName(Element e, ElementMetadata<?, ?> metadata) {
            return metadata == null ? e.getElementId() : metadata.getName();
        }

        protected Collection<XmlNamespace> getNamespaces(Element parent, Element e, ElementMetadata<?, ?> metadata) {
            if (parent == null) {
                return GeneratorUtils.calculateNamespaces(e, metadata).values();
            }
            return null;
        }

        protected List<Attribute> getAttributes(Element e, ElementMetadata<?, ?> metadata) {
            List<Attribute> attrs = null;
            Iterator<com.google.gdata.model.Attribute> attributeIterator = e.getAttributeIterator(metadata);
            if (attributeIterator.hasNext()) {
                ElementKey<?, ?> key = e.getElementKey();
                attrs = new ArrayList();
                while (attributeIterator.hasNext()) {
                    String alias;
                    com.google.gdata.model.Attribute attribute = (com.google.gdata.model.Attribute) attributeIterator.next();
                    AttributeKey<?> attKey = attribute.getAttributeKey();
                    AttributeMetadata<?> attMeta = metadata == null ? null : metadata.bindAttribute(attKey);
                    QName qName = attMeta != null ? attMeta.getName() : attKey.getId();
                    if (qName.getNs() != null) {
                        alias = qName.getNs().getAlias();
                    } else {
                        alias = null;
                    }
                    attrs.add(new Attribute(alias, qName.getLocalName(), attribute.getValue().toString()));
                }
            }
            return attrs;
        }

        public void textContent(XmlWriter xw, Element e, ElementMetadata<?, ?> metadata) throws IOException {
            Object value = metadata == null ? e.getTextValue() : metadata.generateValue(e, metadata);
            if (value != null) {
                String valStr = value.toString();
                if (valStr.length() > 0) {
                    xw.characters(valStr);
                }
            }
        }

        public void endElement(XmlWriter xw, Element e, ElementMetadata<?, ?> metadata) throws IOException {
            QName name = getName(e, metadata);
            xw.endElement(name.getNs(), name.getLocalName());
        }
    }

    static {
        USE_ROOT_ELEMENT_NAMESPACE = new XmlNamespace("__USE_ROOT_ELEMENT_NAMESPACE__");
        DEFAULT_GENERATOR = new XmlElementGenerator();
    }

    public XmlGenerator(StreamProperties props, Writer w, Charset cs, boolean prettyPrint) {
        this(props, w, cs, prettyPrint, USE_ROOT_ELEMENT_NAMESPACE);
    }

    public XmlGenerator(StreamProperties props, Writer w, Charset cs, boolean prettyPrint, XmlNamespace defaultNamespace) {
        EnumSet<WriterFlags> flags = EnumSet.of(WriterFlags.WRITE_HEADER);
        if (prettyPrint) {
            flags.add(WriterFlags.PRETTY_PRINT);
        }
        try {
            this.xw = new XmlWriter(w, flags, cs.name());
            this.rootMetadata = props.getRootMetadata();
            this.defaultNamespace = defaultNamespace;
        } catch (IOException ioe) {
            throw new RuntimeException("Unable to create XML generator", ioe);
        }
    }

    public void generate(Element element) throws IOException {
        generate(element, this.rootMetadata);
    }

    public void generate(Element element, ElementMetadata<?, ?> metadata) throws IOException {
        if (metadata == null || metadata.getKey().equals(element.getElementKey())) {
            try {
                element.visit(this, metadata);
                return;
            } catch (StoppedException se) {
                Throwable cause = se.getCause();
                if (cause instanceof IOException) {
                    throw ((IOException) cause);
                }
                throw se;
            }
        }
        throw new IllegalStateException("Element key (" + element.getElementKey() + ") does not match metadata key (" + metadata.getKey() + ")");
    }

    private ElementGenerator getElementGenerator(ElementMetadata<?, ?> metadata) {
        if (metadata != null) {
            XmlWireFormatProperties xmlProperties = (XmlWireFormatProperties) metadata.getProperties();
            if (xmlProperties != null) {
                ElementGenerator elementGenerator = xmlProperties.getElementGenerator();
                if (elementGenerator != null) {
                    return elementGenerator;
                }
            }
        }
        return DEFAULT_GENERATOR;
    }

    public boolean visit(Element parent, Element e, ElementMetadata<?, ?> metadata) throws StoppedException {
        if (parent == null) {
            try {
                setRootNamespace(metadata, e);
            } catch (Throwable ioe) {
                throw new StoppedException(ioe);
            }
        }
        if (metadata == null || metadata.isSelected(e)) {
            return getElementGenerator(metadata).startElement(this.xw, parent, e, metadata);
        }
        return false;
    }

    private void setRootNamespace(ElementMetadata<?, ?> meta, Element e) {
        XmlNamespace rootNs = this.defaultNamespace;
        if (rootNs == USE_ROOT_ELEMENT_NAMESPACE) {
            if (meta != null) {
                rootNs = meta.getDefaultNamespace();
            } else {
                rootNs = e.getElementId().getNs();
            }
        }
        if (rootNs != null) {
            this.xw.setDefaultNamespace(rootNs);
        }
    }

    public void visitComplete(Element parent, Element e, ElementMetadata<?, ?> metadata) throws StoppedException {
        if (metadata != null) {
            try {
                if (!metadata.isSelected(e)) {
                    return;
                }
            } catch (Throwable ioe) {
                throw new StoppedException(ioe);
            }
        }
        ElementGenerator elementGenerator = getElementGenerator(metadata);
        elementGenerator.textContent(this.xw, e, metadata);
        elementGenerator.endElement(this.xw, e, metadata);
    }
}
