package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.DetachLoadBalancerFromSubnetsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DetachLoadBalancerFromSubnetsResultStaxUnmarshaller implements Unmarshaller<DetachLoadBalancerFromSubnetsResult, StaxUnmarshallerContext> {
    private static DetachLoadBalancerFromSubnetsResultStaxUnmarshaller instance;

    public static DetachLoadBalancerFromSubnetsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DetachLoadBalancerFromSubnetsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DetachLoadBalancerFromSubnetsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DetachLoadBalancerFromSubnetsResult detachLoadBalancerFromSubnetsResult = new DetachLoadBalancerFromSubnetsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return detachLoadBalancerFromSubnetsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Subnets/member", i)) {
                    detachLoadBalancerFromSubnetsResult.getSubnets().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return detachLoadBalancerFromSubnetsResult;
            }
        }
    }
}
