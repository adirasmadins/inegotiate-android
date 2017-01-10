package com.google.gdata.data.geo;

public interface PointData {
    void clearPoint();

    Point getGeoLocation();

    void setGeoLocation(Point point);

    void setGeoLocation(Double d, Double d2) throws IllegalArgumentException;
}
