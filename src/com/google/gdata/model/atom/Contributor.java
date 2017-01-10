package com.google.gdata.model.atom;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;
import java.net.URI;

public class Contributor extends Person {
    public static final ElementKey<Void, Contributor> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomNs, "contributor"), Contributor.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Person.registerMetadata(registry);
            registry.build(KEY);
        }
    }

    public Contributor() {
        super(KEY);
    }

    protected Contributor(ElementKey<?, ?> key) {
        super(key);
    }

    protected Contributor(ElementKey<?, ? extends Contributor> key, Element source) {
        super((ElementKey) key, source);
    }

    public Contributor(String name) {
        super(KEY, name);
    }

    public Contributor(String name, URI uri, String email) {
        super(KEY, name, uri, email);
    }
}
