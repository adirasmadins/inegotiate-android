package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.S3Storage;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class S3StorageStaxUnmarshaller implements Unmarshaller<S3Storage, StaxUnmarshallerContext> {
    private static S3StorageStaxUnmarshaller instance;

    public static S3StorageStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new S3StorageStaxUnmarshaller();
        }
        return instance;
    }

    public S3Storage unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        S3Storage s3Storage = new S3Storage();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return s3Storage;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("bucket", i)) {
                    s3Storage.setBucket(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("prefix", i)) {
                    s3Storage.setPrefix(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("awsAccessKeyId", i)) {
                    s3Storage.setAWSAccessKeyId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("uploadPolicy", i)) {
                    s3Storage.setUploadPolicy(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("uploadPolicySignature", i)) {
                    s3Storage.setUploadPolicySignature(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return s3Storage;
            }
        }
    }
}
