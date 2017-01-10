package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.javax.xml.stream.XMLEventReader;
import com.amazonaws.javax.xml.stream.XMLInputFactory;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.transform.VoidStaxUnmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StaxResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {
    private static final Log log;
    private static XMLInputFactory xmlInputFactory;
    private Unmarshaller<T, StaxUnmarshallerContext> responseUnmarshaller;

    static {
        log = LogFactory.getLog("com.amazonaws.request");
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    public StaxResponseHandler(Unmarshaller<T, StaxUnmarshallerContext> unmarshaller) {
        this.responseUnmarshaller = unmarshaller;
        if (this.responseUnmarshaller == null) {
            this.responseUnmarshaller = new VoidStaxUnmarshaller();
        }
    }

    public AmazonWebServiceResponse<T> handle(HttpResponse httpResponse) throws Exception {
        log.trace("Parsing service response XML");
        InputStream content = httpResponse.getContent();
        if (content == null) {
            content = new ByteArrayInputStream("<eof/>".getBytes());
        }
        XMLEventReader createXMLEventReader = xmlInputFactory.createXMLEventReader(content);
        try {
            AmazonWebServiceResponse<T> amazonWebServiceResponse = new AmazonWebServiceResponse();
            StaxUnmarshallerContext staxUnmarshallerContext = new StaxUnmarshallerContext(createXMLEventReader, httpResponse.getHeaders());
            staxUnmarshallerContext.registerMetadataExpression("ResponseMetadata/RequestId", 2, ResponseMetadata.AWS_REQUEST_ID);
            staxUnmarshallerContext.registerMetadataExpression("requestId", 2, ResponseMetadata.AWS_REQUEST_ID);
            registerAdditionalMetadataExpressions(staxUnmarshallerContext);
            amazonWebServiceResponse.setResult(this.responseUnmarshaller.unmarshall(staxUnmarshallerContext));
            amazonWebServiceResponse.setResponseMetadata(new ResponseMetadata(staxUnmarshallerContext.getMetadata()));
            log.trace("Done parsing service response");
            return amazonWebServiceResponse;
        } finally {
            try {
                createXMLEventReader.close();
            } catch (Exception e) {
            }
        }
    }

    public boolean needsConnectionLeftOpen() {
        return false;
    }

    protected void registerAdditionalMetadataExpressions(StaxUnmarshallerContext staxUnmarshallerContext) {
    }
}
