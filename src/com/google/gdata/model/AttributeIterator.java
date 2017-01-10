package com.google.gdata.model;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import org.codehaus.jackson.impl.JsonWriteContext;

class AttributeIterator implements Iterator<Attribute> {
    private Iterator<Entry<QName, Attribute>> attributeIterator;
    private final Element element;
    private final ElementMetadata<?, ?> metadata;
    private Iterator<AttributeKey<?>> metadataIterator;
    private Mode mode;
    private Attribute nextAttribute;

    /* renamed from: com.google.gdata.model.AttributeIterator.1 */
    static /* synthetic */ class C07321 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gdata$model$AttributeIterator$Mode;

        static {
            $SwitchMap$com$google$gdata$model$AttributeIterator$Mode = new int[Mode.values().length];
            try {
                $SwitchMap$com$google$gdata$model$AttributeIterator$Mode[Mode.DECLARED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$gdata$model$AttributeIterator$Mode[Mode.UNDECLARED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private enum Mode {
        DECLARED,
        UNDECLARED,
        DONE
    }

    AttributeIterator(Element element, ElementMetadata<?, ?> metadata, Map<QName, Attribute> attributes) {
        Iterator it = null;
        this.mode = Mode.DECLARED;
        this.element = element;
        this.metadata = metadata;
        this.metadataIterator = metadata == null ? null : metadata.getAttributes().iterator();
        if (attributes != null) {
            it = attributes.entrySet().iterator();
        }
        this.attributeIterator = it;
        this.nextAttribute = findNextAttribute();
    }

    public boolean hasNext() {
        return this.nextAttribute != null;
    }

    public Attribute next() {
        if (this.nextAttribute == null) {
            throw new NoSuchElementException("No remaining attributes");
        }
        Attribute retVal = this.nextAttribute;
        this.nextAttribute = findNextAttribute();
        return retVal;
    }

    public void remove() {
        throw new UnsupportedOperationException("Removal not supported on attribute iterator");
    }

    private Attribute findNextAttribute() {
        Attribute next = null;
        while (next == null && this.mode != Mode.DONE) {
            switch (C07321.$SwitchMap$com$google$gdata$model$AttributeIterator$Mode[this.mode.ordinal()]) {
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    next = findNextDeclaredAttribute();
                    break;
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                    next = findNextUndeclaredAttribute();
                    break;
                default:
                    break;
            }
        }
        return next;
    }

    private Attribute findNextDeclaredAttribute() {
        if (this.metadataIterator != null) {
            while (this.metadataIterator.hasNext()) {
                AttributeKey<?> nextKey = (AttributeKey) this.metadataIterator.next();
                if (ElementCreatorImpl.ATTRIBUTE_MARKER == nextKey) {
                    this.mode = Mode.UNDECLARED;
                    return null;
                }
                AttributeMetadata<?> attMeta = this.metadata.bindAttribute(nextKey);
                if (attMeta.isVisible()) {
                    Object value = attMeta.generateValue(this.element, this.metadata);
                    if (value != null) {
                        return new Attribute(nextKey, value);
                    }
                }
            }
            this.metadataIterator = null;
        }
        this.mode = Mode.UNDECLARED;
        return null;
    }

    private Attribute findNextUndeclaredAttribute() {
        if (this.attributeIterator != null) {
            while (this.attributeIterator.hasNext()) {
                Entry<QName, Attribute> entry = (Entry) this.attributeIterator.next();
                if (isUndeclared(((Attribute) entry.getValue()).getAttributeKey())) {
                    return (Attribute) entry.getValue();
                }
            }
            this.attributeIterator = null;
        }
        Mode mode = (this.metadataIterator == null || !this.metadataIterator.hasNext()) ? Mode.DONE : Mode.DECLARED;
        this.mode = mode;
        return null;
    }

    private boolean isUndeclared(AttributeKey<?> key) {
        return this.metadata == null || !this.metadata.isDeclared((AttributeKey) key);
    }
}
