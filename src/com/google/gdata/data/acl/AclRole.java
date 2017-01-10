package com.google.gdata.data.acl;

import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;
import com.google.gdata.model.gd.Reminder.Method;

@Default(localName = "role", nsAlias = "gAcl", nsUri = "http://schemas.google.com/acl/2007")
public class AclRole extends ValueConstruct {
    public static final AclRole COMMENTER;
    public static final AclRole NONE;
    public static final AclRole OWNER;
    public static final AclRole PEEKER;
    public static final AclRole READER;
    static final String ROLE = "role";
    private static final String VALUE = "value";
    public static final AclRole WRITER;

    static {
        NONE = new AclRole(Method.NONE);
        PEEKER = new AclRole("peeker");
        READER = new AclRole("reader");
        WRITER = new AclRole("writer");
        OWNER = new AclRole("owner");
        COMMENTER = new AclRole("commenter");
    }

    public AclRole() {
        this(null);
    }

    public AclRole(String value) {
        super(AclNamespace.gAclNs, ROLE, VALUE, value);
    }
}
