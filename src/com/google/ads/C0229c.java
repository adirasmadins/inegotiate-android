package com.google.ads;

import com.google.ads.internal.C0270h;
import com.google.ads.util.C0296a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.ads.c */
public class C0229c {
    private static final Map<String, AdSize> f79a;
    private final String f80b;
    private final String f81c;
    private final List<C0219a> f82d;
    private final Integer f83e;
    private final Integer f84f;
    private final List<String> f85g;
    private final List<String> f86h;
    private final List<String> f87i;

    /* renamed from: com.google.ads.c.1 */
    static class C02281 extends HashMap<String, AdSize> {
        C02281() {
            put("banner", AdSize.BANNER);
            put("mrec", AdSize.IAB_MRECT);
            put("fullbanner", AdSize.IAB_BANNER);
            put("leaderboard", AdSize.IAB_LEADERBOARD);
            put("skyscraper", AdSize.IAB_WIDE_SKYSCRAPER);
        }
    }

    static {
        f79a = Collections.unmodifiableMap(new C02281());
    }

    public static C0229c m57a(String str) throws JSONException {
        Integer valueOf;
        List a;
        List a2;
        List a3;
        Integer num;
        Integer num2 = null;
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("qdata");
        String string2 = jSONObject.has("ad_type") ? jSONObject.getString("ad_type") : null;
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(C0229c.m56a(jSONArray.getJSONObject(i)));
        }
        jSONObject = jSONObject.optJSONObject("settings");
        if (jSONObject != null) {
            if (jSONObject.has("refresh")) {
                valueOf = Integer.valueOf(jSONObject.getInt("refresh"));
            } else {
                valueOf = null;
            }
            if (jSONObject.has("ad_network_timeout_millis")) {
                num2 = Integer.valueOf(jSONObject.getInt("ad_network_timeout_millis"));
            }
            a = C0229c.m58a(jSONObject, "imp_urls");
            a2 = C0229c.m58a(jSONObject, "click_urls");
            a3 = C0229c.m58a(jSONObject, "nofill_urls");
            num = num2;
        } else {
            a3 = null;
            a = null;
            a2 = null;
            num = null;
            valueOf = null;
        }
        return new C0229c(string, string2, arrayList, valueOf, num, a, a2, a3);
    }

    public boolean m59a() {
        return this.f84f != null;
    }

    public int m60b() {
        return this.f84f.intValue();
    }

    public String m61c() {
        return this.f80b;
    }

    public boolean m62d() {
        return this.f83e != null;
    }

    public int m63e() {
        return this.f83e.intValue();
    }

    public List<C0219a> m64f() {
        return this.f82d;
    }

    public List<String> m65g() {
        return this.f85g;
    }

    public List<String> m66h() {
        return this.f86h;
    }

    public List<String> m67i() {
        return this.f87i;
    }

    private static C0219a m56a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap;
        String string = jSONObject.getString("id");
        String optString = jSONObject.optString("allocation_id", null);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        List a = C0229c.m58a(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        HashMap hashMap2 = new HashMap(0);
        if (optJSONObject != null) {
            hashMap = new HashMap(optJSONObject.length());
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, optJSONObject.getString(str));
            }
        } else {
            hashMap = hashMap2;
        }
        return new C0219a(optString, string, arrayList, a, hashMap);
    }

    public C0270h m68j() {
        if (this.f81c == null) {
            return null;
        }
        if ("interstitial".equals(this.f81c)) {
            return C0270h.f274a;
        }
        AdSize adSize = (AdSize) f79a.get(this.f81c);
        return adSize != null ? C0270h.m295a(adSize) : null;
    }

    private static List<String> m58a(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List<String> arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return arrayList;
    }

    private C0229c(String str, String str2, List<C0219a> list, Integer num, Integer num2, List<String> list2, List<String> list3, List<String> list4) {
        C0296a.m370a(str);
        this.f80b = str;
        this.f81c = str2;
        this.f82d = list;
        this.f83e = num;
        this.f84f = num2;
        this.f85g = list2;
        this.f86h = list3;
        this.f87i = list4;
    }
}
