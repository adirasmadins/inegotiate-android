package com.paypal.android.p001b;

import android.view.animation.Animation;

/* renamed from: com.paypal.android.b.l */
public final class C0945l extends Thread {
    private C0872j f844a;
    private Animation f845b;

    public C0945l(C0872j c0872j, Animation animation) {
        this.f844a = c0872j;
        this.f845b = animation;
    }

    public final void run() {
        this.f844a.startAnimation(this.f845b);
    }
}
