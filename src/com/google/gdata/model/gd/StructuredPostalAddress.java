package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class StructuredPostalAddress extends Element {
    public static final ElementKey<Void, StructuredPostalAddress> KEY;
    public static final AttributeKey<String> LABEL;
    public static final AttributeKey<String> MAIL_CLASS;
    public static final AttributeKey<Boolean> PRIMARY;
    public static final AttributeKey<String> REL;
    public static final AttributeKey<String> USAGE;

    public static final class MailClass {
        private static final String[] ALL_VALUES;
        public static final String BOTH = "http://schemas.google.com/g/2005#both";
        public static final String LETTERS = "http://schemas.google.com/g/2005#letters";
        public static final String NEITHER = "http://schemas.google.com/g/2005#neither";
        public static final String PARCELS = "http://schemas.google.com/g/2005#parcels";

        static {
            ALL_VALUES = new String[]{BOTH, LETTERS, NEITHER, PARCELS};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private MailClass() {
        }
    }

    public static final class Rel {
        private static final String[] ALL_VALUES;
        public static final String HOME = "http://schemas.google.com/g/2005#home";
        public static final String OTHER = "http://schemas.google.com/g/2005#other";
        public static final String WORK = "http://schemas.google.com/g/2005#work";

        static {
            ALL_VALUES = new String[]{HOME, OTHER, WORK};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Rel() {
        }
    }

    public static final class Usage {
        private static final String[] ALL_VALUES;
        public static final String GENERAL = "http://schemas.google.com/g/2005#general";
        public static final String LOCAL = "http://schemas.google.com/g/2005#local";

        static {
            ALL_VALUES = new String[]{GENERAL, LOCAL};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Usage() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "structuredPostalAddress"), Void.class, StructuredPostalAddress.class);
        LABEL = AttributeKey.of(new QName(null, "label"), String.class);
        MAIL_CLASS = AttributeKey.of(new QName(null, "mailClass"), String.class);
        PRIMARY = AttributeKey.of(new QName(null, "primary"), Boolean.class);
        REL = AttributeKey.of(new QName(null, "rel"), String.class);
        USAGE = AttributeKey.of(new QName(null, "usage"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(LABEL);
            builder.addAttribute(MAIL_CLASS);
            builder.addAttribute(PRIMARY);
            builder.addAttribute(REL);
            builder.addAttribute(USAGE);
            builder.addElement(Agent.KEY);
            builder.addElement(City.KEY);
            builder.addElement(Country.KEY);
            builder.addElement(FormattedAddress.KEY);
            builder.addElement(HouseName.KEY);
            builder.addElement(Neighborhood.KEY);
            builder.addElement(PoBox.KEY);
            builder.addElement(PostCode.KEY);
            builder.addElement(Region.KEY);
            builder.addElement(Street.KEY);
            builder.addElement(Subregion.KEY);
        }
    }

    public StructuredPostalAddress() {
        super(KEY);
    }

    protected StructuredPostalAddress(ElementKey<?, ? extends StructuredPostalAddress> key) {
        super((ElementKey) key);
    }

    protected StructuredPostalAddress(ElementKey<?, ? extends StructuredPostalAddress> key, Element source) {
        super(key, source);
    }

    public StructuredPostalAddress lock() {
        return (StructuredPostalAddress) super.lock();
    }

    public Agent getAgent() {
        return (Agent) super.getElement(Agent.KEY);
    }

    public StructuredPostalAddress setAgent(Agent agent) {
        super.setElement(Agent.KEY, (Element) agent);
        return this;
    }

    public boolean hasAgent() {
        return super.hasElement(Agent.KEY);
    }

    public City getCity() {
        return (City) super.getElement(City.KEY);
    }

    public StructuredPostalAddress setCity(City city) {
        super.setElement(City.KEY, (Element) city);
        return this;
    }

    public boolean hasCity() {
        return super.hasElement(City.KEY);
    }

    public Country getCountry() {
        return (Country) super.getElement(Country.KEY);
    }

    public StructuredPostalAddress setCountry(Country country) {
        super.setElement(Country.KEY, (Element) country);
        return this;
    }

    public boolean hasCountry() {
        return super.hasElement(Country.KEY);
    }

    public FormattedAddress getFormattedAddress() {
        return (FormattedAddress) super.getElement(FormattedAddress.KEY);
    }

    public StructuredPostalAddress setFormattedAddress(FormattedAddress formattedAddress) {
        super.setElement(FormattedAddress.KEY, (Element) formattedAddress);
        return this;
    }

    public boolean hasFormattedAddress() {
        return super.hasElement(FormattedAddress.KEY);
    }

    public HouseName getHousename() {
        return (HouseName) super.getElement(HouseName.KEY);
    }

    public StructuredPostalAddress setHousename(HouseName housename) {
        super.setElement(HouseName.KEY, (Element) housename);
        return this;
    }

    public boolean hasHousename() {
        return super.hasElement(HouseName.KEY);
    }

    public String getLabel() {
        return (String) super.getAttributeValue(LABEL);
    }

    public StructuredPostalAddress setLabel(String label) {
        super.setAttributeValue(LABEL, (Object) label);
        return this;
    }

    public boolean hasLabel() {
        return super.hasAttribute(LABEL);
    }

    public String getMailClass() {
        return (String) super.getAttributeValue(MAIL_CLASS);
    }

    public StructuredPostalAddress setMailClass(String mailClass) {
        super.setAttributeValue(MAIL_CLASS, (Object) mailClass);
        return this;
    }

    public boolean hasMailClass() {
        return super.hasAttribute(MAIL_CLASS);
    }

    public Neighborhood getNeighborhood() {
        return (Neighborhood) super.getElement(Neighborhood.KEY);
    }

    public StructuredPostalAddress setNeighborhood(Neighborhood neighborhood) {
        super.setElement(Neighborhood.KEY, (Element) neighborhood);
        return this;
    }

    public boolean hasNeighborhood() {
        return super.hasElement(Neighborhood.KEY);
    }

    public PoBox getPobox() {
        return (PoBox) super.getElement(PoBox.KEY);
    }

    public StructuredPostalAddress setPobox(PoBox pobox) {
        super.setElement(PoBox.KEY, (Element) pobox);
        return this;
    }

    public boolean hasPobox() {
        return super.hasElement(PoBox.KEY);
    }

    public PostCode getPostcode() {
        return (PostCode) super.getElement(PostCode.KEY);
    }

    public StructuredPostalAddress setPostcode(PostCode postcode) {
        super.setElement(PostCode.KEY, (Element) postcode);
        return this;
    }

    public boolean hasPostcode() {
        return super.hasElement(PostCode.KEY);
    }

    public Boolean getPrimary() {
        return (Boolean) super.getAttributeValue(PRIMARY);
    }

    public StructuredPostalAddress setPrimary(Boolean primary) {
        super.setAttributeValue(PRIMARY, (Object) primary);
        return this;
    }

    public boolean hasPrimary() {
        return super.hasAttribute(PRIMARY);
    }

    public Region getRegion() {
        return (Region) super.getElement(Region.KEY);
    }

    public StructuredPostalAddress setRegion(Region region) {
        super.setElement(Region.KEY, (Element) region);
        return this;
    }

    public boolean hasRegion() {
        return super.hasElement(Region.KEY);
    }

    public String getRel() {
        return (String) super.getAttributeValue(REL);
    }

    public StructuredPostalAddress setRel(String rel) {
        super.setAttributeValue(REL, (Object) rel);
        return this;
    }

    public boolean hasRel() {
        return super.hasAttribute(REL);
    }

    public Street getStreet() {
        return (Street) super.getElement(Street.KEY);
    }

    public StructuredPostalAddress setStreet(Street street) {
        super.setElement(Street.KEY, (Element) street);
        return this;
    }

    public boolean hasStreet() {
        return super.hasElement(Street.KEY);
    }

    public Subregion getSubregion() {
        return (Subregion) super.getElement(Subregion.KEY);
    }

    public StructuredPostalAddress setSubregion(Subregion subregion) {
        super.setElement(Subregion.KEY, (Element) subregion);
        return this;
    }

    public boolean hasSubregion() {
        return super.hasElement(Subregion.KEY);
    }

    public String getUsage() {
        return (String) super.getAttributeValue(USAGE);
    }

    public StructuredPostalAddress setUsage(String usage) {
        super.setAttributeValue(USAGE, (Object) usage);
        return this;
    }

    public boolean hasUsage() {
        return super.hasAttribute(USAGE);
    }
}
