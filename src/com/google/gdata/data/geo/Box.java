package com.google.gdata.data.geo;

import com.google.gdata.data.Extension;

public interface Box extends Extension {
    Point getLowerLeft();

    Point getUpperRight();

    void setGeoLocation(Point point, Point point2);
}
