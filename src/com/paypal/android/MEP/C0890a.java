package com.paypal.android.MEP;

/* renamed from: com.paypal.android.MEP.a */
public final class C0890a {
    private static C0890a f680a;

    /* renamed from: com.paypal.android.MEP.a.a */
    private class C0868a extends Thread {
        private C0869b f581a;

        public C0868a(C0890a c0890a, C0869b c0869b) {
            this.f581a = c0869b;
        }

        public final void run() {
            try {
                Thread.yield();
                Thread.sleep(3000);
            } catch (Throwable th) {
            }
            this.f581a.m438l();
        }
    }

    /* renamed from: com.paypal.android.MEP.a.b */
    public interface C0869b {
        void m435a(int i, Object obj);

        void m436a(String str, Object obj);

        void m437d(String str);

        void m438l();
    }

    static {
        f680a = null;
    }

    private C0890a() {
    }

    public static C0890a m511a() {
        if (f680a == null) {
            if (f680a != null) {
                throw new IllegalStateException("Attempted to initialize PPMobileAPIInterface more than once.");
            }
            f680a = new C0890a();
        }
        return f680a;
    }

    public final void m512a(C0869b c0869b) {
        new C0868a(this, c0869b).start();
    }

    public final void m513a(C0869b c0869b, String str, String str2) {
        C0868a c0868a = new C0868a(this, c0869b);
        c0869b.m436a("usernameOrPhone", (Object) str);
        c0869b.m436a("passwordOrPin", (Object) str2);
        c0868a.start();
    }

    public final void m514b(C0869b c0869b, String str, String str2) {
        C0868a c0868a = new C0868a(this, c0869b);
        c0869b.m436a("mobileNumber", (Object) str);
        c0869b.m436a("newPIN", (Object) str2);
        c0868a.start();
    }
}
