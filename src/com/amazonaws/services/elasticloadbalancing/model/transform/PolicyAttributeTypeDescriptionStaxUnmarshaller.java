package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.PolicyAttributeTypeDescription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class PolicyAttributeTypeDescriptionStaxUnmarshaller implements Unmarshaller<PolicyAttributeTypeDescription, StaxUnmarshallerContext> {
    private static PolicyAttributeTypeDescriptionStaxUnmarshaller instance;

    public static PolicyAttributeTypeDescriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PolicyAttributeTypeDescriptionStaxUnmarshaller();
        }
        return instance;
    }

    public PolicyAttributeTypeDescription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PolicyAttributeTypeDescription policyAttributeTypeDescription = new PolicyAttributeTypeDescription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return policyAttributeTypeDescription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AttributeName", i)) {
                    policyAttributeTypeDescription.setAttributeName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AttributeType", i)) {
                    policyAttributeTypeDescription.setAttributeType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Description", i)) {
                    policyAttributeTypeDescription.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("DefaultValue", i)) {
                    policyAttributeTypeDescription.setDefaultValue(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Cardinality", i)) {
                    policyAttributeTypeDescription.setCardinality(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return policyAttributeTypeDescription;
            }
        }
    }
}
