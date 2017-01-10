package com.google.gdata.model.batch;

import com.google.gdata.data.batch.BatchOperationType;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class BatchOperation extends Element {
    public static final ElementKey<Void, BatchOperation> KEY;
    public static final AttributeKey<BatchOperationType> TYPE;

    static {
        KEY = ElementKey.of(new QName(Namespaces.batchNs, "operation"), BatchOperation.class);
        TYPE = AttributeKey.of(new QName("type"), BatchOperationType.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY).addAttribute(TYPE).setRequired(true);
        }
    }

    public BatchOperation() {
        super(KEY);
    }

    public BatchOperation(BatchOperationType type) {
        this();
        setType(type);
    }

    public BatchOperationType getType() {
        return (BatchOperationType) getAttributeValue(TYPE);
    }

    public BatchOperation setType(BatchOperationType type) {
        setAttributeValue(TYPE, (Object) type);
        return this;
    }

    public boolean hasType() {
        return getType() != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        return Element.eq(getType(), ((BatchOperation) obj).getType());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getType() != null) {
            return (result * 37) + getType().hashCode();
        }
        return result;
    }

    public String toString() {
        return "{BatchOperation type=" + getAttributeValue(TYPE) + "}";
    }
}
