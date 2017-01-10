package com.google.gdata.data;

import com.google.gdata.util.ParseException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTime implements Comparable<Object> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final TimeZone GMT;
    public static final Pattern datePattern;
    public static final Pattern dateTimeChoicePattern;
    private static final SimpleDateFormat dateTimeFormat822;
    public static final Pattern dateTimePattern;
    protected boolean dateOnly;
    protected Integer tzShift;
    protected long value;

    static {
        boolean z;
        if (DateTime.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
        dateTimePattern = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
        datePattern = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
        dateTimeChoicePattern = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)([Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?)?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
        dateTimeFormat822 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        GMT = TimeZone.getTimeZone("GMT");
        dateTimeFormat822.setTimeZone(GMT);
    }

    public DateTime() {
        this.value = 0;
        this.dateOnly = false;
        this.tzShift = null;
    }

    public DateTime(long value) {
        this.value = 0;
        this.dateOnly = false;
        this.tzShift = null;
        this.value = value;
    }

    public DateTime(Date value) {
        this.value = 0;
        this.dateOnly = false;
        this.tzShift = null;
        this.value = value.getTime();
    }

    public DateTime(long value, int tzShift) {
        this.value = 0;
        this.dateOnly = false;
        this.tzShift = null;
        this.value = value;
        this.tzShift = new Integer(tzShift);
    }

    public DateTime(Date value, TimeZone zone) {
        this.value = 0;
        this.dateOnly = false;
        this.tzShift = null;
        this.value = value.getTime();
        this.tzShift = Integer.valueOf(zone.getOffset(value.getTime()) / 60000);
    }

    public static DateTime now() {
        return new DateTime(new Date(), GMT);
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long v) {
        this.value = v;
    }

    public boolean isDateOnly() {
        return this.dateOnly;
    }

    public void setDateOnly(boolean v) {
        this.dateOnly = v;
    }

    public Integer getTzShift() {
        return this.tzShift;
    }

    public void setTzShift(Integer v) {
        this.tzShift = v;
    }

    public int hashCode() {
        return Long.valueOf(this.value).hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof DateTime) {
            if (this.value == ((DateTime) o).value) {
                return true;
            }
            return false;
        } else if (!(o instanceof Date)) {
            return false;
        } else {
            if (this.value != ((Date) o).getTime()) {
                return false;
            }
            return true;
        }
    }

    public int compareTo(Object o) {
        if (o instanceof DateTime) {
            return new Long(this.value).compareTo(new Long(((DateTime) o).value));
        }
        if (o instanceof Date) {
            return new Long(this.value).compareTo(new Long(((Date) o).getTime()));
        }
        throw new RuntimeException("Invalid type.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Calendar dateTime = new GregorianCalendar(GMT);
        long localTime = this.value;
        if (this.tzShift != null) {
            localTime += this.tzShift.longValue() * 60000;
        }
        dateTime.setTimeInMillis(localTime);
        try {
            appendInt(sb, dateTime.get(1), 4);
            sb.append('-');
            appendInt(sb, dateTime.get(2) + 1, 2);
            sb.append('-');
            appendInt(sb, dateTime.get(5), 2);
            if (!this.dateOnly) {
                sb.append('T');
                appendInt(sb, dateTime.get(11), 2);
                sb.append(':');
                appendInt(sb, dateTime.get(12), 2);
                sb.append(':');
                appendInt(sb, dateTime.get(13), 2);
                if (dateTime.isSet(14)) {
                    sb.append('.');
                    appendInt(sb, dateTime.get(14), 3);
                }
            }
            if (this.tzShift != null) {
                if (this.tzShift.intValue() == 0) {
                    sb.append('Z');
                } else {
                    int absTzShift = this.tzShift.intValue();
                    if (this.tzShift.intValue() > 0) {
                        sb.append('+');
                    } else {
                        sb.append('-');
                        absTzShift = -absTzShift;
                    }
                    int tzMinutes = absTzShift % 60;
                    appendInt(sb, absTzShift / 60, 2);
                    sb.append(':');
                    appendInt(sb, tzMinutes, 2);
                }
            }
            return sb.toString();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    public String toStringRfc822() {
        if ($assertionsDisabled || !this.dateOnly) {
            String format;
            synchronized (dateTimeFormat822) {
                format = dateTimeFormat822.format(Long.valueOf(this.value));
            }
            return format;
        }
        throw new AssertionError();
    }

    public static DateTime parseRfc822(String str) throws ParseException {
        Date date;
        synchronized (dateTimeFormat822) {
            try {
                date = dateTimeFormat822.parse(str);
            } catch (Throwable e) {
                throw new ParseException(e);
            }
        }
        return new DateTime(date);
    }

    public String toUiString() {
        StringBuilder sb = new StringBuilder();
        Calendar dateTime = new GregorianCalendar(GMT);
        long localTime = this.value;
        if (this.tzShift != null) {
            localTime += this.tzShift.longValue() * 60000;
        }
        dateTime.setTimeInMillis(localTime);
        try {
            appendInt(sb, dateTime.get(1), 4);
            sb.append('-');
            appendInt(sb, dateTime.get(2) + 1, 2);
            sb.append('-');
            appendInt(sb, dateTime.get(5), 2);
            if (!this.dateOnly) {
                sb.append(' ');
                appendInt(sb, dateTime.get(11), 2);
                sb.append(':');
                appendInt(sb, dateTime.get(12), 2);
            }
            return sb.toString();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    public static DateTime parseDateTime(String str) throws NumberFormatException {
        Matcher m;
        if (str == null) {
            m = null;
        } else {
            m = dateTimePattern.matcher(str);
        }
        if (str == null || !m.matches()) {
            throw new NumberFormatException("Invalid date/time format.");
        }
        DateTime ret = new DateTime();
        ret.dateOnly = false;
        if (m.group(9) != null) {
            if (m.group(9).equalsIgnoreCase("Z")) {
                ret.tzShift = new Integer(0);
            } else {
                ret.tzShift = new Integer((Integer.valueOf(m.group(12)).intValue() * 60) + Integer.valueOf(m.group(13)).intValue());
                if (m.group(11).equals("-")) {
                    ret.tzShift = new Integer(-ret.tzShift.intValue());
                }
            }
        }
        Calendar dateTime = new GregorianCalendar(GMT);
        dateTime.clear();
        dateTime.set(Integer.valueOf(m.group(1)).intValue(), Integer.valueOf(m.group(2)).intValue() - 1, Integer.valueOf(m.group(3)).intValue(), Integer.valueOf(m.group(4)).intValue(), Integer.valueOf(m.group(5)).intValue(), Integer.valueOf(m.group(6)).intValue());
        if (m.group(8) != null && m.group(8).length() > 0) {
            dateTime.set(14, new BigDecimal("0." + m.group(8)).movePointRight(3).intValue());
        }
        ret.value = dateTime.getTimeInMillis();
        if (ret.tzShift != null) {
            ret.value -= (long) (ret.tzShift.intValue() * 60000);
        }
        return ret;
    }

    public static DateTime parseDate(String str) throws NumberFormatException {
        Matcher m;
        if (str == null) {
            m = null;
        } else {
            m = datePattern.matcher(str);
        }
        if (str == null || !m.matches()) {
            throw new NumberFormatException("Invalid date format.");
        }
        DateTime ret = new DateTime();
        ret.dateOnly = true;
        if (m.group(4) != null) {
            if (m.group(4).equalsIgnoreCase("Z")) {
                ret.tzShift = new Integer(0);
            } else {
                ret.tzShift = new Integer((Integer.valueOf(m.group(7)).intValue() * 60) + Integer.valueOf(m.group(8)).intValue());
                if (m.group(6).equals("-")) {
                    ret.tzShift = new Integer(-ret.tzShift.intValue());
                }
            }
        }
        Calendar dateTime = new GregorianCalendar(GMT);
        dateTime.clear();
        dateTime.set(Integer.valueOf(m.group(1)).intValue(), Integer.valueOf(m.group(2)).intValue() - 1, Integer.valueOf(m.group(3)).intValue());
        ret.value = dateTime.getTimeInMillis();
        if (ret.tzShift != null) {
            ret.value -= (long) (ret.tzShift.intValue() * 60000);
        }
        return ret;
    }

    public static DateTime parseDateTimeChoice(String value) throws NumberFormatException {
        DateTime parseDateTime;
        try {
            parseDateTime = parseDateTime(value);
        } catch (NumberFormatException e) {
            NumberFormatException exception = e;
            try {
                parseDateTime = parseDate(value);
            } catch (NumberFormatException e2) {
                throw e2;
            }
        }
        return parseDateTime;
    }

    private static void appendInt(StringBuilder sb, int num, int numDigits) {
        if (num < 0) {
            sb.append('-');
            num = -num;
        }
        char[] digits = new char[numDigits];
        for (int digit = numDigits - 1; digit >= 0; digit--) {
            digits[digit] = (char) ((num % 10) + 48);
            num /= 10;
        }
        sb.append(digits);
    }
}
