package com.google.gdata.model;

import com.google.gdata.model.Metadata.VirtualValue;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.base.Preconditions;

abstract class MetadataImpl<D> implements Metadata<D> {
    final MetadataContext context;
    private final boolean isRequired;
    private final boolean isVisible;
    final MetadataKey<D> key;
    private final QName name;
    final ElementKey<?, ?> parent;
    final Schema schema;
    private final VirtualValue virtualValue;

    MetadataImpl(Schema schema, Transform transform, ElementKey<?, ?> parent, MetadataKey<D> key, MetadataContext context) {
        this.schema = (Schema) Preconditions.checkNotNull(schema, "schema");
        this.key = (MetadataKey) Preconditions.checkNotNull(key, "key");
        this.parent = parent;
        this.context = context;
        transform = AttributeTransform.mergeSource(schema, transform, context);
        this.name = (QName) firstNonNull(transform.getName(), key.getId());
        this.isRequired = ((Boolean) firstNonNull(transform.getRequired(), Boolean.valueOf(false))).booleanValue();
        Path path = transform.getPath();
        if (transform.isMoved()) {
            this.isVisible = false;
        } else if (path != null) {
            this.isVisible = isVisible(path, schema, parent, context);
        } else {
            this.isVisible = ((Boolean) firstNonNull(transform.getVisible(), Boolean.valueOf(true))).booleanValue();
        }
        this.virtualValue = transform.getVirtualValue();
    }

    static boolean isVisible(Path path, Schema schema, ElementKey<?, ?> parent, MetadataContext context) {
        for (MetadataKey part : path.getSteps()) {
            Boolean visible = schema.getTransform((ElementKey) parent, part, context).getVisible();
            if (visible != null && !visible.booleanValue()) {
                return false;
            }
            if (part instanceof ElementKey) {
                parent = (ElementKey) part;
            }
        }
        return true;
    }

    static <T> T firstNonNull(T... values) {
        for (T value : values) {
            if (value != null) {
                return value;
            }
        }
        throw new IllegalArgumentException("Values must contain at least a single non-null value.");
    }

    public Schema getSchema() {
        return this.schema;
    }

    public MetadataKey<D> getKey() {
        return this.key;
    }

    public ElementKey<?, ?> getParent() {
        return this.parent;
    }

    public MetadataContext getContext() {
        return this.context;
    }

    public QName getName() {
        return this.name;
    }

    public boolean isRequired() {
        return this.isRequired;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public Object generateValue(Element element, ElementMetadata<?, ?> metadata) {
        if (this.virtualValue != null) {
            return this.virtualValue.generate(element, metadata);
        }
        return null;
    }

    public void parseValue(Element element, ElementMetadata<?, ?> metadata, Object value) throws ParseException {
        parse(element, metadata, value);
    }

    boolean parse(Element element, ElementMetadata<?, ?> metadata, Object value) throws ParseException {
        if (this.virtualValue == null) {
            return false;
        }
        this.virtualValue.parse(element, metadata, value);
        return true;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + getKey() + "}@" + Integer.toHexString(hashCode());
    }
}
