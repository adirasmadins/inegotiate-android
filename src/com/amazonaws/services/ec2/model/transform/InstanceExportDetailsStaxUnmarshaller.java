package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceExportDetails;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceExportDetailsStaxUnmarshaller implements Unmarshaller<InstanceExportDetails, StaxUnmarshallerContext> {
    private static InstanceExportDetailsStaxUnmarshaller instance;

    public static InstanceExportDetailsStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceExportDetailsStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceExportDetails unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceExportDetails instanceExportDetails = new InstanceExportDetails();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceExportDetails;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    instanceExportDetails.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("targetEnvironment", i)) {
                    instanceExportDetails.setTargetEnvironment(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceExportDetails;
            }
        }
    }
}
