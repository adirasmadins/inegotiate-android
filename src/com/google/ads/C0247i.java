package com.google.ads;

import android.app.Activity;
import com.google.ads.C0242g.C0241a;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.MappingException;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.util.C0299b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.ads.i */
class C0247i implements Runnable {
    private final C0245h f149a;
    private final String f150b;
    private final AdRequest f151c;
    private final HashMap<String, String> f152d;
    private final boolean f153e;
    private final WeakReference<Activity> f154f;

    /* renamed from: com.google.ads.i.a */
    private static class C0246a extends Exception {
        public C0246a(String str) {
            super(str);
        }
    }

    private static boolean m121a(Map<String, String> map) {
        String str = (String) map.remove("gwhirl_share_location");
        if ("1".equals(str)) {
            return true;
        }
        if (!(str == null || "0".equals(str))) {
            C0299b.m384b("Received an illegal value, '" + str + "', for the special share location parameter from mediation server" + " (expected '0' or '1'). Will not share the location.");
        }
        return false;
    }

    public C0247i(C0245h c0245h, Activity activity, String str, AdRequest adRequest, HashMap<String, String> hashMap) {
        this.f149a = c0245h;
        this.f150b = str;
        this.f154f = new WeakReference(activity);
        this.f151c = adRequest;
        this.f152d = new HashMap(hashMap);
        this.f153e = C0247i.m121a(this.f152d);
    }

    public void run() {
        try {
            C0299b.m380a("Trying to instantiate: " + this.f150b);
            m119a((MediationAdapter) C0242g.m100a(this.f150b, MediationAdapter.class));
        } catch (Throwable e) {
            m120a("Cannot find adapter class '" + this.f150b + "'. Did you link the ad network's mediation adapter? Skipping ad network.", e, C0241a.NOT_FOUND);
        } catch (Throwable e2) {
            m120a("Error while creating adapter and loading ad from ad network. Skipping ad network.", e2, C0241a.EXCEPTION);
        }
    }

    private void m120a(String str, Throwable th, C0241a c0241a) {
        C0299b.m385b(str, th);
        this.f149a.m107a(false, c0241a);
    }

    private <T extends NetworkExtras, U extends MediationServerParameters> void m119a(MediationAdapter<T, U> mediationAdapter) throws MappingException, C0246a, IllegalAccessException, InstantiationException {
        Activity activity = (Activity) this.f154f.get();
        if (activity == null) {
            throw new C0246a("Activity became null while trying to instantiate adapter.");
        }
        MediationServerParameters mediationServerParameters;
        NetworkExtras networkExtras;
        this.f149a.m106a((MediationAdapter) mediationAdapter);
        Class serverParametersType = mediationAdapter.getServerParametersType();
        if (serverParametersType != null) {
            MediationServerParameters mediationServerParameters2 = (MediationServerParameters) serverParametersType.newInstance();
            mediationServerParameters2.load(this.f152d);
            mediationServerParameters = mediationServerParameters2;
        } else {
            mediationServerParameters = null;
        }
        serverParametersType = mediationAdapter.getAdditionalParametersType();
        if (serverParametersType != null) {
            networkExtras = (NetworkExtras) this.f151c.getNetworkExtras(serverParametersType);
        } else {
            networkExtras = null;
        }
        MediationAdRequest mediationAdRequest = new MediationAdRequest(this.f151c, activity, this.f153e);
        if (this.f149a.f135a.m297a()) {
            if (mediationAdapter instanceof MediationInterstitialAdapter) {
                ((MediationInterstitialAdapter) mediationAdapter).requestInterstitialAd(new C0277k(this.f149a), activity, mediationServerParameters, mediationAdRequest, networkExtras);
            } else {
                throw new C0246a("Adapter " + this.f150b + " doesn't support the MediationInterstitialAdapter" + " interface.");
            }
        } else if (mediationAdapter instanceof MediationBannerAdapter) {
            ((MediationBannerAdapter) mediationAdapter).requestBannerAd(new C0276j(this.f149a), activity, mediationServerParameters, this.f149a.f135a.m298b(), mediationAdRequest, networkExtras);
        } else {
            throw new C0246a("Adapter " + this.f150b + " doesn't support the MediationBannerAdapter interface");
        }
        this.f149a.m117k();
    }
}
