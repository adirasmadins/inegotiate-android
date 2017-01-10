package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.DeleteItemResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class DeleteItemResultJsonUnmarshaller implements Unmarshaller<DeleteItemResult, JsonUnmarshallerContext> {
    private static DeleteItemResultJsonUnmarshaller instance;

    public static DeleteItemResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteItemResultJsonUnmarshaller();
        }
        return instance;
    }

    public DeleteItemResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DeleteItemResult deleteItemResult = new DeleteItemResult();
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
                deleteItemResult.setAttributes(new MapUnmarshaller(StringJsonUnmarshaller.getInstance(), AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("ConsumedCapacityUnits", i)) {
                jsonUnmarshallerContext.nextToken();
                deleteItemResult.setConsumedCapacityUnits(DoubleJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return deleteItemResult;
    }
}
