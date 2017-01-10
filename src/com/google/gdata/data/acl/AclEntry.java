package com.google.gdata.data.acl;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.util.Namespaces;
import java.util.List;

@Term("http://schemas.google.com/acl/2007#accessRule")
public class AclEntry extends BaseEntry<AclEntry> {
    public static final Category ACCESS_RULE_CATEGORY;
    public static final String ACCESS_RULE_KIND = "http://schemas.google.com/acl/2007#accessRule";

    static {
        ACCESS_RULE_CATEGORY = new Category(Namespaces.gKind, ACCESS_RULE_KIND);
    }

    public AclEntry() {
        getCategories().add(ACCESS_RULE_CATEGORY);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declare(AclEntry.class, AclScope.class);
        extProfile.declare(AclEntry.class, AclRole.class);
        extProfile.declare(AclEntry.class, AclWithKey.class);
        new AclWithKey().declareExtensions(extProfile);
        extProfile.declare(AclEntry.class, AdditionalRole.getDefaultDescription(false, true));
    }

    public AclScope getScope() {
        return (AclScope) getExtension(AclScope.class);
    }

    public void setScope(AclScope scope) {
        setExtension(scope);
    }

    public AclRole getRole() {
        return (AclRole) getExtension(AclRole.class);
    }

    public void setRole(AclRole role) {
        setExtension(role);
    }

    public AclWithKey getWithKey() {
        return (AclWithKey) getExtension(AclWithKey.class);
    }

    public void setWithKey(AclWithKey withKey) {
        setExtension(withKey);
    }

    public List<AdditionalRole> getAdditionalRoles() {
        return getRepeatingExtension(AdditionalRole.class);
    }

    public void addAdditionalRole(AdditionalRole role) {
        addRepeatingExtension(role);
    }

    public void clearAdditionalRoles() {
        getAdditionalRoles().clear();
    }
}
