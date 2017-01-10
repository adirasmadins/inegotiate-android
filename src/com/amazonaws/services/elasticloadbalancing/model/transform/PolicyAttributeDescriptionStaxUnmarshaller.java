package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.PolicyAttributeDescription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class PolicyAttributeDescriptionStaxUnmarshaller implements Unmarshaller<PolicyAttributeDescription, StaxUnmarshallerContext> {
    private static PolicyAttributeDescriptionStaxUnmarshaller instance;

    public static PolicyAttributeDescriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PolicyAttributeDescriptionStaxUnmarshaller();
        }
        return instance;
    }

    public PolicyAttributeDescription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PolicyAttributeDescription policyAttributeDescription = new PolicyAttributeDescription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return policyAttributeDescription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AttributeName", i)) {
                    policyAttributeDescription.setAttributeName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AttributeValue", i)) {
                    policyAttributeDescription.setAttributeValue(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return policyAttributeDescription;
            }
        }
    }
}
