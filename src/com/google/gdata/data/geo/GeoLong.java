package com.google.gdata.data.geo;

import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;
import java.text.NumberFormat;

@Default(localName = "long", nsAlias = "geo", nsUri = "http://www.w3.org/2003/01/geo/wgs84_pos#")
public class GeoLong extends ValueConstruct {
    public static final int COORDINATE_PRECISION = 6;
    public static final double MAX_LONG = 180.0d;
    public static final double MIN_LONG = -180.0d;
    private static final NumberFormat NUM_FORMAT;
    private Double lon;

    static {
        NUM_FORMAT = NumberFormat.getInstance();
        NUM_FORMAT.setMaximumFractionDigits(COORDINATE_PRECISION);
        NUM_FORMAT.setMinimumFractionDigits(COORDINATE_PRECISION);
    }

    public GeoLong() {
        this(null);
    }

    public GeoLong(Double lon) throws IllegalArgumentException {
        super(Namespaces.W3C_GEO_NAMESPACE, "long", null, null);
        this.lon = null;
        setRequired(true);
        if (lon != null) {
            setLongitude(lon);
            setImmutable(true);
        }
    }

    public Double getLongitude() {
        return this.lon;
    }

    public void setLongitude(Double longitude) {
        this.lon = longitude;
        String value = null;
        if (longitude != null) {
            if (longitude.compareTo(Double.valueOf(MIN_LONG)) < 0 || longitude.compareTo(Double.valueOf(MAX_LONG)) > 0) {
                throw new IllegalArgumentException("Longitude must be between -180 and 180 degrees.");
            }
            value = NUM_FORMAT.format(longitude);
        }
        super.setValue(value);
    }

    public void setValue(String value) {
        Double d = null;
        if (value != null) {
            try {
                d = Double.valueOf(Double.parseDouble(value));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("'value' must be a double.");
            }
        }
        setLongitude(d);
    }
}
