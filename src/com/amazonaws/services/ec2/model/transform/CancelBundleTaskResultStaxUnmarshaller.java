package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CancelBundleTaskResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CancelBundleTaskResultStaxUnmarshaller implements Unmarshaller<CancelBundleTaskResult, StaxUnmarshallerContext> {
    private static CancelBundleTaskResultStaxUnmarshaller instance;

    public static CancelBundleTaskResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CancelBundleTaskResultStaxUnmarshaller();
        }
        return instance;
    }

    public CancelBundleTaskResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CancelBundleTaskResult cancelBundleTaskResult = new CancelBundleTaskResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return cancelBundleTaskResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("bundleInstanceTask", i)) {
                    cancelBundleTaskResult.setBundleTask(BundleTaskStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return cancelBundleTaskResult;
            }
        }
    }
}
