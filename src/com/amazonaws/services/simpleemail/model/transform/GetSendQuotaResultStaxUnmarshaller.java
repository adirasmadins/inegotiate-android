package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.GetSendQuotaResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class GetSendQuotaResultStaxUnmarshaller implements Unmarshaller<GetSendQuotaResult, StaxUnmarshallerContext> {
    private static GetSendQuotaResultStaxUnmarshaller instance;

    public static GetSendQuotaResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetSendQuotaResultStaxUnmarshaller();
        }
        return instance;
    }

    public GetSendQuotaResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetSendQuotaResult getSendQuotaResult = new GetSendQuotaResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return getSendQuotaResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Max24HourSend", i)) {
                    getSendQuotaResult.setMax24HourSend(DoubleStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MaxSendRate", i)) {
                    getSendQuotaResult.setMaxSendRate(DoubleStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("SentLast24Hours", i)) {
                    getSendQuotaResult.setSentLast24Hours(DoubleStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return getSendQuotaResult;
            }
        }
    }
}
