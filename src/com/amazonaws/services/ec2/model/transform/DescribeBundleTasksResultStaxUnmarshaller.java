package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeBundleTasksResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeBundleTasksResultStaxUnmarshaller implements Unmarshaller<DescribeBundleTasksResult, StaxUnmarshallerContext> {
    private static DescribeBundleTasksResultStaxUnmarshaller instance;

    public static DescribeBundleTasksResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeBundleTasksResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeBundleTasksResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeBundleTasksResult describeBundleTasksResult = new DescribeBundleTasksResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeBundleTasksResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("bundleInstanceTasksSet/item", i)) {
                    describeBundleTasksResult.getBundleTasks().add(BundleTaskStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeBundleTasksResult;
            }
        }
    }
}
