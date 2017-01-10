package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class RecurrenceException extends Element {
    public static final ElementKey<Void, RecurrenceException> KEY;
    public static final AttributeKey<Boolean> SPECIALIZED;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "recurrenceException"), Void.class, RecurrenceException.class);
        SPECIALIZED = AttributeKey.of(new QName(null, "specialized"), Boolean.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(SPECIALIZED).setRequired(true);
            builder.addElement(RecurrenceExceptionEntryLink.KEY).setRequired(true);
        }
    }

    public RecurrenceException() {
        super(KEY);
    }

    protected RecurrenceException(ElementKey<?, ? extends RecurrenceException> key) {
        super((ElementKey) key);
    }

    protected RecurrenceException(ElementKey<?, ? extends RecurrenceException> key, Element source) {
        super(key, source);
    }

    public RecurrenceException lock() {
        return (RecurrenceException) super.lock();
    }

    public RecurrenceExceptionEntryLink getEntryLink() {
        return (RecurrenceExceptionEntryLink) super.getElement(RecurrenceExceptionEntryLink.KEY);
    }

    public RecurrenceException setEntryLink(RecurrenceExceptionEntryLink entryLink) {
        super.setElement(RecurrenceExceptionEntryLink.KEY, (Element) entryLink);
        return this;
    }

    public boolean hasEntryLink() {
        return super.hasElement(RecurrenceExceptionEntryLink.KEY);
    }

    public Boolean getSpecialized() {
        return (Boolean) super.getAttributeValue(SPECIALIZED);
    }

    public RecurrenceException setSpecialized(Boolean specialized) {
        super.setAttributeValue(SPECIALIZED, (Object) specialized);
        return this;
    }

    public boolean hasSpecialized() {
        return super.hasAttribute(SPECIALIZED);
    }
}
