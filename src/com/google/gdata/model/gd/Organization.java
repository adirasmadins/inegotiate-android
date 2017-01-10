package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Organization extends Element {
    public static final ElementKey<Void, Organization> KEY;
    public static final AttributeKey<String> LABEL;
    public static final AttributeKey<Boolean> PRIMARY;
    public static final AttributeKey<String> REL;

    public static final class Rel {
        private static final String[] ALL_VALUES;
        public static final String OTHER = "http://schemas.google.com/g/2005#other";
        public static final String WORK = "http://schemas.google.com/g/2005#work";

        static {
            ALL_VALUES = new String[]{OTHER, WORK};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Rel() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "organization"), Void.class, Organization.class);
        LABEL = AttributeKey.of(new QName(null, "label"), String.class);
        PRIMARY = AttributeKey.of(new QName(null, "primary"), Boolean.class);
        REL = AttributeKey.of(new QName(null, "rel"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(LABEL);
            builder.addAttribute(PRIMARY);
            builder.addAttribute(REL);
            builder.addElement(OrgDepartment.KEY);
            builder.addElement(OrgJobDescription.KEY);
            builder.addElement(OrgName.KEY);
            builder.addElement(OrgSymbol.KEY);
            builder.addElement(OrgTitle.KEY);
            builder.addElement(Where.KEY);
        }
    }

    public Organization() {
        super(KEY);
    }

    protected Organization(ElementKey<?, ? extends Organization> key) {
        super((ElementKey) key);
    }

    protected Organization(ElementKey<?, ? extends Organization> key, Element source) {
        super(key, source);
    }

    public Organization lock() {
        return (Organization) super.lock();
    }

    public String getLabel() {
        return (String) super.getAttributeValue(LABEL);
    }

    public Organization setLabel(String label) {
        super.setAttributeValue(LABEL, (Object) label);
        return this;
    }

    public boolean hasLabel() {
        return super.hasAttribute(LABEL);
    }

    public OrgDepartment getOrgDepartment() {
        return (OrgDepartment) super.getElement(OrgDepartment.KEY);
    }

    public Organization setOrgDepartment(OrgDepartment orgDepartment) {
        super.setElement(OrgDepartment.KEY, (Element) orgDepartment);
        return this;
    }

    public boolean hasOrgDepartment() {
        return super.hasElement(OrgDepartment.KEY);
    }

    public OrgJobDescription getOrgJobDescription() {
        return (OrgJobDescription) super.getElement(OrgJobDescription.KEY);
    }

    public Organization setOrgJobDescription(OrgJobDescription orgJobDescription) {
        super.setElement(OrgJobDescription.KEY, (Element) orgJobDescription);
        return this;
    }

    public boolean hasOrgJobDescription() {
        return super.hasElement(OrgJobDescription.KEY);
    }

    public OrgName getOrgName() {
        return (OrgName) super.getElement(OrgName.KEY);
    }

    public Organization setOrgName(OrgName orgName) {
        super.setElement(OrgName.KEY, (Element) orgName);
        return this;
    }

    public boolean hasOrgName() {
        return super.hasElement(OrgName.KEY);
    }

    public OrgSymbol getOrgSymbol() {
        return (OrgSymbol) super.getElement(OrgSymbol.KEY);
    }

    public Organization setOrgSymbol(OrgSymbol orgSymbol) {
        super.setElement(OrgSymbol.KEY, (Element) orgSymbol);
        return this;
    }

    public boolean hasOrgSymbol() {
        return super.hasElement(OrgSymbol.KEY);
    }

    public OrgTitle getOrgTitle() {
        return (OrgTitle) super.getElement(OrgTitle.KEY);
    }

    public Organization setOrgTitle(OrgTitle orgTitle) {
        super.setElement(OrgTitle.KEY, (Element) orgTitle);
        return this;
    }

    public boolean hasOrgTitle() {
        return super.hasElement(OrgTitle.KEY);
    }

    public Boolean getPrimary() {
        return (Boolean) super.getAttributeValue(PRIMARY);
    }

    public Organization setPrimary(Boolean primary) {
        super.setAttributeValue(PRIMARY, (Object) primary);
        return this;
    }

    public boolean hasPrimary() {
        return super.hasAttribute(PRIMARY);
    }

    public String getRel() {
        return (String) super.getAttributeValue(REL);
    }

    public Organization setRel(String rel) {
        super.setAttributeValue(REL, (Object) rel);
        return this;
    }

    public boolean hasRel() {
        return super.hasAttribute(REL);
    }

    public Where getWhere() {
        return (Where) super.getElement(Where.KEY);
    }

    public Organization setWhere(Where where) {
        super.setElement(Where.KEY, (Element) where);
        return this;
    }

    public boolean hasWhere() {
        return super.hasElement(Where.KEY);
    }
}
