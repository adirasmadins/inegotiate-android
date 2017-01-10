package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ConversionTask;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ConversionTaskStaxUnmarshaller implements Unmarshaller<ConversionTask, StaxUnmarshallerContext> {
    private static ConversionTaskStaxUnmarshaller instance;

    public static ConversionTaskStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConversionTaskStaxUnmarshaller();
        }
        return instance;
    }

    public ConversionTask unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ConversionTask conversionTask = new ConversionTask();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return conversionTask;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("conversionTaskId", i)) {
                    conversionTask.setConversionTaskId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("expirationTime", i)) {
                    conversionTask.setExpirationTime(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("importInstance", i)) {
                    conversionTask.setImportInstance(ImportInstanceTaskDetailsStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("importVolume", i)) {
                    conversionTask.setImportVolume(ImportVolumeTaskDetailsStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("state", i)) {
                    conversionTask.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("statusMessage", i)) {
                    conversionTask.setStatusMessage(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("tagSet/item", i)) {
                    conversionTask.getTags().add(TagStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return conversionTask;
            }
        }
    }
}
