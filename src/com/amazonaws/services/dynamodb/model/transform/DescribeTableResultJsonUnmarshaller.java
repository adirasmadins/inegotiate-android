package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.DescribeTableResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class DescribeTableResultJsonUnmarshaller implements Unmarshaller<DescribeTableResult, JsonUnmarshallerContext> {
    private static DescribeTableResultJsonUnmarshaller instance;

    public static DescribeTableResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeTableResultJsonUnmarshaller();
        }
        return instance;
    }

    public DescribeTableResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeTableResult describeTableResult = new DescribeTableResult();
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
            } else if (jsonUnmarshallerContext.testExpression("Table", i)) {
                jsonUnmarshallerContext.nextToken();
                describeTableResult.setTable(TableDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return describeTableResult;
    }
}
