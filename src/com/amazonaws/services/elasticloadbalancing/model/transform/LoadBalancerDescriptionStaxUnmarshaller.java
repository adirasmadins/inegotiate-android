package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.LoadBalancerDescription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class LoadBalancerDescriptionStaxUnmarshaller implements Unmarshaller<LoadBalancerDescription, StaxUnmarshallerContext> {
    private static LoadBalancerDescriptionStaxUnmarshaller instance;

    public static LoadBalancerDescriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LoadBalancerDescriptionStaxUnmarshaller();
        }
        return instance;
    }

    public LoadBalancerDescription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        LoadBalancerDescription loadBalancerDescription = new LoadBalancerDescription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return loadBalancerDescription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("LoadBalancerName", i)) {
                    loadBalancerDescription.setLoadBalancerName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("DNSName", i)) {
                    loadBalancerDescription.setDNSName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("CanonicalHostedZoneName", i)) {
                    loadBalancerDescription.setCanonicalHostedZoneName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("CanonicalHostedZoneNameID", i)) {
                    loadBalancerDescription.setCanonicalHostedZoneNameID(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ListenerDescriptions/member", i)) {
                    loadBalancerDescription.getListenerDescriptions().add(ListenerDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Policies", i)) {
                    loadBalancerDescription.setPolicies(PoliciesStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("BackendServerDescriptions/member", i)) {
                    loadBalancerDescription.getBackendServerDescriptions().add(BackendServerDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AvailabilityZones/member", i)) {
                    loadBalancerDescription.getAvailabilityZones().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Subnets/member", i)) {
                    loadBalancerDescription.getSubnets().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("VPCId", i)) {
                    loadBalancerDescription.setVPCId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Instances/member", i)) {
                    loadBalancerDescription.getInstances().add(InstanceStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("HealthCheck", i)) {
                    loadBalancerDescription.setHealthCheck(HealthCheckStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("SourceSecurityGroup", i)) {
                    loadBalancerDescription.setSourceSecurityGroup(SourceSecurityGroupStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("SecurityGroups/member", i)) {
                    loadBalancerDescription.getSecurityGroups().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("CreatedTime", i)) {
                    loadBalancerDescription.setCreatedTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Scheme", i)) {
                    loadBalancerDescription.setScheme(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return loadBalancerDescription;
            }
        }
    }
}
