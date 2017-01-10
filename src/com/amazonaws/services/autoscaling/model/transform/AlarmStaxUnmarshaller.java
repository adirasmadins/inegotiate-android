package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.Alarm;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AlarmStaxUnmarshaller implements Unmarshaller<Alarm, StaxUnmarshallerContext> {
    private static AlarmStaxUnmarshaller instance;

    public static AlarmStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AlarmStaxUnmarshaller();
        }
        return instance;
    }

    public Alarm unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Alarm alarm = new Alarm();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return alarm;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AlarmName", i)) {
                    alarm.setAlarmName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AlarmARN", i)) {
                    alarm.setAlarmARN(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return alarm;
            }
        }
    }
}
