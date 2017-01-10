package com.google.gdata.model.atom;

import com.google.gdata.client.GDataProtocol.Query;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;
import java.net.URI;

public class Author extends Person {
    public static final ElementKey<Void, Author> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomNs, Query.AUTHOR), Author.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Person.registerMetadata(registry);
            registry.build(KEY);
        }
    }

    public Author() {
        super(KEY);
    }

    protected Author(ElementKey<?, ?> key) {
        super(key);
    }

    protected Author(ElementKey<?, ? extends Author> key, Element source) {
        super((ElementKey) key, source);
    }

    public Author(String name) {
        super(KEY, name);
    }

    public Author(String name, URI uri, String email) {
        super(KEY, name, uri, email);
    }
}
