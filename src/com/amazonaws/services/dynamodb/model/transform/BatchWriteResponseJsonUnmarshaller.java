package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.BatchWriteResponse;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class BatchWriteResponseJsonUnmarshaller implements Unmarshaller<BatchWriteResponse, JsonUnmarshallerContext> {
    private static BatchWriteResponseJsonUnmarshaller instance;

    public static BatchWriteResponseJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BatchWriteResponseJsonUnmarshaller();
        }
        return instance;
    }

    public BatchWriteResponse unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        BatchWriteResponse batchWriteResponse = new BatchWriteResponse();
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
            } else if (jsonUnmarshallerContext.testExpression("ConsumedCapacityUnits", i)) {
                jsonUnmarshallerContext.nextToken();
                batchWriteResponse.setConsumedCapacityUnits(DoubleJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return batchWriteResponse;
    }
}
