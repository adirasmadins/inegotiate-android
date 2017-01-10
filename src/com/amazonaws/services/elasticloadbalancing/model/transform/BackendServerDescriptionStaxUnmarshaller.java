package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.BackendServerDescription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class BackendServerDescriptionStaxUnmarshaller implements Unmarshaller<BackendServerDescription, StaxUnmarshallerContext> {
    private static BackendServerDescriptionStaxUnmarshaller instance;

    public static BackendServerDescriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BackendServerDescriptionStaxUnmarshaller();
        }
        return instance;
    }

    public BackendServerDescription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        BackendServerDescription backendServerDescription = new BackendServerDescription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return backendServerDescription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("InstancePort", i)) {
                    backendServerDescription.setInstancePort(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("PolicyNames/member", i)) {
                    backendServerDescription.getPolicyNames().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return backendServerDescription;
            }
        }
    }
}
