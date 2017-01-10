package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Reservation {
    private List<String> groupNames;
    private List<GroupIdentifier> groups;
    private List<Instance> instances;
    private String ownerId;
    private String requesterId;
    private String reservationId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Reservation)) {
            return false;
        }
        Reservation reservation = (Reservation) obj;
        if (((reservation.getReservationId() == null ? 1 : 0) ^ (getReservationId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservation.getReservationId() != null && !reservation.getReservationId().equals(getReservationId())) {
            return false;
        }
        if (((reservation.getOwnerId() == null ? 1 : 0) ^ (getOwnerId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservation.getOwnerId() != null && !reservation.getOwnerId().equals(getOwnerId())) {
            return false;
        }
        if (((reservation.getRequesterId() == null ? 1 : 0) ^ (getRequesterId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservation.getRequesterId() != null && !reservation.getRequesterId().equals(getRequesterId())) {
            return false;
        }
        if (((reservation.getGroups() == null ? 1 : 0) ^ (getGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservation.getGroups() != null && !reservation.getGroups().equals(getGroups())) {
            return false;
        }
        if (((reservation.getGroupNames() == null ? 1 : 0) ^ (getGroupNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservation.getGroupNames() != null && !reservation.getGroupNames().equals(getGroupNames())) {
            return false;
        }
        return ((reservation.getInstances() == null ? 1 : 0) ^ (getInstances() == null ? 1 : 0)) == 0 ? reservation.getInstances() == null || reservation.getInstances().equals(getInstances()) : false;
    }

    public List<String> getGroupNames() {
        if (this.groupNames == null) {
            this.groupNames = new ArrayList();
        }
        return this.groupNames;
    }

    public List<GroupIdentifier> getGroups() {
        if (this.groups == null) {
            this.groups = new ArrayList();
        }
        return this.groups;
    }

    public List<Instance> getInstances() {
        if (this.instances == null) {
            this.instances = new ArrayList();
        }
        return this.instances;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getRequesterId() {
        return this.requesterId;
    }

    public String getReservationId() {
        return this.reservationId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getGroupNames() == null ? 0 : getGroupNames().hashCode()) + (((getGroups() == null ? 0 : getGroups().hashCode()) + (((getRequesterId() == null ? 0 : getRequesterId().hashCode()) + (((getOwnerId() == null ? 0 : getOwnerId().hashCode()) + (((getReservationId() == null ? 0 : getReservationId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getInstances() != null) {
            i = getInstances().hashCode();
        }
        return hashCode + i;
    }

    public void setGroupNames(Collection<String> collection) {
        if (collection == null) {
            this.groupNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.groupNames = arrayList;
    }

    public void setGroups(Collection<GroupIdentifier> collection) {
        if (collection == null) {
            this.groups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.groups = arrayList;
    }

    public void setInstances(Collection<Instance> collection) {
        if (collection == null) {
            this.instances = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instances = arrayList;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setRequesterId(String str) {
        this.requesterId = str;
    }

    public void setReservationId(String str) {
        this.reservationId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservationId != null) {
            stringBuilder.append("ReservationId: " + this.reservationId + ", ");
        }
        if (this.ownerId != null) {
            stringBuilder.append("OwnerId: " + this.ownerId + ", ");
        }
        if (this.requesterId != null) {
            stringBuilder.append("RequesterId: " + this.requesterId + ", ");
        }
        if (this.groups != null) {
            stringBuilder.append("Groups: " + this.groups + ", ");
        }
        if (this.groupNames != null) {
            stringBuilder.append("GroupNames: " + this.groupNames + ", ");
        }
        if (this.instances != null) {
            stringBuilder.append("Instances: " + this.instances + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Reservation withGroupNames(Collection<String> collection) {
        if (collection == null) {
            this.groupNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.groupNames = arrayList;
        }
        return this;
    }

    public Reservation withGroupNames(String... strArr) {
        if (getGroupNames() == null) {
            setGroupNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getGroupNames().add(add);
        }
        return this;
    }

    public Reservation withGroups(Collection<GroupIdentifier> collection) {
        if (collection == null) {
            this.groups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.groups = arrayList;
        }
        return this;
    }

    public Reservation withGroups(GroupIdentifier... groupIdentifierArr) {
        if (getGroups() == null) {
            setGroups(new ArrayList(groupIdentifierArr.length));
        }
        for (Object add : groupIdentifierArr) {
            getGroups().add(add);
        }
        return this;
    }

    public Reservation withInstances(Collection<Instance> collection) {
        if (collection == null) {
            this.instances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instances = arrayList;
        }
        return this;
    }

    public Reservation withInstances(Instance... instanceArr) {
        if (getInstances() == null) {
            setInstances(new ArrayList(instanceArr.length));
        }
        for (Object add : instanceArr) {
            getInstances().add(add);
        }
        return this;
    }

    public Reservation withOwnerId(String str) {
        this.ownerId = str;
        return this;
    }

    public Reservation withRequesterId(String str) {
        this.requesterId = str;
        return this;
    }

    public Reservation withReservationId(String str) {
        this.reservationId = str;
        return this;
    }
}
