package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.DeleteAlarmsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteAlarmsRequestMarshaller implements Marshaller<Request<DeleteAlarmsRequest>, DeleteAlarmsRequest> {
    public Request<DeleteAlarmsRequest> marshall(DeleteAlarmsRequest deleteAlarmsRequest) {
        if (deleteAlarmsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteAlarmsRequest> defaultRequest = new DefaultRequest(deleteAlarmsRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "DeleteAlarms");
        defaultRequest.addParameter("Version", "2010-08-01");
        int i = 1;
        for (String str : deleteAlarmsRequest.getAlarmNames()) {
            if (str != null) {
                defaultRequest.addParameter("AlarmNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
