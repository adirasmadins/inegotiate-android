package com.google.ads.internal;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: com.google.ads.internal.e */
public class C0265e {
    private String f249a;
    private HashMap<String, String> f250b;

    public C0265e(Bundle bundle) {
        this.f249a = bundle.getString("action");
        this.f250b = m238a(bundle.getSerializable("params"));
    }

    public C0265e(String str) {
        this.f249a = str;
    }

    public C0265e(String str, HashMap<String, String> hashMap) {
        this(str);
        this.f250b = hashMap;
    }

    private HashMap<String, String> m238a(Serializable serializable) {
        if (serializable instanceof HashMap) {
            return (HashMap) serializable;
        }
        return null;
    }

    public Bundle m239a() {
        Bundle bundle = new Bundle();
        bundle.putString("action", this.f249a);
        bundle.putSerializable("params", this.f250b);
        return bundle;
    }

    public String m240b() {
        return this.f249a;
    }

    public HashMap<String, String> m241c() {
        return this.f250b;
    }
}
