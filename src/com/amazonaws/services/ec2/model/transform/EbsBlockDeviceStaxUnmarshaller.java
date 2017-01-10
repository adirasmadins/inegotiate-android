package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.EbsBlockDevice;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class EbsBlockDeviceStaxUnmarshaller implements Unmarshaller<EbsBlockDevice, StaxUnmarshallerContext> {
    private static EbsBlockDeviceStaxUnmarshaller instance;

    public static EbsBlockDeviceStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new EbsBlockDeviceStaxUnmarshaller();
        }
        return instance;
    }

    public EbsBlockDevice unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        EbsBlockDevice ebsBlockDevice = new EbsBlockDevice();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return ebsBlockDevice;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("snapshotId", i)) {
                    ebsBlockDevice.setSnapshotId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("volumeSize", i)) {
                    ebsBlockDevice.setVolumeSize(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("deleteOnTermination", i)) {
                    ebsBlockDevice.setDeleteOnTermination(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("volumeType", i)) {
                    ebsBlockDevice.setVolumeType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("iops", i)) {
                    ebsBlockDevice.setIops(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return ebsBlockDevice;
            }
        }
    }
}
