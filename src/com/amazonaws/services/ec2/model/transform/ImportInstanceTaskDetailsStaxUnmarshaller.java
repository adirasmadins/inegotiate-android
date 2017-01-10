package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ImportInstanceTaskDetails;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ImportInstanceTaskDetailsStaxUnmarshaller implements Unmarshaller<ImportInstanceTaskDetails, StaxUnmarshallerContext> {
    private static ImportInstanceTaskDetailsStaxUnmarshaller instance;

    public static ImportInstanceTaskDetailsStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ImportInstanceTaskDetailsStaxUnmarshaller();
        }
        return instance;
    }

    public ImportInstanceTaskDetails unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ImportInstanceTaskDetails importInstanceTaskDetails = new ImportInstanceTaskDetails();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return importInstanceTaskDetails;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("volumes/item", i)) {
                    importInstanceTaskDetails.getVolumes().add(ImportInstanceVolumeDetailItemStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    importInstanceTaskDetails.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("platform", i)) {
                    importInstanceTaskDetails.setPlatform(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("description", i)) {
                    importInstanceTaskDetails.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return importInstanceTaskDetails;
            }
        }
    }
}
