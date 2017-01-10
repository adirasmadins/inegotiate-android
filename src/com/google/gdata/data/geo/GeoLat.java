package com.google.gdata.data.geo;

import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;
import java.text.NumberFormat;

@Default(localName = "lat", nsAlias = "geo", nsUri = "http://www.w3.org/2003/01/geo/wgs84_pos#")
public class GeoLat extends ValueConstruct {
    public static final int COORDINATE_PRECISION = 6;
    public static final double MAX_LAT = 90.0d;
    public static final double MIN_LAT = -90.0d;
    private static final NumberFormat NUM_FORMAT;
    private Double lat;

    static {
        NUM_FORMAT = NumberFormat.getInstance();
        NUM_FORMAT.setMaximumFractionDigits(COORDINATE_PRECISION);
        NUM_FORMAT.setMinimumFractionDigits(COORDINATE_PRECISION);
    }

    public GeoLat() {
        this(null);
    }

    public GeoLat(Double lat) throws IllegalArgumentException {
        super(Namespaces.W3C_GEO_NAMESPACE, "lat", null, null);
        this.lat = null;
        setRequired(true);
        if (lat != null) {
            setLatitude(lat);
            setImmutable(true);
        }
    }

    public Double getLatitude() {
        return this.lat;
    }

    public void setLatitude(Double latitude) {
        this.lat = latitude;
        String value = null;
        if (latitude != null) {
            if (latitude.compareTo(Double.valueOf(MIN_LAT)) < 0 || latitude.compareTo(Double.valueOf(MAX_LAT)) > 0) {
                throw new IllegalArgumentException("Latitude must be between -90 and 90 degrees.");
            }
            value = NUM_FORMAT.format(latitude);
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
        setLatitude(d);
    }
}
