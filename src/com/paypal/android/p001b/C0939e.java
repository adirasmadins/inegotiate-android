package com.paypal.android.p001b;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.paypal.android.p003a.C0922e;

/* renamed from: com.paypal.android.b.e */
public final class C0939e extends LinearLayout {
    private AnimationDrawable f831a;

    public C0939e(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-2, -2));
        setPadding(10, 10, 10, 10);
        View linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LayoutParams(52, 29));
        View imageView = new ImageView(context);
        imageView.setLayoutParams(new LayoutParams(-1, -1));
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(C0922e.m670a(41031, 5362), 50);
        animationDrawable.addFrame(C0922e.m670a(176309, 5447), 50);
        animationDrawable.addFrame(C0922e.m670a(111874, 5446), 50);
        animationDrawable.addFrame(C0922e.m670a(72182, 5475), 50);
        animationDrawable.addFrame(C0922e.m670a(20096, 5400), 50);
        animationDrawable.addFrame(C0922e.m670a(154674, 5270), 50);
        animationDrawable.addFrame(C0922e.m670a(98231, 5423), 50);
        animationDrawable.addFrame(C0922e.m670a(57867, 5485), 50);
        animationDrawable.addFrame(C0922e.m670a(7623, 5470), 50);
        animationDrawable.addFrame(C0922e.m670a(133008, 5428), 50);
        animationDrawable.addFrame(C0922e.m670a(124672, 5415), 50);
        animationDrawable.addFrame(C0922e.m670a(83060, 5367), 50);
        animationDrawable.addFrame(C0922e.m670a(33070, 5362), 50);
        animationDrawable.addFrame(C0922e.m670a(169015, 5399), 50);
        animationDrawable.addFrame(C0922e.m670a(105998, 5412), 50);
        animationDrawable.addFrame(C0922e.m670a(66279, 5470), 50);
        animationDrawable.addFrame(C0922e.m670a(14681, 5415), 50);
        animationDrawable.addFrame(C0922e.m670a(139270, 5357), 50);
        animationDrawable.addFrame(C0922e.m670a(92086, 5303), 50);
        animationDrawable.addFrame(C0922e.m670a(52342, 5525), 50);
        animationDrawable.addFrame(C0922e.m670a(46393, 5524), 50);
        animationDrawable.addFrame(C0922e.m670a(0, 5487), 50);
        animationDrawable.addFrame(C0922e.m670a(119216, 5456), 50);
        animationDrawable.addFrame(C0922e.m670a(77657, 5403), 50);
        animationDrawable.addFrame(C0922e.m670a(27818, 5252), 50);
        animationDrawable.setOneShot(false);
        animationDrawable.setVisible(true, true);
        this.f831a = animationDrawable;
        imageView.setBackgroundDrawable(this.f831a);
        linearLayout.addView(imageView);
        addView(linearLayout);
    }

    public final void m742a() {
        this.f831a.stop();
        this.f831a.start();
    }

    public final void m743b() {
        this.f831a.stop();
    }
}
