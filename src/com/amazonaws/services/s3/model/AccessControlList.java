package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AccessControlList implements Serializable {
    private static final long serialVersionUID = 8095040648034788376L;
    private HashSet<Grant> grants;
    private Owner owner;

    public AccessControlList() {
        this.grants = new HashSet();
        this.owner = null;
    }

    public Set<Grant> getGrants() {
        return this.grants;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void grantAllPermissions(Grant... grantArr) {
        for (Grant grant : grantArr) {
            grantPermission(grant.getGrantee(), grant.getPermission());
        }
    }

    public void grantPermission(Grantee grantee, Permission permission) {
        this.grants.add(new Grant(grantee, permission));
    }

    public void revokeAllPermissions(Grantee grantee) {
        Collection arrayList = new ArrayList();
        Iterator it = this.grants.iterator();
        while (it.hasNext()) {
            Grant grant = (Grant) it.next();
            if (grant.getGrantee().equals(grantee)) {
                arrayList.add(grant);
            }
        }
        this.grants.removeAll(arrayList);
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String toString() {
        return "AccessControlList [owner=" + this.owner + ", grants=" + getGrants() + "]";
    }
}
