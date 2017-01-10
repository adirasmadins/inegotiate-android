package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonServiceException.ErrorType;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map.Entry;

public class JsonErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {
    private List<Unmarshaller<AmazonServiceException, JSONObject>> unmarshallerList;

    public JsonErrorResponseHandler(List<Unmarshaller<AmazonServiceException, JSONObject>> list) {
        this.unmarshallerList = list;
    }

    private String readStreamContents(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return stringBuilder.toString();
                }
                stringBuilder.append(readLine);
            }
        } catch (Throwable e) {
            try {
                inputStream.close();
            } catch (Exception e2) {
            }
            throw new AmazonClientException("Unable to read error response: " + e.getMessage(), e);
        }
    }

    public AmazonServiceException handle(HttpResponse httpResponse) throws Exception {
        AmazonServiceException runErrorUnmarshallers = runErrorUnmarshallers(httpResponse, new JSONObject(readStreamContents(httpResponse.getContent())));
        if (runErrorUnmarshallers == null) {
            return null;
        }
        runErrorUnmarshallers.setServiceName(httpResponse.getRequest().getServiceName());
        runErrorUnmarshallers.setStatusCode(httpResponse.getStatusCode());
        if (httpResponse.getStatusCode() < 500) {
            runErrorUnmarshallers.setErrorType(ErrorType.Client);
        } else {
            runErrorUnmarshallers.setErrorType(ErrorType.Service);
        }
        for (Entry entry : httpResponse.getHeaders().entrySet()) {
            if (((String) entry.getKey()).equalsIgnoreCase("X-Amzn-RequestId")) {
                runErrorUnmarshallers.setRequestId((String) entry.getValue());
            }
        }
        return runErrorUnmarshallers;
    }

    public boolean needsConnectionLeftOpen() {
        return false;
    }

    protected AmazonServiceException runErrorUnmarshallers(HttpResponse httpResponse, JSONObject jSONObject) throws Exception {
        for (Unmarshaller unmarshall : this.unmarshallerList) {
            AmazonServiceException amazonServiceException = (AmazonServiceException) unmarshall.unmarshall(jSONObject);
            if (amazonServiceException != null) {
                amazonServiceException.setStatusCode(httpResponse.getStatusCode());
                return amazonServiceException;
            }
        }
        return null;
    }
}
