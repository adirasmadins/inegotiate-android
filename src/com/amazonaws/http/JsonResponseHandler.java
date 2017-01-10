package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.transform.VoidJsonUnmarshaller;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;

public class JsonResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {
    private static JsonFactory jsonFactory;
    private static final Log log;
    public boolean needsConnectionLeftOpen;
    private Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller;

    static {
        log = LogFactory.getLog("com.amazonaws.request");
        jsonFactory = new JsonFactory();
    }

    public JsonResponseHandler(Unmarshaller<T, JsonUnmarshallerContext> unmarshaller) {
        this.needsConnectionLeftOpen = false;
        this.responseUnmarshaller = unmarshaller;
        if (this.responseUnmarshaller == null) {
            this.responseUnmarshaller = new VoidJsonUnmarshaller();
        }
    }

    public AmazonWebServiceResponse<T> handle(HttpResponse httpResponse) throws Exception {
        log.trace("Parsing service response JSON");
        JsonParser createJsonParser = !this.needsConnectionLeftOpen ? jsonFactory.createJsonParser(httpResponse.getContent()) : null;
        try {
            AmazonWebServiceResponse<T> amazonWebServiceResponse = new AmazonWebServiceResponse();
            JsonUnmarshallerContext jsonUnmarshallerContext = new JsonUnmarshallerContext(createJsonParser, httpResponse);
            registerAdditionalMetadataExpressions(jsonUnmarshallerContext);
            amazonWebServiceResponse.setResult(this.responseUnmarshaller.unmarshall(jsonUnmarshallerContext));
            Map metadata = jsonUnmarshallerContext.getMetadata();
            metadata.put(ResponseMetadata.AWS_REQUEST_ID, httpResponse.getHeaders().get("x-amzn-RequestId"));
            amazonWebServiceResponse.setResponseMetadata(new ResponseMetadata(metadata));
            log.trace("Done parsing service response");
            if (!this.needsConnectionLeftOpen) {
                try {
                    createJsonParser.close();
                } catch (Exception e) {
                }
            }
            return amazonWebServiceResponse;
        } catch (Throwable th) {
            if (!this.needsConnectionLeftOpen) {
                try {
                    createJsonParser.close();
                } catch (Exception e2) {
                }
            }
        }
    }

    public boolean needsConnectionLeftOpen() {
        return this.needsConnectionLeftOpen;
    }

    protected void registerAdditionalMetadataExpressions(JsonUnmarshallerContext jsonUnmarshallerContext) {
    }
}
