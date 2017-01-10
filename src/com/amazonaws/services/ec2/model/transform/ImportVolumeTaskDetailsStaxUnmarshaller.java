package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ImportVolumeTaskDetails;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ImportVolumeTaskDetailsStaxUnmarshaller implements Unmarshaller<ImportVolumeTaskDetails, StaxUnmarshallerContext> {
    private static ImportVolumeTaskDetailsStaxUnmarshaller instance;

    public static ImportVolumeTaskDetailsStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ImportVolumeTaskDetailsStaxUnmarshaller();
        }
        return instance;
    }

    public ImportVolumeTaskDetails unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ImportVolumeTaskDetails importVolumeTaskDetails = new ImportVolumeTaskDetails();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return importVolumeTaskDetails;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("bytesConverted", i)) {
                    importVolumeTaskDetails.setBytesConverted(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("availabilityZone", i)) {
                    importVolumeTaskDetails.setAvailabilityZone(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("description", i)) {
                    importVolumeTaskDetails.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("image", i)) {
                    importVolumeTaskDetails.setImage(DiskImageDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("volume", i)) {
                    importVolumeTaskDetails.setVolume(DiskImageVolumeDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return importVolumeTaskDetails;
            }
        }
    }
}
