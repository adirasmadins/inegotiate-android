package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.PolicyDescription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class PolicyDescriptionStaxUnmarshaller implements Unmarshaller<PolicyDescription, StaxUnmarshallerContext> {
    private static PolicyDescriptionStaxUnmarshaller instance;

    public static PolicyDescriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PolicyDescriptionStaxUnmarshaller();
        }
        return instance;
    }

    public PolicyDescription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PolicyDescription policyDescription = new PolicyDescription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return policyDescription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("PolicyName", i)) {
                    policyDescription.setPolicyName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("PolicyTypeName", i)) {
                    policyDescription.setPolicyTypeName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("PolicyAttributeDescriptions/member", i)) {
                    policyDescription.getPolicyAttributeDescriptions().add(PolicyAttributeDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return policyDescription;
            }
        }
    }
}
