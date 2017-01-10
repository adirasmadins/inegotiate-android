package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import java.io.Writer;
import java.util.Date;
import java.util.Stack;

public class XMLWriter {
    private static final String PROLOG = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private Stack<String> elementStack;
    private boolean rootElement;
    private final Writer writer;
    private final String xmlns;

    public XMLWriter(Writer writer) {
        this(writer, null);
    }

    public XMLWriter(Writer writer, String str) {
        this.elementStack = new Stack();
        this.rootElement = true;
        this.writer = writer;
        this.xmlns = str;
        append(PROLOG);
    }

    private void append(String str) {
        try {
            this.writer.append(str);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to write XML document", e);
        }
    }

    public XMLWriter endElement() {
        append(XMLStreamWriterImpl.OPEN_END_TAG + ((String) this.elementStack.pop()) + ">");
        return this;
    }

    public XMLWriter startElement(String str) {
        append("<" + str);
        if (this.rootElement && this.xmlns != null) {
            append(" xmlns=\"" + this.xmlns + "\"");
            this.rootElement = false;
        }
        append(">");
        this.elementStack.push(str);
        return this;
    }

    public XMLWriter value(Object obj) {
        append(obj.toString());
        return this;
    }

    public XMLWriter value(String str) {
        append(str);
        return this;
    }

    public XMLWriter value(Date date) {
        append(StringUtils.fromDate(date));
        return this;
    }
}
