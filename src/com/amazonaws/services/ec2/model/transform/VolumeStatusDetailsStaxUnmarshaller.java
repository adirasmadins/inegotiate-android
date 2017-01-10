package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.VolumeStatusDetails;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class VolumeStatusDetailsStaxUnmarshaller implements Unmarshaller<VolumeStatusDetails, StaxUnmarshallerContext> {
    private static VolumeStatusDetailsStaxUnmarshaller instance;

    public static VolumeStatusDetailsStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VolumeStatusDetailsStaxUnmarshaller();
        }
        return instance;
    }

    public VolumeStatusDetails unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        VolumeStatusDetails volumeStatusDetails = new VolumeStatusDetails();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return volumeStatusDetails;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("name", i)) {
                    volumeStatusDetails.setName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression(DBAdapter.STATUS, i)) {
                    volumeStatusDetails.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return volumeStatusDetails;
            }
        }
    }
}
