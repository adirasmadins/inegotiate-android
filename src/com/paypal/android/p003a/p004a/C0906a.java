package com.paypal.android.p003a.p004a;

import com.paypal.android.p003a.C0931m;
import java.math.BigDecimal;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* renamed from: com.paypal.android.a.a.a */
public final class C0906a {
    private BigDecimal f741a;
    private String f742b;

    public static C0906a m555a(Element element) {
        if (element == null) {
            return null;
        }
        C0906a c0906a = new C0906a();
        NodeList elementsByTagName = element.getElementsByTagName("code");
        if (elementsByTagName.getLength() != 1) {
            return null;
        }
        c0906a.f742b = C0931m.m701a(((Element) elementsByTagName.item(0)).getChildNodes());
        elementsByTagName = element.getElementsByTagName("amount");
        if (elementsByTagName.getLength() != 1) {
            return null;
        }
        c0906a.m557a(C0931m.m701a(((Element) elementsByTagName.item(0)).getChildNodes()));
        return c0906a;
    }

    public final BigDecimal m556a() {
        return this.f741a;
    }

    public final void m557a(String str) {
        try {
            this.f741a = new BigDecimal(str);
        } catch (NumberFormatException e) {
            this.f741a = new BigDecimal("0.0");
        }
    }

    public final String m558b() {
        return this.f742b;
    }

    public final void m559b(String str) {
        this.f742b = str;
    }
}
