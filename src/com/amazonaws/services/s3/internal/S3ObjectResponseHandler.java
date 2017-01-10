package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.BinaryUtils;
import com.google.common.net.HttpHeaders;

public class S3ObjectResponseHandler extends AbstractS3ResponseHandler<S3Object> {
    public AmazonWebServiceResponse<S3Object> handle(HttpResponse httpResponse) throws Exception {
        Object obj = 1;
        S3Object s3Object = new S3Object();
        ObjectMetadata objectMetadata = s3Object.getObjectMetadata();
        populateObjectMetadata(httpResponse, objectMetadata);
        Object obj2 = !ServiceUtils.isMultipartUploadETag(objectMetadata.getETag()) ? 1 : null;
        if (httpResponse.getHeaders().get(HttpHeaders.CONTENT_RANGE) != null) {
            obj = null;
        }
        if (obj2 == null || r1 == null) {
            s3Object.setObjectContent(new S3ObjectInputStream(httpResponse.getContent(), httpResponse.getHttpRequest()));
        } else {
            s3Object.setObjectContent(new S3ObjectInputStream(new ChecksumValidatingInputStream(httpResponse.getContent(), BinaryUtils.fromHex(objectMetadata.getETag()), s3Object.getBucketName() + "/" + s3Object.getKey()), httpResponse.getHttpRequest()));
        }
        AmazonWebServiceResponse<S3Object> parseResponseMetadata = parseResponseMetadata(httpResponse);
        parseResponseMetadata.setResult(s3Object);
        return parseResponseMetadata;
    }

    public boolean needsConnectionLeftOpen() {
        return true;
    }
}
