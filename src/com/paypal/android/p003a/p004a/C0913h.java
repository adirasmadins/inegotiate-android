package com.paypal.android.p003a.p004a;

import com.paypal.android.p003a.C0931m;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* renamed from: com.paypal.android.a.a.h */
public final class C0913h {
    private String f770a;
    private String f771b;
    private String f772c;
    private String f773d;
    private String f774e;
    private String f775f;
    private String f776g;
    private String f777h;

    public C0913h() {
        this.f770a = null;
        this.f771b = null;
        this.f772c = null;
        this.f773d = null;
        this.f774e = null;
        this.f775f = null;
        this.f776g = null;
        this.f777h = null;
    }

    public final String m571a() {
        return this.f770a;
    }

    public final void m572a(String str) {
        this.f771b = str;
    }

    public final boolean m573a(Element element) {
        NodeList elementsByTagName = element.getElementsByTagName("baseAddress");
        if (elementsByTagName.getLength() == 0) {
            return false;
        }
        Element element2 = (Element) elementsByTagName.item(0);
        NodeList elementsByTagName2 = element2.getElementsByTagName("line1");
        if (elementsByTagName2.getLength() == 0) {
            return false;
        }
        this.f773d = C0931m.m701a(((Element) elementsByTagName2.item(0)).getChildNodes());
        elementsByTagName2 = element2.getElementsByTagName("line2");
        if (elementsByTagName2.getLength() > 0) {
            this.f774e = C0931m.m701a(((Element) elementsByTagName2.item(0)).getChildNodes());
        }
        elementsByTagName2 = element2.getElementsByTagName("city");
        if (elementsByTagName2.getLength() == 0) {
            return false;
        }
        this.f771b = C0931m.m701a(((Element) elementsByTagName2.item(0)).getChildNodes());
        elementsByTagName2 = element2.getElementsByTagName("state");
        if (elementsByTagName2.getLength() > 0) {
            this.f776g = C0931m.m701a(((Element) elementsByTagName2.item(0)).getChildNodes());
        }
        elementsByTagName2 = element2.getElementsByTagName("postalCode");
        if (elementsByTagName2.getLength() > 0) {
            this.f775f = C0931m.m701a(((Element) elementsByTagName2.item(0)).getChildNodes());
        }
        elementsByTagName2 = element2.getElementsByTagName("countryCode");
        if (elementsByTagName2.getLength() == 0) {
            return false;
        }
        this.f772c = C0931m.m701a(((Element) elementsByTagName2.item(0)).getChildNodes());
        elementsByTagName = element2.getElementsByTagName("type");
        if (elementsByTagName.getLength() > 0) {
            C0931m.m701a(((Element) elementsByTagName.item(0)).getChildNodes());
        }
        elementsByTagName = element.getElementsByTagName("addressId");
        if (elementsByTagName.getLength() == 0) {
            return false;
        }
        this.f777h = C0931m.m701a(((Element) elementsByTagName.item(0)).getChildNodes());
        elementsByTagName = element.getElementsByTagName("addresseeName");
        if (elementsByTagName.getLength() > 0) {
            this.f770a = C0931m.m701a(((Element) elementsByTagName.item(0)).getChildNodes());
        }
        return true;
    }

    public final String m574b() {
        return this.f771b;
    }

    public final void m575b(String str) {
        this.f772c = str;
    }

    public final String m576c() {
        return this.f772c;
    }

    public final void m577c(String str) {
        this.f773d = str;
    }

    public final String m578d() {
        return this.f773d;
    }

    public final void m579d(String str) {
        this.f774e = str;
    }

    public final String m580e() {
        return this.f774e;
    }

    public final void m581e(String str) {
        this.f775f = str;
    }

    public final String m582f() {
        return this.f775f;
    }

    public final void m583f(String str) {
        this.f776g = str;
    }

    public final String m584g() {
        return this.f776g;
    }

    public final void m585g(String str) {
        this.f777h = str;
    }

    public final String m586h() {
        return this.f777h;
    }
}
