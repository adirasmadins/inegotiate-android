package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.BundleTask;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class BundleTaskStaxUnmarshaller implements Unmarshaller<BundleTask, StaxUnmarshallerContext> {
    private static BundleTaskStaxUnmarshaller instance;

    public static BundleTaskStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BundleTaskStaxUnmarshaller();
        }
        return instance;
    }

    public BundleTask unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        BundleTask bundleTask = new BundleTask();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return bundleTask;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    bundleTask.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("bundleId", i)) {
                    bundleTask.setBundleId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("state", i)) {
                    bundleTask.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("startTime", i)) {
                    bundleTask.setStartTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("updateTime", i)) {
                    bundleTask.setUpdateTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("storage", i)) {
                    bundleTask.setStorage(StorageStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("progress", i)) {
                    bundleTask.setProgress(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("error", i)) {
                    bundleTask.setBundleTaskError(BundleTaskErrorStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return bundleTask;
            }
        }
    }
}
