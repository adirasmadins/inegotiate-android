package com.google.ads.mediation.admob;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;
import java.util.Map;

public class AdMobAdapterExtras implements NetworkExtras {
    private boolean f90a;
    private boolean f91b;
    private Map<String, Object> f92c;

    public AdMobAdapterExtras() {
        this.f90a = false;
        this.f91b = false;
        clearExtras();
    }

    public AdMobAdapterExtras(AdMobAdapterExtras original) {
        this();
        if (original != null) {
            this.f90a = original.f90a;
            this.f91b = original.f91b;
            this.f92c.putAll(original.f92c);
        }
    }

    public AdMobAdapterExtras setPlusOneOptOut(boolean plusOneOptOut) {
        this.f90a = plusOneOptOut;
        return this;
    }

    public boolean getPlusOneOptOut() {
        return this.f90a;
    }

    public AdMobAdapterExtras setUseExactAdSize(boolean useExactAdSize) {
        this.f91b = useExactAdSize;
        return this;
    }

    public boolean getUseExactAdSize() {
        return this.f91b;
    }

    public Map<String, Object> getExtras() {
        return this.f92c;
    }

    public AdMobAdapterExtras setExtras(Map<String, Object> extras) {
        if (extras == null) {
            throw new IllegalArgumentException("Argument 'extras' may not be null");
        }
        this.f92c = extras;
        return this;
    }

    public AdMobAdapterExtras clearExtras() {
        this.f92c = new HashMap();
        return this;
    }

    public AdMobAdapterExtras addExtra(String key, Object value) {
        this.f92c.put(key, value);
        return this;
    }
}
