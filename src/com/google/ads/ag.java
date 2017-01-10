package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.C0254a;
import com.google.ads.util.C0299b;
import com.google.gdata.util.common.base.StringUtil;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Locale;

public final class ag {
    private static final C0254a f70a;

    /* renamed from: com.google.ads.ag.a */
    private static class C0221a implements Runnable {
        private final WeakReference<Activity> f63a;
        private final Editor f64b;

        public C0221a(Activity activity) {
            this(activity, null);
        }

        C0221a(Activity activity, Editor editor) {
            this.f63a = new WeakReference(activity);
            this.f64b = editor;
        }

        private Editor m41a(Activity activity) {
            if (this.f64b == null) {
                return PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext()).edit();
            }
            return this.f64b;
        }

        public void run() {
            try {
                Activity activity = (Activity) this.f63a.get();
                if (activity == null) {
                    C0299b.m380a("Activity was null while making a doritos cookie request.");
                    return;
                }
                Object obj;
                Cursor query = activity.getContentResolver().query(af.f60b, af.f62d, null, null, null);
                if (query == null || !query.moveToFirst() || query.getColumnNames().length <= 0) {
                    C0299b.m380a("Google+ app not installed, not storing doritos cookie");
                    obj = null;
                } else {
                    obj = query.getString(query.getColumnIndex(query.getColumnName(0)));
                }
                Editor a = m41a(activity);
                if (TextUtils.isEmpty(obj)) {
                    a.putString("drt", StringUtil.EMPTY_STRING);
                    a.putLong("drt_ts", 0);
                } else {
                    a.putString("drt", obj);
                    a.putLong("drt_ts", new Date().getTime());
                }
                a.commit();
            } catch (Throwable th) {
                C0299b.m385b("An unknown error occurred while sending a doritos request.", th);
            }
        }
    }

    /* renamed from: com.google.ads.ag.b */
    private static class C0222b implements Runnable {
        private final WeakReference<Activity> f65a;
        private final WebView f66b;
        private final String f67c;

        public C0222b(Activity activity, WebView webView, String str) {
            this.f65a = new WeakReference(activity);
            this.f67c = str;
            this.f66b = webView;
        }

        public void run() {
            try {
                Uri withAppendedPath = Uri.withAppendedPath(af.f59a, this.f67c);
                Activity activity = (Activity) this.f65a.get();
                if (activity == null) {
                    C0299b.m380a("Activity was null while getting the +1 button state.");
                    return;
                }
                boolean z;
                Cursor query = activity.getContentResolver().query(withAppendedPath, af.f61c, null, null, null);
                if (query == null || !query.moveToFirst()) {
                    C0299b.m380a("Google+ app not installed, showing ad as not +1'd");
                    z = false;
                } else {
                    z = query.getInt(query.getColumnIndex("has_plus1")) == 1;
                }
                this.f66b.post(new C0223c(this.f66b, z));
            } catch (Throwable th) {
                C0299b.m385b("An unknown error occurred while updating the +1 state.", th);
            }
        }
    }

    /* renamed from: com.google.ads.ag.c */
    static class C0223c implements Runnable {
        private final boolean f68a;
        private final WebView f69b;

        public C0223c(WebView webView, boolean z) {
            this.f69b = webView;
            this.f68a = z;
        }

        public void run() {
            ag.m45a(this.f69b, this.f68a);
        }
    }

    static {
        f70a = (C0254a) C0254a.f170a.m137b();
    }

    public static void m45a(WebView webView, boolean z) {
        f70a.m143a(webView, String.format(Locale.US, "(G_updatePlusOne(%b))", new Object[]{Boolean.valueOf(z)}));
    }

    public static void m44a(WebView webView, String str) {
        f70a.m143a(webView, String.format(Locale.US, "(G_resizeIframe(%s))", new Object[]{str}));
    }

    public static void m43a(Activity activity, WebView webView, String str) {
        new Thread(new C0222b(activity, webView, str)).start();
    }

    public static boolean m46a(Context context, long j) {
        return m47a(context, j, PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()));
    }

    static boolean m47a(Context context, long j, SharedPreferences sharedPreferences) {
        return ah.m48a(context) && !(sharedPreferences.contains("drt") && sharedPreferences.contains("drt_ts") && sharedPreferences.getLong("drt_ts", 0) >= new Date().getTime() - j);
    }

    public static void m42a(Activity activity) {
        new Thread(new C0221a(activity)).start();
    }
}
