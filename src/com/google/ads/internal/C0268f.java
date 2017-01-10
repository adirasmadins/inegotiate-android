package com.google.ads.internal;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0299b;
import com.google.common.net.HttpHeaders;
import com.google.gdata.client.GDataProtocol.Header;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.google.ads.internal.f */
public final class C0268f implements Runnable {
    private final C0263c f251a;
    private final C0264d f252b;
    private final C0266a f253c;
    private volatile boolean f254d;
    private boolean f255e;
    private String f256f;
    private Thread f257g;

    /* renamed from: com.google.ads.internal.f.a */
    public interface C0266a {
        HttpURLConnection m242a(URL url) throws IOException;
    }

    /* renamed from: com.google.ads.internal.f.1 */
    class C02671 implements C0266a {
        C02671() {
        }

        public HttpURLConnection m243a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    C0268f(C0263c c0263c, C0264d c0264d) {
        this(c0263c, c0264d, new C02671());
    }

    C0268f(C0263c c0263c, C0264d c0264d, C0266a c0266a) {
        this.f257g = null;
        this.f251a = c0263c;
        this.f252b = c0264d;
        this.f253c = c0266a;
    }

    void m259a() {
        this.f254d = true;
    }

    private void m245a(HttpURLConnection httpURLConnection) {
        m248b(httpURLConnection);
        m252f(httpURLConnection);
        m253g(httpURLConnection);
        m254h(httpURLConnection);
        m251e(httpURLConnection);
        m255i(httpURLConnection);
        m256j(httpURLConnection);
        m257k(httpURLConnection);
        m250d(httpURLConnection);
        m249c(httpURLConnection);
        m258l(httpURLConnection);
    }

    private void m248b(HttpURLConnection httpURLConnection) {
        Object headerField = httpURLConnection.getHeaderField("X-Afma-Debug-Dialog");
        if (!TextUtils.isEmpty(headerField)) {
            this.f251a.m186e(headerField);
        }
    }

