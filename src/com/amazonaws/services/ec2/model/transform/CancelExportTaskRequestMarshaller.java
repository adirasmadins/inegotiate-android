package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CancelExportTaskRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CancelExportTaskRequestMarshaller implements Marshaller<Request<CancelExportTaskRequest>, CancelExportTaskRequest> {
    public Request<CancelExportTaskRequest> marshall(CancelExportTaskRequest cancelExportTaskRequest) {
        if (cancelExportTaskRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CancelExportTaskRequest> defaultRequest = new DefaultRequest(cancelExportTaskRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CancelExportTask");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (cancelExportTaskRequest.getExportTaskId() != null) {
            defaultRequest.addParameter("ExportTaskId", StringUtils.fromString(cancelExportTaskRequest.getExportTaskId()));
        }
        return defaultRequest;
    }
}
