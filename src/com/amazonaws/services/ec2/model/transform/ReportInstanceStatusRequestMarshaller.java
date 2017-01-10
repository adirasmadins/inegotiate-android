package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.ReportInstanceStatusRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ReportInstanceStatusRequestMarshaller implements Marshaller<Request<ReportInstanceStatusRequest>, ReportInstanceStatusRequest> {
    public Request<ReportInstanceStatusRequest> marshall(ReportInstanceStatusRequest reportInstanceStatusRequest) {
        int i = 1;
        if (reportInstanceStatusRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ReportInstanceStatusRequest> defaultRequest = new DefaultRequest(reportInstanceStatusRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ReportInstanceStatus");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i2 = 1;
        for (String str : reportInstanceStatusRequest.getInstances()) {
            if (str != null) {
                defaultRequest.addParameter("InstanceId." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        if (reportInstanceStatusRequest.getStatus() != null) {
            defaultRequest.addParameter("Status", StringUtils.fromString(reportInstanceStatusRequest.getStatus()));
        }
        if (reportInstanceStatusRequest.getStartTime() != null) {
            defaultRequest.addParameter("StartTime", StringUtils.fromDate(reportInstanceStatusRequest.getStartTime()));
        }
        if (reportInstanceStatusRequest.getEndTime() != null) {
            defaultRequest.addParameter("EndTime", StringUtils.fromDate(reportInstanceStatusRequest.getEndTime()));
        }
        for (String str2 : reportInstanceStatusRequest.getReasonCodes()) {
            if (str2 != null) {
                defaultRequest.addParameter("ReasonCode." + i, StringUtils.fromString(str2));
            }
            i++;
        }
        if (reportInstanceStatusRequest.getDescription() != null) {
            defaultRequest.addParameter("Description", StringUtils.fromString(reportInstanceStatusRequest.getDescription()));
        }
        return defaultRequest;
    }
}
