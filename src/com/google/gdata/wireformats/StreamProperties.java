package com.google.gdata.wireformats;

import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.util.ContentType;
import java.util.Collection;

public interface StreamProperties {
    AltRegistry getAltRegistry();

    ContentType getContentType();

    ExtensionProfile getExtensionProfile();

    String getQueryParameter(String str);

    Collection<String> getQueryParameterNames();

    ElementMetadata<?, ?> getRootMetadata();
}
