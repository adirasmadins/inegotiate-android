package com.amazonaws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class DateUtils {
    protected final SimpleDateFormat alternateIso8601DateFormat;
    protected final SimpleDateFormat iso8601DateFormat;
    protected final SimpleDateFormat rfc822DateFormat;

    public DateUtils() {
        this.iso8601DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.alternateIso8601DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        this.rfc822DateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        this.iso8601DateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        this.rfc822DateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        this.alternateIso8601DateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    }

    public String formatIso8601Date(Date date) {
        String format;
        synchronized (this.iso8601DateFormat) {
            format = this.iso8601DateFormat.format(date);
        }
        return format;
    }

    public String formatRfc822Date(Date date) {
        String format;
        synchronized (this.rfc822DateFormat) {
            format = this.rfc822DateFormat.format(date);
        }
        return format;
    }

    public Date parseIso8601Date(String str) throws ParseException {
        Date parse;
        try {
            synchronized (this.iso8601DateFormat) {
                parse = this.iso8601DateFormat.parse(str);
            }
        } catch (ParseException e) {
            synchronized (this.alternateIso8601DateFormat) {
            }
            parse = this.alternateIso8601DateFormat.parse(str);
        }
        return parse;
    }

    public Date parseRfc822Date(String str) throws ParseException {
        Date parse;
        synchronized (this.rfc822DateFormat) {
            parse = this.rfc822DateFormat.parse(str);
        }
        return parse;
    }
}
