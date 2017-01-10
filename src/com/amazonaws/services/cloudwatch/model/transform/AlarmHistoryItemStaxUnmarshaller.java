package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.cloudwatch.model.AlarmHistoryItem;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AlarmHistoryItemStaxUnmarshaller implements Unmarshaller<AlarmHistoryItem, StaxUnmarshallerContext> {
    private static AlarmHistoryItemStaxUnmarshaller instance;

    public static AlarmHistoryItemStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AlarmHistoryItemStaxUnmarshaller();
        }
        return instance;
    }

    public AlarmHistoryItem unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AlarmHistoryItem alarmHistoryItem = new AlarmHistoryItem();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return alarmHistoryItem;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AlarmName", i)) {
                    alarmHistoryItem.setAlarmName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Timestamp", i)) {
                    alarmHistoryItem.setTimestamp(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("HistoryItemType", i)) {
                    alarmHistoryItem.setHistoryItemType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("HistorySummary", i)) {
                    alarmHistoryItem.setHistorySummary(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("HistoryData", i)) {
                    alarmHistoryItem.setHistoryData(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return alarmHistoryItem;
            }
        }
    }
}
