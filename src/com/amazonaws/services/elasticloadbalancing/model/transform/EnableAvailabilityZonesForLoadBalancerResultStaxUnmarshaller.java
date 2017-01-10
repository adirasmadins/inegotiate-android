package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.EnableAvailabilityZonesForLoadBalancerResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class EnableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller implements Unmarshaller<EnableAvailabilityZonesForLoadBalancerResult, StaxUnmarshallerContext> {
    private static EnableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller instance;

    public static EnableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new EnableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller();
        }
        return instance;
    }

    public EnableAvailabilityZonesForLoadBalancerResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        EnableAvailabilityZonesForLoadBalancerResult enableAvailabilityZonesForLoadBalancerResult = new EnableAvailabilityZonesForLoadBalancerResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return enableAvailabilityZonesForLoadBalancerResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AvailabilityZones/member", i)) {
                    enableAvailabilityZonesForLoadBalancerResult.getAvailabilityZones().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return enableAvailabilityZonesForLoadBalancerResult;
            }
        }
    }
}
