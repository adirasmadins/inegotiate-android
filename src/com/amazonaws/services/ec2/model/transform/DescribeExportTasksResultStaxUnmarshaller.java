package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeExportTasksResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeExportTasksResultStaxUnmarshaller implements Unmarshaller<DescribeExportTasksResult, StaxUnmarshallerContext> {
    private static DescribeExportTasksResultStaxUnmarshaller instance;

    public static DescribeExportTasksResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeExportTasksResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeExportTasksResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeExportTasksResult describeExportTasksResult = new DescribeExportTasksResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeExportTasksResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("exportTaskSet/item", i)) {
                    describeExportTasksResult.getExportTasks().add(ExportTaskStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeExportTasksResult;
            }
        }
    }
}
