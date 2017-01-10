package com.google.gdata.data.batch;

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

public class BatchInterrupted extends ExtensionPoint implements Extension, IBatchInterrupted {
    private String content;
    private ContentType contentType;
    private int errorCount;
    private String reason;
    private int successCount;
    private int totalCount;

    private class BatchInterruptedElementHandler extends ExtensionHandler {
        public BatchInterruptedElementHandler(ExtensionProfile extProfile, Attributes attrs) throws ParseException {
            super(BatchInterrupted.this, extProfile, BatchInterrupted.class);
            BatchInterrupted.this.totalCount = BatchInterrupted.getIntegerAttribute(attrs, "parsed", 0);
            BatchInterrupted.this.successCount = BatchInterrupted.getIntegerAttribute(attrs, "success", 0);
            BatchInterrupted.this.errorCount = BatchInterrupted.getIntegerAttribute(attrs, "error", 0);
            BatchInterrupted.this.reason = attrs.getValue("reason");
            String contentTypeString = attrs.getValue("content-type");
            if (contentTypeString != null) {
                try {
                    BatchInterrupted.this.contentType = new ContentType(contentTypeString);
                } catch (Throwable e) {
                    ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidContentType, e);
                    pe.setInternalReason("Invalid content type: '" + contentTypeString + "'");
                    throw pe;
                }
            }
        }

        public void processEndElement() {
            BatchInterrupted.this.content = this.value;
        }
    }

    public BatchInterrupted(String reason, int totalCount, int successCount, int errorCount) {
        this.reason = reason;
        this.totalCount = totalCount;
        this.successCount = successCount;
        this.errorCount = errorCount;
        if (totalCount < successCount - errorCount) {
            throw new IllegalArgumentException("total < success + error. total = " + totalCount + " success=" + successCount + " error=" + errorCount);
        }
    }

    public BatchInterrupted(Throwable cause, int totalCount, int successCount, int errorCount) {
        this(getReasonFromException(cause), totalCount, successCount, errorCount);
        if (cause instanceof ServiceException) {
            ServiceException se = (ServiceException) cause;
            this.content = se.getResponseBody();
            this.contentType = se.getResponseContentType();
        }
    }

    public static ExtensionDescription getDefaultDescription() {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(BatchInterrupted.class);
        desc.setNamespace(Namespaces.batchNs);
        desc.setLocalName("interrupted");
        desc.setRepeatable(false);
        return desc;
    }

    private static String getReasonFromException(Throwable cause) {
        String message = cause.getMessage();
        if (message == null) {
            return "Unexpected error";
        }
        return message;
    }

    public String getReason() {
        return this.reason;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getSuccessCount() {
        return this.successCount;
    }

    public int getErrorCount() {
        return this.errorCount;
    }

    public int getSkippedCount() {
        return this.totalCount - (this.successCount + this.errorCount);
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
        List<Attribute> attrs = new ArrayList(6);
        if (this.reason != null) {
            attrs.add(new Attribute("reason", this.reason));
        }
        attrs.add(new Attribute("parsed", Integer.toString(this.totalCount)));
        attrs.add(new Attribute("success", Integer.toString(this.successCount)));
        attrs.add(new Attribute("error", Integer.toString(this.errorCount)));
        attrs.add(new Attribute("unprocessed", Integer.toString(this.totalCount - (this.successCount + this.errorCount))));
        if (this.contentType != null) {
            this.contentType.getAttributes().remove(ContentType.ATTR_CHARSET);
            attrs.add(new Attribute("content-type", this.contentType.toString()));
        }
        generateStartElement(w, Namespaces.batchNs, "interrupted", attrs, null);
        generateExtensions(w, extProfile);
        if (this.content != null) {
            w.characters(this.content);
        }
        w.endElement(Namespaces.batchNs, "interrupted");
    }

    public ElementHandler getHandler(ExtensionProfile extProfile, String namespace, String localName, Attributes attrs) throws ParseException {
        return new BatchInterruptedElementHandler(extProfile, attrs);
    }

    private static int getIntegerAttribute(Attributes attrs, String name, int defValue) throws ParseException {
        String stringValue = attrs.getValue(name);
        if (stringValue != null) {
            try {
                defValue = Integer.parseInt(stringValue);
            } catch (Throwable e) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidIntegerAttribute, e);
                pe.setInternalReason("Invalid integer in value of attribute " + name + ": '" + stringValue + "'");
                throw pe;
            }
        }
        return defValue;
    }
}
