package com.amazonaws.services.sns.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ListTopicsResultStaxUnmarshaller implements Unmarshaller<ListTopicsResult, StaxUnmarshallerContext> {
    private static ListTopicsResultStaxUnmarshaller instance;

    public static ListTopicsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListTopicsResultStaxUnmarshaller();
        }
        return instance;
    }

    public ListTopicsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ListTopicsResult listTopicsResult = new ListTopicsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return listTopicsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Topics/member", i)) {
                    listTopicsResult.getTopics().add(TopicStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    listTopicsResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return listTopicsResult;
            }
        }
    }
}
