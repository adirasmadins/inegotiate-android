package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.DeleteRequest;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class DeleteRequestJsonUnmarshaller implements Unmarshaller<DeleteRequest, JsonUnmarshallerContext> {
    private static DeleteRequestJsonUnmarshaller instance;

    public static DeleteRequestJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteRequestJsonUnmarshaller();
        }
        return instance;
    }

    public DeleteRequest unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DeleteRequest deleteRequest = new DeleteRequest();
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
            } else if (jsonUnmarshallerContext.testExpression("Key", i)) {
                jsonUnmarshallerContext.nextToken();
                deleteRequest.setKey(KeyJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return deleteRequest;
    }
}
