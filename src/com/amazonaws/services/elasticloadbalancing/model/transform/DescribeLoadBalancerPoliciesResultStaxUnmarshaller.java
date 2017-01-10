package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancerPoliciesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeLoadBalancerPoliciesResultStaxUnmarshaller implements Unmarshaller<DescribeLoadBalancerPoliciesResult, StaxUnmarshallerContext> {
    private static DescribeLoadBalancerPoliciesResultStaxUnmarshaller instance;

    public static DescribeLoadBalancerPoliciesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeLoadBalancerPoliciesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeLoadBalancerPoliciesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeLoadBalancerPoliciesResult describeLoadBalancerPoliciesResult = new DescribeLoadBalancerPoliciesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeLoadBalancerPoliciesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("PolicyDescriptions/member", i)) {
                    describeLoadBalancerPoliciesResult.getPolicyDescriptions().add(PolicyDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeLoadBalancerPoliciesResult;
            }
        }
    }
}
