package com.google.gdata.data.geo.impl;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.geo.Point;
import com.google.gdata.data.geo.PointData;

public class PointDataImpl implements PointData {
    private ExtensionPoint extPoint;

    public PointDataImpl(ExtensionPoint extensionPoint) {
        this.extPoint = extensionPoint;
    }

    public void setGeoLocation(Double lat, Double lon) throws IllegalArgumentException {
        setGeoLocation(new GeoRssWhere(lat, lon));
    }

    public void setGeoLocation(Point point) {
        setPoint(this.extPoint, point);
    }

    public Point getGeoLocation() {
        return getPoint(this.extPoint);
    }

    public void clearPoint() {
        clearPoint(this.extPoint);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        Class<? extends ExtensionPoint> extClass = this.extPoint.getClass();
        declare(extProfile, extClass, W3CPoint.getDefaultDescription(false));
        declare(extProfile, extClass, GeoRssPoint.getDefaultDescription(false));
        declare(extProfile, extClass, GeoRssWhere.getDefaultDescription(false));
        new W3CPoint().declareExtensions(extProfile);
        new GeoRssWhere().declareExtensions(extProfile);
    }

    private void declare(ExtensionProfile extProfile, Class<? extends ExtensionPoint> extClass, ExtensionDescription desc) {
        extProfile.declare((Class) extClass, desc);
        if (BaseEntry.class.isAssignableFrom(extClass)) {
            extProfile.declare(BaseEntry.class, desc);
        }
    }

    public static void setPoint(ExtensionPoint ext, Point point) {
        Double lon = null;
        Point existing = getPointExtension(ext);
        if (existing != null) {
            Double lat = point != null ? point.getLatitude() : null;
            if (point != null) {
                lon = point.getLongitude();
            }
            existing.setGeoLocation(lat, lon);
        } else if (point != null) {
            ext.setExtension(point);
        }
    }

    static Point getPointExtension(ExtensionPoint ext) {
        for (Extension e : ext.getExtensions()) {
            if (e instanceof Point) {
                return (Point) e;
            }
        }
        return null;
    }

    public static Point getPoint(ExtensionPoint ext) {
        Point p = getPointExtension(ext);
        if (p != null) {
            if (!(p instanceof GeoRssWhere)) {
                return p;
            }
            GeoRssWhere geoWhere = (GeoRssWhere) p;
            if (geoWhere.hasPoint()) {
                return geoWhere;
            }
        }
        return null;
    }

    public static void clearPoint(ExtensionPoint ext) {
        Extension p = getPointExtension(ext);
        if (p != null) {
            if (p instanceof GeoRssWhere) {
                GeoRssWhere where = (GeoRssWhere) p;
                if (where.hasBox()) {
                    where.clearPoint();
                    return;
                }
            }
            ext.removeExtension(p);
        }
    }
}
