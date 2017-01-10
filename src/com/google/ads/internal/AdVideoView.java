package com.google.ads.internal;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.ads.util.C0299b;
import java.lang.ref.WeakReference;

public class AdVideoView extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private static final C0254a f157b;
    public MediaController f158a;
    private WeakReference<Activity> f159c;
    private AdWebView f160d;
    private long f161e;
    private VideoView f162f;
    private String f163g;

    /* renamed from: com.google.ads.internal.AdVideoView.a */
    private static class C0248a implements Runnable {
        private WeakReference<AdVideoView> f155a;
        private Handler f156b;

        public C0248a(AdVideoView adVideoView) {
            this.f155a = new WeakReference(adVideoView);
            this.f156b = new Handler();
        }

        public void run() {
            AdVideoView adVideoView = (AdVideoView) this.f155a.get();
            if (adVideoView == null) {
                C0299b.m388d("The video must be gone, so cancelling the timeupdate task.");
                return;
            }
            adVideoView.m130f();
            this.f156b.postDelayed(this, 250);
        }

        public void m122a() {
            this.f156b.postDelayed(this, 250);
        }
    }

    static {
        f157b = (C0254a) C0254a.f170a.m137b();
    }

    public AdVideoView(Activity adActivity, AdWebView adWebView) {
        super(adActivity);
        this.f159c = new WeakReference(adActivity);
        this.f160d = adWebView;
        this.f162f = new VideoView(adActivity);
        addView(this.f162f, new LayoutParams(-1, -1, 17));
        this.f158a = null;
        this.f163g = null;
        this.f161e = 0;
        m123a();
        this.f162f.setOnCompletionListener(this);
        this.f162f.setOnPreparedListener(this);
        this.f162f.setOnErrorListener(this);
    }

    protected void m123a() {
        new C0248a(this).m122a();
    }

    public void m126b() {
        if (TextUtils.isEmpty(this.f163g)) {
            f157b.m144a(this.f160d, "onVideoEvent", "{'event': 'error', 'what': 'no_src'}");
        } else {
            this.f162f.setVideoPath(this.f163g);
        }
    }

    public void setMediaControllerEnabled(boolean enabled) {
        Activity activity = (Activity) this.f159c.get();
        if (activity == null) {
            C0299b.m390e("adActivity was null while trying to enable controls on a video.");
        } else if (enabled) {
            if (this.f158a == null) {
                this.f158a = new MediaController(activity);
            }
            this.f162f.setMediaController(this.f158a);
        } else {
            if (this.f158a != null) {
                this.f158a.hide();
            }
            this.f162f.setMediaController(null);
        }
    }

    public void setSrc(String src) {
        this.f163g = src;
    }

    public void onCompletion(MediaPlayer mp) {
        f157b.m144a(this.f160d, "onVideoEvent", "{'event': 'ended'}");
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        C0299b.m390e("Video threw error! <what:" + what + ", extra:" + extra + ">");
        f157b.m144a(this.f160d, "onVideoEvent", "{'event': 'error', 'what': '" + what + "', 'extra': '" + extra + "'}");
        return true;
    }

    public void onPrepared(MediaPlayer mp) {
        f157b.m144a(this.f160d, "onVideoEvent", "{'event': 'canplaythrough', 'duration': '" + (((float) this.f162f.getDuration()) / 1000.0f) + "'}");
    }

    public void m127c() {
        this.f162f.pause();
    }

    public void m128d() {
        this.f162f.start();
    }

    public void m124a(int i) {
        this.f162f.seekTo(i);
    }

    public void m125a(MotionEvent motionEvent) {
        this.f162f.onTouchEvent(motionEvent);
    }

    public void m129e() {
        this.f162f.stopPlayback();
    }

    void m130f() {
        long currentPosition = (long) this.f162f.getCurrentPosition();
        if (this.f161e != currentPosition) {
            f157b.m144a(this.f160d, "onVideoEvent", "{'event': 'timeupdate', 'time': " + (((float) currentPosition) / 1000.0f) + "}");
            this.f161e = currentPosition;
        }
    }
}
