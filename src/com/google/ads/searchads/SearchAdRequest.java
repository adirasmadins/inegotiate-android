package com.google.ads.searchads;

import android.content.Context;
import android.graphics.Color;
import com.google.ads.AdRequest;
import com.google.ads.mediation.admob.AdMobAdapterExtras;
import com.google.gdata.client.GDataProtocol.Query;
import com.google.gdata.model.gd.Reminder.Method;
import java.util.Locale;
import java.util.Map;

public class SearchAdRequest extends AdRequest {
    private String f350a;
    private int f351b;
    private int f352c;
    private int f353d;
    private int f354e;
    private int f355f;
    private int f356g;
    private String f357h;
    private int f358i;
    private int f359j;
    private BorderType f360k;
    private int f361l;
    private String f362m;

    public enum BorderType {
        NONE(Method.NONE),
        DASHED("dashed"),
        DOTTED("dotted"),
        SOLID("solid");
        
        private String f349a;

        private BorderType(String param) {
            this.f349a = param;
        }

        public String toString() {
            return this.f349a;
        }
    }

    public void setQuery(String query) {
        this.f350a = query;
    }

    public void setBackgroundColor(int backgroundColor) {
        if (Color.alpha(backgroundColor) == 255) {
            this.f351b = backgroundColor;
            this.f352c = 0;
            this.f353d = 0;
        }
    }

    public void setBackgroundGradient(int from, int to) {
        if (Color.alpha(from) == 255 && Color.alpha(to) == 255) {
            this.f351b = Color.argb(0, 0, 0, 0);
            this.f352c = from;
            this.f353d = to;
        }
    }

    public void setHeaderTextColor(int headerTextColor) {
        this.f354e = headerTextColor;
    }

    public void setDescriptionTextColor(int descriptionTextColor) {
        this.f355f = descriptionTextColor;
    }

    public void setAnchorTextColor(int anchorTextColor) {
        this.f356g = anchorTextColor;
    }

    public void setFontFace(String fontFace) {
        this.f357h = fontFace;
    }

    public void setHeaderTextSize(int headerTextSize) {
        this.f358i = headerTextSize;
    }

    public void setBorderColor(int borderColor) {
        this.f359j = borderColor;
    }

    public void setBorderType(BorderType borderType) {
        this.f360k = borderType;
    }

    public void setBorderThickness(int borderThickness) {
        this.f361l = borderThickness;
    }

    public void setCustomChannels(String channelIds) {
        this.f362m = channelIds;
    }

    public Map<String, Object> getRequestMap(Context context) {
        AdMobAdapterExtras adMobAdapterExtras = (AdMobAdapterExtras) getNetworkExtras(AdMobAdapterExtras.class);
        if (adMobAdapterExtras == null) {
            adMobAdapterExtras = new AdMobAdapterExtras();
            setNetworkExtras(adMobAdapterExtras);
        }
        if (this.f350a != null) {
            adMobAdapterExtras.getExtras().put(Query.FULL_TEXT, this.f350a);
        }
        if (Color.alpha(this.f351b) != 0) {
            adMobAdapterExtras.getExtras().put("bgcolor", m333a(this.f351b));
        }
        if (Color.alpha(this.f352c) == 255 && Color.alpha(this.f353d) == 255) {
            adMobAdapterExtras.getExtras().put("gradientfrom", m333a(this.f352c));
            adMobAdapterExtras.getExtras().put("gradientto", m333a(this.f353d));
        }
        if (Color.alpha(this.f354e) != 0) {
            adMobAdapterExtras.getExtras().put("hcolor", m333a(this.f354e));
        }
        if (Color.alpha(this.f355f) != 0) {
            adMobAdapterExtras.getExtras().put("dcolor", m333a(this.f355f));
        }
        if (Color.alpha(this.f356g) != 0) {
            adMobAdapterExtras.getExtras().put("acolor", m333a(this.f356g));
        }
        if (this.f357h != null) {
            adMobAdapterExtras.getExtras().put("font", this.f357h);
        }
        adMobAdapterExtras.getExtras().put("headersize", Integer.toString(this.f358i));
        if (Color.alpha(this.f359j) != 0) {
            adMobAdapterExtras.getExtras().put("bcolor", m333a(this.f359j));
        }
        if (this.f360k != null) {
            adMobAdapterExtras.getExtras().put("btype", this.f360k.toString());
        }
        adMobAdapterExtras.getExtras().put("bthick", Integer.toString(this.f361l));
        if (this.f362m != null) {
            adMobAdapterExtras.getExtras().put("channel", this.f362m);
        }
        return super.getRequestMap(context);
    }

    private String m333a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }
}
