package com.amazonaws.transform;

import com.amazonaws.javax.xml.stream.XMLEventReader;
import com.amazonaws.javax.xml.stream.XMLStreamException;
import com.amazonaws.javax.xml.stream.events.Attribute;
import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.google.gdata.util.common.base.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StaxUnmarshallerContext {
    private Iterator<?> attributeIterator;
    private XMLEvent currentEvent;
    private final XMLEventReader eventReader;
    private final Map<String, String> headers;
    private Map<String, String> metadata;
    private List<MetadataExpression> metadataExpressions;
    public final Stack<String> stack;
    private String stackString;

    private class MetadataExpression {
        public String expression;
        public String key;
        public int targetDepth;

        public MetadataExpression(String str, int i, String str2) {
            this.expression = str;
            this.targetDepth = i;
            this.key = str2;
        }
    }

    public StaxUnmarshallerContext(XMLEventReader xMLEventReader) {
        this(xMLEventReader, null);
    }

    public StaxUnmarshallerContext(XMLEventReader xMLEventReader, Map<String, String> map) {
        this.stack = new Stack();
        this.stackString = StringUtil.EMPTY_STRING;
        this.metadata = new HashMap();
        this.metadataExpressions = new ArrayList();
        this.eventReader = xMLEventReader;
        this.headers = map;
    }

    private void updateContext(XMLEvent xMLEvent) {
        if (xMLEvent != null) {
            Iterator it;
            if (xMLEvent.isEndElement()) {
                this.stack.pop();
                this.stackString = StringUtil.EMPTY_STRING;
                it = this.stack.iterator();
                while (it.hasNext()) {
                    this.stackString += "/" + ((String) it.next());
                }
            } else if (xMLEvent.isStartElement()) {
                this.stack.push(xMLEvent.asStartElement().getName().getLocalPart());
                this.stackString += "/" + xMLEvent.asStartElement().getName().getLocalPart();
            } else if (xMLEvent.isAttribute()) {
                Attribute attribute = (Attribute) xMLEvent;
                this.stackString = StringUtil.EMPTY_STRING;
                it = this.stack.iterator();
                while (it.hasNext()) {
                    this.stackString += "/" + ((String) it.next());
                }
                this.stackString += "/@" + attribute.getName().getLocalPart();
            }
        }
    }

    public int getCurrentDepth() {
        return this.stack.size();
    }

    public String getHeader(String str) {
        return this.headers == null ? null : (String) this.headers.get(str);
    }

    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    public boolean isStartOfDocument() throws XMLStreamException {
        return this.eventReader.peek().isStartDocument();
    }

    public XMLEvent nextEvent() throws XMLStreamException {
        if (this.attributeIterator == null || !this.attributeIterator.hasNext()) {
            this.currentEvent = this.eventReader.nextEvent();
        } else {
            this.currentEvent = (XMLEvent) this.attributeIterator.next();
        }
        if (this.currentEvent.isStartElement()) {
            this.attributeIterator = this.currentEvent.asStartElement().getAttributes();
        }
        updateContext(this.currentEvent);
        if (this.eventReader.hasNext()) {
            XMLEvent peek = this.eventReader.peek();
            if (peek != null && peek.isCharacters()) {
                for (MetadataExpression metadataExpression : this.metadataExpressions) {
                    if (testExpression(metadataExpression.expression, metadataExpression.targetDepth)) {
                        this.metadata.put(metadataExpression.key, peek.asCharacters().getData());
                    }
                }
            }
        }
        return this.currentEvent;
    }

    public String readText() throws XMLStreamException {
        if (this.currentEvent.isAttribute()) {
            return ((Attribute) this.currentEvent).getValue();
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            XMLEvent peek = this.eventReader.peek();
            if (peek.getEventType() != 4) {
                break;
            }
            this.eventReader.nextEvent();
            stringBuilder.append(peek.asCharacters().getData());
        }
        if (peek.getEventType() == 2) {
            return stringBuilder.toString();
        }
        throw new RuntimeException("Encountered unexpected event: " + peek.toString());
    }

    public void registerMetadataExpression(String str, int i, String str2) {
        this.metadataExpressions.add(new MetadataExpression(str, i, str2));
    }

    public boolean testExpression(String str) {
        return str.equals(".") ? true : this.stackString.endsWith(str);
    }

    public boolean testExpression(String str, int i) {
        if (str.equals(".")) {
            return true;
        }
        int i2 = -1;
        while (true) {
            i2 = str.indexOf("/", i2 + 1);
            if (i2 <= -1) {
                break;
            } else if (str.charAt(i2 + 1) != '@') {
                i++;
            }
        }
        boolean z = i == getCurrentDepth() && this.stackString.endsWith("/" + str);
        return z;
    }
}
