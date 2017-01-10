package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.InstanceState;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceStateStaxUnmarshaller implements Unmarshaller<InstanceState, StaxUnmarshallerContext> {
    private static InstanceStateStaxUnmarshaller instance;

    public static InstanceStateStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceStateStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceState unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceState instanceState = new InstanceState();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceState;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("InstanceId", i)) {
                    instanceState.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("State", i)) {
                    instanceState.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ReasonCode", i)) {
                    instanceState.setReasonCode(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Description", i)) {
                    instanceState.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceState;
            }
        }
    }
}
