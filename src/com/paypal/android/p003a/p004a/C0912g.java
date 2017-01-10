package com.paypal.android.p003a.p004a;

import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0931m;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* renamed from: com.paypal.android.a.a.g */
public final class C0912g {
    private String f768a;
    private String f769b;

    public static C0912g m565a(Element element) {
        if (element == null) {
            return null;
        }
        C0912g c0912g = new C0912g();
        NodeList elementsByTagName = element.getElementsByTagName("type");
        if (elementsByTagName.getLength() != 1) {
            return null;
        }
        c0912g.f769b = C0931m.m701a(((Element) elementsByTagName.item(0)).getChildNodes());
        NodeList elementsByTagName2 = element.getElementsByTagName("lastFourOfAccountNumber");
        if (elementsByTagName2.getLength() == 1) {
            c0912g.f768a = C0931m.m701a(((Element) elementsByTagName2.item(0)).getChildNodes());
        }
        elementsByTagName2 = element.getElementsByTagName("displayName");
        if (elementsByTagName2.getLength() == 1) {
            C0931m.m701a(((Element) elementsByTagName2.item(0)).getChildNodes());
        }
        return c0912g;
    }

    public final String m566a() {
        return this.f769b != null ? this.f769b.equals("BALANCE") ? C0925h.m680a("ANDROID_balance") : (this.f769b.equals("BANK_DELAYED") || this.f769b.equals("BANK_INSTANT")) ? C0925h.m680a("ANDROID_bank") : (this.f769b.equals("CREDITCARD") || this.f769b.equals("DEBITCARD")) ? C0925h.m680a("ANDROID_card") : this.f769b : StringUtil.EMPTY_STRING;
    }

    public final void m567a(String str) {
        this.f768a = str;
    }

    public final String m568b() {
        return this.f768a;
    }

    public final void m569b(String str) {
        this.f769b = str;
    }

    public final String m570c() {
        return this.f769b;
    }
}
