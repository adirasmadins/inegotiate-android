package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.SpotInstanceRequest;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SpotInstanceRequestStaxUnmarshaller implements Unmarshaller<SpotInstanceRequest, StaxUnmarshallerContext> {
    private static SpotInstanceRequestStaxUnmarshaller instance;

    public static SpotInstanceRequestStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SpotInstanceRequestStaxUnmarshaller();
        }
        return instance;
    }

    public SpotInstanceRequest unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SpotInstanceRequest spotInstanceRequest = new SpotInstanceRequest();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return spotInstanceRequest;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("spotInstanceRequestId", i)) {
                    spotInstanceRequest.setSpotInstanceRequestId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("spotPrice", i)) {
                    spotInstanceRequest.setSpotPrice(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("type", i)) {
                    spotInstanceRequest.setType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("state", i)) {
                    spotInstanceRequest.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("fault", i)) {
                    spotInstanceRequest.setFault(SpotInstanceStateFaultStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("validFrom", i)) {
                    spotInstanceRequest.setValidFrom(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("validUntil", i)) {
                    spotInstanceRequest.setValidUntil(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("launchGroup", i)) {
                    spotInstanceRequest.setLaunchGroup(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("availabilityZoneGroup", i)) {
                    spotInstanceRequest.setAvailabilityZoneGroup(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("launchSpecification", i)) {
                    spotInstanceRequest.setLaunchSpecification(LaunchSpecificationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    spotInstanceRequest.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("createTime", i)) {
                    spotInstanceRequest.setCreateTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("productDescription", i)) {
                    spotInstanceRequest.setProductDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("tagSet/item", i)) {
                    spotInstanceRequest.getTags().add(TagStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("launchedAvailabilityZone", i)) {
                    spotInstanceRequest.setLaunchedAvailabilityZone(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return spotInstanceRequest;
            }
        }
    }
}
