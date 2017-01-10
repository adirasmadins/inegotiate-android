package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.DeleteLoadBalancerPolicyResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DeleteLoadBalancerPolicyResultStaxUnmarshaller implements Unmarshaller<DeleteLoadBalancerPolicyResult, StaxUnmarshallerContext> {
    private static DeleteLoadBalancerPolicyResultStaxUnmarshaller instance;

    public static DeleteLoadBalancerPolicyResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteLoadBalancerPolicyResultStaxUnmarshaller();
        }
        return instance;
    }

    public DeleteLoadBalancerPolicyResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DeleteLoadBalancerPolicyResult deleteLoadBalancerPolicyResult = new DeleteLoadBalancerPolicyResult();
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
        return deleteLoadBalancerPolicyResult;
    }
}
