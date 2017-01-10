package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.AttachLoadBalancerToSubnetsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AttachLoadBalancerToSubnetsResultStaxUnmarshaller implements Unmarshaller<AttachLoadBalancerToSubnetsResult, StaxUnmarshallerContext> {
    private static AttachLoadBalancerToSubnetsResultStaxUnmarshaller instance;

    public static AttachLoadBalancerToSubnetsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AttachLoadBalancerToSubnetsResultStaxUnmarshaller();
        }
        return instance;
    }

    public AttachLoadBalancerToSubnetsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AttachLoadBalancerToSubnetsResult attachLoadBalancerToSubnetsResult = new AttachLoadBalancerToSubnetsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return attachLoadBalancerToSubnetsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Subnets/member", i)) {
                    attachLoadBalancerToSubnetsResult.getSubnets().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return attachLoadBalancerToSubnetsResult;
            }
        }
    }
}
