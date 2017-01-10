package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancerPolicyTypesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeLoadBalancerPolicyTypesResultStaxUnmarshaller implements Unmarshaller<DescribeLoadBalancerPolicyTypesResult, StaxUnmarshallerContext> {
    private static DescribeLoadBalancerPolicyTypesResultStaxUnmarshaller instance;

    public static DescribeLoadBalancerPolicyTypesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeLoadBalancerPolicyTypesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeLoadBalancerPolicyTypesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeLoadBalancerPolicyTypesResult describeLoadBalancerPolicyTypesResult = new DescribeLoadBalancerPolicyTypesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeLoadBalancerPolicyTypesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("PolicyTypeDescriptions/member", i)) {
                    describeLoadBalancerPolicyTypesResult.getPolicyTypeDescriptions().add(PolicyTypeDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeLoadBalancerPolicyTypesResult;
            }
        }
    }
}
