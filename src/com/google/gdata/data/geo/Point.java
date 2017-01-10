package com.google.gdata.data.geo;

import com.google.gdata.data.Extension;

public interface Point extends Extension {
    Double getLatitude();

    Double getLongitude();

    void setGeoLocation(Double d, Double d2);
}
