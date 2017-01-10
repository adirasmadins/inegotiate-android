package com.amazonaws.javax.xml.stream.xerces.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class XMLAttributesIteratorImpl extends XMLAttributesImpl implements Iterator {
    protected int fCurrent;
    protected Attribute fLastReturnedItem;

    public XMLAttributesIteratorImpl() {
        this.fCurrent = 0;
    }

    public boolean hasNext() {
        return this.fCurrent < getLength();
    }

    public Object next() {
        if (hasNext()) {
            Attribute[] attributeArr = this.fAttributes;
            int i = this.fCurrent;
            this.fCurrent = i + 1;
            Attribute attribute = attributeArr[i];
            this.fLastReturnedItem = attribute;
            return attribute;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.fLastReturnedItem == this.fAttributes[this.fCurrent - 1]) {
            int i = this.fCurrent;
            this.fCurrent = i - 1;
            removeAttributeAt(i);
            return;
        }
        throw new IllegalStateException();
    }

    public void removeAllAttributes() {
        super.removeAllAttributes();
        this.fCurrent = 0;
    }
}
