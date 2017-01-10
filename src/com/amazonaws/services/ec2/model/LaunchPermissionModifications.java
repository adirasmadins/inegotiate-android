package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LaunchPermissionModifications {
    private List<LaunchPermission> add;
    private List<LaunchPermission> remove;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LaunchPermissionModifications)) {
            return false;
        }
        LaunchPermissionModifications launchPermissionModifications = (LaunchPermissionModifications) obj;
        if (((launchPermissionModifications.getAdd() == null ? 1 : 0) ^ (getAdd() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchPermissionModifications.getAdd() != null && !launchPermissionModifications.getAdd().equals(getAdd())) {
            return false;
        }
        return ((launchPermissionModifications.getRemove() == null ? 1 : 0) ^ (getRemove() == null ? 1 : 0)) == 0 ? launchPermissionModifications.getRemove() == null || launchPermissionModifications.getRemove().equals(getRemove()) : false;
    }

    public List<LaunchPermission> getAdd() {
        if (this.add == null) {
            this.add = new ArrayList();
        }
        return this.add;
    }

    public List<LaunchPermission> getRemove() {
        if (this.remove == null) {
            this.remove = new ArrayList();
        }
        return this.remove;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAdd() == null ? 0 : getAdd().hashCode()) + 31) * 31;
        if (getRemove() != null) {
            i = getRemove().hashCode();
        }
        return hashCode + i;
    }

    public void setAdd(Collection<LaunchPermission> collection) {
        if (collection == null) {
            this.add = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.add = arrayList;
    }

    public void setRemove(Collection<LaunchPermission> collection) {
        if (collection == null) {
            this.remove = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.remove = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.add != null) {
            stringBuilder.append("Add: " + this.add + ", ");
        }
        if (this.remove != null) {
            stringBuilder.append("Remove: " + this.remove + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public LaunchPermissionModifications withAdd(Collection<LaunchPermission> collection) {
        if (collection == null) {
            this.add = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.add = arrayList;
        }
        return this;
    }

    public LaunchPermissionModifications withAdd(LaunchPermission... launchPermissionArr) {
        if (getAdd() == null) {
            setAdd(new ArrayList(launchPermissionArr.length));
        }
        for (Object add : launchPermissionArr) {
            getAdd().add(add);
        }
        return this;
    }

    public LaunchPermissionModifications withRemove(Collection<LaunchPermission> collection) {
        if (collection == null) {
            this.remove = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.remove = arrayList;
        }
        return this;
    }

    public LaunchPermissionModifications withRemove(LaunchPermission... launchPermissionArr) {
        if (getRemove() == null) {
            setRemove(new ArrayList(launchPermissionArr.length));
        }
        for (Object add : launchPermissionArr) {
            getRemove().add(add);
        }
        return this;
    }
}
