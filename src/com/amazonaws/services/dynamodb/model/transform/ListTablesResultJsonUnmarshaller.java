package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.ListTablesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class ListTablesResultJsonUnmarshaller implements Unmarshaller<ListTablesResult, JsonUnmarshallerContext> {
    private static ListTablesResultJsonUnmarshaller instance;

    public static ListTablesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListTablesResultJsonUnmarshaller();
        }
        return instance;
    }

    public ListTablesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListTablesResult listTablesResult = new ListTablesResult();
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
            if (jsonUnmarshallerContext.testExpression("TableNames", i)) {
                listTablesResult.setTableNames(new ListUnmarshaller(StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("LastEvaluatedTableName", i)) {
                jsonUnmarshallerContext.nextToken();
                listTablesResult.setLastEvaluatedTableName(StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return listTablesResult;
    }
}
