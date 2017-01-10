package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.CertificateNotFoundException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class CertificateNotFoundExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public CertificateNotFoundExceptionUnmarshaller() {
        super(CertificateNotFoundException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("CertificateNotFound")) ? null : (CertificateNotFoundException) super.unmarshall(node);
    }
}
