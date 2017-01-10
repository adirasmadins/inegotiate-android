package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.GetItemResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class GetItemResultJsonUnmarshaller implements Unmarshaller<GetItemResult, JsonUnmarshallerContext> {
    private static GetItemResultJsonUnmarshaller instance;

    public static GetItemResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetItemResultJsonUnmarshaller();
        }
        return instance;
    }

    public GetItemResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetItemResult getItemResult = new GetItemResult();
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
            if (jsonUnmarshallerContext.testExpression("Item", i)) {
                getItemResult.setItem(new MapUnmarshaller(StringJsonUnmarshaller.getInstance(), AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("ConsumedCapacityUnits", i)) {
                jsonUnmarshallerContext.nextToken();
                getItemResult.setConsumedCapacityUnits(DoubleJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return getItemResult;
    }
}
