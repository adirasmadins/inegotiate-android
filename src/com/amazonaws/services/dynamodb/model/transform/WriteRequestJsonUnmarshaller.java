package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.WriteRequest;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class WriteRequestJsonUnmarshaller implements Unmarshaller<WriteRequest, JsonUnmarshallerContext> {
    private static WriteRequestJsonUnmarshaller instance;

    public static WriteRequestJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new WriteRequestJsonUnmarshaller();
        }
        return instance;
    }

    public WriteRequest unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        WriteRequest writeRequest = new WriteRequest();
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
            if (jsonUnmarshallerContext.testExpression("PutRequest", i)) {
                jsonUnmarshallerContext.nextToken();
                writeRequest.setPutRequest(PutRequestJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("DeleteRequest", i)) {
                jsonUnmarshallerContext.nextToken();
                writeRequest.setDeleteRequest(DeleteRequestJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return writeRequest;
    }
}
