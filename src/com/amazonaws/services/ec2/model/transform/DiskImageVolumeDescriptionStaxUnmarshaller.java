package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DiskImageVolumeDescription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DiskImageVolumeDescriptionStaxUnmarshaller implements Unmarshaller<DiskImageVolumeDescription, StaxUnmarshallerContext> {
    private static DiskImageVolumeDescriptionStaxUnmarshaller instance;

    public static DiskImageVolumeDescriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DiskImageVolumeDescriptionStaxUnmarshaller();
        }
        return instance;
    }

    public DiskImageVolumeDescription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DiskImageVolumeDescription diskImageVolumeDescription = new DiskImageVolumeDescription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return diskImageVolumeDescription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("size", i)) {
                    diskImageVolumeDescription.setSize(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("id", i)) {
                    diskImageVolumeDescription.setId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return diskImageVolumeDescription;
            }
        }
    }
}
