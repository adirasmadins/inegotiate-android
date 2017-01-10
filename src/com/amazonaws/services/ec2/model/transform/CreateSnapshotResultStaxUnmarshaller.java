package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CreateSnapshotResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateSnapshotResultStaxUnmarshaller implements Unmarshaller<CreateSnapshotResult, StaxUnmarshallerContext> {
    private static CreateSnapshotResultStaxUnmarshaller instance;

    public static CreateSnapshotResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateSnapshotResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateSnapshotResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateSnapshotResult createSnapshotResult = new CreateSnapshotResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createSnapshotResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(".", i)) {
                    createSnapshotResult.setSnapshot(SnapshotStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createSnapshotResult;
            }
        }
    }
}
