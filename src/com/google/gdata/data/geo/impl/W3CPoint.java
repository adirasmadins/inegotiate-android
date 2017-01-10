package com.google.gdata.data.geo.impl;

import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.geo.GeoLat;
import com.google.gdata.data.geo.GeoLong;
import com.google.gdata.data.geo.Namespaces;
import com.google.gdata.data.geo.Point;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import org.xml.sax.Attributes;

public class W3CPoint extends ExtensionPoint implements Point {
    static final String NAME = "Point";

    protected class Handler extends ExtensionHandler {
        public Handler(ExtensionProfile extProfile) {
            super(W3CPoint.this, extProfile, W3CPoint.class);
        }

        public void processEndElement() throws ParseException {
            super.processEndElement();
            Extension lat = W3CPoint.this.getExtension(GeoLat.class);
            Extension lon = W3CPoint.this.getExtension(GeoLong.class);
            if (lat != null || lon != null) {
                if (lat == null) {
                    throw new ParseException("All geo:Point elements must have a latitude coordinate.");
                } else if (lon == null) {
                    throw new ParseException("All geo:Point elements must have a longitude coordinate.");
                }
            }
        }
    }

    public W3CPoint(Double lat, Double lon) {
        setGeoLocation(lat, lon);
    }

    public W3CPoint(Point copyFrom) {
        Double d = null;
        Double latitude = copyFrom == null ? null : copyFrom.getLatitude();
        if (copyFrom != null) {
            d = copyFrom.getLongitude();
        }
        this(latitude, d);
    }

    public static ExtensionDescription getDefaultDescription(boolean repeatable) {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(W3CPoint.class);
        desc.setNamespace(Namespaces.W3C_GEO_NAMESPACE);
        desc.setLocalName(NAME);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public static ExtensionDescription getDefaultDescription() {
        return getDefaultDescription(true);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declare(W3CPoint.class, ExtensionDescription.getDefaultDescription(GeoLat.class));
        extProfile.declare(W3CPoint.class, ExtensionDescription.getDefaultDescription(GeoLong.class));
        super.declareExtensions(extProfile);
    }

    public Double getLatitude() {
        GeoLat lat = (GeoLat) getExtension(GeoLat.class);
        return lat != null ? lat.getLatitude() : null;
    }

    public Double getLongitude() {
        GeoLong lon = (GeoLong) getExtension(GeoLong.class);
        return lon != null ? lon.getLongitude() : null;
    }

    public void setGeoLocation(Double lat, Double lon) {
        if (lat != null && lon != null) {
            setExtension(new GeoLat(lat));
            setExtension(new GeoLong(lon));
        } else if (lat == null && lon == null) {
            removeExtension(GeoLat.class);
            removeExtension(GeoLong.class);
        } else {
            throw new IllegalArgumentException("'lat' and 'lon' must either both be null or non-null.");
        }
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        generateStartElement(w, Namespaces.W3C_GEO_NAMESPACE, NAME, null, null);
        generateExtensions(w, extProfile);
        w.endElement(Namespaces.W3C_GEO_NAMESPACE, NAME);
    }

    public ElementHandler getHandler(ExtensionProfile extProfile, String namespace, String localName, Attributes attrs) {
        return new Handler(extProfile);
    }
}
