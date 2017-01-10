package com.amazonaws.services.s3.model;

public enum Region {
    US_Standard(null),
    US_West("us-west-1"),
    US_West_2("us-west-2"),
    EU_Ireland("EU"),
    AP_Singapore("ap-southeast-1"),
    AP_Tokyo("ap-northeast-1"),
    SA_SaoPaulo("sa-east-1");
    
    private final String regionId;

    private Region(String str) {
        this.regionId = str;
    }

    public static Region fromValue(String str) throws IllegalArgumentException {
        for (Region region : values()) {
            String region2 = region.toString();
            if ((region2 == null && str == null) || (region2 != null && region2.equals(str))) {
                return region;
            }
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.regionId;
    }
}
