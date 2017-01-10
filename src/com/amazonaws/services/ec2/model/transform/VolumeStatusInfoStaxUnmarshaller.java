package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.VolumeStatusInfo;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class VolumeStatusInfoStaxUnmarshaller implements Unmarshaller<VolumeStatusInfo, StaxUnmarshallerContext> {
    private static VolumeStatusInfoStaxUnmarshaller instance;

    public static VolumeStatusInfoStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VolumeStatusInfoStaxUnmarshaller();
        }
        return instance;
    }

    public VolumeStatusInfo unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        VolumeStatusInfo volumeStatusInfo = new VolumeStatusInfo();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return volumeStatusInfo;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(DBAdapter.STATUS, i)) {
                    volumeStatusInfo.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("details/item", i)) {
                    volumeStatusInfo.getDetails().add(VolumeStatusDetailsStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return volumeStatusInfo;
            }
        }
    }
}
