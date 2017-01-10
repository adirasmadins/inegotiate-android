package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CancelSpotInstanceRequestsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CancelSpotInstanceRequestsResultStaxUnmarshaller implements Unmarshaller<CancelSpotInstanceRequestsResult, StaxUnmarshallerContext> {
    private static CancelSpotInstanceRequestsResultStaxUnmarshaller instance;

    public static CancelSpotInstanceRequestsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CancelSpotInstanceRequestsResultStaxUnmarshaller();
        }
        return instance;
    }

    public CancelSpotInstanceRequestsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CancelSpotInstanceRequestsResult cancelSpotInstanceRequestsResult = new CancelSpotInstanceRequestsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return cancelSpotInstanceRequestsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("spotInstanceRequestSet/item", i)) {
                    cancelSpotInstanceRequestsResult.getCancelledSpotInstanceRequests().add(CancelledSpotInstanceRequestStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return cancelSpotInstanceRequestsResult;
            }
        }
    }
}
