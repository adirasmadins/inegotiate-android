package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.ProcessType;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ProcessTypeStaxUnmarshaller implements Unmarshaller<ProcessType, StaxUnmarshallerContext> {
    private static ProcessTypeStaxUnmarshaller instance;

    public static ProcessTypeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ProcessTypeStaxUnmarshaller();
        }
        return instance;
    }

    public ProcessType unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ProcessType processType = new ProcessType();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return processType;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("ProcessName", i)) {
                    processType.setProcessName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return processType;
            }
        }
    }
}
