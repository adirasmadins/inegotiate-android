package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ExportTask;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ExportTaskStaxUnmarshaller implements Unmarshaller<ExportTask, StaxUnmarshallerContext> {
    private static ExportTaskStaxUnmarshaller instance;

    public static ExportTaskStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ExportTaskStaxUnmarshaller();
        }
        return instance;
    }

    public ExportTask unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ExportTask exportTask = new ExportTask();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return exportTask;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("exportTaskId", i)) {
                    exportTask.setExportTaskId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("description", i)) {
                    exportTask.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("state", i)) {
                    exportTask.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("statusMessage", i)) {
                    exportTask.setStatusMessage(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceExport", i)) {
                    exportTask.setInstanceExportDetails(InstanceExportDetailsStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("exportToS3", i)) {
                    exportTask.setExportToS3Task(ExportToS3TaskStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return exportTask;
            }
        }
    }
}
