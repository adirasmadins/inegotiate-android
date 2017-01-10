package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DiskImageDescription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DiskImageDescriptionStaxUnmarshaller implements Unmarshaller<DiskImageDescription, StaxUnmarshallerContext> {
    private static DiskImageDescriptionStaxUnmarshaller instance;

    public static DiskImageDescriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DiskImageDescriptionStaxUnmarshaller();
        }
        return instance;
    }

    public DiskImageDescription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DiskImageDescription diskImageDescription = new DiskImageDescription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return diskImageDescription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("format", i)) {
                    diskImageDescription.setFormat(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("size", i)) {
                    diskImageDescription.setSize(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("importManifestUrl", i)) {
                    diskImageDescription.setImportManifestUrl(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("checksum", i)) {
                    diskImageDescription.setChecksum(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return diskImageDescription;
            }
        }
    }
}
