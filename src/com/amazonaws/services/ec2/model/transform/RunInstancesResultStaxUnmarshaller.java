package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class RunInstancesResultStaxUnmarshaller implements Unmarshaller<RunInstancesResult, StaxUnmarshallerContext> {
    private static RunInstancesResultStaxUnmarshaller instance;

    public static RunInstancesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RunInstancesResultStaxUnmarshaller();
        }
        return instance;
    }

    public RunInstancesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        RunInstancesResult runInstancesResult = new RunInstancesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return runInstancesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(".", i)) {
                    runInstancesResult.setReservation(ReservationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return runInstancesResult;
            }
        }
    }
}
