package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeSnapshotsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeSnapshotsResultStaxUnmarshaller implements Unmarshaller<DescribeSnapshotsResult, StaxUnmarshallerContext> {
    private static DescribeSnapshotsResultStaxUnmarshaller instance;

    public static DescribeSnapshotsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeSnapshotsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeSnapshotsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeSnapshotsResult describeSnapshotsResult = new DescribeSnapshotsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeSnapshotsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("snapshotSet/item", i)) {
                    describeSnapshotsResult.getSnapshots().add(SnapshotStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeSnapshotsResult;
            }
        }
    }
}
