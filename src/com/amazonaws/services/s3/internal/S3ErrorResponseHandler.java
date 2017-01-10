package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonServiceException.ErrorType;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class S3ErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {
    private void fillInErrorType(AmazonServiceException amazonServiceException, HttpResponse httpResponse) {
        if (httpResponse.getStatusCode() >= 500) {
            amazonServiceException.setErrorType(ErrorType.Service);
        } else {
            amazonServiceException.setErrorType(ErrorType.Client);
        }
    }

    public AmazonServiceException handle(HttpResponse httpResponse) throws Exception {
        if (httpResponse.getContent() == null || httpResponse.getRequest().getHttpMethod() == HttpMethodName.HEAD) {
            String str = (String) httpResponse.getHeaders().get(Headers.REQUEST_ID);
            String str2 = (String) httpResponse.getHeaders().get(Headers.EXTENDED_REQUEST_ID);
            AmazonServiceException amazonS3Exception = new AmazonS3Exception(httpResponse.getStatusText());
            amazonS3Exception.setStatusCode(httpResponse.getStatusCode());
            amazonS3Exception.setRequestId(str);
            amazonS3Exception.setExtendedRequestId(str2);
            fillInErrorType(amazonS3Exception, httpResponse);
            return amazonS3Exception;
        }
        Node documentFrom = XpathUtils.documentFrom(httpResponse.getContent());
        str2 = XpathUtils.asString("Error/Message", documentFrom);
        String asString = XpathUtils.asString("Error/Code", documentFrom);
        String asString2 = XpathUtils.asString("Error/RequestId", documentFrom);
        String asString3 = XpathUtils.asString("Error/HostId", documentFrom);
        AmazonServiceException amazonS3Exception2 = new AmazonS3Exception(str2);
        amazonS3Exception2.setStatusCode(httpResponse.getStatusCode());
        amazonS3Exception2.setErrorCode(asString);
        amazonS3Exception2.setRequestId(asString2);
        amazonS3Exception2.setExtendedRequestId(asString3);
        fillInErrorType(amazonS3Exception2, httpResponse);
        return amazonS3Exception2;
    }

    public boolean needsConnectionLeftOpen() {
        return false;
    }
}
