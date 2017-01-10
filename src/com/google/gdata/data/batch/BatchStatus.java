package com.google.gdata.data.batch;

import com.doviknissim.inegotiate.app.DBAdapter;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class BatchStatus extends ExtensionPoint implements Extension, IBatchStatus {
    private int code;
    private String content;
    private ContentType contentType;
    private String reason;

    private class BatchStatusElementHandler extends ExtensionHandler {
        private BatchStatusElementHandler(ExtensionProfile extProfile, Attributes attrs) throws ParseException {
            super(BatchStatus.this, extProfile, BatchStatus.class);
            String code = attrs.getValue("code");
            if (code != null) {
                try {
                    BatchStatus.this.setCode(Integer.parseInt(code));
                } catch (Throwable e) {
                    ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidIntegerAttribute, e);
                    pe.setInternalReason("Invalid integer value for code attribute : '" + code + "'");
                    throw pe;
                }
            }
            String reason = attrs.getValue("reason");
            if (reason != null) {
                BatchStatus.this.setReason(reason);
            }
            String contentType = attrs.getValue("content-type");
            if (contentType != null) {
                try {
                    BatchStatus.this.setContentType(new ContentType(contentType));
                } catch (Throwable e2) {
                    pe = new ParseException(CoreErrorDomain.ERR.invalidContentType, e2);
                    pe.setInternalReason("Invalid content type: " + contentType);
                    throw pe;
                }
            }
        }

        public void processEndElement() {
            if (this.value != null) {
                BatchStatus.this.setContent(this.value);
            }
        }
    }

    public BatchStatus(ServiceException e) {
        this.code = e.getHttpErrorCodeOverride();
        if (this.code == -1) {
            this.code = 500;
        }
        this.reason = e.getMessage();
        this.contentType = e.getResponseContentType();
        this.content = e.getResponseBody();
    }

    public static BatchStatus createSuccessStatus() {
        BatchStatus retval = new BatchStatus();
        retval.setCode(200);
        retval.setReason("Success");
        return retval;
    }

    public static BatchStatus createCreatedStatus() {
        BatchStatus retval = new BatchStatus();
        retval.setCode(201);
        retval.setReason("Created");
        return retval;
    }

    public static ExtensionDescription getDefaultDescription() {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(BatchStatus.class);
        desc.setNamespace(Namespaces.batchNs);
        desc.setLocalName(DBAdapter.STATUS);
        desc.setRepeatable(false);
        return desc;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        List<Attribute> attributes = new ArrayList(4);
        if (this.code > 0) {
            attributes.add(new Attribute("code", Integer.toString(this.code)));
        }
        if (this.reason != null) {
            attributes.add(new Attribute("reason", this.reason));
        }
        if (this.contentType != null) {
            this.contentType.getAttributes().remove(ContentType.ATTR_CHARSET);
            attributes.add(new Attribute("content-type", this.contentType.toString()));
        }
        generateStartElement(w, Namespaces.batchNs, DBAdapter.STATUS, attributes, null);
        generateExtensions(w, extProfile);
        if (this.content != null) {
            w.characters(this.content);
        }
        w.endElement(Namespaces.batchNs, DBAdapter.STATUS);
    }

    public ElementHandler getHandler(ExtensionProfile extProfile, String namespace, String localName, Attributes attrs) throws ParseException {
        return new BatchStatusElementHandler(extProfile, attrs, null);
    }
}
