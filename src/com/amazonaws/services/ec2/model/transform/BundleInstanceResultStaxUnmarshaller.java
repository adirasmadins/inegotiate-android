package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.BundleInstanceResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class BundleInstanceResultStaxUnmarshaller implements Unmarshaller<BundleInstanceResult, StaxUnmarshallerContext> {
    private static BundleInstanceResultStaxUnmarshaller instance;

    public static BundleInstanceResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BundleInstanceResultStaxUnmarshaller();
        }
        return instance;
    }

    public BundleInstanceResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        BundleInstanceResult bundleInstanceResult = new BundleInstanceResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return bundleInstanceResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("bundleInstanceTask", i)) {
                    bundleInstanceResult.setBundleTask(BundleTaskStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return bundleInstanceResult;
            }
        }
    }
}
