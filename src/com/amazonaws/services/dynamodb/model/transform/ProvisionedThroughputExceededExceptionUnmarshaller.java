package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodb.model.ProvisionedThroughputExceededException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

public class ProvisionedThroughputExceededExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ProvisionedThroughputExceededExceptionUnmarshaller() {
        super(ProvisionedThroughputExceededException.class);
    }

    public AmazonServiceException unmarshall(JSONObject jSONObject) throws Exception {
        String parseErrorCode = parseErrorCode(jSONObject);
        return (parseErrorCode == null || !parseErrorCode.equals("ProvisionedThroughputExceededException")) ? null : (ProvisionedThroughputExceededException) super.unmarshall(jSONObject);
    }
}
