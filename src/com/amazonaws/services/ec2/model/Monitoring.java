package com.amazonaws.services.ec2.model;

public class Monitoring {
    private String state;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Monitoring)) {
            return false;
        }
        Monitoring monitoring = (Monitoring) obj;
        return ((monitoring.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) == 0 ? monitoring.getState() == null || monitoring.getState().equals(getState()) : false;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        return (getState() == null ? 0 : getState().hashCode()) + 31;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Monitoring withState(String str) {
        this.state = str;
        return this;
    }
}
