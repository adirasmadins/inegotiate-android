package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.BatchWriteItemResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class BatchWriteItemResultJsonUnmarshaller implements Unmarshaller<BatchWriteItemResult, JsonUnmarshallerContext> {
    private static BatchWriteItemResultJsonUnmarshaller instance;

    public static BatchWriteItemResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BatchWriteItemResultJsonUnmarshaller();
        }
        return instance;
    }

    public BatchWriteItemResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        BatchWriteItemResult batchWriteItemResult = new BatchWriteItemResult();
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
            if (jsonUnmarshallerContext.testExpression("Responses", i)) {
                batchWriteItemResult.setResponses(new MapUnmarshaller(StringJsonUnmarshaller.getInstance(), BatchWriteResponseJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("UnprocessedItems", i)) {
                batchWriteItemResult.setUnprocessedItems(new MapUnmarshaller(StringJsonUnmarshaller.getInstance(), new ListUnmarshaller(WriteRequestJsonUnmarshaller.getInstance())).unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return batchWriteItemResult;
    }
}
