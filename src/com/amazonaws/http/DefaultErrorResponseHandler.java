package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.XpathUtils;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class DefaultErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {
    private List<Unmarshaller<AmazonServiceException, Node>> unmarshallerList;

    public DefaultErrorResponseHandler(List<Unmarshaller<AmazonServiceException, Node>> list) {
        this.unmarshallerList = list;
    }

    public AmazonServiceException handle(HttpResponse httpResponse) throws Exception {
        Document documentFrom = XpathUtils.documentFrom(httpResponse.getContent());
        for (Unmarshaller unmarshall : this.unmarshallerList) {
            AmazonServiceException amazonServiceException = (AmazonServiceException) unmarshall.unmarshall(documentFrom);
            if (amazonServiceException != null) {
                amazonServiceException.setStatusCode(httpResponse.getStatusCode());
                return amazonServiceException;
            }
        }
        throw new AmazonClientException("Unable to unmarshall error response from service");
    }

    public boolean needsConnectionLeftOpen() {
        return false;
    }
}
