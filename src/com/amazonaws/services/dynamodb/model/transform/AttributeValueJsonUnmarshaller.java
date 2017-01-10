package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.AttributeValue;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class AttributeValueJsonUnmarshaller implements Unmarshaller<AttributeValue, JsonUnmarshallerContext> {
    private static AttributeValueJsonUnmarshaller instance;

    public static AttributeValueJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AttributeValueJsonUnmarshaller();
        }
        return instance;
    }

    public AttributeValue unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AttributeValue attributeValue = new AttributeValue();
        int currentDepth = jsonUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        JsonToken jsonToken = jsonUnmarshallerContext.currentToken;
        if (jsonToken == null) {
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        while (jsonToken != null) {
            if (jsonToken != JsonToken.FIELD_NAME && jsonToken != JsonToken.START_OBJECT) {
                if ((jsonToken == JsonToken.END_ARRAY || jsonToken == JsonToken.END_OBJECT) && jsonUnmarshallerContext.getCurrentDepth() <= currentDepth) {
                    break;
                }
            }
            if (jsonUnmarshallerContext.testExpression("S", i)) {
                jsonUnmarshallerContext.nextToken();
                attributeValue.setS(StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("N", i)) {
                jsonUnmarshallerContext.nextToken();
                attributeValue.setN(StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("B", i)) {
                jsonUnmarshallerContext.nextToken();
                attributeValue.setB(ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("SS", i)) {
                attributeValue.setSS(new ListUnmarshaller(StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("NS", i)) {
                attributeValue.setNS(new ListUnmarshaller(StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("BS", i)) {
                attributeValue.setBS(new ListUnmarshaller(ByteBufferJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return attributeValue;
    }
}
