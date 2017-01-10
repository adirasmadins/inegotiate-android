package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ImportInstanceResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ImportInstanceResultStaxUnmarshaller implements Unmarshaller<ImportInstanceResult, StaxUnmarshallerContext> {
    private static ImportInstanceResultStaxUnmarshaller instance;

    public static ImportInstanceResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ImportInstanceResultStaxUnmarshaller();
        }
        return instance;
    }

    public ImportInstanceResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ImportInstanceResult importInstanceResult = new ImportInstanceResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return importInstanceResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("conversionTask", i)) {
                    importInstanceResult.setConversionTask(ConversionTaskStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return importInstanceResult;
            }
        }
    }
}
