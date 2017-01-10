package com.google.gdata.wireformats;

import com.google.common.collect.Maps;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.util.ContentType;
import java.util.Collection;
import java.util.Map;

public abstract class StreamPropertiesBuilder<T extends StreamPropertiesBuilder<T>> {
    protected AltRegistry altRegistry;
    protected ContentType contentType;
    protected ExtensionProfile extensionProfile;
    protected final Map<String, String> queryMap;
    protected ElementMetadata<?, ?> rootMetadata;

    protected static class StreamPropertiesImpl implements StreamProperties {
        private final AltRegistry altRegistry;
        private final ContentType contentType;
        private final ElementMetadata<?, ?> elementMetadata;
        private final ExtensionProfile extensionProfile;
        private final Map<String, String> queryMap;

        protected StreamPropertiesImpl(StreamPropertiesBuilder<?> builder) {
            this.altRegistry = builder.altRegistry;
            this.contentType = builder.contentType;
            this.extensionProfile = builder.extensionProfile;
            this.queryMap = builder.queryMap;
            this.elementMetadata = builder.rootMetadata;
        }

        public AltRegistry getAltRegistry() {
            return this.altRegistry;
        }

        public ContentType getContentType() {
            return this.contentType;
        }

        public ExtensionProfile getExtensionProfile() {
            return this.extensionProfile;
        }

        public Collection<String> getQueryParameterNames() {
            return this.queryMap.keySet();
        }

        public String getQueryParameter(String name) {
            return (String) this.queryMap.get(name);
        }

        public ElementMetadata<?, ?> getRootMetadata() {
            return this.elementMetadata;
        }
    }

    protected StreamPropertiesBuilder() {
        this.queryMap = Maps.newHashMap();
    }

    protected StreamPropertiesBuilder(StreamProperties source) {
        this.altRegistry = source.getAltRegistry();
        this.contentType = source.getContentType();
        this.extensionProfile = source.getExtensionProfile();
        this.rootMetadata = source.getRootMetadata();
        this.queryMap = Maps.newHashMap();
        for (String name : source.getQueryParameterNames()) {
            this.queryMap.put(name, source.getQueryParameter(name));
        }
    }

    public final T thisInstance() {
        return this;
    }

    public T setAltRegistry(AltRegistry altRegistry) {
        this.altRegistry = altRegistry;
        return thisInstance();
    }

    public T setContentType(ContentType contentType) {
        this.contentType = contentType;
        return thisInstance();
    }

    public T setExtensionProfile(ExtensionProfile extensionProfile) {
        this.extensionProfile = extensionProfile;
        return thisInstance();
    }

    public T setQueryParameter(String name, String value) {
        thisInstance().queryMap.put(name, value);
        return thisInstance();
    }

    public T setQueryParameters(Map<String, String> queryMap) {
        this.queryMap.putAll(queryMap);
        return thisInstance();
    }

    public T setElementMetadata(ElementMetadata<?, ?> elementMetadata) {
        this.rootMetadata = elementMetadata;
        return thisInstance();
    }
}
