package com.amazonaws.services.ec2.model;

public class RunInstancesResult {
    private Reservation reservation;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RunInstancesResult)) {
            return false;
        }
        RunInstancesResult runInstancesResult = (RunInstancesResult) obj;
        return ((runInstancesResult.getReservation() == null ? 1 : 0) ^ (getReservation() == null ? 1 : 0)) == 0 ? runInstancesResult.getReservation() == null || runInstancesResult.getReservation().equals(getReservation()) : false;
    }

    public Reservation getReservation() {
        return this.reservation;
    }

    public int hashCode() {
        return (getReservation() == null ? 0 : getReservation().hashCode()) + 31;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservation != null) {
            stringBuilder.append("Reservation: " + this.reservation + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public RunInstancesResult withReservation(Reservation reservation) {
        this.reservation = reservation;
        return this;
    }
}
