package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.services.dynamodb.model.TableDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import org.codehaus.jackson.JsonToken;

public class TableDescriptionJsonUnmarshaller implements Unmarshaller<TableDescription, JsonUnmarshallerContext> {
    private static TableDescriptionJsonUnmarshaller instance;

    public static TableDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TableDescriptionJsonUnmarshaller();
        }
        return instance;
    }

    public TableDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        TableDescription tableDescription = new TableDescription();
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
            if (jsonUnmarshallerContext.testExpression("TableName", i)) {
                jsonUnmarshallerContext.nextToken();
                tableDescription.setTableName(StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("KeySchema", i)) {
                jsonUnmarshallerContext.nextToken();
                tableDescription.setKeySchema(KeySchemaJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("TableStatus", i)) {
                jsonUnmarshallerContext.nextToken();
                tableDescription.setTableStatus(StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("CreationDateTime", i)) {
                jsonUnmarshallerContext.nextToken();
                tableDescription.setCreationDateTime(DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("ProvisionedThroughput", i)) {
                jsonUnmarshallerContext.nextToken();
                tableDescription.setProvisionedThroughput(ProvisionedThroughputDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("TableSizeBytes", i)) {
                jsonUnmarshallerContext.nextToken();
                tableDescription.setTableSizeBytes(LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            if (jsonUnmarshallerContext.testExpression("ItemCount", i)) {
                jsonUnmarshallerContext.nextToken();
                tableDescription.setItemCount(LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            }
            jsonToken = jsonUnmarshallerContext.nextToken();
        }
        return tableDescription;
    }
}
