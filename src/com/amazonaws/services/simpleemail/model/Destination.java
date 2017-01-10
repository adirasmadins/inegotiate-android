package com.amazonaws.services.simpleemail.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Destination {
    private List<String> bccAddresses;
    private List<String> ccAddresses;
    private List<String> toAddresses;

    public Destination(List<String> list) {
        this.toAddresses = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Destination)) {
            return false;
        }
        Destination destination = (Destination) obj;
        if (((destination.getToAddresses() == null ? 1 : 0) ^ (getToAddresses() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (destination.getToAddresses() != null && !destination.getToAddresses().equals(getToAddresses())) {
            return false;
        }
        if (((destination.getCcAddresses() == null ? 1 : 0) ^ (getCcAddresses() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (destination.getCcAddresses() != null && !destination.getCcAddresses().equals(getCcAddresses())) {
            return false;
        }
        return ((destination.getBccAddresses() == null ? 1 : 0) ^ (getBccAddresses() == null ? 1 : 0)) == 0 ? destination.getBccAddresses() == null || destination.getBccAddresses().equals(getBccAddresses()) : false;
    }

    public List<String> getBccAddresses() {
        if (this.bccAddresses == null) {
            this.bccAddresses = new ArrayList();
        }
        return this.bccAddresses;
    }

    public List<String> getCcAddresses() {
        if (this.ccAddresses == null) {
            this.ccAddresses = new ArrayList();
        }
        return this.ccAddresses;
    }

    public List<String> getToAddresses() {
        if (this.toAddresses == null) {
            this.toAddresses = new ArrayList();
        }
        return this.toAddresses;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCcAddresses() == null ? 0 : getCcAddresses().hashCode()) + (((getToAddresses() == null ? 0 : getToAddresses().hashCode()) + 31) * 31)) * 31;
        if (getBccAddresses() != null) {
            i = getBccAddresses().hashCode();
        }
        return hashCode + i;
    }

    public void setBccAddresses(Collection<String> collection) {
        if (collection == null) {
            this.bccAddresses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.bccAddresses = arrayList;
    }

    public void setCcAddresses(Collection<String> collection) {
        if (collection == null) {
            this.ccAddresses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.ccAddresses = arrayList;
    }

    public void setToAddresses(Collection<String> collection) {
        if (collection == null) {
            this.toAddresses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.toAddresses = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.toAddresses != null) {
            stringBuilder.append("ToAddresses: " + this.toAddresses + ", ");
        }
        if (this.ccAddresses != null) {
            stringBuilder.append("CcAddresses: " + this.ccAddresses + ", ");
        }
        if (this.bccAddresses != null) {
            stringBuilder.append("BccAddresses: " + this.bccAddresses + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Destination withBccAddresses(Collection<String> collection) {
        if (collection == null) {
            this.bccAddresses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.bccAddresses = arrayList;
        }
        return this;
    }

    public Destination withBccAddresses(String... strArr) {
        if (getBccAddresses() == null) {
            setBccAddresses(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getBccAddresses().add(add);
        }
        return this;
    }

    public Destination withCcAddresses(Collection<String> collection) {
        if (collection == null) {
            this.ccAddresses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.ccAddresses = arrayList;
        }
        return this;
    }

    public Destination withCcAddresses(String... strArr) {
        if (getCcAddresses() == null) {
            setCcAddresses(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getCcAddresses().add(add);
        }
        return this;
    }

    public Destination withToAddresses(Collection<String> collection) {
        if (collection == null) {
            this.toAddresses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.toAddresses = arrayList;
        }
        return this;
    }

    public Destination withToAddresses(String... strArr) {
        if (getToAddresses() == null) {
            setToAddresses(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getToAddresses().add(add);
        }
        return this;
    }
}
