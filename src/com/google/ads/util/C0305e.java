package com.google.ads.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.DisplayMetrics;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UCSReader;

@TargetApi(4)
/* renamed from: com.google.ads.util.e */
public final class C0305e {
    public static int m401a(Context context, DisplayMetrics displayMetrics) {
        return C0305e.m400a(context, displayMetrics.density, displayMetrics.heightPixels);
    }

    public static int m402b(Context context, DisplayMetrics displayMetrics) {
        return C0305e.m400a(context, displayMetrics.density, displayMetrics.widthPixels);
    }

    private static int m400a(Context context, float f, int i) {
        if ((context.getApplicationInfo().flags & UCSReader.DEFAULT_BUFFER_SIZE) != 0) {
            return (int) (((float) i) / f);
        }
        return i;
    }
}
