package com.google.gdata.data.acl;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;

@Default(localName = "additionalRole", nsAlias = "gAcl", nsUri = "http://schemas.google.com/acl/2007")
public class AdditionalRole extends ValueConstruct {
    public static final AdditionalRole APPENDER;
    public static final AdditionalRole COMMENTER;
    public static final AdditionalRole EXECUTER;
    private static final String VALUE = "value";
    static final String XML_NAME = "additionalRole";

    static {
        APPENDER = new AdditionalRole("appender");
        COMMENTER = new AdditionalRole("commenter");
        EXECUTER = new AdditionalRole("executer");
    }

    public AdditionalRole() {
        this(null);
    }

    public AdditionalRole(String value) {
        super(AclNamespace.gAclNs, XML_NAME, VALUE, value);
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(AdditionalRole.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }
}
