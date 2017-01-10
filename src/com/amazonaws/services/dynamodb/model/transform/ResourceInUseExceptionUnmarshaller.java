package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodb.model.ResourceInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

public class ResourceInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ResourceInUseExceptionUnmarshaller() {
        super(ResourceInUseException.class);
    }

    public AmazonServiceException unmarshall(JSONObject jSONObject) throws Exception {
        String parseErrorCode = parseErrorCode(jSONObject);
        return (parseErrorCode == null || !parseErrorCode.equals("ResourceInUseException")) ? null : (ResourceInUseException) super.unmarshall(jSONObject);
    }
}
