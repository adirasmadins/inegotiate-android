package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.EbsInstanceBlockDevice;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class EbsInstanceBlockDeviceStaxUnmarshaller implements Unmarshaller<EbsInstanceBlockDevice, StaxUnmarshallerContext> {
    private static EbsInstanceBlockDeviceStaxUnmarshaller instance;

    public static EbsInstanceBlockDeviceStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new EbsInstanceBlockDeviceStaxUnmarshaller();
        }
        return instance;
    }

    public EbsInstanceBlockDevice unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        EbsInstanceBlockDevice ebsInstanceBlockDevice = new EbsInstanceBlockDevice();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return ebsInstanceBlockDevice;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("volumeId", i)) {
                    ebsInstanceBlockDevice.setVolumeId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression(DBAdapter.STATUS, i)) {
                    ebsInstanceBlockDevice.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("attachTime", i)) {
                    ebsInstanceBlockDevice.setAttachTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("deleteOnTermination", i)) {
                    ebsInstanceBlockDevice.setDeleteOnTermination(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return ebsInstanceBlockDevice;
            }
        }
    }
}
