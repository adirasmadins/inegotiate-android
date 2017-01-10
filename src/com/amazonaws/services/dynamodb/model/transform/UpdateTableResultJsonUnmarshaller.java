package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.UpdateTableResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class UpdateTableResultJsonUnmarshaller implements Unmarshaller<UpdateTableResult, JsonUnmarshallerContext> {
    private static UpdateTableResultJsonUnmarshaller instance;

    public static UpdateTableResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateTableResultJsonUnmarshaller();
        }
        return instance;
    }

    public UpdateTableResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateTableResult updateTableResult = new UpdateTableResult();
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
            } else if (jsonUnmarshallerContext.testExpression("TableDescription", i)) {
                jsonUnmarshallerContext.nextToken();
                updateTableResult.setTableDescription(TableDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return updateTableResult;
    }
}
