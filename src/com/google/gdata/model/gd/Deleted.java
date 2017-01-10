package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Deleted extends Element {
    public static final ElementKey<Void, Deleted> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "deleted"), Void.class, Deleted.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public Deleted() {
        super(KEY);
    }

    protected Deleted(ElementKey<?, ? extends Deleted> key) {
        super((ElementKey) key);
    }

    protected Deleted(ElementKey<?, ? extends Deleted> key, Element source) {
        super(key, source);
    }

    public Deleted lock() {
        return (Deleted) super.lock();
    }
}
