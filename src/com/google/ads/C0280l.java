package com.google.ads;

import com.google.ads.util.C0278i;
import com.google.ads.util.C0278i.C0320b;
import com.google.ads.util.C0278i.C0321c;

/* renamed from: com.google.ads.l */
public class C0280l extends C0278i {
    private static final C0280l f312b;
    public final C0320b<C0279a> f313a;

    /* renamed from: com.google.ads.l.a */
    public static final class C0279a extends C0278i {
        public final C0321c<Integer> f300a;
        public final C0321c<Integer> f301b;
        public final C0321c<String> f302c;
        public final C0321c<String> f303d;
        public final C0321c<String> f304e;
        public final C0321c<Long> f305f;
        public final C0321c<Long> f306g;
        public final C0321c<Long> f307h;
        public final C0321c<Long> f308i;
        public final C0321c<Long> f309j;
        public final C0321c<Long> f310k;
        public final C0321c<Boolean> f311l;

        public C0279a() {
            this.f300a = new C0321c(this, "minHwAccelerationVersionBanner", Integer.valueOf(17));
            this.f301b = new C0321c(this, "minHwAccelerationVersionOverlay", Integer.valueOf(14));
            this.f302c = new C0321c(this, "mraidBannerPath", "http://media.admob.com/mraid/v1/mraid_app_banner.js");
            this.f303d = new C0321c(this, "mraidExpandedBannerPath", "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            this.f304e = new C0321c(this, "mraidInterstitialPath", "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            this.f305f = new C0321c(this, "appCacheMaxSize", Long.valueOf(0));
            this.f306g = new C0321c(this, "appCacheMaxSizePaddingInBytes", Long.valueOf(131072));
            this.f307h = new C0321c(this, "maxTotalAppCacheQuotaInBytes", Long.valueOf(5242880));
            this.f308i = new C0321c(this, "maxTotalDatabaseQuotaInBytes", Long.valueOf(5242880));
            this.f309j = new C0321c(this, "maxDatabaseQuotaPerOriginInBytes", Long.valueOf(1048576));
            this.f310k = new C0321c(this, "databaseQuotaIncreaseStepInBytes", Long.valueOf(131072));
            this.f311l = new C0321c(this, "isInitialized", Boolean.valueOf(false));
        }
    }

    static {
        f312b = new C0280l();
    }

    public static C0280l m309a() {
        return f312b;
    }

    private C0280l() {
        this.f313a = new C0320b(this, "constants", new C0279a());
    }
}
