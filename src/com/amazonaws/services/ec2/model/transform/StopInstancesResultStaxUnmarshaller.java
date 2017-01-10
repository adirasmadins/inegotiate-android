package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.StopInstancesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class StopInstancesResultStaxUnmarshaller implements Unmarshaller<StopInstancesResult, StaxUnmarshallerContext> {
    private static StopInstancesResultStaxUnmarshaller instance;

    public static StopInstancesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new StopInstancesResultStaxUnmarshaller();
        }
        return instance;
    }

    public StopInstancesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        StopInstancesResult stopInstancesResult = new StopInstancesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return stopInstancesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instancesSet/item", i)) {
                    stopInstancesResult.getStoppingInstances().add(InstanceStateChangeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return stopInstancesResult;
            }
        }
    }
}
