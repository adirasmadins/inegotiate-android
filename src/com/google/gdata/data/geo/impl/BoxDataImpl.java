package com.google.gdata.data.geo.impl;

import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.geo.Box;
import com.google.gdata.data.geo.BoxData;
import com.google.gdata.data.geo.Point;

public class BoxDataImpl implements BoxData {
    private final ExtensionPoint extPoint;

    public BoxDataImpl(ExtensionPoint extensionPoint) {
        this.extPoint = extensionPoint;
    }

    public void setGeoBoundingBox(Point lowerLeft, Point upperRight) {
        setGeoBoundingBox(new GeoRssWhere(lowerLeft, upperRight));
    }

    public void setGeoBoundingBox(Box box) {
        setBox(this.extPoint, box);
    }

    public Box getGeoBoundingBox() {
        return getBox(this.extPoint);
    }

    public void clearGeoBoundingBox() {
        clearBox(this.extPoint);
    }

    public static void setBox(ExtensionPoint ext, Box box) {
        Point upperRight = null;
        Box existing = getBoxExtension(ext);
        if (existing != null) {
            Point lowerLeft = box != null ? box.getLowerLeft() : null;
            if (box != null) {
                upperRight = box.getUpperRight();
            }
            existing.setGeoLocation(lowerLeft, upperRight);
        } else if (box != null) {
            ext.setExtension(box);
        }
    }

    public static Box getBox(ExtensionPoint ext) {
        Box b = getBoxExtension(ext);
        if (b != null) {
            if (!(b instanceof GeoRssWhere)) {
                return b;
            }
            GeoRssWhere geoWhere = (GeoRssWhere) b;
            if (geoWhere.hasBox()) {
                return geoWhere;
            }
        }
        return null;
    }

    static Box getBoxExtension(ExtensionPoint ext) {
        for (Extension e : ext.getExtensions()) {
            if (e instanceof Box) {
                return (Box) e;
            }
        }
        return null;
    }

    public static void clearBox(ExtensionPoint ext) {
        Extension b = getBoxExtension(ext);
        if (b != null) {
            if (b instanceof GeoRssWhere) {
                GeoRssWhere where = (GeoRssWhere) b;
                if (where.hasPoint()) {
                    where.clearBox();
                    return;
                }
            }
            ext.removeExtension(b);
        }
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        Class extClass = this.extPoint.getClass();
        extProfile.declare(extClass, GeoRssBox.getDefaultDescription(false));
        extProfile.declare(extClass, GeoRssWhere.getDefaultDescription(false));
        new GeoRssWhere().declareExtensions(extProfile);
        extProfile.declare(extClass, GmlEnvelope.getDefaultDescription(false));
        new GmlEnvelope().declareExtensions(extProfile);
    }
}
