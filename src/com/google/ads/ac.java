package com.google.ads;

import android.content.Context;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0299b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ac implements Runnable {
    private final Context f56a;
    private final String f57b;

    public ac(String str, Context context) {
        this.f57b = str;
        this.f56a = context;
    }

    protected HttpURLConnection m40a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public void run() {
        HttpURLConnection a;
        try {
            C0299b.m380a("Pinging URL: " + this.f57b);
            a = m40a(new URL(this.f57b));
            AdUtil.m345a(a, this.f56a);
            a.setInstanceFollowRedirects(true);
            a.connect();
            int responseCode = a.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                C0299b.m390e("Did not receive 2XX (got " + responseCode + ") from pinging URL: " + this.f57b);
            }
            a.disconnect();
        } catch (Throwable th) {
            C0299b.m389d("Unable to ping the URL: " + this.f57b, th);
        }
    }
}
