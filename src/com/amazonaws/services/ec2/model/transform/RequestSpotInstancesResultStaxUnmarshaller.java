package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.RequestSpotInstancesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class RequestSpotInstancesResultStaxUnmarshaller implements Unmarshaller<RequestSpotInstancesResult, StaxUnmarshallerContext> {
    private static RequestSpotInstancesResultStaxUnmarshaller instance;

    public static RequestSpotInstancesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RequestSpotInstancesResultStaxUnmarshaller();
        }
        return instance;
    }

    public RequestSpotInstancesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        RequestSpotInstancesResult requestSpotInstancesResult = new RequestSpotInstancesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return requestSpotInstancesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("spotInstanceRequestSet/item", i)) {
                    requestSpotInstancesResult.getSpotInstanceRequests().add(SpotInstanceRequestStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return requestSpotInstancesResult;
            }
        }
    }
}
