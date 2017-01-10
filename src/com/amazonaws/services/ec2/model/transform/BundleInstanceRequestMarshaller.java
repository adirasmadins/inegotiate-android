package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.BundleInstanceRequest;
import com.amazonaws.services.ec2.model.S3Storage;
import com.amazonaws.services.ec2.model.Storage;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class BundleInstanceRequestMarshaller implements Marshaller<Request<BundleInstanceRequest>, BundleInstanceRequest> {
    public Request<BundleInstanceRequest> marshall(BundleInstanceRequest bundleInstanceRequest) {
        if (bundleInstanceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<BundleInstanceRequest> defaultRequest = new DefaultRequest(bundleInstanceRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "BundleInstance");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (bundleInstanceRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(bundleInstanceRequest.getInstanceId()));
        }
        Storage storage = bundleInstanceRequest.getStorage();
        if (storage != null) {
            S3Storage s3 = storage.getS3();
            if (s3 != null) {
                if (s3.getBucket() != null) {
                    defaultRequest.addParameter("Storage.S3.Bucket", StringUtils.fromString(s3.getBucket()));
                }
                if (s3.getPrefix() != null) {
                    defaultRequest.addParameter("Storage.S3.Prefix", StringUtils.fromString(s3.getPrefix()));
                }
                if (s3.getAWSAccessKeyId() != null) {
                    defaultRequest.addParameter("Storage.S3.AWSAccessKeyId", StringUtils.fromString(s3.getAWSAccessKeyId()));
                }
                if (s3.getUploadPolicy() != null) {
                    defaultRequest.addParameter("Storage.S3.UploadPolicy", StringUtils.fromString(s3.getUploadPolicy()));
                }
                if (s3.getUploadPolicySignature() != null) {
                    defaultRequest.addParameter("Storage.S3.UploadPolicySignature", StringUtils.fromString(s3.getUploadPolicySignature()));
                }
            }
        }
        return defaultRequest;
    }
}
