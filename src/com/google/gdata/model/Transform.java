package com.google.gdata.model;

import com.google.gdata.model.Metadata.VirtualValue;

abstract class Transform {
    private final boolean isMoved;
    private final QName name;
    private final Path path;
    private final Boolean required;
    private final TransformKey source;
    private final VirtualValue virtualValue;
    private final Boolean visible;

    Transform() {
        this.name = null;
        this.required = null;
        this.visible = null;
        this.virtualValue = null;
        this.source = null;
        this.path = null;
        this.isMoved = false;
    }

    Transform(MetadataCreatorImpl creator) {
        this.name = creator.getName();
        this.required = creator.getRequired();
        this.visible = creator.getVisible();
        this.virtualValue = creator.getVirtualValue();
        this.source = creator.getSource();
        this.path = creator.getPath();
        this.isMoved = creator.isMoved();
    }

    Transform(Iterable<? extends Transform> parts) {
        QName compositeName = null;
        Boolean compositeRequired = null;
        Boolean compositeVisible = null;
        VirtualValue compositeVirtualValue = null;
        TransformKey compositeSource = null;
        Path compositePath = null;
        boolean compositeMoved = false;
        for (Transform part : parts) {
            if (part.name != null) {
                compositeName = part.name;
            }
            if (part.required != null) {
                compositeRequired = part.required;
            }
            if (part.visible != null) {
                compositeVisible = part.visible;
            }
            if (part.virtualValue != null) {
                compositeVirtualValue = part.virtualValue;
            }
            if (part.source != null) {
                compositeSource = part.source;
            }
            if (part.path != null) {
                compositePath = part.path;
            }
            if (part.isMoved) {
                compositeMoved = true;
            }
        }
        this.name = compositeName;
        this.required = compositeRequired;
        this.visible = compositeVisible;
        this.virtualValue = compositeVirtualValue;
        this.source = compositeSource;
        this.path = compositePath;
        this.isMoved = compositeMoved;
    }

    Transform(Transform transform, Transform source) {
        this.name = (QName) first(transform.name, source.name);
        this.required = transform.required;
        this.visible = (Boolean) first(transform.visible, source.visible);
        this.virtualValue = (VirtualValue) first(transform.virtualValue, source.virtualValue);
        this.path = transform.path;
        this.isMoved = transform.isMoved;
        this.source = null;
    }

    static <T> T first(T... ts) {
        for (T t : ts) {
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    QName getName() {
        return this.name;
    }

    Boolean getRequired() {
        return this.required;
    }

    Boolean getVisible() {
        return this.visible;
    }

    VirtualValue getVirtualValue() {
        return this.virtualValue;
    }

    TransformKey getSource() {
        return this.source;
    }

    Path getPath() {
        return this.path;
    }

    boolean isMoved() {
        return this.isMoved;
    }

    boolean isEmpty() {
        return this.name == null && this.required == null && this.visible == null && this.virtualValue == null && this.source == null && this.path == null && !this.isMoved;
    }
}
