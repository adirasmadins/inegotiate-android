package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.SetAlarmStateRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SetAlarmStateRequestMarshaller implements Marshaller<Request<SetAlarmStateRequest>, SetAlarmStateRequest> {
    public Request<SetAlarmStateRequest> marshall(SetAlarmStateRequest setAlarmStateRequest) {
        if (setAlarmStateRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetAlarmStateRequest> defaultRequest = new DefaultRequest(setAlarmStateRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "SetAlarmState");
        defaultRequest.addParameter("Version", "2010-08-01");
        if (setAlarmStateRequest.getAlarmName() != null) {
            defaultRequest.addParameter("AlarmName", StringUtils.fromString(setAlarmStateRequest.getAlarmName()));
        }
        if (setAlarmStateRequest.getStateValue() != null) {
            defaultRequest.addParameter("StateValue", StringUtils.fromString(setAlarmStateRequest.getStateValue()));
        }
        if (setAlarmStateRequest.getStateReason() != null) {
            defaultRequest.addParameter("StateReason", StringUtils.fromString(setAlarmStateRequest.getStateReason()));
        }
        if (setAlarmStateRequest.getStateReasonData() != null) {
            defaultRequest.addParameter("StateReasonData", StringUtils.fromString(setAlarmStateRequest.getStateReasonData()));
        }
        return defaultRequest;
    }
}
