package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.KeySchema;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class KeySchemaJsonUnmarshaller implements Unmarshaller<KeySchema, JsonUnmarshallerContext> {
    private static KeySchemaJsonUnmarshaller instance;

    public static KeySchemaJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new KeySchemaJsonUnmarshaller();
        }
        return instance;
    }

    public KeySchema unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        KeySchema keySchema = new KeySchema();
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
            if (jsonUnmarshallerContext.testExpression("HashKeyElement", i)) {
                jsonUnmarshallerContext.nextToken();
                keySchema.setHashKeyElement(KeySchemaElementJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("RangeKeyElement", i)) {
                jsonUnmarshallerContext.nextToken();
                keySchema.setRangeKeyElement(KeySchemaElementJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return keySchema;
    }
}
