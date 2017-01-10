package com.amazonaws.internal;

public class DynamoDBBackoffStrategy extends CustomBackoffStrategy {
    public static final CustomBackoffStrategy DEFAULT;

    static {
        DEFAULT = new DynamoDBBackoffStrategy();
    }

    public int getBackoffPeriod(int i) {
        return i == 0 ? 0 : ((int) Math.pow(2.0d, (double) (i - 1))) * 50;
    }
}
