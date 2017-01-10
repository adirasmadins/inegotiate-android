package com.google.gdata.wireformats;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.common.base.Preconditions;
import java.util.List;
import java.util.Set;

public class AltFormat {
    public static final AltFormat APPLICATION_XML;
    public static final AltFormat ATOM;
    public static final AltFormat ATOM_SERVICE;
    public static final AltFormat MEDIA;
    public static final AltFormat MEDIA_MULTIPART;
    public static final AltFormat OPENSEARCH;
    public static final AltFormat RSS;
    private final List<ContentType> acceptList;
    private final AltFormat base;
    private final ContentType contentType;
    private final Set<AltFormat> extraInputFormats;
    private final boolean isSelectableByType;
    private final String name;
    private final WireFormat wireFormat;

    public static class Builder {
        private Set<ContentType> acceptableTypes;
        private AltFormat base;
        private ContentType contentType;
        private final com.google.common.collect.ImmutableSet.Builder<AltFormat> extraInputFormats;
        private boolean isSelectableByType;
        private String name;
        private WireFormat wireFormat;

        private Builder() {
            this.extraInputFormats = ImmutableSet.builder();
        }

        private Builder(AltFormat prototype) {
            this.extraInputFormats = ImmutableSet.builder();
            this.name = prototype.name;
            this.wireFormat = prototype.wireFormat;
            this.contentType = prototype.contentType;
            this.acceptableTypes = ImmutableSet.copyOf(prototype.acceptList);
            this.extraInputFormats.addAll(prototype.extraInputFormats);
            this.isSelectableByType = prototype.isSelectableByType;
            this.base = prototype.base;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setWireFormat(WireFormat wireFormat) {
            this.wireFormat = wireFormat;
            return this;
        }

        public Builder setContentType(ContentType contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder setSelectableByType(boolean isSelectableByType) {
            this.isSelectableByType = isSelectableByType;
            return this;
        }

        public Builder setBaseFormat(AltFormat base) {
            this.base = base;
            return this;
        }

        public Builder setAcceptableTextTypes() {
            return setAcceptableTypes(ContentType.TEXT_PLAIN);
        }

        public Builder setAcceptableXmlTypes() {
            return setAcceptableTypes(ContentType.TEXT_XML, ContentType.TEXT_PLAIN);
        }

        public Builder setAcceptableTypes(ContentType... types) {
            if (types == null) {
                this.acceptableTypes = ImmutableSet.of();
            } else {
                this.acceptableTypes = ImmutableSet.copyOf((Object[]) types);
            }
            return this;
        }

        private Builder setAcceptableTypes(Iterable<ContentType> types) {
            if (types == null) {
                this.acceptableTypes = ImmutableSet.of();
            } else {
                this.acceptableTypes = ImmutableSet.copyOf((Iterable) types);
            }
            return this;
        }

        public Builder addAllowedInputFormats(AltFormat... formats) {
            for (Object format : formats) {
                this.extraInputFormats.add(format);
            }
            return this;
        }

        public AltFormat build() {
            check();
            return new AltFormat();
        }

        private Builder check() {
            boolean z;
            boolean z2 = true;
            if (this.name != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Name must be set");
            if (this.contentType == null) {
                z2 = false;
            }
            Preconditions.checkState(z2, "contentType must be set");
            return this;
        }
    }

    static {
        RSS = builder().setName("rss").setWireFormat(WireFormat.XML).setContentType(ContentType.RSS).setAcceptableXmlTypes().setSelectableByType(true).build();
        OPENSEARCH = builder().setName("opensearch").setWireFormat(WireFormat.XML).setContentType(ContentType.OPENSEARCH).setAcceptableXmlTypes().setSelectableByType(true).build();
        ATOM_SERVICE = builder().setName("atom-service").setWireFormat(WireFormat.XML).setContentType(ContentType.ATOM_SERVICE).setAcceptableXmlTypes().setSelectableByType(true).build();
        APPLICATION_XML = builder().setName("application-xml").setWireFormat(WireFormat.XML).setContentType(ContentType.APPLICATION_XML).setAcceptableXmlTypes().setSelectableByType(true).build();
        MEDIA = builder().setName("media").setContentType(ContentType.ANY).build();
        MEDIA_MULTIPART = builder().setName("media-multipart").setContentType(ContentType.MULTIPART_RELATED).setSelectableByType(true).build();
        ATOM = builder().setName("atom").setWireFormat(WireFormat.XML).setContentType(ContentType.ATOM).setAcceptableXmlTypes().addAllowedInputFormats(MEDIA, MEDIA_MULTIPART, APPLICATION_XML).setSelectableByType(true).build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AltFormat format) {
        return new Builder(null);
    }

    private AltFormat(Builder builder) {
        this.base = builder.base;
        this.name = builder.name;
        this.wireFormat = builder.wireFormat;
        this.contentType = builder.contentType;
        com.google.common.collect.ImmutableList.Builder<ContentType> acceptListBuilder = ImmutableList.builder();
        acceptListBuilder.add(this.contentType);
        if (builder.acceptableTypes != null) {
            acceptListBuilder.addAll(builder.acceptableTypes);
        }
        this.acceptList = acceptListBuilder.build();
        this.isSelectableByType = builder.isSelectableByType;
        this.extraInputFormats = builder.extraInputFormats.build();
    }

    @Deprecated
    public AltFormat(String name, WireFormat wireFormat, ContentType contentType, List<ContentType> acceptList, boolean isSelectableByType) {
        this(builder().setName(name).setWireFormat(wireFormat).setContentType(contentType).setAcceptableTypes((Iterable) acceptList).setSelectableByType(isSelectableByType).check());
    }

    public String getName() {
        return this.name;
    }

    public WireFormat getWireFormat() {
        return this.wireFormat;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public List<ContentType> getMatchingTypes() {
        return this.acceptList;
    }

    public boolean isSelectableByType() {
        return this.isSelectableByType;
    }

    public boolean allowInputFormat(AltFormat inputFormat) {
        return inputFormat == this || this.extraInputFormats.contains(inputFormat);
    }

    public boolean hasBaseFormat() {
        return this.base != null;
    }

    public AltFormat getBaseFormat() {
        return this.base;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof AltFormat) && this.name.equals(((AltFormat) o).name));
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return this.name + "[" + this.contentType + "]";
    }
}
