package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.GetSendStatisticsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class GetSendStatisticsResultStaxUnmarshaller implements Unmarshaller<GetSendStatisticsResult, StaxUnmarshallerContext> {
    private static GetSendStatisticsResultStaxUnmarshaller instance;

    public static GetSendStatisticsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetSendStatisticsResultStaxUnmarshaller();
        }
        return instance;
    }

    public GetSendStatisticsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetSendStatisticsResult getSendStatisticsResult = new GetSendStatisticsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return getSendStatisticsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("SendDataPoints/member", i)) {
                    getSendStatisticsResult.getSendDataPoints().add(SendDataPointStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return getSendStatisticsResult;
            }
        }
    }
}
