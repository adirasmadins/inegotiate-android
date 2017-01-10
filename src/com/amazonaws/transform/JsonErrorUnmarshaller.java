package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.util.json.JSONObject;
import com.google.gdata.util.common.base.StringUtil;

public class JsonErrorUnmarshaller extends AbstractErrorUnmarshaller<JSONObject> {
    protected JsonErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        super(cls);
    }

    public String parseErrorCode(JSONObject jSONObject) throws Exception {
        if (!jSONObject.has("__type")) {
            return null;
        }
        String string = jSONObject.getString("__type");
        return string.substring(string.lastIndexOf("#") + 1);
    }

    public String parseMessage(JSONObject jSONObject) throws Exception {
        return jSONObject.has("message") ? jSONObject.getString("message") : StringUtil.EMPTY_STRING;
    }

    public AmazonServiceException unmarshall(JSONObject jSONObject) throws Exception {
        AmazonServiceException newException = newException(parseMessage(jSONObject));
        newException.setErrorCode(parseErrorCode(jSONObject));
        return newException;
    }
}
