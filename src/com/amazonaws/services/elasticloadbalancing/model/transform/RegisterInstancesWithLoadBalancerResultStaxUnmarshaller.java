package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.RegisterInstancesWithLoadBalancerResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class RegisterInstancesWithLoadBalancerResultStaxUnmarshaller implements Unmarshaller<RegisterInstancesWithLoadBalancerResult, StaxUnmarshallerContext> {
    private static RegisterInstancesWithLoadBalancerResultStaxUnmarshaller instance;

    public static RegisterInstancesWithLoadBalancerResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RegisterInstancesWithLoadBalancerResultStaxUnmarshaller();
        }
        return instance;
    }

    public RegisterInstancesWithLoadBalancerResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        RegisterInstancesWithLoadBalancerResult registerInstancesWithLoadBalancerResult = new RegisterInstancesWithLoadBalancerResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return registerInstancesWithLoadBalancerResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Instances/member", i)) {
                    registerInstancesWithLoadBalancerResult.getInstances().add(InstanceStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return registerInstancesWithLoadBalancerResult;
            }
        }
    }
}
