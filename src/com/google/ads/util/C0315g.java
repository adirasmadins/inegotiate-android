package com.google.ads.util;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.ads.C0220n;
import com.google.ads.C0280l;
import com.google.ads.C0280l.C0279a;
import com.google.ads.C0281m;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0263c;
import com.google.ads.internal.C0264d;
import com.google.ads.internal.C0271i;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.codehaus.jackson.impl.JsonWriteContext;

@TargetApi(11)
/* renamed from: com.google.ads.util.g */
public class C0315g {

    /* renamed from: com.google.ads.util.g.1 */
    static /* synthetic */ class C03061 {
        static final /* synthetic */ int[] f413a;

        static {
            f413a = new int[MessageLevel.values().length];
            try {
                f413a[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f413a[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f413a[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f413a[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f413a[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: com.google.ads.util.g.a */
    public static class C0313a extends WebChromeClient {
        private final C0281m f421a;

        /* renamed from: com.google.ads.util.g.a.1 */
        static class C03071 implements OnCancelListener {
            final /* synthetic */ JsResult f414a;

            C03071(JsResult jsResult) {
                this.f414a = jsResult;
            }

            public void onCancel(DialogInterface dialog) {
                this.f414a.cancel();
            }
        }

        /* renamed from: com.google.ads.util.g.a.2 */
        static class C03082 implements OnClickListener {
            final /* synthetic */ JsResult f415a;

            C03082(JsResult jsResult) {
                this.f415a = jsResult;
            }

            public void onClick(DialogInterface dialog, int which) {
                this.f415a.cancel();
            }
        }

        /* renamed from: com.google.ads.util.g.a.3 */
        static class C03093 implements OnClickListener {
            final /* synthetic */ JsResult f416a;

            C03093(JsResult jsResult) {
                this.f416a = jsResult;
            }

            public void onClick(DialogInterface dialog, int which) {
                this.f416a.confirm();
            }
        }

        /* renamed from: com.google.ads.util.g.a.4 */
        static class C03104 implements OnCancelListener {
            final /* synthetic */ JsPromptResult f417a;

            C03104(JsPromptResult jsPromptResult) {
                this.f417a = jsPromptResult;
            }

            public void onCancel(DialogInterface dialog) {
                this.f417a.cancel();
            }
        }

        /* renamed from: com.google.ads.util.g.a.5 */
        static class C03115 implements OnClickListener {
            final /* synthetic */ JsPromptResult f418a;

            C03115(JsPromptResult jsPromptResult) {
                this.f418a = jsPromptResult;
            }

            public void onClick(DialogInterface dialog, int which) {
                this.f418a.cancel();
            }
        }

        /* renamed from: com.google.ads.util.g.a.6 */
        static class C03126 implements OnClickListener {
            final /* synthetic */ JsPromptResult f419a;
            final /* synthetic */ EditText f420b;

            C03126(JsPromptResult jsPromptResult, EditText editText) {
                this.f419a = jsPromptResult;
                this.f420b = editText;
            }

            public void onClick(DialogInterface dialog, int which) {
                this.f419a.confirm(this.f420b.getText().toString());
            }
        }

        public C0313a(C0281m c0281m) {
            this.f421a = c0281m;
        }

        public void onCloseWindow(WebView webView) {
            if (webView instanceof AdWebView) {
                ((AdWebView) webView).m131a();
            }
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
            switch (C03061.f413a[consoleMessage.messageLevel().ordinal()]) {
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    C0299b.m384b(str);
                    break;
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                    C0299b.m390e(str);
                    break;
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                    C0299b.m386c(str);
                    break;
                case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                    C0299b.m380a(str);
                    break;
            }
            return super.onConsoleMessage(consoleMessage);
        }

        public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, QuotaUpdater quotaUpdater) {
            C0279a c0279a = (C0279a) ((C0280l) this.f421a.f314a.m411a()).f313a.m411a();
            long longValue = ((Long) c0279a.f308i.m412a()).longValue() - totalUsedQuota;
            if (longValue <= 0) {
                quotaUpdater.updateQuota(currentQuota);
                return;
            }
            if (currentQuota == 0) {
                if (estimatedSize > longValue || estimatedSize > ((Long) c0279a.f309j.m412a()).longValue()) {
                    estimatedSize = 0;
                }
            } else if (estimatedSize == 0) {
                estimatedSize = Math.min(Math.min(((Long) c0279a.f310k.m412a()).longValue(), longValue) + currentQuota, ((Long) c0279a.f309j.m412a()).longValue());
            } else {
                if (estimatedSize <= Math.min(((Long) c0279a.f309j.m412a()).longValue() - currentQuota, longValue)) {
                    currentQuota += estimatedSize;
                }
                estimatedSize = currentQuota;
            }
            quotaUpdater.updateQuota(estimatedSize);
        }

        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return C0313a.m405a(view, url, message, null, result, null, false);
        }

        public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
            return C0313a.m405a(view, url, message, null, result, null, false);
        }

        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            return C0313a.m405a(view, url, message, null, result, null, false);
        }

        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return C0313a.m405a(view, url, message, defaultValue, null, result, true);
        }

        public void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, QuotaUpdater quotaUpdater) {
            C0279a c0279a = (C0279a) ((C0280l) this.f421a.f314a.m411a()).f313a.m411a();
            long longValue = ((Long) c0279a.f306g.m412a()).longValue() + spaceNeeded;
            if (((Long) c0279a.f307h.m412a()).longValue() - totalUsedQuota < longValue) {
                quotaUpdater.updateQuota(0);
            } else {
                quotaUpdater.updateQuota(longValue);
            }
        }

        public void onShowCustomView(View view, CustomViewCallback callback) {
            callback.onCustomViewHidden();
        }

        private static boolean m405a(WebView webView, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
            if (webView instanceof AdWebView) {
                Context d = ((AdWebView) webView).m134d();
                if (d != null) {
                    Builder builder = new Builder(d);
                    builder.setTitle(str);
                    if (z) {
                        C0313a.m403a(builder, d, str2, str3, jsPromptResult);
                    } else {
                        C0313a.m404a(builder, str2, jsResult);
                    }
                    return true;
                }
            }
            return false;
        }

        private static void m404a(Builder builder, String str, JsResult jsResult) {
            builder.setMessage(str).setPositiveButton(17039370, new C03093(jsResult)).setNegativeButton(17039360, new C03082(jsResult)).setOnCancelListener(new C03071(jsResult)).create().show();
        }

        private static void m403a(Builder builder, Context context, String str, String str2, JsPromptResult jsPromptResult) {
            View linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            View textView = new TextView(context);
            textView.setText(str);
            View editText = new EditText(context);
            editText.setText(str2);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            builder.setView(linearLayout).setPositiveButton(17039370, new C03126(jsPromptResult, editText)).setNegativeButton(17039360, new C03115(jsPromptResult)).setOnCancelListener(new C03104(jsPromptResult)).create().show();
        }
    }

    /* renamed from: com.google.ads.util.g.b */
    public static class C0314b extends C0271i {
        public C0314b(C0264d c0264d, Map<String, C0220n> map, boolean z, boolean z2) {
            super(c0264d, map, z, z2);
        }

        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            try {
                if ("mraid.js".equalsIgnoreCase(new File(url).getName())) {
                    C0263c j = this.a.m221j();
                    if (j != null) {
                        j.m180b(true);
                    } else {
                        this.a.m208a(true);
                    }
                    C0279a c0279a = (C0279a) ((C0280l) this.a.m219h().f314a.m411a()).f313a.m411a();
                    String str;
                    if (this.a.m219h().m311b()) {
                        str = (String) c0279a.f304e.m412a();
                        C0299b.m380a("shouldInterceptRequest(" + str + ")");
                        return C0314b.m406a(str, view.getContext());
                    } else if (this.b) {
                        str = (String) c0279a.f303d.m412a();
                        C0299b.m380a("shouldInterceptRequest(" + str + ")");
                        return C0314b.m406a(str, view.getContext());
                    } else {
                        str = (String) c0279a.f302c.m412a();
                        C0299b.m380a("shouldInterceptRequest(" + str + ")");
                        return C0314b.m406a(str, view.getContext());
                    }
                }
            } catch (Throwable e) {
                C0299b.m389d("IOException fetching MRAID JS.", e);
            } catch (Throwable e2) {
                C0299b.m385b("An unknown error occurred fetching MRAID JS.", e2);
            }
            return super.shouldInterceptRequest(view, url);
        }

        private static WebResourceResponse m406a(String str, Context context) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                AdUtil.m345a(httpURLConnection, context.getApplicationContext());
                httpURLConnection.connect();
                String a = AdUtil.m341a(new InputStreamReader(httpURLConnection.getInputStream()));
                String str2 = StringEncodings.UTF8;
                WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", str2, new ByteArrayInputStream(a.getBytes(str2)));
                return webResourceResponse;
            } finally {
                httpURLConnection.disconnect();
            }
        }
    }

    public static void m409a(WebSettings webSettings, C0281m c0281m) {
        Context context = (Context) c0281m.f319f.m411a();
        C0279a c0279a = (C0279a) ((C0280l) c0281m.f314a.m411a()).f313a.m411a();
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCacheMaxSize(((Long) c0279a.f305f.m412a()).longValue());
        webSettings.setAppCachePath(new File(context.getCacheDir(), "admob").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDatabasePath(context.getDatabasePath("admob").getAbsolutePath());
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
    }

    public static void m407a(View view) {
        view.setLayerType(1, null);
    }

    public static void m410b(View view) {
        view.setLayerType(0, null);
    }

    public static void m408a(Window window) {
        window.setFlags(16777216, 16777216);
    }
}
