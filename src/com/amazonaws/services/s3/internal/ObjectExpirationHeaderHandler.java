package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.Headers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectExpirationHeaderHandler<T extends ObjectExpirationResult> implements HeaderHandler<T> {
    private static final Pattern datePattern;
    private static final Pattern rulePattern;

    static {
        datePattern = Pattern.compile("expiry-date=\"(.*?)\"");
        rulePattern = Pattern.compile("rule-id=\"(.*)\"");
    }

    private Date parseDate(String str) {
        Date date = null;
        Matcher matcher = datePattern.matcher(str);
        if (matcher.find()) {
            try {
                date = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z").parse(matcher.group(1));
            } catch (ParseException e) {
            }
        }
        return date;
    }

    private String parseRuleId(String str) {
        Matcher matcher = rulePattern.matcher(str);
        return matcher.find() ? matcher.group(1) : null;
    }

    public void handle(T t, HttpResponse httpResponse) {
        String str = (String) httpResponse.getHeaders().get(Headers.EXPIRATION);
        if (str != null) {
            t.setExpirationTime(parseDate(str));
            t.setExpirationTimeRuleId(parseRuleId(str));
        }
    }
}
