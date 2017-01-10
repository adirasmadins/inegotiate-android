package com.paypal.android.p003a.p004a;

import com.paypal.android.p003a.C0931m;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* renamed from: com.paypal.android.a.a.f */
public final class C0911f {
    public C0906a f765a;
    public C0906a f766b;
    private String f767c;

    public static C0911f m563a(Element element) {
        if (element == null) {
            return null;
        }
        C0911f c0911f = new C0911f();
        NodeList elementsByTagName = element.getElementsByTagName("from");
        if (elementsByTagName.getLength() == 1) {
            c0911f.f765a = C0906a.m555a((Element) elementsByTagName.item(0));
        }
        elementsByTagName = element.getElementsByTagName("to");
        if (elementsByTagName.getLength() == 1) {
            c0911f.f766b = C0906a.m555a((Element) elementsByTagName.item(0));
        }
        elementsByTagName = element.getElementsByTagName("exchangeRate");
        if (elementsByTagName.getLength() != 1) {
            return null;
        }
        c0911f.f767c = C0931m.m701a(((Element) elementsByTagName.item(0)).getChildNodes());
        return c0911f;
    }

    public final String m564a() {
        return this.f767c;
    }
}
