package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.SendDataPoint;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SendDataPointStaxUnmarshaller implements Unmarshaller<SendDataPoint, StaxUnmarshallerContext> {
    private static SendDataPointStaxUnmarshaller instance;

    public static SendDataPointStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SendDataPointStaxUnmarshaller();
        }
        return instance;
    }

    public SendDataPoint unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SendDataPoint sendDataPoint = new SendDataPoint();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return sendDataPoint;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Timestamp", i)) {
                    sendDataPoint.setTimestamp(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("DeliveryAttempts", i)) {
                    sendDataPoint.setDeliveryAttempts(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Bounces", i)) {
                    sendDataPoint.setBounces(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Complaints", i)) {
                    sendDataPoint.setComplaints(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Rejects", i)) {
                    sendDataPoint.setRejects(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return sendDataPoint;
            }
        }
    }
}
