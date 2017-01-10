package com.google.gdata.data.geo.impl;

import com.google.gdata.data.ValueConstruct;
import com.google.gdata.data.geo.GeoLat;
import com.google.gdata.data.geo.GeoLong;
import com.google.gdata.data.geo.Point;
import com.google.gdata.util.common.xml.XmlNamespace;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public abstract class PointConstruct extends ValueConstruct implements Point {
    private Double lat;
    private Double lon;

    public PointConstruct(XmlNamespace namespace, String name) {
        super(namespace, name, null);
        setRequired(false);
    }

    public PointConstruct(XmlNamespace namespace, String name, Double lat, Double lon) {
        super(namespace, name, null);
        if (lat == null && lon == null) {
            setRequired(false);
        }
        setGeoLocation(lat, lon);
    }

    public PointConstruct(XmlNamespace namespace, String name, Point copyFrom) {
        Double d = null;
        Double latitude = copyFrom == null ? null : copyFrom.getLatitude();
        if (copyFrom != null) {
            d = copyFrom.getLongitude();
        }
        this(namespace, name, latitude, d);
    }

    public Double getLatitude() {
        return this.lat;
    }

    public Double getLongitude() {
        return this.lon;
    }

    public void setGeoLocation(Double lat, Double lon) {
        if (lat == null || lon == null) {
            if (!(lat == null && lon == null)) {
                throw new IllegalArgumentException("latitude and longitude must either both be null or non-null.");
            }
        } else if (lat.compareTo(Double.valueOf(GeoLat.MIN_LAT)) < 0 || lat.compareTo(Double.valueOf(GeoLat.MAX_LAT)) > 0) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90 degrees.");
        } else if (lon.compareTo(Double.valueOf(GeoLong.MIN_LONG)) < 0 || lon.compareTo(Double.valueOf(GeoLong.MAX_LONG)) > 0) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180 degrees.");
        }
        this.lat = lat;
        this.lon = lon;
        super.setValue(toString());
    }

    public String toString() {
        if (this.lat == null || this.lon == null) {
            return null;
        }
        return this.lat + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.lon;
    }

    public void setValue(String v) {
        Double lat = null;
        Double lon = null;
        if (v != null) {
            v = v.trim();
            int space = v.indexOf(32);
            if (space == -1) {
                throw createInvalidValueException();
            }
            String latString = v.substring(0, space);
            String lonString = v.substring(space + 1);
            try {
                lat = Double.valueOf(latString);
                lon = Double.valueOf(lonString);
            } catch (NumberFormatException e) {
                throw createInvalidValueException();
            }
        }
        setGeoLocation(lat, lon);
    }

    protected void validate() throws IllegalStateException {
        super.validate();
        if ((this.lat == null && this.lon != null) || (this.lat != null && this.lon == null)) {
            throw new IllegalStateException("latitude and longitude must either both be null or non-null.");
        }
    }

    private IllegalArgumentException createInvalidValueException() {
        return new IllegalArgumentException("Format of a coordinate is \"latitude longitude\", where latitude and longitude are doubles, separated by a space.");
    }
}
