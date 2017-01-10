package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeInstancesResult {
    private List<Reservation> reservations;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeInstancesResult)) {
            return false;
        }
        DescribeInstancesResult describeInstancesResult = (DescribeInstancesResult) obj;
        return ((describeInstancesResult.getReservations() == null ? 1 : 0) ^ (getReservations() == null ? 1 : 0)) == 0 ? describeInstancesResult.getReservations() == null || describeInstancesResult.getReservations().equals(getReservations()) : false;
    }

    public List<Reservation> getReservations() {
        if (this.reservations == null) {
            this.reservations = new ArrayList();
        }
        return this.reservations;
    }

    public int hashCode() {
        return (getReservations() == null ? 0 : getReservations().hashCode()) + 31;
    }

    public void setReservations(Collection<Reservation> collection) {
        if (collection == null) {
            this.reservations = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.reservations = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservations != null) {
            stringBuilder.append("Reservations: " + this.reservations + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeInstancesResult withReservations(Collection<Reservation> collection) {
        if (collection == null) {
            this.reservations = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.reservations = arrayList;
        }
        return this;
    }

    public DescribeInstancesResult withReservations(Reservation... reservationArr) {
        if (getReservations() == null) {
            setReservations(new ArrayList(reservationArr.length));
        }
        for (Object add : reservationArr) {
            getReservations().add(add);
        }
        return this;
    }
}
