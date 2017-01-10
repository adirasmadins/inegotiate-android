package com.google.gdata.data.acl;

import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.ParseException;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@Default(localName = "withKey", nsAlias = "gAcl", nsUri = "http://schemas.google.com/acl/2007")
public class AclWithKey extends ExtensionPoint {
    private static final String KEY = "key";
    static final String XML_NAME = "withKey";
    private String key;

    public AclWithKey() {
        this.key = null;
    }

    public AclWithKey(String key, AclRole role) {
        this.key = null;
        setKey(key);
        setRole(role);
        setImmutable(true);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declare(AclWithKey.class, AclRole.class);
        extProfile.declare(AclWithKey.class, AdditionalRole.getDefaultDescription(false, true));
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        throwExceptionIfImmutable();
        this.key = key;
    }

    public boolean hasKey() {
        return getKey() != null;
    }

    public AclRole getRole() {
        return (AclRole) getExtension(AclRole.class);
    }

    public void setRole(AclRole role) {
        throwExceptionIfImmutable();
        if (role == null) {
            removeExtension(AclRole.class);
        } else {
            setExtension(role);
        }
    }

    public boolean hasRole() {
        return hasExtension(AclRole.class);
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

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(KEY, this.key);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.key = helper.consume(KEY, false);
    }

    public String toString() {
        return "{AclWithKey key=" + this.key + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + super.toString() + "}";
    }
}
