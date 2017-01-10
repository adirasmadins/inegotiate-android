package com.google.gdata.data.geo.impl;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.geo.Namespaces;
import com.google.gdata.data.geo.Point;

public class GmlLowerCorner extends PointConstruct {
    static final String NAME = "lowerCorner";

    public GmlLowerCorner() {
        super(Namespaces.GML_NAMESPACE, NAME);
    }

    public GmlLowerCorner(Double lat, Double lon) {
        super(Namespaces.GML_NAMESPACE, NAME, lat, lon);
    }

    public GmlLowerCorner(Point copyFrom) {
        super(Namespaces.GML_NAMESPACE, NAME, copyFrom);
    }

    public static ExtensionDescription getDefaultDescription(boolean repeatable) {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(GmlLowerCorner.class);
        desc.setNamespace(Namespaces.GML_NAMESPACE);
        desc.setLocalName(NAME);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public static ExtensionDescription getDefaultDescription() {
        return getDefaultDescription(true);
    }
}
