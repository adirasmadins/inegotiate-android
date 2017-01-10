package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class RegionStaxUnmarshaller implements Unmarshaller<Region, StaxUnmarshallerContext> {
    private static RegionStaxUnmarshaller instance;

    public static RegionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RegionStaxUnmarshaller();
        }
        return instance;
    }

    public Region unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Region region = new Region();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return region;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("regionName", i)) {
                    region.setRegionName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("regionEndpoint", i)) {
                    region.setEndpoint(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return region;
            }
        }
    }
}
