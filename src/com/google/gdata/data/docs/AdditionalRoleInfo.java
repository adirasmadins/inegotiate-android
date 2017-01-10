package com.google.gdata.data.docs;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.ParseException;
import java.util.List;

@Default(localName = "additionalRoleInfo", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class AdditionalRoleInfo extends ExtensionPoint {
    private static final String KIND = "kind";
    static final String XML_NAME = "additionalRoleInfo";
    private String kind;

    public AdditionalRoleInfo() {
        this.kind = null;
    }

    public AdditionalRoleInfo(String kind) {
        this.kind = null;
        setKind(kind);
        setImmutable(true);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(AdditionalRoleInfo.class)) {
            extProfile.declare(AdditionalRoleInfo.class, AdditionalRoleSet.getDefaultDescription(false, true));
            new AdditionalRoleSet().declareExtensions(extProfile);
        }
    }

    public List<AdditionalRoleSet> getAdditionalRoleSets() {
        return getRepeatingExtension(AdditionalRoleSet.class);
    }

    public void addAdditionalRoleSet(AdditionalRoleSet additionalRoleSet) {
        getAdditionalRoleSets().add(additionalRoleSet);
    }

    public boolean hasAdditionalRoleSets() {
        return hasRepeatingExtension(AdditionalRoleSet.class);
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        throwExceptionIfImmutable();
        this.kind = kind;
    }

    public boolean hasKind() {
        return getKind() != null;
    }

    protected void validate() {
        if (this.kind == null) {
            AbstractExtension.throwExceptionForMissingAttribute(KIND);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(AdditionalRoleInfo.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(KIND, this.kind);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.kind = helper.consume(KIND, true);
    }

    public String toString() {
        return "{AdditionalRoleInfo kind=" + this.kind + "}";
    }
}
