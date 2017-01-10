package com.amazonaws.auth.policy;

import com.google.gdata.model.QName;
import com.google.gdata.util.common.base.StringUtil;

public class Principal {
    public static final Principal AllUsers;
    private final String id;

    static {
        AllUsers = new Principal(QName.ANY_LOCALNAME);
    }

    public Principal(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Null AWS account ID specified");
        }
        this.id = str.replaceAll("-", StringUtil.EMPTY_STRING);
    }

    public String getId() {
        return this.id;
    }

    public String getProvider() {
        return "AWS";
    }
}
