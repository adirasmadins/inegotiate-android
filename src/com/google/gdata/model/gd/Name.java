package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Name extends Element {
    public static final ElementKey<Void, Name> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "name"), Void.class, Name.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addElement(AdditionalName.KEY);
            builder.addElement(FamilyName.KEY);
            builder.addElement(FullName.KEY);
            builder.addElement(GivenName.KEY);
            builder.addElement(NamePrefix.KEY);
            builder.addElement(NameSuffix.KEY);
        }
    }

    public Name() {
        super(KEY);
    }

    protected Name(ElementKey<?, ? extends Name> key) {
        super((ElementKey) key);
    }

    protected Name(ElementKey<?, ? extends Name> key, Element source) {
        super(key, source);
    }

    public Name lock() {
        return (Name) super.lock();
    }

    public AdditionalName getAdditionalName() {
        return (AdditionalName) super.getElement(AdditionalName.KEY);
    }

    public Name setAdditionalName(AdditionalName additionalName) {
        super.setElement(AdditionalName.KEY, (Element) additionalName);
        return this;
    }

    public boolean hasAdditionalName() {
        return super.hasElement(AdditionalName.KEY);
    }

    public FamilyName getFamilyName() {
        return (FamilyName) super.getElement(FamilyName.KEY);
    }

    public Name setFamilyName(FamilyName familyName) {
        super.setElement(FamilyName.KEY, (Element) familyName);
        return this;
    }

    public boolean hasFamilyName() {
        return super.hasElement(FamilyName.KEY);
    }

    public FullName getFullName() {
        return (FullName) super.getElement(FullName.KEY);
    }

    public Name setFullName(FullName fullName) {
        super.setElement(FullName.KEY, (Element) fullName);
        return this;
    }

    public boolean hasFullName() {
        return super.hasElement(FullName.KEY);
    }

    public GivenName getGivenName() {
        return (GivenName) super.getElement(GivenName.KEY);
    }

    public Name setGivenName(GivenName givenName) {
        super.setElement(GivenName.KEY, (Element) givenName);
        return this;
    }

    public boolean hasGivenName() {
        return super.hasElement(GivenName.KEY);
    }

    public NamePrefix getNamePrefix() {
        return (NamePrefix) super.getElement(NamePrefix.KEY);
    }

    public Name setNamePrefix(NamePrefix namePrefix) {
        super.setElement(NamePrefix.KEY, (Element) namePrefix);
        return this;
    }

    public boolean hasNamePrefix() {
        return super.hasElement(NamePrefix.KEY);
    }

    public NameSuffix getNameSuffix() {
        return (NameSuffix) super.getElement(NameSuffix.KEY);
    }

    public Name setNameSuffix(NameSuffix nameSuffix) {
        super.setElement(NameSuffix.KEY, (Element) nameSuffix);
        return this;
    }

    public boolean hasNameSuffix() {
        return super.hasElement(NameSuffix.KEY);
    }
}
