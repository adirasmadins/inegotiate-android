package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.Person;
import com.google.gdata.util.Namespaces;

public class LastModifiedBy extends Person {
    public static final ElementKey<Void, LastModifiedBy> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "lastModifiedBy"), Void.class, LastModifiedBy.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Person.registerMetadata(registry);
            ElementCreator builder = registry.build(KEY);
        }
    }

    public LastModifiedBy() {
        super(KEY);
    }

    protected LastModifiedBy(ElementKey<?, ? extends LastModifiedBy> key) {
        super(key);
    }

    protected LastModifiedBy(ElementKey<?, ? extends LastModifiedBy> key, Element source) {
        super((ElementKey) key, source);
    }

    public LastModifiedBy lock() {
        return (LastModifiedBy) super.lock();
    }
}
