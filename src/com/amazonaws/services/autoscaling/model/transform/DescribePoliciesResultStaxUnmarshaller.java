package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribePoliciesResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribePoliciesResultStaxUnmarshaller implements Unmarshaller<DescribePoliciesResult, StaxUnmarshallerContext> {
    private static DescribePoliciesResultStaxUnmarshaller instance;

    public static DescribePoliciesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribePoliciesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribePoliciesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribePoliciesResult describePoliciesResult = new DescribePoliciesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describePoliciesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("ScalingPolicies/member", i)) {
                    describePoliciesResult.getScalingPolicies().add(ScalingPolicyStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    describePoliciesResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describePoliciesResult;
            }
        }
    }
}
