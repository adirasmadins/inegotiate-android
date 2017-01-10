package com.google.gdata.data.docs;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.acl.AclNamespace;
import com.google.gdata.data.acl.AdditionalRole;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.xml.XmlNamespace;
import java.util.List;

@Default(localName = "additionalRoleSet", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class AdditionalRoleSet extends ExtensionPoint {
    private static final String PRIMARYROLE = "primaryRole";
    static final String XML_NAME = "additionalRoleSet";
    private String primaryRole;

    public AdditionalRoleSet() {
        this.primaryRole = null;
    }

    public AdditionalRoleSet(String primaryRole) {
        this.primaryRole = null;
        setPrimaryRole(primaryRole);
        setImmutable(true);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(AdditionalRoleSet.class)) {
            extProfile.declare(AdditionalRoleSet.class, new ExtensionDescription(AdditionalRole.class, new XmlNamespace(AclNamespace.gAclAlias, AclNamespace.gAcl), "additionalRole", false, true, false));
        }
    }

    public List<AdditionalRole> getAdditionalRoles() {
        return getRepeatingExtension(AdditionalRole.class);
    }

    public void addAdditionalRole(AdditionalRole additionalRole) {
        getAdditionalRoles().add(additionalRole);
    }

    public boolean hasAdditionalRoles() {
        return hasRepeatingExtension(AdditionalRole.class);
    }

    public String getPrimaryRole() {
        return this.primaryRole;
    }

    public void setPrimaryRole(String primaryRole) {
        throwExceptionIfImmutable();
        this.primaryRole = primaryRole;
    }

    public boolean hasPrimaryRole() {
        return getPrimaryRole() != null;
    }

    protected void validate() {
        if (this.primaryRole == null) {
            AbstractExtension.throwExceptionForMissingAttribute(PRIMARYROLE);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(AdditionalRoleSet.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(PRIMARYROLE, this.primaryRole);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.primaryRole = helper.consume(PRIMARYROLE, true);
    }

    public String toString() {
        return "{AdditionalRoleSet primaryRole=" + this.primaryRole + "}";
    }
}
