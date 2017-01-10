package com.google.ads;

import com.google.ads.internal.C0264d;
import com.google.ads.util.C0299b;
import java.lang.ref.WeakReference;

public class ae implements Runnable {
    private WeakReference<C0264d> f58a;

    public ae(C0264d c0264d) {
        this.f58a = new WeakReference(c0264d);
    }

    public void run() {
        C0264d c0264d = (C0264d) this.f58a.get();
        if (c0264d == null) {
            C0299b.m380a("The ad must be gone, so cancelling the refresh timer.");
        } else {
            c0264d.m236y();
        }
    }
}
