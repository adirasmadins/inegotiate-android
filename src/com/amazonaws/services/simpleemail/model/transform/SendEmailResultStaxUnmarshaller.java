package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SendEmailResultStaxUnmarshaller implements Unmarshaller<SendEmailResult, StaxUnmarshallerContext> {
    private static SendEmailResultStaxUnmarshaller instance;

    public static SendEmailResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SendEmailResultStaxUnmarshaller();
        }
        return instance;
    }

    public SendEmailResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SendEmailResult sendEmailResult = new SendEmailResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return sendEmailResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("MessageId", i)) {
                    sendEmailResult.setMessageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return sendEmailResult;
            }
        }
    }
}
