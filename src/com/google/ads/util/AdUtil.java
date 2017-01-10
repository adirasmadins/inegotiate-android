package com.google.ads.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.google.ads.AdActivity;
import com.google.ads.AdRequest;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import com.google.gdata.data.docs.AudioEntry;
import com.google.gdata.data.docs.DocumentListEntry;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AdUtil {
    public static final int f371a;
    private static Boolean f372b;
    private static String f373c;
    private static String f374d;
    private static String f375e;
    private static AudioManager f376f;
    private static boolean f377g;
    private static boolean f378h;
    private static String f379i;

    public static class UserActivityReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                AdUtil.m346a(true);
            } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                AdUtil.m346a(false);
            }
        }
    }

    /* renamed from: com.google.ads.util.AdUtil.a */
    public enum C0294a {
        INVALID,
        SPEAKER,
        HEADPHONES,
        VIBRATE,
        EMULATOR,
        OTHER
    }

    static {
        f371a = m337a(VERSION.SDK);
        f372b = null;
        f373c = null;
        f375e = null;
        f377g = true;
        f378h = false;
        f379i = null;
    }

    public static boolean m348a(Intent intent, Context context) {
        return context.getPackageManager().resolveActivity(intent, 65536) != null;
    }

    public static String m341a(Readable readable) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence allocate = CharBuffer.allocate(ProgressEvent.PART_COMPLETED_EVENT_CODE);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return stringBuilder.toString();
            }
            allocate.flip();
            stringBuilder.append(allocate, 0, read);
        }
    }

    public static int m337a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            C0299b.m390e("The Android SDK version couldn't be parsed to an int: " + VERSION.SDK);
            C0299b.m390e("Defaulting to Android SDK version 3.");
            return 3;
        }
    }

    public static String m339a(Context context) {
        if (f373c == null) {
            String string = Secure.getString(context.getContentResolver(), "android_id");
            if (string == null || m359c()) {
                string = m354b("emulator");
            } else {
                string = m354b(string);
            }
            if (string == null) {
                return null;
            }
            f373c = string.toUpperCase(Locale.US);
        }
        return f373c;
    }

    public static int m335a() {
        if (f371a >= 9) {
            return 6;
        }
        return 0;
    }

    public static int m351b() {
        if (f371a >= 9) {
            return 7;
        }
        return 1;
    }

    public static int m336a(Context context, DisplayMetrics displayMetrics) {
        if (f371a >= 4) {
            return C0305e.m401a(context, displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int m352b(Context context, DisplayMetrics displayMetrics) {
        if (f371a >= 4) {
            return C0305e.m402b(context, displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static boolean m357b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        if (packageManager.checkPermission("android.permission.INTERNET", packageName) == -1) {
            C0299b.m384b("INTERNET permissions must be enabled in AndroidManifest.xml.");
            return false;
        } else if (packageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", packageName) != -1) {
            return true;
        } else {
            C0299b.m384b("ACCESS_NETWORK_STATE permissions must be enabled in AndroidManifest.xml.");
            return false;
        }
    }

    public static boolean m347a(int i, int i2, String str) {
        if ((i & i2) != 0) {
            return true;
        }
        C0299b.m384b("The android:configChanges value of the com.google.ads.AdActivity must include " + str + ".");
        return false;
    }

    public static boolean m360c(Context context) {
        if (f372b != null) {
            return f372b.booleanValue();
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent(context, AdActivity.class), 65536);
        f372b = Boolean.valueOf(true);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            C0299b.m384b("Could not find com.google.ads.AdActivity, please make sure it is registered in AndroidManifest.xml.");
            f372b = Boolean.valueOf(false);
        } else {
            if (!m347a(resolveActivity.activityInfo.configChanges, 16, "keyboard")) {
                f372b = Boolean.valueOf(false);
            }
            if (!m347a(resolveActivity.activityInfo.configChanges, 32, "keyboardHidden")) {
                f372b = Boolean.valueOf(false);
            }
            if (!m347a(resolveActivity.activityInfo.configChanges, XMLChar.MASK_NCNAME, "orientation")) {
                f372b = Boolean.valueOf(false);
            }
            if (!m347a(resolveActivity.activityInfo.configChanges, 256, "screenLayout")) {
                f372b = Boolean.valueOf(false);
            }
            if (!m347a(resolveActivity.activityInfo.configChanges, 512, "uiMode")) {
                f372b = Boolean.valueOf(false);
            }
            if (!m347a(resolveActivity.activityInfo.configChanges, ProgressEvent.PART_STARTED_EVENT_CODE, "screenSize")) {
                f372b = Boolean.valueOf(false);
            }
            if (!m347a(resolveActivity.activityInfo.configChanges, ProgressEvent.PART_COMPLETED_EVENT_CODE, "smallestScreenSize")) {
                f372b = Boolean.valueOf(false);
            }
        }
        return f372b.booleanValue();
    }

    public static boolean m359c() {
        return m350a(null);
    }

    static boolean m350a(C0304d c0304d) {
        if (c0304d == null) {
            c0304d = C0304d.f408d;
        }
        return c0304d.equals(C0304d.f409e);
    }

    public static boolean m349a(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
            return true;
        }
        return false;
    }

    public static String m354b(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            MessageDigest.getInstance("MD5").update(str.getBytes(), 0, str.length());
            return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r0.digest())});
        } catch (NoSuchAlgorithmException e) {
            return str.substring(0, 32);
        }
    }

    public static String m361d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        switch (activeNetworkInfo.getType()) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return "ed";
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return "wi";
            default:
                return DocumentListEntry.UNKNOWN_LABEL;
        }
    }

    public static String m363e(Context context) {
        if (f374d == null) {
            StringBuilder stringBuilder = new StringBuilder();
            PackageManager packageManager = context.getPackageManager();
            List queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=donuts")), 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
                stringBuilder.append(AdActivity.TYPE_PARAM);
            }
            queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.google")), 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append("a");
            }
            List queryIntentActivities2 = packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("tel://6509313940")), 65536);
            if (queryIntentActivities2 == null || queryIntentActivities2.size() == 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append("t");
            }
            f374d = stringBuilder.toString();
        }
        return f374d;
    }

    public static String m364f(Context context) {
        if (f375e != null) {
            return f375e;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads")), 65536);
            if (resolveActivity == null) {
                return null;
            }
            ActivityInfo activityInfo = resolveActivity.activityInfo;
            if (activityInfo == null) {
                return null;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo == null) {
                return null;
            }
            f375e = packageInfo.versionCode + "." + activityInfo.packageName;
            return f375e;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static C0294a m365g(Context context) {
        if (f376f == null) {
            f376f = (AudioManager) context.getSystemService(AudioEntry.LABEL);
        }
        C0294a c0294a = C0294a.OTHER;
        int mode = f376f.getMode();
        if (m359c()) {
            return C0294a.EMULATOR;
        }
        if (f376f.isMusicActive() || f376f.isSpeakerphoneOn() || mode == 2 || mode == 1) {
            return C0294a.VIBRATE;
        }
        mode = f376f.getRingerMode();
        if (mode == 0 || mode == 1) {
            return C0294a.VIBRATE;
        }
        return C0294a.SPEAKER;
    }

    public static DisplayMetrics m338a(Activity activity) {
        if (activity.getWindowManager() == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String m340a(Location location) {
        if (location == null) {
            return null;
        }
        return "e1+" + m358c(m353b(location));
    }

    private static String m353b(Location location) {
        return String.format(Locale.US, "role: 6 producer: 24 historical_role: 1 historical_producer: 12 timestamp: %d latlng < latitude_e7: %d longitude_e7: %d> radius: %d", new Object[]{Long.valueOf(location.getTime() * 1000), Long.valueOf((long) (location.getLatitude() * 1.0E7d)), Long.valueOf((long) (location.getLongitude() * 1.0E7d)), Long.valueOf((long) (location.getAccuracy() * 1000.0f))});
    }

    private static String m358c(String str) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, new SecretKeySpec(new byte[]{(byte) 10, (byte) 55, (byte) -112, (byte) -47, (byte) -6, (byte) 7, Ascii.VT, (byte) 75, (byte) -7, (byte) -121, (byte) 121, (byte) 69, (byte) 80, (byte) -61, Ascii.SI, (byte) 5}, "AES"));
            Object iv = instance.getIV();
            Object doFinal = instance.doFinal(str.getBytes());
            Object obj = new byte[(iv.length + doFinal.length)];
            System.arraycopy(iv, 0, obj, 0, iv.length);
            System.arraycopy(doFinal, 0, obj, iv.length, doFinal.length);
            return C0303c.m396b(obj, 11);
        } catch (GeneralSecurityException e) {
            return null;
        }
    }

    public static HashMap<String, String> m355b(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap();
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery != null) {
            for (String str : encodedQuery.split("&")) {
                int indexOf = str.indexOf("=");
                if (indexOf < 0) {
                    hashMap.put(Uri.decode(str), null);
                } else {
                    hashMap.put(Uri.decode(str.substring(0, indexOf)), Uri.decode(str.substring(indexOf + 1, str.length())));
                }
            }
        }
        return hashMap;
    }

    public static boolean m362d() {
        return f377g;
    }

    public static void m346a(boolean z) {
        f377g = z;
    }

    public static void m366h(Context context) {
        if (!f378h) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new UserActivityReceiver(), intentFilter);
            f378h = true;
        }
    }

    public static String m367i(Context context) {
        if (f379i == null) {
            String userAgentString = new WebView(context).getSettings().getUserAgentString();
            if (userAgentString == null || userAgentString.length() == 0 || userAgentString.equals("Java0")) {
                String property = System.getProperty("os.name", "Linux");
                String str = "Android " + VERSION.RELEASE;
                Locale locale = Locale.getDefault();
                userAgentString = locale.getLanguage().toLowerCase(Locale.US);
                if (userAgentString.length() == 0) {
                    userAgentString = "en";
                }
                String toLowerCase = locale.getCountry().toLowerCase(Locale.US);
                if (toLowerCase.length() > 0) {
                    userAgentString = userAgentString + "-" + toLowerCase;
                }
                userAgentString = "Mozilla/5.0 (" + property + "; U; " + str + "; " + userAgentString + "; " + (Build.MODEL + " Build/" + Build.ID) + ") AppleWebKit/0.0 (KHTML, like " + "Gecko) Version/0.0 Mobile Safari/0.0";
            }
            f379i = userAgentString + " (Mobile; " + "afma-sdk-a-v" + AdRequest.VERSION + ")";
        }
        return f379i;
    }

    public static void m344a(WebView webView) {
        webView.getSettings().setUserAgentString(m367i(webView.getContext().getApplicationContext()));
    }

    public static void m345a(HttpURLConnection httpURLConnection, Context context) {
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, m367i(context));
    }

    public static String m342a(Map<String, Object> map) {
        String str = null;
        try {
            str = m356b((Map) map).toString();
        } catch (Throwable e) {
            C0299b.m389d("JsonException in serialization: ", e);
        }
        return str;
    }

    public static JSONObject m356b(Map<String, Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (map == null || map.isEmpty()) {
            return jSONObject;
        }
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Float)) {
                jSONObject.put(str, obj);
            } else if (obj instanceof Map) {
                try {
                    jSONObject.put(str, m356b((Map) obj));
                } catch (Throwable e) {
                    C0299b.m389d("Unknown map type in json serialization: ", e);
                }
            } else if (obj instanceof Set) {
                try {
                    jSONObject.put(str, m343a((Set) obj));
                } catch (Throwable e2) {
                    C0299b.m389d("Unknown map type in json serialization: ", e2);
                }
            } else {
                C0299b.m390e("Unknown value in json serialization: " + obj);
            }
        }
        return jSONObject;
    }

    public static JSONArray m343a(Set<Object> set) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (set == null || set.isEmpty()) {
            return jSONArray;
        }
        for (Object next : set) {
            if ((next instanceof String) || (next instanceof Integer) || (next instanceof Double) || (next instanceof Long) || (next instanceof Float)) {
                jSONArray.put(next);
            } else if (next instanceof Map) {
                try {
                    jSONArray.put(m356b((Map) next));
                } catch (Throwable e) {
                    C0299b.m389d("Unknown map type in json serialization: ", e);
                }
            } else if (next instanceof Set) {
                try {
                    jSONArray.put(m343a((Set) next));
                } catch (Throwable e2) {
                    C0299b.m389d("Unknown map type in json serialization: ", e2);
                }
            } else {
                C0299b.m390e("Unknown value in json serialization: " + next);
            }
        }
        return jSONArray;
    }
}
