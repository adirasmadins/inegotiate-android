package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.PutRequest;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class PutRequestJsonUnmarshaller implements Unmarshaller<PutRequest, JsonUnmarshallerContext> {
    private static PutRequestJsonUnmarshaller instance;

    public static PutRequestJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PutRequestJsonUnmarshaller();
        }
        return instance;
    }

    public PutRequest unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        PutRequest putRequest = new PutRequest();
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
            } else if (jsonUnmarshallerContext.testExpression("Item", i)) {
                putRequest.setItem(new MapUnmarshaller(StringJsonUnmarshaller.getInstance(), AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return putRequest;
    }
}
