package com.google.ads.util;

import com.google.gdata.util.common.base.StringUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.ads.util.i */
public abstract class C0278i {
    private static final Object f295a;
    private static int f296b;
    private static HashMap<Class<?>, Integer> f297c;
    private final ArrayList<C0319a<?>> f298d;
    public final int f299o;

    /* renamed from: com.google.ads.util.i.a */
    public abstract class C0319a<T> {
        protected T f422a;
        protected final String f423b;
        final /* synthetic */ C0278i f424c;

        private C0319a(C0278i c0278i, String str) {
            this(c0278i, str, null);
        }

        private C0319a(C0278i c0278i, String str, T t) {
            this.f424c = c0278i;
            this.f423b = str;
            c0278i.m307a(this);
            this.f422a = t;
        }

        public String toString() {
            return this.f424c.toString() + "." + this.f423b + " = " + this.f422a;
        }
    }

    /* renamed from: com.google.ads.util.i.b */
    public final class C0320b<T> extends C0319a<T> {
        final /* synthetic */ C0278i f425d;

        public C0320b(C0278i c0278i, String str, T t) {
            this.f425d = c0278i;
            super(str, t, null);
        }

        public T m411a() {
            return this.a;
        }

        public String toString() {
            return super.toString() + " (!)";
        }
    }

    /* renamed from: com.google.ads.util.i.c */
    public final class C0321c<T> extends C0319a<T> {
        final /* synthetic */ C0278i f426d;
        private boolean f427e;

        public C0321c(C0278i c0278i, String str) {
            this.f426d = c0278i;
            super(str, null);
            this.f427e = false;
            this.f427e = false;
        }

        public C0321c(C0278i c0278i, String str, T t) {
            this.f426d = c0278i;
            super(str, t, null);
            this.f427e = false;
            this.f427e = false;
        }

        public synchronized T m412a() {
            return this.a;
        }

        public synchronized void m413a(T t) {
            C0299b.m388d("State changed - " + this.f426d.toString() + "." + this.b + ": '" + t + "' <-- '" + this.a + "'.");
            this.a = t;
            this.f427e = true;
        }

        public String toString() {
            return super.toString() + (this.f427e ? " (*)" : StringUtil.EMPTY_STRING);
        }
    }

    /* renamed from: com.google.ads.util.i.d */
    public final class C0322d<T> extends C0319a<WeakReference<T>> {
        final /* synthetic */ C0278i f428d;

        public C0322d(C0278i c0278i, String str, T t) {
            this.f428d = c0278i;
            super(str, new WeakReference(t), null);
        }

        public T m414a() {
            return ((WeakReference) this.a).get();
        }

        public String toString() {
            return this.f428d.toString() + "." + this.b + " = " + m414a() + " (?)";
        }
    }

    static {
        f295a = new Object();
        f296b = 0;
        f297c = new HashMap();
    }

    public C0278i() {
        this.f298d = new ArrayList();
        synchronized (f295a) {
            int i = f296b;
            f296b = i + 1;
            this.f299o = i;
            Integer num = (Integer) f297c.get(getClass());
            if (num == null) {
                f297c.put(getClass(), Integer.valueOf(1));
            } else {
                f297c.put(getClass(), Integer.valueOf(num.intValue() + 1));
            }
        }
        C0299b.m388d("State created: " + toString());
    }

    protected void finalize() throws Throwable {
        synchronized (f295a) {
            f297c.put(getClass(), Integer.valueOf(((Integer) f297c.get(getClass())).intValue() - 1));
        }
        super.finalize();
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.f299o + "]";
    }

    private void m307a(C0319a<?> c0319a) {
        this.f298d.add(c0319a);
    }
}
