package com.amazonaws.services.s3.model;

import com.google.gdata.util.common.base.StringUtil;
import java.io.Serializable;

public class Owner implements Serializable {
    private static final long serialVersionUID = -8916731456944569115L;
    private String displayName;
    private String id;

    public Owner(String str, String str2) {
        this.id = str;
        this.displayName = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Owner)) {
            return false;
        }
        Owner owner = (Owner) obj;
        String id = owner.getId();
        String displayName = owner.getDisplayName();
        Object id2 = getId();
        Object displayName2 = getDisplayName();
        if (id == null) {
            id = StringUtil.EMPTY_STRING;
        }
        if (displayName == null) {
            displayName = StringUtil.EMPTY_STRING;
        }
        if (id2 == null) {
            id2 = StringUtil.EMPTY_STRING;
        }
        if (displayName2 == null) {
            displayName2 = StringUtil.EMPTY_STRING;
        }
        boolean z = id.equals(id2) && displayName.equals(displayName2);
        return z;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return "S3Owner [name=" + getDisplayName() + ",id=" + getId() + "]";
    }
}
