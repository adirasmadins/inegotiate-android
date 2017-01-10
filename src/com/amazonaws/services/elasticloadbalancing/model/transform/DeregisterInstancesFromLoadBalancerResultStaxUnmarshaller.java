package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.DeregisterInstancesFromLoadBalancerResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DeregisterInstancesFromLoadBalancerResultStaxUnmarshaller implements Unmarshaller<DeregisterInstancesFromLoadBalancerResult, StaxUnmarshallerContext> {
    private static DeregisterInstancesFromLoadBalancerResultStaxUnmarshaller instance;

    public static DeregisterInstancesFromLoadBalancerResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeregisterInstancesFromLoadBalancerResultStaxUnmarshaller();
        }
        return instance;
    }

    public DeregisterInstancesFromLoadBalancerResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DeregisterInstancesFromLoadBalancerResult deregisterInstancesFromLoadBalancerResult = new DeregisterInstancesFromLoadBalancerResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return deregisterInstancesFromLoadBalancerResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Instances/member", i)) {
                    deregisterInstancesFromLoadBalancerResult.getInstances().add(InstanceStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return deregisterInstancesFromLoadBalancerResult;
            }
        }
    }
}
