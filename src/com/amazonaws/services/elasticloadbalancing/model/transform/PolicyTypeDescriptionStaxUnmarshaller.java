package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.PolicyTypeDescription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class PolicyTypeDescriptionStaxUnmarshaller implements Unmarshaller<PolicyTypeDescription, StaxUnmarshallerContext> {
    private static PolicyTypeDescriptionStaxUnmarshaller instance;

    public static PolicyTypeDescriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PolicyTypeDescriptionStaxUnmarshaller();
        }
        return instance;
    }

    public PolicyTypeDescription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PolicyTypeDescription policyTypeDescription = new PolicyTypeDescription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return policyTypeDescription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("PolicyTypeName", i)) {
                    policyTypeDescription.setPolicyTypeName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Description", i)) {
                    policyTypeDescription.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("PolicyAttributeTypeDescriptions/member", i)) {
                    policyTypeDescription.getPolicyAttributeTypeDescriptions().add(PolicyAttributeTypeDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return policyTypeDescription;
            }
        }
    }
}
