package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribePlacementGroupsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribePlacementGroupsResultStaxUnmarshaller implements Unmarshaller<DescribePlacementGroupsResult, StaxUnmarshallerContext> {
    private static DescribePlacementGroupsResultStaxUnmarshaller instance;

    public static DescribePlacementGroupsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribePlacementGroupsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribePlacementGroupsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribePlacementGroupsResult describePlacementGroupsResult = new DescribePlacementGroupsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describePlacementGroupsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("placementGroupSet/item", i)) {
                    describePlacementGroupsResult.getPlacementGroups().add(PlacementGroupStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describePlacementGroupsResult;
            }
        }
    }
}
