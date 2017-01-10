package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CancelledSpotInstanceRequest;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CancelledSpotInstanceRequestStaxUnmarshaller implements Unmarshaller<CancelledSpotInstanceRequest, StaxUnmarshallerContext> {
    private static CancelledSpotInstanceRequestStaxUnmarshaller instance;

    public static CancelledSpotInstanceRequestStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CancelledSpotInstanceRequestStaxUnmarshaller();
        }
        return instance;
    }

    public CancelledSpotInstanceRequest unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CancelledSpotInstanceRequest cancelledSpotInstanceRequest = new CancelledSpotInstanceRequest();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return cancelledSpotInstanceRequest;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("spotInstanceRequestId", i)) {
                    cancelledSpotInstanceRequest.setSpotInstanceRequestId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("state", i)) {
                    cancelledSpotInstanceRequest.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return cancelledSpotInstanceRequest;
            }
        }
    }
}
