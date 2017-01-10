package com.amazonaws.services.s3.model;

public class CanonicalGrantee implements Grantee {
    private String displayName;
    private String id;

    public CanonicalGrantee(String str) {
        this.id = null;
        this.displayName = null;
        setIdentifier(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CanonicalGrantee)) {
            return false;
        }
        return this.id.equals(((CanonicalGrantee) obj).id);
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getIdentifier() {
        return this.id;
    }

    public String getTypeIdentifier() {
        return "id";
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setIdentifier(String str) {
        this.id = str;
    }
}