    private void m249c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_TYPE);
        if (!TextUtils.isEmpty(headerField)) {
            this.f251a.m179b(headerField);
        }
    }

    private void m250d(HttpURLConnection httpURLConnection) {
        Object headerField = httpURLConnection.getHeaderField("X-Afma-Mediation");
        if (!TextUtils.isEmpty(headerField)) {
            this.f251a.m177a(Boolean.valueOf(headerField).booleanValue());
        }
    }

    private void m251e(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Interstitial-Timeout");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                this.f252b.m197a((long) (Float.parseFloat(headerField) * 1000.0f));
            } catch (Throwable e) {
                C0299b.m389d("Could not get timeout value: " + headerField, e);
            }
        }
    }

    private void m252f(HttpURLConnection httpURLConnection) {
        Object headerField = httpURLConnection.getHeaderField("X-Afma-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String b : headerField.trim().split("\\s+")) {
                this.f252b.m212b(b);
            }
        }
    }

    private void m253g(HttpURLConnection httpURLConnection) {
        Object headerField = httpURLConnection.getHeaderField("X-Afma-Click-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String a : headerField.trim().split("\\s+")) {
                this.f251a.m175a(a);
            }
        }
    }

    private void m254h(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Refresh-Rate");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                float parseFloat = Float.parseFloat(headerField);
                if (parseFloat > 0.0f) {
                    this.f252b.m195a(parseFloat);
                    if (!this.f252b.m230s()) {
                        this.f252b.m217f();
                    }
                } else if (this.f252b.m230s()) {
                    this.f252b.m216e();
                }
            } catch (Throwable e) {
                C0299b.m389d("Could not get refresh value: " + headerField, e);
            }
        }
    }

    private void m255i(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Orientation");
        if (!TextUtils.isEmpty(headerField)) {
            if (headerField.equals("portrait")) {
                this.f251a.m169a(AdUtil.m351b());
            } else if (headerField.equals("landscape")) {
                this.f251a.m169a(AdUtil.m335a());
            }
        }
    }

    private void m256j(HttpURLConnection httpURLConnection) {
        if (!TextUtils.isEmpty(httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"))) {
            try {
                this.f252b.m210b(Long.parseLong(httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life")));
            } catch (NumberFormatException e) {
                C0299b.m390e("Got bad value of Doritos cookie cache life from header: " + httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life") + ". Using default value instead.");
            }
        }
    }

    public void m261a(boolean z) {
        this.f255e = z;
    }

    private void m257k(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(Header.CACHE_CONTROL);
        if (!TextUtils.isEmpty(headerField)) {
            this.f251a.m182c(headerField);
        }
    }

    private void m258l(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Ad-Size");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                String[] split = headerField.split("x", 2);
                if (split.length != 2) {
                    C0299b.m390e("Could not parse size header: " + headerField);
                    return;
                }
                this.f251a.m173a(new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            } catch (NumberFormatException e) {
                C0299b.m390e("Could not parse size header: " + headerField);
            }
        }
    }

    synchronized void m260a(String str) {
        if (this.f257g == null) {
            this.f256f = str;
            this.f254d = false;
            this.f257g = new Thread(this);
            this.f257g.start();
        }
    }

    private void m246a(HttpURLConnection httpURLConnection, int i) throws IOException {
        String headerField;
        if (300 <= i && i < 400) {
            headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
            if (headerField == null) {
                C0299b.m386c("Could not get redirect location from a " + i + " redirect.");
                this.f251a.m170a(ErrorCode.INTERNAL_ERROR);
                m259a();
                return;
            }
            m245a(httpURLConnection);
            this.f256f = headerField;
        } else if (i == 200) {
            m245a(httpURLConnection);
            headerField = AdUtil.m341a(new InputStreamReader(httpURLConnection.getInputStream())).trim();
            C0299b.m380a("Response content is: " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                C0299b.m380a("Response message is null or zero length: " + headerField);
                this.f251a.m170a(ErrorCode.NO_FILL);
                m259a();
                return;
            }
            this.f251a.m176a(headerField, this.f256f);
            m259a();
        } else if (i == 400) {
            C0299b.m386c("Bad request");
            this.f251a.m170a(ErrorCode.INVALID_REQUEST);
            m259a();
        } else {
            C0299b.m386c("Invalid response code: " + i);
            this.f251a.m170a(ErrorCode.INTERNAL_ERROR);
            m259a();
        }
    }

    public void run() {
        try {
            m247b();
        } catch (Throwable e) {
            C0299b.m385b("Received malformed ad url from javascript.", e);
            this.f251a.m170a(ErrorCode.INTERNAL_ERROR);
        } catch (Throwable e2) {
            C0299b.m389d("IOException connecting to ad url.", e2);
            this.f251a.m170a(ErrorCode.NETWORK_ERROR);
        } catch (Throwable e22) {
            C0299b.m385b("An unknown error occurred in AdResponseLoader.", e22);
            this.f251a.m170a(ErrorCode.INTERNAL_ERROR);
        }
    }

    private void m247b() throws MalformedURLException, IOException {
        while (!this.f254d) {
            HttpURLConnection a = this.f253c.m242a(new URL(this.f256f));
            try {
                m244a((Context) this.f252b.m219h().f319f.m411a(), a);
                AdUtil.m345a(a, (Context) this.f252b.m219h().f319f.m411a());
                a.setInstanceFollowRedirects(false);
                a.connect();
                m246a(a, a.getResponseCode());
                a.disconnect();
            } catch (Throwable th) {
                a.disconnect();
            }
        }
    }

    private void m244a(Context context, HttpURLConnection httpURLConnection) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("drt", StringUtil.EMPTY_STRING);
        if (this.f255e && !TextUtils.isEmpty(string)) {
            if (AdUtil.f371a == 8) {
                httpURLConnection.addRequestProperty("X-Afma-drt-Cookie", string);
            } else {
                httpURLConnection.addRequestProperty(HttpHeaders.COOKIE, string);
            }
        }
    }
}
