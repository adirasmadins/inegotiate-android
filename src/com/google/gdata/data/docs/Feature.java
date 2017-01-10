package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;

@Default(localName = "feature", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class Feature extends ExtensionPoint {
    static final String XML_NAME = "feature";

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(Feature.class)) {
            extProfile.declare(Feature.class, FeatureName.getDefaultDescription(true, false));
            extProfile.declare(Feature.class, FeatureRate.class);
        }
    }

    public FeatureName getFeatureName() {
        return (FeatureName) getExtension(FeatureName.class);
    }

    public void setFeatureName(FeatureName featureName) {
        if (featureName == null) {
            removeExtension(FeatureName.class);
        } else {
            setExtension(featureName);
        }
    }

    public boolean hasFeatureName() {
        return hasExtension(FeatureName.class);
    }

    public FeatureRate getFeatureRate() {
        return (FeatureRate) getExtension(FeatureRate.class);
    }

    public void setFeatureRate(FeatureRate featureRate) {
        if (featureRate == null) {
            removeExtension(FeatureRate.class);
        } else {
            setExtension(featureRate);
        }
    }

    public boolean hasFeatureRate() {
        return hasExtension(FeatureRate.class);
    }

    protected void validate() {
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Feature.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{Feature}";
    }
}
