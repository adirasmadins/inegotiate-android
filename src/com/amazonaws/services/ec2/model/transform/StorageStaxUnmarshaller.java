package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.Storage;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class StorageStaxUnmarshaller implements Unmarshaller<Storage, StaxUnmarshallerContext> {
    private static StorageStaxUnmarshaller instance;

    public static StorageStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new StorageStaxUnmarshaller();
        }
        return instance;
    }

    public Storage unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Storage storage = new Storage();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return storage;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("S3", i)) {
                    storage.setS3(S3StorageStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return storage;
            }
        }
    }
}
