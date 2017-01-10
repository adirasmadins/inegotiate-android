package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeAlarmsRequestMarshaller implements Marshaller<Request<DescribeAlarmsRequest>, DescribeAlarmsRequest> {
    public Request<DescribeAlarmsRequest> marshall(DescribeAlarmsRequest describeAlarmsRequest) {
        if (describeAlarmsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeAlarmsRequest> defaultRequest = new DefaultRequest(describeAlarmsRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "DescribeAlarms");
        defaultRequest.addParameter("Version", "2010-08-01");
        int i = 1;
        for (String str : describeAlarmsRequest.getAlarmNames()) {
            if (str != null) {
                defaultRequest.addParameter("AlarmNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (describeAlarmsRequest.getAlarmNamePrefix() != null) {
            defaultRequest.addParameter("AlarmNamePrefix", StringUtils.fromString(describeAlarmsRequest.getAlarmNamePrefix()));
        }
        if (describeAlarmsRequest.getStateValue() != null) {
            defaultRequest.addParameter("StateValue", StringUtils.fromString(describeAlarmsRequest.getStateValue()));
        }
        if (describeAlarmsRequest.getActionPrefix() != null) {
            defaultRequest.addParameter("ActionPrefix", StringUtils.fromString(describeAlarmsRequest.getActionPrefix()));
        }
        if (describeAlarmsRequest.getMaxRecords() != null) {
            defaultRequest.addParameter("MaxRecords", StringUtils.fromInteger(describeAlarmsRequest.getMaxRecords()));
        }
        if (describeAlarmsRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeAlarmsRequest.getNextToken()));
        }
        return defaultRequest;
    }
}
