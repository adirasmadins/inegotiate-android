package com.google.ads;

import android.webkit.WebView;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.internal.C0263c;
import com.google.ads.internal.C0264d;
import com.google.ads.util.C0299b;
import java.util.HashMap;

/* renamed from: com.google.ads.v */
public class C0323v implements C0220n {
    public void m415a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("errors");
        C0299b.m390e("Invalid " + ((String) hashMap.get("type")) + " request error: " + str);
        C0263c j = c0264d.m221j();
        if (j != null) {
            j.m170a(ErrorCode.INVALID_REQUEST);
        }
    }
}
