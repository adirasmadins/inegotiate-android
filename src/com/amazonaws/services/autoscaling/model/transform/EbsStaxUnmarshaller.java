package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.Ebs;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class EbsStaxUnmarshaller implements Unmarshaller<Ebs, StaxUnmarshallerContext> {
    private static EbsStaxUnmarshaller instance;

    public static EbsStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new EbsStaxUnmarshaller();
        }
        return instance;
    }

    public Ebs unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Ebs ebs = new Ebs();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return ebs;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("SnapshotId", i)) {
                    ebs.setSnapshotId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("VolumeSize", i)) {
                    ebs.setVolumeSize(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return ebs;
            }
        }
    }
}
