package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.model.ProgressEvent;
import java.io.InputStream;

public class S3StringResponseHandler extends AbstractS3ResponseHandler<String> {
    public AmazonWebServiceResponse<String> handle(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<String> parseResponseMetadata = parseResponseMetadata(httpResponse);
        byte[] bArr = new byte[ProgressEvent.PART_STARTED_EVENT_CODE];
        StringBuilder stringBuilder = new StringBuilder();
        InputStream content = httpResponse.getContent();
        while (true) {
            int read = content.read(bArr);
            if (read > 0) {
                stringBuilder.append(new String(bArr, 0, read));
            } else {
                parseResponseMetadata.setResult(stringBuilder.toString());
                return parseResponseMetadata;
            }
        }
    }
}
