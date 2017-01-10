package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.Instance;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceStaxUnmarshaller implements Unmarshaller<Instance, StaxUnmarshallerContext> {
    private static InstanceStaxUnmarshaller instance;

    public static InstanceStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceStaxUnmarshaller();
        }
        return instance;
    }

    public Instance unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Instance instance = new Instance();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instance;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("InstanceId", i)) {
                    instance.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instance;
            }
        }
    }
}
