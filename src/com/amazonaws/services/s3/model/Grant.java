package com.amazonaws.services.s3.model;

public class Grant {
    private Grantee grantee;
    private Permission permission;

    public Grant(Grantee grantee, Permission permission) {
        this.grantee = null;
        this.permission = null;
        this.grantee = grantee;
        this.permission = permission;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Grant grant = (Grant) obj;
        if (this.grantee == null) {
            if (grant.grantee != null) {
                return false;
            }
        } else if (!this.grantee.equals(grant.grantee)) {
            return false;
        }
        return this.permission == grant.permission;
    }

    public Grantee getGrantee() {
        return this.grantee;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.grantee == null ? 0 : this.grantee.hashCode()) + 31) * 31;
        if (this.permission != null) {
            i = this.permission.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Grant [grantee=" + this.grantee + ", permission=" + this.permission + "]";
    }
}
