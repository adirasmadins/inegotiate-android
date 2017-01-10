package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceState;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
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
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceState;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("code", i)) {
                    instanceState.setCode(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("name", i)) {
                    instanceState.setName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceState;
            }
        }
    }
}
