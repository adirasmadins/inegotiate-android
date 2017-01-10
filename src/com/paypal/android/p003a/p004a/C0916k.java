package com.paypal.android.p003a.p004a;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* renamed from: com.paypal.android.a.a.k */
public final class C0916k {
    public C0906a f783a;
    public C0912g f784b;

    public C0916k() {
        this.f783a = null;
        this.f784b = null;
    }

    public static C0916k m587a(Element element) {
        if (element == null) {
            return null;
        }
        C0916k c0916k = new C0916k();
        c0916k.f783a = null;
        c0916k.f784b = null;
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Element element2 = (Element) childNodes.item(i);
            String tagName = element2.getTagName();
            if (tagName.equals("charge")) {
                C0906a a = C0906a.m555a(element2);
                if (a != null) {
                    c0916k.f783a = a;
                }
            } else if (tagName.equals("fundingSource")) {
                C0912g a2 = C0912g.m565a(element2);
                if (a2 != null) {
                    c0916k.f784b = a2;
                }
            }
        }
        return (c0916k.f783a == null || c0916k.f784b == null) ? null : c0916k;
    }
}
