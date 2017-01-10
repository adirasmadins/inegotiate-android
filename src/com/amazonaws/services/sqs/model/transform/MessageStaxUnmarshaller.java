package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.transform.MapEntry;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.Map.Entry;

public class MessageStaxUnmarshaller implements Unmarshaller<Message, StaxUnmarshallerContext> {
    private static MessageStaxUnmarshaller instance;

    private static class AttributesMapEntryUnmarshaller implements Unmarshaller<Entry<String, String>, StaxUnmarshallerContext> {
        private static AttributesMapEntryUnmarshaller instance;

        private AttributesMapEntryUnmarshaller() {
        }

        public static AttributesMapEntryUnmarshaller getInstance() {
            if (instance == null) {
                instance = new AttributesMapEntryUnmarshaller();
            }
            return instance;
        }

        public Entry<String, String> unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            int currentDepth = staxUnmarshallerContext.getCurrentDepth();
            int i = currentDepth + 1;
            MapEntry mapEntry = new MapEntry();
            while (true) {
                XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
                if (!nextEvent.isEndDocument()) {
                    if (!nextEvent.isAttribute() && !nextEvent.isStartElement()) {
                        if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                            break;
                        }
                    } else if (staxUnmarshallerContext.testExpression("Name", i)) {
                        mapEntry.setKey(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                    } else if (staxUnmarshallerContext.testExpression("Value", i)) {
                        mapEntry.setValue(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                    }
                } else {
                    break;
                }
            }
            return mapEntry;
        }
    }

    public static MessageStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new MessageStaxUnmarshaller();
        }
        return instance;
    }

    public Message unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Message message = new Message();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return message;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("MessageId", i)) {
                    message.setMessageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ReceiptHandle", i)) {
                    message.setReceiptHandle(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MD5OfBody", i)) {
                    message.setMD5OfBody(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Body", i)) {
                    message.setBody(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Attribute", i)) {
                    Entry unmarshall = AttributesMapEntryUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    message.getAttributes().put(unmarshall.getKey(), unmarshall.getValue());
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return message;
            }
        }
    }
}
