package com.google.gdata.data.geo.impl;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.geo.Box;
import com.google.gdata.data.geo.Namespaces;
import com.google.gdata.data.geo.Point;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;

public class GeoRssWhere extends ExtensionPoint implements Point, Box {
    static final String NAME = "where";

    public GeoRssWhere(Double lat, Double lon) {
        this(new GmlPoint(lat, lon));
    }

    public GeoRssWhere(Point point) {
        if (point != null) {
            if (!(point instanceof GmlPoint)) {
                point = new GmlPoint(point);
            }
            setExtension(point);
        }
    }

    public GeoRssWhere(Double lowerLat, Double lowerLon, Double upperLat, Double upperLon) {
        this(new GmlEnvelope(lowerLat, lowerLon, upperLat, upperLon));
    }

    public GeoRssWhere(Point lower, Point upper) {
        this(new GmlEnvelope(lower, upper));
    }

    public GeoRssWhere(Box box) {
        if (box != null) {
            if (!(box instanceof GmlEnvelope)) {
                box = new GmlEnvelope(box);
            }
            setExtension(box);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean repeatable) {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(GeoRssWhere.class);
        desc.setNamespace(Namespaces.GEO_RSS_NAMESPACE);
        desc.setLocalName(NAME);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public static ExtensionDescription getDefaultDescription() {
        return getDefaultDescription(true);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declare(GeoRssWhere.class, GmlPoint.getDefaultDescription(false));
        new GmlPoint().declareExtensions(extProfile);
        extProfile.declare(GeoRssWhere.class, GmlEnvelope.getDefaultDescription(false));
        new GmlEnvelope().declareExtensions(extProfile);
        super.declareExtensions(extProfile);
    }

    public Double getLatitude() {
        GmlPoint point = (GmlPoint) getExtension(GmlPoint.class);
        return point != null ? point.getLatitude() : null;
    }

    public Double getLongitude() {
        GmlPoint point = (GmlPoint) getExtension(GmlPoint.class);
        return point != null ? point.getLongitude() : null;
    }

    public void setGeoLocation(Double lat, Double lon) {
        GmlPoint point = (GmlPoint) getExtension(GmlPoint.class);
        if (point != null) {
            point.setGeoLocation(lat, lon);
        } else if (lat != null || lon != null) {
            point = new GmlPoint();
            setExtension(point);
            point.setGeoLocation(lat, lon);
        }
    }

    public GmlLowerCorner getLowerLeft() {
        GmlEnvelope envelope = (GmlEnvelope) getExtension(GmlEnvelope.class);
        return envelope != null ? envelope.getLowerLeft() : null;
    }

    public GmlUpperCorner getUpperRight() {
        GmlEnvelope envelope = (GmlEnvelope) getExtension(GmlEnvelope.class);
        return envelope != null ? envelope.getUpperRight() : null;
    }

    public void setGeoLocation(Point lowerLeft, Point upperRight) {
        GmlEnvelope envelope = (GmlEnvelope) getExtension(GmlEnvelope.class);
        if (envelope != null) {
            envelope.setGeoLocation(lowerLeft, upperRight);
        } else if (lowerLeft != null || upperRight != null) {
            envelope = new GmlEnvelope();
            setExtension(envelope);
            envelope.setGeoLocation(lowerLeft, upperRight);
        }
    }

    public boolean hasPoint() {
        return getExtension(GmlPoint.class) != null;
    }

    public boolean hasBox() {
        return getExtension(GmlEnvelope.class) != null;
    }

    public void clearPoint() {
        removeExtension(GmlPoint.class);
    }

    public void clearBox() {
        removeExtension(GmlEnvelope.class);
    }

    public void generate(XmlWriter w, ExtensionProfile p) throws IOException {
        generateStartElement(w, Namespaces.GEO_RSS_NAMESPACE, NAME, null, null);
        generateExtensions(w, p);
        w.endElement(Namespaces.GEO_RSS_NAMESPACE, NAME);
    }
}
