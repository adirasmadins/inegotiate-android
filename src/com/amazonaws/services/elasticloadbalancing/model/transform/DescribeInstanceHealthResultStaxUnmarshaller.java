package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.DescribeInstanceHealthResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeInstanceHealthResultStaxUnmarshaller implements Unmarshaller<DescribeInstanceHealthResult, StaxUnmarshallerContext> {
    private static DescribeInstanceHealthResultStaxUnmarshaller instance;

    public static DescribeInstanceHealthResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeInstanceHealthResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeInstanceHealthResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeInstanceHealthResult describeInstanceHealthResult = new DescribeInstanceHealthResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeInstanceHealthResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("InstanceStates/member", i)) {
                    describeInstanceHealthResult.getInstanceStates().add(InstanceStateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeInstanceHealthResult;
            }
        }
    }
}
