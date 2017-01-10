package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.GetConsoleOutputResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class GetConsoleOutputResultStaxUnmarshaller implements Unmarshaller<GetConsoleOutputResult, StaxUnmarshallerContext> {
    private static GetConsoleOutputResultStaxUnmarshaller instance;

    public static GetConsoleOutputResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetConsoleOutputResultStaxUnmarshaller();
        }
        return instance;
    }

    public GetConsoleOutputResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetConsoleOutputResult getConsoleOutputResult = new GetConsoleOutputResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return getConsoleOutputResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    getConsoleOutputResult.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("timestamp", i)) {
                    getConsoleOutputResult.setTimestamp(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("output", i)) {
                    getConsoleOutputResult.setOutput(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return getConsoleOutputResult;
            }
        }
    }
}
