package com.google.ads;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.google.ads.doubleclick.DfpExtras;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobAdapterExtras;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0299b;
import com.google.gdata.util.common.base.StringUtil;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdRequest {
    public static final String LOGTAG = "Ads";
    public static final String TEST_EMULATOR;
    public static final String VERSION = "6.2.1";
    private static final SimpleDateFormat f30a;
    private static Method f31b;
    private static Method f32c;
    private Gender f33d;
    private Date f34e;
    private Set<String> f35f;
    private Map<String, Object> f36g;
    private final Map<Class<?>, NetworkExtras> f37h;
    private Location f38i;
    private boolean f39j;
    private boolean f40k;
    private Set<String> f41l;

    public enum ErrorCode {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        private final String f28a;

        private ErrorCode(String description) {
            this.f28a = description;
        }

        public String toString() {
            return this.f28a;
        }
    }

    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }

    public AdRequest() {
        this.f33d = null;
        this.f34e = null;
        this.f35f = null;
        this.f36g = null;
        this.f37h = new HashMap();
        this.f38i = null;
        this.f39j = false;
        this.f40k = false;
        this.f41l = null;
    }

    static {
        f30a = new SimpleDateFormat("yyyyMMdd");
        f31b = null;
        f32c = null;
        try {
            for (Method method : Class.forName("com.google.analytics.tracking.android.AdMobInfo").getMethods()) {
                if (method.getName().equals("getInstance") && method.getParameterTypes().length == 0) {
                    f31b = method;
                } else if (method.getName().equals("getJoinIds") && method.getParameterTypes().length == 0) {
                    f32c = method;
                }
            }
            if (f31b == null || f32c == null) {
                f31b = null;
                f32c = null;
                C0299b.m390e("No Google Analytics: Library Incompatible.");
            }
        } catch (ClassNotFoundException e) {
            C0299b.m380a("No Google Analytics: Library Not Found.");
        } catch (Throwable th) {
            C0299b.m380a("No Google Analytics: Error Loading Library");
        }
        TEST_EMULATOR = AdUtil.m354b("emulator");
    }

    public AdRequest setGender(Gender gender) {
        this.f33d = gender;
        return this;
    }

    public Gender getGender() {
        return this.f33d;
    }

    @Deprecated
    public AdRequest setBirthday(String birthday) {
        if (birthday == StringUtil.EMPTY_STRING || birthday == null) {
            this.f34e = null;
        } else {
            try {
                this.f34e = f30a.parse(birthday);
            } catch (ParseException e) {
                C0299b.m384b("Birthday format invalid.  Expected 'YYYYMMDD' where 'YYYY' is a 4 digit year, 'MM' is a two digit month, and 'DD' is a two digit day.  Birthday value ignored");
                this.f34e = null;
            }
        }
        return this;
    }

    public AdRequest setBirthday(Date birthday) {
        if (birthday == null) {
            this.f34e = null;
        } else {
            this.f34e = new Date(birthday.getTime());
        }
        return this;
    }

    public AdRequest setBirthday(Calendar calendar) {
        if (calendar == null) {
            this.f34e = null;
        } else {
            setBirthday(calendar.getTime());
        }
        return this;
    }

    public Date getBirthday() {
        return this.f34e;
    }

    public AdRequest clearBirthday() {
        this.f34e = null;
        return this;
    }

    @Deprecated
    public AdRequest setPlusOneOptOut(boolean plusOneOptOut) {
        m14a().setPlusOneOptOut(plusOneOptOut);
        return this;
    }

    @Deprecated
    public boolean getPlusOneOptOut() {
        return m14a().getPlusOneOptOut();
    }

    public AdRequest setKeywords(Set<String> keywords) {
        this.f35f = keywords;
        return this;
    }

    public AdRequest addKeyword(String keyword) {
        if (this.f35f == null) {
            this.f35f = new HashSet();
        }
        this.f35f.add(keyword);
        return this;
    }

    public AdRequest addKeywords(Set<String> keywords) {
        if (this.f35f == null) {
            this.f35f = new HashSet();
        }
        this.f35f.addAll(keywords);
        return this;
    }

    public Set<String> getKeywords() {
        if (this.f35f == null) {
            return null;
        }
        return Collections.unmodifiableSet(this.f35f);
    }

    private synchronized AdMobAdapterExtras m14a() {
        if (getNetworkExtras(AdMobAdapterExtras.class) == null) {
            setNetworkExtras(new AdMobAdapterExtras());
        }
        return (AdMobAdapterExtras) getNetworkExtras(AdMobAdapterExtras.class);
    }

    @Deprecated
    public AdRequest setExtras(Map<String, Object> extras) {
        m14a().setExtras(extras);
        return this;
    }

    @Deprecated
    public AdRequest addExtra(String key, Object value) {
        AdMobAdapterExtras a = m14a();
        if (a.getExtras() == null) {
            a.setExtras(new HashMap());
        }
        a.getExtras().put(key, value);
        return this;
    }

    public AdRequest setNetworkExtras(NetworkExtras extras) {
        if (extras != null) {
            this.f37h.put(extras.getClass(), extras);
        }
        return this;
    }

    public AdRequest removeNetworkExtras(Class<?> extrasClass) {
        this.f37h.remove(extrasClass);
        return this;
    }

    public <T> T getNetworkExtras(Class<T> extrasClass) {
        return this.f37h.get(extrasClass);
    }

    public AdRequest setMediationExtras(Map<String, Object> mediationExtras) {
        this.f36g = mediationExtras;
        return this;
    }

    public AdRequest addMediationExtra(String key, Object value) {
        if (this.f36g == null) {
            this.f36g = new HashMap();
        }
        this.f36g.put(key, value);
        return this;
    }

    public AdRequest setLocation(Location location) {
        this.f38i = location;
        return this;
    }

    public Location getLocation() {
        return this.f38i;
    }

    @Deprecated
    public AdRequest setTesting(boolean testing) {
        this.f39j = testing;
        return this;
    }

    public Map<String, Object> getRequestMap(Context context) {
        int i = 1;
        Map<String, Object> hashMap = new HashMap();
        if (this.f35f != null) {
            hashMap.put("kw", this.f35f);
        }
        if (this.f33d != null) {
            hashMap.put("cust_gender", Integer.valueOf(this.f33d.ordinal()));
        }
        if (this.f34e != null) {
            hashMap.put("cust_age", f30a.format(this.f34e));
        }
        if (this.f38i != null) {
            hashMap.put("uule", AdUtil.m340a(this.f38i));
        }
        if (this.f39j) {
            hashMap.put("testing", Integer.valueOf(1));
        }
        if (isTestDevice(context)) {
            hashMap.put("adtest", "on");
        } else if (!this.f40k) {
            String str;
            if (AdUtil.m359c()) {
                str = "AdRequest.TEST_EMULATOR";
            } else {
                str = "\"" + AdUtil.m339a(context) + "\"";
            }
            C0299b.m386c("To get test ads on this device, call adRequest.addTestDevice(" + str + ");");
            this.f40k = true;
        }
        AdMobAdapterExtras adMobAdapterExtras = (AdMobAdapterExtras) getNetworkExtras(AdMobAdapterExtras.class);
        if (adMobAdapterExtras == null || !adMobAdapterExtras.getPlusOneOptOut()) {
            String str2 = "cipa";
            if (!ah.m48a(context)) {
                i = 0;
            }
            hashMap.put(str2, Integer.valueOf(i));
        } else {
            hashMap.put("pto", Integer.valueOf(1));
        }
        DfpExtras dfpExtras = (DfpExtras) getNetworkExtras(DfpExtras.class);
        if (dfpExtras != null && dfpExtras.getExtras() != null && !dfpExtras.getExtras().isEmpty()) {
            hashMap.put("extras", dfpExtras.getExtras());
        } else if (!(adMobAdapterExtras == null || adMobAdapterExtras.getExtras() == null || adMobAdapterExtras.getExtras().isEmpty())) {
            hashMap.put("extras", adMobAdapterExtras.getExtras());
        }
        if (dfpExtras != null) {
            CharSequence publisherProvidedId = dfpExtras.getPublisherProvidedId();
            if (!TextUtils.isEmpty(publisherProvidedId)) {
                hashMap.put("ppid", publisherProvidedId);
            }
        }
        if (this.f36g != null) {
            hashMap.put("mediation_extras", this.f36g);
        }
        try {
            if (f31b != null) {
                Map map = (Map) f32c.invoke(f31b.invoke(null, new Object[0]), new Object[0]);
                if (map != null && map.size() > 0) {
                    hashMap.put("analytics_join_id", map);
                }
            }
        } catch (Throwable th) {
            C0299b.m387c("Internal Analytics Error:", th);
        }
        return hashMap;
    }

    public AdRequest addTestDevice(String testDevice) {
        if (this.f41l == null) {
            this.f41l = new HashSet();
        }
        this.f41l.add(testDevice);
        return this;
    }

    public AdRequest setTestDevices(Set<String> testDevices) {
        this.f41l = testDevices;
        return this;
    }

    public boolean isTestDevice(Context context) {
        if (this.f41l == null) {
            return false;
        }
        String a = AdUtil.m339a(context);
        if (a != null && this.f41l.contains(a)) {
            return true;
        }
        return false;
    }
}
