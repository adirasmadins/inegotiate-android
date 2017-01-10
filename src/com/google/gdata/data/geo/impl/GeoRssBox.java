package com.google.gdata.data.geo.impl;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;
import com.google.gdata.data.geo.Box;
import com.google.gdata.data.geo.Namespaces;
import com.google.gdata.data.geo.Point;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class GeoRssBox extends ValueConstruct implements Box {
    static final String NAME = "box";
    private Point lowerLeft;
    private Point upperRight;

    public GeoRssBox() {
        this(null, null);
    }

    public GeoRssBox(Double lowerLat, Double lowerLon, Double upperLat, Double upperLon) {
        this(new GeoRssPoint(lowerLat, lowerLon), new GeoRssPoint(upperLat, upperLon));
    }

    public GeoRssBox(Point lowerLeft, Point upperRight) {
        super(Namespaces.GEO_RSS_NAMESPACE, NAME, null);
        if (lowerLeft == null && upperRight == null) {
            setRequired(false);
        }
        setGeoLocation(lowerLeft, upperRight);
    }

    public GeoRssBox(Box box) {
        Point point = null;
        Point lowerLeft = box == null ? null : box.getLowerLeft();
        if (box != null) {
            point = box.getUpperRight();
        }
        this(lowerLeft, point);
    }

    public static ExtensionDescription getDefaultDescription(boolean repeatable) {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(GeoRssBox.class);
        desc.setNamespace(Namespaces.GEO_RSS_NAMESPACE);
        desc.setLocalName(NAME);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public static ExtensionDescription getDefaultDescription() {
        return getDefaultDescription(true);
    }

    public Point getLowerLeft() {
        return this.lowerLeft;
    }

    public Point getUpperRight() {
        return this.upperRight;
    }

    public void setGeoLocation(Point lowerLeft, Point upperRight) {
        if (lowerLeft == null || upperRight == null) {
            if (!(lowerLeft == null && upperRight == null)) {
                throw new IllegalArgumentException("'lowerLeft' and 'upperRight' must either both be null or non-null.");
            }
        } else if (lowerLeft.getLatitude().doubleValue() > upperRight.getLatitude().doubleValue()) {
            throw new IllegalArgumentException("'lowerLeft' must be below 'upperRight'.");
        }
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
        super.setValue(toString());
    }

    public String toString() {
        if (this.lowerLeft == null || this.upperRight == null) {
            return null;
        }
        return this.lowerLeft.getLatitude() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.lowerLeft.getLongitude() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.upperRight.getLatitude() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.upperRight.getLongitude();
    }

    public void setValue(String v) {
        Point lower = null;
        Point upper = null;
        if (v != null) {
            String[] values = v.trim().split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            if (values.length != 4) {
                throw createInvalidValueException();
            }
            lower = getPoint(values[0], values[1]);
            upper = getPoint(values[2], values[3]);
        }
        setGeoLocation(lower, upper);
    }

    private Point getPoint(String latStr, String lonStr) {
        try {
            return new GeoRssPoint(Double.valueOf(latStr), Double.valueOf(lonStr));
        } catch (NumberFormatException e) {
            throw createInvalidValueException();
        }
    }

    private IllegalArgumentException createInvalidValueException() {
        return new IllegalArgumentException("Format of a georss:box is \"latitude longitude latitude longitutde\", where the first pair is the lower left point, and the second pair is the upper right point.  All values must be doubles, separated by spaces.");
    }
}
