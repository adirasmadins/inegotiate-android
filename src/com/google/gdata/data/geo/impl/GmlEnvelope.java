package com.google.gdata.data.geo.impl;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.geo.Box;
import com.google.gdata.data.geo.Namespaces;
import com.google.gdata.data.geo.Point;

@Default(localName = "Envelope", nsAlias = "gml", nsUri = "http://www.opengis.net/gml")
public class GmlEnvelope extends ExtensionPoint implements Box {
    static final String NAME = "Envelope";

    public GmlEnvelope(Double lowerLat, Double lowerLon, Double upperLat, Double upperLon) {
        this(new GmlLowerCorner(lowerLat, lowerLon), new GmlUpperCorner(upperLat, upperLon));
    }

    public GmlEnvelope(Point lower, Point upper) {
        setGeoLocation(lower, upper);
    }

    public GmlEnvelope(Box box) {
        Point point = null;
        Point lowerLeft = box == null ? null : box.getLowerLeft();
        if (box != null) {
            point = box.getUpperRight();
        }
        this(lowerLeft, point);
    }

    public static ExtensionDescription getDefaultDescription(boolean repeatable) {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(GmlEnvelope.class);
        desc.setNamespace(Namespaces.GML_NAMESPACE);
        desc.setLocalName(NAME);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public static ExtensionDescription getDefaultDescription() {
        return getDefaultDescription(true);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declare(GmlEnvelope.class, GmlLowerCorner.getDefaultDescription(false));
        extProfile.declare(GmlEnvelope.class, GmlUpperCorner.getDefaultDescription(false));
        super.declareExtensions(extProfile);
    }

    public GmlLowerCorner getLowerLeft() {
        return (GmlLowerCorner) getExtension(GmlLowerCorner.class);
    }

    public GmlUpperCorner getUpperRight() {
        return (GmlUpperCorner) getExtension(GmlUpperCorner.class);
    }

    public void setGeoLocation(Point lowerLeft, Point upperRight) {
        if (lowerLeft != null && upperRight != null) {
            if (!(lowerLeft instanceof GmlLowerCorner)) {
                lowerLeft = new GmlLowerCorner(lowerLeft);
            }
            if (!(upperRight instanceof GmlUpperCorner)) {
                upperRight = new GmlUpperCorner(upperRight);
            }
            setExtension(lowerLeft);
            setExtension(upperRight);
        } else if (lowerLeft == null && upperRight == null) {
            removeExtension(GmlLowerCorner.class);
            removeExtension(GmlUpperCorner.class);
        } else {
            throw new IllegalArgumentException("'lower' and 'upper' must either both be null or non-null.");
        }
    }

    public void setUpperRight(Point upperRight) {
        if (upperRight == null) {
            removeExtension(GmlUpperCorner.class);
            return;
        }
        if (!(upperRight instanceof GmlUpperCorner)) {
            upperRight = new GmlUpperCorner(upperRight);
        }
        setExtension(upperRight);
    }

    protected void validate() throws IllegalStateException {
        super.validate();
        Point lower = getLowerLeft();
        Point upper = getUpperRight();
        if ((lower != null && upper == null) || (lower == null && upper != null)) {
            throw new IllegalStateException("Both upper and lower must be set or neither may be set.");
        }
    }
}
