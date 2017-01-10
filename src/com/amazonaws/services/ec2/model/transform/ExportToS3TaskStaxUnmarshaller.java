package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ExportToS3Task;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ExportToS3TaskStaxUnmarshaller implements Unmarshaller<ExportToS3Task, StaxUnmarshallerContext> {
    private static ExportToS3TaskStaxUnmarshaller instance;

    public static ExportToS3TaskStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ExportToS3TaskStaxUnmarshaller();
        }
        return instance;
    }

    public ExportToS3Task unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ExportToS3Task exportToS3Task = new ExportToS3Task();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return exportToS3Task;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("diskImageFormat", i)) {
                    exportToS3Task.setDiskImageFormat(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("containerFormat", i)) {
                    exportToS3Task.setContainerFormat(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("s3Bucket", i)) {
                    exportToS3Task.setS3Bucket(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("s3Key", i)) {
                    exportToS3Task.setS3Key(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return exportToS3Task;
            }
        }
    }
}
