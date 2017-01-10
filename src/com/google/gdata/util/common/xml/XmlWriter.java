package com.google.gdata.util.common.xml;

import com.amazonaws.javax.xml.XMLConstants;
import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.amazonaws.javax.xml.transform.OutputKeys;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class XmlWriter {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String INDENTATION_UNIT = "\t";
    private String defaultNamespace;
    private final Stack<Element> elementStack;
    protected String encoding;
    protected final Set<WriterFlags> flags;
    private String nextDefaultNamespace;
    private Boolean standalone;
    protected final Writer writer;

    public static final class Attribute {
        public final String name;
        public final String nsAlias;
        public final String value;

        public Attribute(String name, String value) {
            this(null, name, value);
        }

        public Attribute(String nsAlias, String name, String value) {
            if (nsAlias == null) {
                int separator = name.indexOf(58);
                if (separator > 0) {
                    nsAlias = name.substring(0, separator);
                    name = name.substring(separator + 1);
                }
            }
            this.nsAlias = nsAlias;
            this.name = name;
            this.value = value;
        }

        public Attribute(String name, boolean value) {
            this(null, name, value ? "true" : "false");
        }
    }

    protected static class Element {
        public static final int NOT_REPEATING = -1;
        public String enclosingDefaultNamespace;
        public boolean hasAttributes;
        public final String name;
        public String nsAlias;
        public List<XmlNamespace> nsDecls;
        public final String nsUri;
        public boolean openTagEnded;
        public int repeatingCount;
        public int repeatingIndex;
        public boolean unformattedChildren;
        public String xmlLang;

        protected Element(String nsAlias, String nsUri, String name) {
            this.repeatingCount = NOT_REPEATING;
            this.repeatingIndex = NOT_REPEATING;
            this.nsDecls = new ArrayList();
            this.nsAlias = nsAlias;
            this.nsUri = nsUri;
            this.name = name;
        }

        public void addNamespace(XmlNamespace ns) {
            if (!this.nsDecls.contains(ns)) {
                this.nsDecls.add(ns);
            }
        }
    }

    @Deprecated
    public static final class Namespace extends XmlNamespace {
        public Namespace(String alias, String uri) {
            super(alias, uri);
        }
    }

    public enum WriterFlags {
        WRITE_HEADER,
        EXPAND_EMPTY,
        PRETTY_PRINT
    }

    static {
        $assertionsDisabled = !XmlWriter.class.desiredAssertionStatus() ? true : $assertionsDisabled;
    }

    public XmlWriter(Writer w, Set<WriterFlags> f, String encoding, boolean standalone) throws IOException {
        this(w, f, encoding);
        this.standalone = Boolean.valueOf(standalone);
    }

    public XmlWriter(Writer w, Set<WriterFlags> f, String encoding) throws IOException {
        this.writer = w;
        if (f == null) {
            f = EnumSet.noneOf(WriterFlags.class);
        }
        this.flags = f;
        this.encoding = encoding;
        this.elementStack = new Stack();
        Element rootElement = createElement(null, null, null);
        rootElement.openTagEnded = true;
        this.elementStack.push(rootElement);
    }

    public XmlWriter(Writer w) throws IOException {
        this(w, null, null);
    }

    public XmlWriter(Writer w, String encoding) throws IOException {
        this(w, EnumSet.of(WriterFlags.WRITE_HEADER), encoding);
    }

    @Deprecated
    public XmlWriter(Writer w, boolean includeHeader) throws IOException {
        this(w, EnumSet.of(WriterFlags.WRITE_HEADER), null);
    }

    public void close() throws IOException {
        this.writer.close();
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public void setDefaultNamespace(XmlNamespace namespace) {
        if (!namespace.uri.equals(this.defaultNamespace)) {
            this.nextDefaultNamespace = namespace.uri;
        }
    }

    protected Element createElement(String nsAlias, String nsUri, String name) {
        return new Element(nsAlias, nsUri, name);
    }

    protected Element currentElement() {
        try {
            return (Element) this.elementStack.peek();
        } catch (EmptyStackException e) {
            return null;
        }
    }

    protected Element parentElement() {
        return (Element) this.elementStack.get((this.elementStack.size() - 1) - 1);
    }

    public void startElement(String name) throws IOException {
        startElement(null, name, null, null);
    }

    public void startElement(XmlNamespace namespace, String name, Collection<Attribute> attrs, Collection<? extends XmlNamespace> namespaceDecls) throws IOException {
        Element element;
        if (this.elementStack.size() == 1) {
            writeBeginOutput();
            if (shouldWriteHeaderAndFooter()) {
                writeHeader(this.encoding);
            }
        }
        endOpenTag();
        if (namespace != null) {
            element = createElement(namespace.alias, namespace.uri, name);
        } else {
            element = createElement(null, null, name);
        }
        Element parentElement = currentElement();
        if (parentElement != null) {
            element.xmlLang = parentElement.xmlLang;
            element.unformattedChildren = parentElement.unformattedChildren;
            if (parentElement.repeatingCount != -1) {
                int i = parentElement.repeatingCount;
                parentElement.repeatingCount = i + 1;
                element.repeatingIndex = i;
            }
        }
        this.elementStack.push(element);
        if (this.nextDefaultNamespace != null) {
            XmlNamespace defaultNs = new XmlNamespace(this.nextDefaultNamespace);
            this.defaultNamespace = this.nextDefaultNamespace;
            element.addNamespace(defaultNs);
            this.nextDefaultNamespace = null;
        }
        if (namespaceDecls != null) {
            for (XmlNamespace ns : namespaceDecls) {
                ensureNamespace(ns);
            }
        }
        if (namespace != null) {
            element.nsAlias = ensureNamespace(namespace);
        }
        writeOpenTagStart(element.nsAlias, name);
        for (XmlNamespace ns2 : element.nsDecls) {
            if (ns2.alias == null || ns2.alias.length() <= 0) {
                writeAttribute(null, XMLConstants.XMLNS_ATTRIBUTE, ns2.uri);
            } else {
                writeAttribute(XMLConstants.XMLNS_ATTRIBUTE, ns2.alias, ns2.uri);
            }
        }
        if (attrs != null) {
            for (Attribute attr : attrs) {
                if (attr.name.equals("lang") && XMLConstants.XML_NS_PREFIX.equals(attr.nsAlias)) {
                    if (!attr.value.equals(element.xmlLang)) {
                        element.xmlLang = attr.value;
                    }
                }
                writeAttribute(attr.nsAlias, attr.name, attr.value);
            }
        }
        if (this.flags.contains(WriterFlags.EXPAND_EMPTY)) {
            endOpenTag();
        }
    }

    protected boolean shouldWriteHeaderAndFooter() {
        return (!this.flags.contains(WriterFlags.WRITE_HEADER) && this.encoding == null && this.standalone == null) ? $assertionsDisabled : true;
    }

    protected void endOpenTag() throws IOException {
        Element element = currentElement();
        if (!element.openTagEnded) {
            writeOpenTagEnd();
            element.openTagEnded = true;
        }
    }

    public void endElement(XmlNamespace namespace, String name) throws IOException {
        Element element = currentElement();
        if (!$assertionsDisabled && namespace != null && !element.nsUri.equals(namespace.uri)) {
            throw new AssertionError();
        } else if ($assertionsDisabled || element.name.equals(name)) {
            endElement();
        } else {
            throw new AssertionError();
        }
    }

    public void endElement() throws IOException {
        Element element = currentElement();
        writeCloseTag(element.nsAlias, element.name);
        this.defaultNamespace = element.enclosingDefaultNamespace;
        this.elementStack.pop();
        if (this.elementStack.size() == 1) {
            if (shouldWriteHeaderAndFooter()) {
                writeFooter();
            }
            writeEndOutput();
        }
    }

    public void simpleElement(String name, String value) throws IOException {
        simpleElement(null, name, null, value);
    }

    public void startRepeatingElement() throws IOException {
        Element currentElement = currentElement();
        if (currentElement.repeatingCount != -1) {
            throw new IllegalStateException("Existing repeating element is active");
        }
        currentElement.repeatingCount = 0;
    }

    public void endRepeatingElement() throws IOException {
        currentElement().repeatingCount = -1;
    }

    public void simpleElement(XmlNamespace namespace, String name, List<Attribute> attrs, String value) throws IOException {
        startElement(namespace, name, attrs, null);
        characters(value);
        endElement(namespace, name);
    }

    private String checkNamespace(String namespaceUri) {
        for (int i = this.elementStack.size() - 1; i >= 0; i--) {
            for (XmlNamespace ns : ((Element) this.elementStack.get(i)).nsDecls) {
                if (ns.alias != null && ns.uri.equals(namespaceUri)) {
                    return ns.alias;
                }
            }
        }
        return null;
    }

    private boolean isPrettyPrintingEnabled() {
        return (!this.flags.contains(WriterFlags.PRETTY_PRINT) || currentElement().unformattedChildren) ? $assertionsDisabled : true;
    }

    private int getIndentationLevel() {
        return this.elementStack.size() - 2;
    }

    private void writeNewline() throws IOException {
        this.writer.write("\n");
    }

    private void writeIndentation() throws IOException {
        writeUnitsOfIndentation(getIndentationLevel());
    }

    private void writeUnitsOfIndentation(int i) throws IOException {
        while (i > 0) {
            this.writer.write(INDENTATION_UNIT);
            i--;
        }
    }

    protected String ensureNamespace(XmlNamespace namespace) {
        if (namespace.uri.equals(this.defaultNamespace)) {
            return null;
        }
        String alias = checkNamespace(namespace.uri);
        if (alias != null) {
            return alias;
        }
        Element current = currentElement();
        namespace = ensureUniqueNamespaceAlias(current, namespace);
        current.addNamespace(namespace);
        return namespace.alias;
    }

    private XmlNamespace ensureUniqueNamespaceAlias(Element element, XmlNamespace namespace) {
        int serial = 0;
        boolean unique;
        do {
            unique = true;
            for (XmlNamespace ns : element.nsDecls) {
                if (namespace.alias.equals(ns.alias)) {
                    unique = $assertionsDisabled;
                    serial++;
                    namespace = new XmlNamespace("ns" + String.valueOf(serial), namespace.uri);
                    break;
                    continue;
                }
            }
        } while (!unique);
        return namespace;
    }

    protected String getNamespaceUri(String nsAlias) {
        if (nsAlias == null) {
            return this.defaultNamespace;
        }
        for (int i = this.elementStack.size() - 1; i >= 0; i--) {
            for (XmlNamespace ns : ((Element) this.elementStack.get(i)).nsDecls) {
                if (ns.getAlias().equals(nsAlias)) {
                    return ns.getUri();
                }
            }
        }
        return null;
    }

    protected void writeBeginOutput() throws IOException {
    }

    protected void writeEndOutput() throws IOException {
    }

    protected void writeHeader(String enc) throws IOException {
        this.writer.write("<?xml");
        writeAttribute(OutputKeys.VERSION, XMLStreamWriterImpl.DEFAULT_XML_VERSION);
        if (enc != null) {
            writeAttribute(OutputKeys.ENCODING, enc);
        }
        if (this.standalone != null) {
            writeAttribute(OutputKeys.STANDALONE, this.standalone.booleanValue() ? "yes" : "no");
        }
        this.writer.write("?>");
    }

    protected void writeFooter() throws IOException {
    }

    protected void writeQualifiedName(String nsAlias, String name) throws IOException {
        if (nsAlias != null && nsAlias.length() > 0) {
            this.writer.write(nsAlias);
            this.writer.write(58);
        }
        this.writer.write(name);
    }

    protected void writeOpenTagStart(String nsAlias, String name) throws IOException {
        if (isPrettyPrintingEnabled()) {
            if (getIndentationLevel() > 0 || this.flags.contains(WriterFlags.WRITE_HEADER)) {
                writeNewline();
            }
            writeIndentation();
        }
        this.writer.write(60);
        writeQualifiedName(nsAlias, name);
    }

    protected void writeOpenTagEnd() throws IOException {
        this.writer.write(62);
    }

    protected void writeCloseTag(String nsAlias, String name) throws IOException {
        if (currentElement().openTagEnded) {
            if (isPrettyPrintingEnabled()) {
                writeNewline();
                writeIndentation();
            }
            this.writer.write(XMLStreamWriterImpl.OPEN_END_TAG);
            writeQualifiedName(nsAlias, name);
            this.writer.write(">");
            return;
        }
        this.writer.write(XMLStreamWriterImpl.CLOSE_EMPTY_ELEMENT);
    }

    protected void writeAttribute(String name, String value) throws IOException {
        writeAttribute(null, name, value);
    }

    protected void writeAttribute(String nsAlias, String name, String value) throws IOException {
        this.writer.write(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        writeQualifiedName(nsAlias, name);
        this.writer.write(61);
        this.writer.write(39);
        if (value != null) {
            this.writer.write(StringUtil.xmlEscape(value));
        }
        this.writer.write(39);
    }

    public void characters(String s) throws IOException {
        characters(s, $assertionsDisabled);
    }

    public void characters(String s, boolean useCData) throws IOException {
        if (s != null) {
            String escaped;
            endOpenTag();
            currentElement().unformattedChildren = true;
            if (useCData) {
                escaped = XMLStreamWriterImpl.START_CDATA + StringUtil.xmlCDataEscape(s) + XMLStreamWriterImpl.END_CDATA;
            } else {
                escaped = StringUtil.xmlContentEscape(s);
            }
            this.writer.write(escaped);
        }
    }

    public void innerXml(String xml) throws IOException {
        if (xml != null) {
            writeUnescaped(xml);
        }
    }

    public void writeUnescaped(String s) throws IOException {
        endOpenTag();
        currentElement().unformattedChildren = true;
        this.writer.write(s);
    }
}
