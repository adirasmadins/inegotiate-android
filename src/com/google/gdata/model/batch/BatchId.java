package com.google.gdata.model.batch;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class BatchId extends Element {
    public static final ElementKey<String, BatchId> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.batchNs, "id"), String.class, BatchId.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY);
        }
    }

    public static String getIdFrom(Element element) {
        BatchId tag = (BatchId) element.getElement(KEY);
        return tag == null ? null : tag.getId();
    }

    public BatchId() {
        super(KEY);
    }

    public BatchId(String id) {
        this();
        setId(id);
    }

    public String getId() {
        return (String) super.getTextValue();
    }

    public BatchId setId(String id) {
        super.setTextValue(id);
        return this;
    }

    public boolean hasId() {
        return super.hasTextValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        return Element.eq(getId(), ((BatchId) obj).getId());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getId() != null) {
            return (result * 37) + getId().hashCode();
        }
        return result;
    }

    public String toString() {
        return "{BatchId id=" + getTextValue() + "}";
    }
}
