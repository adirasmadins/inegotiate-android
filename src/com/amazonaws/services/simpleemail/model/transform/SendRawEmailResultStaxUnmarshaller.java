package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.SendRawEmailResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SendRawEmailResultStaxUnmarshaller implements Unmarshaller<SendRawEmailResult, StaxUnmarshallerContext> {
    private static SendRawEmailResultStaxUnmarshaller instance;

    public static SendRawEmailResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SendRawEmailResultStaxUnmarshaller();
        }
        return instance;
    }

    public SendRawEmailResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SendRawEmailResult sendRawEmailResult = new SendRawEmailResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return sendRawEmailResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("MessageId", i)) {
                    sendRawEmailResult.setMessageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return sendRawEmailResult;
            }
        }
    }
}
