package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.EnableAlarmActionsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class EnableAlarmActionsRequestMarshaller implements Marshaller<Request<EnableAlarmActionsRequest>, EnableAlarmActionsRequest> {
    public Request<EnableAlarmActionsRequest> marshall(EnableAlarmActionsRequest enableAlarmActionsRequest) {
        if (enableAlarmActionsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<EnableAlarmActionsRequest> defaultRequest = new DefaultRequest(enableAlarmActionsRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "EnableAlarmActions");
        defaultRequest.addParameter("Version", "2010-08-01");
        int i = 1;
        for (String str : enableAlarmActionsRequest.getAlarmNames()) {
            if (str != null) {
                defaultRequest.addParameter("AlarmNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
