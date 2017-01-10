package com.google.ads;

import com.google.ads.util.C0296a;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.google.ads.a */
public class C0219a {
    private final String f50a;
    private final String f51b;
    private final List<String> f52c;
    private final List<String> f53d;
    private final HashMap<String, String> f54e;

    public C0219a(String str, String str2, List<String> list, List<String> list2, HashMap<String, String> hashMap) {
        C0296a.m370a(str2);
        if (str != null) {
            C0296a.m370a(str);
        }
        this.f50a = str;
        this.f51b = str2;
        this.f52c = list;
        this.f54e = hashMap;
        this.f53d = list2;
    }

    public String m31a() {
        return this.f50a;
    }

    public String m32b() {
        return this.f51b;
    }

    public List<String> m33c() {
        return this.f52c;
    }

    public List<String> m34d() {
        return this.f53d;
    }

    public HashMap<String, String> m35e() {
        return this.f54e;
    }
}
