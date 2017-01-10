package com.google.gdata.model.gd;

import com.google.gdata.client.GDataProtocol.Parameter;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.QName;

public class GdAttributes {
    public static final AttributeKey<String> ETAG;
    public static final AttributeKey<String> FIELDS;
    public static final AttributeKey<String> KIND;

    static {
        ETAG = AttributeKey.of(new QName(Namespaces.gNs, "etag"));
        KIND = AttributeKey.of(new QName(Namespaces.gNs, "kind"));
        FIELDS = AttributeKey.of(new QName(Namespaces.gNs, Parameter.FIELDS));
    }
}
