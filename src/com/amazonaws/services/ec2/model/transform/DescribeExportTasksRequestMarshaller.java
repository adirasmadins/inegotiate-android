package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeExportTasksRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeExportTasksRequestMarshaller implements Marshaller<Request<DescribeExportTasksRequest>, DescribeExportTasksRequest> {
    public Request<DescribeExportTasksRequest> marshall(DescribeExportTasksRequest describeExportTasksRequest) {
        if (describeExportTasksRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeExportTasksRequest> defaultRequest = new DefaultRequest(describeExportTasksRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeExportTasks");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeExportTasksRequest.getExportTaskIds()) {
            if (str != null) {
                defaultRequest.addParameter("ExportTaskId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
