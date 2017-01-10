package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;

public interface Attribute extends XMLEvent {
    String getDTDType();

    QName getName();

    String getValue();

    boolean isSpecified();
}
