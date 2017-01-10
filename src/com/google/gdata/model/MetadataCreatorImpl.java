package com.google.gdata.model;

import com.google.gdata.model.Metadata.VirtualValue;
import com.google.gdata.model.atom.OtherContent;
import com.google.gdata.util.common.base.Preconditions;

abstract class MetadataCreatorImpl implements MetadataCreator {
    private boolean isMoved;
    private QName name;
    private Path path;
    final MetadataRegistry registry;
    private Boolean required;
    private TransformKey source;
    final TransformKey transformKey;
    private VirtualValue virtualValue;
    private Boolean visible;

    MetadataCreatorImpl(MetadataRegistry root, TransformKey transformKey) {
        this.registry = root;
        this.transformKey = transformKey;
    }

    void merge(MetadataCreatorImpl other) {
        Preconditions.checkNotNull(other, OtherContent.KIND);
        if (other.name != null) {
            this.name = other.name;
        }
        if (other.required != null) {
            this.required = other.required;
        }
        if (other.visible != null) {
            this.visible = other.visible;
        }
        if (other.virtualValue != null) {
            this.virtualValue = other.virtualValue;
        }
        if (other.source != null) {
            this.source = other.source;
        }
        if (other.path != null) {
            this.path = other.path;
        }
        if (other.isMoved) {
            this.isMoved = true;
        }
    }

    public MetadataCreatorImpl setName(QName name) {
        synchronized (this.registry) {
            this.name = name;
            this.registry.dirty();
        }
        return this;
    }

    public MetadataCreatorImpl setRequired(boolean required) {
        synchronized (this.registry) {
            this.required = Boolean.valueOf(required);
            this.registry.dirty();
        }
        return this;
    }

    public MetadataCreatorImpl setVisible(boolean visible) {
        synchronized (this.registry) {
            this.visible = Boolean.valueOf(visible);
            this.registry.dirty();
        }
        return this;
    }

    public MetadataCreatorImpl setVirtualValue(VirtualValue virtualValue) {
        synchronized (this.registry) {
            this.virtualValue = virtualValue;
            this.registry.dirty();
        }
        return this;
    }

    void setSource(Path path, TransformKey key) {
        synchronized (this.registry) {
            this.path = path;
            this.source = key;
            this.registry.dirty();
            if (this.required == null) {
                setRequired(false);
            }
        }
    }

    MetadataCreatorImpl moved() {
        synchronized (this.registry) {
            this.isMoved = true;
            this.registry.dirty();
        }
        return this;
    }

    TransformKey getTransformKey() {
        return this.transformKey;
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

    public Path getPath() {
        return this.path;
    }

    boolean isMoved() {
        return this.isMoved;
    }
}
