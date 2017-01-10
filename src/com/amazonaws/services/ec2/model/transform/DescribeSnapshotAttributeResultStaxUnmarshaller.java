package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeSnapshotAttributeResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeSnapshotAttributeResultStaxUnmarshaller implements Unmarshaller<DescribeSnapshotAttributeResult, StaxUnmarshallerContext> {
    private static DescribeSnapshotAttributeResultStaxUnmarshaller instance;

    public static DescribeSnapshotAttributeResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeSnapshotAttributeResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeSnapshotAttributeResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeSnapshotAttributeResult describeSnapshotAttributeResult = new DescribeSnapshotAttributeResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeSnapshotAttributeResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("snapshotId", i)) {
                    describeSnapshotAttributeResult.setSnapshotId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("createVolumePermission/item", i)) {
                    describeSnapshotAttributeResult.getCreateVolumePermissions().add(CreateVolumePermissionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("productCodes/item", i)) {
                    describeSnapshotAttributeResult.getProductCodes().add(ProductCodeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeSnapshotAttributeResult;
            }
        }
    }
}
