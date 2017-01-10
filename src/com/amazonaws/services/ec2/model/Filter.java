package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Filter {
    private String name;
    private List<String> values;

    public Filter(String str) {
        this.name = str;
    }

    public Filter(String str, List<String> list) {
        this.name = str;
        this.values = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Filter)) {
            return false;
        }
        Filter filter = (Filter) obj;
        if (((filter.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (filter.getName() != null && !filter.getName().equals(getName())) {
            return false;
        }
        return ((filter.getValues() == null ? 1 : 0) ^ (getValues() == null ? 1 : 0)) == 0 ? filter.getValues() == null || filter.getValues().equals(getValues()) : false;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getValues() {
        if (this.values == null) {
            this.values = new ArrayList();
        }
        return this.values;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getName() == null ? 0 : getName().hashCode()) + 31) * 31;
        if (getValues() != null) {
            i = getValues().hashCode();
        }
        return hashCode + i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValues(Collection<String> collection) {
        if (collection == null) {
            this.values = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.values = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        if (this.values != null) {
            stringBuilder.append("Values: " + this.values + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Filter withName(String str) {
        this.name = str;
        return this;
    }

    public Filter withValues(Collection<String> collection) {
        if (collection == null) {
            this.values = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.values = arrayList;
        }
        return this;
    }

    public Filter withValues(String... strArr) {
        if (getValues() == null) {
            setValues(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getValues().add(add);
        }
        return this;
    }
}
