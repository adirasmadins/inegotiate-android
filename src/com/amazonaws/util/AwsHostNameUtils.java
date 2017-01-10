package com.amazonaws.util;

import java.net.URI;

public class AwsHostNameUtils {
    public static String parseRegionName(URI uri) {
        String host = uri.getHost();
        if (!host.endsWith(".amazonaws.com")) {
            return "us-east-1";
        }
        String substring = host.substring(0, host.indexOf(".amazonaws.com"));
        int i = 46;
        if (substring.startsWith("s3")) {
            i = 45;
        }
        if (substring.indexOf(i) == -1) {
            return "us-east-1";
        }
        host = substring.substring(substring.indexOf(i) + 1);
        return "us-gov".equals(host) ? "us-gov-west-1" : host;
    }

    public static String parseServiceName(URI uri) {
        String host = uri.getHost();
        if (!host.endsWith(".amazonaws.com")) {
            return "us-east-1";
        }
        String substring = host.substring(0, host.indexOf(".amazonaws.com"));
        int i = 46;
        if (substring.startsWith("s3")) {
            i = 45;
        }
        return substring.indexOf(i) == -1 ? substring : substring.substring(0, substring.indexOf(i));
    }
}
