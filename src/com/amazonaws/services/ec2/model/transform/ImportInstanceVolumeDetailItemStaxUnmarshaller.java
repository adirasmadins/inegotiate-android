package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ImportInstanceVolumeDetailItem;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class ImportInstanceVolumeDetailItemStaxUnmarshaller implements Unmarshaller<ImportInstanceVolumeDetailItem, StaxUnmarshallerContext> {
    private static ImportInstanceVolumeDetailItemStaxUnmarshaller instance;

    public static ImportInstanceVolumeDetailItemStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ImportInstanceVolumeDetailItemStaxUnmarshaller();
        }
        return instance;
    }

    public ImportInstanceVolumeDetailItem unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ImportInstanceVolumeDetailItem importInstanceVolumeDetailItem = new ImportInstanceVolumeDetailItem();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return importInstanceVolumeDetailItem;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("bytesConverted", i)) {
                    importInstanceVolumeDetailItem.setBytesConverted(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("availabilityZone", i)) {
                    importInstanceVolumeDetailItem.setAvailabilityZone(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("image", i)) {
                    importInstanceVolumeDetailItem.setImage(DiskImageDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("volume", i)) {
                    importInstanceVolumeDetailItem.setVolume(DiskImageVolumeDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression(DBAdapter.STATUS, i)) {
                    importInstanceVolumeDetailItem.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("statusMessage", i)) {
                    importInstanceVolumeDetailItem.setStatusMessage(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("description", i)) {
                    importInstanceVolumeDetailItem.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return importInstanceVolumeDetailItem;
            }
        }
    }
}
