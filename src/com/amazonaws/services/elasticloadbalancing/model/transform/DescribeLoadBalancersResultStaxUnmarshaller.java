package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeLoadBalancersResultStaxUnmarshaller implements Unmarshaller<DescribeLoadBalancersResult, StaxUnmarshallerContext> {
    private static DescribeLoadBalancersResultStaxUnmarshaller instance;

    public static DescribeLoadBalancersResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeLoadBalancersResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeLoadBalancersResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeLoadBalancersResult describeLoadBalancersResult = new DescribeLoadBalancersResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeLoadBalancersResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("LoadBalancerDescriptions/member", i)) {
                    describeLoadBalancersResult.getLoadBalancerDescriptions().add(LoadBalancerDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextMarker", i)) {
                    describeLoadBalancersResult.setNextMarker(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeLoadBalancersResult;
            }
        }
    }
}
