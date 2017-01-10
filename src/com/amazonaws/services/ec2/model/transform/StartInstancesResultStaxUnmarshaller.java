package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.StartInstancesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class StartInstancesResultStaxUnmarshaller implements Unmarshaller<StartInstancesResult, StaxUnmarshallerContext> {
    private static StartInstancesResultStaxUnmarshaller instance;

    public static StartInstancesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new StartInstancesResultStaxUnmarshaller();
        }
        return instance;
    }

    public StartInstancesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        StartInstancesResult startInstancesResult = new StartInstancesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return startInstancesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instancesSet/item", i)) {
                    startInstancesResult.getStartingInstances().add(InstanceStateChangeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return startInstancesResult;
            }
        }
    }
}
