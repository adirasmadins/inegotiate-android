package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.ProvisionedThroughputDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class ProvisionedThroughputDescriptionJsonUnmarshaller implements Unmarshaller<ProvisionedThroughputDescription, JsonUnmarshallerContext> {
    private static ProvisionedThroughputDescriptionJsonUnmarshaller instance;

    public static ProvisionedThroughputDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ProvisionedThroughputDescriptionJsonUnmarshaller();
        }
        return instance;
    }

    public ProvisionedThroughputDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ProvisionedThroughputDescription provisionedThroughputDescription = new ProvisionedThroughputDescription();
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
            if (jsonUnmarshallerContext.testExpression("LastIncreaseDateTime", i)) {
                jsonUnmarshallerContext.nextToken();
                provisionedThroughputDescription.setLastIncreaseDateTime(DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("LastDecreaseDateTime", i)) {
                jsonUnmarshallerContext.nextToken();
                provisionedThroughputDescription.setLastDecreaseDateTime(DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("ReadCapacityUnits", i)) {
                jsonUnmarshallerContext.nextToken();
                provisionedThroughputDescription.setReadCapacityUnits(LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("WriteCapacityUnits", i)) {
                jsonUnmarshallerContext.nextToken();
                provisionedThroughputDescription.setWriteCapacityUnits(LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return provisionedThroughputDescription;
    }
}
