package com.google.api.client.json;

import com.google.api.client.util.GenericData;

public class GenericJson extends GenericData implements Cloneable {
    public String toString() {
        return Json.toString(this);
    }

    public GenericJson clone() {
        return (GenericJson) super.clone();
    }
}
