package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerPolicyResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateLoadBalancerPolicyResultStaxUnmarshaller implements Unmarshaller<CreateLoadBalancerPolicyResult, StaxUnmarshallerContext> {
    private static CreateLoadBalancerPolicyResultStaxUnmarshaller instance;

    public static CreateLoadBalancerPolicyResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateLoadBalancerPolicyResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateLoadBalancerPolicyResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateLoadBalancerPolicyResult createLoadBalancerPolicyResult = new CreateLoadBalancerPolicyResult();
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
        return createLoadBalancerPolicyResult;
    }
}
