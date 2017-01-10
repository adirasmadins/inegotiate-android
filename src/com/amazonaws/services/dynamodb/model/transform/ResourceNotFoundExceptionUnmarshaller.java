package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodb.model.ResourceNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

public class ResourceNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ResourceNotFoundExceptionUnmarshaller() {
        super(ResourceNotFoundException.class);
    }

    public AmazonServiceException unmarshall(JSONObject jSONObject) throws Exception {
        String parseErrorCode = parseErrorCode(jSONObject);
        return (parseErrorCode == null || !parseErrorCode.equals("ResourceNotFoundException")) ? null : (ResourceNotFoundException) super.unmarshall(jSONObject);
    }
}
