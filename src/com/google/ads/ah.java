package com.google.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class ah {
    public static boolean m48a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
        return m49a(intent, context);
    }

    public static boolean m49a(Intent intent, Context context) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
