package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class MediationAdRequest {
    private AdRequest f328a;
    private boolean f329b;
    private boolean f330c;

    public MediationAdRequest(AdRequest request, Context context, boolean shareLocation) {
        this.f328a = request;
        this.f330c = shareLocation;
        if (context == null) {
            this.f329b = true;
        } else {
            this.f329b = request.isTestDevice(context);
        }
    }

    public Gender getGender() {
        return this.f328a.getGender();
    }

    public Date getBirthday() {
        return this.f328a.getBirthday();
    }

    public Integer getAgeInYears() {
        if (this.f328a.getBirthday() == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f328a.getBirthday());
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        if (instance2.get(6) < instance.get(6)) {
            return Integer.valueOf(valueOf.intValue() - 1);
        }
        return valueOf;
    }

    public Set<String> getKeywords() {
        if (this.f328a.getKeywords() == null) {
            return null;
        }
        return Collections.unmodifiableSet(this.f328a.getKeywords());
    }

    public Location getLocation() {
        if (this.f328a.getLocation() == null || !this.f330c) {
            return null;
        }
        return new Location(this.f328a.getLocation());
    }

    public boolean isTesting() {
        return this.f329b;
    }
}
