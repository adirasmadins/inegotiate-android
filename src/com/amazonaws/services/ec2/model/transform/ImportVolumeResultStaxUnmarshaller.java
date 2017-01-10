package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ImportVolumeResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ImportVolumeResultStaxUnmarshaller implements Unmarshaller<ImportVolumeResult, StaxUnmarshallerContext> {
    private static ImportVolumeResultStaxUnmarshaller instance;

    public static ImportVolumeResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ImportVolumeResultStaxUnmarshaller();
        }
        return instance;
    }

    public ImportVolumeResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ImportVolumeResult importVolumeResult = new ImportVolumeResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return importVolumeResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("conversionTask", i)) {
                    importVolumeResult.setConversionTask(ConversionTaskStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return importVolumeResult;
            }
        }
    }
}
