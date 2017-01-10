package com.google.gdata.data;

import com.google.gdata.util.common.base.Pair;
import com.google.gdata.util.common.xml.XmlNamespace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ExtensionManifest {
    boolean arbitraryXml;
    final Class<? extends ExtensionPoint> extendedType;
    boolean mixedContent;
    final List<ExtensionManifest> subclassManifests;
    final Map<Pair<String, String>, ExtensionDescription> supportedExtensions;

    ExtensionManifest(Class<? extends ExtensionPoint> extendedType) {
        this.supportedExtensions = new HashMap();
        this.arbitraryXml = false;
        this.mixedContent = false;
        this.subclassManifests = new ArrayList();
        this.extendedType = extendedType;
    }

    public Map<Pair<String, String>, ExtensionDescription> getSupportedExtensions() {
        return Collections.unmodifiableMap(this.supportedExtensions);
    }

    Collection<XmlNamespace> getNamespaceDecls() {
        Collection<XmlNamespace> nsDecls = new HashSet();
        for (ExtensionDescription extDescription : this.supportedExtensions.values()) {
            nsDecls.add(extDescription.getNamespace());
        }
        return nsDecls;
    }
}
