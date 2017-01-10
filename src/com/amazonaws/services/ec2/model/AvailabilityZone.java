package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AvailabilityZone {
    private List<AvailabilityZoneMessage> messages;
    private String regionName;
    private String state;
    private String zoneName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AvailabilityZone)) {
            return false;
        }
        AvailabilityZone availabilityZone = (AvailabilityZone) obj;
        if (((availabilityZone.getZoneName() == null ? 1 : 0) ^ (getZoneName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (availabilityZone.getZoneName() != null && !availabilityZone.getZoneName().equals(getZoneName())) {
            return false;
        }
        if (((availabilityZone.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (availabilityZone.getState() != null && !availabilityZone.getState().equals(getState())) {
            return false;
        }
        if (((availabilityZone.getRegionName() == null ? 1 : 0) ^ (getRegionName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (availabilityZone.getRegionName() != null && !availabilityZone.getRegionName().equals(getRegionName())) {
            return false;
        }
        return ((availabilityZone.getMessages() == null ? 1 : 0) ^ (getMessages() == null ? 1 : 0)) == 0 ? availabilityZone.getMessages() == null || availabilityZone.getMessages().equals(getMessages()) : false;
    }

    public List<AvailabilityZoneMessage> getMessages() {
        if (this.messages == null) {
            this.messages = new ArrayList();
        }
        return this.messages;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public String getState() {
        return this.state;
    }

    public String getZoneName() {
        return this.zoneName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getRegionName() == null ? 0 : getRegionName().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getZoneName() == null ? 0 : getZoneName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getMessages() != null) {
            i = getMessages().hashCode();
        }
        return hashCode + i;
    }

    public void setMessages(Collection<AvailabilityZoneMessage> collection) {
        if (collection == null) {
            this.messages = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.messages = arrayList;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setZoneName(String str) {
        this.zoneName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.zoneName != null) {
            stringBuilder.append("ZoneName: " + this.zoneName + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.regionName != null) {
            stringBuilder.append("RegionName: " + this.regionName + ", ");
        }
        if (this.messages != null) {
            stringBuilder.append("Messages: " + this.messages + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AvailabilityZone withMessages(Collection<AvailabilityZoneMessage> collection) {
        if (collection == null) {
            this.messages = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.messages = arrayList;
        }
        return this;
    }

    public AvailabilityZone withMessages(AvailabilityZoneMessage... availabilityZoneMessageArr) {
        if (getMessages() == null) {
            setMessages(new ArrayList(availabilityZoneMessageArr.length));
        }
        for (Object add : availabilityZoneMessageArr) {
            getMessages().add(add);
        }
        return this;
    }

    public AvailabilityZone withRegionName(String str) {
        this.regionName = str;
        return this;
    }

    public AvailabilityZone withState(String str) {
        this.state = str;
        return this;
    }

    public AvailabilityZone withZoneName(String str) {
        this.zoneName = str;
        return this;
    }
}
