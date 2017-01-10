package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.KeySchemaElement;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class KeySchemaElementJsonUnmarshaller implements Unmarshaller<KeySchemaElement, JsonUnmarshallerContext> {
    private static KeySchemaElementJsonUnmarshaller instance;

    public static KeySchemaElementJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new KeySchemaElementJsonUnmarshaller();
        }
        return instance;
    }

    public KeySchemaElement unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        KeySchemaElement keySchemaElement = new KeySchemaElement();
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
            if (jsonUnmarshallerContext.testExpression("AttributeName", i)) {
                jsonUnmarshallerContext.nextToken();
                keySchemaElement.setAttributeName(StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("AttributeType", i)) {
                jsonUnmarshallerContext.nextToken();
                keySchemaElement.setAttributeType(StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return keySchemaElement;
    }
}
