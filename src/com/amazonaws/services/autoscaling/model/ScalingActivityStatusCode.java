package com.amazonaws.services.autoscaling.model;

import com.google.gdata.util.common.base.StringUtil;

public enum ScalingActivityStatusCode {
    WaitingForSpotInstanceRequestId("WaitingForSpotInstanceRequestId"),
    WaitingForSpotInstanceId("WaitingForSpotInstanceId"),
    WaitingForInstanceId("WaitingForInstanceId"),
    PreInService("PreInService"),
    InProgress("InProgress"),
    Successful("Successful"),
    Failed("Failed"),
    Cancelled("Cancelled");
    
    private String value;

    private ScalingActivityStatusCode(String str) {
        this.value = str;
    }

    public static ScalingActivityStatusCode fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("WaitingForSpotInstanceRequestId".equals(str)) {
            return WaitingForSpotInstanceRequestId;
        } else {
            if ("WaitingForSpotInstanceId".equals(str)) {
                return WaitingForSpotInstanceId;
            }
            if ("WaitingForInstanceId".equals(str)) {
                return WaitingForInstanceId;
            }
            if ("PreInService".equals(str)) {
                return PreInService;
            }
            if ("InProgress".equals(str)) {
                return InProgress;
            }
            if ("Successful".equals(str)) {
                return Successful;
            }
            if ("Failed".equals(str)) {
                return Failed;
            }
            if ("Cancelled".equals(str)) {
                return Cancelled;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
