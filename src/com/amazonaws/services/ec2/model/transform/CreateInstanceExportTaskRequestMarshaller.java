package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CreateInstanceExportTaskRequest;
import com.amazonaws.services.ec2.model.ExportToS3TaskSpecification;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateInstanceExportTaskRequestMarshaller implements Marshaller<Request<CreateInstanceExportTaskRequest>, CreateInstanceExportTaskRequest> {
    public Request<CreateInstanceExportTaskRequest> marshall(CreateInstanceExportTaskRequest createInstanceExportTaskRequest) {
        if (createInstanceExportTaskRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateInstanceExportTaskRequest> defaultRequest = new DefaultRequest(createInstanceExportTaskRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CreateInstanceExportTask");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (createInstanceExportTaskRequest.getDescription() != null) {
            defaultRequest.addParameter("Description", StringUtils.fromString(createInstanceExportTaskRequest.getDescription()));
        }
        if (createInstanceExportTaskRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(createInstanceExportTaskRequest.getInstanceId()));
        }
        if (createInstanceExportTaskRequest.getTargetEnvironment() != null) {
            defaultRequest.addParameter("TargetEnvironment", StringUtils.fromString(createInstanceExportTaskRequest.getTargetEnvironment()));
        }
        ExportToS3TaskSpecification exportToS3Task = createInstanceExportTaskRequest.getExportToS3Task();
        if (exportToS3Task != null) {
            if (exportToS3Task.getDiskImageFormat() != null) {
                defaultRequest.addParameter("ExportToS3.DiskImageFormat", StringUtils.fromString(exportToS3Task.getDiskImageFormat()));
            }
            if (exportToS3Task.getContainerFormat() != null) {
                defaultRequest.addParameter("ExportToS3.ContainerFormat", StringUtils.fromString(exportToS3Task.getContainerFormat()));
            }
            if (exportToS3Task.getS3Bucket() != null) {
                defaultRequest.addParameter("ExportToS3.S3Bucket", StringUtils.fromString(exportToS3Task.getS3Bucket()));
            }
            if (exportToS3Task.getS3Prefix() != null) {
                defaultRequest.addParameter("ExportToS3.S3Prefix", StringUtils.fromString(exportToS3Task.getS3Prefix()));
            }
        }
        return defaultRequest;
    }
}
