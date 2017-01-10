package com.paypal.android.MEP;

import java.io.Serializable;
import java.math.BigDecimal;

public class PayPalPreapproval implements Serializable {
    public static final int DAY_FRIDAY = 5;
    public static final int DAY_MONDAY = 1;
    public static final int DAY_NONE = 7;
    public static final int DAY_SATURDAY = 6;
    public static final int DAY_SUNDAY = 0;
    public static final int DAY_THURSDAY = 4;
    public static final int DAY_TUESDAY = 2;
    public static final int DAY_WEDNESDAY = 3;
    public static final int PERIOD_ANNUALLY = 5;
    public static final int PERIOD_BIWEEKLY = 2;
    public static final int PERIOD_DAILY = 0;
    public static final int PERIOD_MONTHLY = 4;
    public static final int PERIOD_NONE = 6;
    public static final int PERIOD_SEMIMONTHLY = 3;
    public static final int PERIOD_WEEKLY = 1;
    public static final int TYPE_AGREE = 0;
    public static final int TYPE_AGREE_AND_PAY = 1;
    private static final long serialVersionUID = 7;
    private String f556a;
    private String f557b;
    private int f558c;
    private BigDecimal f559d;
    private BigDecimal f560e;
    private String f561f;
    private String f562g;
    private boolean f563h;
    private boolean f564i;
    private int f565j;
    private int f566k;
    private int f567l;
    private int f568m;
    private String f569n;
    private String f570o;
    private int f571p;

    public PayPalPreapproval() {
        this.f556a = null;
        this.f557b = null;
        this.f558c = TYPE_AGREE;
        this.f559d = null;
        this.f560e = null;
        this.f561f = null;
        this.f562g = null;
        this.f563h = false;
        this.f564i = false;
        this.f565j = PERIOD_NONE;
        this.f566k = DAY_NONE;
        this.f567l = TYPE_AGREE;
        this.f568m = TYPE_AGREE;
        this.f569n = null;
        this.f570o = null;
        this.f571p = TYPE_AGREE_AND_PAY;
    }

    public String getCurrencyType() {
        return this.f556a;
    }

    public int getDayOfMonth() {
        return this.f567l;
    }

    public int getDayOfWeek() {
        return this.f566k;
    }

    public int getDayOfWeekInt(String str) {
        return str.equals("SUNDAY") ? TYPE_AGREE : str.equals("MONDAY") ? TYPE_AGREE_AND_PAY : str.equals("TUESDAY") ? PERIOD_BIWEEKLY : str.equals("WEDNESDAY") ? PERIOD_SEMIMONTHLY : str.equals("THURSDAY") ? PERIOD_MONTHLY : str.equals("FRIDAY") ? PERIOD_ANNUALLY : str.equals("SATURDAY") ? PERIOD_NONE : DAY_NONE;
    }

    public String getEndDate() {
        return this.f562g;
    }

    public String getIpnUrl() {
        return this.f569n;
    }

    public boolean getIsApproved() {
        return this.f563h;
    }

    public BigDecimal getMaxAmountPerPayment() {
        return this.f559d;
    }

    public int getMaxNumberOfPayments() {
        return this.f558c;
    }

    public int getMaxNumberOfPaymentsPerPeriod() {
        return this.f568m;
    }

    public BigDecimal getMaxTotalAmountOfAllPayments() {
        return this.f560e;
    }

    public String getMemo() {
        return this.f570o;
    }

    public String getMerchantName() {
        return this.f557b;
    }

    public int getPaymentPeriod() {
        return this.f565j;
    }

    public int getPaymentPeriodInt(String str) {
        return str.equals("DAILY") ? TYPE_AGREE : str.equals("WEEKLY") ? TYPE_AGREE_AND_PAY : str.equals("BIWEEKLY") ? PERIOD_BIWEEKLY : str.equals("SEMIMONTHLY") ? PERIOD_SEMIMONTHLY : str.equals("MONTHLY") ? PERIOD_MONTHLY : str.equals("ANNUALLY") ? PERIOD_ANNUALLY : PERIOD_NONE;
    }

    public boolean getPinRequired() {
        return this.f564i;
    }

    public String getStartDate() {
        return this.f561f;
    }

    public int getType() {
        return this.f571p;
    }

    public boolean isValid() {
        return this.f557b != null && this.f557b.length() > 0;
    }

    public void setCurrencyType(String str) {
        this.f556a = str;
    }

    public void setDayOfMonth(int i) {
        this.f567l = i;
    }

    public void setDayOfWeek(int i) {
        this.f566k = i;
    }

    public void setEndDate(String str) {
        this.f562g = str;
    }

    public void setIpnUrl(String str) {
        this.f569n = str;
    }

    public void setIsApproved(boolean z) {
        this.f563h = z;
    }

    public void setMaxAmountPerPayment(BigDecimal bigDecimal) {
        this.f559d = bigDecimal;
    }

    public void setMaxNumberOfPayments(int i) {
        this.f558c = i;
    }

    public void setMaxNumberOfPaymentsPerPeriod(int i) {
        this.f568m = i;
    }

    public void setMaxTotalAmountOfAllPayments(BigDecimal bigDecimal) {
        this.f560e = bigDecimal;
    }

    public void setMemo(String str) {
        this.f570o = str;
    }

    public void setMerchantName(String str) {
        this.f557b = str;
    }

    public void setPaymentPeriod(int i) {
        this.f565j = i;
    }

    public void setPinRequired(boolean z) {
        this.f564i = z;
    }

    public void setStartDate(String str) {
        this.f561f = str;
    }

    public void setType(int i) {
        if (i <= TYPE_AGREE_AND_PAY && i >= 0) {
            this.f571p = i;
        }
    }
}
