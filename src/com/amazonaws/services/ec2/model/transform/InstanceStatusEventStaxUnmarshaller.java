package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceStatusEvent;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceStatusEventStaxUnmarshaller implements Unmarshaller<InstanceStatusEvent, StaxUnmarshallerContext> {
    private static InstanceStatusEventStaxUnmarshaller instance;

    public static InstanceStatusEventStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceStatusEventStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceStatusEvent unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceStatusEvent instanceStatusEvent = new InstanceStatusEvent();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceStatusEvent;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("code", i)) {
                    instanceStatusEvent.setCode(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("description", i)) {
                    instanceStatusEvent.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("notBefore", i)) {
                    instanceStatusEvent.setNotBefore(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("notAfter", i)) {
                    instanceStatusEvent.setNotAfter(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceStatusEvent;
            }
        }
    }
}
