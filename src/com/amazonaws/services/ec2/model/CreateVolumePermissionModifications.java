package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateVolumePermissionModifications {
    private List<CreateVolumePermission> add;
    private List<CreateVolumePermission> remove;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateVolumePermissionModifications)) {
            return false;
        }
        CreateVolumePermissionModifications createVolumePermissionModifications = (CreateVolumePermissionModifications) obj;
        if (((createVolumePermissionModifications.getAdd() == null ? 1 : 0) ^ (getAdd() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createVolumePermissionModifications.getAdd() != null && !createVolumePermissionModifications.getAdd().equals(getAdd())) {
            return false;
        }
        return ((createVolumePermissionModifications.getRemove() == null ? 1 : 0) ^ (getRemove() == null ? 1 : 0)) == 0 ? createVolumePermissionModifications.getRemove() == null || createVolumePermissionModifications.getRemove().equals(getRemove()) : false;
    }

    public List<CreateVolumePermission> getAdd() {
        if (this.add == null) {
            this.add = new ArrayList();
        }
        return this.add;
    }

    public List<CreateVolumePermission> getRemove() {
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

    public void setAdd(Collection<CreateVolumePermission> collection) {
        if (collection == null) {
            this.add = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.add = arrayList;
    }

    public void setRemove(Collection<CreateVolumePermission> collection) {
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

    public CreateVolumePermissionModifications withAdd(Collection<CreateVolumePermission> collection) {
        if (collection == null) {
            this.add = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.add = arrayList;
        }
        return this;
    }

    public CreateVolumePermissionModifications withAdd(CreateVolumePermission... createVolumePermissionArr) {
        if (getAdd() == null) {
            setAdd(new ArrayList(createVolumePermissionArr.length));
        }
        for (Object add : createVolumePermissionArr) {
            getAdd().add(add);
        }
        return this;
    }

    public CreateVolumePermissionModifications withRemove(Collection<CreateVolumePermission> collection) {
        if (collection == null) {
            this.remove = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.remove = arrayList;
        }
        return this;
    }

    public CreateVolumePermissionModifications withRemove(CreateVolumePermission... createVolumePermissionArr) {
        if (getRemove() == null) {
            setRemove(new ArrayList(createVolumePermissionArr.length));
        }
        for (Object add : createVolumePermissionArr) {
            getRemove().add(add);
        }
        return this;
    }
}
