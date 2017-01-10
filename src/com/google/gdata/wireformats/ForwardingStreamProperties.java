package com.google.gdata.wireformats;

import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.common.base.Preconditions;
import java.util.Collection;

public class ForwardingStreamProperties implements StreamProperties {
    private final StreamProperties delegate;

    public ForwardingStreamProperties(StreamProperties delegate) {
        Preconditions.checkNotNull(delegate, "delegate");
        this.delegate = delegate;
    }

    public ContentType getContentType() {
        return this.delegate.getContentType();
    }

    public Collection<String> getQueryParameterNames() {
        return this.delegate.getQueryParameterNames();
    }

    public String getQueryParameter(String name) {
        return this.delegate.getQueryParameter(name);
    }

    public ExtensionProfile getExtensionProfile() {
        return this.delegate.getExtensionProfile();
    }

    public AltRegistry getAltRegistry() {
        return this.delegate.getAltRegistry();
    }

    public ElementMetadata<?, ?> getRootMetadata() {
        return this.delegate.getRootMetadata();
    }
}
