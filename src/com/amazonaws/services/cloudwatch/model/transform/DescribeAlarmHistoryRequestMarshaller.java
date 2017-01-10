package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeAlarmHistoryRequestMarshaller implements Marshaller<Request<DescribeAlarmHistoryRequest>, DescribeAlarmHistoryRequest> {
    public Request<DescribeAlarmHistoryRequest> marshall(DescribeAlarmHistoryRequest describeAlarmHistoryRequest) {
        if (describeAlarmHistoryRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeAlarmHistoryRequest> defaultRequest = new DefaultRequest(describeAlarmHistoryRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "DescribeAlarmHistory");
        defaultRequest.addParameter("Version", "2010-08-01");
        if (describeAlarmHistoryRequest.getAlarmName() != null) {
            defaultRequest.addParameter("AlarmName", StringUtils.fromString(describeAlarmHistoryRequest.getAlarmName()));
        }
        if (describeAlarmHistoryRequest.getHistoryItemType() != null) {
            defaultRequest.addParameter("HistoryItemType", StringUtils.fromString(describeAlarmHistoryRequest.getHistoryItemType()));
        }
        if (describeAlarmHistoryRequest.getStartDate() != null) {
            defaultRequest.addParameter("StartDate", StringUtils.fromDate(describeAlarmHistoryRequest.getStartDate()));
        }
        if (describeAlarmHistoryRequest.getEndDate() != null) {
            defaultRequest.addParameter("EndDate", StringUtils.fromDate(describeAlarmHistoryRequest.getEndDate()));
        }
        if (describeAlarmHistoryRequest.getMaxRecords() != null) {
            defaultRequest.addParameter("MaxRecords", StringUtils.fromInteger(describeAlarmHistoryRequest.getMaxRecords()));
        }
        if (describeAlarmHistoryRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeAlarmHistoryRequest.getNextToken()));
        }
        return defaultRequest;
    }
}
