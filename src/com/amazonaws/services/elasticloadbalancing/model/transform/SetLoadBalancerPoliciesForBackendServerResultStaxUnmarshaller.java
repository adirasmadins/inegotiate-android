package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesForBackendServerResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SetLoadBalancerPoliciesForBackendServerResultStaxUnmarshaller implements Unmarshaller<SetLoadBalancerPoliciesForBackendServerResult, StaxUnmarshallerContext> {
    private static SetLoadBalancerPoliciesForBackendServerResultStaxUnmarshaller instance;

    public static SetLoadBalancerPoliciesForBackendServerResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetLoadBalancerPoliciesForBackendServerResultStaxUnmarshaller();
        }
        return instance;
    }

    public SetLoadBalancerPoliciesForBackendServerResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SetLoadBalancerPoliciesForBackendServerResult setLoadBalancerPoliciesForBackendServerResult = new SetLoadBalancerPoliciesForBackendServerResult();
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
        return setLoadBalancerPoliciesForBackendServerResult;
    }
}
