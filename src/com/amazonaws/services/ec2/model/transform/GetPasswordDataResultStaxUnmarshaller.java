package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.GetPasswordDataResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class GetPasswordDataResultStaxUnmarshaller implements Unmarshaller<GetPasswordDataResult, StaxUnmarshallerContext> {
    private static GetPasswordDataResultStaxUnmarshaller instance;

    public static GetPasswordDataResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetPasswordDataResultStaxUnmarshaller();
        }
        return instance;
    }

    public GetPasswordDataResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetPasswordDataResult getPasswordDataResult = new GetPasswordDataResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return getPasswordDataResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instanceId", i)) {
                    getPasswordDataResult.setInstanceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("timestamp", i)) {
                    getPasswordDataResult.setTimestamp(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("passwordData", i)) {
                    getPasswordDataResult.setPasswordData(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return getPasswordDataResult;
            }
        }
    }
}
