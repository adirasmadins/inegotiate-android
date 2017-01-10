package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.Key;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class KeyJsonUnmarshaller implements Unmarshaller<Key, JsonUnmarshallerContext> {
    private static KeyJsonUnmarshaller instance;

    public static KeyJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new KeyJsonUnmarshaller();
        }
        return instance;
    }

    public Key unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        Key key = new Key();
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
                key.setHashKeyElement(AttributeValueJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("RangeKeyElement", i)) {
                jsonUnmarshallerContext.nextToken();
                key.setRangeKeyElement(AttributeValueJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return key;
    }
}
