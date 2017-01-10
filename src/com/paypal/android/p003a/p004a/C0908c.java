package com.paypal.android.p003a.p004a;

import com.paypal.android.p003a.C0931m;
import java.util.Vector;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* renamed from: com.paypal.android.a.a.c */
public final class C0908c {
    public C0906a f745a;
    public C0906a f746b;
    public C0911f f747c;
    public Vector<C0916k> f748d;
    private String f749e;

    public static C0908c m560a(Element element) {
        int i = 0;
        if (element == null) {
            return null;
        }
        C0908c c0908c = new C0908c();
        NodeList elementsByTagName = element.getElementsByTagName("fundingPlanId");
        if (elementsByTagName.getLength() != 1) {
            return null;
        }
        c0908c.f749e = C0931m.m701a(((Element) elementsByTagName.item(0)).getChildNodes());
        elementsByTagName = element.getElementsByTagName("fundingAmount");
        if (elementsByTagName.getLength() != 1) {
            return null;
        }
        c0908c.f745a = C0906a.m555a((Element) elementsByTagName.item(0));
        elementsByTagName = element.getElementsByTagName("backupFundingSource");
        if (elementsByTagName.getLength() == 1) {
            C0912g.m565a((Element) elementsByTagName.item(0));
        }
        elementsByTagName = element.getElementsByTagName("senderFees");
        if (elementsByTagName.getLength() == 1) {
            c0908c.f746b = C0906a.m555a((Element) elementsByTagName.item(0));
        }
        elementsByTagName = element.getElementsByTagName("currencyConversion");
        if (elementsByTagName.getLength() == 1) {
            c0908c.f747c = C0911f.m563a((Element) elementsByTagName.item(0));
        }
        c0908c.f748d = new Vector();
        NodeList elementsByTagName2 = element.getElementsByTagName("charge");
        while (i < elementsByTagName2.getLength()) {
            C0916k a = C0916k.m587a((Element) elementsByTagName2.item(i));
            if (a != null) {
                c0908c.f748d.add(a);
            }
            i++;
        }
        return c0908c;
    }

    public final String m561a() {
        return this.f749e;
    }

    public final void m562a(String str) {
        this.f749e = str;
    }
}
