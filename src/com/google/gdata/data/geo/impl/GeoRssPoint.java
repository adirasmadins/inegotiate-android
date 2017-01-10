package com.google.gdata.data.geo.impl;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.geo.Namespaces;
import com.google.gdata.data.geo.Point;

public final class GeoRssPoint extends PointConstruct {
    static final String NAME = "point";

    public GeoRssPoint() {
        super(Namespaces.GEO_RSS_NAMESPACE, NAME);
    }

    public GeoRssPoint(Double lat, Double lon) {
        super(Namespaces.GEO_RSS_NAMESPACE, NAME, lat, lon);
    }

    public GeoRssPoint(Point copyFrom) {
        super(Namespaces.GEO_RSS_NAMESPACE, NAME, copyFrom);
    }

    public static ExtensionDescription getDefaultDescription(boolean repeatable) {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(GeoRssPoint.class);
        desc.setNamespace(Namespaces.GEO_RSS_NAMESPACE);
        desc.setLocalName(NAME);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public static ExtensionDescription getDefaultDescription() {
        return getDefaultDescription(true);
    }
}
