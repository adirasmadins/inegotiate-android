package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.BundleTaskError;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class BundleTaskErrorStaxUnmarshaller implements Unmarshaller<BundleTaskError, StaxUnmarshallerContext> {
    private static BundleTaskErrorStaxUnmarshaller instance;

    public static BundleTaskErrorStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BundleTaskErrorStaxUnmarshaller();
        }
        return instance;
    }

    public BundleTaskError unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        BundleTaskError bundleTaskError = new BundleTaskError();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return bundleTaskError;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("code", i)) {
                    bundleTaskError.setCode(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("message", i)) {
                    bundleTaskError.setMessage(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return bundleTaskError;
            }
        }
    }
}
