package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceStateChange;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceStateChangeStaxUnmarshaller implements Unmarshaller<InstanceStateChange, StaxUnmarshallerContext> {
    private static InstanceStateChangeStaxUnmarshaller instance;

    public static InstanceStateChangeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceStateChangeStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceStateChange unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceStateChange instanceStateChange = new InstanceStateChange();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceStateChange;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    instanceStateChange.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("currentState", i)) {
                    instanceStateChange.setCurrentState(InstanceStateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("previousState", i)) {
                    instanceStateChange.setPreviousState(InstanceStateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceStateChange;
            }
        }
    }
}
