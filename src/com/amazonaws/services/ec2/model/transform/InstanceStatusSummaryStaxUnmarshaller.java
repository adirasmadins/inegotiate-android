package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceStatusSummary;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class InstanceStatusSummaryStaxUnmarshaller implements Unmarshaller<InstanceStatusSummary, StaxUnmarshallerContext> {
    private static InstanceStatusSummaryStaxUnmarshaller instance;

    public static InstanceStatusSummaryStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceStatusSummaryStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceStatusSummary unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceStatusSummary instanceStatusSummary = new InstanceStatusSummary();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceStatusSummary;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(DBAdapter.STATUS, i)) {
                    instanceStatusSummary.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("details/item", i)) {
                    instanceStatusSummary.getDetails().add(InstanceStatusDetailsStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceStatusSummary;
            }
        }
    }
}
