package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodb.model.LimitExceededException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

public class LimitExceededExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public LimitExceededExceptionUnmarshaller() {
        super(LimitExceededException.class);
    }

    public AmazonServiceException unmarshall(JSONObject jSONObject) throws Exception {
        String parseErrorCode = parseErrorCode(jSONObject);
        return (parseErrorCode == null || !parseErrorCode.equals("LimitExceededException")) ? null : (LimitExceededException) super.unmarshall(jSONObject);
    }
}
