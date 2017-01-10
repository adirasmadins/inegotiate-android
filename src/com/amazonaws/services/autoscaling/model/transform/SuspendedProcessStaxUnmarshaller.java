package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.SuspendedProcess;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SuspendedProcessStaxUnmarshaller implements Unmarshaller<SuspendedProcess, StaxUnmarshallerContext> {
    private static SuspendedProcessStaxUnmarshaller instance;

    public static SuspendedProcessStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SuspendedProcessStaxUnmarshaller();
        }
        return instance;
    }

    public SuspendedProcess unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SuspendedProcess suspendedProcess = new SuspendedProcess();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return suspendedProcess;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("ProcessName", i)) {
                    suspendedProcess.setProcessName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("SuspensionReason", i)) {
                    suspendedProcess.setSuspensionReason(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return suspendedProcess;
            }
        }
    }
}
