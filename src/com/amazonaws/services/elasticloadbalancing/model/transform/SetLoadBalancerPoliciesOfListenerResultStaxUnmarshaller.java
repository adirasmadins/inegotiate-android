package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesOfListenerResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SetLoadBalancerPoliciesOfListenerResultStaxUnmarshaller implements Unmarshaller<SetLoadBalancerPoliciesOfListenerResult, StaxUnmarshallerContext> {
    private static SetLoadBalancerPoliciesOfListenerResultStaxUnmarshaller instance;

    public static SetLoadBalancerPoliciesOfListenerResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetLoadBalancerPoliciesOfListenerResultStaxUnmarshaller();
        }
        return instance;
    }

    public SetLoadBalancerPoliciesOfListenerResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SetLoadBalancerPoliciesOfListenerResult setLoadBalancerPoliciesOfListenerResult = new SetLoadBalancerPoliciesOfListenerResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (!nextEvent.isEndDocument()) {
                if (!nextEvent.isAttribute() && !nextEvent.isStartElement() && nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                    break;
                }
            } else {
                break;
            }
        }
        return setLoadBalancerPoliciesOfListenerResult;
    }
}
