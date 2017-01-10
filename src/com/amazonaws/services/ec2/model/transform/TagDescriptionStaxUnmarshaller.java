package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.TagDescription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class TagDescriptionStaxUnmarshaller implements Unmarshaller<TagDescription, StaxUnmarshallerContext> {
    private static TagDescriptionStaxUnmarshaller instance;

    public static TagDescriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TagDescriptionStaxUnmarshaller();
        }
        return instance;
    }

    public TagDescription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        TagDescription tagDescription = new TagDescription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return tagDescription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("resourceId", i)) {
                    tagDescription.setResourceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("resourceType", i)) {
                    tagDescription.setResourceType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("key", i)) {
                    tagDescription.setKey(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("value", i)) {
                    tagDescription.setValue(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return tagDescription;
            }
        }
    }
}
