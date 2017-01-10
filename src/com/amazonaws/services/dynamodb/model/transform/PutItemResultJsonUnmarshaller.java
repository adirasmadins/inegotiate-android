package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.PutItemResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class PutItemResultJsonUnmarshaller implements Unmarshaller<PutItemResult, JsonUnmarshallerContext> {
    private static PutItemResultJsonUnmarshaller instance;

    public static PutItemResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PutItemResultJsonUnmarshaller();
        }
        return instance;
    }

    public PutItemResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        PutItemResult putItemResult = new PutItemResult();
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
            if (jsonUnmarshallerContext.testExpression("Attributes", i)) {
                putItemResult.setAttributes(new MapUnmarshaller(StringJsonUnmarshaller.getInstance(), AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("ConsumedCapacityUnits", i)) {
                jsonUnmarshallerContext.nextToken();
                putItemResult.setConsumedCapacityUnits(DoubleJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return putItemResult;
    }
}
