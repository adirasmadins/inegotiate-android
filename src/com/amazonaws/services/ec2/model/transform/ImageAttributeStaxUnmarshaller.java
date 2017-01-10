package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ImageAttribute;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ImageAttributeStaxUnmarshaller implements Unmarshaller<ImageAttribute, StaxUnmarshallerContext> {
    private static ImageAttributeStaxUnmarshaller instance;

    public static ImageAttributeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ImageAttributeStaxUnmarshaller();
        }
        return instance;
    }

    public ImageAttribute unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ImageAttribute imageAttribute = new ImageAttribute();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return imageAttribute;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("imageId", i)) {
                    imageAttribute.setImageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("launchPermission/item", i)) {
                    imageAttribute.getLaunchPermissions().add(LaunchPermissionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("productCodes/item", i)) {
                    imageAttribute.getProductCodes().add(ProductCodeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("kernel/value", i)) {
                    imageAttribute.setKernelId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ramdisk/value", i)) {
                    imageAttribute.setRamdiskId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("description/value", i)) {
                    imageAttribute.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("blockDeviceMapping/item", i)) {
                    imageAttribute.getBlockDeviceMappings().add(BlockDeviceMappingStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return imageAttribute;
            }
        }
    }
}
