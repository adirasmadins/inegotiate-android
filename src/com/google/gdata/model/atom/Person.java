package com.google.gdata.model.atom;

import com.google.gdata.data.IPerson;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.gd.Reminder.Method;
import com.google.gdata.util.Namespaces;
import java.net.URI;
import java.net.URISyntaxException;

public class Person extends Element implements IPerson {
    public static final ElementKey<String, Element> EMAIL;
    public static final ElementKey<Void, Person> KEY;
    public static final ElementKey<String, Element> NAME;
    public static final ElementKey<URI, Element> URI;

    static {
        KEY = ElementKey.of(null, Person.class);
        EMAIL = ElementKey.of(new QName(Namespaces.atomNs, Method.EMAIL));
        NAME = ElementKey.of(new QName(Namespaces.atomNs, "name"));
        URI = ElementKey.of(new QName(Namespaces.atomNs, "uri"), URI.class, Element.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(NAME);
            registry.build(URI);
            registry.build(EMAIL);
            ElementCreator builder = registry.build(KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(NAME).setRequired(true);
            builder.addElement(URI);
            builder.addElement(EMAIL);
        }
    }

    public Person() {
        super(KEY);
    }

    protected Person(ElementKey<?, ?> key) {
        super((ElementKey) key);
    }

    protected Person(ElementKey<?, ? extends Person> key, Element source) {
        super(key, source);
    }

    public Person(ElementKey<?, ?> key, String name) {
        super((ElementKey) key);
        if (name == null) {
            throw new NullPointerException("Name must have a value");
        }
        setName(name);
    }

    public Person(ElementKey<?, ?> key, String name, URI uri, String email) {
        super((ElementKey) key);
        setName(name);
        setUri(uri);
        setEmail(email);
    }

    public String getName() {
        if (hasElement(NAME)) {
            return (String) getElementValue(NAME);
        }
        return null;
    }

    public void setName(String v) {
        setElement(NAME, v == null ? null : new Element(NAME).setTextValue(v));
    }

    public String getNameLang() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public void setNameLang(String v) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Deprecated
    public String getUri() {
        URI uri = getUriUri();
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public URI getUriUri() {
        return (URI) getElementValue(URI);
    }

    @Deprecated
    public void setUri(String v) {
        try {
            setUri(v == null ? null : new URI(v));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUri(URI v) {
        setElement(URI, v == null ? null : new Element(URI).setTextValue(v));
    }

    public String getEmail() {
        return (String) getElementValue(EMAIL);
    }

    public void setEmail(String v) {
        setElement(EMAIL, v == null ? null : new Element(EMAIL).setTextValue(v));
    }
}
