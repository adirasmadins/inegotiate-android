package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CreateInstanceExportTaskResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateInstanceExportTaskResultStaxUnmarshaller implements Unmarshaller<CreateInstanceExportTaskResult, StaxUnmarshallerContext> {
    private static CreateInstanceExportTaskResultStaxUnmarshaller instance;

    public static CreateInstanceExportTaskResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateInstanceExportTaskResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateInstanceExportTaskResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateInstanceExportTaskResult createInstanceExportTaskResult = new CreateInstanceExportTaskResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createInstanceExportTaskResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("exportTask", i)) {
                    createInstanceExportTaskResult.setExportTask(ExportTaskStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createInstanceExportTaskResult;
            }
        }
    }
}
