package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.DisableAvailabilityZonesForLoadBalancerResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DisableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller implements Unmarshaller<DisableAvailabilityZonesForLoadBalancerResult, StaxUnmarshallerContext> {
    private static DisableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller instance;

    public static DisableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DisableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller();
        }
        return instance;
    }

    public DisableAvailabilityZonesForLoadBalancerResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DisableAvailabilityZonesForLoadBalancerResult disableAvailabilityZonesForLoadBalancerResult = new DisableAvailabilityZonesForLoadBalancerResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return disableAvailabilityZonesForLoadBalancerResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AvailabilityZones/member", i)) {
                    disableAvailabilityZonesForLoadBalancerResult.getAvailabilityZones().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return disableAvailabilityZonesForLoadBalancerResult;
            }
        }
    }
}
