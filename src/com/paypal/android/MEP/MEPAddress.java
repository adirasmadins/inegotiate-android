package com.paypal.android.MEP;

public class MEPAddress {
    private String f483a;
    private String f484b;
    private String f485c;
    private String f486d;
    private String f487e;
    private String f488f;

    public String getCity() {
        return this.f485c;
    }

    public String getCountrycode() {
        return this.f488f;
    }

    public String getPostalcode() {
        return this.f487e;
    }

    public String getState() {
        return this.f486d;
    }

    public String getStreet1() {
        return this.f483a;
    }

    public String getStreet2() {
        return this.f484b;
    }

    public void setCity(String str) {
        this.f485c = str;
    }

    public void setCountrycode(String str) {
        this.f488f = str;
    }

    public void setPostalcode(String str) {
        this.f487e = str;
    }

    public void setState(String str) {
        this.f486d = str;
    }

    public void setStreet1(String str) {
        this.f483a = str;
    }

    public void setStreet2(String str) {
        this.f484b = str;
    }
}
