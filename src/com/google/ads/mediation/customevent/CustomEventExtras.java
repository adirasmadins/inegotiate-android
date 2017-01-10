package com.google.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

public class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> f346a;

    public CustomEventExtras() {
        this.f346a = new HashMap();
    }

    public CustomEventExtras addExtra(String label, Object value) {
        this.f346a.put(label, value);
        return this;
    }

    public CustomEventExtras clearExtras() {
        this.f346a.clear();
        return this;
    }

    public Object getExtra(String label) {
        return this.f346a.get(label);
    }

    public Object removeExtra(String label) {
        return this.f346a.remove(label);
    }
}
