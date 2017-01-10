package com.amazonaws.javax.xml.stream.util;

import java.util.Iterator;

public class ReadOnlyIterator implements Iterator {
    Iterator iterator;

    public ReadOnlyIterator() {
        this.iterator = null;
    }

    public ReadOnlyIterator(Iterator itr) {
        this.iterator = null;
        this.iterator = itr;
    }

    public boolean hasNext() {
        if (this.iterator != null) {
            return this.iterator.hasNext();
        }
        return false;
    }

    public Object next() {
        if (this.iterator != null) {
            return this.iterator.next();
        }
        return null;
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported");
    }
}
