package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceStatusDetails;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class InstanceStatusDetailsStaxUnmarshaller implements Unmarshaller<InstanceStatusDetails, StaxUnmarshallerContext> {
    private static InstanceStatusDetailsStaxUnmarshaller instance;

    public static InstanceStatusDetailsStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceStatusDetailsStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceStatusDetails unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceStatusDetails instanceStatusDetails = new InstanceStatusDetails();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceStatusDetails;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("name", i)) {
                    instanceStatusDetails.setName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression(DBAdapter.STATUS, i)) {
                    instanceStatusDetails.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("impairedSince", i)) {
                    instanceStatusDetails.setImpairedSince(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceStatusDetails;
            }
        }
    }
}
