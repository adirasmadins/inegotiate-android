package com.google.gdata.model.atompub;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.atompub.Draft.Value;
import com.google.gdata.util.Namespaces;

public class Control extends Element {
    public static final ElementKey<Void, Control> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomPubStandardNs, "control"), Void.class, Control.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY).addElement(Draft.KEY);
        }
    }

    public Control() {
        super(KEY);
    }

    protected Control(ElementKey<?, ? extends Control> key) {
        super((ElementKey) key);
    }

    protected Control(ElementKey<?, ? extends Control> key, Element source) {
        super(key, source);
    }

    public Control lock() {
        return (Control) super.lock();
    }

    public Draft getDraft() {
        return (Draft) super.getElement(Draft.KEY);
    }

    public Control setDraft(Draft draft) {
        super.setElement(Draft.KEY, (Element) draft);
        return this;
    }

    public boolean hasDraft() {
        return super.hasElement(Draft.KEY);
    }

    public boolean isDraft() {
        return hasDraft() && Value.YES.equals(getElementValue(Draft.KEY));
    }

    public void setDraft(boolean value) {
        if (value) {
            setDraft(new Draft(Value.YES));
        } else {
            removeElement(Draft.KEY);
        }
    }
}
