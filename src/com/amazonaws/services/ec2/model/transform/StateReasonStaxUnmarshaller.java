package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.StateReason;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class StateReasonStaxUnmarshaller implements Unmarshaller<StateReason, StaxUnmarshallerContext> {
    private static StateReasonStaxUnmarshaller instance;

    public static StateReasonStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new StateReasonStaxUnmarshaller();
        }
        return instance;
    }

    public StateReason unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        StateReason stateReason = new StateReason();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return stateReason;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("code", i)) {
                    stateReason.setCode(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("message", i)) {
                    stateReason.setMessage(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return stateReason;
            }
        }
    }
}
