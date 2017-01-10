package com.google.ads;

import com.google.ads.util.C0296a;
import java.util.List;

/* renamed from: com.google.ads.f */
public class C0240f {
    private final String f119a;
    private final String f120b;
    private final String f121c;
    private final List<String> f122d;
    private final List<String> f123e;
    private final List<String> f124f;

    public C0240f(String str, String str2, String str3, List<String> list, List<String> list2, List<String> list3) {
        C0296a.m370a(str2);
        if (str != null) {
            C0296a.m370a(str);
        }
        C0296a.m370a(str3);
        this.f119a = str;
        this.f120b = str2;
        this.f121c = str3;
        this.f122d = list;
        this.f123e = list2;
        this.f124f = list3;
    }

    public String m95a() {
        return this.f119a;
    }

    public String m96b() {
        return this.f120b;
    }

    public String m97c() {
        return this.f121c;
    }

    public List<String> m98d() {
        return this.f122d;
    }

    public List<String> m99e() {
        return this.f123e;
    }
}
