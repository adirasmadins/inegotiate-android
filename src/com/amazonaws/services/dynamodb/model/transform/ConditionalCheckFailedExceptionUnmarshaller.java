package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodb.model.ConditionalCheckFailedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

public class ConditionalCheckFailedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ConditionalCheckFailedExceptionUnmarshaller() {
        super(ConditionalCheckFailedException.class);
    }

    public AmazonServiceException unmarshall(JSONObject jSONObject) throws Exception {
        String parseErrorCode = parseErrorCode(jSONObject);
        return (parseErrorCode == null || !parseErrorCode.equals("ConditionalCheckFailedException")) ? null : (ConditionalCheckFailedException) super.unmarshall(jSONObject);
    }
}
