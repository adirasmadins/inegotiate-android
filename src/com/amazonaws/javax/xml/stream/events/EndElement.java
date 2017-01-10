package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;
import java.util.Iterator;

public interface EndElement extends XMLEvent {
    QName getName();

    Iterator getNamespaces();
}
