package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.DisableAlarmActionsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DisableAlarmActionsRequestMarshaller implements Marshaller<Request<DisableAlarmActionsRequest>, DisableAlarmActionsRequest> {
    public Request<DisableAlarmActionsRequest> marshall(DisableAlarmActionsRequest disableAlarmActionsRequest) {
        if (disableAlarmActionsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DisableAlarmActionsRequest> defaultRequest = new DefaultRequest(disableAlarmActionsRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "DisableAlarmActions");
        defaultRequest.addParameter("Version", "2010-08-01");
        int i = 1;
        for (String str : disableAlarmActionsRequest.getAlarmNames()) {
            if (str != null) {
                defaultRequest.addParameter("AlarmNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
