package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.SpotPlacement;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SpotPlacementStaxUnmarshaller implements Unmarshaller<SpotPlacement, StaxUnmarshallerContext> {
    private static SpotPlacementStaxUnmarshaller instance;

    public static SpotPlacementStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SpotPlacementStaxUnmarshaller();
        }
        return instance;
    }

    public SpotPlacement unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SpotPlacement spotPlacement = new SpotPlacement();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return spotPlacement;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("availabilityZone", i)) {
                    spotPlacement.setAvailabilityZone(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupName", i)) {
                    spotPlacement.setGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return spotPlacement;
            }
        }
    }
}
