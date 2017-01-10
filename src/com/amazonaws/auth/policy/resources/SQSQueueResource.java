package com.amazonaws.auth.policy.resources;

import com.amazonaws.auth.policy.Resource;
import com.google.gdata.util.common.base.StringUtil;

public class SQSQueueResource extends Resource {
    public SQSQueueResource(String str, String str2) {
        super("/" + formatAccountId(str) + "/" + str2);
    }

    private static String formatAccountId(String str) {
        if (str != null) {
            return str.trim().replaceAll("-", StringUtil.EMPTY_STRING);
        }
        throw new IllegalArgumentException("Account ID cannot be null");
    }
}
