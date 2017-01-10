package com.google.gdata.data.geo;

public interface BoxData {
    void clearGeoBoundingBox();

    Box getGeoBoundingBox();

    void setGeoBoundingBox(Box box);

    void setGeoBoundingBox(Point point, Point point2);
}
