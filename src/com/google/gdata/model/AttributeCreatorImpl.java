package com.google.gdata.model;

import com.google.gdata.model.Metadata.VirtualValue;

final class AttributeCreatorImpl extends MetadataCreatorImpl implements AttributeCreator {
    AttributeCreatorImpl(MetadataRegistry root, TransformKey transformKey) {
        super(root, transformKey);
    }

    AttributeTransform toTransform() {
        return AttributeTransform.create(this);
    }

    public AttributeCreatorImpl setName(QName name) {
        return (AttributeCreatorImpl) super.setName(name);
    }

    public AttributeCreatorImpl setRequired(boolean required) {
        return (AttributeCreatorImpl) super.setRequired(required);
    }

    public AttributeCreatorImpl setVisible(boolean visible) {
        return (AttributeCreatorImpl) super.setVisible(visible);
    }

    public AttributeCreatorImpl setVirtualValue(VirtualValue virtualValue) {
        return (AttributeCreatorImpl) super.setVirtualValue(virtualValue);
    }

    void setSource(Path path, TransformKey key) {
        super.setSource(path, key);
        setVirtualValue(PathAdapter.valueAdapter(path));
    }
}
