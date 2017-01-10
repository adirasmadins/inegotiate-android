package com.google.gdata.model;

import com.google.gdata.model.ElementMetadata.MultipleVirtualElement;
import com.google.gdata.model.ElementMetadata.SingleVirtualElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.codehaus.jackson.impl.JsonWriteContext;

class ElementIterator implements Iterator<Element> {
    private final Element element;
    private Iterator<Object> elementIterator;
    private final Map<QName, Object> elements;
    private final ElementMetadata<?, ?> metadata;
    private Iterator<ElementKey<?, ?>> metadataIterator;
    private Mode mode;
    private Element nextElement;
    private Iterator<? extends Element> sublistIterator;

    /* renamed from: com.google.gdata.model.ElementIterator.1 */
    static /* synthetic */ class C07341 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gdata$model$ElementIterator$Mode;

        static {
            $SwitchMap$com$google$gdata$model$ElementIterator$Mode = new int[Mode.values().length];
            try {
                $SwitchMap$com$google$gdata$model$ElementIterator$Mode[Mode.DECLARED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$gdata$model$ElementIterator$Mode[Mode.UNDECLARED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private enum Mode {
        DECLARED,
        UNDECLARED,
        DONE
    }

    ElementIterator(Element element, ElementMetadata<?, ?> metadata, Map<QName, Object> elements) {
        Iterator it = null;
        this.mode = Mode.DECLARED;
        this.element = element;
        this.metadata = metadata;
        this.elements = elements;
        this.metadataIterator = metadata == null ? null : metadata.getElements().iterator();
        if (elements != null) {
            it = elements.values().iterator();
        }
        this.elementIterator = it;
        this.nextElement = findNextElement();
    }

    public boolean hasNext() {
        return this.nextElement != null;
    }

    public Element next() {
        if (this.nextElement == null) {
            throw new NoSuchElementException("No remaining elements");
        }
        Element retval = this.nextElement;
        this.nextElement = findNextElement();
        return retval;
    }

    public void remove() {
        throw new UnsupportedOperationException("Removal not supported on element iterator");
    }

    private Element findNextElement() {
        if (this.sublistIterator != null) {
            if (this.sublistIterator.hasNext()) {
                return (Element) this.sublistIterator.next();
            }
            this.sublistIterator = null;
        }
        Element next = null;
        while (next == null && this.mode != Mode.DONE) {
            switch (C07341.$SwitchMap$com$google$gdata$model$ElementIterator$Mode[this.mode.ordinal()]) {
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    next = findNextDeclaredElement();
                    break;
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                    next = findNextUndeclaredElement();
                    break;
                default:
                    break;
            }
        }
        return next;
    }

    private Element findNextDeclaredElement() {
        if (this.metadataIterator != null) {
            while (this.metadataIterator.hasNext()) {
                ElementKey<?, ?> nextKey = (ElementKey) this.metadataIterator.next();
                if (ElementCreatorImpl.ELEMENT_MARKER == nextKey) {
                    this.mode = Mode.UNDECLARED;
                    return null;
                }
                ElementMetadata<?, ?> childMeta = this.metadata.bindElement(nextKey);
                if (childMeta.isVisible()) {
                    SingleVirtualElement singleVirtual = childMeta.getSingleVirtualElement();
                    if (singleVirtual != null) {
                        Element generated = singleVirtual.generateSingle(this.element, this.metadata, childMeta);
                        if (generated != null) {
                            return generated;
                        }
                    }
                    MultipleVirtualElement multipleVirtual = childMeta.getMultipleVirtualElement();
                    if (multipleVirtual != null) {
                        Collection<? extends Element> virtualElements = multipleVirtual.generateMultiple(this.element, this.metadata, childMeta);
                        if (!(virtualElements == null || virtualElements.isEmpty())) {
                            this.sublistIterator = virtualElements.iterator();
                            return (Element) this.sublistIterator.next();
                        }
                    }
                    Element first = firstElement(getElementObject(nextKey.getId()));
                    if (first != null) {
                        return first;
                    }
                }
            }
            this.metadataIterator = null;
        }
        this.mode = Mode.UNDECLARED;
        return null;
    }

    private Element findNextUndeclaredElement() {
        if (this.elementIterator != null) {
            while (this.elementIterator.hasNext()) {
                Element first = firstElement(this.elementIterator.next());
                if (first != null && isUndeclared(first.getElementKey())) {
                    return first;
                }
                this.sublistIterator = null;
            }
            this.sublistIterator = null;
            this.elementIterator = null;
        }
        Mode mode = (this.metadataIterator == null || !this.metadataIterator.hasNext()) ? Mode.DONE : Mode.DECLARED;
        this.mode = mode;
        return null;
    }

    private Element firstElement(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Element) {
            return (Element) obj;
        }
        Collection<Element> elementCollection = castElementCollection(obj);
        if (elementCollection.isEmpty()) {
            return null;
        }
        this.sublistIterator = elementCollection.iterator();
        return (Element) this.sublistIterator.next();
    }

    private <T extends Element> Collection<T> castElementCollection(Object obj) {
        return (Collection) obj;
    }

    private Object getElementObject(QName id) {
        return this.elements != null ? this.elements.get(id) : null;
    }

    private boolean isUndeclared(ElementKey<?, ?> key) {
        return this.metadata == null || !this.metadata.isDeclared((ElementKey) key);
    }
}
