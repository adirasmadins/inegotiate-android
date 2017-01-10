package com.google.gdata.data.geo.impl;

import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.geo.Namespaces;
import com.google.gdata.data.geo.Point;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;

@Default(localName = "Point", nsAlias = "gml", nsUri = "http://www.opengis.net/gml")
public class GmlPoint extends ExtensionPoint implements Point {
    static final String NAME = "Point";

    public GmlPoint(Double lat, Double lon) {
        this(new GmlPos(lat, lon));
    }

    public GmlPoint(Point point) {
        if (point != null) {
            if (!(point instanceof GmlPos)) {
                point = new GmlPos(point);
            }
            setExtension(point);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean repeatable) {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(GmlPoint.class);
        desc.setNamespace(Namespaces.GML_NAMESPACE);
        desc.setLocalName(NAME);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public static ExtensionDescription getDefaultDescription() {
        return getDefaultDescription(true);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declare(GmlPoint.class, GmlPos.getDefaultDescription(false));
        super.declareExtensions(extProfile);
    }

    public Double getLatitude() {
        GmlPos coord = (GmlPos) getExtension(GmlPos.class);
        return coord != null ? coord.getLatitude() : null;
    }

    public Double getLongitude() {
        GmlPos coord = (GmlPos) getExtension(GmlPos.class);
        return coord != null ? coord.getLongitude() : null;
    }

    public void setGeoLocation(Double lat, Double lon) {
        GmlPos point = (GmlPos) getExtension(GmlPos.class);
        if (point != null) {
            if (lat == null && lon == null) {
                removeExtension((Extension) point);
            } else {
                point.setGeoLocation(lat, lon);
            }
        } else if (lat != null || lon != null) {
            point = new GmlPos();
            setExtension(point);
            point.setGeoLocation(lat, lon);
        }
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        generateStartElement(w, Namespaces.GML_NAMESPACE, NAME, null, null);
        generateExtensions(w, extProfile);
        w.endElement(Namespaces.GML_NAMESPACE, NAME);
    }
}
