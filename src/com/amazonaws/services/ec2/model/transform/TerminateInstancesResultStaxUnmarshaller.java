package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.TerminateInstancesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class TerminateInstancesResultStaxUnmarshaller implements Unmarshaller<TerminateInstancesResult, StaxUnmarshallerContext> {
    private static TerminateInstancesResultStaxUnmarshaller instance;

    public static TerminateInstancesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TerminateInstancesResultStaxUnmarshaller();
        }
        return instance;
    }

    public TerminateInstancesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        TerminateInstancesResult terminateInstancesResult = new TerminateInstancesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return terminateInstancesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instancesSet/item", i)) {
                    terminateInstancesResult.getTerminatingInstances().add(InstanceStateChangeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return terminateInstancesResult;
            }
        }
    }
}
