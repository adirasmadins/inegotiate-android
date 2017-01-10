package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.IdentityNotificationAttributes;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class IdentityNotificationAttributesStaxUnmarshaller implements Unmarshaller<IdentityNotificationAttributes, StaxUnmarshallerContext> {
    private static IdentityNotificationAttributesStaxUnmarshaller instance;

    public static IdentityNotificationAttributesStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new IdentityNotificationAttributesStaxUnmarshaller();
        }
        return instance;
    }

    public IdentityNotificationAttributes unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        IdentityNotificationAttributes identityNotificationAttributes = new IdentityNotificationAttributes();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return identityNotificationAttributes;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("BounceTopic", i)) {
                    identityNotificationAttributes.setBounceTopic(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ComplaintTopic", i)) {
                    identityNotificationAttributes.setComplaintTopic(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ForwardingEnabled", i)) {
                    identityNotificationAttributes.setForwardingEnabled(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return identityNotificationAttributes;
            }
        }
    }
}
