package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.BatchResponse;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class BatchResponseJsonUnmarshaller implements Unmarshaller<BatchResponse, JsonUnmarshallerContext> {
    private static BatchResponseJsonUnmarshaller instance;

    public static BatchResponseJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BatchResponseJsonUnmarshaller();
        }
        return instance;
    }

    public BatchResponse unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        BatchResponse batchResponse = new BatchResponse();
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
            if (jsonUnmarshallerContext.testExpression("Items", i)) {
                batchResponse.setItems(new ListUnmarshaller(new MapUnmarshaller(StringJsonUnmarshaller.getInstance(), AttributeValueJsonUnmarshaller.getInstance())).unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("ConsumedCapacityUnits", i)) {
                jsonUnmarshallerContext.nextToken();
                batchResponse.setConsumedCapacityUnits(DoubleJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return batchResponse;
    }
}
